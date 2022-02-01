package com.tencent.mobileqq.richmediabrowser;

import com.tencent.raft.raftframework.IServiceProvider;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;

class AIOGalleryActivity$1
  implements IServiceProvider
{
  AIOGalleryActivity$1(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public ServiceWrapper provide()
  {
    return new ServiceWrapper(new AIOBrowserBuilder(this.a), "Prototype");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.1
 * JD-Core Version:    0.7.0.1
 */