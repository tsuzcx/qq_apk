package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import bimg;
import bimp;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class AlbumBackupProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    a(paramActivity, paramString1, paramString2, -1);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(536870912);
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("weiyun_backup_source", paramString2);
    paramString2 = new bimp(0);
    paramString2.jdField_b_of_type_JavaLangString = "WeiyunPlugin.apk";
    paramString2.d = paramActivity.getResources().getString(2131721427);
    paramString2.jdField_a_of_type_JavaLangString = paramString1;
    paramString2.e = "com.weiyun.plugin.cloudalbum.activity.CloudAlbumActivity";
    paramString2.jdField_a_of_type_JavaLangClass = AlbumBackupProxyActivity.class;
    paramString2.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (paramInt != -1) {
      paramString2.jdField_b_of_type_Int = paramInt;
    }
    bimg.a(paramActivity, paramString2);
  }
  
  public String getPluginID()
  {
    return "WeiyunPlugin.apk";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupProxyActivity
 * JD-Core Version:    0.7.0.1
 */