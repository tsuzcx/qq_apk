import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual.IBuilder;

public class pws
  implements PTSNodeVirtual.IBuilder<pwq>
{
  public pwq a(PTSAppInstance paramPTSAppInstance)
  {
    return new pwq(paramPTSAppInstance, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pws
 * JD-Core Version:    0.7.0.1
 */