package com.tencent.mobileqq.editor.composite.step;

import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

class VideoStoryPicToVideo$2
  implements FFmpegExecuteResponseCallback
{
  VideoStoryPicToVideo$2(VideoStoryPicToVideo paramVideoStoryPicToVideo, VideoStoryPicToVideo.ConvertListener paramConvertListener, VideoStoryPicToVideo.RetCode paramRetCode) {}
  
  public void onFailure(String paramString)
  {
    if (this.a != null)
    {
      this.b.a(943004);
      this.b.a(paramString);
      this.a.b(this.b);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPicToVideo", 2, "picToVideo failure");
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPicToVideo", 2, "picToVideo finish");
    }
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPicToVideo", 2, "picToVideo start");
    }
  }
  
  public void onSuccess(String paramString)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.a(this.b);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryPicToVideo", 2, "picToVideo sucess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.2
 * JD-Core Version:    0.7.0.1
 */