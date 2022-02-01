package com.tencent.mobileqq.magicface.drawable;

import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class PngFrameManager$3$1
  extends DownloadListener
{
  PngFrameManager$3$1(PngFrameManager.3 param3) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【aio preview】");
    }
    synchronized (this.a.this$0)
    {
      if (this.a.this$0.a != null) {
        if (paramDownloadTask.a() != 3)
        {
          this.a.this$0.a.obtainMessage(226, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
        }
        else
        {
          paramDownloadTask = PngGifEngine.a(this.a.jdField_a_of_type_JavaLangString);
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam.a = paramDownloadTask;
          this.a.this$0.a.obtainMessage(227, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$RandomDrawableParam).sendToTarget();
          GlobalImageCache.a.put(this.a.jdField_a_of_type_JavaLangString, paramDownloadTask);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.3.1
 * JD-Core Version:    0.7.0.1
 */