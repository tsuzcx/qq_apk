package com.tencent.mobileqq.forward;

import aael;
import acvh;
import android.content.Intent;
import android.os.Bundle;
import apku;
import avys;
import awbi;
import awdq;
import aweg;
import awey;
import awfo;
import awuw;
import bfhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;

public class ForwardQFavBatchOption$1
  implements Runnable
{
  public ForwardQFavBatchOption$1(apku paramapku, Bundle paramBundle, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, Intent paramIntent) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("qfavType");
    Object localObject2;
    String str1;
    String str2;
    String str3;
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 6: 
    case 8: 
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131626746));
      this.jdField_a_of_type_AndroidOsBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131626744));
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_action", "plugin");
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
      this.jdField_a_of_type_AndroidOsBundle.putInt("req_type", 133);
      localObject1 = awuw.a(this.jdField_a_of_type_AndroidOsBundle);
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = this.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_b_of_type_JavaLangString;
      str3 = this.c;
      int j = this.jdField_a_of_type_Int;
      int k = avys.jdField_a_of_type_Int;
      avys.jdField_a_of_type_Int = k + 1;
      localObject2 = awbi.a((QQAppInterface)localObject2, str1, str2, str3, j, k, (AbsStructMsg)localObject1);
      j = this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
      acvh.a().a(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, j);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, null);
      if (i == 8)
      {
        bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 8, 0, this.jdField_b_of_type_Int);
        return;
      }
      bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 2, 0, this.jdField_b_of_type_Int);
      return;
    case 1: 
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("text");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = awbi.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, (byte)1, (byte)0, (short)0, (String)localObject1);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, null);
      }
      bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 1, 0, this.jdField_b_of_type_Int);
      return;
    case 2: 
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ThreadManager.post(new ForwardQFavBatchOption.1.1(this, (String)localObject1), 8, null, false);
      bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 3, 0, this.jdField_b_of_type_Int);
      return;
    case 7: 
      localObject1 = new SessionInfo();
      ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((SessionInfo)localObject1).d = this.d;
      ((SessionInfo)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((SessionInfo)localObject1).jdField_b_of_type_JavaLangString = this.c;
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("lat");
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("lon");
      str2 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
      str3 = this.jdField_a_of_type_AndroidOsBundle.getString("address");
      aael.a(this.this$0.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject1, (String)localObject2, str1, str3, str2, str3, null, "", "", "", this.this$0.jdField_a_of_type_AndroidOsBundle);
      bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 7, 0, this.jdField_b_of_type_Int);
      return;
    }
    Object localObject1 = aweg.a(0, 2);
    this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    localObject1 = aweg.a(this.jdField_a_of_type_AndroidContentIntent, (awey)localObject1);
    ((awfo)localObject1).c = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin");
    ((awfo)localObject1).d = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    ((awfo)localObject1).jdField_b_of_type_Int = this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    ((awfo)localObject1).jdField_a_of_type_Int = 2;
    ((awfo)localObject1).i = true;
    new awdq(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((awfo)localObject1);
    bfhz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 5, 0, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.1
 * JD-Core Version:    0.7.0.1
 */