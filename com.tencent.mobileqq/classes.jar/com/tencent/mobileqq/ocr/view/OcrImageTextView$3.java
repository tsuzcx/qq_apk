package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gallery.picocr.PicOcrRspResult;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$3
  implements Runnable
{
  OcrImageTextView$3(OcrImageTextView paramOcrImageTextView, PicOcrRspResult paramPicOcrRspResult, TranslateResult paramTranslateResult) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    localObject1 = OcrImageTextView.a((OcrImageTextView)localObject1, this.jdField_a_of_type_ComTencentMobileqqGalleryPicocrPicOcrRspResult, OcrImageTextView.a((OcrImageTextView)localObject1));
    localObject1 = OcrImageTextView.a(this.this$0, ((PicOcrRspResult)localObject1).a, this.jdField_a_of_type_ComTencentMobileqqOcrDataTranslateResult);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      OcrImageTextView.b(this.this$0).addAll((Collection)localObject1);
    }
    int i = 0;
    while (i < OcrImageTextView.b(this.this$0).size())
    {
      localObject1 = (OcrImageSectBean)OcrImageTextView.b(this.this$0).get(i);
      Object localObject2 = ((OcrImageSectBean)localObject1).a();
      Rect localRect = ((OcrImageSectBean)localObject1).a();
      OcrImageTextView localOcrImageTextView = this.this$0;
      localObject2 = OcrImageTextView.a(localOcrImageTextView, OcrImageTextView.a(localOcrImageTextView), (Point)localObject2, localRect.width(), localRect.height(), ((OcrImageSectBean)localObject1).jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0), "");
      if (localObject2 != null)
      {
        OCRPerformUtil.a(1, "", "", "ocr_crop_back_img", "");
        ((OcrImageSectBean)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = OcrImageTextView.a(this.this$0, (Bitmap)localObject2);
        ((Bitmap)localObject2).recycle();
        ((OcrImageSectBean)localObject1).a(OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));
        ((OcrImageSectBean)localObject1).a(OcrImageTextView.a(this.this$0));
        OcrImageTextView.a(this.this$0, (OcrImageSectBean)localObject1);
        OcrImageTextView.b(this.this$0).set(i, localObject1);
      }
      i += 1;
    }
    ThreadManager.getUIHandler().postDelayed(OcrImageTextView.a(this.this$0), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.3
 * JD-Core Version:    0.7.0.1
 */