import android.graphics.drawable.Drawable;

public class mdh
  extends mdf
{
  protected Drawable a;
  protected String b;
  protected int k = 0;
  
  public mdh(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
  }
  
  public mdh(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString1);
    this.b = paramString2;
    this.k = paramInt5;
  }
  
  public int a()
  {
    return 1;
  }
  
  public Drawable a()
  {
    return this.a;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  public int k()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdh
 * JD-Core Version:    0.7.0.1
 */