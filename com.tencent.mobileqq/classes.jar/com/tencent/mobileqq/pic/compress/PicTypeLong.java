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
    int k = paramCompressInfo.jdField_g_of_type_Int;
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
  
  protected boolean d()
  {
    StringBuilder localStringBuilder1;
    if (this.k == 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Boolean) && (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        localObject = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(HardCodeUtil.a(2131708177));
        ((CompressInfo)localObject).f = localStringBuilder1.toString();
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(" compress()");
        Logger.a(localObject, localStringBuilder1.toString(), HardCodeUtil.a(2131708178));
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(" destPath is empty");
        Logger.b(localObject, "compress()", localStringBuilder1.toString());
        return false;
      }
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(" destPath exist. return true");
        Logger.b(localObject, "compress()", localStringBuilder1.toString());
        return true;
      }
    }
    try
    {
      localObject = BaseImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, null);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder1.append(" bm == null, maybe is broken");
        Logger.b(localObject, "compress()", localStringBuilder1.toString());
        return false;
      }
      boolean bool = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, (Bitmap)localObject, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      if (!JpegExifReader.isCrashJpeg(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)) {
        try
        {
          if (!BaseImageUtil.a(new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c), new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e), true)) {
            Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", "Failed to save exif");
          }
        }
        catch (IOException localIOException)
        {
          String str = this.jdField_a_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
    Object localObject = this.jdField_a_of_type_JavaLangString;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder2.append(" decodeFile oom, execute commonCompress()");
    Logger.b(localObject, "compress()", localStringBuilder2.toString());
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
    return c();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeLong
 * JD-Core Version:    0.7.0.1
 */