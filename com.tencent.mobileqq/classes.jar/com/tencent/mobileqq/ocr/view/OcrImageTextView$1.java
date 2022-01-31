package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import asjy;
import asjz;
import avvq;
import avyz;
import azri;
import bdqr;
import bdqt;
import bdqv;
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
      Object localObject2 = (asjy)localIterator.next();
      avyz localavyz = new avyz((asjy)localObject2);
      int i = ((asjy)localObject2).b();
      int j = ((asjy)localObject2).c();
      localavyz.b = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localavyz.jdField_c_of_type_Int = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (localavyz.jdField_c_of_type_Boolean) {}
      for (Object localObject1 = avvq.a(OcrImageTextView.a(this.this$0), ((asjz)((asjy)localObject2).a.get(3)).jdField_a_of_type_Int, ((asjz)((asjy)localObject2).a.get(3)).b, i, j, localavyz.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));; localObject1 = avvq.a(OcrImageTextView.a(this.this$0), ((asjz)((asjy)localObject2).a.get(0)).jdField_a_of_type_Int, ((asjz)((asjy)localObject2).a.get(0)).b, i, j, localavyz.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0)))
      {
        if (localObject1 != null) {
          break label295;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_succ_flag", "0");
        ((HashMap)localObject1).put("param_md5", this.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_text", localavyz.jdField_a_of_type_JavaLangString);
        azri.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject1, null);
        break;
      }
      label295:
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("param_succ_flag", "1");
      ((HashMap)localObject3).put("param_md5", this.jdField_a_of_type_JavaLangString);
      ((HashMap)localObject3).put("param_text", localavyz.jdField_a_of_type_JavaLangString);
      azri.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject3, null);
      avvq.a(localavyz, 64, (Bitmap)localObject1);
      localObject3 = bdqr.a(localavyz.jdField_a_of_type_AndroidGraphicsBitmap).a();
      if ((localObject3 != null) && (((bdqr)localObject3).a() != null))
      {
        localObject3 = ((bdqr)localObject3).a();
        localavyz.m = (0xFF000000 | ((bdqv)localObject3).a());
        localavyz.n = (((bdqv)localObject3).d() | 0xFF000000);
        localavyz.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "ocrText.backRGB=" + localavyz.m + " ocrText.textColor =" + localavyz.n + " text=" + localavyz.jdField_a_of_type_JavaLangString);
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "1");
        azri.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      for (;;)
      {
        if ((((Bitmap)localObject1).getHeight() != this.jdField_a_of_type_Int) || (((Bitmap)localObject1).getWidth() != this.b)) {
          ((Bitmap)localObject1).recycle();
        }
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "setOcrResult srcBitmapWidth=" + i + " srcBitmapHeight=" + j + " showWidth=" + localavyz.b + " showHeight=" + localavyz.jdField_c_of_type_Int + " isDarkColor=" + localavyz.jdField_a_of_type_Boolean + "arc=" + localavyz.jdField_a_of_type_Int + "text=" + localavyz.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((asjy)localObject2).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (asjz)((Iterator)localObject1).next();
          localObject2 = new Point((int)(((asjz)localObject2).jdField_a_of_type_Int * OcrImageTextView.a(this.this$0)), (int)(((asjz)localObject2).b * OcrImageTextView.b(this.this$0)));
          localavyz.jdField_a_of_type_JavaUtilList.add(localObject2);
          localavyz.jdField_d_of_type_Int = Math.max(localavyz.jdField_d_of_type_Int, ((Point)localObject2).x);
          localavyz.e = Math.max(localavyz.e, ((Point)localObject2).y);
          localavyz.f = Math.min(localavyz.f, ((Point)localObject2).x);
          localavyz.g = Math.min(localavyz.g, ((Point)localObject2).y);
        }
        localavyz.jdField_a_of_type_Boolean = avvq.a(localavyz.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "0");
        azri.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      if (OcrImageTextView.a(this.this$0) != null) {
        OcrImageTextView.a(this.this$0).add(localavyz);
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