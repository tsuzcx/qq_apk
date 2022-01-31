package com.tencent.viola.module;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.utils.ViolaUtils;

public class MonitorModule
  extends BaseModule
  implements Destroyable
{
  public static final String MODULE_NAME = "monitor";
  private RenderActionContext mRenderActionContext;
  private ViolaRenderManager mRenderManager;
  
  @JSMethod(uiThread=true)
  public void click(String paramString)
  {
    this.mRenderManager = ViolaSDKManager.getInstance().getRenderManager();
    this.mRenderActionContext = this.mRenderManager.getRenderContext(getViolaInstance().getInstanceId());
    paramString = this.mRenderActionContext.getComponent(paramString);
    if ((paramString != null) && (paramString.getHostView() != null))
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent1 = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      l += 1000L;
      MotionEvent localMotionEvent2 = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      paramString.getHostView().onTouchEvent(localMotionEvent1);
      paramString.getHostView().onTouchEvent(localMotionEvent2);
      localMotionEvent1.recycle();
      localMotionEvent2.recycle();
    }
  }
  
  public void destroy() {}
  
  @JSMethod(uiThread=false)
  public void screenshot(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      this.mRenderManager = ViolaSDKManager.getInstance().getRenderManager();
      this.mRenderActionContext = this.mRenderManager.getRenderContext(getViolaInstance().getInstanceId());
      paramString1 = this.mRenderActionContext.getComponent(paramString1);
      if ((paramString1 != null) && (paramString1.getHostView() != null))
      {
        paramString1.getHostView().setDrawingCacheEnabled(true);
        paramString1.getHostView().buildDrawingCache();
        paramString1 = paramString1.getHostView().getDrawingCache();
        if (paramString1 != null)
        {
          paramString1 = ViolaUtils.bitmapToBase64(paramString1);
          if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
            ViolaBridgeManager.getInstance().callbackJavascript(getViolaInstance().getInstanceId(), "monitor", "callback", paramString2, paramString1, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.module.MonitorModule
 * JD-Core Version:    0.7.0.1
 */