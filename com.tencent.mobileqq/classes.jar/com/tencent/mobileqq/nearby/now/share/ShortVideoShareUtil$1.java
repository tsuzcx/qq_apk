package com.tencent.mobileqq.nearby.now.share;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

final class ShortVideoShareUtil$1
  implements ShareActionSheet.OnItemClickListener
{
  ShortVideoShareUtil$1(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, QQAppInterface paramQQAppInterface) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    paramShareActionSheet.dismiss();
    switch (i)
    {
    default: 
      QLog.e("ShortVideoShareUtil", 1, "handleShareChatItemClick with invalid case:" + i);
      return;
    case 2: 
    case 73: 
      ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, false);
      return;
    case 3: 
      ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e);
      return;
    case 9: 
      ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.f, new ShortVideoShareUtil.1.1(this));
      return;
    case 10: 
      ShortVideoShareUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.f, new ShortVideoShareUtil.1.2(this));
      return;
    }
    ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, false, paramActionSheetItem.uinType, paramActionSheetItem.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1
 * JD-Core Version:    0.7.0.1
 */