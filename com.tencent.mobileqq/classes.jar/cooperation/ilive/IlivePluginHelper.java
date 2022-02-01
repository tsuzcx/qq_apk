package cooperation.ilive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import mqq.app.AppRuntime;

public class IlivePluginHelper
{
  public static void a(Context paramContext)
  {
    QLog.i("IlivePluginHelper", 1, "Ilive start preloadOdexPlugin");
    IliveShadowImpl.a().enter(paramContext, 1002L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", new Bundle(), new IlivePluginHelper.1());
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, EnterCallback paramEnterCallback)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getExtras();
    } else {
      paramIntent = null;
    }
    Object localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putString("KEY_ACTIVITY_CLASSNAME", paramString);
    ((Bundle)localObject).putLong("start_plugin_act_begin_time", System.currentTimeMillis());
    IliveShadowImpl.a().enter(paramContext, 1003L, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "", (Bundle)localObject, paramEnterCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IlivePluginHelper
 * JD-Core Version:    0.7.0.1
 */