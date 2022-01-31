package com.tencent.open.base.img;

import bcyb;
import bdfn;
import bdid;
import bdif;
import bdii;
import bdjh;
import bdji;
import bdjj;
import bdjk;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bdji a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bdji parambdji)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bdji = parambdji;
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
      bdjk localbdjk;
      try
      {
        if (((!bdfn.a()) || (!bdid.b(bcyb.a().a()))) && (this.jdField_a_of_type_Bdji != null)) {
          this.jdField_a_of_type_Bdji.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bdfn.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bdif.a(this.jdField_c_of_type_JavaLangString);
        bdii.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bdif.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bdji != null))
        {
          this.jdField_a_of_type_Bdji.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bdji = null;
        }
        localbdjk = ImageCache.jdField_a_of_type_Bdjh.a(this.jdField_a_of_type_JavaLangString);
        if (localbdjk == null)
        {
          bdii.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bdjk();
          ((bdjk)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bdjk)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bdjk)localObject1).jdField_c_of_type_Long = 0L;
          ((bdjk)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bdjj.a((bdjk)localObject1)) {
            break;
          }
          bdii.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bdjh.a((bdjk)localObject1);
          if (this.jdField_a_of_type_Bdji == null) {
            return;
          }
          this.jdField_a_of_type_Bdji.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bdfn.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bdif.a(((bdjk)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbdjk.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bdji != null)
        {
          bdii.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbdjk.jdField_c_of_type_Long = 0L;
          localObject1 = localbdjk;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bdii.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbdjk;
      if (l > localbdjk.jdField_b_of_type_Long)
      {
        localObject2 = localbdjk;
        if (l < localbdjk.jdField_a_of_type_Long + localbdjk.jdField_b_of_type_Long)
        {
          bdii.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbdjk.jdField_a_of_type_Long + localbdjk.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bdii.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bdji != null) {
      this.jdField_a_of_type_Bdji.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */