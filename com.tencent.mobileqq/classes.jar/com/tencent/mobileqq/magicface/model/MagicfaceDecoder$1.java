package com.tencent.mobileqq.magicface.model;

class MagicfaceDecoder$1
  implements Runnable
{
  MagicfaceDecoder$1(MagicfaceDecoder paramMagicfaceDecoder) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    MagicfaceDecoder localMagicfaceDecoder = this.this$0;
    localMagicfaceDecoder.f = true;
    if (localMagicfaceDecoder.b != null) {
      this.this$0.b.a();
    }
    this.this$0.a();
    localMagicfaceDecoder = this.this$0;
    localMagicfaceDecoder.f = false;
    if (localMagicfaceDecoder.b != null) {
      this.this$0.b.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */