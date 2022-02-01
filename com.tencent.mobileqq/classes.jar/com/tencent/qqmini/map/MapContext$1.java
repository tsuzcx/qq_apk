package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.action.CheckLocationAction.CheckLocationPermissionCallback;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

class MapContext$1
  implements CheckLocationAction.CheckLocationPermissionCallback
{
  MapContext$1(MapContext paramMapContext) {}
  
  public void onCheckLocationPermissionAction(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(MapContext.access$000(this.this$0).getAttachedActivity(), "wgs84", true, new MapContext.1.1(this));
    }
    MapContext.access$802(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.MapContext.1
 * JD-Core Version:    0.7.0.1
 */