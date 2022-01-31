import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.av.redpacket.AVRedPacketManager;

public class lvs
{
  public lur[] a = new lur[8];
  
  public lvs(Context paramContext)
  {
    this.a[0] = new lvk();
    this.a[1] = new lvi(paramContext);
    this.a[2] = new luw();
    this.a[3] = new lvn();
    this.a[4] = new luu();
    this.a[5] = new lut();
    this.a[6] = new lus();
    this.a[7] = new lvg();
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
      lur[] arrayOflur = this.a;
      int j = arrayOflur.length;
      int i = 0;
      while (i < j)
      {
        arrayOflur[i].jdField_a_of_type_Long = paramLong;
        i += 1;
      }
      ((lvk)this.a[0]).a = true;
      ((lvi)this.a[1]).a = true;
      ((luw)this.a[2]).a = true;
      return l1;
    }
  }
  
  public void a()
  {
    lur[] arrayOflur = this.a;
    int j = arrayOflur.length;
    int i = 0;
    while (i < j)
    {
      arrayOflur[i].b();
      i += 1;
    }
    this.a = null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    lur[] arrayOflur = this.a;
    int j = arrayOflur.length;
    int i = 0;
    while (i < j)
    {
      arrayOflur[i].b(paramInt1, paramInt2, paramInt3, paramInt4);
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
    lur[] arrayOflur = this.a;
    int j = arrayOflur.length;
    int i = 0;
    while (i < j)
    {
      arrayOflur[i].a(paramCanvas, paramPaint);
      i += 1;
    }
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    this.a[0].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_light_bg.png"));
    this.a[2].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_cd.png"));
    this.a[4].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_3.png"));
    this.a[5].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_2.png"));
    this.a[6].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_1.png"));
    this.a[7].jdField_a_of_type_Lvr = new lvr(paramAVRedPacketManager.a("qav_redpacket_go.png"));
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    if (paramBoolean) {}
    for (this.a[3].jdField_a_of_type_Lvr = null;; this.a[3].jdField_a_of_type_Lvr = null)
    {
      ((lvi)this.a[1]).a(paramBoolean, paramAVRedPacketManager);
      return;
    }
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    lur[] arrayOflur = this.a;
    int j = arrayOflur.length;
    int i = 0;
    while (i < j)
    {
      arrayOflur[i].a(paramLong);
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
 * Qualified Name:     lvs
 * JD-Core Version:    0.7.0.1
 */