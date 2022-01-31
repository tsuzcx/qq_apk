import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public abstract class jfk
  implements Runnable
{
  WeakReference a;
  
  public jfk(EffectOperateManager paramEffectOperateManager)
  {
    this.a = new WeakReference(paramEffectOperateManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfk
 * JD-Core Version:    0.7.0.1
 */