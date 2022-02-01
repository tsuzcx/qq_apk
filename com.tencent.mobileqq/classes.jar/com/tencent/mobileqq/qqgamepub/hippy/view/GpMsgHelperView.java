package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameSessionView;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView.UiRefresh;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class GpMsgHelperView
  extends FrameLayout
  implements GameContentView.UiRefresh, HippyViewBase
{
  private GameSessionView a;
  private int b = -2147483648;
  private boolean c = false;
  
  public GpMsgHelperView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.b = paramInt;
    c();
  }
  
  public GpMsgHelperView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void a(String paramString, HippyMap paramHippyMap)
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.b);
    if (localHippyQQEngine != null) {
      ((EventDispatcher)localHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
    }
  }
  
  private void c()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView initView");
    this.a = new GameSessionView(getContext());
    addView(this.a, -1, -1);
    this.a.a(MobileQQ.sMobileQQ.waitAppRuntime(null), this);
    this.a.setVisibility(0);
    b();
  }
  
  public void a()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView destory");
    GameSessionView localGameSessionView = this.a;
    if (localGameSessionView != null) {
      localGameSessionView.b();
    }
  }
  
  public void b()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void c(long paramLong)
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView postDraw");
    this.c = true;
    HippyMap localHippyMap;
    if (paramLong == 0L)
    {
      localHippyMap = new HippyMap();
      localHippyMap.pushInt("action", 5);
      localHippyMap.pushInt("height", 0);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new GpMsgHelperView.2(this, localHippyMap), 500L);
      return;
    }
    int i = (int)(500L + paramLong);
    try
    {
      if (QQGameUIHelper.a != null)
      {
        QQGameUIHelper.a(paramLong, this.a, QQGameUIHelper.a);
        localHippyMap = new HippyMap();
        localHippyMap.pushInt("action", 5);
        localHippyMap.pushInt("height", 0);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new GpMsgHelperView.3(this, localHippyMap), i);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void h()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView refreshGameContentView");
    b();
    if (this.c)
    {
      this.c = false;
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((GameSessionView)localObject).getVisibility() == 8)
      {
        localObject = new HippyMap();
        ((HippyMap)localObject).pushInt("action", 5);
        ((HippyMap)localObject).pushInt("height", 0);
        a("onGameFeedsEvent", (HippyMap)localObject);
        return;
      }
      this.a.post(new GpMsgHelperView.1(this));
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperView
 * JD-Core Version:    0.7.0.1
 */