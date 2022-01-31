import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import java.lang.ref.WeakReference;

public class jnx
  implements ConditionSearchManager.IConfigListener
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  
  public jnx(jnz paramjnz, ConditionSearchManager paramConditionSearchManager, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.a = new WeakReference(paramjnz);
    this.b = new WeakReference(paramConditionSearchManager);
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ConditionSearchManager)this.b.get();
    if (localObject != null) {
      ((ConditionSearchManager)localObject).d(this);
    }
    localObject = (jnz)this.a.get();
    IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)this.c.get();
    if ((localObject != null) && (localIQQServiceLocationCallback != null)) {
      ((jnz)localObject).a(paramBoolean, localIQQServiceLocationCallback);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jnx
 * JD-Core Version:    0.7.0.1
 */