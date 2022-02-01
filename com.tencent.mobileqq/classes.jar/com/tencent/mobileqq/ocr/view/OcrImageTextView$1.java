package com.tencent.mobileqq.ocr.view;

import avip;
import azbk;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$1
  implements Runnable
{
  OcrImageTextView$1(OcrImageTextView paramOcrImageTextView, List paramList, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      avip localavip = (avip)localIterator.next();
      azbk localazbk = new azbk(localavip);
      int i = localavip.b();
      int j = localavip.c();
      localazbk.b = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localazbk.c = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (OcrImageTextView.a(this.this$0, localavip, localazbk, i, j, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b))
      {
        OcrImageTextView.a(this.this$0, localazbk);
        OcrImageTextView.a(this.this$0, localavip, localazbk);
      }
    }
    if (OcrImageTextView.a(this.this$0) != null)
    {
      ThreadManager.getUIHandler().post(new OcrImageTextView.1.1(this));
      ThreadManager.getUIHandler().postDelayed(this.this$0.a, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.1
 * JD-Core Version:    0.7.0.1
 */