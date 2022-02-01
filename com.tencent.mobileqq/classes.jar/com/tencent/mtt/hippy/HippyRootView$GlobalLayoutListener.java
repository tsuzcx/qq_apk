package com.tencent.mtt.hippy;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.Dimensions;
import com.tencent.mtt.hippy.utils.DimensionsUtil;
import java.lang.reflect.Method;

class HippyRootView$GlobalLayoutListener
  implements View.OnSystemUiVisibilityChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private int mOrientation = 0;
  
  private HippyRootView$GlobalLayoutListener(HippyRootView paramHippyRootView) {}
  
  private void checkUpdateDimension(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (HippyRootView.access$300(this.this$0) == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.this$0.getContext().getResources().getDisplayMetrics();
      Object localObject1 = new DisplayMetrics();
      ((DisplayMetrics)localObject1).setTo((DisplayMetrics)localObject2);
      localObject2 = ((WindowManager)this.this$0.getContext().getSystemService("window")).getDefaultDisplay();
      try
      {
        if (Build.VERSION.SDK_INT >= 17) {
          ((Display)localObject2).getRealMetrics((DisplayMetrics)localObject1);
        }
        for (;;)
        {
          localObject1 = DimensionsUtil.getDimensions(paramInt1, paramInt2, HippyRootView.access$300(this.this$0).getGlobalConfigs().getContext(), paramBoolean1);
          if (localObject1 == null) {
            break label364;
          }
          localObject2 = ((HippyMap)localObject1).getMap("windowPhysicalPixels");
          i = ((HippyMap)localObject2).getInt("width");
          paramInt1 = ((HippyMap)localObject2).getInt("height");
          if (((paramInt2 < 0) || (i == paramInt1)) && (HippyRootView.access$300(this.this$0).getGlobalConfigs() != null))
          {
            localObject2 = HippyRootView.access$300(this.this$0).getGlobalConfigs().getDeviceAdapter();
            if (localObject2 != null) {
              ((HippyDeviceAdapter)localObject2).reviseDimensionIfNeed(this.this$0.getContext(), (HippyMap)localObject1, paramBoolean1, paramBoolean2);
            }
          }
          if (HippyRootView.access$300(this.this$0).getModuleManager() == null) {
            break;
          }
          ((Dimensions)HippyRootView.access$300(this.this$0).getModuleManager().getJavaScriptModule(Dimensions.class)).set((HippyMap)localObject1);
          return;
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          Object localObject3 = Display.class.getMethod("getRawWidth", new Class[0]).invoke(localObject2, new Object[0]);
          if (localObject3 == null) {
            break label352;
          }
          i = ((Integer)localObject3).intValue();
          ((DisplayMetrics)localObject1).widthPixels = i;
          localObject2 = localMethod.invoke(localObject2, new Object[0]);
          if (localObject2 == null) {
            break label358;
          }
          i = ((Integer)localObject2).intValue();
          ((DisplayMetrics)localObject1).heightPixels = i;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          continue;
          label352:
          int i = 0;
          continue;
          label358:
          i = 0;
          continue;
          label364:
          paramInt1 = 0;
          i = j;
        }
      }
    }
  }
  
  private void checkUpdateDimension(boolean paramBoolean1, boolean paramBoolean2)
  {
    checkUpdateDimension(-1, -1, false, false);
  }
  
  private void sendOrientationChangeEvent(int paramInt) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.getContext() != null)
    {
      int i = this.this$0.getContext().getResources().getConfiguration().orientation;
      if (i != this.mOrientation)
      {
        this.mOrientation = i;
        sendOrientationChangeEvent(this.mOrientation);
        checkUpdateDimension(false, false);
      }
    }
  }
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x2) == 0)
    {
      checkUpdateDimension(false, true);
      return;
    }
    checkUpdateDimension(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyRootView.GlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */