package com.tencent.mobileqq.kandian.glue.video;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload.CallbackListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.util.HashMap;

public class VideoWebPreDownload
  implements OnVideoPluginInstallListener, IVideoWebPreDownload
{
  private static VideoWebPreDownload jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload;
  private static final String jdField_a_of_type_JavaLangString = "VideoWebPreDownload";
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = null;
  private IVideoWebPreDownload.CallbackListener jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoWebPreDownload$CallbackListener = null;
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public VideoWebPreDownload()
  {
    c();
  }
  
  private void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    if (paramInt1 == 2)
    {
      ThirdVideoManager.a().a(paramString1, new VideoWebPreDownload.3(this, paramString1, paramInt2, paramLong));
      return;
    }
    if (!a(paramString2, paramString1, paramInt2))
    {
      a(paramString2, paramString1, paramLong, paramInt2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoWebPreDownload$CallbackListener != null)
    {
      paramString2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoWebPreDownload$CallbackListener.a(paramString1, 1, paramString2);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "innerDoPreDownload() start preload ERROR cacheMgr == null!");
      }
      return;
    }
    Object localObject = paramString2;
    if (paramString1 != null) {
      if (paramString2 != null)
      {
        localObject = paramString2;
        if (!paramString1.equals(paramString2)) {}
      }
      else
      {
        localObject = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString1);
      }
    }
    paramString2 = new TVK_UserInfo("", "");
    localObject = new TVK_PlayerVideoInfo(2, (String)localObject, "");
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_duration", String.valueOf(paramInt));
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("cache_servers_type", "20160519");
    if (paramLong > 0L) {
      ((TVK_PlayerVideoInfo)localObject).setConfigMap("duration", String.valueOf(paramLong));
    }
    ((TVK_PlayerVideoInfo)localObject).addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String str = VideoPlayUtils.a();
    if (TextUtils.isEmpty(paramString1))
    {
      localTVK_ICacheMgr.preLoadVideoById(this.jdField_a_of_type_AndroidContentContext, paramString2, (TVK_PlayerVideoInfo)localObject, str);
      return;
    }
    localTVK_ICacheMgr.preLoadVideoByUrl(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, (TVK_PlayerVideoInfo)localObject);
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt)
  {
    TVK_ICacheMgr localTVK_ICacheMgr = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
    if (localTVK_ICacheMgr == null) {
      return false;
    }
    if ((paramString1 != null) && ((paramString2 == null) || (paramString1.equals(paramString2)))) {
      paramString2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString1);
    }
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, paramString2, "");
    localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(paramInt));
    localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
    localTVK_PlayerVideoInfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int i = arrayOfString.length;
    int j = 0;
    paramInt = 0;
    label263:
    StringBuilder localStringBuilder1;
    while (j < i)
    {
      String str1 = arrayOfString[j];
      try
      {
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        try
        {
          int k = localTVK_ICacheMgr.isVideoCached(localContext, paramString1, localTVK_UserInfo, localTVK_PlayerVideoInfo, str1);
          paramInt = k;
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          break label263;
        }
      }
      catch (Exception localException2) {}
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString2);
      localStringBuilder2.append(" checkIsVideoCached() cacheMgr.isVideoCached Exception = ");
      localStringBuilder2.append(localException2.getMessage());
      QLog.d(str2, 2, localStringBuilder2.toString());
      if ((paramInt != 2) && (paramInt != 1))
      {
        j += 1;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramString1 = jdField_a_of_type_JavaLangString;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(paramString2);
          localStringBuilder1.append(" checkIsVideoCached(), definition = ");
          localStringBuilder1.append(str1);
          localStringBuilder1.append(", cacheStatus = ");
          localStringBuilder1.append(paramInt);
          localStringBuilder1.append(", return TRUE");
          QLog.d(paramString1, 2, localStringBuilder1.toString());
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = jdField_a_of_type_JavaLangString;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString2);
      localStringBuilder1.append(" checkIsVideoCached() return FALSE");
      QLog.d(paramString1, 2, localStringBuilder1.toString());
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
      return;
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    TVK_IProxyFactory localTVK_IProxyFactory = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
    if (localTVK_IProxyFactory != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = localTVK_IProxyFactory.getCacheMgr(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(new VideoWebPreDownload.4(this));
  }
  
  public void a()
  {
    ThreadManager.post(new VideoWebPreDownload.2(this), 5, null, true);
  }
  
  public void a(IVideoWebPreDownload.CallbackListener paramCallbackListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoWebPreDownload$CallbackListener = paramCallbackListener;
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString3);
    ThreadManager.post(new VideoWebPreDownload.1(this, paramString1, paramInt1, paramLong, paramInt2, paramString2), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    d();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiIVideoWebPreDownload$CallbackListener = null;
    ThreadManager.post(new VideoWebPreDownload.5(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoWebPreDownload
 * JD-Core Version:    0.7.0.1
 */