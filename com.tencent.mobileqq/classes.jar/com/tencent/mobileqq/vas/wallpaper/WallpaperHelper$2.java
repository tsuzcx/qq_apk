package com.tencent.mobileqq.vas.wallpaper;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.IFactoryStub;
import java.io.File;
import kotlin.jvm.functions.Function1;

class WallpaperHelper$2
  implements Function1<IFactoryStub, Drawable>
{
  WallpaperHelper$2(WallpaperHelper paramWallpaperHelper, File paramFile) {}
  
  public Drawable a(IFactoryStub paramIFactoryStub)
  {
    return paramIFactoryStub.useCache(true).fromFile(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.2
 * JD-Core Version:    0.7.0.1
 */