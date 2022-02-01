import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lgg
  implements Observer
{
  private WeakReference<lgf> a;
  
  lgg(lgf paramlgf)
  {
    this.a = new WeakReference(paramlgf);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lgf locallgf = (lgf)this.a.get();
    if (locallgf == null) {
      return;
    }
    lgf.a(locallgf, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgg
 * JD-Core Version:    0.7.0.1
 */