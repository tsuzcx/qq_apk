package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VideoFeedsPlayManager$PlayStartVideoRunnable$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoFeedsPlayManager$PlayStartVideoRunnable$1(VideoFeedsPlayManager.PlayStartVideoRunnable paramPlayStartVideoRunnable, long paramLong, ThirdVideoManager paramThirdVideoManager) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    Object localObject1 = (VideoPlayParam)VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)VideoFeedsPlayManager.PlayStartVideoRunnable.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$PlayStartVideoRunnable).get();
    if (paramVideoUrlInfo == null)
    {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("UUIDToUrlCallback Callback code=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.jdField_c_of_type_Int);
      ((StringBuilder)localObject2).append(", vid=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", url=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", isH265=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append(", isHWCodec=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject2).append(", fileBitRate=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", hwBackupUrl=");
      ((StringBuilder)localObject2).append(paramVideoUrlInfo.e);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$PlayStartVideoRunnable, (VideoPlayParam)localObject1, localVideoPlayerWrapper))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "sendUUIDToUrlRequest: checkVideoStatus error return");
      }
      return;
    }
    if (paramVideoUrlInfo.jdField_b_of_type_JavaLangString.equals(((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString))
    {
      if (!VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$PlayStartVideoRunnable, paramVideoUrlInfo, localVideoPlayerWrapper)) {
        return;
      }
      localObject2 = VideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$PlayStartVideoRunnable.this$0);
      if (localObject2 != null)
      {
        localVideoPlayerWrapper.jdField_b_of_type_Boolean = ((VideoPreDownloadMgr)localObject2).a(paramVideoUrlInfo.jdField_a_of_type_JavaLangString, paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
        ((VideoPreDownloadMgr)localObject2).a(((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, localVideoPlayerWrapper.jdField_b_of_type_Boolean);
      }
      if (paramVideoUrlInfo.d == 1) {
        localVideoPlayerWrapper.a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 104, this.jdField_a_of_type_Long, 0L, ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, ((VideoPlayParam)localObject1).jdField_a_of_type_Boolean);
      } else {
        localVideoPlayerWrapper.a(paramVideoUrlInfo.jdField_b_of_type_JavaLangString, paramVideoUrlInfo.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Long, 0L, ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d, paramVideoUrlInfo.jdField_b_of_type_Boolean, true, ((VideoPlayParam)localObject1).jdField_a_of_type_Boolean, paramVideoUrlInfo.e);
      }
      VideoFeedsPlayManager.PlayStartVideoRunnable.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$PlayStartVideoRunnable, (VideoPlayParam)localObject1, localVideoPlayerWrapper, paramVideoUrlInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("vid2url换回来后，当前视频已经不再播放，vid:");
      ((StringBuilder)localObject1).append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(" url:");
      ((StringBuilder)localObject1).append(paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager.PlayStartVideoRunnable.1
 * JD-Core Version:    0.7.0.1
 */