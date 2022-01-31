import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectConfigBase.ItemBase;
import java.lang.ref.WeakReference;

public class jff
  extends Handler
{
  WeakReference a;
  
  public jff(EffectConfigBase paramEffectConfigBase)
  {
    this.a = new WeakReference(paramEffectConfigBase);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    EffectConfigBase localEffectConfigBase;
    if (this.a.get() != null) {
      localEffectConfigBase = (EffectConfigBase)this.a.get();
    }
    switch (paramMessage.what)
    {
    default: 
      localEffectConfigBase.a(paramMessage);
      return;
    case 0: 
      EffectConfigBase.a(localEffectConfigBase, (EffectConfigBase.ItemBase)paramMessage.obj);
      return;
    case 1: 
      EffectConfigBase.ItemBase localItemBase = (EffectConfigBase.ItemBase)paramMessage.obj;
      if (paramMessage.arg1 == 1) {}
      for (;;)
      {
        EffectConfigBase.a(localEffectConfigBase, localItemBase, bool);
        return;
        bool = false;
      }
    }
    EffectConfigBase.a(localEffectConfigBase, (EffectConfigBase.ItemBase)paramMessage.obj, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jff
 * JD-Core Version:    0.7.0.1
 */