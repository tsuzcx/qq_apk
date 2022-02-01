package com.tencent.mobileqq.kandian.base.bandwidth;

import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;

class VideoBufferRangeController$1
  implements Runnable
{
  VideoBufferRangeController$1(VideoBufferRangeController paramVideoBufferRangeController, VideoPlayerWrapper paramVideoPlayerWrapper, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    localVideoPlayerWrapper.a(arrayOfInt[0], arrayOfInt[1], this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.VideoBufferRangeController.1
 * JD-Core Version:    0.7.0.1
 */