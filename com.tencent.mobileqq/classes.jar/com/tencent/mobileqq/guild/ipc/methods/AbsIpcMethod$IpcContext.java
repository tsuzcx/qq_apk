package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class AbsIpcMethod$IpcContext
{
  public final QIPCModule a;
  public final int b;
  public final Bundle c;
  
  public AbsIpcMethod$IpcContext(QIPCModule paramQIPCModule, int paramInt, Bundle paramBundle)
  {
    this.a = paramQIPCModule;
    this.b = paramInt;
    this.c = paramBundle;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.callbackResult(this.b, EIPCResult.createResult(paramInt, paramBundle));
  }
  
  public void a(Bundle paramBundle)
  {
    this.a.callbackResult(this.b, EIPCResult.createSuccessResult(paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod.IpcContext
 * JD-Core Version:    0.7.0.1
 */