package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import axqy;
import bglh;
import bglq;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    bglq localbglq = new bglq(1);
    localbglq.jdField_b_of_type_JavaLangString = paramString1;
    localbglq.d = paramString2;
    localbglq.jdField_a_of_type_JavaLangString = paramString4;
    localbglq.e = paramString3;
    localbglq.jdField_a_of_type_JavaLangClass = paramClass;
    localbglq.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbglq.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbglq.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localbglq.jdField_b_of_type_Int = paramInt;
    localbglq.c = 10000;
    localbglq.f = null;
    bglh.a(paramActivity, localbglq);
    axqy.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
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