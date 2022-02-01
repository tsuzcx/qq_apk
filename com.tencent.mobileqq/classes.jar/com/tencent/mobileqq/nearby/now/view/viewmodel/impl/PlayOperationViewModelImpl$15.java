package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class PlayOperationViewModelImpl$15
  implements INowShortVideoProtoManager.Callback
{
  PlayOperationViewModelImpl$15(PlayOperationViewModelImpl paramPlayOperationViewModelImpl, VideoData paramVideoData) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("err_msg:   ");
          paramArrayOfByte.append(paramBundle.err_msg.get());
          paramArrayOfByte.append(" isLiked=");
          paramArrayOfByte.append(PlayOperationViewModelImpl.access$500(this.b));
          QLog.i("PlayOperationViewModel", 2, paramArrayOfByte.toString());
        }
        if (!paramBundle.busi_buf.has()) {
          return;
        }
        paramArrayOfByte = new ilive_feeds_like.FeedsUnLikeRsp();
        paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
        this.b.setLiked(false);
        this.b.setLikes(paramArrayOfByte.total.get());
        this.a.h = PlayOperationViewModelImpl.access$800(this.b);
        this.a.o = false;
        PlayOperationViewModelImpl.access$602(this.b, false);
        ((INearbyMomentManager)this.b.app.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(PlayOperationViewModelImpl.access$900(this.b), paramArrayOfByte.total.get());
        if (!QLog.isColorLevel()) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("total:   ");
        localStringBuilder.append(paramArrayOfByte.total.get());
        localStringBuilder.append(",ret:     ");
        localStringBuilder.append(paramArrayOfByte.ret.get());
        QLog.i("PlayOperationViewModel", 2, localStringBuilder.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("err_msg:   ");
        localStringBuilder.append(paramBundle.err_msg.get());
        localStringBuilder.append(" isLiked=");
        localStringBuilder.append(PlayOperationViewModelImpl.access$500(this.b));
        localStringBuilder.append("  e:");
        localStringBuilder.append(paramArrayOfByte);
        QLog.w("PlayOperationViewModel", 1, localStringBuilder.toString());
        return;
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("errorCode:   ");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append(" isLiked=");
      paramArrayOfByte.append(PlayOperationViewModelImpl.access$500(this.b));
      QLog.w("PlayOperationViewModel", 1, paramArrayOfByte.toString());
      PlayOperationViewModelImpl.access$602(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.15
 * JD-Core Version:    0.7.0.1
 */