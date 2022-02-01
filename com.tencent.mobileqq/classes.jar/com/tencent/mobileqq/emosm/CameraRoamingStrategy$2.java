package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.List;

class CameraRoamingStrategy$2
  implements CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback
{
  CameraRoamingStrategy$2(CameraRoamingStrategy paramCameraRoamingStrategy, CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback) {}
  
  public void a(List<EmoticonInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmCameraRoamingStrategy.a(paramList);
    CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback localCustomEmotionDataInPanelCallback = this.jdField_a_of_type_ComTencentMobileqqEmosmCustomEmotionRoamingDBManagerBase$CustomEmotionDataInPanelCallback;
    if (localCustomEmotionDataInPanelCallback != null) {
      localCustomEmotionDataInPanelCallback.a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.2
 * JD-Core Version:    0.7.0.1
 */