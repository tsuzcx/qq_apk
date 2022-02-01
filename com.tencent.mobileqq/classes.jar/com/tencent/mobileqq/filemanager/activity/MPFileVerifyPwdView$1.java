package com.tencent.mobileqq.filemanager.activity;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.BaseApplication;

class MPFileVerifyPwdView$1
  implements TextWatcher
{
  MPFileVerifyPwdView$1(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = MPFileVerifyPwdView.a(this.a).getText().toString();
    if ((!TextUtils.isEmpty(paramEditable)) && (paramEditable.length() >= 16))
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131891919));
      return;
    }
    if (!TextUtils.isEmpty(paramEditable))
    {
      MPFileVerifyPwdView.b(this.a).setEnabled(true);
      MPFileVerifyPwdView.b(this.a).setTextColor(Color.parseColor("#00a5e0"));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.1
 * JD-Core Version:    0.7.0.1
 */