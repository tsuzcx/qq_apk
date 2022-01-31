package com.tencent.open.base.img;

import bbtm;
import bcax;
import bcdn;
import bcdp;
import bcds;
import bcer;
import bces;
import bcet;
import bceu;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bces a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bces parambces)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bces = parambces;
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
      bceu localbceu;
      try
      {
        if (((!bcax.a()) || (!bcdn.b(bbtm.a().a()))) && (this.jdField_a_of_type_Bces != null)) {
          this.jdField_a_of_type_Bces.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bcax.d() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bcdp.a(this.jdField_c_of_type_JavaLangString);
        bcds.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bcdp.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bces != null))
        {
          this.jdField_a_of_type_Bces.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bces = null;
        }
        localbceu = ImageCache.jdField_a_of_type_Bcer.a(this.jdField_a_of_type_JavaLangString);
        if (localbceu == null)
        {
          bcds.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bceu();
          ((bceu)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bceu)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bceu)localObject1).jdField_c_of_type_Long = 0L;
          ((bceu)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bcet.a((bceu)localObject1)) {
            break;
          }
          bcds.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bcer.a((bceu)localObject1);
          if (this.jdField_a_of_type_Bces == null) {
            return;
          }
          this.jdField_a_of_type_Bces.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bcax.d() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bcdp.a(((bceu)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbceu.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bces != null)
        {
          bcds.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbceu.jdField_c_of_type_Long = 0L;
          localObject1 = localbceu;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bcds.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbceu;
      if (l > localbceu.jdField_b_of_type_Long)
      {
        localObject2 = localbceu;
        if (l < localbceu.jdField_a_of_type_Long + localbceu.jdField_b_of_type_Long)
        {
          bcds.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbceu.jdField_a_of_type_Long + localbceu.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bcds.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bces != null) {
      this.jdField_a_of_type_Bces.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */