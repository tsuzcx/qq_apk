import com.tencent.av.ui.EffectToolbar;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class mfy
  implements Observer
{
  private WeakReference<EffectToolbar> a;
  
  public mfy(EffectToolbar paramEffectToolbar)
  {
    this.a = new WeakReference(paramEffectToolbar);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    EffectToolbar localEffectToolbar = (EffectToolbar)this.a.get();
    if (localEffectToolbar == null) {
      return;
    }
    EffectToolbar.access$300(localEffectToolbar, paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfy
 * JD-Core Version:    0.7.0.1
 */