package com.tencent.qidian.controller;

import com.tencent.mobileqq.pb.MessageMicro;

public class BigDataHandler$ReqStruct
{
  MessageMicro<?> a = null;
  int b = 0;
  int c = 0;
  Object d = null;
  
  public BigDataHandler$ReqStruct(int paramInt1, MessageMicro<?> paramMessageMicro, int paramInt2, Object paramObject)
  {
    this.b = paramInt1;
    this.a = paramMessageMicro;
    this.c = paramInt2;
    this.d = paramObject;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public MessageMicro<?> b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public Object d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataHandler.ReqStruct
 * JD-Core Version:    0.7.0.1
 */