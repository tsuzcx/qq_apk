import com.tencent.av.redpacket.AVRedPacketManager;

public class lxd
  extends lxh
{
  public int b;
  
  public lxd()
  {
    this.jdField_b_of_type_Int = 667;
    this.c = new lxt[8];
    this.jdField_b_of_type_Long = 1250L;
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    long l = this.a;
    int i = 0;
    if (paramLong - l <= this.jdField_b_of_type_Long) {
      i = 255;
    }
    a(i);
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new lxt(paramAVRedPacketManager.a("qav_redpacket_excellent_" + i * 2 + ".png"));
      i += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(0, 0, paramInt1, this.jdField_b_of_type_Int * paramInt1 / 750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxd
 * JD-Core Version:    0.7.0.1
 */