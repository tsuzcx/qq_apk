package com.tencent.mobileqq.nearby.now.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

class InfinitePlayListDataModel$1
  implements INowShortVideoProtoManager.Callback
{
  InfinitePlayListDataModel$1(InfinitePlayListDataModel paramInfinitePlayListDataModel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("errorCode:   ");
      paramBundle.append(paramInt);
      QLog.i("InfinitePlayListDataModel", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xada.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("err_msg:   ");
          paramArrayOfByte.append(paramBundle.err_msg.get());
          QLog.i("InfinitePlayListDataModel", 2, paramArrayOfByte.toString());
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new FeedsProtocol.GetMediaDetailRsp();
          try
          {
            paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
            paramBundle = this.a;
            if (paramArrayOfByte.is_end.get() == 0) {
              break label391;
            }
            bool = true;
            InfinitePlayListDataModel.a(paramBundle, bool);
            this.a.a = paramArrayOfByte.total.get();
            InfinitePlayListDataModel.a(this.a, paramArrayOfByte);
            if (!TextUtils.isEmpty(InfinitePlayListDataModel.a(this.a)))
            {
              int j = this.a.d.size();
              paramInt = 0;
              int i = j;
              if (paramInt < this.a.d.size())
              {
                if (!InfinitePlayListDataModel.a(this.a).equals(((VideoData)this.a.d.get(paramInt)).c)) {
                  break label397;
                }
                this.a.e.a((VideoData)this.a.d.get(paramInt));
                i = paramInt;
              }
              if (i < this.a.d.size())
              {
                this.a.d.remove(i);
                i += 1;
                continue;
              }
            }
            paramBundle = this.a.e;
            if (!paramArrayOfByte.err_code.has()) {
              break label404;
            }
            paramInt = paramArrayOfByte.err_code.get();
            paramBundle.a(0, paramInt);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            this.a.e.a();
            return;
          }
        }
        else
        {
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      label391:
      boolean bool = false;
      continue;
      label397:
      paramInt += 1;
      continue;
      label404:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.InfinitePlayListDataModel.1
 * JD-Core Version:    0.7.0.1
 */