package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class ForwardDialogMgr
{
  private Dialog a;
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      QLog.e("ForwardDialogMgr", 1, "-->showMultShareDialog: (null == activity) || activity.isFinishing()");
    }
    String str;
    QQAppInterface localQQAppInterface;
    int i;
    ForwardDialogMgr.1 local1;
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("sdk_mult_share", false));
      ForwardStatisticsReporter.b("KEY_STAGE_2_TOTAL");
      paramIntent.removeExtra("sdk_mult_share");
      str = Integer.toString(paramIntent.getIntExtra("sdk_mult_share_total_count", 0));
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramIntent.getBooleanExtra("sdk_mult_share_for_local", false))
      {
        QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
        i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299166);
        QQToast.a(localQQAppInterface.getApp(), 2, 2131692688, 0).b(i);
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        return;
      }
      i = paramIntent.getIntExtra("sdk_mult_share_result_code", -1);
      local1 = new ForwardDialogMgr.1(paramIntent, i, paramActivity, localQQAppInterface);
      QLog.d("ForwardDialogMgr", 1, new Object[] { "-->showMultShareDialog--RESULT_CODE=", Integer.valueOf(i), ", count=", str });
      if (901503 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), local1);
        return;
      }
      if (i == 0)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        a(paramActivity, paramIntent, HardCodeUtil.a(2131719154), local1);
        return;
      }
      if (2 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent, HardCodeUtil.a(2131719153), local1);
        return;
      }
      if (1 == i)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
        ForwardUtils.a(localQQAppInterface, "0X800A73A", new String[] { str, Integer.toString(localArrayList.size()) });
        a(paramActivity, paramIntent, localArrayList, local1);
        return;
      }
    } while (3 != i);
    ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
    a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), local1);
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = DialogUtil.a(paramActivity, 232, null, paramString, ForwardShareByServerHelper.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), HardCodeUtil.a(2131719149), paramOnClickListener, paramOnClickListener);
    try
    {
      paramActivity.show();
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("ForwardDialogMgr", 1, "-->showShareResultDialog: failed. ", paramActivity);
    }
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, List<ResultRecord> paramList, DialogInterface.OnClickListener paramOnClickListener)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QQCustomDialogWtihForwardAvatar localQQCustomDialogWtihForwardAvatar = new QQCustomDialogWtihForwardAvatar(paramActivity, 2131755842);
    localQQCustomDialogWtihForwardAvatar.setContentView(2131559093);
    localQQCustomDialogWtihForwardAvatar.a(localQQAppInterface, paramActivity, paramList, false);
    localQQCustomDialogWtihForwardAvatar.c(String.format(paramActivity.getResources().getString(2131719150), new Object[] { Integer.valueOf(paramList.size()) }));
    localQQCustomDialogWtihForwardAvatar.c();
    localQQCustomDialogWtihForwardAvatar.setNegativeButton(ForwardShareByServerHelper.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), paramOnClickListener);
    localQQCustomDialogWtihForwardAvatar.setPositiveButton(HardCodeUtil.a(2131719149), paramOnClickListener);
    localQQCustomDialogWtihForwardAvatar.findViewById(2131379450).setVisibility(8);
    localQQCustomDialogWtihForwardAvatar.show();
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    QLog.d("ForwardDialogMgr", 1, new Object[] { "showOtherErrorDialog errorMsg=", paramString });
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
      return;
    }
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setMessage(paramString);
    paramActivity.setPositiveButton(2131694615, paramOnClickListener);
    paramActivity.show();
  }
  
  void a(Activity paramActivity)
  {
    b(paramActivity);
    this.a = new ReportDialog(paramActivity, 2131755842);
    this.a.setCancelable(false);
    this.a.setContentView(2131559683);
    paramActivity = HardCodeUtil.a(2131719151);
    ((TextView)this.a.findViewById(2131373066)).setText(paramActivity);
    this.a.show();
  }
  
  void b(Activity paramActivity)
  {
    if ((!paramActivity.isFinishing()) && (this.a != null) && (this.a.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardDialogMgr
 * JD-Core Version:    0.7.0.1
 */