package cooperation.qzone.video;

import amkf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bcuc;
import bglh;
import bglq;
import bhii;
import bhio;
import bhkh;
import bhqn;
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
    Class localClass = bhqn.a("com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity");
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject;
    if (QzoneVerticalVideoDownloadActivity.useLocalPlugin("qzone_vertical_video_plugin.apk"))
    {
      localObject = new bglq(0);
      ((bglq)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((bglq)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
      ((bglq)localObject).jdField_a_of_type_JavaLangClass = localClass;
      ((bglq)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((bglq)localObject).jdField_b_of_type_Int = paramInt;
      ((bglq)localObject).c = 15000;
      ((bglq)localObject).f = null;
      ((bglq)localObject).jdField_b_of_type_Boolean = false;
      ((bglq)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
      ((bglq)localObject).d = "QZoneVerticalVideo";
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "加载原始插件");
      }
      bglh.a(paramActivity, (bglq)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginDebug", 2, "QzoneVerticalVideoPluginProxyActivity.launchPluginActivityForResult");
      }
      return;
      if (new File(bhkh.a(paramActivity), "qzone_vertical_video_plugin.apk").exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:qzone_vertical_video_plugin.apk");
        }
        localObject = new bhio(0);
        ((bhio)localObject).jdField_a_of_type_JavaLangString = paramString;
        ((bhio)localObject).e = "com.qzone.commoncode.module.verticalvideo.VerticalVideoLayerActivity";
        ((bhio)localObject).jdField_a_of_type_JavaLangClass = localClass;
        ((bhio)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
        ((bhio)localObject).jdField_b_of_type_Int = paramInt;
        ((bhio)localObject).c = 15000;
        ((bhio)localObject).f = null;
        ((bhio)localObject).jdField_a_of_type_Boolean = false;
        ((bhio)localObject).jdField_b_of_type_JavaLangString = "qzone_vertical_video_plugin.apk";
        ((bhio)localObject).d = "QZoneVerticalVideo";
        bhii.a(paramActivity, (bhio)localObject);
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
    return bhqn.a(paramString);
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
    bcuc.a(BaseApplicationImpl.getContext(), false, 5);
    amkf.a(BaseApplicationImpl.getContext(), 2, false);
  }
  
  public void onDestroy()
  {
    amkf.a(BaseApplicationImpl.getContext(), 2, true);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */