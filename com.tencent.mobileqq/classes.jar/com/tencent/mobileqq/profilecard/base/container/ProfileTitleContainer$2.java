package com.tencent.mobileqq.profilecard.base.container;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class ProfileTitleContainer$2
  implements Handler.Callback
{
  ProfileTitleContainer$2(ProfileTitleContainer paramProfileTitleContainer) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      if (ProfileTitleContainer.access$500(this.this$0) == null)
      {
        View localView = ProfileTitleContainer.access$700(this.this$0, ProfileTitleContainer.access$600(this.this$0), 5, 0, 5, 0);
        if (localView != null) {
          ProfileTitleContainer.access$502(this.this$0, new RedTouch(ProfileTitleContainer.access$800(this.this$0), localView).b(53).e(5).a());
        }
      }
      if (ProfileTitleContainer.access$500(this.this$0) != null) {
        ProfileTitleContainer.access$500(this.this$0).a(paramMessage);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.2
 * JD-Core Version:    0.7.0.1
 */