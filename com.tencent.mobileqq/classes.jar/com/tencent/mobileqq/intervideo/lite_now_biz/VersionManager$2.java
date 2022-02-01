package com.tencent.mobileqq.intervideo.lite_now_biz;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;

class VersionManager$2
  implements CsTask.OnCsError
{
  VersionManager$2(VersionManager paramVersionManager, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i("VersionManager", 1, "getVersionGrayConfig, 0xada_0 errorCode=" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager$IVersionGrayscaleCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager$IVersionGrayscaleCallback.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager.2
 * JD-Core Version:    0.7.0.1
 */