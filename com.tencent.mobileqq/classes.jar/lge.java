import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class lge
  implements Observer
{
  private WeakReference<lgd> a;
  
  lge(lgd paramlgd)
  {
    this.a = new WeakReference(paramlgd);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    lgd locallgd = (lgd)this.a.get();
    if (locallgd == null) {
      return;
    }
    lgd.a(locallgd, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lge
 * JD-Core Version:    0.7.0.1
 */