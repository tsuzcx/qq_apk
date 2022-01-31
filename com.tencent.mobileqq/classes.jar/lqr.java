import javax.microedition.khronos.opengles.GL11;

public abstract interface lqr
{
  public abstract int a();
  
  public abstract void a(int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void a(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void b(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqr
 * JD-Core Version:    0.7.0.1
 */