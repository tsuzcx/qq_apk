package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;

public class RewardedVideoAdPlugin
{
  public static GdtMotiveVideoPageData a(GdtAd paramGdtAd, String paramString, int paramInt)
  {
    if (paramGdtAd != null)
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = paramGdtAd.getProductType();
      localGdtMotiveVideoPageData.vSize = paramGdtAd.getCreativeSize();
      localGdtMotiveVideoPageData.screenOrientation = paramInt;
      localGdtMotiveVideoPageData.adId = paramGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = paramGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = paramGdtAd.getVideoUrl();
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
      String str;
      if (paramGdtAd.getImageData() == null) {
        str = "";
      } else {
        str = paramGdtAd.getImageData().a;
      }
      localGdtMotiveVideoPageData.previewImgUrl = str;
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
      paramGdtAd = new StringBuilder();
      paramGdtAd.append("mockMVPageData productType= ");
      paramGdtAd.append(localGdtMotiveVideoPageData.productType);
      paramGdtAd.append(" vSize=");
      paramGdtAd.append(localGdtMotiveVideoPageData.vSize);
      paramGdtAd.append(" adId=");
      paramGdtAd.append(localGdtMotiveVideoPageData.adId);
      paramGdtAd.append(" vid=");
      paramGdtAd.append(localGdtMotiveVideoPageData.vid);
      paramGdtAd.append(" url=");
      paramGdtAd.append(localGdtMotiveVideoPageData.url);
      paramGdtAd.append(" previewImgUrl=");
      paramGdtAd.append(localGdtMotiveVideoPageData.previewImgUrl);
      paramGdtAd.append(" bannerImgName=");
      paramGdtAd.append(localGdtMotiveVideoPageData.bannerImgName);
      paramGdtAd.append(" bannerBaseInfoText=");
      paramGdtAd.append(localGdtMotiveVideoPageData.bannerBaseInfoText);
      paramGdtAd.append(" bannerLogo=");
      paramGdtAd.append(localGdtMotiveVideoPageData.bannerLogo);
      paramGdtAd.append(" exposureUrl=");
      paramGdtAd.append(localGdtMotiveVideoPageData.exposureUrl);
      paramGdtAd.append(" appScore=");
      paramGdtAd.append(localGdtMotiveVideoPageData.appScore);
      paramGdtAd.append(" downloadNum=");
      paramGdtAd.append(localGdtMotiveVideoPageData.downloadNum);
      QLog.d("[minigame] RewardedVideoAdPlugin", 2, paramGdtAd.toString());
      return localGdtMotiveVideoPageData;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */