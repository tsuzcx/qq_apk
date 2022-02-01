import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class luy
  extends lva
{
  public luu a;
  public boolean a;
  public lvm[] a;
  public int b;
  public lvm[] b;
  public int c;
  
  public luy(luu paramluu)
  {
    this.jdField_a_of_type_ArrayOfLvm = new lvm[6];
    this.jdField_b_of_type_ArrayOfLvm = new lvm[10];
    this.jdField_a_of_type_Luu = paramluu;
    this.jdField_c_of_type_ArrayOfLvm = this.jdField_a_of_type_ArrayOfLvm;
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
      if (i >= this.jdField_a_of_type_ArrayOfLvm.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfLvm[i] = new lvm(paramAVRedPacketManager.a("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfLvm.length)
    {
      this.jdField_b_of_type_ArrayOfLvm[j] = new lvm(paramAVRedPacketManager.a("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
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
    for (lvm[] arrayOflvm = this.jdField_b_of_type_ArrayOfLvm;; arrayOflvm = this.jdField_a_of_type_ArrayOfLvm)
    {
      this.jdField_c_of_type_ArrayOfLvm = arrayOflvm;
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfLvm.length * 150);
      return;
    }
  }
  
  public void b()
  {
    int j = 0;
    super.b();
    lvm[] arrayOflvm = this.jdField_a_of_type_ArrayOfLvm;
    int k = arrayOflvm.length;
    int i = 0;
    lvm locallvm;
    while (i < k)
    {
      locallvm = arrayOflvm[i];
      if (locallvm != null) {
        locallvm.a();
      }
      i += 1;
    }
    arrayOflvm = this.jdField_b_of_type_ArrayOfLvm;
    k = arrayOflvm.length;
    i = j;
    while (i < k)
    {
      locallvm = arrayOflvm[i];
      if (locallvm != null) {
        locallvm.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_Luu = null;
    this.jdField_a_of_type_ArrayOfLvm = null;
    this.jdField_b_of_type_ArrayOfLvm = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 500 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 500 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Luu.a();
    int i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
    int j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
    int k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
    int m = localRect.top;
    a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     luy
 * JD-Core Version:    0.7.0.1
 */