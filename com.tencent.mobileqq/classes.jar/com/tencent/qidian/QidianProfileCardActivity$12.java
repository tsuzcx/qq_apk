package com.tencent.qidian;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;

class QidianProfileCardActivity$12
  implements Runnable
{
  QidianProfileCardActivity$12(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void run()
  {
    QidianProfileCardActivity localQidianProfileCardActivity;
    if (SimpleUIUtil.a())
    {
      localQidianProfileCardActivity = this.this$0;
      localQidianProfileCardActivity.jdField_a_of_type_AndroidGraphicsBitmap = localQidianProfileCardActivity.app.getFaceBitmap(this.this$0.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, (byte)2, true);
    }
    else
    {
      localQidianProfileCardActivity = this.this$0;
      localQidianProfileCardActivity.jdField_a_of_type_AndroidGraphicsBitmap = localQidianProfileCardActivity.app.getFaceBitmap(this.this$0.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, true);
    }
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.12
 * JD-Core Version:    0.7.0.1
 */