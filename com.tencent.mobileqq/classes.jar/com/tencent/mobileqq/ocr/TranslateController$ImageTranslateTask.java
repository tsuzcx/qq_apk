package com.tencent.mobileqq.ocr;

import amvj;
import amxh;
import amxi;
import amxk;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import arof;
import avsv;
import avsw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TranslateController$ImageTranslateTask
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  
  public TranslateController$ImageTranslateTask(TranslateController paramTranslateController, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private String a()
  {
    return String.format("%s_%s_%05d", new Object[] { TranslateController.a(this.this$0).getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void run()
  {
    if (!arof.a(this.jdField_a_of_type_JavaLangString))
    {
      QLog.d("TranslateController", 1, "picTranslate, file is not exists: " + this.jdField_a_of_type_JavaLangString);
      localObject1 = new TranslateResult(2);
      ((TranslateResult)localObject1).jdField_b_of_type_Int = 1001;
      TranslateController.a(this.this$0, false, this.jdField_a_of_type_JavaLangString, (TranslateResult)localObject1);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = avsv.a(this.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (!avsv.a(this.jdField_a_of_type_JavaLangString, (String)localObject2))
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        QLog.d("TranslateController", 1, "compress image failed!");
      }
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
    int i = ((BitmapFactory.Options)localObject2).outHeight;
    int j = ((BitmapFactory.Options)localObject2).outWidth;
    localObject2 = new amxh();
    ((amxh)localObject2).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((amxh)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
    ((amxh)localObject2).jdField_a_of_type_Int = 0;
    ((amxh)localObject2).jdField_b_of_type_Int = i;
    ((amxh)localObject2).jdField_c_of_type_Int = j;
    amxk localamxk = new amxk();
    localamxk.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localamxk.c = this.c;
    localamxk.jdField_a_of_type_JavaLangString = a();
    amxi localamxi = new amxi();
    localamxi.jdField_a_of_type_JavaLangString = a();
    localamxi.jdField_a_of_type_Amxh = ((amxh)localObject2);
    localamxi.jdField_a_of_type_Amxk = localamxk;
    localamxi.jdField_b_of_type_Int = 900000000;
    localamxi.jdField_a_of_type_Int = 900000000;
    localamxi.jdField_a_of_type_Long = 8192L;
    localamxi.jdField_c_of_type_Int = 0;
    localamxi.jdField_b_of_type_JavaLangString = String.valueOf(TranslateController.a(this.this$0).getAppid());
    localamxi.jdField_b_of_type_Long = Long.parseLong(TranslateController.a(this.this$0).getCurrentAccountUin());
    localamxi.jdField_c_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new File((String)localObject1);
      QLog.d("TranslateController", 2, String.format("picTranslate, fileInfo:%s, fileSize:%s", new Object[] { ((amxh)localObject2).toString(), ((File)localObject1).length() / 1024L + "KB" }));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateController", 2, "picTranslate reqInfo:" + localamxi);
    }
    if (TranslateController.a(this.this$0) == null) {
      TranslateController.a(this.this$0, new amvj(TranslateController.a(this.this$0)));
    }
    TranslateController.a(this.this$0).a(localamxi, new avsw(this, localamxi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask
 * JD-Core Version:    0.7.0.1
 */