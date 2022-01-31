import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import java.lang.ref.WeakReference;

public class jni
  implements ConditionSearchManager.IConfigListener
{
  private WeakReference a;
  private WeakReference b;
  private WeakReference c;
  
  public jni(jnk paramjnk, ConditionSearchManager paramConditionSearchManager, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.a = new WeakReference(paramjnk);
    this.b = new WeakReference(paramConditionSearchManager);
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ConditionSearchManager)this.b.get();
    if (localObject != null) {
      ((ConditionSearchManager)localObject).d(this);
    }
    localObject = (jnk)this.a.get();
    IQQServiceLocationCallback localIQQServiceLocationCallback = (IQQServiceLocationCallback)this.c.get();
    if ((localObject != null) && (localIQQServiceLocationCallback != null)) {
      ((jnk)localObject).a(paramBoolean, localIQQServiceLocationCallback);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    this.c = new WeakReference(paramIQQServiceLocationCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jni
 * JD-Core Version:    0.7.0.1
 */