package com.tencent.mobileqq.resourcesgrab;

import java.util.HashSet;
import rx.functions.Action0;

class ResourceGrabRepository$3
  implements Action0
{
  ResourceGrabRepository$3(ResourceGrabRepository paramResourceGrabRepository, ResourceGrabRepository.OnFileSaveCompleteCallback paramOnFileSaveCompleteCallback, HashSet paramHashSet) {}
  
  public void call()
  {
    ResourceGrabRepository.OnFileSaveCompleteCallback localOnFileSaveCompleteCallback = this.a;
    if (localOnFileSaveCompleteCallback != null) {
      localOnFileSaveCompleteCallback.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabRepository.3
 * JD-Core Version:    0.7.0.1
 */