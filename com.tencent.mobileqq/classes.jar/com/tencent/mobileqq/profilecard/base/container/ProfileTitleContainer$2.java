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
        Object localObject = this.this$0;
        localObject = ProfileTitleContainer.access$700((ProfileTitleContainer)localObject, ProfileTitleContainer.access$600((ProfileTitleContainer)localObject), 5, 0, 5, 0);
        if (localObject != null)
        {
          ProfileTitleContainer localProfileTitleContainer = this.this$0;
          ProfileTitleContainer.access$502(localProfileTitleContainer, new RedTouch(ProfileTitleContainer.access$800(localProfileTitleContainer), (View)localObject).b(53).e(5).a());
        }
      }
      if (ProfileTitleContainer.access$500(this.this$0) != null) {
        ProfileTitleContainer.access$500(this.this$0).a(paramMessage);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.2
 * JD-Core Version:    0.7.0.1
 */