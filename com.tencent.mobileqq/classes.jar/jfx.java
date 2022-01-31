import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public class jfx
  extends jfz
{
  public jfx(EffectOperateManager paramEffectOperateManager)
  {
    super(paramEffectOperateManager);
  }
  
  public void run()
  {
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.a.get();
    if (localEffectOperateManager != null) {
      localEffectOperateManager.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfx
 * JD-Core Version:    0.7.0.1
 */