import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public class jfy
  extends jfz
{
  public jfy(EffectOperateManager paramEffectOperateManager)
  {
    super(paramEffectOperateManager);
  }
  
  public void run()
  {
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.a.get();
    if (localEffectOperateManager != null) {
      localEffectOperateManager.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfy
 * JD-Core Version:    0.7.0.1
 */