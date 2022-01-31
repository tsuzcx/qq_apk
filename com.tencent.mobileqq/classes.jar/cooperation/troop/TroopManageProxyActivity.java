package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import axqw;
import bgkq;
import bgkz;

public class TroopManageProxyActivity
  extends TroopBaseProxyActivity
{
  public static void a(String paramString1, String paramString2, Class paramClass, Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString3, String paramString4, int paramInt)
  {
    bgkz localbgkz = new bgkz(1);
    localbgkz.jdField_b_of_type_JavaLangString = paramString1;
    localbgkz.d = paramString2;
    localbgkz.jdField_a_of_type_JavaLangString = paramString4;
    localbgkz.e = paramString3;
    localbgkz.jdField_a_of_type_JavaLangClass = paramClass;
    localbgkz.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbgkz.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbgkz.jdField_a_of_type_AndroidContentIntent.putExtra("useSkinEngine", true);
    localbgkz.jdField_b_of_type_Int = paramInt;
    localbgkz.c = 10000;
    localbgkz.f = null;
    bgkq.a(paramActivity, localbgkz);
    axqw.b(null, "P_CliOper", "BizTechReport", "", "troop_manage_plugin", "load_plugin_v2", 0, 0, null, null, null, null);
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