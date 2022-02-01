package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.plugin.IPluginManager;
import java.lang.ref.WeakReference;

class TroopPluginManager$InstallRunable
  implements Runnable
{
  Handler jdField_a_of_type_AndroidOsHandler = new TroopPluginManager.InstallRunable.1(this, Looper.getMainLooper());
  TroopPluginManager.TroopPluginCallback jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback;
  String jdField_a_of_type_JavaLangString;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, TroopPluginManager.TroopPluginCallback paramTroopPluginCallback, String paramString)
  {
    this.jdField_a_of_type_CooperationTroopTroopPluginManager$TroopPluginCallback = paramTroopPluginCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
    } while (localObject == null);
    ((IPluginManager)localObject).installPlugin(this.jdField_a_of_type_JavaLangString, new TroopPluginManager.InstallRunable.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */