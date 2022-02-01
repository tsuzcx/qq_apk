package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.mobileqq.activity.FriendProfilePhotoHelper.ProfilePhotoCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.base.view.ProfileBaseView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ProfileHeaderBaseComponent$1
  implements FriendProfilePhotoHelper.ProfilePhotoCallback
{
  ProfileHeaderBaseComponent$1(ProfileHeaderBaseComponent paramProfileHeaderBaseComponent) {}
  
  public void notifyUser(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a();
  }
  
  public void onUploadResult(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if ((ProfileHeaderBaseComponent.access$200(this.this$0) != null) && (((ProfileCardInfo)ProfileHeaderBaseComponent.access$300(this.this$0)).card != null))
      {
        if (((ProfileCardInfo)ProfileHeaderBaseComponent.access$400(this.this$0)).card.checkCoverUrl(paramArrayOfByte)) {
          ((ProfileCardInfo)ProfileHeaderBaseComponent.access$500(this.this$0)).card.updateCoverData(paramArrayOfByte);
        }
        if ((this.this$0.mHeaderView instanceof ProfileBaseView)) {
          ((ProfileBaseView)this.this$0.mHeaderView).onUpdate((ProfileCardInfo)ProfileHeaderBaseComponent.access$600(this.this$0), false);
        }
        ThreadManager.excute(new ProfileHeaderBaseComponent.1.1(this), 32, null, false);
      }
    }
    else {
      this.this$0.mDelegate.requestUpdateCard();
    }
    ReportController.b(ProfileHeaderBaseComponent.access$900(this.this$0), "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
  }
  
  public void updateCover(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      ((ProfileCardInfo)ProfileHeaderBaseComponent.access$000(this.this$0)).card.updateCoverData(paramArrayOfByte);
      if ((this.this$0.mHeaderView instanceof ProfileBaseView)) {
        this.this$0.mHeaderView.onUpdate((ProfileCardInfo)ProfileHeaderBaseComponent.access$100(this.this$0), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.1
 * JD-Core Version:    0.7.0.1
 */