package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class OpenAuthorityAccountView$5
  implements Runnable
{
  OpenAuthorityAccountView$5(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    Bitmap localBitmap = OpenAuthorityAccountView.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, (int)(58.0F * this.this$0.a), true);
    if (OpenAuthorityAccountView.a(this.this$0) == null)
    {
      QLog.e("OpenAuthorityAccountView", 1, "-->updateAccountFace mContext == null");
      return;
    }
    ((BaseActivity)OpenAuthorityAccountView.a(this.this$0)).runOnUiThread(new OpenAuthorityAccountView.5.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.5
 * JD-Core Version:    0.7.0.1
 */