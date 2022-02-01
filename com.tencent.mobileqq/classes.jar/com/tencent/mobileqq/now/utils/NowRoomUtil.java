package com.tencent.mobileqq.now.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavUtil;

public class NowRoomUtil
{
  private static final String a = "NowRoomUtil";
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter now live room. mqqapi= ");
      localStringBuilder.append(paramString);
      LogUtility.b((String)localObject, localStringBuilder.toString());
    }
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.putExtra("big_brother_source_key", "biz_src_now");
      paramActivity.startActivity(paramString);
      return true;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel())
      {
        paramString = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enter now live room error: ");
        ((StringBuilder)localObject).append(paramActivity.getMessage());
        LogUtility.b(paramString, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return false;
    }
    if ((paramActivity != null) && (!NetworkUtil.isNetworkAvailable(paramActivity.getApplication())))
    {
      QfavUtil.a(paramActivity, 2131694435, 1);
      return false;
    }
    if ((paramString != null) && (paramString.startsWith("mqqapi://"))) {
      return a(paramActivity, paramString);
    }
    Object localObject2 = null;
    Object localObject1;
    if (paramInt1 > 0)
    {
      paramString = new StringBuilder();
      paramString.append("mqqapi://now/openroom?first=1&roomid=");
      paramString.append(paramInt1);
      paramString.append("&roomtype=0&startsrc=");
      paramString.append(paramInt2);
      paramString.append("&fromid=");
      paramString.append(paramInt2);
      localObject1 = paramString.toString();
    }
    else
    {
      localObject1 = localObject2;
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (paramString.contains("roomid=")) {
          try
          {
            paramString = Uri.parse(paramString).getQueryParameter("roomid");
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("mqqapi://now/openroom?first=1&roomid=");
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("&roomtype=0&startsrc=");
            ((StringBuilder)localObject1).append(paramInt2);
            ((StringBuilder)localObject1).append("&fromid=");
            ((StringBuilder)localObject1).append(paramInt2);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          catch (Exception paramString)
          {
            QLog.e(a, 2, paramString, new Object[0]);
            localObject1 = localObject2;
          }
        }
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
      return a(paramActivity, (String)localObject1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.utils.NowRoomUtil
 * JD-Core Version:    0.7.0.1
 */