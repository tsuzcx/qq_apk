package com.tencent.mobileqq.identification;

import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.WeJson;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.GetLiveStyleResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import java.util.concurrent.atomic.AtomicBoolean;

final class FaceLoginHelper$2
  implements YTAGReflectLiveCheckInterface.GetLiveStyleResult
{
  FaceLoginHelper$2(int paramInt, AtomicBoolean paramAtomicBoolean, String paramString1, String paramString2, String paramString3, long paramLong, FaceLoginHelper.IConfInterface paramIConfInterface) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new WeJson();
    LiveStyleRequester.YTLiveStyleReq localYTLiveStyleReq = new LiveStyleRequester.YTLiveStyleReq(-2.0F, String.valueOf(101810106));
    localYTLiveStyleReq.app_id = String.valueOf(101810106);
    localObject = ((WeJson)localObject).toJson(localYTLiveStyleReq);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    FaceLoginHelper.a(101810106, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceLoginHelper$IConfInterface);
    QLog.d("FaceLoginHelper", 1, new Object[] { "getLightInfo Failed code=", Integer.valueOf(paramInt), " tips=", paramString1, " howtofix=", paramString2 });
  }
  
  public void onSuccess(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, LiveStyleResponse paramLiveStyleResponse)
  {
    paramYTLiveStyleReq.app_id = String.valueOf(this.jdField_a_of_type_Int);
    paramYTLiveStyleReq = new WeJson().toJson(paramYTLiveStyleReq);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, true))
    {
      QLog.d("FaceLoginHelper", 1, "sendPacket isLoading now");
      return;
    }
    FaceLoginHelper.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Long, paramYTLiveStyleReq, this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceLoginHelper$IConfInterface);
    QLog.d("FaceLoginHelper", 1, "getLightInfo success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper.2
 * JD-Core Version:    0.7.0.1
 */