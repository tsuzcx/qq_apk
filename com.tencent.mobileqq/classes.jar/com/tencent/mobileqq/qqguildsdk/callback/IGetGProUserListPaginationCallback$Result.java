package com.tencent.mobileqq.qqguildsdk.callback;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.Collections;
import java.util.List;

public class IGetGProUserListPaginationCallback$Result
{
  public int a;
  public String b;
  public List<IGProUserInfo> c;
  public boolean d;
  public Object e;
  
  public static Result a(int paramInt, String paramString)
  {
    Result localResult = new Result();
    localResult.a = paramInt;
    localResult.b = paramString;
    localResult.c = Collections.emptyList();
    localResult.d = true;
    return localResult;
  }
  
  public static Result a(List<IGProUserInfo> paramList, Object paramObject, boolean paramBoolean)
  {
    Result localResult = new Result();
    localResult.a = 0;
    localResult.b = "";
    localResult.c = paramList;
    localResult.d = paramBoolean;
    localResult.e = paramObject;
    return localResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Result{code=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", message='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", list.size=");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", cookie=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result
 * JD-Core Version:    0.7.0.1
 */