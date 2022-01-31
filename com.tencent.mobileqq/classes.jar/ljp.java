import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class ljp
  implements Observer
{
  private WeakReference<ljo> a;
  
  public ljp(ljo paramljo)
  {
    this.a = new WeakReference(paramljo);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ljo localljo = (ljo)this.a.get();
    if (localljo == null) {
      return;
    }
    ljo.a(localljo, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljp
 * JD-Core Version:    0.7.0.1
 */