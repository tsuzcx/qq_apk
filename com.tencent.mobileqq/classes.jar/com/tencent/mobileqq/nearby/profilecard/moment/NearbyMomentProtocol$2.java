package com.tencent.mobileqq.nearby.profilecard.moment;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

final class NearbyMomentProtocol$2
  implements CsTask.Callback
{
  NearbyMomentProtocol$2(int paramInt, NearbyMomentProtocol.GetMomentListCallback paramGetMomentListCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new ArrayList();
    int i = this.jdField_a_of_type_Int;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool4 = true;
    boolean bool3 = true;
    if (paramInt == 0)
    {
      Object localObject = new ilive_feeds_read.ReadNearUserFeedsRsp();
      try
      {
        ((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).mergeFrom(paramArrayOfByte);
        if (!((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).result.has())
        {
          QLog.i("NearbyMomentProtocol", 1, "getMomentList, don't has result");
        }
        else
        {
          if (((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).result.get() == 0)
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("endFlag=");
              paramArrayOfByte.append(((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).end_flag.get());
              paramArrayOfByte.append(",size=");
              paramArrayOfByte.append(((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).infos.size());
              paramArrayOfByte.append(",total=");
              paramArrayOfByte.append(((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).total.get());
              QLog.i("NearbyMomentProtocol", 2, paramArrayOfByte.toString());
            }
            try
            {
              paramBundle.addAll(((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).infos.get());
              paramInt = ((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).end_flag.get();
              bool1 = bool2;
              if (paramInt == 1) {
                bool1 = true;
              }
              try
              {
                paramInt = ((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).pos.get();
                bool2 = bool1;
                bool1 = bool3;
              }
              catch (InvalidProtocolBufferMicroException paramArrayOfByte)
              {
                bool3 = true;
                bool2 = bool1;
                bool1 = bool3;
                break label318;
              }
              paramArrayOfByte = new StringBuilder();
            }
            catch (InvalidProtocolBufferMicroException paramArrayOfByte)
            {
              bool1 = true;
            }
          }
          paramArrayOfByte.append("getMomentList error, result =");
          paramArrayOfByte.append(((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).result.get());
          paramArrayOfByte.append(",errMsg=");
          paramArrayOfByte.append(((ilive_feeds_read.ReadNearUserFeedsRsp)localObject).err_msg.get());
          QLog.i("NearbyMomentProtocol", 1, paramArrayOfByte.toString());
        }
        bool2 = true;
        bool1 = false;
        paramInt = i;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        bool1 = false;
        bool2 = true;
        label318:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMomentList, e=");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.i("NearbyMomentProtocol", 1, ((StringBuilder)localObject).toString());
        paramInt = i;
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("getMomentList, 0xada_0 errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.i("NearbyMomentProtocol", 1, paramArrayOfByte.toString());
      bool2 = bool4;
      paramInt = i;
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$GetMomentListCallback;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(bool1, paramBundle, bool2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.2
 * JD-Core Version:    0.7.0.1
 */