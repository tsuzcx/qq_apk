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
    this.a = paramBaseChatPie.a;
  }
  
  public String getTag()
  {
    return "QzoneGiftHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 11 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.a == null);
    ((QzoneGiftManager)this.a.getManager(QQManagerFactory.QZONE_GIFT_MANAGER)).onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftHelper
 * JD-Core Version:    0.7.0.1
 */