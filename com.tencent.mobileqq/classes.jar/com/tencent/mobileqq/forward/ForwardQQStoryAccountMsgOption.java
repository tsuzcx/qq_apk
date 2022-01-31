package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardQQStoryAccountMsgOption
  extends ForwardPluginShareStructMsgOption
{
  public ForwardQQStoryAccountMsgOption(Intent paramIntent)
  {
    super(paramIntent);
    this.e = true;
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && (localRecentUser.type != 1020) && (localRecentUser.type != 1008) && (localRecentUser.type != 1005) && ((localRecentUser.type != 1006) || (a(ForwardAbility.ForwardAbilityType.h))) && (localRecentUser.type != 1009) && (localRecentUser.type != 1021) && (localRecentUser.type != 1001) && (localRecentUser.type != 10002) && (localRecentUser.type != 10004) && (localRecentUser.type != 1022) && (localRecentUser.type != 1029) && (localRecentUser.type != 7000) && (localRecentUser.type != 6004) && (localRecentUser.type != 1025) && (localRecentUser.type != 1024) && (localRecentUser.type != 9501) && ((localRecentUser.type != 1) || (!a(localRecentUser.uin))) && ((localRecentUser.type != 0) || (!CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, localRecentUser.type))) && (((localRecentUser.type != 1004) && (localRecentUser.type != 1000)) || (this.b))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void m()
  {
    w();
    super.m();
  }
  
  public void w()
  {
    Object localObject1 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
    if ((localObject1 == null) || (TextUtils.isEmpty(((AbsStructMsg)localObject1).mMsg_A_ActionData))) {}
    for (;;)
    {
      return;
      Object localObject2 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, ((AbsStructMsg)localObject1).mMsg_A_ActionData);
      if (localObject2 == null) {
        continue;
      }
      localObject1 = ((JumpAction)localObject2).a("usertype");
      localObject2 = ((JumpAction)localObject2).a("unionid");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        continue;
      }
      try
      {
        i = Integer.parseInt((String)localObject1);
        StoryReportor.a("share_uin", "qq_suc", TroopUtils.b(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype")), i, new String[] { localObject2 });
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.shareAccount", 2, "shareToQQ success userType:" + i + ",userUnionId:" + (String)localObject2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQQStoryAccountMsgOption
 * JD-Core Version:    0.7.0.1
 */