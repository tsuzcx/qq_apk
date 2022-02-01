package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$2
  implements Runnable
{
  OcrImageTextView$2(OcrImageTextView paramOcrImageTextView, PicOcrRspResult paramPicOcrRspResult) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    localObject1 = OcrImageTextView.a((OcrImageTextView)localObject1, this.a, OcrImageTextView.a((OcrImageTextView)localObject1));
    Iterator localIterator = ((PicOcrRspResult)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (PicOcrResultBean)localIterator.next();
      OcrImageTextBean localOcrImageTextBean = new OcrImageTextBean((PicOcrResultBean)localObject2);
      localOcrImageTextBean.f = ((PicOcrResultBean)localObject2).a(OcrImageTextView.a(this.this$0));
      localOcrImageTextBean.g = ((PicOcrResultBean)localObject2).b(OcrImageTextView.b(this.this$0));
      localObject2 = OcrImageTextView.a(this.this$0, (PicOcrResultBean)localObject2, localOcrImageTextBean.c, localOcrImageTextBean.jdField_a_of_type_Int, ((PicOcrRspResult)localObject1).jdField_a_of_type_JavaLangString, ((PicOcrRspResult)localObject1).jdField_a_of_type_Int, ((PicOcrRspResult)localObject1).b);
      if (localObject2 != null)
      {
        localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
        localOcrImageTextBean.a(OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));
        OcrImageTextView.a(this.this$0, localOcrImageTextBean);
        OcrImageTextView.a(this.this$0).add(localOcrImageTextBean);
      }
    }
    ThreadManager.getUIHandler().postDelayed(OcrImageTextView.a(this.this$0), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.2
 * JD-Core Version:    0.7.0.1
 */