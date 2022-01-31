package com.tencent.mobileqq.search.util;

import aezj;
import aezl;
import afac;
import afah;
import afaj;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import aupa;
import awwb;
import bdik;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public final class SearchUtils$3
  implements Runnable
{
  public SearchUtils$3(String paramString1, String paramString2, List paramList, String paramString3, Rect paramRect, AppInterface paramAppInterface, awwb paramawwb) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = bdik.d(this.jdField_a_of_type_JavaLangString);
      if (aupa.a(this.jdField_a_of_type_JavaLangString))
      {
        localObject3 = new aezj(new File(this.jdField_a_of_type_JavaLangString), false, 0.0F);
        localObject2 = afah.a().a(((aezj)localObject3).getWidth(), ((aezj)localObject3).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, bdik.d(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
        ((aezj)localObject3).a((afaj)localObject2);
        localObject3 = new afac();
        ((afac)localObject3).jdField_a_of_type_Afaj = ((afaj)localObject2);
        ((afac)localObject3).b = true;
        ((afac)localObject3).c = this.jdField_a_of_type_JavaLangString;
        ((afac)localObject3).jdField_a_of_type_Boolean = true;
        ((afac)localObject3).d = ((String)localObject1);
        ((afac)localObject3).jdField_a_of_type_Int = 0;
        ((afac)localObject3).e = ((String)localObject1);
        localObject1 = aezl.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a((afac)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + (String)localObject1);
        }
        this.jdField_a_of_type_Awwb.a((String)localObject1);
        return;
      }
      localObject1 = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString).copy(Bitmap.Config.ARGB_8888, true);
      Object localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Object localObject3 = afah.a().a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, bdik.d(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      int i = 0;
      while (i < ((afaj)localObject3).jdField_a_of_type_ArrayOfFloat.length)
      {
        float f = ((Rect)localObject2).top + localObject3.jdField_a_of_type_ArrayOfFloat[i];
        if (((afaj)localObject3).b != null) {
          localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((afaj)localObject3).b);
        }
        localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((afaj)localObject3).jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      localObject2 = this.jdField_a_of_type_JavaLangString + "_" + System.currentTimeMillis();
      BitmapUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2);
      this.jdField_a_of_type_Awwb.a((String)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "generateGiftWithText: " + localException);
      this.jdField_a_of_type_Awwb.a(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.3
 * JD-Core Version:    0.7.0.1
 */