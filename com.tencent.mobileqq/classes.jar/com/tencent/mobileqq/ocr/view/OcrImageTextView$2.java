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
    PicOcrRspResult localPicOcrRspResult = OcrImageTextView.a(this.this$0, this.a, OcrImageTextView.a(this.this$0));
    Iterator localIterator = localPicOcrRspResult.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (PicOcrResultBean)localIterator.next();
      OcrImageTextBean localOcrImageTextBean = new OcrImageTextBean((PicOcrResultBean)localObject);
      localOcrImageTextBean.f = ((PicOcrResultBean)localObject).a(OcrImageTextView.a(this.this$0));
      localOcrImageTextBean.g = ((PicOcrResultBean)localObject).b(OcrImageTextView.b(this.this$0));
      localObject = OcrImageTextView.a(this.this$0, (PicOcrResultBean)localObject, localOcrImageTextBean.c, localOcrImageTextBean.jdField_a_of_type_Int, localPicOcrRspResult.jdField_a_of_type_JavaLangString, localPicOcrRspResult.jdField_a_of_type_Int, localPicOcrRspResult.b);
      if (localObject != null)
      {
        localOcrImageTextBean.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        localOcrImageTextBean.a(OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));
        OcrImageTextView.a(this.this$0, localOcrImageTextBean);
        OcrImageTextView.a(this.this$0).add(localOcrImageTextBean);
      }
    }
    ThreadManager.getUIHandler().postDelayed(OcrImageTextView.a(this.this$0), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.2
 * JD-Core Version:    0.7.0.1
 */