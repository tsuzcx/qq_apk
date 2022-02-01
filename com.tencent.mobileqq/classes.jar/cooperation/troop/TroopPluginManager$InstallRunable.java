package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import blvy;
import bmix;
import bmiy;
import bmiz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bmiz a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bmiz parambmiz, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bmix(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bmiz = parambmiz;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (blvy)((QQAppInterface)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
    } while (localObject == null);
    ((blvy)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bmiy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */