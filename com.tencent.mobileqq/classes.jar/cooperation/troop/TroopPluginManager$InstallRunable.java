package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import bkkq;
import bkxo;
import bkxp;
import bkxq;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bkxq a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bkxq parambkxq, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bkxo(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bkxq = parambkxq;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (bkkq)((QQAppInterface)localObject).getManager(27);
    } while (localObject == null);
    ((bkkq)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bkxp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */