package com.tencent.mobileqq.extendfriend.utils;

import android.os.Bundle;
import asfu;
import asml;
import com.tencent.mobileqq.app.QQAppInterface;

public class ExtendFriendSendMsgHelper$2
  implements Runnable
{
  public ExtendFriendSendMsgHelper$2(asml paramasml, int paramInt, String paramString) {}
  
  public void run()
  {
    asfu localasfu = (asfu)asml.a(this.this$0).getManager(264);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", this.jdField_a_of_type_Int);
    localasfu.a(this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */