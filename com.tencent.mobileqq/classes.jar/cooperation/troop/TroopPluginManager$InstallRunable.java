package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import bmgk;
import bnsh;
import bnsi;
import bnsj;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bnsj a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bnsj parambnsj, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bnsh(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bnsj = parambnsj;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (bmgk)((QQAppInterface)localObject).getManager(27);
    } while (localObject == null);
    ((bmgk)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bnsi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */