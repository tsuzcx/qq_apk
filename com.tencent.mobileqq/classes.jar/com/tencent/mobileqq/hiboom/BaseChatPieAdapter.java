package com.tencent.mobileqq.hiboom;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.api.IBaseChatPieAdapter;
import com.tencent.widget.XEditText;

public class BaseChatPieAdapter
  implements IBaseChatPieAdapter
{
  private BaseChatPie a;
  
  public BaseChatPieAdapter(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public Object a()
  {
    return this.a;
  }
  
  public QQAppInterface b()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie == null) {
      return null;
    }
    return localBaseChatPie.d;
  }
  
  public Context c()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.d != null)) {
      return this.a.d.getApp();
    }
    return null;
  }
  
  public XEditText d()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie == null) {
      return null;
    }
    return localBaseChatPie.Y;
  }
  
  public BaseSessionInfo e()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie == null) {
      return null;
    }
    return localBaseChatPie.ah;
  }
  
  public void f()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie != null) {
      localBaseChatPie.aF();
    }
  }
  
  public int g()
  {
    BaseChatPie localBaseChatPie = this.a;
    if (localBaseChatPie != null) {
      return localBaseChatPie.F();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.BaseChatPieAdapter
 * JD-Core Version:    0.7.0.1
 */