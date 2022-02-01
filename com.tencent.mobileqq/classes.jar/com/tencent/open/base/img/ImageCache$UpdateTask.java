package com.tencent.open.base.img;

import bjjo;
import bjrc;
import bjts;
import bjtu;
import bjtx;
import bjuw;
import bjux;
import bjuy;
import bjuz;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bjux a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bjux parambjux)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bjux = parambjux;
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
      bjuz localbjuz;
      try
      {
        if (((!bjrc.a()) || (!bjts.b(bjjo.a().a()))) && (this.jdField_a_of_type_Bjux != null)) {
          this.jdField_a_of_type_Bjux.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bjrc.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bjtu.a(this.jdField_c_of_type_JavaLangString);
        bjtx.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bjtu.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bjux != null))
        {
          this.jdField_a_of_type_Bjux.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bjux = null;
        }
        localbjuz = ImageCache.jdField_a_of_type_Bjuw.a(this.jdField_a_of_type_JavaLangString);
        if (localbjuz == null)
        {
          bjtx.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bjuz();
          ((bjuz)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bjuz)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bjuz)localObject1).jdField_c_of_type_Long = 0L;
          ((bjuz)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bjuy.a((bjuz)localObject1)) {
            break;
          }
          bjtx.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bjuw.a((bjuz)localObject1);
          if (this.jdField_a_of_type_Bjux == null) {
            return;
          }
          this.jdField_a_of_type_Bjux.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bjrc.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bjtu.a(((bjuz)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbjuz.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bjux != null)
        {
          bjtx.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbjuz.jdField_c_of_type_Long = 0L;
          localObject1 = localbjuz;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bjtx.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbjuz;
      if (l > localbjuz.jdField_b_of_type_Long)
      {
        localObject2 = localbjuz;
        if (l < localbjuz.jdField_a_of_type_Long + localbjuz.jdField_b_of_type_Long)
        {
          bjtx.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbjuz.jdField_a_of_type_Long + localbjuz.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bjtx.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bjux != null) {
      this.jdField_a_of_type_Bjux.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */