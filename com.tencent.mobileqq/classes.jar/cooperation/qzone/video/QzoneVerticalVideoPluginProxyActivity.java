package cooperation.qzone.video;

import aluq;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bbqo;
import bfcz;
import bfdi;
import bfzg;
import bfzm;
import bgbf;
import bghc;
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
    Class localClass = bghc.a("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_vertical_video_plugin.apk"))
    {
      localObject = new bfdi(0);
      ((bfdi)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bfdi)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
      ((bfdi)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bfdi)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bfdi)localObject).jdField_b_of_type_Int = paramInt;
      ((bfdi)localObject).c = 15000;
      ((bfdi)localObject).f = null;
      ((bfdi)localObject).jdField_b_of_type_Boolean = false;
      ((bfdi)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
      ((bfdi)localObject).d = "QZoneVerticalVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bfcz.a(paramActivity, (bfdi)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bgbf.a(paramActivity), "qzone_vertical_video_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_vertical_video_plugin.apk");
        }
        localObject = new bfzm(0);
        ((bfzm)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bfzm)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
        ((bfzm)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bfzm)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bfzm)localObject).jdField_b_of_type_Int = paramInt;
        ((bfzm)localObject).c = 15000;
        ((bfzm)localObject).f = null;
        ((bfzm)localObject).jdField_a_of_type_Boolean = false;
        ((bfzm)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
        ((bfzm)localObject).d = "QZoneVerticalVideo";
        bfzg.a(paramActivity, (bfzm)localObject);
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
    return bghc.a(paramString);
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
    bbqo.a(BaseApplicationImpl.getContext(), false, 5);
    aluq.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    aluq.a(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */