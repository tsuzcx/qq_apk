package com.tencent.mobileqq.hotpic;

import com.tencent.image.URLDrawableHandler;
import java.io.File;

class HotVideoPreviewDownloader$1
  implements HotVideoData.HotVideoGetUrlCallBack
{
  HotVideoPreviewDownloader$1(HotVideoPreviewDownloader paramHotVideoPreviewDownloader, HotVideoData paramHotVideoData, File paramFile, URLDrawableHandler paramURLDrawableHandler) {}
  
  public void a(HotVideoData.HotVideoGetUrlResult paramHotVideoGetUrlResult)
  {
    if (paramHotVideoGetUrlResult.a)
    {
      this.a.url = paramHotVideoGetUrlResult.a();
      HotVideoPreviewDownloader.a(this.d, this.b, this.a, this.c);
      return;
    }
    this.b.delete();
    paramHotVideoGetUrlResult = this.a;
    paramHotVideoGetUrlResult.onFileDownloadFailed(paramHotVideoGetUrlResult.picIndex);
    paramHotVideoGetUrlResult = this.c;
    if (paramHotVideoGetUrlResult != null) {
      paramHotVideoGetUrlResult.onFileDownloadFailed(this.a.picIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader.1
 * JD-Core Version:    0.7.0.1
 */