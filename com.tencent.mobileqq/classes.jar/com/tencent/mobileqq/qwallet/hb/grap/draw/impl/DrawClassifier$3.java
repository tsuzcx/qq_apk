package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DrawClassifier$3
  implements IPreloadService.OnGetPathListener
{
  DrawClassifier$3(DrawClassifier paramDrawClassifier, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener) {}
  
  private void a()
  {
    DrawClassifier.OnClassifierInitListener localOnClassifierInitListener = this.a;
    if (localOnClassifierInitListener != null) {
      localOnClassifierInitListener.a(false);
    }
  }
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      try
      {
        localObject = new File(paramPathResult.folderPath, "quickDraw.tflite").toString();
        paramPathResult = new File(paramPathResult.folderPath, "classes.txt").toString();
        if ((new File((String)localObject).exists()) && (new File(paramPathResult).exists()))
        {
          DrawClassifier.a(this.b, new DefaultClassifier((String)localObject, paramPathResult));
          paramPathResult = this.a;
          if (paramPathResult != null) {
            paramPathResult.a(true);
          }
          DrawClassifier.a(this.b, true);
          if (QLog.isColorLevel()) {
            QLog.d("DrawClassifier", 2, "init success");
          }
          return;
        }
        QLog.e("DrawClassifier", 1, "init fail file not exist");
        a();
        return;
      }
      catch (Throwable paramPathResult)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("init recog fail:");
          ((StringBuilder)localObject).append(paramPathResult);
          QLog.e("DrawClassifier", 2, ((StringBuilder)localObject).toString());
        }
        paramPathResult.printStackTrace();
        a();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "init download fail");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier.3
 * JD-Core Version:    0.7.0.1
 */