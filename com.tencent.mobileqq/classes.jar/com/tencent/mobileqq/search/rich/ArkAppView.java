package com.tencent.mobileqq.search.rich;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.presenter.RichSearchResultPresenter.OnActionListener;
import com.tencent.qphone.base.util.QLog;

public class ArkAppView
  extends ArkTextureView
  implements ArkViewImplement.LoadCallback
{
  protected RichSearchResultPresenter.OnActionListener a;
  private ArkAppView.ArkAppViewEvent b;
  
  public ArkAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkMultiProcUtil.a();
    ArkAppDataReport.a();
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void a(ArkNodeContainer paramArkNodeContainer, ArkAppView.ArkAppViewEvent paramArkAppViewEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "init");
    }
    if (paramArkNodeContainer == null) {
      return;
    }
    this.b = paramArkAppViewEvent;
    super.initArkView(paramArkNodeContainer);
    setOnTouchListener(this);
    setLoadCallback(this);
  }
  
  public void onFirstPaint()
  {
    ArkAppView.ArkAppViewEvent localArkAppViewEvent = this.b;
    if (localArkAppViewEvent != null) {
      localArkAppViewEvent.do_();
    }
  }
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onLoadFailed");
    }
    Object localObject = this.mViewImpl.getViewModel();
    if (localObject == null) {
      return;
    }
    if ((((ArkViewModel)localObject).GetAppScriptType() == 2) && (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isJSCLibExist()))
    {
      QLog.e(TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
      onLoading();
      return;
    }
    setVisibility(8);
    localObject = this.b;
    if (localObject != null) {
      ((ArkAppView.ArkAppViewEvent)localObject).a(paramString, paramInt, paramBoolean);
    }
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachArkView onLoadFinish state=");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void onLoadSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onLoadSuccess");
    }
    super.onLoadSuccess();
    ArkAppView.ArkAppViewEvent localArkAppViewEvent = this.b;
    if (localArkAppViewEvent != null) {
      localArkAppViewEvent.a();
    }
  }
  
  public void onLoading()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onLoading");
    }
    setVisibility(8);
    ArkAppView.ArkAppViewEvent localArkAppViewEvent = this.b;
    if (localArkAppViewEvent != null) {
      localArkAppViewEvent.dn_();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      RichSearchResultPresenter.OnActionListener localOnActionListener = this.a;
      if (localOnActionListener != null) {
        localOnActionListener.a();
      }
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void setOnActionListener(RichSearchResultPresenter.OnActionListener paramOnActionListener)
  {
    this.a = paramOnActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppView
 * JD-Core Version:    0.7.0.1
 */