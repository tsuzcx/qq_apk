package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;

class BaseAuthorityAccountView$5$1
  implements Runnable
{
  BaseAuthorityAccountView$5$1(BaseAuthorityAccountView.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->updateAccountFace success uin = ");
      localStringBuilder.append(AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$5.jdField_a_of_type_JavaLangString));
      SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$5.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->updateAccountFace use default uin = ");
      localStringBuilder.append(AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$5.jdField_a_of_type_JavaLangString));
      SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
      this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$5.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentOpenAgentBaseAuthorityAccountView$5.this$0.getResources(), 2130840667));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label140:
      break label140;
    }
    SSOLog.b("BaseAuthorityAccountView", new Object[] { "-->updateAccountFace oom uin = AuthorityUtil.getSimpleUin(uin)" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.5.1
 * JD-Core Version:    0.7.0.1
 */