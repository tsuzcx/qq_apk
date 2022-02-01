package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import cooperation.plugin.IPluginManager;
import java.lang.ref.WeakReference;

class TroopPluginManager$InstallRunable
  implements Runnable
{
  TroopPluginCallback a;
  String b;
  Handler c = new TroopPluginManager.InstallRunable.1(this, Looper.getMainLooper());
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, TroopPluginCallback paramTroopPluginCallback, String paramString)
  {
    this.a = paramTroopPluginCallback;
    this.b = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.b.get();
    if (localObject == null) {
      return;
    }
    localObject = (IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
    if (localObject == null) {
      return;
    }
    ((IPluginManager)localObject).installPlugin(this.b, new TroopPluginManager.InstallRunable.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */