package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import java.util.List;

public class TeamWorkObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List<TimDocSSOMsg.UinRightInfo> paramList) {}
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void b(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void c(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void d(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2)
    {
      if (paramInt != 13)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 11: 
          if (paramObject == null) {
            return;
          }
          d(paramBoolean, (Object[])paramObject);
          return;
        case 9: 
          if (paramObject != null) {
            b(paramBoolean, (Object[])paramObject);
          }
        case 10: 
          if (paramObject == null) {
            return;
          }
          c(paramBoolean, (Object[])paramObject);
          return;
        case 8: 
          if (paramObject == null) {
            return;
          }
          a(paramBoolean, (Object[])paramObject);
          return;
        case 7: 
          if (paramObject == null) {
            return;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (List)paramObject[2]);
          return;
        case 6: 
          if (paramObject == null) {
            return;
          }
          paramObject = (Object[])paramObject;
          b(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
          return;
        }
        if (paramObject != null)
        {
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
        }
      }
      else if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2) {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
        }
      }
    }
    else if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkObserver
 * JD-Core Version:    0.7.0.1
 */