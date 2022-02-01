package com.tencent.mobileqq.qqexpand.utils.impl;

import com.qflutter.resource_loader.NativeImageInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.flutter.plugin.QFlutterResourceLoaderNativeImp;
import com.tencent.mobileqq.qqexpand.utils.IResourceLoaderDrawableApi;

public class ResourceLoaderDrawableApiImpl
  implements IResourceLoaderDrawableApi
{
  public int getDrawableId(String paramString)
  {
    return new QFlutterResourceLoaderNativeImp(BaseApplicationImpl.getContext()).getNativeAppImage(paramString).drawableId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ResourceLoaderDrawableApiImpl
 * JD-Core Version:    0.7.0.1
 */