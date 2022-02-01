package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import blfh;
import bmrc;
import bmrd;
import bmre;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bmre a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bmre parambmre, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bmrc(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bmre = parambmre;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (blfh)((QQAppInterface)localObject).getManager(27);
    } while (localObject == null);
    ((blfh)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bmrd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */