package com.tencent.mobileqq.vas.gldrawable;

import android.content.Context;
import android.os.Build.VERSION;
import bhlo;
import biaq;
import bibs;
import bibu;
import bibw;
import bicb;
import java.io.File;
import kotlin.Pair;

public class GLDrawableLoaderImpl$3
  implements Runnable
{
  public GLDrawableLoaderImpl$3(bibs parambibs, String paramString, Context paramContext, bibu parambibu, bicb parambicb) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    File localFile1 = bibw.a(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localObject = bibs.a(this.this$0, (File)localObject, localFile1, "gldrawable.apk");
      if (!"sucess".equals(localObject))
      {
        this.jdField_a_of_type_Bibu.a("gldrawable_main_init", "error", (String)localObject, -1L);
        if ((bibw.a()) || (bibs.a() > 3))
        {
          bool1 = true;
          bibs.b(bool1);
          if (!bibw.a()) {
            break label113;
          }
          if (this.jdField_a_of_type_Bicb != null) {
            this.jdField_a_of_type_Bicb.b();
          }
        }
        label113:
        while (this.jdField_a_of_type_Bicb == null)
        {
          return;
          bool1 = false;
          break;
        }
        this.jdField_a_of_type_Bicb.c();
        return;
      }
      localObject = new File(localFile1, "gldrawable.apk");
      if (bibs.a(this.this$0)) {
        break label354;
      }
      if (!bibs.b(this.this$0)) {}
      for (localFile1 = new File(localFile1, "/lib/armeabi-v7a");; localFile1 = new File(localFile1, "/lib/arm64-v8a"))
      {
        label173:
        bibw.a().a(this.jdField_a_of_type_AndroidContentContext, (File)localObject, localFile1);
        if (!bibw.a()) {
          biaq.a("gldrawable_error_model", new Pair[] { new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("so", localFile1.getName()) });
        }
        if (bhlo.g()) {
          bibw.a().a(20);
        }
        if ((bibw.a()) || (bibs.a() > 3)) {
          bool1 = true;
        }
        bibs.b(bool1);
        if (!bibw.a()) {
          break label392;
        }
        if (this.jdField_a_of_type_Bicb == null) {
          break;
        }
        this.jdField_a_of_type_Bicb.b();
        return;
      }
      if (this.jdField_a_of_type_Bicb == null) {
        break label352;
      }
    }
    finally
    {
      if (!bibw.a())
      {
        bool1 = bool2;
        if (bibs.a() <= 3) {}
      }
      else
      {
        bool1 = true;
      }
      bibs.b(bool1);
      if (!bibw.a()) {
        break label409;
      }
    }
    this.jdField_a_of_type_Bicb.b();
    for (;;)
    {
      label352:
      throw localFile2;
      label354:
      if (!bibs.b(this.this$0))
      {
        localFile3 = new File(localFile2, "/lib/x86");
        break label173;
      }
      File localFile3 = new File(localFile3, "/lib/x86_64");
      break label173;
      label392:
      if (this.jdField_a_of_type_Bicb == null) {
        break;
      }
      this.jdField_a_of_type_Bicb.c();
      return;
      label409:
      if (this.jdField_a_of_type_Bicb != null) {
        this.jdField_a_of_type_Bicb.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.3
 * JD-Core Version:    0.7.0.1
 */