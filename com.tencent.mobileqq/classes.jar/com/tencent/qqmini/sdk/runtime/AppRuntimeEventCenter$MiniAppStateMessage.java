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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{RuntimeLoader(");
    Object localObject = this.appRuntimeLoader;
    String str = "nil";
    if (localObject != null) {
      localObject = localObject.getClass().getSimpleName();
    } else {
      localObject = "nil";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")@");
    BaseRuntimeLoader localBaseRuntimeLoader = this.appRuntimeLoader;
    localObject = str;
    if (localBaseRuntimeLoader != null) {
      localObject = Integer.valueOf(localBaseRuntimeLoader.hashCode());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(this.appRuntimeLoader);
    localStringBuilder.append(" what=");
    localStringBuilder.append(this.what);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.MiniAppStateMessage
 * JD-Core Version:    0.7.0.1
 */