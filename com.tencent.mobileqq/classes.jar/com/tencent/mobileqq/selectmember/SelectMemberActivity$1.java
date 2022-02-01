package com.tencent.mobileqq.selectmember;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.qphone.base.util.QLog;

class SelectMemberActivity$1
  implements Runnable
{
  SelectMemberActivity$1(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void run()
  {
    Object localObject = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopManagerBizHandlerName();
    localObject = (ITroopManagerBizHandler)this.this$0.app.getBusinessHandler((String)localObject);
    if (localObject != null) {}
    try
    {
      ((ITroopManagerBizHandler)localObject).a(Long.valueOf(this.this$0.mGroupCode));
      ((ITroopManagerBizHandler)localObject).b(Long.valueOf(this.this$0.mGroupCode));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label66:
      break label66;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NumberFormatException : mGroupCode = ");
      ((StringBuilder)localObject).append(this.this$0.mGroupCode);
      QLog.e("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */