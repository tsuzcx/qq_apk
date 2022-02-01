package com.tencent.mobileqq.search.rich;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface IRichNode
{
  public abstract void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(IRichNodeEvent paramIRichNodeEvent);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract int d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract IRichNodeView h();
  
  public abstract int i();
  
  public abstract String j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.IRichNode
 * JD-Core Version:    0.7.0.1
 */