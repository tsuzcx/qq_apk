package com.tencent.richmedia.videocompress;

import com.tencent.richmedia.videocompress.converter.SoftwareConverter.ProcessCallBack;

class VideoConverterImpl$2
  implements SoftwareConverter.ProcessCallBack
{
  VideoConverterImpl$2(VideoConverterImpl paramVideoConverterImpl, VideoConverter.Processor paramProcessor) {}
  
  public VideoConverterConfig getEncodeConfig()
  {
    return this.val$processor.getEncodeConfig(0, 0);
  }
  
  public void onDestroy()
  {
    VideoConverterImpl.access$302(this.this$0, null);
  }
  
  public void onStart(Process paramProcess)
  {
    VideoConverterImpl.access$302(this.this$0, paramProcess);
  }
  
  public void onStop()
  {
    VideoConverterImpl.access$302(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.VideoConverterImpl.2
 * JD-Core Version:    0.7.0.1
 */