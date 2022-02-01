package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.UrlToUUIDCallback;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.ac.ArticleCenter.GetUrlByVidRequest;
import tencent.im.oidb.ac.ArticleCenter.GetUrlByVidResponse;
import tencent.im.oidb.ac.ArticleCenter.GetVidByUrlRequest;
import tencent.im.oidb.ac.ArticleCenter.RetInfo;

public class ThirdVideoManager
{
  private static volatile ThirdVideoManager e;
  private static MQLruCache<String, VideoUrlInfo> f = new MQLruCache(300);
  public Long a = Long.valueOf(0L);
  private Set<String> b;
  private boolean c = true;
  private ArrayList<String> d = new ArrayList();
  
  public static ThirdVideoManager a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new ThirdVideoManager();
        }
      }
      finally {}
    }
    return e;
  }
  
  public static String a(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return "";
  }
  
  public static void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (!TextUtils.isEmpty(paramVideoUrlInfo.b))
    {
      if (TextUtils.isEmpty(paramVideoUrlInfo.a)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cache putCache vid : ");
        localStringBuilder.append(paramVideoUrlInfo.b);
        localStringBuilder.append(" url:");
        localStringBuilder.append(paramVideoUrlInfo.a);
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, localStringBuilder.toString());
      }
      paramVideoUrlInfo.l = NetConnInfoCenter.getServerTime();
      f.put(paramVideoUrlInfo.b, paramVideoUrlInfo);
    }
  }
  
  private void a(VideoUrlInfo paramVideoUrlInfo, ArticleCenter.GetUrlByVidResponse paramGetUrlByVidResponse, boolean paramBoolean)
  {
    String str = RIJPBFieldUtils.d(paramGetUrlByVidResponse.json_video_detail);
    if (paramVideoUrlInfo.c)
    {
      HashMap localHashMap = new HashMap();
      if (paramBoolean) {
        paramGetUrlByVidResponse = "1";
      } else {
        paramGetUrlByVidResponse = "0";
      }
      localHashMap.put("param_isH265SwitchError", paramGetUrlByVidResponse);
      localHashMap.put("param_jsonVideoDetail", str);
      VideoGetUrlReporter.a(BaseApplication.getContext(), RIJQQAppInterfaceUtil.d(), localHashMap);
    }
    PublicAccountReportUtils.a(null, null, "0X8009756", "0X8009756", 0, 0, VideoDeviceInfoHelper.a(), "8.8.17", paramVideoUrlInfo.g, str, false);
    paramGetUrlByVidResponse = new JSONObject();
    try
    {
      paramGetUrlByVidResponse.put("vid", paramVideoUrlInfo.b);
      paramGetUrlByVidResponse.put("isH265", paramVideoUrlInfo.c);
      paramGetUrlByVidResponse.put("url", paramVideoUrlInfo.a);
      paramGetUrlByVidResponse.put("hwBackupUrl", paramVideoUrlInfo.h);
    }
    catch (JSONException paramVideoUrlInfo)
    {
      paramVideoUrlInfo.printStackTrace();
    }
    PublicAccountReportUtils.a(null, null, "0X8009822", "0X8009822", 0, 0, "", "", "", paramGetUrlByVidResponse.toString(), false);
  }
  
  private void a(String paramString1, String paramString2, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    VideoUrlInfo localVideoUrlInfo = new VideoUrlInfo(paramString1);
    Object localObject;
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle != null) && (paramBundle.length >= 0)) {}
      for (;;)
      {
        try
        {
          localObject = new ArticleCenter.GetUrlByVidResponse();
          ((ArticleCenter.GetUrlByVidResponse)localObject).mergeFrom(paramBundle);
          i = ((ArticleCenter.GetUrlByVidResponse)localObject).ret_info.ret_code.get();
          paramBundle = ((ArticleCenter.GetUrlByVidResponse)localObject).ret_info.err_info.get();
          if (i == 0)
          {
            bool1 = VideoUrlInfo.a((ArticleCenter.GetUrlByVidResponse)localObject, localVideoUrlInfo);
            if (ViolaUtils.isBindDataOpmOpen())
            {
              ThreadManager.excute(new ThirdVideoManager.2(this, localVideoUrlInfo, (ArticleCenter.GetUrlByVidResponse)localObject, bool1), 16, null, true);
              break;
            }
            a(localVideoUrlInfo, (ArticleCenter.GetUrlByVidResponse)localObject, bool1);
            break;
          }
          localVideoUrlInfo.k = i;
        }
        catch (Exception paramBundle)
        {
          paramBundle = paramBundle.getMessage();
          i = -2;
          continue;
        }
        bool1 = false;
        break label202;
        paramBundle = "";
        i = 0;
      }
    }
    int i = paramBundle.getInt("respones_code", -3);
    paramBundle = "";
    boolean bool1 = paramBoolean;
    label202:
    boolean bool2 = TextUtils.isEmpty(localVideoUrlInfo.a) ^ true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetUrlByVidResponse(), vid:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" cmd:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" ssoTime : ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", isValid:");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", videoUrlInfo=");
      ((StringBuilder)localObject).append(localVideoUrlInfo);
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
    }
    if (bool2)
    {
      if (localVideoUrlInfo.m == 0) {
        a(localVideoUrlInfo);
      }
      paramUUIDToUrlCallback.a(localVideoUrlInfo);
      this.d.remove(paramString1);
    }
    else
    {
      if (!this.d.contains(paramString1)) {
        break label448;
      }
    }
    try
    {
      this.d.remove(paramString1);
      label401:
      paramUUIDToUrlCallback.a(localVideoUrlInfo);
      paramString2 = new StringBuilder();
      paramString2.append("handleGetUrlByVidResponse() 重试依然失败！ vidInfo : ");
      paramString2.append(localVideoUrlInfo);
      QLog.e("Q.readinjoy.video.ThirdVideoManager", 1, paramString2.toString());
      paramBoolean = false;
      break label510;
      label448:
      paramBoolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetUrlByVidResponse() 获取失败, 进行重试 sendUUIDToUrlTryAgain vidInfo : ");
        ((StringBuilder)localObject).append(localVideoUrlInfo);
        QLog.w("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
      }
      a(paramString1, paramString2, paramUUIDToUrlCallback);
      this.d.add(paramString1);
      label510:
      paramString2 = new VideoGetUrlReportData();
      paramString2.a = bool2;
      paramString2.b = paramString1;
      this.a = Long.valueOf(paramLong);
      paramString2.c = paramLong;
      paramString2.d = i;
      paramString2.e = paramBundle;
      paramString2.f = paramBoolean;
      VideoGetUrlReporter.a(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.d(), bool1, paramString2.a());
      return;
    }
    catch (Exception paramString2)
    {
      break label401;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((RIJQQAppInterfaceUtil.e() != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendUUIDToUrlRequest checkArgs failed,   vid : ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" cmd:");
      localStringBuilder.append(paramString2);
      QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static VideoUrlInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (VideoUrlInfo)f.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.a)) && (paramString.a(NetConnInfoCenter.getServerTime()))) {
      return paramString;
    }
    return null;
  }
  
  private boolean d(String paramString)
  {
    boolean bool = this.b.contains(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isDomainInLocalDnsBlackList(), result = ");
      paramString.append(bool);
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, paramString.toString());
    }
    return bool;
  }
  
  public void a(String paramString, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback)
  {
    a(paramString, "PubAccountArticleCenter.GetUrlByVid", paramUUIDToUrlCallback);
  }
  
  public void a(String paramString, UrlToUUIDCallback paramUrlToUUIDCallback)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if ((localAppRuntime != null) && (localAppRuntime.getApplication() != null))
    {
      long l = System.currentTimeMillis();
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetVidByUrl");
      ArticleCenter.GetVidByUrlRequest localGetVidByUrlRequest = new ArticleCenter.GetVidByUrlRequest();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
      localGetVidByUrlRequest.url.set(localByteStringMicro);
      localGetVidByUrlRequest.mv.set(ByteStringMicro.copyFromUtf8("8.8.17,3,5770"));
      localNewIntent.putExtra("data", localGetVidByUrlRequest.toByteArray());
      localNewIntent.setObserver(new ThirdVideoManager.3(this, l, localNewIntent, paramUrlToUUIDCallback, paramString));
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    if (paramUrlToUUIDCallback != null) {
      paramUrlToUUIDCallback.a(paramString, "");
    }
  }
  
  public void a(String paramString1, String paramString2, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback)
  {
    if (paramUUIDToUrlCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, "sendUUIDToUrlRequestL callback == null! ");
      }
      return;
    }
    if (!a(paramString1, paramString2))
    {
      paramUUIDToUrlCallback.a(new VideoUrlInfo(paramString1));
      paramString2 = new VideoGetUrlReportData();
      paramString2.a = false;
      paramString2.b = paramString1;
      paramString2.c = 0L;
      paramString2.d = -4L;
      paramString2.e = "vid or cmd is null";
      paramString2.f = false;
      VideoGetUrlReporter.a(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.d(), true, paramString2.a());
      return;
    }
    Object localObject1 = b(paramString1);
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("cache hit,  getUrlByVid vid : ");
        paramString2.append(paramString1);
        paramString2.append(" url:");
        paramString2.append(((VideoUrlInfo)localObject1).a);
        paramString2.append(", ");
        paramString2.append(((VideoUrlInfo)localObject1).toString());
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, paramString2.toString());
      }
      this.a = Long.valueOf(0L);
      paramUUIDToUrlCallback.a((VideoUrlInfo)localObject1);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    ((NewIntent)localObject1).putExtra("cmd", paramString2);
    ArticleCenter.GetUrlByVidRequest localGetUrlByVidRequest = new ArticleCenter.GetUrlByVidRequest();
    Object localObject2 = ByteStringMicro.copyFromUtf8(paramString1);
    localGetUrlByVidRequest.vid.set((ByteStringMicro)localObject2);
    localGetUrlByVidRequest.mv.set(ByteStringMicro.copyFromUtf8("8.8.17,3,5770"));
    int i = NetUtil.a(null);
    localGetUrlByVidRequest.net_type.set(i);
    localGetUrlByVidRequest.video_type.set(0);
    localObject2 = VideoDeviceInfoHelper.a();
    localGetUrlByVidRequest.mobile_detail_info.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendUUIDToUrlRequest netType : ");
      localStringBuilder.append(i);
      localStringBuilder.append(", vid : ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", reqDeviceInfo : ");
      localStringBuilder.append((String)localObject2);
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, localStringBuilder.toString());
    }
    ((NewIntent)localObject1).putExtra("data", localGetUrlByVidRequest.toByteArray());
    ((NewIntent)localObject1).setObserver(new ThirdVideoManager.1(this, (NewIntent)localObject1, paramString1, paramString2, paramUUIDToUrlCallback, l));
    RIJQQAppInterfaceUtil.e().startServlet((NewIntent)localObject1);
  }
  
  public void a(boolean paramBoolean, Set<String> paramSet)
  {
    this.c = paramBoolean;
    this.b = paramSet;
  }
  
  public String[] c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      String[] arrayOfString;
      int j;
      try
      {
        Object localObject1 = new URL(paramString);
        String str1 = ((URL)localObject1).getHost();
        String str2 = ((URL)localObject1).getProtocol();
        localObject2 = ((URL)localObject1).getFile();
        if ((!TextUtils.isEmpty(str1)) && (this.c) && (!d(str1)))
        {
          ArrayList localArrayList = InnerDns.getInstance().reqDnsForIpList(str1, 1006);
          if (localArrayList == null) {
            break label358;
          }
          i = localArrayList.size();
          if (i > 0)
          {
            arrayOfString = new String[i + 1];
            j = 0;
            if (j < i)
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = localObject2;
                if (((String)localObject2).indexOf('/') != 0)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("/");
                  ((StringBuilder)localObject1).append((String)localObject2);
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(str2);
              ((StringBuilder)localObject2).append("://");
              ((StringBuilder)localObject2).append((String)localArrayList.get(j));
              ((StringBuilder)localObject2).append((String)localObject1);
              localObject2 = ((StringBuilder)localObject2).toString();
              if (!((String)localObject2).contains("&"))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append("?txhost=");
                localStringBuilder.append(str1);
                localObject2 = localStringBuilder.toString();
                break label363;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append("&txhost=");
              localStringBuilder.append(str1);
              localObject2 = localStringBuilder.toString();
              break label363;
            }
            arrayOfString[i] = paramString;
            return arrayOfString;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.video.ThirdVideoManager", 2, "replaceDomain2Ip Exception:", localException);
        }
      }
      return new String[] { paramString };
      label358:
      int i = 0;
      continue;
      label363:
      arrayOfString[j] = localObject2;
      j += 1;
      Object localObject2 = localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager
 * JD-Core Version:    0.7.0.1
 */