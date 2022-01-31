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
    for (;;)
    {
      ImageInfo localImageInfo;
      try
      {
        if (((!Common.a()) || (!APNUtil.b(CommonDataAdapter.a().a()))) && (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)) {
          this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = Common.d() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + FileUtils.a(this.jdField_c_of_type_JavaLangString);
        LogUtility.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + FileUtils.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null))
        {
          this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback = null;
        }
        localImageInfo = ImageCache.jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper.a(this.jdField_a_of_type_JavaLangString);
        if (localImageInfo == null)
        {
          LogUtility.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new ImageInfo();
          ((ImageInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((ImageInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((ImageInfo)localObject1).jdField_c_of_type_Long = 0L;
          ((ImageInfo)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!ImageDownloader.a((ImageInfo)localObject1)) {
            break;
          }
          LogUtility.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_ComTencentOpenBaseImgImageDbHelper.a((ImageInfo)localObject1);
          if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Common.d() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + FileUtils.a(((ImageInfo)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localImageInfo.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null)
        {
          LogUtility.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localImageInfo.jdField_c_of_type_Long = 0L;
          localObject1 = localImageInfo;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        LogUtility.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localImageInfo;
      if (l > localImageInfo.jdField_b_of_type_Long)
      {
        localObject2 = localImageInfo;
        if (l < localImageInfo.jdField_a_of_type_Long + localImageInfo.jdField_b_of_type_Long)
        {
          LogUtility.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localImageInfo.jdField_a_of_type_Long + localImageInfo.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    LogUtility.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback != null) {
      this.jdField_a_of_type_ComTencentOpenBaseImgImageDownCallback.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */