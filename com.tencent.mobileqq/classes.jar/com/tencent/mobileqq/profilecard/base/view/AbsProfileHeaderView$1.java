package com.tencent.mobileqq.profilecard.base.view;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderView$1
  implements Handler.Callback
{
  AbsProfileHeaderView$1(AbsProfileHeaderView paramAbsProfileHeaderView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AbsProfileHeaderView.TAG, 2, String.format("handleMessage msg.what=%s", new Object[] { Integer.valueOf(paramMessage.what) }));
    }
    if (1000 == paramMessage.what)
    {
      if (AbsProfileHeaderView.access$000(this.this$0).get())
      {
        paramMessage = this.this$0;
        paramMessage.updateTips(paramMessage.mCardInfo);
        return true;
      }
    }
    else if (1003 == paramMessage.what)
    {
      Object localObject = (View)this.this$0.mHeaderChildMap.get("map_key_avatar_pendant");
      if ((localObject instanceof ImageView))
      {
        localObject = (ImageView)localObject;
        paramMessage = (ExtensionInfo)paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.isPendantValid()))
        {
          this.this$0.mPendantId = paramMessage.pendantId;
          ((ImageView)localObject).setVisibility(0);
          AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.this$0.mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
          if (AvatarPendantUtil.a(this.this$0.mPendantId))
          {
            localAvatarPendantManager.a(this.this$0.mPendantId).a((View)localObject, 2, PendantInfo.d, paramMessage.uin, paramMessage.pendantDiyId);
            return true;
          }
          localAvatarPendantManager.a(this.this$0.mPendantId).a((View)localObject, 1, PendantInfo.d, paramMessage.uin, paramMessage.pendantDiyId);
          return true;
        }
        ((ImageView)localObject).setVisibility(4);
        this.this$0.mPendantId = 0L;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.1
 * JD-Core Version:    0.7.0.1
 */