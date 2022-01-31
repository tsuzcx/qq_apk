import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.PosListener.1;
import java.lang.ref.WeakReference;

public final class qzx
  implements pfu
{
  private WeakReference<qzw> a;
  
  public qzx(qzw paramqzw)
  {
    this.a = new WeakReference(paramqzw);
  }
  
  public void a(int paramInt)
  {
    if (this.a != null)
    {
      qzw localqzw = (qzw)this.a.get();
      if ((localqzw != null) && (qzw.a(localqzw) != null)) {
        qzw.a(localqzw).post(new VideoAdExposureManager.PosListener.1(this, localqzw, paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzx
 * JD-Core Version:    0.7.0.1
 */