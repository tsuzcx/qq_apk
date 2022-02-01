package cooperation.qqlive.bizmodule;

import com.tencent.qphone.base.util.QLog;

class QQLiveGiftPreloadModule$3
  implements Runnable
{
  QQLiveGiftPreloadModule$3(QQLiveGiftPreloadModule paramQQLiveGiftPreloadModule) {}
  
  public void run()
  {
    try
    {
      QQLiveGiftPreloadModule.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate preloadGiftRes throw e:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QQLiveGiftPreloadModule", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftPreloadModule.3
 * JD-Core Version:    0.7.0.1
 */