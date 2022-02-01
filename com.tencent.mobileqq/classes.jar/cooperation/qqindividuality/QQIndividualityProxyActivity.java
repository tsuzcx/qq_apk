package cooperation.qqindividuality;

import Override;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import bmgk;
import bmgt;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginInfo;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;

public class QQIndividualityProxyActivity
  extends PluginProxyActivity
{
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog, int paramInt)
  {
    QQIndividualityPluginProxyService.a();
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    bmgt localbmgt = new bmgt(1);
    localbmgt.jdField_b_of_type_JavaLangString = "qqindividuality_plugin.apk";
    localbmgt.d = PluginInfo.m;
    localbmgt.jdField_a_of_type_JavaLangString = paramString1;
    localbmgt.e = paramString2;
    localbmgt.jdField_a_of_type_JavaLangClass = paramClass;
    localbmgt.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbmgt.jdField_b_of_type_Int = paramInt;
    localbmgt.c = 30000;
    localbmgt.f = null;
    localbmgt.jdField_b_of_type_Boolean = false;
    bmgk.a(paramActivity, localbmgt);
    if ((paramString2.equals("com.qqindividuality.activity.QQIndividualitySignatureActivity")) && ((paramActivity instanceof QQIndividualityBridgeActivity)) && (paramDialog != null)) {
      paramActivity.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQIndividuality", 2, "QQIndividualityPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqindividuality.QQIndividualityProxyActivity
 * JD-Core Version:    0.7.0.1
 */