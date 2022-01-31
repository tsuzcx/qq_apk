package cooperation.troop;

import alpo;
import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class TroopBaseProxyActivity
  extends PluginProxyActivity
{
  public static Dialog a(Activity paramActivity)
  {
    do
    {
      try
      {
        paramActivity = new Dialog(paramActivity, 2131755801);
        Activity localActivity = paramActivity;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          paramActivity.setCancelable(true);
          paramActivity.setContentView(2131559438);
          paramActivity.show();
          ((TextView)paramActivity.findViewById(2131371874)).setText(alpo.a(2131715634));
          localActivity = paramActivity;
          return localActivity;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          continue;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        paramActivity = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopBaseProxyActivity", 2, localOutOfMemoryError1.getStackTrace());
    return paramActivity;
  }
  
  public String getPluginID()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopBaseProxyActivity
 * JD-Core Version:    0.7.0.1
 */