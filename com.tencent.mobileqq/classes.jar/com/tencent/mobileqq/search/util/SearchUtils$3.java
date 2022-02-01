package com.tencent.mobileqq.search.util;

import aiog;
import aioi;
import aioz;
import aipe;
import aipg;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import azlo;
import bcnd;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public final class SearchUtils$3
  implements Runnable
{
  public SearchUtils$3(String paramString1, String paramString2, List paramList, String paramString3, Rect paramRect, AppInterface paramAppInterface, bcnd parambcnd) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString);
      if (azlo.a(this.jdField_a_of_type_JavaLangString))
      {
        localObject3 = new aiog(new File(this.jdField_a_of_type_JavaLangString), false, 0.0F);
        localObject2 = aipe.a().a(((aiog)localObject3).getWidth(), ((aiog)localObject3).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
        ((aiog)localObject3).a((aipg)localObject2);
        localObject3 = new aioz();
        ((aioz)localObject3).jdField_a_of_type_Aipg = ((aipg)localObject2);
        ((aioz)localObject3).b = true;
        ((aioz)localObject3).c = this.jdField_a_of_type_JavaLangString;
        ((aioz)localObject3).jdField_a_of_type_Boolean = true;
        ((aioz)localObject3).d = ((String)localObject1);
        ((aioz)localObject3).jdField_a_of_type_Int = 0;
        ((aioz)localObject3).e = ((String)localObject1);
        localObject1 = aioi.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a((aioz)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + (String)localObject1);
        }
        this.jdField_a_of_type_Bcnd.a((String)localObject1);
        return;
      }
      localObject1 = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString).copy(Bitmap.Config.ARGB_8888, true);
      Object localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Object localObject3 = aipe.a().a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      int i = 0;
      while (i < ((aipg)localObject3).jdField_a_of_type_ArrayOfFloat.length)
      {
        float f = ((Rect)localObject2).top + localObject3.jdField_a_of_type_ArrayOfFloat[i];
        if (((aipg)localObject3).b != null) {
          localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((aipg)localObject3).b);
        }
        localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((aipg)localObject3).jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      localObject2 = this.jdField_a_of_type_JavaLangString + "_" + System.currentTimeMillis();
      BitmapUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2);
      this.jdField_a_of_type_Bcnd.a((String)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localException);
      this.jdField_a_of_type_Bcnd.a(null);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localOutOfMemoryError);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.3
 * JD-Core Version:    0.7.0.1
 */