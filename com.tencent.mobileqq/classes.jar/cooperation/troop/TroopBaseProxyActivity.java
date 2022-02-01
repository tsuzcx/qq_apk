package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class TroopBaseProxyActivity
  extends PluginProxyActivity
{
  public static Dialog a(Activity paramActivity)
  {
    try
    {
      paramActivity = new ReportDialog(paramActivity, 2131953338);
      try
      {
        paramActivity.setCancelable(true);
        paramActivity.setContentView(2131625585);
        paramActivity.show();
        ((TextView)paramActivity.findViewById(2131440191)).setText(HardCodeUtil.a(2131912523));
        return paramActivity;
      }
      catch (OutOfMemoryError localOutOfMemoryError1) {}
      if (!QLog.isColorLevel()) {
        return paramActivity;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      paramActivity = null;
    }
    QLog.e("TroopBaseProxyActivity", 2, localOutOfMemoryError2.getStackTrace());
    return paramActivity;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopBaseProxyActivity
 * JD-Core Version:    0.7.0.1
 */