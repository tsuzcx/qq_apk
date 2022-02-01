package com.tencent.mobileqq.resourcesgrab;

import java.util.HashSet;
import rx.functions.Action0;

class ResourceGrabRepository$3
  implements Action0
{
  ResourceGrabRepository$3(ResourceGrabRepository paramResourceGrabRepository, ResourceGrabRepository.OnFileSaveCompleteCallback paramOnFileSaveCompleteCallback, HashSet paramHashSet) {}
  
  public void call()
  {
    ResourceGrabRepository.OnFileSaveCompleteCallback localOnFileSaveCompleteCallback = this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabRepository$OnFileSaveCompleteCallback;
    if (localOnFileSaveCompleteCallback != null) {
      localOnFileSaveCompleteCallback.a(this.jdField_a_of_type_JavaUtilHashSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabRepository.3
 * JD-Core Version:    0.7.0.1
 */