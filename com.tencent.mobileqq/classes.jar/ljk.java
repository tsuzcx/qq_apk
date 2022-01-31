import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

class ljk
  implements Observer
{
  private WeakReference<ljj> a;
  
  public ljk(ljj paramljj)
  {
    this.a = new WeakReference(paramljj);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    ljj localljj = (ljj)this.a.get();
    if (localljj == null) {
      return;
    }
    ljj.a(localljj, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljk
 * JD-Core Version:    0.7.0.1
 */