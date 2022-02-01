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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResourceNameOnClickListener subscribe call :");
      localStringBuilder.append(paramResourceGrabSkinData);
      QLog.d("ResourceGrabModel", 2, localStringBuilder.toString());
    }
    ResourceGrabRepository.a(this.b, paramResourceGrabSkinData, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabRepository.1
 * JD-Core Version:    0.7.0.1
 */