package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.listentogether.data.ISong;
import java.util.List;

public class ListenTogetherObserver
  implements BusinessObserver
{
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  protected void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(ListenTogetherSession paramListenTogetherSession) {}
  
  protected void a(ISong paramISong) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, long paramLong, int paramInt2, int paramInt3, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3) {}
  
  protected void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList) {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void c(int paramInt, String paramString) {}
  
  protected void d() {}
  
  protected void d(int paramInt, String paramString) {}
  
  protected void e(int paramInt, String paramString) {}
  
  protected void f(int paramInt, String paramString) {}
  
  protected void g(int paramInt, String paramString) {}
  
  protected void h(int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 24: 
      paramObject = (Object[])paramObject;
      if (paramBoolean)
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), 0, "");
        return;
      }
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Long)paramObject[2]).longValue(), 0, ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 23: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 22: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 21: 
      paramObject = (Object[])paramObject;
      f(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 20: 
      paramObject = (Object[])paramObject;
      e(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 19: 
      paramObject = (Object[])paramObject;
      b(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 18: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    case 17: 
      paramObject = (Object[])paramObject;
      if (paramBoolean)
      {
        a(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2]);
        return;
      }
      a(true, (String)paramObject[0], 0, null);
      return;
    case 16: 
      d();
      return;
    case 15: 
      paramObject = (Object[])paramObject;
      a(((Boolean)paramObject[0]).booleanValue(), (ListenTogetherSession)paramObject[1]);
      return;
    case 14: 
      paramObject = (Object[])paramObject;
      h(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 13: 
      a((ISong)((Object[])(Object[])paramObject)[0]);
      return;
    case 12: 
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 11: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 10: 
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    case 9: 
      paramObject = (Object[])paramObject;
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      g(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      d(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      c(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    }
    a((ListenTogetherSession)((Object[])(Object[])paramObject)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherObserver
 * JD-Core Version:    0.7.0.1
 */