package com.tencent.mobileqq.nearby.profilecard.moment;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

final class NearbyMomentProtocol$6
  implements INowShortVideoProtoManager.Callback
{
  NearbyMomentProtocol$6(NearbyMomentProtocol.UnLikeCallback paramUnLikeCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_feeds_like.FeedsUnLikeRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          boolean bool3 = paramArrayOfByte.ret.has();
          if (bool3)
          {
            paramInt = paramArrayOfByte.ret.get();
            if (paramInt == 0)
            {
              try
              {
                paramInt = paramArrayOfByte.total.get();
                try
                {
                  if (QLog.isColorLevel())
                  {
                    paramArrayOfByte = new StringBuilder();
                    paramArrayOfByte.append("unlike success, total:   ");
                    paramArrayOfByte.append(paramInt);
                    QLog.i("NearbyMomentProtocol", 2, paramArrayOfByte.toString());
                  }
                  bool1 = true;
                }
                catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
                bool1 = true;
              }
              catch (InvalidProtocolBufferMicroException paramArrayOfByte)
              {
                paramInt = 0;
              }
              break label219;
            }
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unlike error, ret=");
          localStringBuilder.append(paramArrayOfByte.ret.get());
          localStringBuilder.append(",err_msg=");
          localStringBuilder.append(paramBundle.err_msg.get());
          QLog.i("NearbyMomentProtocol", 1, localStringBuilder.toString());
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramInt = 0;
        label219:
        paramArrayOfByte.printStackTrace();
        break label232;
      }
    }
    paramInt = 0;
    bool1 = bool2;
    label232:
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(bool1, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.6
 * JD-Core Version:    0.7.0.1
 */