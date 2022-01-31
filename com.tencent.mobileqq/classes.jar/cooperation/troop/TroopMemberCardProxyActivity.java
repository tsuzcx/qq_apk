package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import azmj;
import bimg;
import bimp;
import bjyo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class TroopMemberCardProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    paramQQAppInterface = new bjyo(paramQQAppInterface);
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(paramQQAppInterface);
    }
    paramQQAppInterface = new bimp(1);
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
    bimg.a(paramActivity, paramQQAppInterface);
    azmj.b(null, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "load_plugin", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopMemberCardProxyActivity
 * JD-Core Version:    0.7.0.1
 */