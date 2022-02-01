package com.tencent.mobileqq.location.window;

import android.content.Context;
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
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, 230, null, ((QBaseActivity)localObject).getResources().getString(2131916654), 2131892267, 2131887648, null, new FloatMapDialogUtil.1.1(this));
    FloatMapDialogUtil.a(this.a, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapDialogUtil.1
 * JD-Core Version:    0.7.0.1
 */