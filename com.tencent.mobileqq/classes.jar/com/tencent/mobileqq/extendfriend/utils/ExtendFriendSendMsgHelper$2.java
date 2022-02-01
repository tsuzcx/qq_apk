package com.tencent.mobileqq.extendfriend.utils;

import android.os.Bundle;
import arhi;
import aros;
import com.tencent.mobileqq.app.QQAppInterface;

public class ExtendFriendSendMsgHelper$2
  implements Runnable
{
  public ExtendFriendSendMsgHelper$2(aros paramaros, int paramInt, String paramString) {}
  
  public void run()
  {
    arhi localarhi = (arhi)aros.a(this.this$0).getManager(264);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", this.jdField_a_of_type_Int);
    localarhi.a(this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */