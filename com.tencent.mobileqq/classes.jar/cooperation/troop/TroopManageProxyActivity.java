package cooperation.troop;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import bcef;
import bkkq;
import bkkz;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    bkkz localbkkz = new bkkz(1);
    localbkkz.jdField_b_of_type_JavaLangString = paramString1;
    localbkkz.d = paramString2;
    localbkkz.jdField_a_of_type_JavaLangString = paramString4;
    localbkkz.e = paramString3;
    localbkkz.jdField_a_of_type_JavaLangClass = paramClass;
    localbkkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbkkz.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbkkz.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localbkkz.jdField_b_of_type_Int = paramInt;
    localbkkz.c = 10000;
    localbkkz.f = null;
    bkkq.a(paramActivity, localbkkz);
    bcef.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
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
    return "troop_manage_plugin.apk";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopManageProxyActivity
 * JD-Core Version:    0.7.0.1
 */