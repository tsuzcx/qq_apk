package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;

class LiteSDKForCrossProcess$3
  implements IBizLoginObserver
{
  LiteSDKForCrossProcess$3(LiteSDKForCrossProcess paramLiteSDKForCrossProcess, int paramInt, ILiveLoginTicketListener paramILiveLoginTicketListener) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginILiveLoginTicketListener.a(paramInt, paramString);
  }
  
  public void a(BizLoginRequest paramBizLoginRequest)
  {
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcLiteSDKForCrossProcess.a(paramBizLoginRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess.3
 * JD-Core Version:    0.7.0.1
 */