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
  protected ImageDownCallback a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, ImageDownCallback paramImageDownCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback = paramImageDownCallback;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof UpdateTask)) {
      return false;
    }
    return this.jdField_a_of_type_JavaLangString.equals(((UpdateTask)paramObject).jdField_a_of_type_JavaLangString);
  }
  
  public void run()
  {
    try
    {
      if (((!Common.a()) || (!APNUtil.b(CommonDataAdapter.a().a()))) && (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)) {
        this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Common.e());
      ((StringBuilder)localObject1).append(ImageCache.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(FileUtils.a(this.jdField_c_of_type_JavaLangString));
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("imgFilePath = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" | ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" | ");
      ((StringBuilder)localObject2).append(FileUtils.a(this.jdField_c_of_type_JavaLangString));
      ((StringBuilder)localObject2).append(" key=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" url=");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      LogUtility.c("downloadImage", ((StringBuilder)localObject2).toString());
      if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null))
      {
        this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
        this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback = null;
      }
      localObject2 = ImageCache.jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper.a(this.jdField_a_of_type_JavaLangString);
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("image not in db. key=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(" url=");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
        LogUtility.a("ImageCache", ((StringBuilder)localObject1).toString());
        localObject1 = new ImageInfo();
        ((ImageInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        ((ImageInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        ((ImageInfo)localObject1).jdField_c_of_type_Long = 0L;
        ((ImageInfo)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      else
      {
        ((ImageInfo)localObject2).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("file is deleted.");
          ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(" key=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          LogUtility.a("ImageCache", ((StringBuilder)localObject1).toString());
          ((ImageInfo)localObject2).jdField_c_of_type_Long = 0L;
          localObject1 = localObject2;
        }
        else
        {
          long l = System.currentTimeMillis();
          localObject1 = localObject2;
          if (l > ((ImageInfo)localObject2).jdField_b_of_type_Long)
          {
            localObject1 = localObject2;
            if (l < ((ImageInfo)localObject2).jdField_a_of_type_Long + ((ImageInfo)localObject2).jdField_b_of_type_Long)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("currenttime=");
              ((StringBuilder)localObject1).append(System.currentTimeMillis());
              ((StringBuilder)localObject1).append("\nmaxage+updatetime=");
              ((StringBuilder)localObject1).append(((ImageInfo)localObject2).jdField_a_of_type_Long);
              ((StringBuilder)localObject1).append(((ImageInfo)localObject2).jdField_b_of_type_Long);
              ((StringBuilder)localObject1).append(" key=");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject1).append(" url=");
              ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
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
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(" key=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        LogUtility.d("ImageCache", ((StringBuilder)localObject2).toString());
        ImageCache.jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper.a((ImageInfo)localObject1);
        if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback;
          String str1 = this.jdField_a_of_type_JavaLangString;
          String str2 = this.jdField_b_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(Common.e());
          localStringBuilder.append(ImageCache.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(FileUtils.a(((ImageInfo)localObject1).jdField_b_of_type_JavaLangString));
          ((ImageDownCallback)localObject2).a(str1, str2, localStringBuilder.toString());
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("download failed.");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(" key=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        LogUtility.d("ImageCache", ((StringBuilder)localObject1).toString());
        if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)
        {
          this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */