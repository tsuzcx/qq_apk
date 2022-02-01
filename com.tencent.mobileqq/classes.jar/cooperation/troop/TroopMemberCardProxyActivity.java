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
import bkxr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopMemberCardProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    paramQQAppInterface = new bkxr(paramQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramQQAppInterface);
    }
    paramQQAppInterface = new bkkz(1);
    paramQQAppInterface.jdField_b_of_type_JavaLangString = paramString1;
    paramQQAppInterface.d = paramString2;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString4;
    paramQQAppInterface.e = paramString3;
    paramQQAppInterface.jdField_a_of_type_JavaLangClass = paramClass;
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent = paramIntent;
    paramQQAppInterface.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent.putExtra("userQqResources", 2);
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent.putExtra("param_plugin_gesturelock", true);
    paramQQAppInterface.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    paramQQAppInterface.jdField_b_of_type_Int = paramInt;
    paramQQAppInterface.c = 10000;
    paramQQAppInterface.f = null;
    bkkq.a(paramActivity, paramQQAppInterface);
    bcef.b(null, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "load_plugin", 0, 0, null, null, null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopMemberCardProxyActivity
 * JD-Core Version:    0.7.0.1
 */