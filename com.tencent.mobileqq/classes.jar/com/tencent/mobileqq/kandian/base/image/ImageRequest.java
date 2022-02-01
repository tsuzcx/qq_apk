package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap.Config;
import java.net.URL;

public class ImageRequest
{
  public static int g = 2;
  public int a;
  public long a;
  Bitmap.Config a;
  public String a;
  public URL a;
  public volatile boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public int e;
  public long e;
  public int f;
  public long f;
  public long g;
  public long h;
  public long i;
  
  public ImageRequest()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -2;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandian_zimage_image_req_");
    localStringBuilder.append(hashCode());
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ImageRequest)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) {
        return false;
      }
      if (this.jdField_c_of_type_Int != paramObject.jdField_c_of_type_Int) {
        return false;
      }
      URL localURL = this.jdField_a_of_type_JavaNetURL;
      if (localURL != null)
      {
        if (!localURL.equals(paramObject.jdField_a_of_type_JavaNetURL)) {
          return false;
        }
      }
      else if (paramObject.jdField_a_of_type_JavaNetURL != null) {
        return false;
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap$Config == paramObject.jdField_a_of_type_AndroidGraphicsBitmap$Config;
    }
    return false;
  }
  
  public int hashCode()
  {
    URL localURL = this.jdField_a_of_type_JavaNetURL;
    int j;
    if (localURL != null) {
      j = localURL.hashCode();
    } else {
      j = 0;
    }
    return ((j * 31 + this.jdField_a_of_type_Int) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_c_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaNetURL);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("x");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" isPreload:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" isCancel:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" startTime: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" enterSubThreadTime: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" enterThreadPoolTime: ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(" startThreadPoolTime: ");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(" downloadAndWriteFileTime: ");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(" decodeTime: ");
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append(" enterMainThreadTime: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" endTime: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" failCode: ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" errMsg: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.ImageRequest
 * JD-Core Version:    0.7.0.1
 */