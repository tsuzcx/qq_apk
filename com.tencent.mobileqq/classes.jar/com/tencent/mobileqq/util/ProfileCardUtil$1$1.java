package com.tencent.mobileqq.util;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CommonModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.profilecommon.utils.ProfileCommonUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

class ProfileCardUtil$1$1
  implements UpCallBack
{
  ProfileCardUtil$1$1(ProfileCardUtil.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    int i;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onSend result is null ? ");
      if (paramSendResult == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" result is: ");
      if (paramSendResult == null) {
        i = -99;
      } else {
        i = paramSendResult.a;
      }
      ((StringBuilder)localObject).append(i);
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSendResult == null) {
      return;
    }
    if (paramSendResult.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = (CardHandler)this.c.c.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localObject != null) {
      ((CardHandler)localObject).a(bool, this.c.c.getCurrentAccountUin(), paramSendResult.b);
    } else {
      FaceUtil.e(null);
    }
    if (!bool)
    {
      ProfileCardUtil.a("TransferRequest.onSend", paramSendResult.b, paramSendResult.toString());
    }
    else
    {
      if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.c.c.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.c.c.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.a) {
        ThreadManager.getUIHandler().post(new ProfileCardUtil.1.1.1(this));
      }
      if (SharedPreUtils.aG(this.c.c.getApp(), this.c.c.getCurrentAccountUin()) != 2)
      {
        paramSendResult = (AvatarHistoryNumProcessor)ProfileCommonUtils.a(AvatarHistoryNumProcessor.class, this.c.c);
        if (paramSendResult != null) {
          paramSendResult.a();
        }
      }
    }
    if ("FROM_MINI_APP".equals(this.b))
    {
      if (bool) {
        i = j;
      } else {
        i = -10002;
      }
      if (bool) {
        paramSendResult = "ok";
      } else {
        paramSendResult = "upload failed";
      }
      this.c.b.putExtra("param_result_code", i);
      this.c.b.putExtra("param_result_desc", paramSendResult);
      CommonModule.a().a(this.c.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ProfileCardUtil.1.1
 * JD-Core Version:    0.7.0.1
 */