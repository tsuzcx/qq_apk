import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lik
  implements Observer
{
  private WeakReference<lij> a;
  
  public lik(lij paramlij)
  {
    this.a = new WeakReference(paramlij);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lij locallij = (lij)this.a.get();
    if (locallij == null) {
      return;
    }
    lij.a(locallij, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lik
 * JD-Core Version:    0.7.0.1
 */