package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.RspBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.TinyInfo;

class NearbyFaceScoreManager$3
  extends ProtoUtils.AppProtocolObserver
{
  NearbyFaceScoreManager$3(NearbyFaceScoreManager paramNearbyFaceScoreManager, FaceScoreCallBack paramFaceScoreCallBack, long paramLong) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onResult errorCode=");
      paramBundle.append(paramInt);
      paramBundle.append(", data=");
      paramBundle.append(paramArrayOfByte);
      QLog.e("Q..troop.faceScore", 2, paramBundle.toString());
    }
    if (paramInt == 0)
    {
      if (paramArrayOfByte != null) {
        try
        {
          paramBundle = new oidb_0x8da.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = paramBundle.rpt_msg_tiny_info.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            paramBundle = (oidb_0x8da.TinyInfo)paramArrayOfByte.next();
            if (paramBundle.uint32_result.get() == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(paramBundle.uint64_uin.get(), paramBundle.uint64_tinyid.get());
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(this.jdField_a_of_type_Long, -1L);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getTinyIdByUin oidb_0x8da onResult  uin=");
              localStringBuilder.append(paramBundle.uint64_uin.get());
              localStringBuilder.append(" tinyid=");
              localStringBuilder.append(paramBundle.uint64_tinyid.get());
              localStringBuilder.append(" result=");
              localStringBuilder.append(paramBundle.uint32_result.get());
              QLog.e("Q..troop.faceScore", 2, localStringBuilder.toString());
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(this.jdField_a_of_type_Long, -1L);
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("onResult exception=");
            paramBundle.append(paramArrayOfByte.toString());
            QLog.e("Q..troop.faceScore", 2, paramBundle.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(this.jdField_a_of_type_Long, -1L);
          return;
        }
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFaceScoreCallBack.a(this.jdField_a_of_type_Long, -1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFaceScoreManager.3
 * JD-Core Version:    0.7.0.1
 */