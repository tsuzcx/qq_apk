package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

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
    paramString2 = new IPluginManager.PluginParams(0);
    paramString2.b = "WeiyunPlugin.apk";
    paramString2.e = paramActivity.getResources().getString(2131720662);
    paramString2.jdField_a_of_type_JavaLangString = paramString1;
    paramString2.f = "com.weiyun.plugin.cloudalbum.activity.CloudAlbumActivity";
    paramString2.jdField_a_of_type_JavaLangClass = AlbumBackupProxyActivity.class;
    paramString2.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (paramInt != -1) {
      paramString2.c = paramInt;
    }
    IPluginManager.a(paramActivity, paramString2);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return "WeiyunPlugin.apk";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.AlbumBackupProxyActivity
 * JD-Core Version:    0.7.0.1
 */