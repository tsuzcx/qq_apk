package cooperation.qzone.video;

import amkg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bctn;
import bgkq;
import bgkz;
import bhhr;
import bhhx;
import bhjq;
import bhpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import java.io.File;

public class QzoneVerticalVideoPluginProxyActivity
  extends PluginProxyFragmentActivity
{
  private static final String jdField_a_of_type_JavaLangString = QzoneVerticalVideoPluginProxyActivity.class.getSimpleName();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Class localClass = bhpw.a("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_vertical_video_plugin.apk"))
    {
      localObject = new bgkz(0);
      ((bgkz)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bgkz)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
      ((bgkz)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bgkz)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bgkz)localObject).jdField_b_of_type_Int = paramInt;
      ((bgkz)localObject).c = 15000;
      ((bgkz)localObject).f = null;
      ((bgkz)localObject).jdField_b_of_type_Boolean = false;
      ((bgkz)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
      ((bgkz)localObject).d = "QZoneVerticalVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bgkq.a(paramActivity, (bgkz)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bhjq.a(paramActivity), "qzone_vertical_video_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_vertical_video_plugin.apk");
        }
        localObject = new bhhx(0);
        ((bhhx)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bhhx)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
        ((bhhx)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bhhx)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bhhx)localObject).jdField_b_of_type_Int = paramInt;
        ((bhhx)localObject).c = 15000;
        ((bhhx)localObject).f = null;
        ((bhhx)localObject).jdField_a_of_type_Boolean = false;
        ((bhhx)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
        ((bhhx)localObject).d = "QZoneVerticalVideo";
        bhhr.a(paramActivity, (bhhx)localObject);
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
      }
    }
  }
  
  private static boolean b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public String getPluginID()
  {
    return "qzone_vertical_video_plugin.apk";
  }
  
  public int getPluginResType()
  {
    return 2;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return bhpw.a(paramString);
  }
  
  public int getThemeResId()
  {
    return 0;
  }
  
  public void handleCrash(Bundle paramBundle, Throwable paramThrowable)
  {
    super.handleCrash(paramBundle, paramThrowable);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bctn.a(BaseApplicationImpl.getContext(), false, 5);
    amkg.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    amkg.a(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */