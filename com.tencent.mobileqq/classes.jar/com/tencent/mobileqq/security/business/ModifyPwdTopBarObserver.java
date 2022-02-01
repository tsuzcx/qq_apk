package com.tencent.mobileqq.security.business;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class ModifyPwdTopBarObserver
  implements BusinessObserver
{
  public final String f = "ModifyPwdTopBarObserver";
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (a(paramObject))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, new ModifyPwdTopBarObserver.ModifyPwdTopBarInfo(this, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue()));
      return;
    }
    QLog.e("ModifyPwdTopBarObserver", 2, "onUpdateDisplayInfo error");
  }
  
  private boolean a(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 5);
  }
  
  public void a(boolean paramBoolean, ModifyPwdTopBarObserver.ModifyPwdTopBarInfo paramModifyPwdTopBarInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.security.business.ModifyPwdTopBarObserver
 * JD-Core Version:    0.7.0.1
 */