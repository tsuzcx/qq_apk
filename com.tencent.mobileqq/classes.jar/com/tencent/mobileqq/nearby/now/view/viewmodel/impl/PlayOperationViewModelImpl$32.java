package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class PlayOperationViewModelImpl$32
  implements INowShortVideoProtoManager.Callback
{
  PlayOperationViewModelImpl$32(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("err_msg:   ");
          paramArrayOfByte.append(paramBundle.err_msg.get());
          paramArrayOfByte.append("  isFollow:");
          paramArrayOfByte.append(PlayOperationViewModelImpl.access$1400(this.a));
          QLog.i("PlayOperationViewModel", 2, paramArrayOfByte.toString());
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_new_anchor_follow_interface.FollowActionRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("ret:   ");
            paramBundle.append(paramArrayOfByte.ret.get());
            paramBundle.append(",msg:     ");
            paramBundle.append(paramArrayOfByte.msg.get());
            paramBundle.append("  isFollow:");
            paramBundle.append(PlayOperationViewModelImpl.access$1400(this.a));
            QLog.i("PlayOperationViewModel", 2, paramBundle.toString());
          }
          if (paramArrayOfByte.ret.get() == 0)
          {
            PlayOperationViewModelImpl.access$1402(this.a, true);
            if (PlayOperationViewModelImpl.access$1500(this.a))
            {
              ThreadManager.getUIHandler().post(new PlayOperationViewModelImpl.32.1(this));
              PlayOperationViewModelImpl.access$1502(this.a, false);
            }
            this.a.mVideoData.a = true;
            ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_focus").genderInd1().reportByVideo(this.a.app);
            ThreadManagerV2.excute(new PlayOperationViewModelImpl.32.2(this, (INearbyCardManager)this.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
            PlayOperationViewModelImpl.access$1700(this.a, PlayOperationViewModelImpl.access$1400(this.a));
            return;
          }
          if (!TextUtils.isEmpty(paramArrayOfByte.msg.get()))
          {
            QQToast.a(BaseApplication.getContext(), 1, paramArrayOfByte.msg.get(), 0).a();
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.32
 * JD-Core Version:    0.7.0.1
 */