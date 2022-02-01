package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.qphone.base.util.QLog;

final class NearbyMomentProtocol$1
  implements CsTask.OnCsError
{
  NearbyMomentProtocol$1(NearbyMomentProtocol.GetMomentListCallback paramGetMomentListCallback, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i("NearbyMomentProtocol", 1, "getMomentList, 0xada_0 errorCode=" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$GetMomentListCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$GetMomentListCallback.a(false, null, true, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.1
 * JD-Core Version:    0.7.0.1
 */