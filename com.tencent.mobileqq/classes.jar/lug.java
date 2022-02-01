import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lug
  extends luj
{
  public lub a;
  public boolean a;
  public luv[] a;
  public int b;
  public luv[] b;
  public int c;
  public int d;
  public int e;
  
  public lug(lub paramlub)
  {
    this.jdField_a_of_type_ArrayOfLuv = new luv[6];
    this.jdField_b_of_type_ArrayOfLuv = new luv[6];
    this.jdField_a_of_type_Lub = paramlub;
    this.jdField_c_of_type_ArrayOfLuv = this.jdField_a_of_type_ArrayOfLuv;
    this.jdField_b_of_type_Long = 1800L;
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    Rect localRect = this.jdField_a_of_type_Lub.a();
    int i;
    int j;
    int k;
    int m;
    if (this.jdField_a_of_type_Boolean)
    {
      i = (localRect.left + localRect.right - this.d) / 2;
      j = (localRect.top + localRect.bottom - this.e) / 2;
      k = (localRect.left + localRect.right + this.d) / 2;
      m = localRect.top;
      a(i, j, k, (localRect.bottom + m + this.e) / 2);
      if (this.jdField_a_of_type_Lub.a == null) {
        break label237;
      }
      a(this.jdField_a_of_type_Lub.a());
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Lub.a());
      return;
      i = (localRect.left + localRect.right - this.jdField_b_of_type_Int) / 2;
      j = (localRect.top + localRect.bottom - this.jdField_c_of_type_Int) / 2;
      k = (localRect.left + localRect.right + this.jdField_b_of_type_Int) / 2;
      m = localRect.top;
      a(i, j, k, (localRect.bottom + m + this.jdField_c_of_type_Int) / 2);
      break;
      label237:
      a(0);
    }
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
      this.jdField_a_of_type_ArrayOfLuv[i] = new luv(paramAVRedPacketManager.a("qav_redpacket_focus_" + i * 6 + ".png"));
      i += 1;
    }
    while (j < this.jdField_b_of_type_ArrayOfLuv.length)
    {
      this.jdField_b_of_type_ArrayOfLuv[j] = new luv(paramAVRedPacketManager.a("qav_redpacket_focus_big_" + j * 6 + ".png"));
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
      this.jdField_b_of_type_Long = (this.jdField_c_of_type_ArrayOfLuv.length * 300);
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
    this.jdField_a_of_type_Lub = null;
    this.jdField_a_of_type_ArrayOfLuv = null;
    this.jdField_b_of_type_ArrayOfLuv = null;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = (paramInt1 * 380 / 750);
    this.jdField_c_of_type_Int = (paramInt1 * 380 / 750);
    this.d = (paramInt1 * 500 / 750);
    this.e = (paramInt1 * 500 / 750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lug
 * JD-Core Version:    0.7.0.1
 */