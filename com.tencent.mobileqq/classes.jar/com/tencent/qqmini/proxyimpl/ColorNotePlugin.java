package com.tencent.qqmini.proxyimpl;

import alrv;
import bdcz;
import bdfz;
import bdgi;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class ColorNotePlugin
  extends BaseJsPlugin
{
  private static final String TAG = "ColorNotePlugin";
  
  private void addColorSign(boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
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
    for (;;)
    {
      if ((localObject1 != null) && (!((alrv)localObject1).c()))
      {
        if (!((alrv)localObject1).b()) {
          break label157;
        }
        if (!paramBoolean) {
          break;
        }
        bdgi.a(new ColorNotePlugin.1(this, (alrv)localObject1));
      }
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
    bdgi.a(new ColorNotePlugin.2(this, (alrv)localObject1));
    return;
    label157:
    bdgi.a(new ColorNotePlugin.3(this, (alrv)localObject1));
  }
  
  public void addColorSign(bdfz parambdfz)
  {
    parambdfz.a();
    addColorSign(false);
  }
  
  public void addColorSignDirectly(bdfz parambdfz)
  {
    parambdfz.a();
    addColorSign(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin
 * JD-Core Version:    0.7.0.1
 */