package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

class OpenAuthorityAccountView$5$1
  implements Runnable
{
  OpenAuthorityAccountView$5$1(OpenAuthorityAccountView.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      QLog.d("OpenAuthorityAccountView", 1, "-->updateAccountFace success uin = " + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$5.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$5.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    try
    {
      QLog.d("OpenAuthorityAccountView", 1, "-->updateAccountFace use default uin = " + AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$5.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$5.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView$5.this$0.getResources(), 2130840792));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("OpenAuthorityAccountView", 1, "-->updateAccountFace oom uin = AuthorityUtil.getSimpleUin(uin)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.5.1
 * JD-Core Version:    0.7.0.1
 */