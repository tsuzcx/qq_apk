import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lul
  extends luj
{
  public lud a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public lul(lud paramlud)
  {
    this.jdField_a_of_type_Lud = paramlud;
    this.jdField_b_of_type_Long = 750L;
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    long l = this.jdField_a_of_type_Long;
    int i = 0;
    if (paramLong - l <= this.jdField_b_of_type_Long) {
      i = 255;
    }
    a(i);
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    this.jdField_c_of_type_ArrayOfLuv = new luv[5];
    int i = 0;
    while (i < this.jdField_c_of_type_ArrayOfLuv.length)
    {
      this.jdField_c_of_type_ArrayOfLuv[i] = new luv(paramAVRedPacketManager.a("qav_redpacket_gold_" + i * 2 + ".png"));
      i += 1;
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Lud = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 399 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 279 / 750);
    this.d = (paramInt1 * 155 / 750);
    this.e = (paramInt1 * 252 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Lud.a();
    int i = localRect.left - this.d;
    int j = localRect.top - this.e;
    a(i, j, this.jdField_b_of_type_Int + i, this.jdField_c_of_type_Int + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lul
 * JD-Core Version:    0.7.0.1
 */