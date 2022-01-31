package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import aqnb;
import aqnc;
import auad;
import audm;
import axrn;
import bbno;
import bbnq;
import bbns;
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
      Object localObject2 = (aqnb)localIterator.next();
      if (OcrImageTextView.a(this.this$0).getWidth() != this.jdField_a_of_type_Int) {
        ((aqnb)localObject2).a(OcrImageTextView.a(this.this$0).getWidth() / this.jdField_a_of_type_Int);
      }
      audm localaudm = new audm((aqnb)localObject2);
      int i = ((aqnb)localObject2).b();
      int j = ((aqnb)localObject2).c();
      localaudm.b = ((int)Math.ceil(i * OcrImageTextView.a(this.this$0)));
      localaudm.jdField_c_of_type_Int = ((int)Math.ceil(j * OcrImageTextView.b(this.this$0)));
      if (localaudm.jdField_c_of_type_Boolean) {}
      for (Object localObject1 = auad.a(OcrImageTextView.a(this.this$0), ((aqnc)((aqnb)localObject2).a.get(3)).jdField_a_of_type_Int, ((aqnc)((aqnb)localObject2).a.get(3)).b, i, j, localaudm.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0));; localObject1 = auad.a(OcrImageTextView.a(this.this$0), ((aqnc)((aqnb)localObject2).a.get(0)).jdField_a_of_type_Int, ((aqnc)((aqnb)localObject2).a.get(0)).b, i, j, localaudm.jdField_a_of_type_Int, OcrImageTextView.a(this.this$0), OcrImageTextView.b(this.this$0)))
      {
        if (localObject1 != null) {
          break label360;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_succ_flag", "0");
        ((HashMap)localObject1).put("param_md5", this.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject1).put("param_text", localaudm.jdField_a_of_type_JavaLangString);
        axrn.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject1, null);
        break;
      }
      label360:
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("param_succ_flag", "1");
      ((HashMap)localObject3).put("param_md5", this.jdField_a_of_type_JavaLangString);
      ((HashMap)localObject3).put("param_text", localaudm.jdField_a_of_type_JavaLangString);
      axrn.a(BaseApplication.getContext()).a(null, "ocr_crop_back_img", true, 0L, 0L, (HashMap)localObject3, null);
      auad.a(localaudm, 64, (Bitmap)localObject1);
      localObject3 = bbno.a(localaudm.jdField_a_of_type_AndroidGraphicsBitmap).a();
      if ((localObject3 != null) && (((bbno)localObject3).a() != null))
      {
        localObject3 = ((bbno)localObject3).a();
        localaudm.m = (0xFF000000 | ((bbns)localObject3).a());
        localaudm.n = (((bbns)localObject3).d() | 0xFF000000);
        localaudm.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "ocrText.backRGB=" + localaudm.m + " ocrText.textColor =" + localaudm.n + " text=" + localaudm.jdField_a_of_type_JavaLangString);
        }
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "1");
        axrn.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      for (;;)
      {
        ((Bitmap)localObject1).recycle();
        if (QLog.isColorLevel()) {
          QLog.d(OcrImageTextView.a(), 2, "setOcrResult srcBitmapWidth=" + i + " srcBitmapHeight=" + j + " showWidth=" + localaudm.b + " showHeight=" + localaudm.jdField_c_of_type_Int + " isDarkColor=" + localaudm.jdField_a_of_type_Boolean + "arc=" + localaudm.jdField_a_of_type_Int + "text=" + localaudm.jdField_a_of_type_JavaLangString);
        }
        localObject1 = ((aqnb)localObject2).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (aqnc)((Iterator)localObject1).next();
          localObject2 = new Point((int)(((aqnc)localObject2).jdField_a_of_type_Int * OcrImageTextView.a(this.this$0)), (int)(((aqnc)localObject2).b * OcrImageTextView.b(this.this$0)));
          localaudm.jdField_a_of_type_JavaUtilList.add(localObject2);
          localaudm.jdField_d_of_type_Int = Math.max(localaudm.jdField_d_of_type_Int, ((Point)localObject2).x);
          localaudm.e = Math.max(localaudm.e, ((Point)localObject2).y);
          localaudm.f = Math.min(localaudm.f, ((Point)localObject2).x);
          localaudm.g = Math.min(localaudm.g, ((Point)localObject2).y);
        }
        localaudm.jdField_a_of_type_Boolean = auad.a(localaudm.jdField_a_of_type_AndroidGraphicsBitmap);
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("param_succ_flag", "0");
        axrn.a(BaseApplication.getContext()).a(null, "ocr_palette_suc", true, 0L, 0L, (HashMap)localObject3, null);
      }
      OcrImageTextView.a(this.this$0).add(localaudm);
    }
    ThreadManager.getUIHandler().post(new OcrImageTextView.1.1(this));
    ThreadManager.getUIHandler().postDelayed(this.this$0.a, 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextView.1
 * JD-Core Version:    0.7.0.1
 */