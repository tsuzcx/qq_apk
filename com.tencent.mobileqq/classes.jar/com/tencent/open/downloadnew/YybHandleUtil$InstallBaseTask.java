package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.StaticAnalyz;

public class YybHandleUtil$InstallBaseTask
  extends AsyncTask
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
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
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
      return;
    }
    ToastUtil.a().a("安装失败", 1);
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.InstallBaseTask
 * JD-Core Version:    0.7.0.1
 */