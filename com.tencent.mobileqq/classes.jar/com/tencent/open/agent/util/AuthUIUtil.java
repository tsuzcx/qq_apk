package com.tencent.open.agent.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.widget.MaxHeightScrollView;
import com.tencent.widget.ActionSheet;

public class AuthUIUtil
{
  public static QQProgressDialog a(Activity paramActivity, QQProgressDialog paramQQProgressDialog, int paramInt)
  {
    SSOLog.b("AuthUIUtil", new Object[] { "showLoading" });
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramQQProgressDialog == null)
      {
        paramActivity = new QQProgressDialog(paramActivity, 0, paramInt, 17);
        paramActivity.a(-1);
        a(paramActivity);
        return paramActivity;
      }
      if (!paramQQProgressDialog.isShowing()) {
        a(paramQQProgressDialog);
      }
      return paramQQProgressDialog;
    }
    SSOLog.b("AuthUIUtil", "showLoading activity is finishing");
    return null;
  }
  
  public static ActionSheet a(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.create(paramContext, -1, null);
    paramContext.setActionContentView(paramView, null);
    return paramContext;
  }
  
  public static String a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("sdkp");
    if ("web".equals(paramBundle)) {
      return HardCodeUtil.a(2131899038);
    }
    if ("android".equals(paramBundle)) {
      return HardCodeUtil.a(2131899044);
    }
    return HardCodeUtil.a(2131899043);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    QQToast.makeText(paramActivity, 1, HardCodeUtil.a(paramInt), 0).show();
  }
  
  public static void a(Activity paramActivity, Dialog paramDialog)
  {
    SSOLog.b("AuthUIUtil", new Object[] { "dismissDialog" });
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if ((paramDialog != null) && (paramDialog.isShowing())) {
        try
        {
          paramDialog.dismiss();
          return;
        }
        catch (Exception paramActivity)
        {
          SSOLog.c("AuthUIUtil", "Exception", paramActivity);
          return;
        }
      }
      SSOLog.b("AuthUIUtil", new Object[] { "dismissDialog dialog is invalid" });
      return;
    }
    SSOLog.b("AuthUIUtil", new Object[] { "dismissDialog activity is invalid" });
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()) && ((Build.VERSION.SDK_INT < 17) || (!paramActivity.isDestroyed())))
    {
      DialogUtil.b(paramActivity, 230).setMessageWithUrl(paramString).setTitle(paramActivity.getString(2131915899)).setPositiveButton(17039370, paramOnClickListener).show();
      return;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("showDialog activity is null/finished. sdk_int: ");
    paramActivity.append(Build.VERSION.SDK_INT);
    SSOLog.b("AuthUIUtil", new Object[] { paramActivity.toString() });
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity.runOnUiThread(new AuthUIUtil.1(paramActivity, paramBoolean, paramString));
      return;
    }
    SSOLog.b("AuthUIUtil", new Object[] { "showToast activity is null/finished" });
  }
  
  private static void a(Dialog paramDialog)
  {
    try
    {
      paramDialog.show();
      return;
    }
    catch (Exception paramDialog)
    {
      SSOLog.a("AuthUIUtil", "showProgressDialog", paramDialog);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!(paramContext instanceof Activity)) {
      return;
    }
    if (((Activity)paramContext).isFinishing()) {
      return;
    }
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setMessage(paramString);
    paramContext.setNegativeButton(HardCodeUtil.a(2131905677), new AuthUIUtil.3());
    paramContext.show();
  }
  
  public static void a(MaxHeightScrollView paramMaxHeightScrollView, Activity paramActivity)
  {
    paramMaxHeightScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new AuthUIUtil.2(paramActivity, paramMaxHeightScrollView));
  }
  
  @TargetApi(17)
  public static void a(String paramString, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed()))
      {
        SSOLog.a("AuthUIUtil", new Object[] { "activity isDestroyed" });
        return;
      }
      DialogUtil.b(paramActivity, 230).setMessageWithUrl(paramString).setTitle(paramActivity.getString(2131915899)).setPositiveButton(17039370, paramOnClickListener).show();
      return;
    }
    SSOLog.a("AuthUIUtil", new Object[] { "activity invalid" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.AuthUIUtil
 * JD-Core Version:    0.7.0.1
 */