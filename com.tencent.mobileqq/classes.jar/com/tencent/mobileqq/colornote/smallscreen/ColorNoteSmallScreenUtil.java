package com.tencent.mobileqq.colornote.smallscreen;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorNoteSmallScreenUtil
{
  private static boolean a = false;
  private static boolean b = false;
  private static Point c = new Point(-1, -1);
  
  public static int a(ColorNote paramColorNote)
  {
    if ((paramColorNote != null) && (ColorNoteUtils.i(paramColorNote))) {
      return 2;
    }
    if (ColorNoteUtils.d(paramColorNote)) {
      return 3;
    }
    return 1;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    paramString = paramString.split("@");
    if ((paramString != null) && (paramString.length > 0))
    {
      paramString = paramString[0];
      if (!TextUtils.isEmpty(paramString)) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("color_note_");
    localStringBuilder.append(paramString);
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static Point a(AppRuntime paramAppRuntime)
  {
    if ((c.x == -1) || (c.y == -1))
    {
      paramAppRuntime = a(paramAppRuntime.getApp(), paramAppRuntime.getCurrentUin());
      int j = paramAppRuntime.getInt("colornote_windows_x", -1);
      int i = paramAppRuntime.getInt("colornote_windows_y", -1);
      if ((j != -1) && (i != -1)) {
        break label92;
      }
      j = ViewUtils.getScreenWidth() - ViewUtils.dip2px(25.0F);
      i = ViewUtils.getScreenHeight() / 2;
      i = ViewUtils.dip2px(25.0F) + i;
      label92:
      paramAppRuntime = c;
      paramAppRuntime.x = j;
      paramAppRuntime.y = i;
    }
    return c;
  }
  
  protected static void a(int paramInt1, int paramInt2)
  {
    Point localPoint = c;
    localPoint.x = paramInt1;
    localPoint.y = paramInt2;
  }
  
  public static void a(Context paramContext)
  {
    if (!a)
    {
      a = true;
      Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
      try
      {
        paramContext.startService(localIntent);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("actionOn e = ");
          localStringBuilder.append(localException);
          QLog.d("ColorNoteSmallScreenUtil", 2, localStringBuilder.toString());
        }
        a = false;
      }
    }
    a(paramContext, 3, true);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendUpdateSmallScreenStateBroadcast sHasServiceExit = ");
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append(", from = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", shouldShow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ColorNoteSmallScreenUtil", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent("action_update_cn_smallscreen_state");
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    ((Intent)localObject).putExtra("param_from", paramInt);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          if (paramInt != 4)
          {
            if (paramInt == 6) {
              ((Intent)localObject).putExtra("param_custom_night_mode", paramBoolean);
            }
          }
          else
          {
            if (paramBoolean)
            {
              Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
              try
              {
                paramContext.startService(localIntent);
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel())
                {
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("actionOn e = ");
                  localStringBuilder.append(localException);
                  QLog.d("ColorNoteSmallScreenUtil", 2, localStringBuilder.toString());
                }
              }
            }
            ((Intent)localObject).putExtra("param_is_app_foreground", paramBoolean);
          }
        }
      }
      else {
        ((Intent)localObject).putExtra("param_shoule_show_smallscreen", paramBoolean);
      }
    }
    else {
      ((Intent)localObject).putExtra("param_not_in_colornote_list", paramBoolean);
    }
    paramContext.sendBroadcast((Intent)localObject);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("sendUpdateSmallScreenStateBroadcast:");
      paramContext.append(paramBoolean);
      QLog.d("ColorNoteSmallScreenUtil", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
    localIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
    localIntent.putExtra("KEY_SHOW_LIST_LAND", paramBoolean);
    paramContext.startService(localIntent);
  }
  
  public static void a(TextView paramTextView, String paramString1, int paramInt1, TextUtils.TruncateAt paramTruncateAt, String paramString2, int paramInt2)
  {
    if (paramTextView != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      float f1 = paramTextView.getPaint().measureText(paramString1);
      float f2 = paramInt1 - paramInt2;
      if (f2 >= f1)
      {
        paramTextView.setText(paramString1);
        return;
      }
      float f3;
      if (paramTruncateAt == TextUtils.TruncateAt.END)
      {
        CharSequence localCharSequence = TextUtils.ellipsize(paramString1, paramTextView.getPaint(), f2, paramTruncateAt);
        f1 = paramTextView.getPaint().measureText((String)localCharSequence);
        f3 = paramTextView.getPaint().measureText("的");
        paramString2 = localCharSequence;
        if (f2 - f1 > f3 / 2.0F)
        {
          paramString2 = localCharSequence;
          if (paramInt2 != 0)
          {
            paramInt2 = (int)(f2 + f3);
            paramTextView.setMaxWidth((int)(paramInt1 + f3));
            paramString2 = TextUtils.ellipsize(paramString1, paramTextView.getPaint(), paramInt2, paramTruncateAt);
          }
        }
        paramTextView.setText(paramString2);
        return;
      }
      if ((paramTruncateAt == TextUtils.TruncateAt.MIDDLE) && (!TextUtils.isEmpty(paramString2)))
      {
        paramInt1 = paramString1.lastIndexOf(paramString2);
        if (paramInt1 == -1)
        {
          paramTextView.setText(paramString1);
          return;
        }
        paramTruncateAt = paramString1.substring(0, paramInt1);
        paramString2 = new StringBuilder();
        paramString2.append("…");
        paramString2.append(paramString1.substring(paramInt1));
        paramString2 = paramString2.toString();
        f1 = paramTextView.getPaint().measureText(paramTruncateAt);
        f3 = paramTextView.getPaint().measureText(paramString2);
        if (f3 > f2)
        {
          paramTextView.setText(paramString1);
          return;
        }
        while (f2 - f1 < f3)
        {
          paramTruncateAt = paramTruncateAt.substring(0, paramTruncateAt.length() - 1);
          f1 = paramTextView.getPaint().measureText(paramTruncateAt);
        }
        paramString1 = new StringBuilder();
        paramString1.append(paramTruncateAt);
        paramString1.append(paramString2);
        paramTextView.setText(paramString1.toString());
        return;
      }
      paramTextView.setEllipsize(paramTruncateAt);
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenUtil", 2, "showPermissionDialog in");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_permission_from", paramInt);
    if ((paramInt == 3) && (ColorNoteRecentView.c(paramAppRuntime))) {
      return;
    }
    if (!ColorNoteSmallScreenPermissionDialogFragment.a) {
      QPublicFragmentActivity.Launcher.a(localIntent, QPublicTransFragmentActivity.class, ColorNoteSmallScreenPermissionDialogFragment.class);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (d(MobileQQ.getContext())) {
        bool = true;
      }
    }
    if ((bool) && (b))
    {
      IColorNoteDataService localIColorNoteDataService = (IColorNoteDataService)paramAppRuntime.getRuntimeService(IColorNoteDataService.class, "all");
      if ((paramAppRuntime.isLogin()) && (localIColorNoteDataService.getCurrentColorNoteCount() > 0)) {
        a(paramAppRuntime, false, true);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      a(paramAppRuntime, paramBoolean1, paramBoolean2, null);
      return;
    }
    finally
    {
      paramAppRuntime = finally;
      throw paramAppRuntime;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2, ColorNote paramColorNote)
  {
    try
    {
      BaseApplication localBaseApplication = paramAppRuntime.getApp();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showColorNoteSmallScreen , idAdd = ");
        localStringBuilder.append(paramBoolean1);
        localStringBuilder.append(", sHasServiceExit = ");
        localStringBuilder.append(a);
        localStringBuilder.append(", force = ");
        localStringBuilder.append(paramBoolean2);
        QLog.d("ColorNoteSmallScreenUtil", 1, localStringBuilder.toString());
      }
      int i = a(paramColorNote);
      if ((!ColorNoteSmallScreenPermissionUtil.a(localBaseApplication)) && (paramBoolean1)) {
        a(paramAppRuntime, i);
      }
      if ((a) && (!paramBoolean2))
      {
        a(localBaseApplication, 3, true);
      }
      else
      {
        a = true;
        paramAppRuntime = new Intent(localBaseApplication, ColorNoteSmallScreenService.class);
        try
        {
          localBaseApplication.startService(paramAppRuntime);
        }
        catch (Exception paramAppRuntime)
        {
          if (QLog.isColorLevel())
          {
            paramColorNote = new StringBuilder();
            paramColorNote.append("actionOn e = ");
            paramColorNote.append(paramAppRuntime);
            QLog.d("ColorNoteSmallScreenUtil", 2, paramColorNote.toString());
          }
          a = false;
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setAfterSyncMsg ");
        ((StringBuilder)localObject1).append(b);
        QLog.d("ColorNoteSmallScreenUtil", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new Intent("key_after_sync_msg");
      ((Intent)localObject1).putExtra("extra_after_sync_msg", b);
      MobileQQ.getContext().sendBroadcast((Intent)localObject1);
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    boolean bool1 = Build.MANUFACTURER.equalsIgnoreCase("meizu");
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (bool1) {}
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    bool1 = false;
    if (Build.DEVICE.equals("mx2")) {
      return true;
    }
    bool2 = bool3;
    if (!Build.DEVICE.equals("mx"))
    {
      if (Build.DEVICE.equals("m9")) {
        return false;
      }
      bool2 = bool1;
    }
    return bool2;
  }
  
  public static UpComingMsgModel b(ColorNote paramColorNote)
  {
    if ((paramColorNote != null) && (paramColorNote.getServiceType() == 17235968))
    {
      paramColorNote = new String(paramColorNote.getReserve());
      UpComingMsgModel localUpComingMsgModel = new UpComingMsgModel();
      localUpComingMsgModel.parseFromJson(paramColorNote);
      return localUpComingMsgModel;
    }
    return new UpComingMsgModel();
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hideColorNoteSmallScreen sHasServiceExit = ");
        ((StringBuilder)localObject).append(a);
        QLog.d("ColorNoteSmallScreenUtil", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Intent(paramContext, ColorNoteSmallScreenService.class);
      try
      {
        a = false;
        paramContext.stopService((Intent)localObject);
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("actionOff e = ");
          ((StringBuilder)localObject).append(paramContext);
          QLog.e("ColorNoteSmallScreenUtil", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    finally {}
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenUtil", 2, "[showListFromAddTodo], is called");
    }
    Intent localIntent = new Intent(paramContext, ColorNoteSmallScreenService.class);
    localIntent.putExtra("KEY_CMD_SHOW_LIST", 1);
    localIntent.putExtra("key_upcoming_notify", 2);
    localIntent.putExtra("KEY_SHOW_LIST_LAND", paramBoolean);
    paramContext.startService(localIntent);
  }
  
  public static boolean b()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAfterSyncMsg() ");
      localStringBuilder.append(b);
      QLog.d("ColorNoteSmallScreenUtil", 2, localStringBuilder.toString());
    }
    return b;
  }
  
  public static boolean c(Context paramContext)
  {
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localObject = null;
        paramContext = (Context)localObject;
        if (localList != null)
        {
          paramContext = (Context)localObject;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label268;
        }
        if (!QLog.isDevelopLevel()) {
          break label263;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isAppOnForeground componentName = ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("ColorNoteSmallScreenUtil", 2, ((StringBuilder)localObject).toString());
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        if (!QLog.isDevelopLevel()) {
          break label261;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isAppOnForeground e = ");
        ((StringBuilder)localObject).append(paramContext);
        QLog.d("ColorNoteSmallScreenUtil", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          localObject = paramContext.iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((paramContext.importance != 100) || (!paramContext.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("isAppOnForeground appProcess.processName = ");
              ((StringBuilder)localObject).append(paramContext.processName);
              QLog.d("ColorNoteSmallScreenUtil", 2, ((StringBuilder)localObject).toString());
            }
            return true;
          }
        }
      }
      else
      {
        return bool;
      }
      label261:
      return false;
      label263:
      boolean bool = true;
      continue;
      label268:
      bool = false;
    }
  }
  
  private static boolean d(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
      if (QLog.isDevelopLevel()) {
        QLog.d("FSReceiver", 4, new Object[] { "currTopPkg:", ((ComponentName)localObject).getPackageName() });
      }
      if (((ComponentName)localObject).getPackageName().equals(paramContext.getPackageName())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil
 * JD-Core Version:    0.7.0.1
 */