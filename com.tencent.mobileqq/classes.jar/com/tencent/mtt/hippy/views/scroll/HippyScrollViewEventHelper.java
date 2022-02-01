package com.tencent.mtt.hippy.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;

public class HippyScrollViewEventHelper
{
  public static final String EVENT_TYPE_ANIMATION_END = "onScrollAnimationEnd";
  public static final String EVENT_TYPE_BEGIN_DRAG = "onScrollBeginDrag";
  public static final String EVENT_TYPE_END_DRAG = "onScrollEndDrag";
  public static final String EVENT_TYPE_MOMENTUM_BEGIN = "onMomentumScrollBegin";
  public static final String EVENT_TYPE_MOMENTUM_END = "onMomentumScrollEnd";
  public static final String EVENT_TYPE_REFRESH = "onRefresh";
  public static final String EVENT_TYPE_SCROLL = "onScroll";
  public static final long MOMENTUM_DELAY = 20L;
  
  public static void emitScrollAnimationEndEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onScrollAnimationEnd");
  }
  
  public static void emitScrollBeginDragEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onScrollBeginDrag");
  }
  
  public static void emitScrollEndDragEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onScrollEndDrag");
  }
  
  public static void emitScrollEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onScroll");
  }
  
  public static void emitScrollEvent(ViewGroup paramViewGroup, String paramString)
  {
    if (paramViewGroup == null) {
      return;
    }
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushDouble("top", 0.0D);
    localHippyMap1.pushDouble("bottom", 0.0D);
    localHippyMap1.pushDouble("left", 0.0D);
    localHippyMap1.pushDouble("right", 0.0D);
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushDouble("x", PixelUtil.px2dp(paramViewGroup.getScrollX()));
    localHippyMap2.pushDouble("y", PixelUtil.px2dp(paramViewGroup.getScrollY()));
    HippyMap localHippyMap3 = new HippyMap();
    if (paramViewGroup.getChildCount() > 0)
    {
      f = paramViewGroup.getChildAt(0).getWidth();
      label108:
      localHippyMap3.pushDouble("width", PixelUtil.px2dp(f));
      if (paramViewGroup.getChildCount() <= 0) {
        break label295;
      }
    }
    label295:
    for (float f = paramViewGroup.getChildAt(0).getHeight();; f = paramViewGroup.getHeight())
    {
      localHippyMap3.pushDouble("height", PixelUtil.px2dp(f));
      HippyMap localHippyMap4 = new HippyMap();
      localHippyMap4.pushDouble("width", PixelUtil.px2dp(paramViewGroup.getWidth()));
      localHippyMap4.pushDouble("height", PixelUtil.px2dp(paramViewGroup.getHeight()));
      HippyMap localHippyMap5 = new HippyMap();
      localHippyMap5.pushMap("contentInset", localHippyMap1);
      localHippyMap5.pushMap("contentOffset", localHippyMap2);
      localHippyMap5.pushMap("contentSize", localHippyMap3);
      localHippyMap5.pushMap("layoutMeasurement", localHippyMap4);
      if ((paramViewGroup == null) || (!(paramViewGroup.getContext() instanceof HippyInstanceContext))) {
        break;
      }
      ((EventDispatcher)((HippyInstanceContext)paramViewGroup.getContext()).getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramViewGroup.getId(), paramString, localHippyMap5);
      return;
      f = paramViewGroup.getWidth();
      break label108;
    }
  }
  
  public static void emitScrollMomentumBeginEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onMomentumScrollBegin");
  }
  
  public static void emitScrollMomentumEndEvent(ViewGroup paramViewGroup)
  {
    emitScrollEvent(paramViewGroup, "onMomentumScrollEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper
 * JD-Core Version:    0.7.0.1
 */