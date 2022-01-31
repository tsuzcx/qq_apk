package eipc;

import android.os.Bundle;

public abstract class EIPCModule
{
  EIPCModuleManager a;
  int[] b = new int[0];
  public String name;
  
  public EIPCModule(String paramString)
  {
    this.name = paramString;
  }
  
  public EIPCModule(String paramString, int[] paramArrayOfInt)
  {
    this.name = paramString;
    this.b = paramArrayOfInt;
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    this.a.callbackResult(paramInt, paramEIPCResult);
  }
  
  public abstract EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt);
  
  public void onReceiveMsg(int paramInt, Bundle paramBundle) {}
  
  public String toString()
  {
    return "name:" + this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     eipc.EIPCModule
 * JD-Core Version:    0.7.0.1
 */