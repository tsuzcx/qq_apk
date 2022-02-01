package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class PlayOperationViewModelImpl$27
  implements INowShortVideoProtoManager.Callback
{
  PlayOperationViewModelImpl$27(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
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
          paramArrayOfByte.append("queryVideoState err_msg:   ");
          paramArrayOfByte.append(paramBundle.err_msg.get());
          QLog.i("PlayOperationViewModel", 2, paramArrayOfByte.toString());
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_short_video_label.GetShortVideoVideoLabelRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          this.a.parseShortVideoVideoLabel(paramArrayOfByte);
          return;
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
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.27
 * JD-Core Version:    0.7.0.1
 */