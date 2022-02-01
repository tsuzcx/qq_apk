package com.tencent.mobileqq.gamecenter.sso;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class GameCenterUnissoObserver
  implements BusinessObserver
{
  private int a;
  
  public GameCenterUnissoObserver(int paramInt)
  {
    this.a = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[GameCenterUnissoObserver], hashcode:");
    localStringBuilder.append(this.a);
    QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, localStringBuilder.toString());
  }
  
  private boolean a(int paramInt, Object paramObject)
  {
    if (b(paramInt, paramObject)) {
      return true;
    }
    if (paramInt != 8224)
    {
      if (paramInt != 8225)
      {
        switch (paramInt)
        {
        default: 
          return false;
        case 8275: 
          b((JSONObject)paramObject);
          return true;
        case 8274: 
          a((JSONObject)paramObject);
          return true;
        }
        h(paramObject);
        return true;
      }
      e(paramObject);
      return true;
    }
    b(paramObject);
    return true;
  }
  
  private boolean b(int paramInt, Object paramObject)
  {
    if (paramInt != 8261)
    {
      if (paramInt != 8262)
      {
        switch (paramInt)
        {
        default: 
          return false;
        case 8228: 
          f(paramObject);
          return true;
        case 8227: 
          a(paramObject);
          return true;
        }
        c(paramObject);
        return true;
      }
      g(paramObject);
      return true;
    }
    d(paramObject);
    return true;
  }
  
  public void a() {}
  
  public void a(Object paramObject) {}
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b() {}
  
  public void b(Object paramObject) {}
  
  public void b(JSONObject paramJSONObject) {}
  
  public void c(Object paramObject) {}
  
  public void d(Object paramObject) {}
  
  public void e(Object paramObject) {}
  
  public void f(Object paramObject) {}
  
  public void g(Object paramObject) {}
  
  public void h(Object paramObject) {}
  
  public void i(Object paramObject) {}
  
  public void j(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GameCenterSsoRspData)) {
        return;
      }
      paramObject = (GameCenterSsoRspData)paramObject;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("self:");
        localStringBuilder.append(this.a);
        localStringBuilder.append(",rspData:");
        localStringBuilder.append(paramObject.a);
        QLog.d("GameCenterMsg.GameCenterUnissoObserver", 2, localStringBuilder.toString());
      }
      if (this.a != paramObject.a)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("hashCode Not the same. rspDaat.hashcode:");
        localStringBuilder.append(paramObject.a);
        QLog.i("GameCenterMsg.GameCenterUnissoObserver", 1, localStringBuilder.toString());
        return;
      }
      paramObject = paramObject.b;
      if (a(paramInt, paramObject)) {
        return;
      }
      if (paramInt != 8272)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 8265: 
          b();
          return;
        case 8264: 
          j(paramObject);
          return;
        }
        i(paramObject);
        return;
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver
 * JD-Core Version:    0.7.0.1
 */