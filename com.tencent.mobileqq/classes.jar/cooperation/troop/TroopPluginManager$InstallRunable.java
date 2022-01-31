package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import bfcz;
import bgnr;
import bgns;
import bgnt;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopPluginManager$InstallRunable
  implements Runnable
{
  public Handler a;
  public bgnt a;
  public String a;
  
  public TroopPluginManager$InstallRunable(TroopPluginManager paramTroopPluginManager, bgnt parambgnt, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new bgnr(this, Looper.getMainLooper());
    this.jdField_a_of_type_Bgnt = parambgnt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.this$0.a.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = (bfcz)((QQAppInterface)localObject).getManager(27);
    } while (localObject == null);
    ((bfcz)localObject).a(this.jdField_a_of_type_JavaLangString, false, new bgns(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.InstallRunable
 * JD-Core Version:    0.7.0.1
 */