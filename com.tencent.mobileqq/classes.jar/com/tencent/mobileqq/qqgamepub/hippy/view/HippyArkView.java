package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.QLog;

public class HippyArkView
  extends RelativeLayout
  implements ArkViewImplement.LoadCallback, HippyViewBase
{
  private ArkView a;
  private String b;
  private HippyArray c;
  private HippyMap d;
  private QQGameMsgInfo e;
  private long f;
  
  public HippyArkView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(getContext()).inflate(2131624905, this);
    this.a = ((ArkView)findViewById(2131442586));
  }
  
  public void a()
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView postDraw");
    measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo)
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView init");
    if (this.a != null)
    {
      a();
      this.e = paramQQGameMsgInfo;
      this.b = paramQQGameMsgInfo.arkAppName;
      this.a.getViewTreeObserver().dispatchOnGlobalLayout();
      this.a.load(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramQQGameMsgInfo.arkAppConfig, this);
      this.f = SystemClock.elapsedRealtime();
    }
  }
  
  public void a(HippyArray paramHippyArray)
  {
    this.c = paramHippyArray;
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    localQQGameMsgInfo.arkAppName = paramHippyArray.getString(0);
    localQQGameMsgInfo.arkAppView = paramHippyArray.getString(1);
    localQQGameMsgInfo.arkAppMinVersion = paramHippyArray.getString(2);
    localQQGameMsgInfo.arkMetaList = paramHippyArray.getString(3);
    localQQGameMsgInfo.arkAppConfig = paramHippyArray.getString(4);
    localQQGameMsgInfo.paMsgid = paramHippyArray.getString(5);
    a(localQQGameMsgInfo);
  }
  
  public void b()
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView destory");
    ArkView localArkView = this.a;
    if (localArkView != null) {
      localArkView.onDestroy();
    }
  }
  
  public void c()
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView resume");
    ArkView localArkView = this.a;
    if (localArkView != null) {
      localArkView.onResume();
    }
  }
  
  public void d()
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView onAfterUpdateProps ");
  }
  
  public void e()
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView pause");
    ArkView localArkView = this.a;
    if (localArkView != null) {
      localArkView.onPause();
    }
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildAt(0) != null) {
      getChildAt(0).layout(0, 0, getWidth(), getHeight());
    }
  }
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_HippyArkView", 1, "onLoadFailed");
    }
    if (this.e != null)
    {
      long l = SystemClock.elapsedRealtime() - this.f;
      Object localObject2 = GamePubAccountHelper.c(GamePubAccountHelper.a()).d("76918").c("207984").a(2, this.e.advId).b(this.e.gameAppId);
      if (l > 0L) {
        localObject1 = String.valueOf(l);
      } else {
        localObject1 = "";
      }
      Object localObject1 = ((WadlReportBuilder)localObject2).a(17, (String)localObject1).a(18, this.e.arkAppName);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("");
      localObject1 = ((WadlReportBuilder)localObject1).a(19, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("");
      paramString = ((WadlReportBuilder)localObject1).a(20, ((StringBuilder)localObject2).toString()).a(21, paramString);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("");
      paramString.a(22, ((StringBuilder)localObject1).toString()).a();
    }
  }
  
  public void onLoadState(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLoadState state=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("QQGamePub_HippyArkView", 1, ((StringBuilder)localObject1).toString());
    }
    if (this.e != null)
    {
      long l = SystemClock.elapsedRealtime() - this.f;
      Object localObject2 = GamePubAccountHelper.c(GamePubAccountHelper.a()).d("76918").c("207984").a(2, this.e.advId).b(this.e.gameAppId);
      if (l > 0L) {
        localObject1 = String.valueOf(l);
      } else {
        localObject1 = "";
      }
      localObject1 = ((WadlReportBuilder)localObject2).a(17, (String)localObject1).a(18, this.e.arkAppName);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("");
      ((WadlReportBuilder)localObject1).a(29, ((StringBuilder)localObject2).toString()).a();
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
  
  public void setSrc(HippyMap paramHippyMap)
  {
    QLog.d("QQGamePub_HippyArkView", 1, "HippyArkView setSrc");
    this.d = paramHippyMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.HippyArkView
 * JD-Core Version:    0.7.0.1
 */