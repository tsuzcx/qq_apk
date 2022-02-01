package com.tencent.tav.core.audio;

class AudioExportTask$1
  implements ExportCallback
{
  AudioExportTask$1(AudioExportTask paramAudioExportTask, int paramInt) {}
  
  public void onProgress(int paramInt, float paramFloat)
  {
    synchronized (this.this$0)
    {
      AudioExportTask.access$100(this.this$0, this.val$index, paramInt, paramFloat);
      AudioExportTask.access$200(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportTask.1
 * JD-Core Version:    0.7.0.1
 */