package com.tencent.qqmini.proxyimpl;

import amgn;
import behq;
import bekr;
import bekz;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class ColorNotePlugin
  extends BaseJsPlugin
{
  private static final String TAG = "ColorNotePlugin";
  
  private void addColorSign(boolean paramBoolean)
  {
    if (this.mMiniAppInfo.isLimitedAccessApp()) {}
    Object localObject1;
    for (;;)
    {
      return;
      Object localObject2 = null;
      if (this.mIsMiniGame)
      {
        localObject1 = localObject2;
        if (this.mMiniAppContext.a() != null)
        {
          localObject1 = localObject2;
          if ((this.mMiniAppContext.a() instanceof GameActivity1)) {
            localObject1 = ((GameActivity1)this.mMiniAppContext.a()).getColorNoteController();
          }
        }
      }
      while ((localObject1 != null) && (!((amgn)localObject1).c()))
      {
        if (!((amgn)localObject1).b()) {
          break label168;
        }
        if (!paramBoolean) {
          break label155;
        }
        bekz.a(new ColorNotePlugin.1(this, (amgn)localObject1));
        return;
        localObject1 = localObject2;
        if (this.mMiniAppContext.a() != null)
        {
          localObject1 = localObject2;
          if ((this.mMiniAppContext.a() instanceof AppBrandUI)) {
            localObject1 = ((AppBrandUI)this.mMiniAppContext.a()).getColorNoteController();
          }
        }
      }
    }
    label155:
    bekz.a(new ColorNotePlugin.2(this, (amgn)localObject1));
    return;
    label168:
    bekz.a(new ColorNotePlugin.3(this, (amgn)localObject1));
  }
  
  public void addColorSign(bekr parambekr)
  {
    parambekr.a();
    addColorSign(false);
  }
  
  public void addColorSignDirectly(bekr parambekr)
  {
    parambekr.a();
    addColorSign(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin
 * JD-Core Version:    0.7.0.1
 */