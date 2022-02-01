package com.tencent.mobileqq.search;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import com.tencent.common.app.AppInterface;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.activity.aio.zhitu.GifImageWithText;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituTextManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituTextManager.DrawTextParam;
import com.tencent.mobileqq.search.util.SearchUtils.GenerateGifWithTextCallback;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

final class SearchUtil$2
  implements Runnable
{
  SearchUtil$2(String paramString1, String paramString2, List paramList, String paramString3, Rect paramRect, AppInterface paramAppInterface, SearchUtils.GenerateGifWithTextCallback paramGenerateGifWithTextCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString);
      boolean bool = BaseImageUtil.b(this.jdField_a_of_type_JavaLangString);
      int i = 0;
      if (bool)
      {
        localObject3 = new GifImageWithText(new File(this.jdField_a_of_type_JavaLangString), false, 0.0F);
        localObject2 = ZhituTextManager.a().a(((GifImageWithText)localObject3).getWidth(), ((GifImageWithText)localObject3).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
        ((GifImageWithText)localObject3).a((ZhituTextManager.DrawTextParam)localObject2);
        localObject3 = new ZhituPicData();
        ((ZhituPicData)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam = ((ZhituTextManager.DrawTextParam)localObject2);
        ((ZhituPicData)localObject3).b = true;
        ((ZhituPicData)localObject3).c = this.jdField_a_of_type_JavaLangString;
        ((ZhituPicData)localObject3).jdField_a_of_type_Boolean = true;
        ((ZhituPicData)localObject3).d = ((String)localObject1);
        ((ZhituPicData)localObject3).jdField_a_of_type_Int = 0;
        ((ZhituPicData)localObject3).e = ((String)localObject1);
        localObject1 = ZhituManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a((ZhituPicData)localObject3);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("generateGiftWithText: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.uniteSearch.SearchUtil", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchUtils$GenerateGifWithTextCallback.a((String)localObject1);
        return;
      }
      localObject1 = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString).copy(Bitmap.Config.ARGB_8888, true);
      localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Object localObject3 = ZhituTextManager.a().a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), this.b, this.jdField_a_of_type_JavaUtilList, this.c, this.jdField_a_of_type_AndroidGraphicsRect, 1, MD5Utils.toMD5(this.jdField_a_of_type_JavaLangString), 0, Typeface.DEFAULT);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      while (i < ((ZhituTextManager.DrawTextParam)localObject3).jdField_a_of_type_ArrayOfFloat.length)
      {
        float f = ((Rect)localObject2).top + localObject3.jdField_a_of_type_ArrayOfFloat[i];
        if (((ZhituTextManager.DrawTextParam)localObject3).b != null) {
          localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((ZhituTextManager.DrawTextParam)localObject3).b);
        }
        localCanvas.drawText(localObject3.jdField_a_of_type_ArrayOfJavaLangString[i], ((Rect)localObject2).exactCenterX(), f, ((ZhituTextManager.DrawTextParam)localObject3).jdField_a_of_type_AndroidGraphicsPaint);
        i += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      localObject2 = ((StringBuilder)localObject2).toString();
      BitmapUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchUtils$GenerateGifWithTextCallback.a((String)localObject2);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("generateGiftWithText: ");
      ((StringBuilder)localObject2).append(localOutOfMemoryError);
      QLog.e("Q.uniteSearch.SearchUtil", 2, ((StringBuilder)localObject2).toString());
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("generateGiftWithText: ");
      ((StringBuilder)localObject2).append(localException);
      QLog.e("Q.uniteSearch.SearchUtil", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSearchUtils$GenerateGifWithTextCallback.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil.2
 * JD-Core Version:    0.7.0.1
 */