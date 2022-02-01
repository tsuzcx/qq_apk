package cooperation.qzone;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.ITranslucentActivityProxy;
import java.lang.reflect.Field;
import mqq.app.AndroidOreoUtils;

public class TranslucentActivity
  extends Activity
{
  public static int getStatusHeight(Activity paramActivity)
  {
    Object localObject1 = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    int i = j;
    if (j == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i = paramActivity.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (Exception paramActivity) {}
    return j;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return ((ITranslucentActivityProxy)QRoute.api(ITranslucentActivityProxy.class)).getSharedPreferences(paramString, paramInt);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = new AndroidOreoUtils(this);
    if ((Build.VERSION.SDK_INT == 26) && (getApplicationInfo().targetSdkVersion >= 27) && (((AndroidOreoUtils)localObject).isTranslucentOrFloating()))
    {
      boolean bool = ((AndroidOreoUtils)localObject).fixOrientation();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate fixOrientation when Oreo, result = ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("TranslucentActivity", 1, ((StringBuilder)localObject).toString());
    }
    super.onCreate(paramBundle);
    paramBundle = super.getIntent();
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.getActivityNameToIntent(paramBundle)))
    {
      ((ITranslucentActivityProxy)QRoute.api(ITranslucentActivityProxy.class)).startPlugin(paramBundle, this);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */