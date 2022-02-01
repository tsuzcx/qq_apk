package cooperation.troop;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import cooperation.plugin.IPluginManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;

class TroopPluginManager$1
  implements Runnable
{
  TroopPluginManager$1(TroopPluginManager paramTroopPluginManager, String paramString, TroopPluginCallback paramTroopPluginCallback) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.b.get();
    if (localObject == null) {
      return;
    }
    if (((IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled(this.a))
    {
      localObject = this.this$0.d.obtainMessage(1001);
      ((Message)localObject).obj = this.b;
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      return;
    }
    if (this.this$0.c.contains(this.a))
    {
      localObject = this.this$0.d.obtainMessage(1001);
      ((Message)localObject).obj = this.b;
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).sendToTarget();
    }
    this.this$0.c.add(this.a);
    ThreadManager.post(new TroopPluginManager.InstallRunable(this.this$0, this.b, this.a), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.1
 * JD-Core Version:    0.7.0.1
 */