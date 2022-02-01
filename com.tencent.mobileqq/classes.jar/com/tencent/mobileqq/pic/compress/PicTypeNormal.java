package com.tencent.mobileqq.pic.compress;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class PicTypeNormal
  extends PicType
{
  public static final int l;
  
  static
  {
    Resources localResources = MobileQQ.getContext().getResources();
    int j = localResources.getDisplayMetrics().heightPixels;
    int k = localResources.getDisplayMetrics().widthPixels;
    int i = k;
    if (j > k) {
      i = j;
    }
    l = i;
  }
  
  PicTypeNormal(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    int i = paramCompressInfo.jdField_g_of_type_Int;
    if ((i != 0) && (i != 1))
    {
      if (i != 2) {
        return -1;
      }
      return 2;
    }
    return 0;
  }
  
  protected int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    int j = AbstractPicType.d;
    int k = l;
    int i = j;
    if (j > k) {
      i = k;
    }
    arrayOfInt[0] = i;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicType.SendPhotoMaxLongSide = ");
    localStringBuilder.append(arrayOfInt[0]);
    Logger.a("PicTypeNormal", "getScaleLargerSide", localStringBuilder.toString());
    return arrayOfInt;
  }
  
  protected boolean d()
  {
    int i = this.k;
    int k = 0;
    if (i == 0)
    {
      Object localObject2;
      if ((this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Boolean) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131708180));
        ((CompressInfo)localObject1).f = ((StringBuilder)localObject2).toString();
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" compress()");
        Logger.a(localObject1, ((StringBuilder)localObject2).toString(), HardCodeUtil.a(2131708179));
        return true;
      }
      Object localObject1 = a();
      if (localObject1 == null)
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" largerSide is null");
        Logger.b(localObject1, "compress()", ((StringBuilder)localObject2).toString());
        return false;
      }
      int j = localObject1[0];
      i = localObject1[1];
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" destPath is empty");
        Logger.b(localObject1, "compress()", ((StringBuilder)localObject2).toString());
        return false;
      }
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" destPath exist. return true");
        Logger.b(localObject1, "compress()", ((StringBuilder)localObject2).toString());
        return true;
      }
      localObject1 = new BitmapFactory.Options();
      if (!Utils.a((BitmapFactory.Options)localObject1, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, i, j))
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" calculateInSampleSize fail");
        Logger.b(localObject1, "compress()", ((StringBuilder)localObject2).toString());
        return false;
      }
      try
      {
        localObject2 = BaseImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, (BitmapFactory.Options)localObject1);
        if (localObject2 == null)
        {
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" bm == null, maybe is broken");
          Logger.b(localObject1, "compress()", ((StringBuilder)localObject2).toString());
          return false;
        }
        m = ((Bitmap)localObject2).getWidth();
        n = ((Bitmap)localObject2).getHeight();
        localObject3 = new Matrix();
        if (m > n) {
          i = m;
        } else {
          i = n;
        }
        float f = 1.0F;
        if (i > j)
        {
          f = j / (i * 1.0F);
          i = 1;
        }
        else
        {
          i = 0;
        }
        int i1 = BaseImageUtil.c(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c);
        j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d)
        {
          j = k;
          if (i1 != 0)
          {
            j = k;
            if (i1 % 90 == 0)
            {
              ((Matrix)localObject3).postRotate(i1, m >> 1, n >> 1);
              j = 1;
            }
          }
        }
        if (i != 0) {
          ((Matrix)localObject3).postScale(f, f);
        }
        if (j == 0)
        {
          localObject1 = localObject2;
          if (i == 0) {
            break label803;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        int m;
        int n;
        Object localObject3;
        label696:
        boolean bool;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        localOutOfMemoryError1.printStackTrace();
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(" decodeFile oom, execute commonCompress()");
        Logger.b(str, "compress()", localStringBuilder1.toString());
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
        return c();
      }
    }
    try
    {
      localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, m, n, (Matrix)localObject3, true);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label751;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label696;
    }
    localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(" scale or rotate createBitmap NullPointerException");
    Logger.b(localObject1, "compress()", ((StringBuilder)localObject3).toString());
    localObject1 = localObject2;
    break label803;
    label751:
    localObject1 = this.jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(" scale or rotate createBitmap OutOfMemoryError");
    Logger.b(localObject1, "compress()", ((StringBuilder)localObject3).toString());
    localObject1 = localObject2;
    label803:
    bool = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, (Bitmap)localObject1, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    if (!JpegExifReader.isCrashJpeg(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)) {
      try
      {
        if (BaseImageUtil.a(new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c), new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e), true)) {
          break label956;
        }
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", "Failed to save exif");
      }
      catch (Throwable localThrowable)
      {
        localObject3 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("cannot read exif, ");
        localStringBuilder2.append(localThrowable.getMessage());
        Logger.b(localObject3, "compress()", localStringBuilder2.toString());
      }
    } else {
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", "crash jpeg, skip saveExif");
    }
    label956:
    if (localObject1 != null) {
      ((Bitmap)localObject1).recycle();
    }
    return bool;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeNormal
 * JD-Core Version:    0.7.0.1
 */