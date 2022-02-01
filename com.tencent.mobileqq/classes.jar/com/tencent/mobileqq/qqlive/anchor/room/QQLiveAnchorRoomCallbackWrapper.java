package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public class QQLiveAnchorRoomCallbackWrapper
  implements IQQLiveAnchorRoomThirdPushCallback
{
  private IQQLiveAnchorRoomThirdPushCallback a;
  
  public QQLiveAnchorRoomCallbackWrapper(IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    this.a = paramIQQLiveAnchorRoomThirdPushCallback;
  }
  
  public void a()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramInt, paramString);
    }
  }
  
  public void a(QQLiveAnchorRoomState paramQQLiveAnchorRoomState1, QQLiveAnchorRoomState paramQQLiveAnchorRoomState2)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorRoomState1, paramQQLiveAnchorRoomState2);
    }
  }
  
  public void a(QQLiveAnchorDataAuth paramQQLiveAnchorDataAuth)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataAuth);
    }
  }
  
  public void a(QQLiveAnchorDataCheckPermission paramQQLiveAnchorDataCheckPermission)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataCheckPermission);
    }
  }
  
  public void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataEnter);
    }
  }
  
  public void a(QQLiveAnchorDataFastResume paramQQLiveAnchorDataFastResume)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataFastResume);
    }
  }
  
  public void a(QQLiveAnchorDataInit paramQQLiveAnchorDataInit)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataInit);
    }
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataPrepare);
    }
  }
  
  public void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataPublishStream);
    }
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataPullInfo);
    }
  }
  
  public void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataPushInfo);
    }
  }
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataSet);
    }
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveAnchorDataThirdPushCheck);
    }
  }
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.a(paramQQLiveErrorMsg);
    }
  }
  
  public void b()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.b();
    }
  }
  
  public void c()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.c();
    }
  }
  
  public void d()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.d();
    }
  }
  
  public void e()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.e();
    }
  }
  
  public void f()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.f();
    }
  }
  
  public void h()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.h();
    }
  }
  
  public void i()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.i();
    }
  }
  
  public void j()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.j();
    }
  }
  
  public void k()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.k();
    }
  }
  
  public void l()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.l();
    }
  }
  
  public void m()
  {
    IQQLiveAnchorRoomThirdPushCallback localIQQLiveAnchorRoomThirdPushCallback = this.a;
    if (localIQQLiveAnchorRoomThirdPushCallback != null) {
      localIQQLiveAnchorRoomThirdPushCallback.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoomCallbackWrapper
 * JD-Core Version:    0.7.0.1
 */