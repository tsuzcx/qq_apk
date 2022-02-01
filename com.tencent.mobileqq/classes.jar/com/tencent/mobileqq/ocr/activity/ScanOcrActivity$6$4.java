package com.tencent.mobileqq.ocr.activity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.view.MaskView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ScanOcrActivity$6$4
  implements Runnable
{
  ScanOcrActivity$6$4(ScanOcrActivity.6 param6, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (new File(this.a).exists()))
    {
      long l = System.currentTimeMillis() - ScanOcrActivity.k(this.b.a);
      if (this.b.a.k == 1)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(new File(this.a), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).downloadImediatly();
        this.b.a.j.setPreviewDrawable((Drawable)localObject);
        ScanOcrActivity.a(this.b.a, this.a, true);
        return;
      }
      if (l > 900L)
      {
        ScanOcrActivity.a(this.b.a, this.a, false);
        return;
      }
      ScanOcrActivity.l(this.b.a).postDelayed(new ScanOcrActivity.6.4.1(this), 900L - l);
      return;
    }
    ScanOcrActivity.a(this.b.a, false);
    QLog.d("Q.ocr.ScanOcrActivity", 1, "onTakePicFinish failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.activity.ScanOcrActivity.6.4
 * JD-Core Version:    0.7.0.1
 */