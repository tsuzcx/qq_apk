package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import bimg;
import bjyl;
import bjym;
import bjyn;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bjyn a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bjyn parambjyn, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bjyl(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bjyn = parambjyn;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (bimg)((QQAppInterface)localObject).getManager(27);
    } while (localObject == null);
    ((bimg)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bjym(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */