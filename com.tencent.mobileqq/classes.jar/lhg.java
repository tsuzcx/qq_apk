import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lhg
  implements Observer
{
  private WeakReference<lhf> a;
  
  lhg(lhf paramlhf)
  {
    this.a = new WeakReference(paramlhf);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lhf locallhf = (lhf)this.a.get();
    if (locallhf == null) {
      return;
    }
    lhf.a(locallhf, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhg
 * JD-Core Version:    0.7.0.1
 */