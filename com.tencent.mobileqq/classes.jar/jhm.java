import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public class jhm
  extends jhn
{
  public jhm(EffectOperateManager paramEffectOperateManager)
  {
    super(paramEffectOperateManager);
  }
  
  public void run()
  {
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.a.get();
    if (localEffectOperateManager != null) {
      localEffectOperateManager.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhm
 * JD-Core Version:    0.7.0.1
 */