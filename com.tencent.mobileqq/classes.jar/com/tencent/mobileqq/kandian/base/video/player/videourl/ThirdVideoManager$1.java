package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.os.Bundle;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class ThirdVideoManager$1
  implements BusinessObserver
{
  ThirdVideoManager$1(ThirdVideoManager paramThirdVideoManager, NewIntent paramNewIntent, String paramString1, String paramString2, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    ThirdVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlThirdVideoManager$UUIDToUrlCallback, this.jdField_a_of_type_Long, paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.1
 * JD-Core Version:    0.7.0.1
 */