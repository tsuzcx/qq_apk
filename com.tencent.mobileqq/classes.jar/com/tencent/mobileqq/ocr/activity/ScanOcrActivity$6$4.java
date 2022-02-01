package com.tencent.mobileqq.ocr.activity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import ayzz;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ScanOcrActivity$6$4
  implements Runnable
{
  public ScanOcrActivity$6$4(ayzz paramayzz, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (new File(this.jdField_a_of_type_JavaLangString).exists()))
    {
      long l = System.currentTimeMillis() - ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a);
      if (this.jdField_a_of_type_Ayzz.a.jdField_a_of_type_Int == 1)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.jdField_a_of_type_Ayzz.a.jdField_a_of_type_ComTencentMobileqqOcrViewMaskView.setPreviewDrawable((Drawable)localObject);
        ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a, this.jdField_a_of_type_JavaLangString, true);
        return;
      }
      if (l > 900L)
      {
        ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a, this.jdField_a_of_type_JavaLangString, false);
        return;
      }
      ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a).postDelayed(new ScanOcrActivity.6.4.1(this), 900L - l);
      return;
    }
    ScanOcrActivity.a(this.jdField_a_of_type_Ayzz.a, false);
    QLog.d("Q.ocr.ScanOcrActivity", 1, "onTakePicFinish failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.4
 * JD-Core Version:    0.7.0.1
 */