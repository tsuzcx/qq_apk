package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import eipc.EIPCModule;

public abstract class QIPCModule
  extends EIPCModule
{
  public static final int[] LISTEN_MSGS = { 1 };
  static final int MSG_ACCOUNT_CHANGE = 1;
  
  public QIPCModule(String paramString)
  {
    super(paramString, LISTEN_MSGS);
  }
  
  public void onAccountChange() {}
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle)
  {
    super.onReceiveMsg(paramInt, paramBundle);
    if (paramInt == 1) {
      onAccountChange();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCModule
 * JD-Core Version:    0.7.0.1
 */