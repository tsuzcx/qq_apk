package mqq.app;

public abstract interface QQPermissionCallback
{
  public abstract void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.QQPermissionCallback
 * JD-Core Version:    0.7.0.1
 */