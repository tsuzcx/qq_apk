package com.tencent.mobileqq.kandian.base.video.player.videourl.api;

import com.tencent.mobileqq.kandian.base.video.player.videourl.AbsVideoUrlInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IThirdVideoManager
  extends QRouteApi
{
  public static final String CMD_VIDEO_SHOP_AD = "SQQShopAdSvr.GetUrlByVid";
  public static final String CMD_VIDEO_URLFORUUID = "PubAccountArticleCenter.GetVidByUrl";
  public static final String CMD_VIDEO_UUIDFORURL = "PubAccountArticleCenter.GetUrlByVid";
  public static final int ERROR_VIDEO_DELETED = 2;
  public static final int URL_TYPE_HLS = 1;
  public static final int URL_TYPE_MP4 = 0;
  
  public abstract String getUrlByVid(String paramString);
  
  public abstract AbsVideoUrlInfo getVidUrlObjectFromCache(String paramString);
  
  public abstract void sendUrlToUUIDRequest(String paramString, UrlToUUIDCallback paramUrlToUUIDCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager
 * JD-Core Version:    0.7.0.1
 */