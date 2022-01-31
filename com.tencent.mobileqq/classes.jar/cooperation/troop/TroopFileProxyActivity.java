package cooperation.troop;

import alpo;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import bimg;
import bimp;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import java.util.ArrayList;

public class TroopFileProxyActivity
  extends TroopBaseProxyActivity
{
  public static String a;
  public static ArrayList<FileInfo> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaLangString = "key_qun_id";
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, String paramString)
  {
    a(paramActivity, paramIntent, null, "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", paramString, paramInt);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, String paramString2, int paramInt)
  {
    bimp localbimp = new bimp(0);
    localbimp.jdField_b_of_type_JavaLangString = "troop_plugin.apk";
    localbimp.d = alpo.a(2131715713);
    localbimp.jdField_a_of_type_JavaLangString = paramString2;
    localbimp.e = paramString1;
    localbimp.jdField_a_of_type_JavaLangClass = TroopFileProxyActivity.class;
    localbimp.jdField_a_of_type_AndroidContentIntent = paramIntent;
    localbimp.jdField_a_of_type_AndroidAppDialog = paramDialog;
    paramIntent.putExtra("userQqResources", 1);
    paramIntent.putExtra("param_plugin_gesturelock", true);
    localbimp.jdField_b_of_type_Int = paramInt;
    localbimp.c = 10000;
    localbimp.f = null;
    bimg.a(paramActivity, localbimp);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, null, "com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity", paramString, 0);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileUploadActivity", paramString, 0);
  }
  
  public static void c(Activity paramActivity, Intent paramIntent, String paramString)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.troop.activity.TroopFileSearchByTypeActivity", paramString, 0);
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return TroopFileProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop.TroopFileProxyActivity
 * JD-Core Version:    0.7.0.1
 */