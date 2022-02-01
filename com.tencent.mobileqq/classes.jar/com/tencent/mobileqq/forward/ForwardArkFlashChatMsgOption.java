package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.Iterator;
import java.util.List;
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
  
  protected boolean a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.b = paramString2;
    paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_flashchat_rawcontent");
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new ArkFlashChatMessage();
    paramString2.fromAppXml(paramString1);
    paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString2, paramInt);
    return true;
  }
  
  protected void b()
  {
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
  }
  
  protected boolean c()
  {
    if (j())
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.uin, localResultRecord.getUinType(), localResultRecord.groupUin);
      }
      return super.c();
    }
    k_();
    return super.c();
  }
  
  protected boolean k_()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    return a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), i, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkFlashChatMsgOption
 * JD-Core Version:    0.7.0.1
 */