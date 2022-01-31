import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class qkt
  implements pao
{
  private WeakReference<qks> a;
  
  public qkt(qks paramqks)
  {
    this.a = new WeakReference(paramqks);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      qks localqks = (qks)this.a.get();
      if ((localqks != null) && (qks.a(localqks) != null)) {
        qks.a(localqks).post(new VideoAdExposureManager.PosListener.1(this, localqks, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkt
 * JD-Core Version:    0.7.0.1
 */