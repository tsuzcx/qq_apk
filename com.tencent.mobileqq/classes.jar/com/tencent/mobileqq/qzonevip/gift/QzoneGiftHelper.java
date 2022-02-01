package com.tencent.mobileqq.qzonevip.gift;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class QzoneGiftHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  
  public QzoneGiftHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie.d;
  }
  
  public String getTag()
  {
    return "QzoneGiftHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 12 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 12) {
      return;
    }
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      ((QzoneGiftManager)localQQAppInterface.getManager(QQManagerFactory.QZONE_GIFT_MANAGER)).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftHelper
 * JD-Core Version:    0.7.0.1
 */