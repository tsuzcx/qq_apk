package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRoute;
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
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!Utils.a(localRecentUser.uin)) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    label17:
    do
    {
      do
      {
        do
        {
          break label17;
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
          paramInt = this.jdField_a_of_type_AndroidOsBundle.getInt("apollo.game.invite.from");
          if (paramInt != 4) {
            break;
          }
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_Int = paramBundle.getInt("uintype");
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
          ((SessionInfo)localObject).b = paramBundle.getString("troop_uin");
          paramBundle = new ArkAppMessage();
          paramBundle.appName = "com.tencent.qqpay.b2c_redpacket";
          paramBundle.appView = "redpacket";
          paramBundle.appMinVersion = "1.0.0.1";
          paramBundle.appDesc = HardCodeUtil.a(2131704751);
          paramBundle.promptText = HardCodeUtil.a(2131704753);
          paramBundle.metaList = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.redpacket_info", "");
          ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (SessionInfo)localObject, paramBundle);
        } while (this.jdField_a_of_type_AndroidAppActivity == null);
        paramBundle = new Intent();
        paramBundle.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramBundle);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
        if (paramInt != 2) {
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
      Object localObject = new ApolloGameMsgInfo();
      ((ApolloGameMsgInfo)localObject).actionId = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.actionid");
      ((ApolloGameMsgInfo)localObject).gameId = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameid");
      ((ApolloGameMsgInfo)localObject).gameMode = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.gameMode");
      ((ApolloGameMsgInfo)localObject).roomId = this.jdField_a_of_type_AndroidOsBundle.getLong("forward.apollo.roomid");
      ((ApolloGameMsgInfo)localObject).gameName = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.gamename");
      ((ApolloGameMsgInfo)localObject).actionName = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.actionname");
      ((ApolloGameMsgInfo)localObject).msgType = this.jdField_a_of_type_AndroidOsBundle.getInt("forward.apollo.msgtype");
      ((ApolloGameMsgInfo)localObject).gameExtendJson = this.jdField_a_of_type_AndroidOsBundle.getString("forward.apollo.sharejson");
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
      localSessionInfo.b = paramBundle.getString("troop_uin");
      localSessionInfo.jdField_a_of_type_Int = paramBundle.getInt("uintype");
      ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloGameMsgInfo)localObject, localSessionInfo);
      CmGameMainManager.a(localSessionInfo.jdField_a_of_type_JavaLangString);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_msg_sent", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionTypeByContext(localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 3, new String[] { "" + ((ApolloGameMsgInfo)localObject).gameId });
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
  
  protected void b()
  {
    if (q()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    if (r()) {
      this.jdField_a_of_type_JavaUtilSet.add(b);
    }
    if (p()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardApolloGameMsgOption
 * JD-Core Version:    0.7.0.1
 */