import android.content.Context;
import android.view.ViewConfiguration;

public class lia
{
  private int jdField_a_of_type_Int;
  private lhx jdField_a_of_type_Lhx;
  private boolean jdField_a_of_type_Boolean;
  
  public lia(Context paramContext)
  {
    this.jdField_a_of_type_Lhx = new lhx(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Lhx.a();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.jdField_a_of_type_Lhx.a();
    if (this.jdField_a_of_type_Lhx.a()) {}
    for (int i = j;; i = this.jdField_a_of_type_Lhx.b())
    {
      paramInt2 = lie.a(i + paramInt1, paramInt2, paramInt3);
      if (paramInt2 != j) {
        this.jdField_a_of_type_Lhx.a(j, 0, paramInt2 - j, 0, 0);
      }
      return i + paramInt1 - paramInt2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Lhx.a(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = a();
    lhx locallhx = this.jdField_a_of_type_Lhx;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      locallhx.a(j, 0, paramInt1, 0, paramInt2, paramInt3, 0, 0, i, 0);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lhx.a();
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Lhx.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Lhx.a(paramInt, 0, 0, 0, 0);
    this.jdField_a_of_type_Lhx.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lia
 * JD-Core Version:    0.7.0.1
 */