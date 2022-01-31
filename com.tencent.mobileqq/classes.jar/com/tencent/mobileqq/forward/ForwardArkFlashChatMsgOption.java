package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import java.util.Set;

public class ForwardArkFlashChatMsgOption
  extends ForwardBaseOption
{
  public ForwardArkFlashChatMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_app_desc");
      }
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  protected boolean b()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localSessionInfo.b = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_flashchat_rawcontent");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    ArkFlashChatMessage localArkFlashChatMessage = new ArkFlashChatMessage();
    localArkFlashChatMessage.fromAppXml(str);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, localArkFlashChatMessage);
    return true;
  }
  
  protected boolean c()
  {
    b();
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkFlashChatMsgOption
 * JD-Core Version:    0.7.0.1
 */