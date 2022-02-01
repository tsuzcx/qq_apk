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
      Object localObject1 = MD5Utils.toMD5(this.a);
      boolean bool = BaseImageUtil.c(this.a);
      int i = 0;
      if (bool)
      {
        localObject3 = new GifImageWithText(new File(this.a), false, 0.0F);
        localObject2 = ZhituTextManager.a().a(((GifImageWithText)localObject3).getWidth(), ((GifImageWithText)localObject3).getHeight(), this.b, this.c, this.d, this.e, 1, MD5Utils.toMD5(this.a), 0, Typeface.DEFAULT);
        ((GifImageWithText)localObject3).a((ZhituTextManager.DrawTextParam)localObject2);
        localObject3 = new ZhituPicData();
        ((ZhituPicData)localObject3).d = ((ZhituTextManager.DrawTextParam)localObject2);
        ((ZhituPicData)localObject3).k = true;
        ((ZhituPicData)localObject3).c = this.a;
        ((ZhituPicData)localObject3).e = true;
        ((ZhituPicData)localObject3).f = ((String)localObject1);
        ((ZhituPicData)localObject3).g = 0;
        ((ZhituPicData)localObject3).h = ((String)localObject1);
        localObject1 = ZhituManager.a(this.f).c((ZhituPicData)localObject3);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("generateGiftWithText: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.uniteSearch.SearchUtil", 2, ((StringBuilder)localObject2).toString());
        }
        this.g.a((String)localObject1);
        return;
      }
      localObject1 = BitmapFactory.decodeFile(this.a).copy(Bitmap.Config.ARGB_8888, true);
      localObject2 = new Rect(0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      Object localObject3 = ZhituTextManager.a().a(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), this.b, this.c, this.d, this.e, 1, MD5Utils.toMD5(this.a), 0, Typeface.DEFAULT);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      while (i < ((ZhituTextManager.DrawTextParam)localObject3).a.length)
      {
        float f1 = ((Rect)localObject2).top + localObject3.a[i];
        if (((ZhituTextManager.DrawTextParam)localObject3).d != null) {
          localCanvas.drawText(localObject3.b[i], ((Rect)localObject2).exactCenterX(), f1, ((ZhituTextManager.DrawTextParam)localObject3).d);
        }
        localCanvas.drawText(localObject3.b[i], ((Rect)localObject2).exactCenterX(), f1, ((ZhituTextManager.DrawTextParam)localObject3).c);
        i += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      localObject2 = ((StringBuilder)localObject2).toString();
      BitmapUtils.saveBitmapToFile((Bitmap)localObject1, (String)localObject2);
      this.g.a((String)localObject2);
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
    this.g.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil.2
 * JD-Core Version:    0.7.0.1
 */