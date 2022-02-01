package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;

class SoLoaderBaseCommonetServiceImpl$1
  implements IPreloadService.OnGetPathListener
{
  SoLoaderBaseCommonetServiceImpl$1(SoLoaderBaseCommonetServiceImpl paramSoLoaderBaseCommonetServiceImpl, OnSoGetPathListener paramOnSoGetPathListener) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    OnSoGetPathListener localOnSoGetPathListener = this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnSoGetPathListener;
    if (localOnSoGetPathListener != null) {
      localOnSoGetPathListener.onResult(paramInt, paramPathResult.filePath, paramPathResult.folderPath, paramPathResult.url, paramPathResult.isAlreadyExist, paramPathResult.subErrCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderBaseCommonetServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */