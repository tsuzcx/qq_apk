package com.tencent.qg.qq;

class QGameApp$3
  implements Runnable
{
  QGameApp$3(QGameApp paramQGameApp, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (!QGameApp.a(this.this$0, this.a, this.b))
    {
      QGameApp.a(this.this$0, 1001);
      return;
    }
    if (QGameApp.b(this.this$0))
    {
      QGameApp.c(this.this$0);
      return;
    }
    QGameApp.a(this.this$0, 1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp.3
 * JD-Core Version:    0.7.0.1
 */