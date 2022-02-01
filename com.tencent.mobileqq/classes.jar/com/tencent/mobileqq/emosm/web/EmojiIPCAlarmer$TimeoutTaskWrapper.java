package com.tencent.mobileqq.emosm.web;

import asij;

class EmojiIPCAlarmer$TimeoutTaskWrapper
  implements Runnable
{
  private int a;
  
  public EmojiIPCAlarmer$TimeoutTaskWrapper(EmojiIPCAlarmer paramEmojiIPCAlarmer, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    if (this.this$0.a != null) {}
    try
    {
      this.this$0.a.a(this.a);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutTaskWrapper
 * JD-Core Version:    0.7.0.1
 */