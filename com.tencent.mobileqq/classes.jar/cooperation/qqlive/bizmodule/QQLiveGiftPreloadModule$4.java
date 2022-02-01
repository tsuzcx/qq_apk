package cooperation.qqlive.bizmodule;

import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.service.IQQGiftListCallback;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQLiveGiftPreloadModule$4
  implements IQQGiftListCallback
{
  QQLiveGiftPreloadModule$4(QQLiveGiftPreloadModule paramQQLiveGiftPreloadModule) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadGiftRes onFailed errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.e("QQLiveGiftPreloadModule", 1, localStringBuilder.toString());
  }
  
  public void a(List<GiftServiceData> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i] = ((GiftServiceData)paramList.get(i)).g;
      i += 1;
    }
    if ((QQLiveGiftPreloadModule.b(this.a) != null) && (!QQLiveGiftPreloadModule.b(this.a).k()))
    {
      QQLiveGiftPreloadModule.b(this.a).g().a(arrayOfInt, QQLiveGiftPreloadModule.c(this.a));
      QQLiveGiftPreloadModule.b(this.a).g().b(arrayOfInt, QQLiveGiftPreloadModule.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqlive.bizmodule.QQLiveGiftPreloadModule.4
 * JD-Core Version:    0.7.0.1
 */