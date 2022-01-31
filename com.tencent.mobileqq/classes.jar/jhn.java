import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public abstract class jhn
  implements Runnable
{
  WeakReference a;
  
  public jhn(EffectOperateManager paramEffectOperateManager)
  {
    this.a = new WeakReference(paramEffectOperateManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhn
 * JD-Core Version:    0.7.0.1
 */