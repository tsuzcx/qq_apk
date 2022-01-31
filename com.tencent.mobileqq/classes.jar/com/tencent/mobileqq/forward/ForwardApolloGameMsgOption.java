package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel.GameMsgInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ForwardApolloGameMsgOption
  extends ForwardBaseOption
{
  public ForwardApolloGameMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  public List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && ((localRecentUser.type == 0) || (localRecentUser.type == 1) || (localRecentUser.type == 3000))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
    if (h()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidOsBundle == null) || (paramBundle == null));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardApolloGameMsgOption", 2, "[buildForwardDialig]extra:" + paramBundle.toString() + "mExtraData:" + this.jdField_a_of_type_AndroidOsBundle.toString());
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("uin", paramBundle.getString("uin"));
        this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", paramBundle.getInt("uintype"));
        this.jdField_a_of_type_AndroidOsBundle.putInt("share_result_key", 0);
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("apollo.game.invite.from") != 2) {
          break;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("uin", paramBundle.getString("uin"));
        ((Bundle)localObject).putInt("uintype", paramBundle.getInt("uintype"));
        ((Bundle)localObject).putString("troop_uin", paramBundle.getString("troop_uin"));
        ((Bundle)localObject).putString("uinname", paramBundle.getString("uinname"));
        ((Bundle)localObject).putBoolean("launchApolloGame", true);
        ((Bundle)localObject).putInt("gameId", this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameid"));
        ((Bundle)localObject).putInt("gameMode", this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameMode"));
        ((Bundle)localObject).putInt("enter", 4);
      } while (this.jdField_a_of_type_AndroidAppActivity == null);
      this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      this.jdField_a_of_type_AndroidContentIntent = AIOUtils.a(this.jdField_a_of_type_AndroidContentIntent, new int[] { 2 });
      this.jdField_a_of_type_AndroidContentIntent.putExtras((Bundle)localObject);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      paramBundle = new Intent();
      paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramBundle);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
      Object localObject = new ApolloPanel.GameMsgInfo();
      ((ApolloPanel.GameMsgInfo)localObject).jdField_f_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.actionid");
      ((ApolloPanel.GameMsgInfo)localObject).jdField_e_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameid");
      ((ApolloPanel.GameMsgInfo)localObject).g = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameMode");
      ((ApolloPanel.GameMsgInfo)localObject).b = this.jdField_a_of_type_AndroidOsBundle.getLong("forward.apollo.roomid");
      ((ApolloPanel.GameMsgInfo)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.gamename");
      ((ApolloPanel.GameMsgInfo)localObject).d = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.actionname");
      ((ApolloPanel.GameMsgInfo)localObject).h = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.msgtype");
      ((ApolloPanel.GameMsgInfo)localObject).jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.sharejson");
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
      localSessionInfo.b = paramBundle.getString("troop_uin");
      localSessionInfo.jdField_a_of_type_Int = paramBundle.getInt("uintype");
      ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloPanel.GameMsgInfo)localObject, localSessionInfo);
      CmGameMainManager.a(localSessionInfo.jdField_a_of_type_JavaLangString);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_msg_sent", ApolloUtil.a(localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 3, new String[] { "" + ((ApolloPanel.GameMsgInfo)localObject).jdField_e_of_type_Int });
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    paramBundle = new Intent();
    paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramBundle);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardApolloGameMsgOption", 2, new Object[] { "[endForwardCallback], isCompleted:", Boolean.valueOf(paramBoolean) });
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("share_result_key", 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardApolloGameMsgOption
 * JD-Core Version:    0.7.0.1
 */