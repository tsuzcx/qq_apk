package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.utils.ThreadCenter;

class CsTaskImpl$1
  implements ChannelCallback
{
  CsTaskImpl$1(CsTaskImpl paramCsTaskImpl, byte[] paramArrayOfByte) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    ThreadCenter.clear(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl);
    if (CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl) > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl.send(this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    if (CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl) != null) {
      CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl).onError(paramBoolean, paramInt, paramString);
    }
    CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl, null);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    ThreadCenter.clear(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl);
    if (CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl) != null) {
      CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl).onRecv(paramArrayOfByte);
    }
    CsTaskImpl.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelCsTaskImpl, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.CsTaskImpl.1
 * JD-Core Version:    0.7.0.1
 */