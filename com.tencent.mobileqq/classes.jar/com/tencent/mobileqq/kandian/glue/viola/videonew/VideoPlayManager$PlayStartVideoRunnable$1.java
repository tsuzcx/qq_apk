package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$PlayStartVideoRunnable$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoPlayManager$PlayStartVideoRunnable$1(VideoPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("UUIDToUrlCallback Callback vid=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", isH265=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_a_of_type_Boolean);
      localStringBuilder.append(", isHWCodec=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_b_of_type_Boolean);
      localStringBuilder.append(", fileBitRate=");
      localStringBuilder.append(paramVideoUrlInfo.c);
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
    if ((VideoPlayManager.PlayStartVideoRunnable.a(this.a) != null) && (paramVideoUrlInfo.jdField_b_of_type_JavaLangString.equals(VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.jdField_a_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString))
      {
        if (VideoPlayManager.a(this.a.this$0) != null) {
          VideoPlayManager.a(this.a.this$0).a(null, 202, 107, 0, "vid2url failed, get null", null);
        }
        return;
      }
      if (paramVideoUrlInfo.d == 1)
      {
        VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 104, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, false);
        return;
      }
      VideoPlayManager.PlayStartVideoRunnable.a(this.a).a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 101, VideoPlayManager.PlayStartVideoRunnable.a(this.a), 0L, VideoPlayManager.PlayStartVideoRunnable.a(this.a).a.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, false);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vid2url换回来后，当前视频已经不再播放，vid:");
      localStringBuilder.append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(" url:");
      localStringBuilder.append(paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
      QLog.d("Viola.VideoPlayManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.PlayStartVideoRunnable.1
 * JD-Core Version:    0.7.0.1
 */