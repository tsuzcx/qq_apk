package com.tencent.mobileqq.triton.audio;

class InnerAudioPlayer$ResetTask
  implements Runnable
{
  public int targetId;
  public String targetPath;
  
  public InnerAudioPlayer$ResetTask(InnerAudioPlayer paramInnerAudioPlayer, int paramInt, String paramString)
  {
    this.targetId = paramInt;
    this.targetPath = paramString;
  }
  
  public void run()
  {
    if ((this.this$0.getAudioId() == this.targetId) && (this.this$0.getAudioPath() != null) && (this.this$0.getAudioPath().equals(this.targetPath))) {
      this.this$0.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.InnerAudioPlayer.ResetTask
 * JD-Core Version:    0.7.0.1
 */