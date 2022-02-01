package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GroupTeamWorkObserver
  implements BusinessObserver
{
  public static String a = "GroupTeamWorkObserver";
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List<GPadInfo> paramList) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean1, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GroupTeamWorkObserver type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 7) {
              return;
            }
            if (paramObject != null)
            {
              paramObject = (Object[])paramObject;
              if (paramObject.length == 3) {
                b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
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
        else if (paramObject != null)
        {
          paramObject = (Object[])paramObject;
          if (paramObject.length == 3) {
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (List)paramObject[2]);
          }
        }
      }
      else if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 5) {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (List)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue());
        }
      }
    }
    else if (paramObject != null)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 5) {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (List)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkObserver
 * JD-Core Version:    0.7.0.1
 */