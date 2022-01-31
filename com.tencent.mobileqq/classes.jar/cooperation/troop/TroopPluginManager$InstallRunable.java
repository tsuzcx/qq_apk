package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import biqn;
import bkcs;
import bkct;
import bkcu;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bkcu a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bkcu parambkcu, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bkcs(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bkcu = parambkcu;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (biqn)((QQAppInterface)localObject).getManager(27);
    } while (localObject == null);
    ((biqn)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bkct(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */