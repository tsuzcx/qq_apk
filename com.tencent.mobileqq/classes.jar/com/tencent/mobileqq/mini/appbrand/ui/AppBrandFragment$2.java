package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import org.json.JSONObject;

class AppBrandFragment$2
  implements ComponentCallbacks2
{
  AppBrandFragment$2(AppBrandFragment paramAppBrandFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("level", paramInt);
      if ((this.this$0.miniConfig != null) && (this.this$0.miniConfig.config != null))
      {
        AppBrandRuntime localAppBrandRuntime = this.this$0.appBrandRuntimeContainer.getAppBrandRunTime(this.this$0.miniConfig.config);
        if (localAppBrandRuntime != null) {
          localAppBrandRuntime.evaluateServiceSubcribeJS("onMemoryWarning", localJSONObject.toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandFragment.2
 * JD-Core Version:    0.7.0.1
 */