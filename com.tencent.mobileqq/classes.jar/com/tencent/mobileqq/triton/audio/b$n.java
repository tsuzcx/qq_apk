package com.tencent.mobileqq.triton.audio;

class b$n
  implements Runnable
{
  public int a;
  public String b;
  
  public b$n(b paramb, int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public void run()
  {
    if ((this.c.getAudioId() == this.a) && (this.c.getAudioPath() != null) && (this.c.getAudioPath().equals(this.b))) {
      this.c.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.b.n
 * JD-Core Version:    0.7.0.1
 */