package common.config.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;

class QzoneConfig$2
  extends ContentObserver
{
  QzoneConfig$2(QzoneConfig paramQzoneConfig, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    ThreadManager.post(new QzoneConfig.2.1(this, paramBoolean), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.config.service.QzoneConfig.2
 * JD-Core Version:    0.7.0.1
 */