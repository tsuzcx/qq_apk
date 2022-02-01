package com.tencent.mobileqq.search.rich;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class RichNodeBase
  implements IRichNode
{
  protected QQAppInterface a;
  protected Context b;
  private WeakReference<IRichNodeEvent> c;
  private IRichNodeView d;
  private RichMetaData e = new RichMetaData();
  private String f;
  private int g;
  
  protected abstract IRichNodeView a(Context paramContext);
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("create, serverdata:");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append("  extredata:");
      paramQQAppInterface.append(paramString2);
      paramQQAppInterface.append(" config:");
      paramQQAppInterface.append(paramString3);
      paramQQAppInterface.append(" templateid:");
      paramQQAppInterface.append(paramInt);
      QLog.d("RichNodeBase", 2, paramQQAppInterface.toString());
    }
    this.e.a(true);
    this.e.a(paramString1);
    this.e.b(paramString2);
    this.f = paramString3;
    this.g = paramInt;
    this.d = a(paramContext);
  }
  
  public void a(IRichNodeEvent paramIRichNodeEvent)
  {
    this.c = new WeakReference(paramIRichNodeEvent);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateData, serverdata:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  extredata:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" config:");
      localStringBuilder.append(paramString3);
      QLog.d("RichNodeBase", 2, localStringBuilder.toString());
    }
    this.e.a(paramString1);
    this.e.b(paramString2);
    this.f = paramString3;
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fireEvent, key:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" value:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("RichNodeBase", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (IRichNodeEvent)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IRichNodeEvent)localObject).a(this, paramString1, paramString2);
      }
    }
  }
  
  protected void c() {}
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "pause");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "resume");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "destroy");
    }
    c();
    this.a = null;
    this.b = null;
    this.c = null;
    IRichNodeView localIRichNodeView = this.d;
    if (localIRichNodeView != null)
    {
      localIRichNodeView.l();
      this.d = null;
    }
    this.f = null;
    this.e = null;
  }
  
  public IRichNodeView h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.e.a();
  }
  
  protected void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (IRichNodeEvent)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IRichNodeEvent)localObject).a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeBase
 * JD-Core Version:    0.7.0.1
 */