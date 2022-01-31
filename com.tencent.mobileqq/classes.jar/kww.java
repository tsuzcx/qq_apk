import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class kww
  implements Observer
{
  private WeakReference<kwv> a;
  
  kww(kwv paramkwv)
  {
    this.a = new WeakReference(paramkwv);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    kwv localkwv = (kwv)this.a.get();
    if (localkwv == null) {
      return;
    }
    kwv.a(localkwv, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kww
 * JD-Core Version:    0.7.0.1
 */