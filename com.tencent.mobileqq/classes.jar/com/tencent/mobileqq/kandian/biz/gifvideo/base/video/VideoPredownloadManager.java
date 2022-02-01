package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class VideoPredownloadManager
{
  public static void a(String paramString)
  {
    Object localObject = TVK_SDKMgr.getProxyFactory();
    if (localObject != null)
    {
      localObject = ((TVK_IProxyFactory)localObject).getCacheMgr(BaseApplicationImpl.getContext());
      if (localObject != null)
      {
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString), "");
        localTVK_PlayerVideoInfo.setConfigMap("cache_duration", "2");
        localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20160519");
        ((TVK_ICacheMgr)localObject).preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, localTVK_PlayerVideoInfo);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject1 = TVK_SDKMgr.getProxyFactory();
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((TVK_IProxyFactory)localObject1).getCacheMgr(BaseApplicationImpl.getContext());
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).generateVid(paramString);
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo("", "");
    localObject2 = new TVK_PlayerVideoInfo(2, (String)localObject2, "");
    ((TVK_PlayerVideoInfo)localObject2).setConfigMap("cache_duration", "2");
    ((TVK_PlayerVideoInfo)localObject2).setConfigMap("cache_servers_type", "20160519");
    ((TVK_PlayerVideoInfo)localObject2).addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int m = arrayOfString.length;
    int j = 0;
    int i = 0;
    label153:
    String str;
    while (j < m) {
      str = arrayOfString[j];
    }
    try
    {
      int k = ((TVK_ICacheMgr)localObject1).isVideoCached(BaseApplicationImpl.getContext(), paramString, localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject2, str);
      i = k;
    }
    catch (Exception localException)
    {
      label188:
      break label188;
    }
    if (i != 2)
    {
      if (i == 1) {
        return true;
      }
      j += 1;
      break label153;
    }
    return true;
    QLog.isColorLevel();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPredownloadManager
 * JD-Core Version:    0.7.0.1
 */