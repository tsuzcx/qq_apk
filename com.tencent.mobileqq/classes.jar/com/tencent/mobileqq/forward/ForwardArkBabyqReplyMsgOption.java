package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardArkBabyqReplyMsgOption
  extends ForwardBaseOption
{
  public ForwardArkBabyqReplyMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward_text");
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 10004) && (localRecentUser.type != 1029) && (localRecentUser.type != 7000) && (localRecentUser.type != 6004) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 9501) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type)))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
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
  
  public boolean a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_ark_babyq_reply_rawcontent"))
    {
      b();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    return true;
  }
  
  protected boolean b()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    localSessionInfo.b = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("forward_ark_babyq_reply_rawcontent");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    MessageForArkBabyqReply localMessageForArkBabyqReply = new MessageForArkBabyqReply();
    localMessageForArkBabyqReply.fromAppXml(str);
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, localMessageForArkBabyqReply, true, false);
    return true;
  }
  
  protected boolean c()
  {
    b();
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardArkBabyqReplyMsgOption
 * JD-Core Version:    0.7.0.1
 */