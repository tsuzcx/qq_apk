package com.tencent.mobileqq.gamecenter.hippy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class HippyArkView
  extends RelativeLayout
  implements ArkViewImplement.LoadCallback, HippyViewBase
{
  private static final String TAG = "HippyArkView";
  private String appName;
  private ArkView arkView;
  private HippyArray array;
  private QQGameMsgInfo mMsgInfo;
  private HippyMap map;
  
  public HippyArkView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131561750, this);
    this.arkView = ((ArkView)findViewById(2131374884));
  }
  
  public void destory()
  {
    QLog.d("HippyArkView", 1, "HippyArkView destory");
    if (this.arkView != null) {
      this.arkView.onDestroy();
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public void init(QQGameMsgInfo paramQQGameMsgInfo)
  {
    QLog.d("HippyArkView", 1, "HippyArkView init");
    if (this.arkView != null)
    {
      postDraw();
      this.mMsgInfo = paramQQGameMsgInfo;
      this.appName = paramQQGameMsgInfo.arkAppName;
      this.arkView.getViewTreeObserver().dispatchOnGlobalLayout();
      this.arkView.load(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramQQGameMsgInfo.arkAppConfig, this);
    }
  }
  
  public void init(HippyArray paramHippyArray)
  {
    this.array = paramHippyArray;
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.arkAppName = paramHippyArray.getString(0);
    localQQGameMsgInfo.arkAppView = paramHippyArray.getString(1);
    localQQGameMsgInfo.arkAppMinVersion = paramHippyArray.getString(2);
    localQQGameMsgInfo.arkMetaList = paramHippyArray.getString(3);
    localQQGameMsgInfo.arkAppConfig = paramHippyArray.getString(4);
    localQQGameMsgInfo.paMsgid = paramHippyArray.getString(5);
    init(localQQGameMsgInfo);
  }
  
  public void onAfterUpdateProps()
  {
    QLog.d("HippyArkView", 1, "HippyArkView onAfterUpdateProps ");
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  public void onLoadState(int paramInt) {}
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildAt(0) != null) {
      getChildAt(0).measure(paramInt1, paramInt2);
    }
  }
  
  public void pause()
  {
    QLog.d("HippyArkView", 1, "HippyArkView pause");
    if (this.arkView != null) {
      this.arkView.onPause();
    }
  }
  
  public void postDraw()
  {
    QLog.d("HippyArkView", 1, "HippyArkView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void resume()
  {
    QLog.d("HippyArkView", 1, "HippyArkView resume");
    if (this.arkView != null) {
      this.arkView.onResume();
    }
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  public void setSrc(HippyMap paramHippyMap)
  {
    QLog.d("HippyArkView", 1, "HippyArkView setSrc");
    this.map = paramHippyMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.view.HippyArkView
 * JD-Core Version:    0.7.0.1
 */