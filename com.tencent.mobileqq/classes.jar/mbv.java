import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.mobileqq.utils.AudioHelper;

public class mbv
  extends lee
{
  public mbv(AVActivity paramAVActivity) {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    this.a.a.a(paramLong1, this.a, 4, 0);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    paramLong = AudioHelper.b();
    this.a.a.a(paramLong, this.a, 3, 2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    this.a.a.a(paramLong1, this.a, 4, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mbv
 * JD-Core Version:    0.7.0.1
 */