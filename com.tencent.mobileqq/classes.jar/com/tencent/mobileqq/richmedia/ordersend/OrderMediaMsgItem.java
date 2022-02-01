package com.tencent.mobileqq.richmedia.ordersend;

import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageRecord;

public class OrderMediaMsgItem
{
  int a;
  int b;
  int c;
  long d;
  String e;
  boolean f;
  boolean g;
  MessageRecord h;
  MediaMessageObserver i;
  IOrderMediaMsgService.IMsgSendingListener j;
  Runnable k;
  
  public boolean a()
  {
    return (this.h != null) && (this.b == 1);
  }
  
  public boolean b()
  {
    return (this.h != null) && (this.b >= 2);
  }
  
  public boolean c()
  {
    return (this.h != null) && (this.c == 3);
  }
  
  public boolean d()
  {
    return (this.h != null) && (this.c >= 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(90);
    localStringBuilder.append(" MsgItem{index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uniseq=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", addStatus=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sendStatus=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isInvalid=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgItem
 * JD-Core Version:    0.7.0.1
 */