package io.flutter.plugin.common;

import android.support.annotation.Nullable;
import android.util.Log;

public class ErrorLogResult
  implements MethodChannel.Result
{
  private int level;
  private String tag;
  
  public ErrorLogResult(String paramString)
  {
    this(paramString, 5);
  }
  
  public ErrorLogResult(String paramString, int paramInt)
  {
    this.tag = paramString;
    this.level = paramInt;
  }
  
  public void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(" details: ");
      paramString1.append(paramObject);
    }
    for (paramString1 = paramString1.toString(); this.level < 5; paramString1 = "") {
      return;
    }
    int i = this.level;
    paramObject = this.tag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    Log.println(i, paramObject, localStringBuilder.toString());
  }
  
  public void notImplemented()
  {
    if (this.level < 5) {
      return;
    }
    Log.println(this.level, this.tag, "method not implemented");
  }
  
  public void success(@Nullable Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugin.common.ErrorLogResult
 * JD-Core Version:    0.7.0.1
 */