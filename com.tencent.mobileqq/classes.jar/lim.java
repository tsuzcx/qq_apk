import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lim
  implements Observer
{
  private WeakReference<lil> a;
  
  public lim(lil paramlil)
  {
    this.a = new WeakReference(paramlil);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lil locallil = (lil)this.a.get();
    if (locallil == null) {
      return;
    }
    lil.a(locallil, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lim
 * JD-Core Version:    0.7.0.1
 */