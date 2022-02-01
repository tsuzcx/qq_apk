import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lgs
  implements Observer
{
  private WeakReference<lgr> a;
  
  lgs(lgr paramlgr)
  {
    this.a = new WeakReference(paramlgr);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lgr locallgr = (lgr)this.a.get();
    if (locallgr == null) {
      return;
    }
    lgr.a(locallgr, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgs
 * JD-Core Version:    0.7.0.1
 */