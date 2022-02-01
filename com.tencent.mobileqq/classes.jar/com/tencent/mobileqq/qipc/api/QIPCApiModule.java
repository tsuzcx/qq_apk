package com.tencent.mobileqq.qipc.api;

import android.os.Bundle;

public abstract class QIPCApiModule
{
  public String name;
  
  public QIPCApiModule(String paramString)
  {
    this.name = paramString;
  }
  
  public abstract QIPCApiResult onCall(String paramString, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.QIPCApiModule
 * JD-Core Version:    0.7.0.1
 */