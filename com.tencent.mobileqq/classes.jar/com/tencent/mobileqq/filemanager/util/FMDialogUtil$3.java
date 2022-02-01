package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class FMDialogUtil$3
  implements Runnable
{
  FMDialogUtil$3(Context paramContext, CharSequence paramCharSequence, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (((localObject instanceof Activity)) && (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = this.b;
    if ((localObject instanceof String))
    {
      DialogUtil.a(this.a, 230, this.c, (String)localObject, 2131889250, 2131889254, this.d, this.e).show();
      return;
    }
    if ((localObject instanceof SpannableString)) {
      DialogUtil.a(this.a, 230, this.c, (CharSequence)localObject, 2131889250, 2131889254, this.d, this.e).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMDialogUtil.3
 * JD-Core Version:    0.7.0.1
 */