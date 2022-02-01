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
    return "Result{status=" + this.status + ", message='" + this.message + '\'' + ", data=" + this.data + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.bridge.Result
 * JD-Core Version:    0.7.0.1
 */