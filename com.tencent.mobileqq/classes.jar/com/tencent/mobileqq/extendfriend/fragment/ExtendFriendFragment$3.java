package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog.OnConfirmListener;

class ExtendFriendFragment$3
  implements FillBirthdayDialog.OnConfirmListener
{
  ExtendFriendFragment$3(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    CardHandler localCardHandler = (CardHandler)ExtendFriendFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localCardHandler != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("birthday", paramInt);
      localCardHandler.a(localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.3
 * JD-Core Version:    0.7.0.1
 */