package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.Manager;

public class TroopPluginManager
  implements Manager
{
  public static final String a = "cooperation.troop.TroopPluginManager";
  Handler a;
  protected WeakReference<QQAppInterface> a;
  public ConcurrentLinkedQueue<String> a;
  
  public TroopPluginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_AndroidOsHandler = new TroopPluginManager.2(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, TroopPluginCallback paramTroopPluginCallback)
  {
    ThreadManager.post(new TroopPluginManager.1(this, paramString, paramTroopPluginCallback), 8, null, true);
    return false;
  }
  
  public void onDestroy()
  {
    Object localObject = PluginCommunicationHandler.getInstance();
    if (localObject != null)
    {
      ((PluginCommunicationHandler)localObject).unregister("troop.troopmemcard.get_app_interface_data");
      ((PluginCommunicationHandler)localObject).unregister("troop.manage.get_app_interface_data");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager
 * JD-Core Version:    0.7.0.1
 */