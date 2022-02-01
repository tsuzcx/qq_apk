package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;

class BaseAuthorityAccountView$6
  implements DialogInterface.OnClickListener
{
  BaseAuthorityAccountView$6(BaseAuthorityAccountView paramBaseAuthorityAccountView, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ThreadManager.executeOnSubThread(new BaseAuthorityAccountView.DelAccountRunnable(this.b, this.a));
      return;
    }
    if ((paramInt == 0) && (this.b.h != null))
    {
      this.b.h.dismiss();
      this.b.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.6
 * JD-Core Version:    0.7.0.1
 */