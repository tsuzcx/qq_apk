package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.graphics.Bitmap;
import com.tencent.mobileqq.mini.widget.TabBarView;
import java.lang.ref.WeakReference;

class TabBarJsPlugin$4
  implements Runnable
{
  TabBarJsPlugin$4(TabBarJsPlugin paramTabBarJsPlugin, WeakReference paramWeakReference, int paramInt, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public void run()
  {
    TabBarView localTabBarView = (TabBarView)this.val$tabBarViewRef.get();
    if (localTabBarView != null) {
      localTabBarView.setTabBarItem(this.val$index, this.val$text, this.val$iconBitmap, this.val$selectedIconBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.TabBarJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */