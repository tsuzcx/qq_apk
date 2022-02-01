package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class PlayOperationViewModelImpl$31
  implements INowShortVideoProtoManager.Callback
{
  PlayOperationViewModelImpl$31(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.31
 * JD-Core Version:    0.7.0.1
 */