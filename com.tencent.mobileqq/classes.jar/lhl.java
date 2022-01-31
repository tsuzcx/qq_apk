import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lhl
  implements Observer
{
  private WeakReference<lhk> a;
  
  lhl(lhk paramlhk)
  {
    this.a = new WeakReference(paramlhk);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lhk locallhk = (lhk)this.a.get();
    if (locallhk == null) {
      return;
    }
    lhk.a(locallhk, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhl
 * JD-Core Version:    0.7.0.1
 */