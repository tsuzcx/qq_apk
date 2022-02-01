package com.tencent.mobileqq.shortvideo;

final class VideoEnvironment$3
  implements Runnable
{
  VideoEnvironment$3(VideoEnvironment.ShortVideoDownload paramShortVideoDownload, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$ele != null) {
      this.val$ele.VideoSoDownloadSuccess(this.val$success);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment.3
 * JD-Core Version:    0.7.0.1
 */