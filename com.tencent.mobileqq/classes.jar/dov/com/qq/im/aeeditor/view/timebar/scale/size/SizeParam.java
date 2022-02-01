package dov.com.qq.im.aeeditor.view.timebar.scale.size;

public abstract class SizeParam
{
  protected float a;
  
  public SizeParam(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public abstract float a(long paramLong);
  
  public abstract long a(float paramFloat);
  
  public abstract String a(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timebar.scale.size.SizeParam
 * JD-Core Version:    0.7.0.1
 */