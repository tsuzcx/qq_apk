package dov.com.qq.im.ae.camera.ui;

public abstract class Direction
{
  public static Direction a(int paramInt)
  {
    if (paramInt > 0) {
      return new Direction.End();
    }
    return new Direction.Start();
  }
  
  public abstract int a(int paramInt);
  
  public abstract boolean a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.Direction
 * JD-Core Version:    0.7.0.1
 */