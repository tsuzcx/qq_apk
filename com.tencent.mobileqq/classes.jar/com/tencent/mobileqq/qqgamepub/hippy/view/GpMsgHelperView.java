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
  private int jdField_a_of_type_Int = -2147483648;
  private GameSessionView jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GpMsgHelperView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    d();
  }
  
  public GpMsgHelperView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void a(String paramString, HippyMap paramHippyMap)
  {
    HippyQQEngine localHippyQQEngine = HippyQQEngine.getEngineInstance(this.jdField_a_of_type_Int);
    if (localHippyQQEngine != null) {
      ((EventDispatcher)localHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
    }
  }
  
  private void d()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView initView");
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView = new GameSessionView(getContext());
    addView(this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView.a(MobileQQ.sMobileQQ.waitAppRuntime(null), this);
    this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView.setVisibility(0);
    c();
  }
  
  public void a()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView destory");
    GameSessionView localGameSessionView = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
    if (localGameSessionView != null) {
      localGameSessionView.c();
    }
  }
  
  public void a(long paramLong)
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView postDraw");
    this.jdField_a_of_type_Boolean = true;
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
        QQGameUIHelper.a(paramLong, this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView, QQGameUIHelper.a);
        localHippyMap = new HippyMap();
        localHippyMap.pushInt("action", 5);
        localHippyMap.pushInt("height", 0);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new GpMsgHelperView.3(this, localHippyMap), i);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void b()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView refreshGameContentView");
    c();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView;
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
      this.jdField_a_of_type_ComTencentMobileqqQqgamepubViewGameSessionView.post(new GpMsgHelperView.1(this));
    }
  }
  
  public void c()
  {
    QLog.d("QQGamePub_GpMsgHelperView", 1, "GpMsgHelperView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperView
 * JD-Core Version:    0.7.0.1
 */