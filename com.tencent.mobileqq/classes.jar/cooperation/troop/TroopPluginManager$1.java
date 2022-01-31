package cooperation.troop;

import android.os.Handler;
import android.os.Message;
import biqn;
import bkcu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;

class TroopPluginManager$1
  implements Runnable
{
  TroopPluginManager$1(TroopPluginManager paramTroopPluginManager, String paramString, bkcu parambkcu) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    if (((biqn)((QQAppInterface)localObject).getManager(27)).isPlugininstalled(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      ((Message)localObject).obj = this.jdField_a_of_type_Bkcu;
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).sendToTarget();
      return;
    }
    if (this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(this.jdField_a_of_type_JavaLangString))
    {
      localObject = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1001);
      ((Message)localObject).obj = this.jdField_a_of_type_Bkcu;
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).sendToTarget();
    }
    this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(this.jdField_a_of_type_JavaLangString);
    ThreadManager.post(new TroopPluginManager.InstallRunable(this.this$0, this.jdField_a_of_type_Bkcu, this.jdField_a_of_type_JavaLangString), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.1
 * JD-Core Version:    0.7.0.1
 */