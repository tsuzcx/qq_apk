package com.tencent.tkd.comment.publisher.qq.bridge;

public abstract interface QQSharedPreferenceBridge
{
  public abstract <T> T getValue(String paramString, T paramT);
  
  public abstract <T> void setValue(String paramString, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge
 * JD-Core Version:    0.7.0.1
 */