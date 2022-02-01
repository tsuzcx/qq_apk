package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class OnlineStatusConstants
{
  public static final AppRuntime.Status[] a = { AppRuntime.Status.online, AppRuntime.Status.qme, AppRuntime.Status.away, AppRuntime.Status.busy, AppRuntime.Status.dnd, AppRuntime.Status.invisiable };
  
  public static int a(AppRuntime.Status paramStatus)
  {
    int j = OnlineStatusConstants.1.a[paramStatus.ordinal()];
    int i = 2131361914;
    switch (j)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getButtonId changed to online , status: ");
      localStringBuilder.append(paramStatus);
      QLog.d("Q..online.status", 1, localStringBuilder.toString());
      return 2131361914;
    case 6: 
      return 2131361913;
    case 5: 
      return 2131361912;
    case 4: 
      return 2131361911;
    case 3: 
      return 2131361910;
    case 2: 
      i = 2131361915;
    }
    return i;
  }
  
  public static Drawable a(AppRuntime.Status paramStatus)
  {
    return a(paramStatus, 0);
  }
  
  public static Drawable a(AppRuntime.Status paramStatus, int paramInt)
  {
    Object localObject1 = null;
    if (paramStatus != null) {}
    try
    {
      localObject2 = MobileQQ.sMobileQQ;
      switch (OnlineStatusConstants.1.a[paramStatus.ordinal()])
      {
      case 6: 
        paramStatus = ((Context)localObject2).getResources().getDrawable(2130837640);
      }
    }
    catch (Exception paramStatus)
    {
      Object localObject2;
      break label183;
    }
    paramStatus = ((Context)localObject2).getResources().getDrawable(2130837638);
    break label215;
    paramStatus = ((Context)localObject2).getResources().getDrawable(2130837635);
    break label215;
    paramStatus = ((Context)localObject2).getResources().getDrawable(2130837633);
    break label215;
    paramStatus = ((Context)localObject2).getResources().getDrawable(2130837644);
    break label215;
    paramStatus = ((Context)localObject2).getResources().getDrawable(2130837642);
    break label215;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getStatusIcon, not find status: ");
    ((StringBuilder)localObject2).append(paramStatus);
    QLog.d("Q..online.status", 1, ((StringBuilder)localObject2).toString());
    paramStatus = localObject1;
    break label194;
    QLog.d("Q..online.status", 1, "getStatusIcon, status == null");
    paramStatus = localObject1;
    break label194;
    label183:
    QLog.d("Q..online.status", 1, "getStatusDrawable", paramStatus);
    paramStatus = localObject1;
    label194:
    label215:
    for (;;)
    {
      if ((paramStatus != null) && (paramInt > 0)) {
        paramStatus.setBounds(0, 0, paramInt, paramInt);
      }
      return paramStatus;
      break;
    }
  }
  
  public static String a(AppRuntime.Status paramStatus)
  {
    Object localObject = MobileQQ.sMobileQQ;
    if (paramStatus != null) {
      switch (OnlineStatusConstants.1.a[paramStatus.ordinal()])
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getStatusName, not find status: ");
        ((StringBuilder)localObject).append(paramStatus);
        QLog.d("Q..online.status", 1, ((StringBuilder)localObject).toString());
        break;
      case 6: 
        return ((Context)localObject).getString(2131719227);
      case 5: 
        return ((Context)localObject).getString(2131719225);
      case 4: 
        return ((Context)localObject).getString(2131719221);
      case 3: 
        return ((Context)localObject).getString(2131719219);
      case 2: 
        return ((Context)localObject).getString(2131719231);
      case 1: 
        return ((Context)localObject).getString(2131719230);
      }
    } else {
      QLog.d("Q..online.status", 1, "getStatusName, status is null");
    }
    return "";
  }
  
  public static AppRuntime.Status a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 7: 
      return AppRuntime.Status.dnd;
    case 6: 
      return AppRuntime.Status.qme;
    case 5: 
      return AppRuntime.Status.busy;
    case 4: 
      return AppRuntime.Status.invisiable;
    case 3: 
      return AppRuntime.Status.away;
    case 2: 
      return AppRuntime.Status.offline;
    }
    return AppRuntime.Status.online;
  }
  
  public static boolean a(AppRuntime.Status paramStatus)
  {
    return (paramStatus == AppRuntime.Status.away) || (paramStatus == AppRuntime.Status.busy) || (paramStatus == AppRuntime.Status.dnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusConstants
 * JD-Core Version:    0.7.0.1
 */