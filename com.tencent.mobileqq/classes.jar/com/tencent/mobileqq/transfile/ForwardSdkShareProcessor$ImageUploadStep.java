package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import atqa;
import ayeu;
import bhvw;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

class ForwardSdkShareProcessor$ImageUploadStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private int retryCount;
  
  ForwardSdkShareProcessor$ImageUploadStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "ImageUploadStep";
  }
  
  Pair<Integer, String> instanceUpload(String paramString, long paramLong)
  {
    String str = this.this$0.app.getCurrentUin();
    paramString = new CompressInfo(paramString, 0);
    paramString.f = 0;
    atqa.a("compress_local_image");
    atqa.a("compress_local_image", str, ayeu.b(paramString));
    if (!TextUtils.isEmpty(paramString.e)) {
      this.this$0.mLocalImgUrl = paramString.e;
    }
    paramString = new File(this.this$0.mLocalImgUrl);
    long l;
    Object localObject2;
    if (paramString.exists())
    {
      l = paramString.length();
      paramString = FileUtils.calcMd5(this.this$0.mLocalImgUrl);
      if ((l <= 0L) || (TextUtils.isEmpty(paramString))) {
        break label537;
      }
      paramString = String.format("https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { paramString, Long.valueOf(l) });
      atqa.a("query_image");
      paramString = HttpUtil.queryImageByIP(NetworkUtil.toDirectIpUrl(paramString, 1007), str, ForwardSdkShareProcessor.access$200(this.this$0));
      localObject2 = new HashMap();
      if (paramString != null) {
        break label434;
      }
      ((HashMap)localObject2).put("param_ret_code", "-1");
      ((HashMap)localObject2).put("param_need_upload", "0");
      atqa.a("query_image", str, (HashMap)localObject2, false);
    }
    for (;;)
    {
      paramLong = System.currentTimeMillis() - paramLong;
      if (paramString == null) {
        paramString = new Pair(Integer.valueOf(-1), "");
      }
      for (;;)
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|queryImage|ret=" + paramString.first + ",cost=" + paramLong + ",url=" + (String)paramString.second);
        Object localObject1 = new Bundle();
        ((Bundle)localObject1).putString("report_type", "102");
        ((Bundle)localObject1).putString("act_type", "16");
        ((Bundle)localObject1).putString("intext_1", "" + paramString.first);
        localObject2 = new StringBuilder().append("");
        if (((Integer)paramString.first).intValue() == -1) {}
        for (int i = 0;; i = ((Integer)paramString.first).intValue())
        {
          ((Bundle)localObject1).putString("intext_2", i);
          ((Bundle)localObject1).putString("intext_5", "" + paramLong);
          bhvw.a().a((Bundle)localObject1, "", str, false);
          return paramString;
          l = 0L;
          break;
          label434:
          ((HashMap)localObject2).put("param_ret_code", String.valueOf(paramString.first));
          if (TextUtils.isEmpty((CharSequence)paramString.second))
          {
            localObject1 = "0";
            label466:
            ((HashMap)localObject2).put("param_need_upload", localObject1);
            if (TextUtils.isEmpty((CharSequence)paramString.second)) {
              break label513;
            }
          }
          label513:
          for (boolean bool = true;; bool = false)
          {
            atqa.a("query_image", str, (HashMap)localObject2, bool);
            break;
            localObject1 = "1";
            break label466;
          }
        }
      }
      label537:
      paramString = null;
    }
  }
  
  protected boolean isFinished()
  {
    return ForwardSdkShareProcessor.access$1000(this.this$0).get();
  }
  
  protected void process()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|process|ready=" + ForwardSdkShareProcessor.access$1000(this.this$0) + ",remoteUrl=" + this.this$0.mRemoteImgUrl + " ,localUrl=" + this.this$0.mLocalImgUrl);
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (ForwardSdkShareProcessor.access$1000(this.this$0).get())
    {
      doNextStep();
      return;
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.ImageUploadStep.1(this), 128, null, true);
  }
  
  Pair<Integer, Boolean> uploadImage(long paramLong)
  {
    String str = this.this$0.app.getCurrentUin();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("Connection", "keep-alive");
    localHashMap2.put("Referer", "http://www.qq.com");
    localHashMap2.put("Host", "cgi.connect.qq.com");
    Object localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(str, "cgi.connect.qq.com");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localHashMap2.put("Cookie", "p_uin=" + str + ";p_skey=" + (String)localObject1);
    }
    HashMap localHashMap3 = new HashMap();
    localHashMap3.put("share_image", this.this$0.mLocalImgUrl);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "51");
    ((Bundle)localObject1).putString("intext_3", "0");
    ((Bundle)localObject1).putString("stringext_1", this.this$0.mTargetUrl);
    bhvw.a().a((Bundle)localObject1, "", str, false);
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("param_is_ip_direct", "1");
    atqa.a("upload_local_thumb_image");
    Object localObject2 = HttpUtil.uploadImageWithHttps(NetworkUtil.toDirectIpUrl("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str, ForwardSdkShareProcessor.access$200(this.this$0), null, localHashMap3, localHashMap2, false);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      atqa.a("upload_local_thumb_image", str, localHashMap1, false);
      atqa.a("upload_local_thumb_image");
      localObject1 = HttpUtil.uploadImageWithHttps("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str, ForwardSdkShareProcessor.access$200(this.this$0), null, localHashMap3, localHashMap2, true);
      localHashMap1.put("param_is_ip_direct", "0");
    }
    int k = 0;
    i = 0;
    bool2 = false;
    bool1 = bool2;
    if (localObject1 != null) {
      j = k;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      j = k;
      k = ((JSONObject)localObject1).getInt("retcode");
      bool1 = bool2;
      i = k;
      if (k == 0)
      {
        bool1 = bool2;
        i = k;
        j = k;
        if (((JSONObject)localObject1).has("result"))
        {
          j = k;
          localObject1 = ((JSONObject)localObject1).getJSONObject("result");
          j = k;
          this.this$0.mRemoteImgUrl = ((JSONObject)localObject1).getString("url");
          j = k;
          ForwardSdkShareProcessor.access$900(this.this$0).set(true);
          bool1 = true;
          i = k;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bool1 = bool2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException.getMessage());
          bool1 = bool2;
          i = j;
          continue;
          QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException);
          continue;
          j = 1;
        }
      }
    }
    localHashMap1.put("param_ret_code", Integer.toString(i));
    atqa.a("upload_local_thumb_image", str, bool1);
    paramLong = System.currentTimeMillis() - paramLong;
    if (QLog.isColorLevel())
    {
      localObject1 = "ImageUploadStep|uploadImage|suc=" + bool1 + ",cost=" + paramLong + ",localImgUrl=" + this.this$0.mLocalImgUrl + ",targetUrl=" + this.this$0.mTargetUrl;
      if ((!bool1) || (paramLong > 5000L)) {
        QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject1);
      }
    }
    else
    {
      if (!bool1) {
        QLog.e("Q.share.ForwardSdkShareProcessor", 1, "ImageUploadStep|uploadImage|ret=" + i + ",retry=" + this.retryCount);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "11");
      localObject2 = new StringBuilder().append("");
      if (!bool1) {
        break label891;
      }
      j = 0;
      ((Bundle)localObject1).putString("intext_1", j);
      ((Bundle)localObject1).putString("intext_2", "" + i);
      ((Bundle)localObject1).putString("intext_3", "0");
      ((Bundle)localObject1).putString("intext_5", "" + paramLong);
      if (!bool1)
      {
        ((Bundle)localObject1).putString("stringext_2", this.this$0.mLocalImgUrl);
        ((Bundle)localObject1).putString("stringext_1", this.this$0.mTargetUrl);
      }
      bhvw.a().a((Bundle)localObject1, "", str, false);
      return new Pair(Integer.valueOf(i), Boolean.valueOf(bool1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep
 * JD-Core Version:    0.7.0.1
 */