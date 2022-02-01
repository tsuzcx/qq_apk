package com.tencent.mobileqq.nearby.now.view.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class VideoViewTVKImpl$5
  implements TVK_IMediaPlayer.OnDownloadCallbackListener
{
  VideoViewTVKImpl$5(VideoViewTVKImpl paramVideoViewTVKImpl, String paramString1, String paramString2, String paramString3) {}
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.a != null) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.getInt("callBackType");
        if (QLog.isColorLevel()) {
          QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback callBackType=" + i);
        }
        if (i != 7) {
          break label313;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label312;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback success , vid = " + this.b);
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.a.a(this.b, this.c, new File(this.jdField_a_of_type_JavaLangString));
        return;
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label312;
        }
      }
      int i = paramString.getInt("errorCode");
      if (QLog.isColorLevel()) {
        QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback errorCode=" + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.a.a(this.b, this.c, i);
      return;
      QLog.d("VideoViewTVKImpl", 2, "OnDownloadCallback JSONException=" + paramString.getMessage());
      return;
      label312:
      label313:
      do
      {
        long l1;
        if (i == 2)
        {
          l1 = paramString.getLong("fileSize");
          long l2 = paramString.getLong("offset");
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.a.a(this.b, this.c, l1, l2);
          return;
        }
        if (i == 1)
        {
          l1 = paramString.getLong("fileSize");
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.a.a(this.b, this.c, l1);
        }
        return;
        if (i == 4) {
          break;
        }
      } while (i != 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl.5
 * JD-Core Version:    0.7.0.1
 */