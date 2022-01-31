import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class qkq
  implements pal
{
  private WeakReference<qkp> a;
  
  public qkq(qkp paramqkp)
  {
    this.a = new WeakReference(paramqkp);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      qkp localqkp = (qkp)this.a.get();
      if ((localqkp != null) && (qkp.a(localqkp) != null)) {
        qkp.a(localqkp).post(new VideoAdExposureManager.PosListener.1(this, localqkp, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkq
 * JD-Core Version:    0.7.0.1
 */