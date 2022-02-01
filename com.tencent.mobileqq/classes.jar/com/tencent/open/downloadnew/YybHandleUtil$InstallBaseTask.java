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
  Activity jdField_a_of_type_AndroidAppActivity;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  String jdField_a_of_type_JavaLangString;
  
  public YybHandleUtil$InstallBaseTask(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public YybHandleUtil$InstallBaseTask(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(false);
  }
  
  protected void a()
  {
    ProgressDialog localProgressDialog = this.jdField_a_of_type_AndroidAppProgressDialog;
    if ((localProgressDialog != null) && (localProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    a();
    if (paramBoolean.booleanValue())
    {
      if ((YybHandleUtil.a()) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        StaticAnalyz.a("311", this.jdField_a_of_type_JavaLangString, "1101070898");
      }
    }
    else {
      ToastUtil.a().a(HardCodeUtil.a(2131716504), 1);
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
    this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.InstallBaseTask
 * JD-Core Version:    0.7.0.1
 */