package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class YybHandleUtil$InstallBaseTask
  extends AsyncTask<Void, Long, Boolean>
{
  ProgressDialog c;
  Activity d;
  String e;
  
  public YybHandleUtil$InstallBaseTask(Activity paramActivity)
  {
    this.d = paramActivity;
  }
  
  public YybHandleUtil$InstallBaseTask(Activity paramActivity, String paramString)
  {
    this.d = paramActivity;
    this.e = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(false);
  }
  
  protected void a()
  {
    ProgressDialog localProgressDialog = this.c;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.c.dismiss();
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    a();
    if (paramBoolean.booleanValue())
    {
      if ((YybHandleUtil.a()) && (TextUtils.isEmpty(this.e))) {
        StaticAnalyz.a("311", this.e, "1101070898");
      }
    }
    else {
      ToastUtil.a().a(HardCodeUtil.a(2131913937), 1);
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.c = new ReportProgressDialog(this.d);
    Activity localActivity = this.d;
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      this.c.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.InstallBaseTask
 * JD-Core Version:    0.7.0.1
 */