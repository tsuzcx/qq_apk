package com.tencent.mobileqq.location.window;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class FloatMapDialogUtil$1
  implements Runnable
{
  FloatMapDialogUtil$1(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.a, 230, null, this.a.getResources().getString(2131719400), 2131694615, 2131690800, null, new FloatMapDialogUtil.1.1(this));
    FloatMapDialogUtil.a(this.a, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapDialogUtil.1
 * JD-Core Version:    0.7.0.1
 */