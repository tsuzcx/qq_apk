package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class BlessSelectMemberActivity$1
  extends BaseMessageObserver
{
  BlessSelectMemberActivity$1(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBlessDirtyTextCheck ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ,code=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("BlessSelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
    int i = 1;
    if (paramBoolean)
    {
      paramInt = i;
    }
    else if (paramInt == 0)
    {
      paramInt = i;
    }
    else
    {
      if (paramInt == 1) {
        BlessSelectMemberActivity.a(this.a, 2131887578, true);
      } else if (paramInt == 8) {
        BlessSelectMemberActivity.a(this.a, 2131887602, true);
      }
      paramInt = 0;
    }
    if ((paramInt != 0) && (!BlessSelectMemberActivity.f()))
    {
      localObject = this.a;
      BlessSelectMemberActivity.a((BlessSelectMemberActivity)localObject, BlessSelectMemberActivity.a((BlessSelectMemberActivity)localObject));
      return;
    }
    this.a.d();
  }
  
  public void a(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSendBlessMsgResp ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" ,replyCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" waitTime=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" ,entrance=");
      ((StringBuilder)localObject).append(this.a.mEntrance);
      QLog.d("BlessSelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.a.e) {
      return;
    }
    Object localObject = this.a;
    ((BlessSelectMemberActivity)localObject).e = false;
    if (paramInt == 67L)
    {
      BlessSelectMemberActivity.b(System.currentTimeMillis());
      this.a.a(paramLong);
      this.a.d();
      BlessSelectMemberActivity.a(this.a, 2131887589, true);
      return;
    }
    if (((BlessSelectMemberActivity)localObject).mEntrance == 15)
    {
      this.a.a(paramBoolean1);
      return;
    }
    this.a.a(paramBoolean1, paramBoolean2);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onUpdateMsgContent, isSuc:");
      paramString.append(paramBoolean);
      paramString.append(" ,type:");
      paramString.append(BlessSelectMemberActivity.b(this.a));
      QLog.d("BlessSelectMemberActivity", 2, paramString.toString());
    }
    if (BlessSelectMemberActivity.b(this.a) == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value())
    {
      if (paramBoolean)
      {
        BlessSelectMemberActivity.c(this.a);
        return;
      }
      this.a.d();
      BlessSelectMemberActivity.a(this.a, 2131887588, false);
      return;
    }
    if (BlessSelectMemberActivity.b(this.a) == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) {
      if (((MessageForShortVideo)((IBlessApi)QRoute.api(IBlessApi.class)).getPtvMessage(this.a.app) != null) && (paramBoolean))
      {
        if (!BlessSelectMemberActivity.f()) {
          BlessSelectMemberActivity.d(this.a);
        }
      }
      else
      {
        this.a.d();
        BlessSelectMemberActivity.a(this.a, 2131887603, false);
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject;
    if ((paramObject instanceof Object[])) {
      arrayOfObject = (Object[])paramObject;
    } else {
      arrayOfObject = null;
    }
    int i = 0;
    if (paramInt == 8018)
    {
      paramInt = i;
      if (arrayOfObject != null)
      {
        paramInt = i;
        if (arrayOfObject.length == 1) {
          paramInt = ((Integer)arrayOfObject[0]).intValue();
        }
      }
      a(paramBoolean, paramInt);
      return;
    }
    if (paramInt == 8019)
    {
      if ((arrayOfObject != null) && (arrayOfObject.length == 3)) {
        a(paramBoolean, ((Integer)arrayOfObject[0]).intValue(), ((Long)arrayOfObject[1]).longValue(), ((Boolean)arrayOfObject[2]).booleanValue());
      }
    }
    else if (paramInt == 999)
    {
      if ((paramObject instanceof String))
      {
        a(paramBoolean, (String)paramObject);
        return;
      }
      a(paramBoolean, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */