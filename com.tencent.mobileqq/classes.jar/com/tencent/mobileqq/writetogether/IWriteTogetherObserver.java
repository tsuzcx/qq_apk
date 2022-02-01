package com.tencent.mobileqq.writetogether;

import com.tencent.mobileqq.writetogether.websocket.msg.Type;

public abstract interface IWriteTogetherObserver
{
  public abstract void a(Type paramType, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.IWriteTogetherObserver
 * JD-Core Version:    0.7.0.1
 */