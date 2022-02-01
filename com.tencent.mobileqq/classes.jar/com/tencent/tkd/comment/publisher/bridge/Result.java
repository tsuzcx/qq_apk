package com.tencent.tkd.comment.publisher.bridge;

public class Result<T>
{
  public T data;
  public String message;
  public int status;
  
  public Result(int paramInt, String paramString)
  {
    this.status = paramInt;
    this.message = paramString;
  }
  
  public Result(T paramT)
  {
    this.data = paramT;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Result{status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", message='");
    localStringBuilder.append(this.message);
    localStringBuilder.append('\'');
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.data);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.bridge.Result
 * JD-Core Version:    0.7.0.1
 */