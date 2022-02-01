package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.IOException;

@KeepClassConstructor
public class PicTypeLong
  extends PicType
{
  PicTypeLong(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    int k = paramCompressInfo.p;
    int j = 1;
    int i = j;
    if (k != 0)
    {
      i = j;
      if (k != 1)
      {
        i = 2;
        if (k != 2) {
          return -1;
        }
      }
    }
    return i;
  }
  
  protected boolean f()
  {
    StringBuilder localStringBuilder1;
    if (this.m == 1)
    {
      if ((this.l.w) && (Utils.c(this.l.h)))
      {
        this.l.l = this.l.h;
        localObject = this.l;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.j);
        localStringBuilder1.append(this.l.a);
        localStringBuilder1.append(HardCodeUtil.a(2131905972));
        ((CompressInfo)localObject).s = localStringBuilder1.toString();
        localObject = this.j;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.l.a);
        localStringBuilder1.append(" compress()");
        Logger.a(localObject, localStringBuilder1.toString(), HardCodeUtil.a(2131905973));
        return true;
      }
      this.l.l = Utils.a(this.l.h, this.l.p);
      if (TextUtils.isEmpty(this.l.l))
      {
        localObject = this.j;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.l.a);
        localStringBuilder1.append(" destPath is empty");
        Logger.b(localObject, "compress()", localStringBuilder1.toString());
        return false;
      }
      if (FileUtils.fileExistsAndNotEmpty(this.l.l))
      {
        localObject = this.j;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.l.a);
        localStringBuilder1.append(" destPath exist. return true");
        Logger.b(localObject, "compress()", localStringBuilder1.toString());
        return true;
      }
    }
    try
    {
      localObject = BaseImageUtil.a(this.l.h, null);
      if (localObject == null)
      {
        localObject = this.j;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.l.a);
        localStringBuilder1.append(" bm == null, maybe is broken");
        Logger.b(localObject, "compress()", localStringBuilder1.toString());
        return false;
      }
      boolean bool = Utils.a(this.l.l, (Bitmap)localObject, c(), this.l.a, this.l);
      if (!JpegExifReader.isCrashJpeg(this.l.h)) {
        try
        {
          if (!BaseImageUtil.a(new ExifInterface(this.l.h), new ExifInterface(this.l.l), true)) {
            Logger.b(this.j, "compress()", "Failed to save exif");
          }
        }
        catch (IOException localIOException)
        {
          String str = this.j;
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("cannot read exif, ");
          localStringBuilder3.append(localIOException.getMessage());
          Logger.b(str, "compress()", localStringBuilder3.toString());
        }
      }
      if (localObject != null) {
        ((Bitmap)localObject).recycle();
      }
      return bool;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label487:
      StringBuilder localStringBuilder2;
      break label487;
    }
    this.l.a(true);
    Object localObject = this.j;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.l.a);
    localStringBuilder2.append(" decodeFile oom, execute commonCompress()");
    Logger.b(localObject, "compress()", localStringBuilder2.toString());
    this.l.l = "";
    return e();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeLong
 * JD-Core Version:    0.7.0.1
 */