import com.tencent.av.business.manager.EffectOperateManager;
import java.lang.ref.WeakReference;

public class jfh
  extends jfk
{
  public jfh(EffectOperateManager paramEffectOperateManager)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfh
 * JD-Core Version:    0.7.0.1
 */