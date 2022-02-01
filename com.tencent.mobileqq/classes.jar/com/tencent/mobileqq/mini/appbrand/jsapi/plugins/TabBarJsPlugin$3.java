package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.TabBarView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class TabBarJsPlugin$3
  implements Runnable
{
  TabBarJsPlugin$3(TabBarJsPlugin paramTabBarJsPlugin, WeakReference paramWeakReference, JSONObject paramJSONObject) {}
  
  public void run()
  {
    TabBarView localTabBarView = (TabBarView)this.val$tabBarViewRef.get();
    if (localTabBarView != null) {
      localTabBarView.setTabBarStyle(this.val$params.optString("color"), this.val$params.optString("selectedColor"), this.val$params.optString("backgroundColor"), this.val$params.optString("borderStyle", "black"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */