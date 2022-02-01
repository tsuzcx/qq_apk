package com.tencent.mobileqq.newfriend.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NewFriendVerificationObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onUpdate() type =");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (QLog.isColorLevel())
            {
              paramObject = new StringBuilder();
              paramObject.append(" default type =");
              paramObject.append(paramInt);
              QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, paramObject.toString());
            }
          }
          else
          {
            paramObject = (Object[])paramObject;
            localObject = (List)paramObject[0];
            String str = (String)paramObject[1];
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(" blockedInfos =");
              if (localObject != null) {
                paramObject = Integer.valueOf(((List)localObject).size());
              } else {
                paramObject = " is null";
              }
              localStringBuilder.append(paramObject);
              QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, localStringBuilder.toString());
            }
            a(paramBoolean, (List)localObject, str);
          }
        }
        else
        {
          localObject = (Object[])paramObject;
          boolean bool1 = ((Boolean)localObject[0]).booleanValue();
          boolean bool2 = ((Boolean)localObject[1]).booleanValue();
          paramObject = (String)localObject[2];
          boolean bool3 = ((Boolean)localObject[3]).booleanValue();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" isShowEntrance =");
            ((StringBuilder)localObject).append(bool1);
            ((StringBuilder)localObject).append(" isShowRedPoint =");
            ((StringBuilder)localObject).append(bool2);
            ((StringBuilder)localObject).append(" isShowRedPointAtNewFriendBanner = ");
            ((StringBuilder)localObject).append(bool3);
            QLog.d("NEW_FRD.NewFriendVerificationObserver", 2, ((StringBuilder)localObject).toString());
          }
          a(paramBoolean, bool1, bool2, paramObject, bool3);
        }
      }
      else {
        a(paramBoolean, null);
      }
    }
    else {
      b(paramBoolean, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver
 * JD-Core Version:    0.7.0.1
 */