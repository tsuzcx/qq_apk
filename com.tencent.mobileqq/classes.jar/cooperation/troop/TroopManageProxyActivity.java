package cooperation.troop;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import bdla;
import blvy;
import blwh;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    blwh localblwh = new blwh(1);
    localblwh.jdField_b_of_type_JavaLangString = paramString1;
    localblwh.d = paramString2;
    localblwh.jdField_a_of_type_JavaLangString = paramString4;
    localblwh.e = paramString3;
    localblwh.jdField_a_of_type_JavaLangClass = paramClass;
    localblwh.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localblwh.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localblwh.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localblwh.jdField_b_of_type_Int = paramInt;
    localblwh.c = 10000;
    localblwh.f = null;
    blvy.a(paramActivity, localblwh);
    bdla.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
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