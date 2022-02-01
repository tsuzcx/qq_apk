import android.content.Context;
import android.view.ViewConfiguration;

public class lrz
{
  private int jdField_a_of_type_Int;
  private lrw jdField_a_of_type_Lrw;
  private boolean jdField_a_of_type_Boolean;
  
  public lrz(Context paramContext)
  {
    this.jdField_a_of_type_Lrw = new lrw(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Lrw.a();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.jdField_a_of_type_Lrw.a();
    if (this.jdField_a_of_type_Lrw.a()) {}
    for (int i = j;; i = this.jdField_a_of_type_Lrw.b())
    {
      paramInt2 = lsd.a(i + paramInt1, paramInt2, paramInt3);
      if (paramInt2 != j) {
        this.jdField_a_of_type_Lrw.a(j, 0, paramInt2 - j, 0, 0);
      }
      return i + paramInt1 - paramInt2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lrw.a(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = a();
    lrw locallrw = this.jdField_a_of_type_Lrw;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      locallrw.a(j, 0, paramInt1, 0, paramInt2, paramInt3, 0, 0, i, 0);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lrw.a();
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Lrw.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Lrw.a(paramInt, 0, 0, 0, 0);
    this.jdField_a_of_type_Lrw.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrz
 * JD-Core Version:    0.7.0.1
 */