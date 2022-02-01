import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class liy
  implements Observer
{
  private WeakReference<lix> a;
  
  public liy(lix paramlix)
  {
    this.a = new WeakReference(paramlix);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lix locallix = (lix)this.a.get();
    if (locallix == null) {
      return;
    }
    lix.a(locallix, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     liy
 * JD-Core Version:    0.7.0.1
 */