package com.tencent.mobileqq.kandian.base.view;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

final class ReadInJoyLottieDrawable$5
  extends DownloadListener
{
  ReadInJoyLottieDrawable$5(long paramLong, String paramString, File paramFile1, File paramFile2, WeakReference paramWeakReference) {}
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append(this.jdField_a_of_type_Long);
      paramDownloadTask.append(" download lottie resource fail!");
      QLog.e("ReadInJoyLottieDrawable", 1, paramDownloadTask.toString());
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask != null) && (paramDownloadTask.a().getLong("bgLottieResId") == this.jdField_a_of_type_Long) && (paramDownloadTask.a == 0))
    {
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("download success ");
        paramDownloadTask.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("ReadInJoyLottieDrawable", 1, paramDownloadTask.toString());
      }
      ThreadManager.excute(new ReadInJoyLottieDrawable.5.1(this), 64, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.5
 * JD-Core Version:    0.7.0.1
 */