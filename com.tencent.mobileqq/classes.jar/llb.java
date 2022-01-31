import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.av.redpacket.AVRedPacketManager;

public class llb
{
  public lka[] a = new lka[8];
  
  public llb(Context paramContext)
  {
    this.a[0] = new lkt();
    this.a[1] = new lkr(paramContext);
    this.a[2] = new lkf();
    this.a[3] = new lkw();
    this.a[4] = new lkd();
    this.a[5] = new lkc();
    this.a[6] = new lkb();
    this.a[7] = new lkp();
  }
  
  public long a(long paramLong)
  {
    long l2;
    if (paramLong < this.a[0].jdField_a_of_type_Long)
    {
      l2 = this.a[0].jdField_a_of_type_Long;
      l1 = this.a[0].jdField_a_of_type_Long;
      l2 -= paramLong;
      paramLong = l1;
    }
    for (long l1 = l2;; l1 = 0L)
    {
      lka[] arrayOflka = this.a;
      int j = arrayOflka.length;
      int i = 0;
      while (i < j)
      {
        arrayOflka[i].jdField_a_of_type_Long = paramLong;
        i += 1;
      }
      ((lkt)this.a[0]).a = true;
      ((lkr)this.a[1]).a = true;
      ((lkf)this.a[2]).a = true;
      return l1;
    }
  }
  
  public void a()
  {
    lka[] arrayOflka = this.a;
    int j = arrayOflka.length;
    int i = 0;
    while (i < j)
    {
      arrayOflka[i].b();
      i += 1;
    }
    this.a = null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    lka[] arrayOflka = this.a;
    int j = arrayOflka.length;
    int i = 0;
    while (i < j)
    {
      arrayOflka[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  public void a(long paramLong)
  {
    this.a[0].jdField_a_of_type_Long = paramLong;
    this.a[1].jdField_a_of_type_Long = paramLong;
    this.a[2].jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    lka[] arrayOflka = this.a;
    int j = arrayOflka.length;
    int i = 0;
    while (i < j)
    {
      arrayOflka[i].a(paramCanvas, paramPaint);
      i += 1;
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    this.a[0].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_light_bg.png"));
    this.a[2].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_cd.png"));
    this.a[4].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_3.png"));
    this.a[5].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_2.png"));
    this.a[6].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_1.png"));
    this.a[7].jdField_a_of_type_Lla = new lla(paramAVRedPacketManager.a("qav_redpacket_go.png"));
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    if (paramBoolean) {}
    for (this.a[3].jdField_a_of_type_Lla = null;; this.a[3].jdField_a_of_type_Lla = null)
    {
      ((lkr)this.a[1]).a(paramBoolean, paramAVRedPacketManager);
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    lka[] arrayOflka = this.a;
    int j = arrayOflka.length;
    int i = 0;
    while (i < j)
    {
      arrayOflka[i].a(paramLong);
      i += 1;
    }
    boolean bool1 = bool2;
    if (this.a[7].jdField_a_of_type_Long != 0L)
    {
      bool1 = bool2;
      if (paramLong - this.a[7].jdField_a_of_type_Long > 5564L) {
        bool1 = true;
      }
    }
    if (bool1) {
      this.a[7].jdField_a_of_type_Long = 0L;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llb
 * JD-Core Version:    0.7.0.1
 */