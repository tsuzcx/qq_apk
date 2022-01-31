package com.tencent.mobileqq.emosm.web;

import akji;
import akqb;
import android.os.Bundle;
import aply;
import com.tencent.mobileqq.app.QQAppInterface;

public class MessengerService$IncomingHandler$5
  implements Runnable
{
  public MessengerService$IncomingHandler$5(aply paramaply, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, MessengerService paramMessengerService) {}
  
  public void run()
  {
    boolean bool = ((akji)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(this.jdField_a_of_type_AndroidOsBundle.getString("url"));
    Bundle localBundle = new Bundle();
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      localBundle.putInt("result", i);
      this.b.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.5
 * JD-Core Version:    0.7.0.1
 */