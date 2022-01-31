package com.tencent.open.base.img;

import bfbm;
import bfiu;
import bflk;
import bflm;
import bflp;
import bfmo;
import bfmp;
import bfmq;
import bfmr;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bfmp a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bfmp parambfmp)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bfmp = parambfmp;
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
      bfmr localbfmr;
      try
      {
        if (((!bfiu.a()) || (!bflk.b(bfbm.a().a()))) && (this.jdField_a_of_type_Bfmp != null)) {
          this.jdField_a_of_type_Bfmp.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bfiu.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bflm.a(this.jdField_c_of_type_JavaLangString);
        bflp.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bflm.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bfmp != null))
        {
          this.jdField_a_of_type_Bfmp.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bfmp = null;
        }
        localbfmr = ImageCache.jdField_a_of_type_Bfmo.a(this.jdField_a_of_type_JavaLangString);
        if (localbfmr == null)
        {
          bflp.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bfmr();
          ((bfmr)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bfmr)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bfmr)localObject1).jdField_c_of_type_Long = 0L;
          ((bfmr)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bfmq.a((bfmr)localObject1)) {
            break;
          }
          bflp.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bfmo.a((bfmr)localObject1);
          if (this.jdField_a_of_type_Bfmp == null) {
            return;
          }
          this.jdField_a_of_type_Bfmp.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bfiu.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bflm.a(((bfmr)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbfmr.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bfmp != null)
        {
          bflp.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbfmr.jdField_c_of_type_Long = 0L;
          localObject1 = localbfmr;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bflp.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbfmr;
      if (l > localbfmr.jdField_b_of_type_Long)
      {
        localObject2 = localbfmr;
        if (l < localbfmr.jdField_a_of_type_Long + localbfmr.jdField_b_of_type_Long)
        {
          bflp.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbfmr.jdField_a_of_type_Long + localbfmr.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bflp.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bfmp != null) {
      this.jdField_a_of_type_Bfmp.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */