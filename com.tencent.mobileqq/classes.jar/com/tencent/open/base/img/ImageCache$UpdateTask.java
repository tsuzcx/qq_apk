package com.tencent.open.base.img;

import biip;
import biqd;
import bist;
import bisv;
import bisy;
import bitx;
import bity;
import bitz;
import biua;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bity a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bity parambity)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bity = parambity;
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
      biua localbiua;
      try
      {
        if (((!biqd.a()) || (!bist.b(biip.a().a()))) && (this.jdField_a_of_type_Bity != null)) {
          this.jdField_a_of_type_Bity.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = biqd.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bisv.a(this.jdField_c_of_type_JavaLangString);
        bisy.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bisv.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bity != null))
        {
          this.jdField_a_of_type_Bity.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bity = null;
        }
        localbiua = ImageCache.jdField_a_of_type_Bitx.a(this.jdField_a_of_type_JavaLangString);
        if (localbiua == null)
        {
          bisy.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new biua();
          ((biua)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((biua)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((biua)localObject1).jdField_c_of_type_Long = 0L;
          ((biua)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bitz.a((biua)localObject1)) {
            break;
          }
          bisy.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bitx.a((biua)localObject1);
          if (this.jdField_a_of_type_Bity == null) {
            return;
          }
          this.jdField_a_of_type_Bity.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, biqd.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bisv.a(((biua)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbiua.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bity != null)
        {
          bisy.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbiua.jdField_c_of_type_Long = 0L;
          localObject1 = localbiua;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bisy.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbiua;
      if (l > localbiua.jdField_b_of_type_Long)
      {
        localObject2 = localbiua;
        if (l < localbiua.jdField_a_of_type_Long + localbiua.jdField_b_of_type_Long)
        {
          bisy.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbiua.jdField_a_of_type_Long + localbiua.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bisy.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bity != null) {
      this.jdField_a_of_type_Bity.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */