package com.tencent.mobileqq.intervideo.lite_now_biz;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;

class VersionManager$2
  implements CsTask.OnCsError
{
  VersionManager$2(VersionManager paramVersionManager, VersionManager.IVersionGrayscaleCallback paramIVersionGrayscaleCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("getVersionGrayConfig, 0xada_0 errorCode=");
    paramArrayOfByte.append(paramInt);
    QLog.i("VersionManager", 1, paramArrayOfByte.toString());
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizVersionManager$IVersionGrayscaleCallback;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.VersionManager.2
 * JD-Core Version:    0.7.0.1
 */