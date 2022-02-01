package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.chat.IExpandMsgSendHelper;
import com.tencent.mobileqq.qqexpand.chat.ISendMsgInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ProfileBottomContainer$5
  implements ISendMsgInterface
{
  ProfileBottomContainer$5(ProfileBottomContainer paramProfileBottomContainer) {}
  
  public void enterAio(String paramString1, String paramString2)
  {
    ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).enterAio(ProfileBottomContainer.access$2100(this.this$0), paramString1, paramString2);
  }
  
  public void showCampusVerifyDialog(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).showCampusVerifyDialog(ProfileBottomContainer.access$1600(this.this$0), paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public void showMatchCountDialog()
  {
    ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).showMatchCountDialog(ProfileBottomContainer.access$1700(this.this$0));
  }
  
  public void showToast(int paramInt)
  {
    if (ProfileBottomContainer.access$1800(this.this$0) == null)
    {
      QLog.d("ProfileBottomContainer", 1, "showToast() activity is null just return");
      return;
    }
    ((IExpandMsgSendHelper)QRoute.api(IExpandMsgSendHelper.class)).showToast(ProfileBottomContainer.access$1900(this.this$0), ProfileBottomContainer.access$2000(this.this$0).getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.5
 * JD-Core Version:    0.7.0.1
 */