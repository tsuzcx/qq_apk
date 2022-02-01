package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.troop.troopmemcard.TroopMemCardCmd;

public class TroopMemberCardProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    paramQQAppInterface = new TroopMemCardCmd(paramQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramQQAppInterface);
    }
    paramQQAppInterface = new IPluginManager.PluginParams(1);
    paramQQAppInterface.d = paramString1;
    paramQQAppInterface.g = paramString2;
    paramQQAppInterface.c = paramString4;
    paramQQAppInterface.h = paramString3;
    paramQQAppInterface.i = paramClass;
    paramQQAppInterface.j = paramIntent;
    paramQQAppInterface.l = paramDialog;
    paramQQAppInterface.j.putExtra("userQqResources", 2);
    paramQQAppInterface.j.putExtra("param_plugin_gesturelock", true);
    paramQQAppInterface.j.putExtra("useSkinEngine", true);
    paramQQAppInterface.k = paramInt;
    paramQQAppInterface.r = 10000;
    paramQQAppInterface.q = null;
    IPluginManager.a(paramActivity, paramQQAppInterface);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "load_plugin", 0, 0, null, null, null, null);
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
 * Qualified Name:     cooperation.troop.TroopMemberCardProxyActivity
 * JD-Core Version:    0.7.0.1
 */