import android.os.SystemClock;
import com.tencent.av.widget.stageview.MathUtils;

public class kks
{
  public final int a;
  public final long a;
  public final boolean a;
  public int[] a;
  public final int b;
  public final int c;
  public int d;
  public int e;
  
  private kks(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = MathUtils.a(paramInt1, 20000);
    this.c = paramInt2;
    this.jdField_a_of_type_Long = (SystemClock.uptimeMillis() + paramInt4);
    this.e = paramInt1;
    paramInt1 = MathUtils.a(paramInt1, this.c, 20000, true);
    if (paramInt1 > 10000) {
      this.d = (20000 - paramInt1);
    }
    for (this.jdField_a_of_type_Boolean = false; paramInt3 == -1; this.jdField_a_of_type_Boolean = true)
    {
      this.jdField_a_of_type_Int = ((int)(0.1F * this.d));
      return;
      this.d = paramInt1;
    }
    this.jdField_a_of_type_Int = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kks
 * JD-Core Version:    0.7.0.1
 */