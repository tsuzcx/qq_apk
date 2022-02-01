package com.tencent.mobileqq.intervideo.yiqikan;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenReporter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import javax.annotation.Nonnull;
import mqq.app.MobileQQ;

public class TogetherWatchFloatingUtil
{
  private static volatile String a;
  
  public static int a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool"))
    {
      try
      {
        paramContext = new Intent();
        paramContext.setAction("action_show_together_floating_windows");
        paramContext.setPackage(MobileQQ.getContext().getPackageName());
        paramContext.putExtra("com.tencent.mobileqq.webprocess.together.floating.data", paramWatchTogetherFloatingData);
        paramContext.setComponent(new ComponentName(MobileQQ.getContext(), "com.tencent.mobileqq.webprocess.WebProcessReceiver"));
        BaseApplicationImpl.getContext().sendBroadcast(paramContext, "com.tencent.msg.permission.pushnotify");
        if (QLog.isColorLevel())
        {
          QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "showFloatingWindow main..., data=", paramWatchTogetherFloatingData.toString() });
          return 0;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherWatchFloatingUtil", 2, "showFloatingWindow fail...", paramContext);
        }
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "showFloatingWindow tool..., data=", paramWatchTogetherFloatingData.toString() });
    }
    if (WatchFloatingWindowController.c().a(paramContext, paramWatchTogetherFloatingData) == 0) {
      return 1;
    }
    return 2;
  }
  
  public static Dialog a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    FloatingScreenReporter.b();
    paramContext = DialogUtil.a(paramContext, 230, null, "一起看将收起为小窗进行展示，请开启QQ悬浮窗权限以正常使用功能。", paramContext.getString(2131887648), paramContext.getString(2131892267), new TogetherWatchFloatingUtil.1(paramContext), null);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, Intent paramIntent)
  {
    paramContext = ActionSheet.create(paramContext);
    paramContext.addButton(2131914217);
    paramContext.addButton(2131887816, 3);
    paramContext.addCancelButton(2131887648);
    paramContext.setOnButtonClickListener(new TogetherWatchFloatingUtil.2(paramIntent, paramContext));
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("key_dialog_type", paramInt);
    localIntent.putExtra("cur_uin", paramString);
    localIntent.addFlags(805306368);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "setIsWatchFloatingShow isShow=", Boolean.valueOf(paramBoolean1), " uin=", paramString, " sessionType=", Integer.valueOf(paramInt) });
    }
    Object localObject;
    if (!paramBoolean1)
    {
      a = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("2_");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramInt);
      a = ((StringBuilder)localObject).toString();
    }
    if (7 == BaseApplicationImpl.sProcessId)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("BUNDLE_SET_KEY_REFRESH_UI", paramBoolean2);
      ((Bundle)localObject).putBoolean("BUNDLE_SET_STATUS", paramBoolean1);
      ((Bundle)localObject).putString("BUNDLE_SET_KEY_UIN", paramString);
      ((Bundle)localObject).putInt("BUNDLE_SET_KEY_SESSION_TYPE", paramInt);
      QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_set_floating", (Bundle)localObject, new TogetherWatchFloatingUtil.3());
    }
  }
  
  public static boolean a()
  {
    return TextUtils.isEmpty(a);
  }
  
  public static boolean a(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (!QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool"))
    {
      a = null;
      if (QLog.isColorLevel()) {
        QLog.d("TogetherWatchFloatingUtil", 2, "isWatchFloatingShow， tool process NOT EXIST");
      }
      return false;
    }
    if ((1 != BaseApplicationImpl.sProcessId) && (7 != BaseApplicationImpl.sProcessId)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "key=", paramString, " info=", a });
    }
    return TextUtils.equals(paramString, a);
  }
  
  public static void b(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (BaseApplicationImpl.getApplication().getQQProcessName() == null) {
        return;
      }
      if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool"))
      {
        boolean bool1 = b(2, paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType());
        boolean bool2 = a();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherWatchFloatingUtil", 2, new Object[] { "closeFloatingWindow isSameFloatingInfo=", Boolean.valueOf(bool1), "isFloatingInfoEmpty=", Boolean.valueOf(bool2) });
        }
        if ((!bool1) && (!bool2)) {
          return;
        }
        a = "";
        paramContext = new Bundle();
        paramContext.putSerializable("BUNDLE_KEY_UI_DATA", paramWatchTogetherFloatingData);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WatchTogetherClientIPCModule", "ACTION_QUIT_WATCH_FLOATING_WINDOWS", paramContext, new TogetherWatchFloatingUtil.4());
        return;
      }
      WatchFloatingWindowController.c().a(paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
    }
  }
  
  public static boolean b()
  {
    return a == null;
  }
  
  public static boolean b(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    return TextUtils.equals(localStringBuilder.toString(), a);
  }
  
  public static void c()
  {
    a = "";
    if (!BaseApplicationImpl.getApplication().getQQProcessName().endsWith(":tool"))
    {
      Bundle localBundle = new Bundle();
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WatchTogetherClientIPCModule", "ACTION_CLOSE_OR_QUIT_WATCH_FLOATING_WINDOWS", localBundle, new TogetherWatchFloatingUtil.5());
      return;
    }
    WatchFloatingWindowController.c().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil
 * JD-Core Version:    0.7.0.1
 */