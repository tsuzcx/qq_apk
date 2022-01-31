package cooperation.troop;

import amoz;
import ampa;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.Manager;

public class TroopPluginManager
  implements Manager
{
  public static final String a;
  public Handler a;
  public WeakReference a;
  public ConcurrentLinkedQueue a;
  
  static
  {
    jdField_a_of_type_JavaLangString = TroopPluginManager.class.getName();
  }
  
  public TroopPluginManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_AndroidOsHandler = new ampa(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public boolean a(String paramString, TroopPluginManager.TroopPluginCallback paramTroopPluginCallback)
  {
    ThreadManager.post(new amoz(this, paramString, paramTroopPluginCallback), 8, null, true);
    return false;
  }
  
  public void onDestroy()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null)
    {
      localPluginCommunicationHandler.unregister("troop.troopmemcard.get_app_interface_data");
      localPluginCommunicationHandler.unregister("troop.manage.get_app_interface_data");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager
 * JD-Core Version:    0.7.0.1
 */