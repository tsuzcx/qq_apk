import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lxf
  extends lxh
{
  public lxb a;
  public boolean a;
  public lxt[] a;
  public int b;
  public lxt[] b;
  public int c;
  
  public lxf(lxb paramlxb)
  {
    this.jdField_a_of_type_ArrayOfLxt = new lxt[6];
    this.jdField_b_of_type_ArrayOfLxt = new lxt[10];
    this.jdField_a_of_type_Lxb = paramlxb;
    this.jdField_c_of_type_ArrayOfLxt = this.jdField_a_of_type_ArrayOfLxt;
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
      if (i >= this.jdField_a_of_type_ArrayOfLxt.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfLxt[i] = new lxt(paramAVRedPacketManager.a("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfLxt.length)
    {
      this.jdField_b_of_type_ArrayOfLxt[j] = new lxt(paramAVRedPacketManager.a("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
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
    for (lxt[] arrayOflxt = this.jdField_b_of_type_ArrayOfLxt;; arrayOflxt = this.jdField_a_of_type_ArrayOfLxt)
    {
      this.jdField_c_of_type_ArrayOfLxt = arrayOflxt;
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfLxt.length * 150);
      return;
    }
  }
  
  public void b()
  {
    int j = 0;
    super.b();
    lxt[] arrayOflxt = this.jdField_a_of_type_ArrayOfLxt;
    int k = arrayOflxt.length;
    int i = 0;
    lxt locallxt;
    while (i < k)
    {
      locallxt = arrayOflxt[i];
      if (locallxt != null) {
        locallxt.a();
      }
      i += 1;
    }
    arrayOflxt = this.jdField_b_of_type_ArrayOfLxt;
    k = arrayOflxt.length;
    i = j;
    while (i < k)
    {
      locallxt = arrayOflxt[i];
      if (locallxt != null) {
        locallxt.a();
      }
      i += 1;
    }
    this.jdField_a_of_type_Lxb = null;
    this.jdField_a_of_type_ArrayOfLxt = null;
    this.jdField_b_of_type_ArrayOfLxt = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 500 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 500 / 750);
  }
  
  public void c()
  {
    Rect localRect = this.jdField_a_of_type_Lxb.a();
    int i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
    int j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
    int k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
    int m = localRect.top;
    a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxf
 * JD-Core Version:    0.7.0.1
 */