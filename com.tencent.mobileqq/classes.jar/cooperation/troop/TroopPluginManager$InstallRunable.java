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
  Handler jdField_a_of_type_AndroidOsHandler = new TroopPluginManager.InstallRunable.1(this, Looper.getMainLooper());
  TroopPluginCallback jdField_a_of_type_ComTencentMobileqqTroopPluginTroopPluginCallback;
  String jdField_a_of_type_JavaLangString;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, TroopPluginCallback paramTroopPluginCallback, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopPluginTroopPluginCallback = paramTroopPluginCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {
      return;
    }
    localObject = (IPluginManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
    if (localObject == null) {
      return;
    }
    ((IPluginManager)localObject).installPlugin(this.jdField_a_of_type_JavaLangString, new TroopPluginManager.InstallRunable.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */