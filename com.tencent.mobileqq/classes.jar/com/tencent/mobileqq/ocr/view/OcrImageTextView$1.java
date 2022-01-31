package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import aqmz;
import aqna;
import auab;
import audk;
import axrl;
import bbna;
import bbnc;
import bbne;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class OcrImageTextView$1
  implements Runnable
{
  OcrImageTextView$1(OcrImageTextView paramOcrImageTextView, List paramList, int paramInt, String paramString) {}
  
  public void run()
  {
    if (OcrImageTextView.a(this.this$0) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(OcrImageTextView.a(), 2, "initBlurBitmap srcBitMap==null");
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (aqmz)localIterator.next();
      if (OcrImageTextView.a(this.this$0).getWidth() != this.jdField_a_of_type_Int) {
        ((aqmz)localObject2).a(OcrImageTextView.a(this.this$0).getWidth() / this.jdField_a_of_type_Int);
      }
      audk localaudk = new audk((aqmz)localObject2);
      int i = ((aqmz)localObject2).b();
      int j = ((aqmz)localObject2).c();
      localaudk.b = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localaudk.jdField_c_of_type_Int = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (localaudk.jdField_c_of_type_Boolean) {}
      for (Object localObject1 = auab.a(OcrImageTextView.a(this.this$0), ((aqna)((aqmz)localObject2).a.get(3)).jdField_a_of_type_Int, ((aqna)((aqmz)localObject2).a.get(3)).b, i, j, localaudk.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));; localObject1 = auab.a(OcrImageTextView.a(this.this$0), ((aqna)((aqmz)localObject2).a.get(0)).jdField_a_of_type_Int, ((aqna)((aqmz)localObject2).a.get(0)).b, i, j, localaudk.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0)))
      {
        if (localObject1 != null) {
          break label360;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_succ_flag", "0");
        ((HashMap)localObject1).put("param_md5", this.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_text", localaudk.jdField_a_of_type_JavaLangString);
        axrl.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject1, null);
        break;
      }
      label360:
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("param_succ_flag", "1");
      ((HashMap)localObject3).put("param_md5", this.jdField_a_of_type_JavaLangString);
      ((HashMap)localObject3).put("param_text", localaudk.jdField_a_of_type_JavaLangString);
      axrl.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject3, null);
      auab.a(localaudk, 64, (Bitmap)localObject1);
      localObject3 = bbna.a(localaudk.jdField_a_of_type_AndroidGraphicsBitmap).a();
      if ((localObject3 != null) && (((bbna)localObject3).a() != null))
      {
        localObject3 = ((bbna)localObject3).a();
        localaudk.m = (0xFF000000 | ((bbne)localObject3).a());
        localaudk.n = (((bbne)localObject3).d() | 0xFF000000);
        localaudk.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "ocrText.backRGB=" + localaudk.m + " ocrText.textColor =" + localaudk.n + " text=" + localaudk.jdField_a_of_type_JavaLangString);
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "1");
        axrl.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      for (;;)
      {
        ((Bitmap)localObject1).recycle();
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "setOcrResult srcBitmapWidth=" + i + " srcBitmapHeight=" + j + " showWidth=" + localaudk.b + " showHeight=" + localaudk.jdField_c_of_type_Int + " isDarkColor=" + localaudk.jdField_a_of_type_Boolean + "arc=" + localaudk.jdField_a_of_type_Int + "text=" + localaudk.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((aqmz)localObject2).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (aqna)((Iterator)localObject1).next();
          localObject2 = new Point((int)(((aqna)localObject2).jdField_a_of_type_Int * OcrImageTextView.a(this.this$0)), (int)(((aqna)localObject2).b * OcrImageTextView.b(this.this$0)));
          localaudk.jdField_a_of_type_JavaUtilList.add(localObject2);
          localaudk.jdField_d_of_type_Int = Math.max(localaudk.jdField_d_of_type_Int, ((Point)localObject2).x);
          localaudk.e = Math.max(localaudk.e, ((Point)localObject2).y);
          localaudk.f = Math.min(localaudk.f, ((Point)localObject2).x);
          localaudk.g = Math.min(localaudk.g, ((Point)localObject2).y);
        }
        localaudk.jdField_a_of_type_Boolean = auab.a(localaudk.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "0");
        axrl.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      OcrImageTextView.a(this.this$0).add(localaudk);
    }
    ThreadManager.getUIHandler().post(new OcrImageTextView.1.1(this));
    ThreadManager.getUIHandler().postDelayed(this.this$0.a, 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.1
 * JD-Core Version:    0.7.0.1
 */