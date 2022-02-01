package com.tencent.mobileqq.leba.controller.list;

import android.text.TextUtils;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class LebaListController$LebaListRedTouch
  extends LebaRedTouchBase
{
  public BusinessInfoCheckUpdate.AppInfo a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (String.valueOf(1130).equals(paramString))) {
      return null;
    }
    paramAppRuntime = ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(0, paramString);
    if ((RedTouch.a(paramAppRuntime)) && (paramAppRuntime.type.get() != 5) && (paramAppRuntime.red_display_info.has()) && (paramAppRuntime.red_display_info.get() != null) && (paramAppRuntime.red_display_info.red_type_info.has()) && (paramAppRuntime.red_display_info.red_type_info.get() != null))
    {
      int i = paramAppRuntime.type.get();
      if ((i == 11) || (i == 16) || (i == 17)) {
        paramAppRuntime.type.set(0);
      }
      paramString = paramAppRuntime.red_display_info.red_type_info.get().iterator();
      while (paramString.hasNext()) {
        a((BusinessInfoCheckUpdate.RedTypeInfo)paramString.next());
      }
    }
    return paramAppRuntime;
  }
  
  public String a(String paramString)
  {
    if (paramString.length() <= 8) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, 8));
    localStringBuilder.append("...");
    return localStringBuilder.toString();
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    int j = paramRedTypeInfo.red_type.get();
    int i = 0;
    if ((j != 11) && (j != 17))
    {
      String str;
      if (j == 16)
      {
        paramRedTypeInfo.red_type.set(4);
        str = paramRedTypeInfo.red_content.get();
        if (!TextUtils.isEmpty(str))
        {
          if (str.indexOf("\\n") == 7)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str.substring(0, 7));
            localStringBuilder.append("...");
            str = localStringBuilder.toString();
          }
          else
          {
            str = a(str.replace("\\n", "，"));
          }
          paramRedTypeInfo.red_content.set(str);
        }
      }
      else if (j == 4)
      {
        str = paramRedTypeInfo.red_content.get();
        if (!TextUtils.isEmpty(str)) {
          paramRedTypeInfo.red_content.set(a(str));
        }
      }
      else if (j == 9)
      {
        try
        {
          j = Integer.parseInt(paramRedTypeInfo.red_content.get());
          i = j;
        }
        catch (Exception localException)
        {
          QLog.e("Q.lebatab.LebaListController", 1, localException, new Object[0]);
        }
        if (i <= 0) {
          paramRedTypeInfo.red_content.set("8");
        }
      }
    }
    else
    {
      paramRedTypeInfo.red_type.set(0);
    }
  }
  
  public void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramRedTouch.a(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListController.LebaListRedTouch
 * JD-Core Version:    0.7.0.1
 */