import com.tencent.av.redpacket.AVRedPacketManager;

public class lxn
  extends lxh
{
  public lxn()
  {
    this.c = new lxt[6];
    this.b = 1000L;
    a(255);
  }
  
  public void a(AVRedPacketManager paramAVRedPacketManager)
  {
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new lxt(paramAVRedPacketManager.a("qav_redpacket_lightning_" + (i + 1) + ".png"));
      i += 1;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(0, paramInt2 - paramInt1 * 120 / 750, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxn
 * JD-Core Version:    0.7.0.1
 */