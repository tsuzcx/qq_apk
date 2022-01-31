package cooperation.troop;

import ajyc;
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
        paramActivity = new Dialog(paramActivity, 2131755791);
        Activity localActivity = paramActivity;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          paramActivity.setCancelable(true);
          paramActivity.setContentView(2131559386);
          paramActivity.show();
          ((TextView)paramActivity.findViewById(2131371557)).setText(ajyc.a(2131715251));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.TroopBaseProxyActivity
 * JD-Core Version:    0.7.0.1
 */