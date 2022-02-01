package com.tencent.mobileqq.extendfriend.utils;

import android.os.Bundle;
import aslo;
import assy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class ExtendFriendSendMsgHelper$2
  implements Runnable
{
  public ExtendFriendSendMsgHelper$2(assy paramassy, int paramInt, String paramString) {}
  
  public void run()
  {
    aslo localaslo = (aslo)assy.a(this.this$0).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", this.jdField_a_of_type_Int);
    localaslo.a(this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2
 * JD-Core Version:    0.7.0.1
 */