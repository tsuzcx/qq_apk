package com.tencent.mobileqq.forward;

import aeow;
import agfe;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import anvx;
import aupt;
import ausy;
import bben;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ForwardReplyMsgOption
  extends ForwardTextOption
{
  private ChatMessage a;
  
  public ForwardReplyMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public static void a(aupt paramaupt, long paramLong)
  {
    String str2 = paramaupt.c();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      if (!str2.startsWith(anvx.a(2131704259))) {
        break label216;
      }
      str1 = str2.substring(4);
    }
    for (;;)
    {
      str2 = paramaupt.jdField_a_of_type_AndroidOsBundle.getString("uin");
      int i = paramaupt.jdField_a_of_type_AndroidOsBundle.getInt("uintype", 0);
      Intent localIntent = new Intent();
      localIntent.setClass(paramaupt.jdField_a_of_type_AndroidAppActivity, MiniChatActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("uinname", str1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("minaio_scaled_ration", paramaupt.a(0.78F));
      localIntent.putExtra("minaio_height_ration", 0.86F);
      localIntent.putExtra("member_dialog_title", str1);
      localIntent.putExtra("structmsg_uniseq", paramLong);
      localIntent.putExtra("multi_forward_title", anvx.a(2131704251));
      localIntent.putExtra("multi_forward_type", 3);
      localIntent.putExtra("key_mini_from", 4);
      aeow.a(paramaupt.jdField_a_of_type_AndroidAppActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
      return;
      label216:
      str1 = str2;
      if (str2.startsWith(anvx.a(2131704252))) {
        str1 = str2.substring(3);
      }
    }
  }
  
  public View a()
  {
    View localView = super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      localView.findViewById(2131367233).setOnClickListener(new ausy(this));
    }
    return localView;
  }
  
  public String a()
  {
    String str2 = super.a();
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      str1 = anvx.a(2131704253) + str2;
    }
    return str1;
  }
  
  public void a()
  {
    if (o()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("FORWARD_MSG_UNISEQ", -1L);
    if (l == -1L) {
      return bool;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((bben)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(l);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardReplyMsgOption", 2, "ForwardReplyMsgOption preloadData mChatMessage=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return bool;
  }
  
  public boolean b(String paramString1, String paramString2, int paramInt)
  {
    int i = agfe.a().a();
    this.jdField_a_of_type_AndroidOsBundle.putInt("KEY_MSG_FORWARD_ID", i);
    return super.b(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardReplyMsgOption
 * JD-Core Version:    0.7.0.1
 */