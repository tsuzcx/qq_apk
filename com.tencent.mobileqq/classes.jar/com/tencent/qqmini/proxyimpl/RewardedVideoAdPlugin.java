package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;

public class RewardedVideoAdPlugin
{
  public static GdtMotiveVideoPageData a(GdtAd paramGdtAd, String paramString, int paramInt)
  {
    Object localObject = null;
    GdtMotiveVideoPageData localGdtMotiveVideoPageData;
    if (paramGdtAd != null)
    {
      localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = paramGdtAd.getProductType();
      localGdtMotiveVideoPageData.vSize = paramGdtAd.getCreativeSize();
      localGdtMotiveVideoPageData.screenOrientation = paramInt;
      localGdtMotiveVideoPageData.adId = paramGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = paramGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = paramGdtAd.getVideoUrl();
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
      if (paramGdtAd.getImageData() != null) {
        break label420;
      }
    }
    label420:
    for (localObject = "";; localObject = paramGdtAd.getImageData().a)
    {
      localGdtMotiveVideoPageData.previewImgUrl = ((String)localObject);
      localGdtMotiveVideoPageData.bannerImgName = paramGdtAd.getAdvertiser_corporate_image_name();
      localGdtMotiveVideoPageData.bannerBaseInfoText = paramGdtAd.getText();
      localGdtMotiveVideoPageData.bannerLogo = paramGdtAd.getAdvertiser_corporate_logo();
      localGdtMotiveVideoPageData.exposureUrl = paramGdtAd.getUrlForImpression();
      localGdtMotiveVideoPageData.appScore = Double.valueOf(paramGdtAd.getAppScore()).doubleValue();
      localGdtMotiveVideoPageData.downloadNum = paramGdtAd.getAppDownloadNum();
      localGdtMotiveVideoPageData.style = paramGdtAd.getStyle();
      localGdtMotiveVideoPageData.endcardUrl = paramGdtAd.getEndcardUrl();
      localGdtMotiveVideoPageData.endcardLoadTime = paramGdtAd.getEndcardLoadTime();
      localGdtMotiveVideoPageData.bottomCardUrl = paramGdtAd.getBottomCardUrl();
      localGdtMotiveVideoPageData.bottomCardLoadTime = paramGdtAd.getBottomCardLoadTime();
      localGdtMotiveVideoPageData.adsContent = paramString;
      localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
      QLog.d("[minigame] RewardedVideoAdPlugin", 2, "mockMVPageData productType= " + localGdtMotiveVideoPageData.productType + " vSize=" + localGdtMotiveVideoPageData.vSize + " adId=" + localGdtMotiveVideoPageData.adId + " vid=" + localGdtMotiveVideoPageData.vid + " url=" + localGdtMotiveVideoPageData.url + " previewImgUrl=" + localGdtMotiveVideoPageData.previewImgUrl + " bannerImgName=" + localGdtMotiveVideoPageData.bannerImgName + " bannerBaseInfoText=" + localGdtMotiveVideoPageData.bannerBaseInfoText + " bannerLogo=" + localGdtMotiveVideoPageData.bannerLogo + " exposureUrl=" + localGdtMotiveVideoPageData.exposureUrl + " appScore=" + localGdtMotiveVideoPageData.appScore + " downloadNum=" + localGdtMotiveVideoPageData.downloadNum);
      localObject = localGdtMotiveVideoPageData;
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */