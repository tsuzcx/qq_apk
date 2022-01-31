package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessObserver;

public class PstnObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(Boolean paramBoolean, int paramInt) {}
  
  public void a(Boolean paramBoolean, long paramLong, boolean paramBoolean1) {}
  
  public void a(Boolean paramBoolean, Object paramObject) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, PstnCardInfo paramPstnCardInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    long l;
    switch (paramInt)
    {
    default: 
      return;
    case 60000: 
      a(paramBoolean, (PstnCardInfo)paramObject);
      return;
    case 60001: 
      a(paramBoolean);
      return;
    case 60002: 
      l = 0L;
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2) {
          l = ((Long)paramObject[0]).longValue();
        }
      }
      break;
    }
    for (paramBoolean = ((Boolean)paramObject[1]).booleanValue();; paramBoolean = bool2)
    {
      a(Boolean.valueOf(bool1), l, paramBoolean);
      return;
      if ((paramObject == null) || (!(paramObject instanceof Integer))) {
        break;
      }
      a(Boolean.valueOf(paramBoolean), ((Integer)paramObject).intValue());
      return;
      a(Boolean.valueOf(paramBoolean), paramObject);
      return;
      a();
      return;
      if (paramObject == null) {
        break;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length != 2) {
        break;
      }
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
      if (paramObject == null) {
        break;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length != 3) {
        break;
      }
      a((String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.PstnObserver
 * JD-Core Version:    0.7.0.1
 */