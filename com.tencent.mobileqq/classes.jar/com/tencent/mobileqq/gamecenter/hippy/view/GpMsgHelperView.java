package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.QQGameUIHelper;
import com.tencent.mobileqq.gamecenter.view.GameSessionView;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView.UiRefresh;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

class GpMsgHelperView
  extends FrameLayout
  implements GameContentView.UiRefresh, HippyViewBase
{
  private static final String TAG = "GpMsgHelperView";
  private GameSessionView gameSessionView;
  private boolean isViewHide = false;
  private int mHippyEngineId = -2147483648;
  
  public GpMsgHelperView(@NonNull Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public GpMsgHelperView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mHippyEngineId = paramInt;
    initView();
  }
  
  public GpMsgHelperView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void initView()
  {
    QLog.d("GpMsgHelperView", 1, "GpMsgHelperView initView");
    this.gameSessionView = new GameSessionView(getContext());
    addView(this.gameSessionView, -1, -1);
    this.gameSessionView.a(BaseApplicationImpl.getApplication().getRuntime(), this);
    this.gameSessionView.setVisibility(0);
    postDraw();
  }
  
  private void sendHippEvent(String paramString, HippyMap paramHippyMap)
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.mHippyEngineId);
    if (localHippyQQEngine != null) {
      ((EventDispatcher)localHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
    }
  }
  
  public void destory()
  {
    QLog.d("GpMsgHelperView", 1, "GpMsgHelperView destory");
    if (this.gameSessionView != null) {
      this.gameSessionView.c();
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void postDraw()
  {
    QLog.d("GpMsgHelperView", 1, "GpMsgHelperView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void refreshGameContentView()
  {
    QLog.d("GpMsgHelperView", 1, "GpMsgHelperView refreshGameContentView");
    postDraw();
    if (this.isViewHide)
    {
      this.isViewHide = false;
      return;
    }
    this.gameSessionView.post(new GpMsgHelperView.1(this));
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void shrinkGameContentView(long paramLong)
  {
    QLog.d("GpMsgHelperView", 1, "GpMsgHelperView postDraw");
    this.isViewHide = true;
    int i = (int)(500L + paramLong);
    try
    {
      if (QQGameUIHelper.a != null)
      {
        QQGameUIHelper.a(paramLong, this.gameSessionView, QQGameUIHelper.a);
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushInt("action", 5);
        localHippyMap.pushInt("height", 0);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new GpMsgHelperView.2(this, localHippyMap), i);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.GpMsgHelperView
 * JD-Core Version:    0.7.0.1
 */