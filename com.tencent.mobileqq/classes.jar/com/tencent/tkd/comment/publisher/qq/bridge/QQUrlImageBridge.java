package com.tencent.tkd.comment.publisher.qq.bridge;

public abstract interface QQUrlImageBridge
{
  public static final QQUrlImageBridge EMPTY = new QQUrlImageBridge.1();
  
  public abstract void loadUrlImage(String paramString, int paramInt1, int paramInt2, QQUrlImageBridge.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge
 * JD-Core Version:    0.7.0.1
 */