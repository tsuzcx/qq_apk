package com.tencent.mobileqq.kandian.biz.account;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class RIJUserLevelDialog
  extends Dialog
  implements View.OnClickListener
{
  private RIJUserLevelDialog.DialogClick jdField_a_of_type_ComTencentMobileqqKandianBizAccountRIJUserLevelDialog$DialogClick;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public RIJUserLevelDialog(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    a(2131378784, null, this.jdField_a_of_type_JavaLangString, this.b);
    a(2131365169, null, this.c, this.d);
    a(2131369942, this, this.e, this.f);
    a(2131376561, this, this.g, this.h);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccountRIJUserLevelDialog$DialogClick;
    if (localObject != null) {
      ((RIJUserLevelDialog.DialogClick)localObject).a(paramInt, this.i);
    }
    if (paramInt == 0) {
      localObject = "0X800B4C4";
    } else {
      localObject = "0X800B4C2";
    }
    ThreadManager.executeOnSubThread(new RIJUserLevelDialog.2(this, (String)localObject));
    dismiss();
  }
  
  private void a(int paramInt, View.OnClickListener paramOnClickListener, String paramString1, String paramString2)
  {
    try
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (paramOnClickListener != null) {
        localTextView.setOnClickListener(paramOnClickListener);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localTextView.setText(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localTextView.setTextColor(Color.parseColor(paramString2));
        return;
      }
    }
    catch (Exception paramOnClickListener)
    {
      paramString1 = new StringBuilder();
      paramString1.append("initTextView error,msg=");
      paramString1.append(paramOnClickListener);
      QLog.d("RIJUserLevelDialog", 1, paramString1.toString());
    }
  }
  
  public void a(RIJUserLevelDialog.DialogSettingInfo paramDialogSettingInfo)
  {
    if (paramDialogSettingInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramDialogSettingInfo.jdField_a_of_type_JavaLangString;
    this.c = paramDialogSettingInfo.c;
    this.e = paramDialogSettingInfo.e;
    this.f = paramDialogSettingInfo.f;
    this.g = paramDialogSettingInfo.g;
    this.h = paramDialogSettingInfo.h;
    this.i = paramDialogSettingInfo.i;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccountRIJUserLevelDialog$DialogClick = paramDialogSettingInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAccountRIJUserLevelDialog$DialogClick;
    this.b = paramDialogSettingInfo.b;
    this.d = paramDialogSettingInfo.d;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131369942)
    {
      if (j != 2131376561) {
        return;
      }
      a(0);
      return;
    }
    a(1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    }
    setContentView(2131560313);
    a();
    ThreadManager.executeOnSubThread(new RIJUserLevelDialog.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog
 * JD-Core Version:    0.7.0.1
 */