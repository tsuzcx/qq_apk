package com.tencent.qqprotect.qsec;

public abstract interface IQSecRuntime
{
  public abstract Object getApplicationContext();
  
  public abstract Object getQQAppInterface();
  
  public abstract int getRuntimeVersion();
  
  public abstract IRuntimeInterface queryRuntimeInterface(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.IQSecRuntime
 * JD-Core Version:    0.7.0.1
 */