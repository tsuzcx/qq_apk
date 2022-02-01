package com.tencent.mobileqq.forward;

import admh;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aupt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardArkFlashChatMsgOption
  extends aupt
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
  
  protected boolean a(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curType = paramInt;
    localSessionInfo.curFriendUin = paramString1;
    localSessionInfo.troopUin = paramString2;
    paramString1 = this.jdField_a_of_type_AndroidOsBundle.getString("forward_flashchat_rawcontent");
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new ArkFlashChatMessage();
    paramString2.fromAppXml(paramString1);
    paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("KEY_MSG_FORWARD_ID");
    admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramString2, paramInt);
    return true;
  }
  
  public boolean c()
  {
    if (i())
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        a(localResultRecord.uin, localResultRecord.getUinType(), localResultRecord.groupUin);
      }
      return super.c();
    }
    i_();
    return super.c();
  }
  
  protected boolean i_()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    return a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), i, this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkFlashChatMsgOption
 * JD-Core Version:    0.7.0.1
 */