package com.tencent.qphone.base.remote;

import android.os.IInterface;

public abstract interface IBaseActionListener
  extends IInterface
{
  public abstract void onActionResult(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRecvFromMsg(FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.IBaseActionListener
 * JD-Core Version:    0.7.0.1
 */