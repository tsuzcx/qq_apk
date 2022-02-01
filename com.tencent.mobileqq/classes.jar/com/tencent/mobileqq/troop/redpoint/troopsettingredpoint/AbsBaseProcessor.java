package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.QQAppInterface;

public abstract class AbsBaseProcessor
{
  protected String a;
  protected QQAppInterface b;
  
  public AbsBaseProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.b = paramQQAppInterface;
    this.a = paramString;
  }
  
  public abstract String a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.AbsBaseProcessor
 * JD-Core Version:    0.7.0.1
 */