package cooperation.qzone.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import bfcz;
import bfdi;
import bfzg;
import bfzm;
import bgbf;
import bgha;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QzoneLiveVideoPluginProxyActivity
  extends PluginProxyActivity
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.qzone.adapter.livevideo.RewardGiftActivity", "com.qzonex.module.global.FeedActionPanelActivity", "com.qzone.adapter.livevideo.LiveCommonActivity" };
  Object jdField_a_of_type_JavaLangObject = null;
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, int paramInt, String paramString2)
  {
    Class localClass = bgha.a(paramString2);
    paramIntent.putExtra("userQqResources", -1);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("param_plugin_gesturelock", false);
    Object localObject = bgbf.a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
    }
    for (;;)
    {
      return;
      if (((String)localObject).equals("qzone_live_video_plugin_hack.apk")) {
        if (new File(bgbf.a(paramActivity), (String)localObject).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "launchPluginActivityForResult 加载动态包:hackPluginID:" + (String)localObject);
          }
          localObject = new bfzm(0);
          ((bfzm)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((bfzm)localObject).e = paramString2;
          ((bfzm)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((bfzm)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((bfzm)localObject).jdField_b_of_type_Int = paramInt;
          ((bfzm)localObject).c = 15000;
          ((bfzm)localObject).f = null;
          ((bfzm)localObject).jdField_a_of_type_Boolean = false;
          ((bfzm)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin_hack.apk";
          ((bfzm)localObject).d = "QZoneLiveVideo";
          bfzg.a(paramActivity, (bfzm)localObject);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("PluginDebug", 2, "QzoneLiveVideoPluginProxyActivity.launchPluingActivityForResult");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("PluginDebug", 2, "launchPluginActivityForResult 加载动态包不存在");
          continue;
          if (!"qzone_live_video_plugin.apk".equals(localObject)) {
            break label355;
          }
          localObject = new bfdi(0);
          ((bfdi)localObject).jdField_a_of_type_JavaLangString = paramString1;
          ((bfdi)localObject).e = paramString2;
          ((bfdi)localObject).jdField_a_of_type_JavaLangClass = localClass;
          ((bfdi)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
          ((bfdi)localObject).jdField_b_of_type_Int = paramInt;
          ((bfdi)localObject).c = 15000;
          ((bfdi)localObject).f = null;
          ((bfdi)localObject).jdField_b_of_type_Boolean = false;
          ((bfdi)localObject).jdField_b_of_type_JavaLangString = "qzone_live_video_plugin.apk";
          ((bfdi)localObject).d = "QZoneLiveVideo";
          if (QLog.isColorLevel()) {
            QLog.d("PluginDebug", 2, "加载原始插件");
          }
          bfcz.a(paramActivity, (bfdi)localObject);
        }
      }
    }
    label355:
    QLog.e("PluginDebug", 1, "启动失败 错误的pluginid=" + (String)localObject);
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
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return bgha.a(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void requestPermissions(Object paramObject, int paramInt, String... paramVarArgs)
  {
    super.requestPermissions(paramObject, paramInt, paramVarArgs);
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */