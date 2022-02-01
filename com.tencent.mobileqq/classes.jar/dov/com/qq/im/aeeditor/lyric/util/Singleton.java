package dov.com.qq.im.aeeditor.lyric.util;

public abstract class Singleton<T, P>
{
  private volatile T a;
  
  protected abstract T a(P paramP);
  
  public final T b(P paramP)
  {
    if (this.a == null) {}
    try
    {
      if (this.a == null) {
        this.a = a(paramP);
      }
      return this.a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.util.Singleton
 * JD-Core Version:    0.7.0.1
 */