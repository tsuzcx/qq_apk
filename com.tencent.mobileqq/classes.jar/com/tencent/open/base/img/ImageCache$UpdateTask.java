package com.tencent.open.base.img;

import bcxm;
import bdey;
import bdho;
import bdhq;
import bdht;
import bdis;
import bdit;
import bdiu;
import bdiv;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bdit a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bdit parambdit)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bdit = parambdit;
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
      bdiv localbdiv;
      try
      {
        if (((!bdey.a()) || (!bdho.b(bcxm.a().a()))) && (this.jdField_a_of_type_Bdit != null)) {
          this.jdField_a_of_type_Bdit.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bdey.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bdhq.a(this.jdField_c_of_type_JavaLangString);
        bdht.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bdhq.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bdit != null))
        {
          this.jdField_a_of_type_Bdit.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bdit = null;
        }
        localbdiv = ImageCache.jdField_a_of_type_Bdis.a(this.jdField_a_of_type_JavaLangString);
        if (localbdiv == null)
        {
          bdht.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bdiv();
          ((bdiv)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bdiv)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bdiv)localObject1).jdField_c_of_type_Long = 0L;
          ((bdiv)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bdiu.a((bdiv)localObject1)) {
            break;
          }
          bdht.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bdis.a((bdiv)localObject1);
          if (this.jdField_a_of_type_Bdit == null) {
            return;
          }
          this.jdField_a_of_type_Bdit.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bdey.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bdhq.a(((bdiv)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbdiv.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bdit != null)
        {
          bdht.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbdiv.jdField_c_of_type_Long = 0L;
          localObject1 = localbdiv;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bdht.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbdiv;
      if (l > localbdiv.jdField_b_of_type_Long)
      {
        localObject2 = localbdiv;
        if (l < localbdiv.jdField_a_of_type_Long + localbdiv.jdField_b_of_type_Long)
        {
          bdht.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbdiv.jdField_a_of_type_Long + localbdiv.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bdht.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bdit != null) {
      this.jdField_a_of_type_Bdit.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */