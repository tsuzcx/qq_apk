package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService.GIFCreatorCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class CameraEmoSingleSend$2
  implements IEmosmService.GIFCreatorCallback
{
  CameraEmoSingleSend$2(CameraEmoSingleSend paramCameraEmoSingleSend, Object paramObject, long paramLong) {}
  
  public void onGifCreateFail()
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateFail, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend).emoId) });
    CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend, false, null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sucFlag", "0");
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend.a().collectPerformance(null, "CamEmoCreateGIF", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, null);
  }
  
  public void onGifCreateSuccess(String paramString)
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateSuccess, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend).emoId) });
    CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend, true, paramString);
    ((IEmosmService)QRoute.api(IEmosmService.class)).clearFrameFilesGifCreator(this.jdField_a_of_type_JavaLangObject);
    paramString = new HashMap();
    paramString.put("sucFlag", "1");
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend.a().collectPerformance(null, "CamEmoCreateGIF", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend.2
 * JD-Core Version:    0.7.0.1
 */