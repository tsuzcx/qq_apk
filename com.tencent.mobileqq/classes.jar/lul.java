import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lul
  extends lun
{
  public luh a;
  public boolean a;
  public luz[] a;
  public int b;
  public luz[] b;
  public int c;
  
  public lul(luh paramluh)
  {
    this.jdField_a_of_type_ArrayOfLuz = new luz[6];
    this.jdField_b_of_type_ArrayOfLuz = new luz[10];
    this.jdField_a_of_type_Luh = paramluh;
    this.jdField_c_of_type_ArrayOfLuz = this.jdField_a_of_type_ArrayOfLuz;
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
      if (i >= this.jdField_a_of_type_ArrayOfLuz.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfLuz[i] = new luz(paramAVRedPacketManager.a("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfLuz.length)
    {
      this.jdField_b_of_type_ArrayOfLuz[j] = new luz(paramAVRedPacketManager.a("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
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
    for (luz[] arrayOfluz = this.jdField_b_of_type_ArrayOfLuz;; arrayOfluz = this.jdField_a_of_type_ArrayOfLuz)
    {
      this.jdField_c_of_type_ArrayOfLuz = arrayOfluz;
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfLuz.length * 150);
      return;
    }
  }
  
  public void b()
  {
    int j = 0;
    super.b();
    luz[] arrayOfluz = this.jdField_a_of_type_ArrayOfLuz;
    int k = arrayOfluz.length;
    int i = 0;
    luz localluz;
    while (i < k)
    {
      localluz = arrayOfluz[i];
      if (localluz != null) {
        localluz.a();
      }
      i += 1;
    }
    arrayOfluz = this.jdField_b_of_type_ArrayOfLuz;
    k = arrayOfluz.length;
    i = j;
    while (i < k)
    {
      localluz = arrayOfluz[i];
      if (localluz != null) {
        localluz.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_Luh = null;
    this.jdField_a_of_type_ArrayOfLuz = null;
    this.jdField_b_of_type_ArrayOfLuz = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 500 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 500 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Luh.a();
    int i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
    int j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
    int k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
    int m = localRect.top;
    a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lul
 * JD-Core Version:    0.7.0.1
 */