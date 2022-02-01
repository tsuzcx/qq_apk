package com.tencent.open.sdk.checker;

import android.content.Context;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class BaseAccountChecker$DefaultAccountNotify
{
  private Context a;
  private int b;
  private int c;
  private String d;
  private int e;
  private int f;
  
  public BaseAccountChecker$DefaultAccountNotify(Context paramContext, String paramString, int paramInt)
  {
    this.a = paramContext;
    this.d = paramString;
    this.c = 2131892355;
    this.b = paramInt;
    if (paramInt == 1) {
      this.e = 2131892357;
    } else {
      this.e = 2131892356;
    }
    this.f = 2131887648;
  }
  
  public void a(BaseAccountChecker.DefaultAccountNotify.DialogBtnClickListener paramDialogBtnClickListener)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230);
    localQQCustomDialog.setTitle(this.c);
    localQQCustomDialog.setMessage(this.d);
    BaseAccountChecker.DefaultAccountNotify.1 local1 = new BaseAccountChecker.DefaultAccountNotify.1(this, paramDialogBtnClickListener);
    localQQCustomDialog.setPositiveButton(this.e, local1);
    if (this.b == 2) {
      localQQCustomDialog.setNegativeButton(this.f, local1);
    }
    localQQCustomDialog.setOnCancelListener(new BaseAccountChecker.DefaultAccountNotify.2(this, paramDialogBtnClickListener));
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.sdk.checker.BaseAccountChecker.DefaultAccountNotify
 * JD-Core Version:    0.7.0.1
 */