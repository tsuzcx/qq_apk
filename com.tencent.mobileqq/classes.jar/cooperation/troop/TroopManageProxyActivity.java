package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import azmj;
import bimg;
import bimp;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    bimp localbimp = new bimp(1);
    localbimp.jdField_b_of_type_JavaLangString = paramString1;
    localbimp.d = paramString2;
    localbimp.jdField_a_of_type_JavaLangString = paramString4;
    localbimp.e = paramString3;
    localbimp.jdField_a_of_type_JavaLangClass = paramClass;
    localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbimp.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbimp.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localbimp.jdField_b_of_type_Int = paramInt;
    localbimp.c = 10000;
    localbimp.f = null;
    bimg.a(paramActivity, localbimp);
    azmj.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
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