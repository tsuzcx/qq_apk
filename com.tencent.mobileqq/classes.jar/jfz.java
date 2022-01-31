import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public abstract class jfz
  implements Runnable
{
  WeakReference a;
  
  public jfz(EffectOperateManager paramEffectOperateManager)
  {
    this.a = new WeakReference(paramEffectOperateManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfz
 * JD-Core Version:    0.7.0.1
 */