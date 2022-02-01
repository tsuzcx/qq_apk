import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lgm
  implements Observer
{
  private WeakReference<lgl> a;
  
  lgm(lgl paramlgl)
  {
    this.a = new WeakReference(paramlgl);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lgl locallgl = (lgl)this.a.get();
    if (locallgl == null) {
      return;
    }
    lgl.a(locallgl, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgm
 * JD-Core Version:    0.7.0.1
 */