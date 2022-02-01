package com.tencent.mobileqq.leba.controller.table;

import android.text.TextUtils;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import mqq.app.AppRuntime;

class LebaTabletController$LebaTableRedTouch
  extends LebaRedTouchBase
{
  public BusinessInfoCheckUpdate.AppInfo a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (String.valueOf(1130).equals(paramString))) {
      paramAppRuntime = null;
    }
    do
    {
      do
      {
        return paramAppRuntime;
        paramString = ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, paramString);
        paramAppRuntime = paramString;
      } while (!RedTouch.a(paramString));
      paramAppRuntime = paramString;
    } while (paramString.type.get() == 5);
    RedTouch.d(paramString);
    return paramString;
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.b(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTabletController.LebaTableRedTouch
 * JD-Core Version:    0.7.0.1
 */