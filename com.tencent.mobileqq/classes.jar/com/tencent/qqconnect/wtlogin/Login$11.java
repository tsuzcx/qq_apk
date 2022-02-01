package com.tencent.qqconnect.wtlogin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;

class Login$11
  implements DialogInterface.OnClickListener
{
  Login$11(Login paramLogin, ISafeBlockApi paramISafeBlockApi, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.reportFrozenDlg(null, this.b, 3, this.c);
    if (!this.a.unBlockWithMiniAppFromCnt(this.f, this.d))
    {
      paramDialogInterface = this.a.getJumpAQH5Url(this.d, this.e, false);
      Intent localIntent = new Intent(this.f.getActivity(), QQBrowserActivity.class);
      this.f.startActivity(localIntent.putExtra("url", paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.11
 * JD-Core Version:    0.7.0.1
 */