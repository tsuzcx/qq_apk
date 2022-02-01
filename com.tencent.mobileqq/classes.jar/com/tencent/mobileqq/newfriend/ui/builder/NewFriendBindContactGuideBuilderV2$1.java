package com.tencent.mobileqq.newfriend.ui.builder;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class NewFriendBindContactGuideBuilderV2$1
  implements Runnable
{
  NewFriendBindContactGuideBuilderV2$1(NewFriendBindContactGuideBuilderV2 paramNewFriendBindContactGuideBuilderV2) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.this$0.a.getRuntimeService(IPhoneContactService.class, "");
    localIPhoneContactService.uploadOrUpdateContact();
    localIPhoneContactService.setNeedUploadResultTip(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendBindContactGuideBuilderV2.1
 * JD-Core Version:    0.7.0.1
 */