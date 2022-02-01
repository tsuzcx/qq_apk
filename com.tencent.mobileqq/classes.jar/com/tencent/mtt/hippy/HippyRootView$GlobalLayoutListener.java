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
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.reflect.Method;

class HippyRootView$GlobalLayoutListener
  implements View.OnSystemUiVisibilityChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private int mOrientation = 0;
  
  private HippyRootView$GlobalLayoutListener(HippyRootView paramHippyRootView) {}
  
  private void checkUpdateDimension(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (HippyRootView.access$300(this.this$0) == null) {
      return;
    }
    Object localObject1 = this.this$0.getContext().getResources().getDisplayMetrics();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject1);
    localObject1 = ((WindowManager)this.this$0.getContext().getSystemService("window")).getDefaultDisplay();
    int j = 0;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((Display)localObject1).getRealMetrics(localDisplayMetrics);
        }
        else
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          Object localObject2 = Display.class.getMethod("getRawWidth", new Class[0]).invoke(localObject1, new Object[0]);
          if (localObject2 == null) {
            break label367;
          }
          i = ((Integer)localObject2).intValue();
          localDisplayMetrics.widthPixels = i;
          localObject1 = localMethod.invoke(localObject1, new Object[0]);
          if (localObject1 == null) {
            break label373;
          }
          i = ((Integer)localObject1).intValue();
          localDisplayMetrics.heightPixels = i;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      HippyMap localHippyMap = DimensionsUtil.getDimensions(paramInt1, paramInt2, HippyRootView.access$300(this.this$0).getGlobalConfigs().getContext(), paramBoolean1);
      if (localHippyMap != null)
      {
        localObject1 = localHippyMap.getMap("windowPhysicalPixels");
        i = ((HippyMap)localObject1).getInt("width");
        paramInt1 = ((HippyMap)localObject1).getInt("height");
      }
      else
      {
        paramInt1 = 0;
        i = j;
      }
      if (((paramInt2 < 0) || (i == paramInt1)) && (HippyRootView.access$300(this.this$0).getGlobalConfigs() != null))
      {
        localObject1 = HippyRootView.access$300(this.this$0).getGlobalConfigs().getDeviceAdapter();
        if (localObject1 != null) {
          ((HippyDeviceAdapter)localObject1).reviseDimensionIfNeed(this.this$0.getContext(), localHippyMap, paramBoolean1, paramBoolean2);
        }
      }
      if (HippyRootView.access$300(this.this$0).getModuleManager() != null) {
        ((Dimensions)HippyRootView.access$300(this.this$0).getModuleManager().getJavaScriptModule(Dimensions.class)).set(localHippyMap);
      }
      return;
      label367:
      int i = 0;
      continue;
      label373:
      i = 0;
    }
  }
  
  private void checkUpdateDimension(boolean paramBoolean1, boolean paramBoolean2)
  {
    checkUpdateDimension(-1, -1, false, false);
  }
  
  private void sendOrientationChangeEvent(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendOrientationChangeEvent: orientation=");
    localStringBuilder.append(paramInt);
    LogUtils.d("HippyRootView", localStringBuilder.toString());
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyRootView.GlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */