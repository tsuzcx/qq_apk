package com.tencent.mobileqq.nearby.profilecard.moment;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_write.DelFeedRsp;
import com.tencent.qphone.base.util.QLog;

final class NearbyMomentProtocol$4
  implements CsTask.Callback
{
  NearbyMomentProtocol$4(NearbyMomentProtocol.DeleteFeedCallback paramDeleteFeedCallback, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramInt == 0)
    {
      paramBundle = new ilive_feeds_write.DelFeedRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.ret.get();
        if (paramInt != 0)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("deleteMomentFeed error, ret=");
          paramArrayOfByte.append(paramInt);
          paramArrayOfByte.append(",msg=");
          paramArrayOfByte.append(paramBundle.err_msg.get().toStringUtf8());
          QLog.i("NearbyMomentProtocol", 1, paramArrayOfByte.toString());
          bool1 = false;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("deleteMomentFeed error, e=");
        paramBundle.append(paramArrayOfByte.toString());
        QLog.i("NearbyMomentProtocol", 1, paramBundle.toString());
        bool1 = bool2;
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("deleteMomentFeed error, errorCode =");
      paramArrayOfByte.append(paramInt);
      QLog.i("NearbyMomentProtocol", 1, paramArrayOfByte.toString());
      bool1 = bool2;
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$DeleteFeedCallback;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(bool1, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.4
 * JD-Core Version:    0.7.0.1
 */