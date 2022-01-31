import android.content.Context;
import android.view.ViewConfiguration;

public class lut
{
  private int jdField_a_of_type_Int;
  private luq jdField_a_of_type_Luq;
  private boolean jdField_a_of_type_Boolean;
  
  public lut(Context paramContext)
  {
    this.jdField_a_of_type_Luq = new luq(paramContext);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Luq.a();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.jdField_a_of_type_Luq.a();
    if (this.jdField_a_of_type_Luq.a()) {}
    for (int i = j;; i = this.jdField_a_of_type_Luq.b())
    {
      paramInt2 = lux.a(i + paramInt1, paramInt2, paramInt3);
      if (paramInt2 != j) {
        this.jdField_a_of_type_Luq.a(j, 0, paramInt2 - j, 0, 0);
      }
      return i + paramInt1 - paramInt2;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Luq.a(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = a();
    luq localluq = this.jdField_a_of_type_Luq;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = 0)
    {
      localluq.a(j, 0, paramInt1, 0, paramInt2, paramInt3, 0, 0, i, 0);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Luq.a();
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Luq.b();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Luq.a(paramInt, 0, 0, 0, 0);
    this.jdField_a_of_type_Luq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lut
 * JD-Core Version:    0.7.0.1
 */