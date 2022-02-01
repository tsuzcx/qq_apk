package com.tencent.mobileqq.soload.biz;

import android.os.Bundle;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import eipc.EIPCResult;

class SoLoadIPCModule$1
  implements OnGetSoLoadInfoListener
{
  SoLoadIPCModule$1(SoLoadIPCModule paramSoLoadIPCModule, int paramInt) {}
  
  public void a(SoLoadInfo paramSoLoadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("res", paramSoLoadInfo);
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizSoLoadIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.SoLoadIPCModule.1
 * JD-Core Version:    0.7.0.1
 */