package com.tencent.mobileqq.nearby.now.model;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class PlayListDataModel$1
  implements INowShortVideoProtoManager.Callback
{
  PlayListDataModel$1(PlayListDataModel paramPlayListDataModel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      paramBundle = PlayListDataModel.a(this.a);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCode:   ");
      localStringBuilder.append(paramInt);
      QLog.i(paramBundle, 2, localStringBuilder.toString());
    }
    if (paramArrayOfByte != null) {
      paramBundle = new oidb_0xada.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = PlayListDataModel.a(this.a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("err_msg:   ");
          localStringBuilder.append(paramBundle.err_msg.get());
          QLog.i(paramArrayOfByte, 2, localStringBuilder.toString());
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new FeedsProtocol.GetMediaDetailRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (QLog.isColorLevel())
          {
            paramBundle = PlayListDataModel.a(this.a);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("GetMediaDetailRsp  error_code:   ");
            localStringBuilder.append(paramArrayOfByte.err_code.get());
            localStringBuilder.append(",err_msg:     ");
            localStringBuilder.append(paramArrayOfByte.err_msg.get().toStringUtf8());
            localStringBuilder.append(",total:  ");
            localStringBuilder.append(paramArrayOfByte.total.get());
            QLog.i(paramBundle, 2, localStringBuilder.toString());
          }
          paramBundle = this.a;
          int i = paramArrayOfByte.is_end.get();
          paramInt = 0;
          if (i == 0) {
            break label366;
          }
          bool = true;
          paramBundle.b = bool;
          this.a.a = paramArrayOfByte.total.get();
          PlayListDataModel.a(this.a, paramArrayOfByte);
          PlayListDataModel.a(this.a, PlayListDataModel.b(this.a) + 10);
          paramBundle = this.a.e;
          if (paramArrayOfByte.err_code.has()) {
            paramInt = paramArrayOfByte.err_code.get();
          }
          paramBundle.a(1, paramInt);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return;
      label366:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.PlayListDataModel.1
 * JD-Core Version:    0.7.0.1
 */