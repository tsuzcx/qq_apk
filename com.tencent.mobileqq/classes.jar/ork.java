import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ad.video.strategy.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class ork
  implements pxb
{
  private WeakReference<orj> a;
  
  public ork(orj paramorj)
  {
    this.a = new WeakReference(paramorj);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      orj localorj = (orj)this.a.get();
      if ((localorj != null) && (orj.a(localorj) != null)) {
        orj.a(localorj).post(new VideoAdExposureManager.PosListener.1(this, localorj, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ork
 * JD-Core Version:    0.7.0.1
 */