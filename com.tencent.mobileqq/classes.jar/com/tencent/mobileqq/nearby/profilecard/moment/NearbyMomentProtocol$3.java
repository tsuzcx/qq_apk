package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.qphone.base.util.QLog;

final class NearbyMomentProtocol$3
  implements CsTask.OnCsError
{
  NearbyMomentProtocol$3(NearbyMomentProtocol.DeleteFeedCallback paramDeleteFeedCallback, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, errorCode =" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$DeleteFeedCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$DeleteFeedCallback.a(false, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.3
 * JD-Core Version:    0.7.0.1
 */