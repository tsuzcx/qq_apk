package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import avaw;
import ayvc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$3
  implements Runnable
{
  OcrImageTextView$3(OcrImageTextView paramOcrImageTextView, avaw paramavaw, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    Object localObject1 = OcrImageTextView.a(this.this$0, this.jdField_a_of_type_Avaw, OcrImageTextView.a(this.this$0));
    localObject1 = OcrImageTextView.a(this.this$0, ((avaw)localObject1).a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      OcrImageTextView.b(this.this$0).addAll((Collection)localObject1);
    }
    int i = 0;
    if (i < OcrImageTextView.b(this.this$0).size())
    {
      localObject1 = (ayvc)OcrImageTextView.b(this.this$0).get(i);
      Object localObject2 = ((ayvc)localObject1).a();
      Rect localRect = ((ayvc)localObject1).a();
      localObject2 = OcrImageTextView.a(this.this$0, OcrImageTextView.a(this.this$0), (Point)localObject2, localRect.width(), localRect.height(), ((ayvc)localObject1).jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));
      if (localObject2 == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((ayvc)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = OcrImageTextView.a(this.this$0, (Bitmap)localObject2);
        ((Bitmap)localObject2).recycle();
        ((ayvc)localObject1).a(OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));
        ((ayvc)localObject1).a(OcrImageTextView.a(this.this$0));
        OcrImageTextView.a(this.this$0, (ayvc)localObject1);
        OcrImageTextView.b(this.this$0).set(i, localObject1);
      }
    }
    ThreadManager.getUIHandler().postDelayed(OcrImageTextView.a(this.this$0), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.3
 * JD-Core Version:    0.7.0.1
 */