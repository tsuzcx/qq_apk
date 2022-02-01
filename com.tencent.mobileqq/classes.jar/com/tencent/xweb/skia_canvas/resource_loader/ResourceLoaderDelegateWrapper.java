package com.tencent.xweb.skia_canvas.resource_loader;

import android.util.Log;
import androidx.annotation.NonNull;

public class ResourceLoaderDelegateWrapper
{
  private static final String TAG = "ResourceLoaderDelegateW";
  private final IResourceLoader mDelegate;
  private final Thread mThread;
  
  ResourceLoaderDelegateWrapper(@NonNull IResourceLoader paramIResourceLoader)
  {
    this.mDelegate = paramIResourceLoader;
    this.mThread = Thread.currentThread();
    nativeCreatePeer();
  }
  
  private void checkRunningThread()
  {
    if (Thread.currentThread() == this.mThread) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Any method should be run at thread ");
    localStringBuilder.append(this.mThread);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private native void nativeCreatePeer();
  
  private native void nativeNotifyResourceLoad(int paramInt, @NonNull byte[] paramArrayOfByte);
  
  @NonNull
  public byte[] loadResource(String paramString1, String paramString2)
  {
    Log.i("ResourceLoaderDelegateW", String.format("loadResource path:%s, referrerPolicy:%s, delegate: %s", new Object[] { paramString1, paramString2, this.mDelegate }));
    paramString2 = this.mDelegate.loadResource(paramString1, paramString2);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = new byte[0];
    }
    return paramString1;
  }
  
  public void loadResourceAsync(int paramInt, String paramString1, String paramString2)
  {
    Log.i("ResourceLoaderDelegateW", String.format("loadResourceAsync path:%s, referrerPolicy:%s, requestId: %d, delegate: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), this.mDelegate }));
    this.mDelegate.loadResourceAsync(paramString1, paramString2, new ResourceLoaderDelegateWrapper.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.resource_loader.ResourceLoaderDelegateWrapper
 * JD-Core Version:    0.7.0.1
 */