package cooperation.qqlive.bizmodule;

import com.tencent.mobileqq.qqgift.callback.IQQGiftResourceDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class QQLiveGiftPreloadModule$1
  implements IQQGiftResourceDownloadCallback
{
  QQLiveGiftPreloadModule$1(QQLiveGiftPreloadModule paramQQLiveGiftPreloadModule) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadGiftRes onAllFinished success/total:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt1);
    QLog.e("QQLiveGiftPreloadModule", 1, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadGiftRes onSingleFinished id:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", msg:");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveGiftPreloadModule", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftPreloadModule.1
 * JD-Core Version:    0.7.0.1
 */