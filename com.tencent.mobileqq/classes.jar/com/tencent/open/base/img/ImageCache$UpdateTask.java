package com.tencent.open.base.img;

import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected String a;
  protected String b;
  protected String c;
  protected ImageDownCallback d;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, ImageDownCallback paramImageDownCallback)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramImageDownCallback;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof UpdateTask)) {
      return false;
    }
    return this.a.equals(((UpdateTask)paramObject).a);
  }
  
  public void run()
  {
    try
    {
      if (((!Common.d()) || (!APNUtil.i(CommonDataAdapter.a().b()))) && (this.d != null)) {
        this.d.b(this.a, this.b, this.c);
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Common.f());
      ((StringBuilder)localObject1).append(ImageCache.a);
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(FileUtils.a(this.c));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("imgFilePath = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" | ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" | ");
      ((StringBuilder)localObject2).append(FileUtils.a(this.c));
      ((StringBuilder)localObject2).append(" key=");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" url=");
      ((StringBuilder)localObject2).append(this.c);
      LogUtility.c("downloadImage", ((StringBuilder)localObject2).toString());
      if ((new File((String)localObject1).exists()) && (this.d != null))
      {
        this.d.a(this.a, this.b, (String)localObject1);
        this.d = null;
      }
      localObject2 = ImageCache.c.a(this.a);
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("image not in db. key=");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(" url=");
        ((StringBuilder)localObject1).append(this.c);
        LogUtility.a("ImageCache", ((StringBuilder)localObject1).toString());
        localObject1 = new ImageInfo();
        ((ImageInfo)localObject1).a = this.a;
        ((ImageInfo)localObject1).b = this.c;
        ((ImageInfo)localObject1).e = 0L;
        ((ImageInfo)localObject1).f = this.b;
      }
      else
      {
        ((ImageInfo)localObject2).b = this.c;
        if (this.d != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("file is deleted.");
          ((StringBuilder)localObject1).append(this.c);
          ((StringBuilder)localObject1).append(" key=");
          ((StringBuilder)localObject1).append(this.a);
          LogUtility.a("ImageCache", ((StringBuilder)localObject1).toString());
          ((ImageInfo)localObject2).e = 0L;
          localObject1 = localObject2;
        }
        else
        {
          long l = System.currentTimeMillis();
          localObject1 = localObject2;
          if (l > ((ImageInfo)localObject2).d)
          {
            localObject1 = localObject2;
            if (l < ((ImageInfo)localObject2).c + ((ImageInfo)localObject2).d)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("currenttime=");
              ((StringBuilder)localObject1).append(System.currentTimeMillis());
              ((StringBuilder)localObject1).append("\nmaxage+updatetime=");
              ((StringBuilder)localObject1).append(((ImageInfo)localObject2).c);
              ((StringBuilder)localObject1).append(((ImageInfo)localObject2).d);
              ((StringBuilder)localObject1).append(" key=");
              ((StringBuilder)localObject1).append(this.a);
              ((StringBuilder)localObject1).append(" url=");
              ((StringBuilder)localObject1).append(this.c);
              LogUtility.a("ImageCache", ((StringBuilder)localObject1).toString());
              return;
            }
          }
        }
      }
      if (ImageDownloader.a((ImageInfo)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("download image succ. ");
        ((StringBuilder)localObject2).append(this.c);
        ((StringBuilder)localObject2).append(" key=");
        ((StringBuilder)localObject2).append(this.a);
        LogUtility.d("ImageCache", ((StringBuilder)localObject2).toString());
        ImageCache.c.a((ImageInfo)localObject1);
        if (this.d != null)
        {
          localObject2 = this.d;
          String str1 = this.a;
          String str2 = this.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(Common.f());
          localStringBuilder.append(ImageCache.a);
          localStringBuilder.append(this.b);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(FileUtils.a(((ImageInfo)localObject1).b));
          ((ImageDownCallback)localObject2).a(str1, str2, localStringBuilder.toString());
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("download failed.");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(" key=");
        ((StringBuilder)localObject1).append(this.a);
        LogUtility.d("ImageCache", ((StringBuilder)localObject1).toString());
        if (this.d != null)
        {
          this.d.b(this.a, this.b, this.c);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.b("ImageCache", "Download img warning", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */