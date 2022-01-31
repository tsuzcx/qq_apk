import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;

class mrm
  extends lme
{
  mrm(mrl parammrl) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    c();
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    c();
  }
  
  void c()
  {
    mrt localmrt = this.a.a();
    if ((localmrt != null) && (localmrt.a())) {
      ((AVRedPacketManager)this.a.a.a(6)).c(this.a.a.a().a().j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mrm
 * JD-Core Version:    0.7.0.1
 */