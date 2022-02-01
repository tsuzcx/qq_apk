package com.tencent.mobileqq.kandian.biz.pts.item;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;

class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$2
  implements Runnable
{
  ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$2(ColumnTwoVideoProteusItem.ColumnSubscriptionCallback paramColumnSubscriptionCallback, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("subscribeAction");
    if ((i == 1) && (this.jdField_a_of_type_Int != 0))
    {
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("columnId");
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("columnIconUrl", "");
      RIJPushNotifyManager.Companion.a().showPushNotifyDialog(this.jdField_a_of_type_Int, str, String.valueOf(i), 1);
      return;
    }
    if (i == 2) {
      RIJPushNotifyManager.Companion.a().dismiss(true, "MATCH_ALL_UIN");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.2
 * JD-Core Version:    0.7.0.1
 */