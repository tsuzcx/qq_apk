package com.tencent.mobileqq.triton.render;

import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.triton.engine.TTLog;

public class GameGlobalView
  extends RelativeLayout
{
  private static final String TAG = "GameGlobalView";
  
  public GameGlobalView(Activity paramActivity, RenderContext paramRenderContext)
  {
    super(paramActivity);
    paramActivity = new TritonSurfaceView(paramActivity, paramRenderContext, paramRenderContext.getTouchEventManager());
    paramActivity.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(paramActivity);
    TTLog.e("GameGlobalView", "new GameGlobalView:" + this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.GameGlobalView
 * JD-Core Version:    0.7.0.1
 */