package com.tencent.qzonehub.api.impl;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import cooperation.qzone.QzoneFeedsPluginProxyActivity;
import cooperation.qzone.QzoneFullscreenPluginProxyActivity;
import cooperation.qzone.QzoneGPUPluginProxyActivity;
import cooperation.qzone.QzoneNOGPUPluginProxyActivity;
import cooperation.qzone.QzoneOrientationPluginProxyActivity;
import cooperation.qzone.QzonePictureExtPluginProxyActivity;
import cooperation.qzone.QzonePicturePluginProxyActivity;
import cooperation.qzone.QzonePublishMoodProxyActivity;
import cooperation.qzone.QzoneTransNoTitlePluginProxyActivity;
import cooperation.qzone.QzoneTransWithKeyboardPluginProxyActivity;
import cooperation.qzone.QzoneTranslucentGPUPluginProxyActivity;

class QzonePluginProxyActivityProxyImpl$PluginProxyActivityClassFactory
{
  public static Class<? extends PluginProxyActivity> a(String paramString)
  {
    if (QzonePluginProxyActivityProxyImpl.access$100(QzonePluginProxyActivityProxyImpl.access$000(), paramString)) {
      return QzonePicturePluginProxyActivity.class;
    }
    if (QzonePluginProxyActivityProxyImpl.access$100(QzonePluginProxyActivityProxyImpl.access$200(), paramString)) {
      return QzoneTransNoTitlePluginProxyActivity.class;
    }
    if ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) {
      return QzoneTransWithKeyboardPluginProxyActivity.class;
    }
    if ("com.qzone.common.activities.QZoneRapidCommentActivity".equals(paramString)) {
      return QzoneTransNoTitlePluginProxyActivity.class;
    }
    if ("com.qzone.face.ui.QzoneMarkFaceActivity".equals(paramString)) {
      return QzonePictureExtPluginProxyActivity.class;
    }
    if ((!"com.qzone.preview.QZoneVideoFloatActivity".equals(paramString)) && (!"com.qzone.preview.QZoneAdvertiseVideoFloatActivity".equals(paramString)) && (!"com.qzone.preview.QZoneEncourageAdvActivity".equals(paramString)) && (!"com.qzone.preview.VideoPlayerActivity".equals(paramString)) && (!"com.qzone.commoncode.module.videorecommend.ui.QzoneVideoFullscreenRecommendActivity".equals(paramString)))
    {
      if ("com.qzone.commoncode.module.videorecommend.ui.QzoneVideoRecommendActivity".equals(paramString)) {
        return QzoneTranslucentGPUPluginProxyActivity.class;
      }
      if ("com.qzone.video.activity.TrimVideoActivity".equals(paramString)) {
        return QzoneNOGPUPluginProxyActivity.class;
      }
      if ("com.qzone.video.activity.PreviewVideoActivity".equals(paramString)) {
        return QzoneNOGPUPluginProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QZonePublishMoodRealActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QZonePublishMoodTabActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QzonePublishSecretShuoShuoH5Activity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.qzone.feed.ui.activity.QZoneFriendFeedActivity".equals(paramString)) {
        return QzoneFeedsPluginProxyActivity.class;
      }
      if ("com.qzone.common.activities.QzoneDialogActivity".equals(paramString)) {
        return QzoneFullscreenPluginProxyActivity.class;
      }
      if ("com.qzone.feed.ui.activity.QZoneExtendFeedActiviy".equals(paramString)) {
        return QzoneTranslucentGPUPluginProxyActivity.class;
      }
      if ("com.qzone.feed.ui.activity.QZoneExtendLiveCollectActivity".equals(paramString)) {
        return QzoneTranslucentGPUPluginProxyActivity.class;
      }
      if ("com.qzone.publish.ui.activity.QQPublicAccountPublishFeedActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      if ("com.tencent.qcircle.QCirclePublishFeedActivity".equals(paramString)) {
        return QzonePublishMoodProxyActivity.class;
      }
      return QzoneGPUPluginProxyActivity.class;
    }
    return QzoneOrientationPluginProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl.PluginProxyActivityClassFactory
 * JD-Core Version:    0.7.0.1
 */