package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.agent.report.ReportCenter;
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
  private int retryCount = 0;
  
  ForwardSdkShareProcessor$ImageUploadStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "ImageUploadStep";
  }
  
  Pair<Integer, String> instanceUpload(String paramString, long paramLong)
  {
    String str = this.this$0.app.getCurrentUin();
    int i = 0;
    paramString = new CompressInfo(paramString, 0);
    paramString.o = 0;
    ForwardStatisticsReporter.a("compress_local_image");
    ForwardStatisticsReporter.a("compress_local_image", str, ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail(paramString));
    if (!TextUtils.isEmpty(paramString.l)) {
      this.this$0.mLocalImgUrl = paramString.l;
    }
    Object localObject1 = null;
    paramString = new File(this.this$0.mLocalImgUrl);
    long l;
    if (paramString.exists()) {
      l = paramString.length();
    } else {
      l = 0L;
    }
    Object localObject2 = FileUtils.calcMd5(this.this$0.mLocalImgUrl);
    paramString = (String)localObject1;
    if (l > 0L)
    {
      paramString = (String)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString = String.format("https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { localObject2, Long.valueOf(l) });
        ForwardStatisticsReporter.a("query_image");
        localObject1 = HttpUtil.queryImageByIP(NetworkUtil.a(paramString, 1007), str, ForwardSdkShareProcessor.access$200(this.this$0));
        localObject2 = new HashMap();
        paramString = "0";
        if (localObject1 == null)
        {
          ((HashMap)localObject2).put("param_ret_code", "-1");
          ((HashMap)localObject2).put("param_need_upload", "0");
          ForwardStatisticsReporter.a("query_image", str, (HashMap)localObject2, false);
          paramString = (String)localObject1;
        }
        else
        {
          ((HashMap)localObject2).put("param_ret_code", String.valueOf(((Pair)localObject1).first));
          if (!TextUtils.isEmpty((CharSequence)((Pair)localObject1).second)) {
            paramString = "1";
          }
          ((HashMap)localObject2).put("param_need_upload", paramString);
          ForwardStatisticsReporter.a("query_image", str, (HashMap)localObject2, TextUtils.isEmpty((CharSequence)((Pair)localObject1).second) ^ true);
          paramString = (String)localObject1;
        }
      }
    }
    paramLong = System.currentTimeMillis() - paramLong;
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = new Pair(Integer.valueOf(-1), "");
    }
    paramString = new StringBuilder();
    paramString.append("ImageUploadStep|queryImage|ret=");
    paramString.append(((Pair)localObject1).first);
    paramString.append(",cost=");
    paramString.append(paramLong);
    paramString.append(",url=");
    paramString.append((String)((Pair)localObject1).second);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, paramString.toString());
    paramString = new Bundle();
    paramString.putString("report_type", "102");
    paramString.putString("act_type", "16");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(((Pair)localObject1).first);
    paramString.putString("intext_1", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    if (((Integer)((Pair)localObject1).first).intValue() != -1) {
      i = ((Integer)((Pair)localObject1).first).intValue();
    }
    ((StringBuilder)localObject2).append(i);
    paramString.putString("intext_2", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong);
    paramString.putString("intext_5", ((StringBuilder)localObject2).toString());
    ReportCenter.a().a(paramString, "", str, false, this.this$0.isSdkShare());
    return localObject1;
  }
  
  protected boolean isFinished()
  {
    return ForwardSdkShareProcessor.access$1000(this.this$0).get();
  }
  
  protected void process()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageUploadStep|process|ready=");
    localStringBuilder.append(ForwardSdkShareProcessor.access$1000(this.this$0));
    localStringBuilder.append(",remoteUrl=");
    localStringBuilder.append(this.this$0.mRemoteImgUrl);
    localStringBuilder.append(" ,localUrl=");
    localStringBuilder.append(this.this$0.mLocalImgUrl);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
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
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("Connection", "keep-alive");
    localHashMap1.put("Referer", "http://www.qq.com");
    localHashMap1.put("Host", "cgi.connect.qq.com");
    Object localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(str, "cgi.connect.qq.com");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("p_uin=");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(";p_skey=");
      ((StringBuilder)localObject3).append((String)localObject1);
      localHashMap1.put("Cookie", ((StringBuilder)localObject3).toString());
    }
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("share_image", this.this$0.mLocalImgUrl);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "51");
    ((Bundle)localObject1).putString("intext_3", "0");
    ((Bundle)localObject1).putString("stringext_1", this.this$0.mTargetUrl);
    ReportCenter.a().a((Bundle)localObject1, "", str, false, this.this$0.isSdkShare());
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put("param_is_ip_direct", "1");
    ForwardStatisticsReporter.a("upload_local_thumb_image");
    localObject1 = HttpUtil.uploadImageWithHttps(NetworkUtil.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", str, ForwardSdkShareProcessor.access$200(this.this$0), null, localHashMap2, localHashMap1, false);
    if (localObject1 == null)
    {
      ForwardStatisticsReporter.a("upload_local_thumb_image", str, (HashMap)localObject3, false);
      ForwardStatisticsReporter.a("upload_local_thumb_image");
      localObject1 = HttpUtil.uploadImageWithHttps("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", str, ForwardSdkShareProcessor.access$200(this.this$0), null, localHashMap2, localHashMap1, true);
      ((HashMap)localObject3).put("param_is_ip_direct", "0");
    }
    boolean bool2 = false;
    int i;
    boolean bool1;
    if (localObject1 != null)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        j = ((JSONObject)localObject1).getInt("retcode");
        i = j;
        bool1 = bool2;
        if (j != 0) {
          break label529;
        }
        i = j;
        bool1 = bool2;
        try
        {
          if (!((JSONObject)localObject1).has("result")) {
            break label529;
          }
          localObject1 = ((JSONObject)localObject1).getJSONObject("result");
          this.this$0.mRemoteImgUrl = ((JSONObject)localObject1).getString("url");
          ForwardSdkShareProcessor.access$900(this.this$0).set(true);
          bool1 = true;
          i = j;
        }
        catch (JSONException localJSONException1) {}
        i = j;
      }
      catch (JSONException localJSONException2)
      {
        j = 0;
      }
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, localJSONException2.getMessage());
        i = j;
        bool1 = bool2;
      }
    }
    else
    {
      i = 0;
      bool1 = bool2;
    }
    label529:
    ((HashMap)localObject3).put("param_ret_code", Integer.toString(i));
    ForwardStatisticsReporter.a("upload_local_thumb_image", str, bool1);
    paramLong = System.currentTimeMillis() - paramLong;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ImageUploadStep|uploadImage|suc=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(",cost=");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(",localImgUrl=");
      ((StringBuilder)localObject2).append(this.this$0.mLocalImgUrl);
      ((StringBuilder)localObject2).append(",targetUrl=");
      ((StringBuilder)localObject2).append(this.this$0.mTargetUrl);
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((bool1) && (paramLong <= 5000L)) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, (String)localObject2);
      } else {
        QLog.e("Q.share.ForwardSdkShareProcessor", 2, (String)localObject2);
      }
    }
    if (!bool1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ImageUploadStep|uploadImage|ret=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",retry=");
      ((StringBuilder)localObject2).append(this.retryCount);
      QLog.e("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("report_type", "102");
    ((Bundle)localObject2).putString("act_type", "11");
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(bool1 ^ true);
    ((Bundle)localObject2).putString("intext_1", ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i);
    ((Bundle)localObject2).putString("intext_2", ((StringBuilder)localObject3).toString());
    ((Bundle)localObject2).putString("intext_3", "0");
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(paramLong);
    ((Bundle)localObject2).putString("intext_5", ((StringBuilder)localObject3).toString());
    if (!bool1)
    {
      ((Bundle)localObject2).putString("stringext_2", this.this$0.mLocalImgUrl);
      ((Bundle)localObject2).putString("stringext_1", this.this$0.mTargetUrl);
    }
    ReportCenter.a().a((Bundle)localObject2, "", str, false, this.this$0.isSdkShare());
    return new Pair(Integer.valueOf(i), Boolean.valueOf(bool1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.ImageUploadStep
 * JD-Core Version:    0.7.0.1
 */