import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import java.lang.ref.WeakReference;

public class jpl
  implements ConditionSearchManager.IConfigListener
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  
  public jpl(jpn paramjpn, ConditionSearchManager paramConditionSearchManager, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.a = new WeakReference(paramjpn);
    this.b = new WeakReference(paramConditionSearchManager);
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ConditionSearchManager)this.b.get();
    if (localObject != null) {
      ((ConditionSearchManager)localObject).d(this);
    }
    localObject = (jpn)this.a.get();
    IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)this.c.get();
    if ((localObject != null) && (localIQQServiceLocationCallback != null)) {
      ((jpn)localObject).a(paramBoolean, localIQQServiceLocationCallback);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jpl
 * JD-Core Version:    0.7.0.1
 */