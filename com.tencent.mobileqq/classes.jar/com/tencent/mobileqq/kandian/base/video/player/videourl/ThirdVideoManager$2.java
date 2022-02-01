package com.tencent.mobileqq.kandian.base.video.player.videourl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.UrlToUUIDCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.ac.ArticleCenter.GetVidByUrlResponse;
import tencent.im.oidb.ac.ArticleCenter.RetInfo;

class ThirdVideoManager$2
  implements BusinessObserver
{
  ThirdVideoManager$2(ThirdVideoManager paramThirdVideoManager, long paramLong, NewIntent paramNewIntent, UrlToUUIDCallback paramUrlToUUIDCallback, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CMD_VIDEO_URLFORUUID time : ");
      ((StringBuilder)localObject).append(l1 - l2);
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (!paramBoolean)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback;
      if (paramBundle != null) {
        paramBundle.a(this.jdField_a_of_type_JavaLangString, "error");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "CMD_VIDEO_URLFORUUID notSuccess!");
      }
      return;
    }
    Object localObject = paramBundle.getByteArray("data");
    if ((localObject != null) && (localObject.length > 0)) {}
    try
    {
      paramBundle = new ArticleCenter.GetVidByUrlResponse();
      paramBundle.mergeFrom((byte[])localObject);
      if (paramBundle.ret_info.ret_code.get() != 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback.a(this.jdField_a_of_type_JavaLangString, "error");
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CMD_VIDEO_URLFORUUID error:");
        ((StringBuilder)localObject).append(paramBundle.ret_info.ret_code.get());
        ((StringBuilder)localObject).append(", ");
        ((StringBuilder)localObject).append(paramBundle.ret_info.err_info.get());
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
      paramBundle = paramBundle.vid.get();
      if (paramBundle != null)
      {
        localObject = paramBundle.toStringUtf8();
        paramBundle = (Bundle)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback != null)
        {
          paramBundle = (Bundle)localObject;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            paramBundle = "error";
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback.a(this.jdField_a_of_type_JavaLangString, paramBundle);
        }
        if (!QLog.isColorLevel()) {
          break label421;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CMD_VIDEO_URLFORUUID vid:");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback.a(this.jdField_a_of_type_JavaLangString, "error");
      }
      if (!QLog.isColorLevel()) {
        break label421;
      }
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "CMD_VIDEO_URLFORUUID null vid!");
      return;
    }
    catch (Exception paramBundle)
    {
      label386:
      break label386;
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_JavaLangString, "error");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "CMD_VIDEO_URLFORUUID exception!");
    }
    label421:
    return;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlApiUrlToUUIDCallback;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_JavaLangString, "error");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.ThirdVideoManager", 2, "CMD_VIDEO_URLFORUUID empty data!");
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.2
 * JD-Core Version:    0.7.0.1
 */