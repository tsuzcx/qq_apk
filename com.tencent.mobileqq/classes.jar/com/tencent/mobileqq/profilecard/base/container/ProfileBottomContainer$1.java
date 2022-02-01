package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.widget.QQToast;

class ProfileBottomContainer$1
  implements Runnable
{
  ProfileBottomContainer$1(ProfileBottomContainer paramProfileBottomContainer) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)ProfileBottomContainer.access$000(this.this$0).getRuntimeService(IPhoneContactService.class, "");
    if (!localIPhoneContactService.existContact(((ProfileCardInfo)ProfileBottomContainer.access$100(this.this$0)).allInOne.contactName, ((ProfileCardInfo)ProfileBottomContainer.access$200(this.this$0)).allInOne.uin))
    {
      if (localIPhoneContactService.addContactAndUpload(((ProfileCardInfo)ProfileBottomContainer.access$300(this.this$0)).allInOne.contactName, ((ProfileCardInfo)ProfileBottomContainer.access$400(this.this$0)).allInOne.uin))
      {
        QQToast.makeText(ProfileBottomContainer.access$500(this.this$0), 2, HardCodeUtil.a(2131902887), 0).show();
        return;
      }
      QQToast.makeText(ProfileBottomContainer.access$600(this.this$0), 1, HardCodeUtil.a(2131902915), 0).show();
      return;
    }
    QQToast.makeText(ProfileBottomContainer.access$700(this.this$0), HardCodeUtil.a(2131902877), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.1
 * JD-Core Version:    0.7.0.1
 */