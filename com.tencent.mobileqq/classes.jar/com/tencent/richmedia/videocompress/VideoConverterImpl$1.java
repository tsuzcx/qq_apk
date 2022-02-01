package com.tencent.richmedia.videocompress;

class VideoConverterImpl$1
  implements VideoConverter.Processor
{
  VideoConverterImpl$1(VideoConverterImpl paramVideoConverterImpl, VideoConverter.Processor paramProcessor) {}
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    return this.val$processor.getEncodeConfig(paramInt1, paramInt2);
  }
  
  public void onCancel()
  {
    VideoConverterImpl.access$202(this.this$0, true);
    this.val$processor.onCancel();
  }
  
  public void onFail(Throwable paramThrowable)
  {
    if ("noNeedCompress".equals(paramThrowable.getMessage()))
    {
      VideoConverterImpl.access$002(this.this$0, true);
      return;
    }
    VideoConverterImpl.access$102(this.this$0, paramThrowable);
    this.val$processor.onFail(paramThrowable);
  }
  
  public void onProgress(int paramInt)
  {
    this.val$processor.onProgress(paramInt);
  }
  
  public void onSuccess()
  {
    this.val$processor.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.VideoConverterImpl.1
 * JD-Core Version:    0.7.0.1
 */