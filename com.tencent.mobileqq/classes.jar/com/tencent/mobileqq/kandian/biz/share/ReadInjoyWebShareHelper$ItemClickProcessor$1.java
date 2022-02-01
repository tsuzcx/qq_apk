package com.tencent.mobileqq.kandian.biz.share;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class ReadInjoyWebShareHelper$ItemClickProcessor$1
  implements ITroopMemberApiClientApi.Callback
{
  ReadInjoyWebShareHelper$ItemClickProcessor$1(ReadInjoyWebShareHelper.ItemClickProcessor paramItemClickProcessor, ActionItem paramActionItem) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess");
    ReadInjoyWebShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ItemClickProcessor.a, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareActionItem.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.ItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */