import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;

class mpu
  extends ljr
{
  mpu(mpt parammpt) {}
  
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
    mqb localmqb = this.a.a();
    if ((localmqb != null) && (localmqb.a())) {
      ((AVRedPacketManager)this.a.a.a(6)).c(this.a.a.a().a().j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpu
 * JD-Core Version:    0.7.0.1
 */