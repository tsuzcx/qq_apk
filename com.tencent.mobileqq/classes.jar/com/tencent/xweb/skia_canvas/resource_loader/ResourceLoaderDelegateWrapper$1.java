package com.tencent.xweb.skia_canvas.resource_loader;

import android.util.Log;

class ResourceLoaderDelegateWrapper$1
  implements IResourceLoader.ResourceLoadCallback
{
  ResourceLoaderDelegateWrapper$1(ResourceLoaderDelegateWrapper paramResourceLoaderDelegateWrapper, int paramInt) {}
  
  public void onResourceLoaded(byte[] paramArrayOfByte)
  {
    ResourceLoaderDelegateWrapper.access$000(this.this$0);
    if (paramArrayOfByte == null)
    {
      Log.e("ResourceLoaderDelegateW", "resource is null, return");
      ResourceLoaderDelegateWrapper.access$100(this.this$0, this.val$requestId, new byte[0]);
      return;
    }
    ResourceLoaderDelegateWrapper.access$100(this.this$0, this.val$requestId, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderDelegateWrapper.1
 * JD-Core Version:    0.7.0.1
 */