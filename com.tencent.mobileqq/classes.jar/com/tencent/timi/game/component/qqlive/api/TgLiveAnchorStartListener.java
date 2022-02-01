package com.tencent.timi.game.component.qqlive.api;

import android.view.View;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;

public abstract interface TgLiveAnchorStartListener
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo);
  
  public abstract void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, QQLiveAnchorDataBase paramQQLiveAnchorDataBase, View paramView);
  
  public abstract void a(boolean paramBoolean, QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter);
  
  public abstract void a(boolean paramBoolean, QQLiveAnchorDataInit paramQQLiveAnchorDataInit);
  
  public abstract void a(boolean paramBoolean, QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare);
  
  public abstract void a(boolean paramBoolean, QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo, String paramString1, String paramString2);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener
 * JD-Core Version:    0.7.0.1
 */