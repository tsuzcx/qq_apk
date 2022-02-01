package me.weishu.epic.art;

class Trampoline
{
  private final long a;
  private final byte[] b;
  private int c;
  private long d;
  private boolean e;
  
  private void a()
  {
    long l = this.d;
    if (l != 0L)
    {
      EpicNative.a(l, this.c);
      this.d = 0L;
      this.c = 0;
    }
    if (this.e) {
      EpicNative.a(this.b, this.a);
    }
  }
  
  protected void finalize()
  {
    a();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.Trampoline
 * JD-Core Version:    0.7.0.1
 */