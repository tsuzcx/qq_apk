import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class kyz
  implements Observer
{
  private WeakReference<kyy> a;
  
  public kyz(kyy paramkyy)
  {
    this.a = new WeakReference(paramkyy);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    kyy localkyy = (kyy)this.a.get();
    if (localkyy == null) {
      return;
    }
    kyy.a(localkyy, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kyz
 * JD-Core Version:    0.7.0.1
 */