import android.view.MotionEvent;
import java.lang.ref.WeakReference;

public class mme
  implements lsd
{
  private WeakReference<mmd> a;
  
  public mme(mmd parammmd)
  {
    this.a = new WeakReference(parammmd);
  }
  
  public boolean a(lsc paramlsc, MotionEvent paramMotionEvent)
  {
    mmd localmmd = (mmd)this.a.get();
    if (localmmd != null) {
      return localmmd.a(paramlsc, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mme
 * JD-Core Version:    0.7.0.1
 */