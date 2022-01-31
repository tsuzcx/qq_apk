import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class ljj
  implements Observer
{
  private WeakReference<lji> a;
  
  ljj(lji paramlji)
  {
    this.a = new WeakReference(paramlji);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lji locallji = (lji)this.a.get();
    if (locallji == null) {
      return;
    }
    lji.a(locallji, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljj
 * JD-Core Version:    0.7.0.1
 */