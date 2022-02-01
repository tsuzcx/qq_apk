package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.UrlToUUIDCallback;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;
import tencent.im.oidb.ac.ArticleCenter.GetUrlByVidRequest;
import tencent.im.oidb.ac.ArticleCenter.GetUrlByVidResponse;
import tencent.im.oidb.ac.ArticleCenter.GetVidByUrlRequest;
import tencent.im.oidb.ac.ArticleCenter.RetInfo;

public class ThirdVideoManager
{
  private static MQLruCache<String, VideoUrlInfo> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(300);
  private static volatile ThirdVideoManager jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager;
  public Long a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean = true;
  
  private ThirdVideoManager()
  {
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public static ThirdVideoManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager == null) {
          jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager = new ThirdVideoManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager;
  }
  
  public static VideoUrlInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (VideoUrlInfo)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString)) && (paramString.a(NetConnInfoCenter.getServerTime()))) {
      return paramString;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (!TextUtils.isEmpty(paramVideoUrlInfo.jdField_b_of_type_JavaLangString))
    {
      if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cache putCache vid : ");
        localStringBuilder.append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(" url:");
        localStringBuilder.append(paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, localStringBuilder.toString());
      }
      paramVideoUrlInfo.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
      jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo);
    }
  }
  
  private void a(String paramString1, String paramString2, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    VideoUrlInfo localVideoUrlInfo = new VideoUrlInfo(paramString1);
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if ((paramBundle == null) || (paramBundle.length < 0)) {}
    }
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
          String str = RIJPBFieldUtils.b(((ArticleCenter.GetUrlByVidResponse)localObject).json_video_detail);
          if (localVideoUrlInfo.jdField_a_of_type_Boolean)
          {
            HashMap localHashMap = new HashMap();
            if (!bool1) {
              break label741;
            }
            localObject = "1";
            localHashMap.put("param_isH265SwitchError", localObject);
            localHashMap.put("param_jsonVideoDetail", str);
            VideoGetUrlReporter.a(BaseApplication.getContext(), RIJQQAppInterfaceUtil.a(), localHashMap);
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009756", "0X8009756", 0, 0, VideoDeviceInfoHelper.a(), "8.7.0", localVideoUrlInfo.jdField_d_of_type_JavaLangString, str, false);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("vid", localVideoUrlInfo.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject).put("isH265", localVideoUrlInfo.jdField_a_of_type_Boolean);
          ((JSONObject)localObject).put("url", localVideoUrlInfo.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject).put("hwBackupUrl", localVideoUrlInfo.e);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009822", "0X8009822", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
          break label356;
        }
        localVideoUrlInfo.c = i;
      }
      catch (Exception paramBundle)
      {
        paramBundle = paramBundle.getMessage();
        i = -2;
        continue;
      }
      boolean bool1 = false;
      break label360;
      paramBundle = "";
      int i = 0;
      continue;
      i = paramBundle.getInt("respones_code", -3);
      paramBundle = "";
      label356:
      bool1 = paramBoolean;
      label360:
      boolean bool2 = TextUtils.isEmpty(localVideoUrlInfo.jdField_a_of_type_JavaLangString) ^ true;
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
        if (localVideoUrlInfo.jdField_d_of_type_Int == 0) {
          a(localVideoUrlInfo);
        }
        paramUUIDToUrlCallback.a(localVideoUrlInfo);
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramString1);
      }
      else
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString1)) {
          break label606;
        }
      }
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramString1);
        label559:
        paramUUIDToUrlCallback.a(localVideoUrlInfo);
        paramString2 = new StringBuilder();
        paramString2.append("handleGetUrlByVidResponse() 重试依然失败！ vidInfo : ");
        paramString2.append(localVideoUrlInfo);
        QLog.e("Q.readinjoy.video.ThirdVideoManager", 1, paramString2.toString());
        paramBoolean = false;
        break label668;
        label606:
        paramBoolean = true;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleGetUrlByVidResponse() 获取失败, 进行重试 sendUUIDToUrlTryAgain vidInfo : ");
          ((StringBuilder)localObject).append(localVideoUrlInfo);
          QLog.w("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
        }
        a(paramString1, paramString2, paramUUIDToUrlCallback);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
        label668:
        paramString2 = new VideoGetUrlReportData();
        paramString2.jdField_a_of_type_Boolean = bool2;
        paramString2.jdField_a_of_type_JavaLangString = paramString1;
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
        paramString2.jdField_a_of_type_Long = paramLong;
        paramString2.jdField_b_of_type_Long = i;
        paramString2.jdField_b_of_type_JavaLangString = paramBundle;
        paramString2.jdField_b_of_type_Boolean = paramBoolean;
        VideoGetUrlReporter.a(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.a(), bool1, paramString2.a());
        return;
      }
      catch (Exception paramString2)
      {
        break label559;
      }
      label741:
      Object localObject = "0";
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isDomainInLocalDnsBlackList(), result = ");
      paramString.append(bool);
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, paramString.toString());
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((RIJQQAppInterfaceUtil.a() != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
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
  
  public void a(String paramString, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback)
  {
    a(paramString, "PubAccountArticleCenter.GetUrlByVid", paramUUIDToUrlCallback);
  }
  
  public void a(String paramString, UrlToUUIDCallback paramUrlToUUIDCallback)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
    if ((localAppRuntime != null) && (localAppRuntime.getApplication() != null))
    {
      long l = System.currentTimeMillis();
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
      localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetVidByUrl");
      ArticleCenter.GetVidByUrlRequest localGetVidByUrlRequest = new ArticleCenter.GetVidByUrlRequest();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
      localGetVidByUrlRequest.url.set(localByteStringMicro);
      localGetVidByUrlRequest.mv.set(ByteStringMicro.copyFromUtf8("8.7.0,3,5295"));
      localNewIntent.putExtra("data", localGetVidByUrlRequest.toByteArray());
      localNewIntent.setObserver(new ThirdVideoManager.2(this, l, localNewIntent, paramUrlToUUIDCallback, paramString));
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
      paramString2.jdField_a_of_type_Boolean = false;
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.jdField_a_of_type_Long = 0L;
      paramString2.jdField_b_of_type_Long = -4L;
      paramString2.jdField_b_of_type_JavaLangString = "vid or cmd is null";
      paramString2.jdField_b_of_type_Boolean = false;
      VideoGetUrlReporter.a(BaseApplicationImpl.getContext(), RIJQQAppInterfaceUtil.a(), true, paramString2.a());
      return;
    }
    Object localObject1 = a(paramString1);
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("cache hit,  getUrlByVid vid : ");
        paramString2.append(paramString1);
        paramString2.append(" url:");
        paramString2.append(((VideoUrlInfo)localObject1).jdField_a_of_type_JavaLangString);
        paramString2.append(", ");
        paramString2.append(((VideoUrlInfo)localObject1).toString());
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, paramString2.toString());
      }
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
      paramUUIDToUrlCallback.a((VideoUrlInfo)localObject1);
      return;
    }
    long l = System.currentTimeMillis();
    localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    ((NewIntent)localObject1).putExtra("cmd", paramString2);
    ArticleCenter.GetUrlByVidRequest localGetUrlByVidRequest = new ArticleCenter.GetUrlByVidRequest();
    Object localObject2 = ByteStringMicro.copyFromUtf8(paramString1);
    localGetUrlByVidRequest.vid.set((ByteStringMicro)localObject2);
    localGetUrlByVidRequest.mv.set(ByteStringMicro.copyFromUtf8("8.7.0,3,5295"));
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
    RIJQQAppInterfaceUtil.a().startServlet((NewIntent)localObject1);
  }
  
  public void a(boolean paramBoolean, Set<String> paramSet)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public String[] a(String paramString)
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
        if ((!TextUtils.isEmpty(str1)) && (this.jdField_a_of_type_Boolean) && (!a(str1)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager
 * JD-Core Version:    0.7.0.1
 */