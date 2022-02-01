package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class AuthorityAccountView$5
  implements Runnable
{
  AuthorityAccountView$5(AuthorityAccountView paramAuthorityAccountView, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityAccountView.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, (int)(58.0F * this.this$0.a), true);
    if (AuthorityAccountView.a(this.this$0) == null)
    {
      QLog.e("AuthorityAccountView", 1, "-->updateAccountFace mContext == null");
      return;
    }
    ((BaseActivity)AuthorityAccountView.a(this.this$0)).runOnUiThread(new AuthorityAccountView.5.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.5
 * JD-Core Version:    0.7.0.1
 */