import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class luh
  extends luj
{
  public lud a;
  public boolean a;
  public luv[] a;
  public int b;
  public luv[] b;
  public int c;
  
  public luh(lud paramlud)
  {
    this.jdField_a_of_type_ArrayOfLuv = new luv[6];
    this.jdField_b_of_type_ArrayOfLuv = new luv[10];
    this.jdField_a_of_type_Lud = paramlud;
    this.jdField_c_of_type_ArrayOfLuv = this.jdField_a_of_type_ArrayOfLuv;
    this.jdField_b_of_type_Long = 900L;
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
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ArrayOfLuv.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfLuv[i] = new luv(paramAVRedPacketManager.a("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfLuv.length)
    {
      this.jdField_b_of_type_ArrayOfLuv[j] = new luv(paramAVRedPacketManager.a("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!this.jdField_a_of_type_Boolean) {
        break label45;
      }
    }
    label45:
    for (luv[] arrayOfluv = this.jdField_b_of_type_ArrayOfLuv;; arrayOfluv = this.jdField_a_of_type_ArrayOfLuv)
    {
      this.jdField_c_of_type_ArrayOfLuv = arrayOfluv;
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfLuv.length * 150);
      return;
    }
  }
  
  public void b()
  {
    int j = 0;
    super.b();
    luv[] arrayOfluv = this.jdField_a_of_type_ArrayOfLuv;
    int k = arrayOfluv.length;
    int i = 0;
    luv localluv;
    while (i < k)
    {
      localluv = arrayOfluv[i];
      if (localluv != null) {
        localluv.a();
      }
      i += 1;
    }
    arrayOfluv = this.jdField_b_of_type_ArrayOfLuv;
    k = arrayOfluv.length;
    i = j;
    while (i < k)
    {
      localluv = arrayOfluv[i];
      if (localluv != null) {
        localluv.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_Lud = null;
    this.jdField_a_of_type_ArrayOfLuv = null;
    this.jdField_b_of_type_ArrayOfLuv = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 500 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 500 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Lud.a();
    int i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
    int j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
    int k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
    int m = localRect.top;
    a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     luh
 * JD-Core Version:    0.7.0.1
 */