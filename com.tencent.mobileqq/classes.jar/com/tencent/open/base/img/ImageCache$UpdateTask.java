package com.tencent.open.base.img;

import bexd;
import bfel;
import bfhb;
import bfhd;
import bfhg;
import bfif;
import bfig;
import bfih;
import bfii;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bfig a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bfig parambfig)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bfig = parambfig;
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
      bfii localbfii;
      try
      {
        if (((!bfel.a()) || (!bfhb.b(bexd.a().a()))) && (this.jdField_a_of_type_Bfig != null)) {
          this.jdField_a_of_type_Bfig.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bfel.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bfhd.a(this.jdField_c_of_type_JavaLangString);
        bfhg.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bfhd.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bfig != null))
        {
          this.jdField_a_of_type_Bfig.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bfig = null;
        }
        localbfii = ImageCache.jdField_a_of_type_Bfif.a(this.jdField_a_of_type_JavaLangString);
        if (localbfii == null)
        {
          bfhg.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bfii();
          ((bfii)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bfii)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bfii)localObject1).jdField_c_of_type_Long = 0L;
          ((bfii)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bfih.a((bfii)localObject1)) {
            break;
          }
          bfhg.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bfif.a((bfii)localObject1);
          if (this.jdField_a_of_type_Bfig == null) {
            return;
          }
          this.jdField_a_of_type_Bfig.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bfel.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bfhd.a(((bfii)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbfii.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bfig != null)
        {
          bfhg.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbfii.jdField_c_of_type_Long = 0L;
          localObject1 = localbfii;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bfhg.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbfii;
      if (l > localbfii.jdField_b_of_type_Long)
      {
        localObject2 = localbfii;
        if (l < localbfii.jdField_a_of_type_Long + localbfii.jdField_b_of_type_Long)
        {
          bfhg.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbfii.jdField_a_of_type_Long + localbfii.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bfhg.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bfig != null) {
      this.jdField_a_of_type_Bfig.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */