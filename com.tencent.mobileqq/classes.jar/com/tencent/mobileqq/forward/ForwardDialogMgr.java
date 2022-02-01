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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.selectmember.ResultRecord;
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
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (!paramIntent.getBooleanExtra("sdk_mult_share", false)) {
        return;
      }
      ForwardStatisticsReporter.b("KEY_STAGE_2_TOTAL");
      paramIntent.removeExtra("sdk_mult_share");
      String str = Integer.toString(paramIntent.getIntExtra("sdk_mult_share_total_count", 0));
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramIntent.getBooleanExtra("sdk_mult_share_for_local", false))
      {
        QLog.d("ForwardDialogMgr", 1, "showMultShareDialog SDK_MULT_SHARE_FOR_LOCAL");
        i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920);
        QQToast.makeText(localQQAppInterface.getApp(), 2, 2131889669, 0).show(i);
        ForwardUtils.a(localQQAppInterface, "0X800A738", new String[] { str });
        return;
      }
      int i = paramIntent.getIntExtra("sdk_mult_share_result_code", -1);
      ForwardDialogMgr.1 local1 = new ForwardDialogMgr.1(paramIntent, i, paramActivity, localQQAppInterface);
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
        a(paramActivity, paramIntent, HardCodeUtil.a(2131916405), local1);
        return;
      }
      if (2 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent, HardCodeUtil.a(2131916404), local1);
        return;
      }
      if (1 == i)
      {
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("sdk_mult_share_fail_record");
        ForwardUtils.a(localQQAppInterface, "0X800A73A", new String[] { str, Integer.toString(localArrayList.size()) });
        a(paramActivity, paramIntent, localArrayList, local1);
        return;
      }
      if (3 == i)
      {
        ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { str });
        a(paramActivity, paramIntent.getStringExtra("sdk_mult_share_error_wording"), local1);
      }
      return;
    }
    QLog.e("ForwardDialogMgr", 1, "-->showMultShareDialog: (null == activity) || activity.isFinishing()");
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = DialogUtil.a(paramActivity, 232, null, paramString, ForwardShareByServerHelper.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), HardCodeUtil.a(2131916400), paramOnClickListener, paramOnClickListener);
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
    QQCustomDialogWtihForwardAvatar localQQCustomDialogWtihForwardAvatar = new QQCustomDialogWtihForwardAvatar(paramActivity, 2131953338);
    localQQCustomDialogWtihForwardAvatar.setContentView(2131624620);
    localQQCustomDialogWtihForwardAvatar.a(localQQAppInterface, paramActivity, paramList, false);
    localQQCustomDialogWtihForwardAvatar.e(String.format(paramActivity.getResources().getString(2131916401), new Object[] { Integer.valueOf(paramList.size()) }));
    localQQCustomDialogWtihForwardAvatar.d();
    localQQCustomDialogWtihForwardAvatar.setNegativeButton(ForwardShareByServerHelper.a(paramIntent.getStringExtra("sdk_mult_share_app_name")), paramOnClickListener);
    localQQCustomDialogWtihForwardAvatar.setPositiveButton(HardCodeUtil.a(2131916400), paramOnClickListener);
    localQQCustomDialogWtihForwardAvatar.findViewById(2131447483).setVisibility(8);
    localQQCustomDialogWtihForwardAvatar.show();
  }
  
  public static void a(Activity paramActivity, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    QLog.d("ForwardDialogMgr", 1, new Object[] { "showOtherErrorDialog errorMsg=", paramString });
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = DialogUtil.a(paramActivity, 230);
      paramActivity.setMessage(paramString);
      paramActivity.setPositiveButton(2131892267, paramOnClickListener);
      paramActivity.show();
      return;
    }
    QLog.e("ForwardDialogMgr", 1, "showOtherErrorDialog null == activity || activity.isFinishing()");
  }
  
  void a(Activity paramActivity)
  {
    b(paramActivity);
    this.a = new ReportDialog(paramActivity, 2131953338);
    this.a.setCancelable(false);
    this.a.setContentView(2131625585);
    paramActivity = HardCodeUtil.a(2131916402);
    ((TextView)this.a.findViewById(2131440191)).setText(paramActivity);
    this.a.show();
  }
  
  void b(Activity paramActivity)
  {
    if (!paramActivity.isFinishing())
    {
      paramActivity = this.a;
      if ((paramActivity != null) && (paramActivity.isShowing()))
      {
        this.a.dismiss();
        this.a = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardDialogMgr
 * JD-Core Version:    0.7.0.1
 */