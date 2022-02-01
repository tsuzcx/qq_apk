package com.tencent.qzonehub.api.zipanimate.impl;

import android.content.Context;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import cooperation.qzone.zipanimate.ZipDrawableLoaderInterface;

public class ZipDrawableLoaderImpl
  implements IZipDrawableLoader
{
  public ZipDrawableLoaderInterface getZipDrawableLoader(Context paramContext)
  {
    return new ZipDrawableLoader(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.zipanimate.impl.ZipDrawableLoaderImpl
 * JD-Core Version:    0.7.0.1
 */