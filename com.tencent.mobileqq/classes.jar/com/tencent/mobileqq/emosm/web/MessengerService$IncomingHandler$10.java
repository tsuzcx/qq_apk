package com.tencent.mobileqq.emosm.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import aply;
import bdhy;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Map;

public class MessengerService$IncomingHandler$10
  implements Runnable
{
  public MessengerService$IncomingHandler$10(aply paramaply, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bitmap localBitmap = bdhy.a(this.jdField_a_of_type_JavaLangString, this.b, null, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    Bundle localBundle = new Bundle();
    if (localBitmap != null)
    {
      Object localObject = new HashMap();
      ((Map)localObject).put("starHomeUrl", this.c);
      ((Map)localObject).put("nickname", this.d);
      ((Map)localObject).put("starId", this.b);
      localObject = bdhy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sid", (Map)localObject);
      bdhy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject, this.d, localBitmap);
      localBundle.putInt("ret", 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      localBundle.putInt("ret", -4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.10
 * JD-Core Version:    0.7.0.1
 */