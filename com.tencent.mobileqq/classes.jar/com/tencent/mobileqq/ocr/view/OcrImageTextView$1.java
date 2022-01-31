package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import asfp;
import asfq;
import avrh;
import avuq;
import azmz;
import bdmi;
import bdmk;
import bdmm;
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
  OcrImageTextView$1(OcrImageTextView paramOcrImageTextView, List paramList, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (asfp)localIterator.next();
      avuq localavuq = new avuq((asfp)localObject2);
      int i = ((asfp)localObject2).b();
      int j = ((asfp)localObject2).c();
      localavuq.b = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localavuq.jdField_c_of_type_Int = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (localavuq.jdField_c_of_type_Boolean) {}
      for (Object localObject1 = avrh.a(OcrImageTextView.a(this.this$0), ((asfq)((asfp)localObject2).a.get(3)).jdField_a_of_type_Int, ((asfq)((asfp)localObject2).a.get(3)).b, i, j, localavuq.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));; localObject1 = avrh.a(OcrImageTextView.a(this.this$0), ((asfq)((asfp)localObject2).a.get(0)).jdField_a_of_type_Int, ((asfq)((asfp)localObject2).a.get(0)).b, i, j, localavuq.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0)))
      {
        if (localObject1 != null) {
          break label295;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_succ_flag", "0");
        ((HashMap)localObject1).put("param_md5", this.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_text", localavuq.jdField_a_of_type_JavaLangString);
        azmz.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject1, null);
        break;
      }
      label295:
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("param_succ_flag", "1");
      ((HashMap)localObject3).put("param_md5", this.jdField_a_of_type_JavaLangString);
      ((HashMap)localObject3).put("param_text", localavuq.jdField_a_of_type_JavaLangString);
      azmz.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject3, null);
      avrh.a(localavuq, 64, (Bitmap)localObject1);
      localObject3 = bdmi.a(localavuq.jdField_a_of_type_AndroidGraphicsBitmap).a();
      if ((localObject3 != null) && (((bdmi)localObject3).a() != null))
      {
        localObject3 = ((bdmi)localObject3).a();
        localavuq.m = (0xFF000000 | ((bdmm)localObject3).a());
        localavuq.n = (((bdmm)localObject3).d() | 0xFF000000);
        localavuq.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "ocrText.backRGB=" + localavuq.m + " ocrText.textColor =" + localavuq.n + " text=" + localavuq.jdField_a_of_type_JavaLangString);
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "1");
        azmz.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      for (;;)
      {
        if ((((Bitmap)localObject1).getHeight() != this.jdField_a_of_type_Int) || (((Bitmap)localObject1).getWidth() != this.b)) {
          ((Bitmap)localObject1).recycle();
        }
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "setOcrResult srcBitmapWidth=" + i + " srcBitmapHeight=" + j + " showWidth=" + localavuq.b + " showHeight=" + localavuq.jdField_c_of_type_Int + " isDarkColor=" + localavuq.jdField_a_of_type_Boolean + "arc=" + localavuq.jdField_a_of_type_Int + "text=" + localavuq.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((asfp)localObject2).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (asfq)((Iterator)localObject1).next();
          localObject2 = new Point((int)(((asfq)localObject2).jdField_a_of_type_Int * OcrImageTextView.a(this.this$0)), (int)(((asfq)localObject2).b * OcrImageTextView.b(this.this$0)));
          localavuq.jdField_a_of_type_JavaUtilList.add(localObject2);
          localavuq.jdField_d_of_type_Int = Math.max(localavuq.jdField_d_of_type_Int, ((Point)localObject2).x);
          localavuq.e = Math.max(localavuq.e, ((Point)localObject2).y);
          localavuq.f = Math.min(localavuq.f, ((Point)localObject2).x);
          localavuq.g = Math.min(localavuq.g, ((Point)localObject2).y);
        }
        localavuq.jdField_a_of_type_Boolean = avrh.a(localavuq.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "0");
        azmz.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      if (OcrImageTextView.a(this.this$0) != null) {
        OcrImageTextView.a(this.this$0).add(localavuq);
      }
    }
    if (OcrImageTextView.a(this.this$0) != null)
    {
      ThreadManager.getUIHandler().post(new OcrImageTextView.1.1(this));
      ThreadManager.getUIHandler().postDelayed(this.this$0.a, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.1
 * JD-Core Version:    0.7.0.1
 */