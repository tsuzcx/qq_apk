package com.tencent.mobileqq.vas.gldrawable;

import android.content.Context;
import android.os.Build.VERSION;
import bhak;
import bhbk;
import bhbm;
import bhbn;
import bhbr;
import java.io.File;
import kotlin.Pair;

public class GLDrawableLoaderImpl$3
  implements Runnable
{
  public GLDrawableLoaderImpl$3(bhbk parambhbk, String paramString, Context paramContext, bhbm parambhbm, bhbr parambhbr) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    File localFile1 = bhbn.a(this.jdField_a_of_type_AndroidContentContext);
    try
    {
      localObject = bhbk.a(this.this$0, (File)localObject, localFile1, "gldrawable.apk");
      if (!"sucess".equals(localObject))
      {
        this.jdField_a_of_type_Bhbm.a("gldrawable_main_init", "error", (String)localObject, -1L);
        if ((bhbn.a()) || (bhbk.a() > 3))
        {
          bool1 = true;
          bhbk.b(bool1);
          if (!bhbn.a()) {
            break label113;
          }
          if (this.jdField_a_of_type_Bhbr != null) {
            this.jdField_a_of_type_Bhbr.b();
          }
        }
        label113:
        while (this.jdField_a_of_type_Bhbr == null)
        {
          return;
          bool1 = false;
          break;
        }
        this.jdField_a_of_type_Bhbr.c();
        return;
      }
      localObject = new File(localFile1, "gldrawable.apk");
      if (bhbk.a(this.this$0)) {
        break label339;
      }
      if (!bhbk.b(this.this$0)) {}
      for (localFile1 = new File(localFile1, "/lib/armeabi-v7a");; localFile1 = new File(localFile1, "/lib/arm64-v8a"))
      {
        label173:
        bhbn.a().a(this.jdField_a_of_type_AndroidContentContext, (File)localObject, localFile1);
        if (!bhbn.a()) {
          bhak.a("gldrawable_error_model", new Pair[] { new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("so", localFile1.getName()) });
        }
        if ((bhbn.a()) || (bhbk.a() > 3)) {
          bool1 = true;
        }
        bhbk.b(bool1);
        if (!bhbn.a()) {
          break label377;
        }
        if (this.jdField_a_of_type_Bhbr == null) {
          break;
        }
        this.jdField_a_of_type_Bhbr.b();
        return;
      }
      if (this.jdField_a_of_type_Bhbr == null) {
        break label337;
      }
    }
    finally
    {
      if (!bhbn.a())
      {
        bool1 = bool2;
        if (bhbk.a() <= 3) {}
      }
      else
      {
        bool1 = true;
      }
      bhbk.b(bool1);
      if (!bhbn.a()) {
        break label394;
      }
    }
    this.jdField_a_of_type_Bhbr.b();
    for (;;)
    {
      label337:
      throw localFile2;
      label339:
      if (!bhbk.b(this.this$0))
      {
        localFile3 = new File(localFile2, "/lib/x86");
        break label173;
      }
      File localFile3 = new File(localFile3, "/lib/x86_64");
      break label173;
      label377:
      if (this.jdField_a_of_type_Bhbr == null) {
        break;
      }
      this.jdField_a_of_type_Bhbr.c();
      return;
      label394:
      if (this.jdField_a_of_type_Bhbr != null) {
        this.jdField_a_of_type_Bhbr.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.3
 * JD-Core Version:    0.7.0.1
 */