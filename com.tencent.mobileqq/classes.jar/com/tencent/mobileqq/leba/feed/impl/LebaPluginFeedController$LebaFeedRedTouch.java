package com.tencent.mobileqq.leba.feed.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import mqq.app.AppRuntime;

class LebaPluginFeedController$LebaFeedRedTouch
  extends LebaRedTouchBase
{
  public BusinessInfoCheckUpdate.AppInfo a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (String.valueOf(1130).equals(paramString))) {
      return null;
    }
    paramAppRuntime = ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, paramString);
    if (RedTouch.d(paramAppRuntime))
    {
      paramAppRuntime.type.set(0);
      paramAppRuntime.red_display_info.red_type_info.clear();
      paramString = new BusinessInfoCheckUpdate.RedTypeInfo();
      paramString.red_type.set(0);
      paramAppRuntime.red_display_info.red_type_info.add(paramString);
    }
    return paramAppRuntime;
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.b(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.impl.LebaPluginFeedController.LebaFeedRedTouch
 * JD-Core Version:    0.7.0.1
 */