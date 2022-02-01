package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.GIFCreator;
import dov.com.qq.im.ae.gif.video.GIFCreator.Callback;
import java.util.HashMap;

class CameraEmoSingleSend$2
  implements GIFCreator.Callback
{
  CameraEmoSingleSend$2(CameraEmoSingleSend paramCameraEmoSingleSend, GIFCreator paramGIFCreator, long paramLong) {}
  
  public void a()
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateFail, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend).emoId) });
    CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend, false, null);
    HashMap localHashMap = new HashMap();
    localHashMap.put("sucFlag", "0");
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend.a().collectPerformance(null, "CamEmoCreateGIF", false, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, localHashMap, null);
  }
  
  public void a(String paramString)
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onGifCreateSuccess, emoId:", Integer.valueOf(CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend).emoId) });
    CameraEmoSingleSend.a(this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend, true, paramString);
    this.jdField_a_of_type_DovComQqImAeGifVideoGIFCreator.a();
    paramString = new HashMap();
    paramString.put("sucFlag", "1");
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoSingleSend.a().collectPerformance(null, "CamEmoCreateGIF", true, System.currentTimeMillis() - this.jdField_a_of_type_Long, 0L, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend.2
 * JD-Core Version:    0.7.0.1
 */