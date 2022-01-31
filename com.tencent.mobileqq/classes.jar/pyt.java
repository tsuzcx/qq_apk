import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class pyt
  implements opn
{
  private WeakReference<pys> a;
  
  public pyt(pys parampys)
  {
    this.a = new WeakReference(parampys);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      pys localpys = (pys)this.a.get();
      if ((localpys != null) && (pys.a(localpys) != null)) {
        pys.a(localpys).post(new VideoAdExposureManager.PosListener.1(this, localpys, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyt
 * JD-Core Version:    0.7.0.1
 */