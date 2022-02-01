import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lis
  implements Observer
{
  private WeakReference<lir> a;
  
  public lis(lir paramlir)
  {
    this.a = new WeakReference(paramlir);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lir locallir = (lir)this.a.get();
    if (locallir == null) {
      return;
    }
    lir.a(locallir, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */