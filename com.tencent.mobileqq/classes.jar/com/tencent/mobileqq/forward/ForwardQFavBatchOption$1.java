package com.tencent.mobileqq.forward;

import acjm;
import afcu;
import android.content.Intent;
import android.os.Bundle;
import asca;
import ayxz;
import azaf;
import azdd;
import azdi;
import azdx;
import azvd;
import bivo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;

public class ForwardQFavBatchOption$1
  implements Runnable
{
  public ForwardQFavBatchOption$1(asca paramasca, Bundle paramBundle, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, Intent paramIntent) {}
  
  public void run()
  {
    int m = this.jdField_a_of_type_AndroidOsBundle.getInt("qfavType");
    int k;
    int i;
    boolean bool;
    Object localObject1;
    int n;
    Object localObject2;
    int j;
    switch (m)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 6: 
    case 8: 
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_icon", BaseApplicationImpl.getContext().getString(2131692425));
      this.jdField_a_of_type_AndroidOsBundle.putString("app_name", BaseApplicationImpl.getContext().getString(2131692423));
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_action", "plugin");
      this.jdField_a_of_type_AndroidOsBundle.putString("struct_share_key_source_action_data", "qqfav://operation/2");
      this.jdField_a_of_type_AndroidOsBundle.putInt("req_type", 133);
      k = 0;
      i = 0;
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("bFriendCard", false);
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("sBizDataList");
      if (m == 6)
      {
        n = this.jdField_a_of_type_AndroidOsBundle.getInt("nLinkType");
        if ((n == 4) || (n == 5))
        {
          localObject2 = new ArkAppMessage();
          ((ArkAppMessage)localObject2).fromAppXml(new String((byte[])localObject1));
          localObject2 = azaf.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, (ArkAppMessage)localObject2);
          afcu.a().a(((MessageForArkApp)localObject2).uniseq, ((MessageForArkApp)localObject2).uniseq, this.jdField_b_of_type_Int);
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, null);
          j = 1;
          k = j;
          j = i;
          i = k;
        }
      }
      break;
    }
    for (;;)
    {
      k = i;
      if (i == 0)
      {
        k = i;
        if (j != 0)
        {
          k = i;
          if (localObject1 != null)
          {
            localObject1 = azvd.a((byte[])localObject1, 0);
            k = i;
            if (localObject1 != null)
            {
              localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              str1 = this.jdField_c_of_type_JavaLangString;
              str2 = this.jdField_a_of_type_JavaLangString;
              str3 = this.jdField_b_of_type_JavaLangString;
              i = this.jdField_a_of_type_Int;
              j = ayxz.jdField_a_of_type_Int;
              ayxz.jdField_a_of_type_Int = j + 1;
              localObject2 = azaf.a((QQAppInterface)localObject2, str1, str2, str3, i, j, (AbsStructMsg)localObject1);
              afcu.a().a(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, this.jdField_b_of_type_Int);
              this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, null);
              k = 1;
            }
          }
        }
      }
      if (k == 0)
      {
        localObject1 = azvd.a(this.jdField_a_of_type_AndroidOsBundle);
        localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str1 = this.jdField_c_of_type_JavaLangString;
        str2 = this.jdField_a_of_type_JavaLangString;
        str3 = this.jdField_b_of_type_JavaLangString;
        i = this.jdField_a_of_type_Int;
        j = ayxz.jdField_a_of_type_Int;
        ayxz.jdField_a_of_type_Int = j + 1;
        localObject2 = azaf.a((QQAppInterface)localObject2, str1, str2, str3, i, j, (AbsStructMsg)localObject1);
        afcu.a().a(((MessageForStructing)localObject2).uniseq, ((AbsStructMsg)localObject1).uniseq, this.jdField_b_of_type_Int);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, null);
      }
      if (m == 8)
      {
        bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 8, 0, this.jdField_c_of_type_Int);
        return;
        if (n != 6)
        {
          j = k;
          if (n != 7) {
            break;
          }
        }
        i = 1;
        j = k;
        break;
        if ((!bool) || (localObject1 == null)) {
          break label1063;
        }
        i = 0;
        j = 1;
        continue;
      }
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 2, 0, this.jdField_c_of_type_Int);
      return;
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("text");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = azaf.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, (byte)1, (byte)0, (short)0, (String)localObject1);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, null);
      }
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 1, 0, this.jdField_c_of_type_Int);
      return;
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ThreadManager.post(new ForwardQFavBatchOption.1.1(this, (String)localObject1), 8, null, false);
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 3, 0, this.jdField_c_of_type_Int);
      return;
      localObject1 = new SessionInfo();
      ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((SessionInfo)localObject1).d = this.d;
      ((SessionInfo)localObject1).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((SessionInfo)localObject1).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("lat");
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("lon");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("title");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("address");
      this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("isArk", 1);
      acjm.a(this.this$0.jdField_a_of_type_AndroidAppActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject1, (String)localObject2, str1, str3, str2, str3, null, "", "", "", this.this$0.jdField_a_of_type_AndroidOsBundle);
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 7, 0, this.jdField_c_of_type_Int);
      return;
      localObject1 = azdd.a(3, 2);
      this.jdField_a_of_type_AndroidContentIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      localObject2 = azdd.a(2, this.jdField_a_of_type_AndroidContentIntent, (azdx)localObject1);
      ((azdi)localObject2).jdField_c_of_type_JavaLangString = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("uin");
      ((azdi)localObject2).d = this.this$0.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
      ((azdi)localObject2).jdField_b_of_type_Int = this.this$0.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
      ((azdi)localObject2).jdField_a_of_type_Int = 2;
      ((azdx)localObject1).a((azdi)localObject2);
      azdd.a((azdx)localObject1, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bivo.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "User_Forward", 5, 0, this.jdField_c_of_type_Int);
      return;
      label1063:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.1
 * JD-Core Version:    0.7.0.1
 */