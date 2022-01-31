import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lkm
  extends lko
{
  public lki a;
  public boolean a;
  public lla[] a;
  public int b;
  public lla[] b;
  public int c;
  
  public lkm(lki paramlki)
  {
    this.jdField_a_of_type_ArrayOfLla = new lla[6];
    this.jdField_b_of_type_ArrayOfLla = new lla[10];
    this.jdField_a_of_type_Lki = paramlki;
    this.jdField_c_of_type_ArrayOfLla = this.jdField_a_of_type_ArrayOfLla;
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
      if (i >= this.jdField_a_of_type_ArrayOfLla.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfLla[i] = new lla(paramAVRedPacketManager.a("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfLla.length)
    {
      this.jdField_b_of_type_ArrayOfLla[j] = new lla(paramAVRedPacketManager.a("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
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
    for (lla[] arrayOflla = this.jdField_b_of_type_ArrayOfLla;; arrayOflla = this.jdField_a_of_type_ArrayOfLla)
    {
      this.jdField_c_of_type_ArrayOfLla = arrayOflla;
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfLla.length * 150);
      return;
    }
  }
  
  public void b()
  {
    int j = 0;
    super.b();
    lla[] arrayOflla = this.jdField_a_of_type_ArrayOfLla;
    int k = arrayOflla.length;
    int i = 0;
    lla locallla;
    while (i < k)
    {
      locallla = arrayOflla[i];
      if (locallla != null) {
        locallla.a();
      }
      i += 1;
    }
    arrayOflla = this.jdField_b_of_type_ArrayOfLla;
    k = arrayOflla.length;
    i = j;
    while (i < k)
    {
      locallla = arrayOflla[i];
      if (locallla != null) {
        locallla.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_Lki = null;
    this.jdField_a_of_type_ArrayOfLla = null;
    this.jdField_b_of_type_ArrayOfLla = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 500 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 500 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Lki.a();
    int i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
    int j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
    int k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
    int m = localRect.top;
    a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkm
 * JD-Core Version:    0.7.0.1
 */