package com.tencent.open.base.img;

import bizw;
import bjht;
import bjkj;
import bjkl;
import bjko;
import bjlk;
import bjll;
import bjlm;
import bjln;
import java.io.File;

public class ImageCache$UpdateTask
  implements Runnable
{
  protected bjll a;
  protected String a;
  protected String b;
  protected String c;
  
  public ImageCache$UpdateTask(String paramString1, String paramString2, String paramString3, bjll parambjll)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Bjll = parambjll;
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
      bjln localbjln;
      try
      {
        if (((!bjht.a()) || (!bjkj.b(bizw.a().a()))) && (this.jdField_a_of_type_Bjll != null)) {
          this.jdField_a_of_type_Bjll.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        }
        Object localObject1 = bjht.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bjkl.a(this.jdField_c_of_type_JavaLangString);
        bjko.c("downloadImage", "imgFilePath = " + (String)localObject1 + " | " + this.jdField_b_of_type_JavaLangString + " | " + bjkl.a(this.jdField_c_of_type_JavaLangString) + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
        if ((new File((String)localObject1).exists()) && (this.jdField_a_of_type_Bjll != null))
        {
          this.jdField_a_of_type_Bjll.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Bjll = null;
        }
        localbjln = ImageCache.jdField_a_of_type_Bjlk.a(this.jdField_a_of_type_JavaLangString);
        if (localbjln == null)
        {
          bjko.a("ImageCache", "image not in db. key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          localObject1 = new bjln();
          ((bjln)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          ((bjln)localObject1).jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          ((bjln)localObject1).jdField_c_of_type_Long = 0L;
          ((bjln)localObject1).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
          if (!bjlm.a((bjln)localObject1)) {
            break;
          }
          bjko.d("ImageCache", "download image succ. " + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          ImageCache.jdField_a_of_type_Bjlk.a((bjln)localObject1);
          if (this.jdField_a_of_type_Bjll == null) {
            return;
          }
          this.jdField_a_of_type_Bjll.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, bjht.e() + ImageCache.jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + File.separator + bjkl.a(((bjln)localObject1).jdField_b_of_type_JavaLangString));
          return;
        }
        localbjln.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_a_of_type_Bjll != null)
        {
          bjko.a("ImageCache", "file is deleted." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
          localbjln.jdField_c_of_type_Long = 0L;
          localObject1 = localbjln;
          continue;
        }
        l = System.currentTimeMillis();
      }
      catch (Exception localException)
      {
        bjko.b("ImageCache", "Download img warning", localException);
        return;
      }
      long l;
      Object localObject2 = localbjln;
      if (l > localbjln.jdField_b_of_type_Long)
      {
        localObject2 = localbjln;
        if (l < localbjln.jdField_a_of_type_Long + localbjln.jdField_b_of_type_Long)
        {
          bjko.a("ImageCache", "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + localbjln.jdField_a_of_type_Long + localbjln.jdField_b_of_type_Long + " key=" + this.jdField_a_of_type_JavaLangString + " url=" + this.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    bjko.d("ImageCache", "download failed." + this.jdField_c_of_type_JavaLangString + " key=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bjll != null) {
      this.jdField_a_of_type_Bjll.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.img.ImageCache.UpdateTask
 * JD-Core Version:    0.7.0.1
 */