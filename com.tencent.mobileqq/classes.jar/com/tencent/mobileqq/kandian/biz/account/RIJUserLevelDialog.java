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
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private RIJUserLevelDialog.DialogClick j;
  
  public RIJUserLevelDialog(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    a(2131447463, null, this.a, this.b);
    a(2131431322, null, this.c, this.d);
    a(2131437091, this, this.e, this.f);
    a(2131444812, this, this.g, this.h);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.j;
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
    this.a = paramDialogSettingInfo.a;
    this.c = paramDialogSettingInfo.c;
    this.e = paramDialogSettingInfo.e;
    this.f = paramDialogSettingInfo.f;
    this.g = paramDialogSettingInfo.g;
    this.h = paramDialogSettingInfo.h;
    this.i = paramDialogSettingInfo.i;
    this.j = paramDialogSettingInfo.j;
    this.b = paramDialogSettingInfo.b;
    this.d = paramDialogSettingInfo.d;
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2131437091)
    {
      if (k != 2131444812) {
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
    setContentView(2131626359);
    a();
    ThreadManager.executeOnSubThread(new RIJUserLevelDialog.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.RIJUserLevelDialog
 * JD-Core Version:    0.7.0.1
 */