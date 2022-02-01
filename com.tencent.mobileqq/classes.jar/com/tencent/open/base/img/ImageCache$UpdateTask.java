package com.tencent.open.base.img;

import bhpc;
import bhwr;
import bhzh;
import bhzj;
import bhzm;
import biai;
import biaj;
import biak;
import bial;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected biaj a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, biaj parambiaj)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Biaj = parambiaj;
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
      bial localbial;
      try
      {
        if (((!bhwr.a()) || (!bhzh.b(bhpc.a().a()))) && (this.jdField_a_of_type_Biaj != null)) {
          this.jdField_a_of_type_Biaj.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bhwr.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bhzj.a(this.jdField_c_of_type_JavaLangString);
        bhzm.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bhzj.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Biaj != null))
        {
          this.jdField_a_of_type_Biaj.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Biaj = null;
        }
        localbial = ImageCache.jdField_a_of_type_Biai.a(this.jdField_a_of_type_JavaLangString);
        if (localbial == null)
        {
          bhzm.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bial();
          ((bial)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bial)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bial)localObject1).jdField_c_of_type_Long = 0L;
          ((bial)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!biak.a((bial)localObject1)) {
            break;
          }
          bhzm.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Biai.a((bial)localObject1);
          if (this.jdField_a_of_type_Biaj == null) {
            return;
          }
          this.jdField_a_of_type_Biaj.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bhwr.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bhzj.a(((bial)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbial.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Biaj != null)
        {
          bhzm.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbial.jdField_c_of_type_Long = 0L;
          localObject1 = localbial;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bhzm.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbial;
      if (l > localbial.jdField_b_of_type_Long)
      {
        localObject2 = localbial;
        if (l < localbial.jdField_a_of_type_Long + localbial.jdField_b_of_type_Long)
        {
          bhzm.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbial.jdField_a_of_type_Long + localbial.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bhzm.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Biaj != null) {
      this.jdField_a_of_type_Biaj.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */