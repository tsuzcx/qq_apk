package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class AuthorityAccountView$5$1
  implements Runnable
{
  AuthorityAccountView$5$1(AuthorityAccountView.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$5.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$5.a.setImageBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$5.this$0.getResources(), 2130840291));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.d("AuthorityAccountView", 2, "-->updateAccountFace oom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.5.1
 * JD-Core Version:    0.7.0.1
 */