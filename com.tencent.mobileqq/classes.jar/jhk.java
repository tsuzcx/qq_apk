import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public class jhk
  extends jhn
{
  public jhk(EffectOperateManager paramEffectOperateManager)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhk
 * JD-Core Version:    0.7.0.1
 */