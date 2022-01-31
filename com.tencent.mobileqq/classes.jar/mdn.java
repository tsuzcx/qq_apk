import com.tencent.av.ui.EffectToolbar;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

public class mdn
  implements Observer
{
  private WeakReference<EffectToolbar> a;
  
  public mdn(EffectToolbar paramEffectToolbar)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdn
 * JD-Core Version:    0.7.0.1
 */