package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import awqx;
import bfcz;
import bfdi;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    bfdi localbfdi = new bfdi(1);
    localbfdi.jdField_b_of_type_JavaLangString = paramString1;
    localbfdi.d = paramString2;
    localbfdi.jdField_a_of_type_JavaLangString = paramString4;
    localbfdi.e = paramString3;
    localbfdi.jdField_a_of_type_JavaLangClass = paramClass;
    localbfdi.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbfdi.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbfdi.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localbfdi.jdField_b_of_type_Int = paramInt;
    localbfdi.c = 10000;
    localbfdi.f = null;
    bfcz.a(paramActivity, localbfdi);
    awqx.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
  }
  
  public String getPluginID()
  {
    return "troop_manage_plugin.apk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop.TroopManageProxyActivity
 * JD-Core Version:    0.7.0.1
 */