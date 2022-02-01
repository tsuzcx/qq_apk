package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import avav;
import avaw;
import ayvd;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$2
  implements Runnable
{
  OcrImageTextView$2(OcrImageTextView paramOcrImageTextView, avaw paramavaw) {}
  
  public void run()
  {
    avaw localavaw = OcrImageTextView.a(this.this$0, this.a, OcrImageTextView.a(this.this$0));
    Iterator localIterator = localavaw.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (avav)localIterator.next();
      ayvd localayvd = new ayvd((avav)localObject);
      localayvd.f = ((avav)localObject).a(OcrImageTextView.a(this.this$0));
      localayvd.g = ((avav)localObject).b(OcrImageTextView.b(this.this$0));
      localObject = OcrImageTextView.a(this.this$0, (avav)localObject, localayvd.c, localayvd.jdField_a_of_type_Int, localavaw.jdField_a_of_type_JavaLangString, localavaw.jdField_a_of_type_Int, localavaw.b);
      if (localObject != null)
      {
        localayvd.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        localayvd.a(OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));
        OcrImageTextView.a(this.this$0, localayvd);
        OcrImageTextView.a(this.this$0).add(localayvd);
      }
    }
    ThreadManager.getUIHandler().postDelayed(OcrImageTextView.a(this.this$0), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.2
 * JD-Core Version:    0.7.0.1
 */