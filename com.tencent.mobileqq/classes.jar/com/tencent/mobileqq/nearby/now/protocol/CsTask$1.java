package com.tencent.mobileqq.nearby.now.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class CsTask$1
  extends ProtoUtils.TroopGiftProtocolObserver
{
  CsTask$1(CsTask paramCsTask) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      oidb_0xada.RspBody localRspBody = new oidb_0xada.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("err_msg:   ");
        localStringBuilder.append(localRspBody.err_msg.get());
        QLog.i("QQ_NOW_TASK", 2, localStringBuilder.toString());
        if (localRspBody.busi_buf.has())
        {
          if ((this.b.d != null) && (paramInt == 0))
          {
            this.b.d.a(paramInt, localRspBody.busi_buf.get().toByteArray(), paramBundle);
            return;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("err_msg1:   ");
          paramBundle.append(localRspBody.err_msg.get());
          QLog.i("QQ_NOW_TASK", 1, paramBundle.toString());
          if (this.b.e == null) {
            return;
          }
          this.b.e.a(paramInt, paramArrayOfByte);
          return;
        }
        QLog.i("QQ_NOW_TASK", 1, "err_msg2:   ");
        if (this.b.e == null) {
          return;
        }
        this.b.e.a(paramInt, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.i("QQ_NOW_TASK", 1, "err_msg3:   ");
        if (this.b.e == null) {
          return;
        }
      }
      this.b.e.a(paramInt, null);
    }
    else
    {
      QLog.i("QQ_NOW_TASK", 1, "err_msg4:   ");
      if (this.b.e != null) {
        this.b.e.a(paramInt, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.CsTask.1
 * JD-Core Version:    0.7.0.1
 */