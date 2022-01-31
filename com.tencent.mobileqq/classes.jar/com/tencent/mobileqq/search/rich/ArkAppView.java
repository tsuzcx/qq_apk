package com.tencent.mobileqq.search.rich;

import alep;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import avsz;
import avtb;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class ArkAppView
  extends ArkTextureView
  implements ArkViewImplement.LoadCallback
{
  private avsz a;
  
  public ArkAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkAppCenter.b(true);
    alep.a();
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(avtb paramavtb, avsz paramavsz)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "init");
    }
    if (paramavtb == null) {
      return;
    }
    this.a = paramavsz;
    super.initArkView(paramavtb);
    setOnTouchListener(this);
    setLoadCallback(this);
  }
  
  public void onFirstPaint()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onLoadFailed");
    }
    ArkViewModel localArkViewModel = this.mViewImpl.getViewModel();
    if (localArkViewModel == null) {}
    do
    {
      return;
      if ((localArkViewModel.GetAppScriptType() == 2) && (!ArkAppCenter.d()))
      {
        QLog.e(TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
        onLoading();
        return;
      }
      setVisibility(8);
    } while (this.a == null);
    this.a.a(paramString, paramInt, paramBoolean);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "attachArkView onLoadFinish state=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public void onLoadSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onLoadSuccess");
    }
    super.onLoadSuccess();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void onLoading()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onLoading");
    }
    setVisibility(8);
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppView
 * JD-Core Version:    0.7.0.1
 */