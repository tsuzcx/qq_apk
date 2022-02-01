package com.tencent.mobileqq.soload.temp.api.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;

class SoloadOtherServiceImpl$1
  implements IPreloadService.OnGetPathListener
{
  SoloadOtherServiceImpl$1(SoloadOtherServiceImpl paramSoloadOtherServiceImpl, OnSoGetPathListener paramOnSoGetPathListener) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnSoGetPathListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnSoGetPathListener.a(paramInt, paramPathResult.filePath, paramPathResult.folderPath, paramPathResult.url, paramPathResult.isAlreadyExist, paramPathResult.subErrCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.temp.api.impl.SoloadOtherServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */