package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;

public abstract interface IQQLiveAnchorRoomPrepare
  extends IQQLiveAnchorRoomBase
{
  public abstract void a(QQLiveAnchorDataAuth paramQQLiveAnchorDataAuth);
  
  public abstract void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare);
  
  public abstract void b();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare
 * JD-Core Version:    0.7.0.1
 */