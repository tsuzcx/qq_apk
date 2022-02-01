package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.BaseMessageNavigateInfo;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

public abstract class BaseAioNavigateBarManager
  extends Observable
  implements Manager
{
  protected AppInterface e;
  
  public BaseAioNavigateBarManager() {}
  
  public BaseAioNavigateBarManager(AppInterface paramAppInterface)
  {
    this.e = paramAppInterface;
  }
  
  public long a(String paramString, long paramLong)
  {
    return 0L;
  }
  
  protected void a(@Nullable BaseMessageNavigateInfo paramBaseMessageNavigateInfo1, BaseMessageNavigateInfo paramBaseMessageNavigateInfo2, int paramInt)
  {
    if (TroopAioNavigateUtil.a(paramInt))
    {
      paramBaseMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_ADD;
      return;
    }
    if ((paramBaseMessageNavigateInfo1 != null) && (paramBaseMessageNavigateInfo1.status != BaseMessageNavigateInfo.STATUS_DELETE))
    {
      paramBaseMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_MODIFY;
      return;
    }
    paramBaseMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_ADD;
  }
  
  protected abstract boolean a(int paramInt);
  
  public List<Long> b(String paramString, int paramInt)
  {
    return null;
  }
  
  protected void b(String paramString) {}
  
  public void c(String paramString, int paramInt) {}
  
  protected abstract String e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.BaseAioNavigateBarManager
 * JD-Core Version:    0.7.0.1
 */