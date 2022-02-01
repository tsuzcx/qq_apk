package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import java.util.HashSet;

public class NativeGestureDispatcher
  implements g.a
{
  private static final String KEY_EVENT_NAME = "name";
  private static final String KEY_PAGE_X = "page_x";
  private static final String KEY_PAGE_Y = "page_y";
  private static final String KEY_TAG_ID = "id";
  private static final String TAG = "NativeGestureDispatcher";
  private static final int TAP_TIMEOUT = ;
  private static View.OnAttachStateChangeListener mOnAttachedToWindowListener = new NativeGestureDispatcher.3();
  private static View.OnClickListener mOnClickListener = new NativeGestureDispatcher.1();
  private static View.OnAttachStateChangeListener mOnDetachedFromWindowListener = new NativeGestureDispatcher.4();
  private static View.OnLongClickListener mOnLongClickListener = new NativeGestureDispatcher.2();
  private HippyEngineContext mEngineContext;
  private g mGestureProcessor;
  private HashSet<String> mGestureTypes = null;
  private View mTargetView;
  
  public NativeGestureDispatcher(View paramView)
  {
    this.mTargetView = paramView;
    if ((paramView != null) && ((paramView.getContext() instanceof HippyInstanceContext))) {
      this.mEngineContext = ((HippyInstanceContext)paramView.getContext()).getEngineContext();
    }
  }
  
  private static void getLocationInWindow(HippyEngineContext paramHippyEngineContext, int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt >= 0)
    {
      paramHippyEngineContext = paramHippyEngineContext.getRenderManager().getControllerManager().findView(paramInt);
      if (paramHippyEngineContext != null) {
        paramHippyEngineContext.getLocationInWindow(paramArrayOfInt);
      }
    }
  }
  
  public static View.OnAttachStateChangeListener getOnAttachedToWindowListener()
  {
    return mOnAttachedToWindowListener;
  }
  
  public static View.OnClickListener getOnClickListener()
  {
    return mOnClickListener;
  }
  
  public static View.OnAttachStateChangeListener getOnDetachedFromWindowListener()
  {
    return mOnDetachedFromWindowListener;
  }
  
  public static View.OnLongClickListener getOnLongClickListener()
  {
    return mOnLongClickListener;
  }
  
  public static void handleAttachedToWindow(HippyEngineContext paramHippyEngineContext, int paramInt)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramInt, "onAttachedToWindow", null);
  }
  
  public static void handleClick(HippyEngineContext paramHippyEngineContext, int paramInt)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onClick");
    localHippyMap.pushInt("id", paramInt);
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
    LogUtils.d("NativeGestureDispatcher", "send msg: onClick");
  }
  
  public static void handleDetachedFromWindow(HippyEngineContext paramHippyEngineContext, int paramInt)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramInt, "onDetachedFromWindow", null);
  }
  
  public static void handleLongClick(HippyEngineContext paramHippyEngineContext, int paramInt)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onLongClick");
    localHippyMap.pushInt("id", paramInt);
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
  }
  
  public static void handlePressIn(HippyEngineContext paramHippyEngineContext, int paramInt)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onPressIn");
    localHippyMap.pushInt("id", paramInt);
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
    LogUtils.d("NativeGestureDispatcher", "send msg: onPressIn");
  }
  
  public static void handlePressOut(HippyEngineContext paramHippyEngineContext, int paramInt)
  {
    if (paramHippyEngineContext == null) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onPressOut");
    localHippyMap.pushInt("id", paramInt);
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
    LogUtils.d("NativeGestureDispatcher", "send msg: onPressIn");
  }
  
  public static void handleTouchCancel(HippyEngineContext paramHippyEngineContext, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(paramHippyEngineContext, paramInt2, arrayOfInt);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onTouchCancel");
    localHippyMap.pushInt("id", paramInt1);
    localHippyMap.pushDouble("page_x", PixelUtil.px2dp(arrayOfInt[0] + paramFloat1));
    localHippyMap.pushDouble("page_y", PixelUtil.px2dp(arrayOfInt[1] + paramFloat2));
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
  }
  
  public static void handleTouchDown(HippyEngineContext paramHippyEngineContext, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(paramHippyEngineContext, paramInt2, arrayOfInt);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onTouchDown");
    localHippyMap.pushInt("id", paramInt1);
    localHippyMap.pushDouble("page_x", PixelUtil.px2dp(arrayOfInt[0] + paramFloat1));
    localHippyMap.pushDouble("page_y", PixelUtil.px2dp(arrayOfInt[1] + paramFloat2));
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
  }
  
  public static void handleTouchEnd(HippyEngineContext paramHippyEngineContext, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(paramHippyEngineContext, paramInt2, arrayOfInt);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onTouchEnd");
    localHippyMap.pushInt("id", paramInt1);
    localHippyMap.pushDouble("page_x", PixelUtil.px2dp(arrayOfInt[0] + paramFloat1));
    localHippyMap.pushDouble("page_y", PixelUtil.px2dp(arrayOfInt[1] + paramFloat2));
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
  }
  
  public static void handleTouchMove(HippyEngineContext paramHippyEngineContext, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(paramHippyEngineContext, paramInt2, arrayOfInt);
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("name", "onTouchMove");
    localHippyMap.pushInt("id", paramInt1);
    localHippyMap.pushDouble("page_x", PixelUtil.px2dp(arrayOfInt[0] + paramFloat1));
    localHippyMap.pushDouble("page_y", PixelUtil.px2dp(arrayOfInt[1] + paramFloat2));
    ((EventDispatcher)paramHippyEngineContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeGesture(localHippyMap);
  }
  
  public void addGestureType(String paramString)
  {
    if (this.mGestureTypes == null) {
      this.mGestureTypes = new HashSet();
    }
    this.mGestureTypes.add(paramString);
  }
  
  public void handle(String paramString, float paramFloat1, float paramFloat2)
  {
    if (this.mTargetView == null) {
      LogUtils.e("NativeGestureDispatcher", "handle!!! but view is null!!!!");
    }
    do
    {
      return;
      if (TextUtils.equals(paramString, "onPressIn"))
      {
        handlePressIn(this.mEngineContext, this.mTargetView.getId());
        return;
      }
      if (TextUtils.equals(paramString, "onPressOut"))
      {
        handlePressOut(this.mEngineContext, this.mTargetView.getId());
        return;
      }
      if (TextUtils.equals(paramString, "onTouchDown"))
      {
        handleTouchDown(this.mEngineContext, this.mTargetView.getId(), paramFloat1, paramFloat2, this.mTargetView.getId());
        return;
      }
      if (TextUtils.equals(paramString, "onTouchMove"))
      {
        handleTouchMove(this.mEngineContext, this.mTargetView.getId(), paramFloat1, paramFloat2, this.mTargetView.getId());
        return;
      }
      if (TextUtils.equals(paramString, "onTouchEnd"))
      {
        handleTouchEnd(this.mEngineContext, this.mTargetView.getId(), paramFloat1, paramFloat2, this.mTargetView.getId());
        return;
      }
    } while (!TextUtils.equals(paramString, "onTouchCancel"));
    handleTouchCancel(this.mEngineContext, this.mTargetView.getId(), paramFloat1, paramFloat2, this.mTargetView.getId());
  }
  
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureProcessor == null) {
      this.mGestureProcessor = new g(this);
    }
    return this.mGestureProcessor.a(paramMotionEvent);
  }
  
  public boolean needHandle(String paramString)
  {
    if (this.mGestureTypes != null)
    {
      boolean bool2 = this.mGestureTypes.contains(paramString);
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!TextUtils.equals(paramString, "onInterceptTouchEvent"))
        {
          bool1 = bool2;
          if (!TextUtils.equals(paramString, "onInterceptPullUpEvent")) {
            if (!needHandle("onInterceptTouchEvent"))
            {
              bool1 = bool2;
              if (!needHandle("onInterceptPullUpEvent")) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    return false;
  }
  
  public void removeGestureType(String paramString)
  {
    if (this.mGestureTypes != null) {
      this.mGestureTypes.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher
 * JD-Core Version:    0.7.0.1
 */