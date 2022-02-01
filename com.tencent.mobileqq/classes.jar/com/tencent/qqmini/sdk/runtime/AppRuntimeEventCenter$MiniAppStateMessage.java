package com.tencent.qqmini.sdk.runtime;

public class AppRuntimeEventCenter$MiniAppStateMessage
{
  public BaseRuntimeLoader appRuntimeLoader;
  public Object obj;
  public int what;
  
  private AppRuntimeEventCenter$MiniAppStateMessage(int paramInt, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    this.what = paramInt;
    this.appRuntimeLoader = paramBaseRuntimeLoader;
  }
  
  public static MiniAppStateMessage obtainMessage(int paramInt, BaseRuntimeLoader paramBaseRuntimeLoader)
  {
    return new MiniAppStateMessage(paramInt, paramBaseRuntimeLoader);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("{RuntimeLoader(");
    if (this.appRuntimeLoader != null)
    {
      localObject = this.appRuntimeLoader.getClass().getSimpleName();
      localStringBuilder = localStringBuilder.append((String)localObject).append(")@");
      if (this.appRuntimeLoader == null) {
        break label99;
      }
    }
    label99:
    for (Object localObject = Integer.valueOf(this.appRuntimeLoader.hashCode());; localObject = "nil")
    {
      return localObject + this.appRuntimeLoader + " what=" + this.what + "}";
      localObject = "nil";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.MiniAppStateMessage
 * JD-Core Version:    0.7.0.1
 */