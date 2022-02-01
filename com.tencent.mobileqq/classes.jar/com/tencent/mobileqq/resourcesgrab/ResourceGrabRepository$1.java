package com.tencent.mobileqq.resourcesgrab;

import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import rx.functions.Action1;

class ResourceGrabRepository$1
  implements Action1<ResourceGrabSkinData>
{
  ResourceGrabRepository$1(ResourceGrabRepository paramResourceGrabRepository, HashSet paramHashSet) {}
  
  public void a(ResourceGrabSkinData paramResourceGrabSkinData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabModel", 2, "ResourceNameOnClickListener subscribe call :" + paramResourceGrabSkinData);
    }
    ResourceGrabRepository.a(this.jdField_a_of_type_ComTencentMobileqqResourcesgrabResourceGrabRepository, paramResourceGrabSkinData, this.jdField_a_of_type_JavaUtilHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabRepository.1
 * JD-Core Version:    0.7.0.1
 */