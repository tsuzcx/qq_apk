package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import java.util.HashMap;
import java.util.List;

class PreloadServiceImpl$MultiDownTask$1
  implements IPreloadService.OnGetPathListener
{
  PreloadServiceImpl$MultiDownTask$1(PreloadServiceImpl.MultiDownTask paramMultiDownTask) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    int i = 1;
    PreloadServiceImpl.MultiDownTask localMultiDownTask = this.a;
    localMultiDownTask.jdField_a_of_type_Int += 1;
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_JavaUtilHashMap.put(paramPathResult.url, paramPathResult);
      if ((this.a.jdField_a_of_type_Int >= this.a.jdField_a_of_type_JavaUtilList.size()) && (this.a.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathsListener != null))
      {
        paramPathResult = this.a.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$OnGetPathsListener;
        if (!this.a.jdField_a_of_type_Boolean) {
          break label118;
        }
      }
    }
    label118:
    for (paramInt = i;; paramInt = 0)
    {
      paramPathResult.a(paramInt, this.a.jdField_a_of_type_JavaUtilHashMap);
      return;
      this.a.jdField_a_of_type_Boolean = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.MultiDownTask.1
 * JD-Core Version:    0.7.0.1
 */