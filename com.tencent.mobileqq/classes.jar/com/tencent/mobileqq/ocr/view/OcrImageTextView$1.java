package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import auqp;
import auqq;
import ayfi;
import ayir;
import bctj;
import bgvr;
import bgvt;
import bgvv;
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
      Object localObject2 = (auqp)localIterator.next();
      ayir localayir = new ayir((auqp)localObject2);
      int i = ((auqp)localObject2).b();
      int j = ((auqp)localObject2).c();
      localayir.b = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localayir.jdField_c_of_type_Int = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (localayir.jdField_c_of_type_Boolean) {}
      for (Object localObject1 = ayfi.a(OcrImageTextView.a(this.this$0), ((auqq)((auqp)localObject2).a.get(3)).jdField_a_of_type_Int, ((auqq)((auqp)localObject2).a.get(3)).b, i, j, localayir.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));; localObject1 = ayfi.a(OcrImageTextView.a(this.this$0), ((auqq)((auqp)localObject2).a.get(0)).jdField_a_of_type_Int, ((auqq)((auqp)localObject2).a.get(0)).b, i, j, localayir.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0)))
      {
        if (localObject1 != null) {
          break label295;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_succ_flag", "0");
        ((HashMap)localObject1).put("param_md5", this.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_text", localayir.jdField_a_of_type_JavaLangString);
        bctj.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject1, null);
        break;
      }
      label295:
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("param_succ_flag", "1");
      ((HashMap)localObject3).put("param_md5", this.jdField_a_of_type_JavaLangString);
      ((HashMap)localObject3).put("param_text", localayir.jdField_a_of_type_JavaLangString);
      bctj.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject3, null);
      ayfi.a(localayir, 64, (Bitmap)localObject1);
      localObject3 = bgvr.a(localayir.jdField_a_of_type_AndroidGraphicsBitmap).a();
      if ((localObject3 != null) && (((bgvr)localObject3).a() != null))
      {
        localObject3 = ((bgvr)localObject3).a();
        localayir.m = (0xFF000000 | ((bgvv)localObject3).a());
        localayir.n = (((bgvv)localObject3).d() | 0xFF000000);
        localayir.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "ocrText.backRGB=" + localayir.m + " ocrText.textColor =" + localayir.n + " text=" + localayir.jdField_a_of_type_JavaLangString);
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "1");
        bctj.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      for (;;)
      {
        if ((((Bitmap)localObject1).getHeight() != this.jdField_a_of_type_Int) || (((Bitmap)localObject1).getWidth() != this.b)) {
          ((Bitmap)localObject1).recycle();
        }
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "setOcrResult srcBitmapWidth=" + i + " srcBitmapHeight=" + j + " showWidth=" + localayir.b + " showHeight=" + localayir.jdField_c_of_type_Int + " isDarkColor=" + localayir.jdField_a_of_type_Boolean + "arc=" + localayir.jdField_a_of_type_Int + "text=" + localayir.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((auqp)localObject2).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (auqq)((Iterator)localObject1).next();
          localObject2 = new Point((int)(((auqq)localObject2).jdField_a_of_type_Int * OcrImageTextView.a(this.this$0)), (int)(((auqq)localObject2).b * OcrImageTextView.b(this.this$0)));
          localayir.jdField_a_of_type_JavaUtilList.add(localObject2);
          localayir.jdField_d_of_type_Int = Math.max(localayir.jdField_d_of_type_Int, ((Point)localObject2).x);
          localayir.e = Math.max(localayir.e, ((Point)localObject2).y);
          localayir.f = Math.min(localayir.f, ((Point)localObject2).x);
          localayir.g = Math.min(localayir.g, ((Point)localObject2).y);
        }
        localayir.jdField_a_of_type_Boolean = ayfi.a(localayir.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "0");
        bctj.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      if (OcrImageTextView.a(this.this$0) != null) {
        OcrImageTextView.a(this.this$0).add(localayir);
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