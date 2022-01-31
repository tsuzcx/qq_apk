package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import azqs;
import biqn;
import biqw;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    biqw localbiqw = new biqw(1);
    localbiqw.jdField_b_of_type_JavaLangString = paramString1;
    localbiqw.d = paramString2;
    localbiqw.jdField_a_of_type_JavaLangString = paramString4;
    localbiqw.e = paramString3;
    localbiqw.jdField_a_of_type_JavaLangClass = paramClass;
    localbiqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbiqw.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbiqw.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localbiqw.jdField_b_of_type_Int = paramInt;
    localbiqw.c = 10000;
    localbiqw.f = null;
    biqn.a(paramActivity, localbiqw);
    azqs.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return "troop_manage_plugin.apk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopManageProxyActivity
 * JD-Core Version:    0.7.0.1
 */