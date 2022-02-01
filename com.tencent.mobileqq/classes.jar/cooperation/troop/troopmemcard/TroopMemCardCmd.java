package cooperation.troop.troopmemcard;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.HWTroopMemberCard;
import com.tencent.mobileqq.troop.utils.api.IBizTroopDBUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class TroopMemCardCmd
  extends RemoteCommand
{
  QQAppInterface a;
  
  public TroopMemCardCmd(QQAppInterface paramQQAppInterface)
  {
    super("troop.troopmemcard.get_app_interface_data");
    this.a = paramQQAppInterface;
  }
  
  public Bundle a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramOnInvokeFinishLinstener = paramBundle.getString("troopUin");
    String str2 = paramBundle.getString("memUin");
    paramBundle = this.a.getMessageFacade().a(paramOnInvokeFinishLinstener, 1, 100);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chatmsg:");
    int i;
    if (!TextUtils.isEmpty(str2)) {
      i = 10;
    } else {
      i = 20;
    }
    Iterator localIterator = paramBundle.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (j > i) {
        break;
      }
      if ((localMessageRecord != null) && ((TextUtils.isEmpty(str2)) || (TextUtils.equals(localMessageRecord.senderuin, str2))))
      {
        String str1;
        if ((localMessageRecord instanceof MessageForPic))
        {
          paramOnInvokeFinishLinstener = ((MessageForPic)localMessageRecord).uuid;
          str1 = "2";
        }
        else
        {
          if (((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForLongMsg))) || (localMessageRecord.msgtype != -1000)) {
            continue;
          }
          paramOnInvokeFinishLinstener = localMessageRecord.msg;
          str1 = "1";
        }
        j += 1;
        paramBundle = paramOnInvokeFinishLinstener;
        try
        {
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("\"", "\\\"");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("'", "\\'");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("|", "\\|");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(":", "\\:");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace(";", "\\;");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("[", "\\[");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("]", "\\]");
          paramBundle = paramOnInvokeFinishLinstener;
          paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.replace("=", "\\=");
          paramBundle = paramOnInvokeFinishLinstener;
        }
        catch (Throwable paramOnInvokeFinishLinstener)
        {
          paramOnInvokeFinishLinstener.printStackTrace();
        }
        localStringBuilder.append("[");
        paramOnInvokeFinishLinstener = new StringBuilder();
        paramOnInvokeFinishLinstener.append("uin=");
        paramOnInvokeFinishLinstener.append(localMessageRecord.senderuin);
        localStringBuilder.append(paramOnInvokeFinishLinstener.toString());
        localStringBuilder.append(";");
        paramOnInvokeFinishLinstener = new StringBuilder();
        paramOnInvokeFinishLinstener.append("content=");
        paramOnInvokeFinishLinstener.append(paramBundle);
        localStringBuilder.append(paramOnInvokeFinishLinstener.toString());
        localStringBuilder.append(";");
        paramBundle = new StringBuilder();
        paramBundle.append("type=");
        paramBundle.append(str1);
        localStringBuilder.append(paramBundle.toString());
        localStringBuilder.append("]");
      }
    }
    try
    {
      paramBundle = URLEncoder.encode(localStringBuilder.toString(), "UTF-8");
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      paramBundle = "";
    }
    paramOnInvokeFinishLinstener = new Bundle();
    paramOnInvokeFinishLinstener.putString("msgtoupload", paramBundle);
    return paramOnInvokeFinishLinstener;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        int i = paramBundle.getInt("req_sub_cmd");
        Bundle localBundle = new Bundle();
        boolean bool2 = false;
        Object localObject1;
        boolean bool1;
        Object localObject2;
        Object localObject3;
        switch (i)
        {
        default: 
          paramBundle = localBundle;
          break;
        case 1018: 
          paramBundle = paramBundle.getString("uin");
          localObject1 = MutualMarkDataCenter.a(this.a, paramBundle, false);
          paramBundle = localBundle;
          if (localObject1 != null)
          {
            paramBundle = IntimateUtil.a(this.a.getApp(), ((MutualMarkForDisplayInfo)localObject1).a);
            i = ((MutualMarkForDisplayInfo)localObject1).c;
            localBundle.putString("bind_name", paramBundle);
            localBundle.putInt("bind_icon", i);
            paramBundle = localBundle;
          }
          break;
        case 1017: 
          paramBundle = paramBundle.getString("uin");
          ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(paramBundle, (byte)2);
          localObject1 = this.a.getHandler(ChatActivity.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(16711681, paramBundle));
          }
          localObject1 = this.a.getHandler(ChatSettingActivity.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).sendMessage(((MqqHandler)localObject1).obtainMessage(16711681, paramBundle));
          }
          if (Utils.b(paramBundle)) {
            ReportController.b(this.a, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
          }
          localObject1 = new Intent("ACTION_DELETE_FRIEND");
          ((Intent)localObject1).putExtra("KEY_DELETE_FRIEND_UIN", paramBundle);
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1);
          paramBundle = localBundle;
          break;
        case 1016: 
          localObject1 = paramBundle.getString("uin");
          bool1 = paramBundle.getBoolean("is_gather");
          paramBundle = (FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(localObject1);
          paramBundle.gatherContacts((short)1, (List)localObject2, bool1, true);
          paramBundle = localBundle;
          break;
        case 1015: 
          localObject1 = paramBundle.getString("uin");
          bool1 = paramBundle.getBoolean("do_not_disturb");
          paramBundle = this.a;
          if (!bool1) {
            break label1374;
          }
          l1 = MessageCache.a();
          FriendsStatusUtil.a(paramBundle, (String)localObject1, 0, l1, true, false, null, true);
          paramBundle = localBundle;
          break;
        case 1014: 
          localObject1 = paramBundle.getString("uin");
          localObject2 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
          localObject3 = ((FriendsManager)localObject2).b((String)localObject1);
          paramBundle = localBundle;
          if (localObject3 != null)
          {
            paramBundle = localBundle;
            if (((Friends)localObject3).isFriend())
            {
              paramBundle = ((FriendsManager)localObject2).a((String)localObject1);
              bool1 = bool2;
              if (paramBundle != null)
              {
                bool1 = bool2;
                if (paramBundle.globalSwitch != 0) {
                  bool1 = true;
                }
              }
              localBundle.putBoolean("is_special_care", bool1);
              paramBundle = localBundle;
            }
          }
          break;
        case 1013: 
          paramBundle = paramBundle.getString("troopUin");
          ((ITroopMngHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(paramBundle);
          paramBundle = localBundle;
          break;
        case 1012: 
          paramBundle = paramBundle.getString("troopUin");
          ((ITroopMngHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).b(paramBundle);
          paramBundle = localBundle;
          break;
        case 1011: 
          localObject1 = paramBundle.getString("troopUin");
          localObject2 = paramBundle.getString("memberUin");
          localObject3 = paramBundle.getString("troopNick");
          i = paramBundle.getInt("level");
          String str1 = paramBundle.getString("friendNick");
          String str2 = paramBundle.getString("troopRemark");
          int j = paramBundle.getInt("age");
          int k = paramBundle.getInt("sex");
          int m = paramBundle.getInt("distance");
          l1 = paramBundle.getLong("msgseq");
          long l2 = paramBundle.getLong("gagTimeStamp");
          ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).a((String)localObject1, (String)localObject2, (String)localObject3, i, str1, str2, j, k, m, l1, l2);
          paramBundle = localBundle;
          break;
        case 1010: 
          localObject1 = paramBundle.getString("troopUin");
          paramBundle = paramBundle.getStringArrayList("memberUins");
          ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).b((String)localObject1, (String)paramBundle.get(0));
          paramBundle = localBundle;
          break;
        case 1009: 
          localObject1 = paramBundle.getString("key");
          paramBundle = (ServerConfigManager.ConfigType)paramBundle.getSerializable("type");
          localBundle.putString("result", this.a.getServerConfigValue(paramBundle, (String)localObject1));
          paramBundle = localBundle;
          break;
        case 1008: 
          paramBundle = paramBundle.getString("troopCode");
          localObject1 = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
          this.a.getMessageFacade().a(paramBundle, 1);
          ((TroopManager)localObject1).b(paramBundle);
          ((IBizTroopDBUtilsApi)QRoute.api(IBizTroopDBUtilsApi.class)).removeToopMsgFilter(this.a, paramBundle, this.a.getCurrentAccountUin(), this.a.getApp());
          paramBundle = localBundle;
          break;
        case 1007: 
          localObject1 = paramBundle.getString("troopUin");
          localObject2 = paramBundle.getString("memUin");
          localObject3 = paramBundle.getString("uniqueTitle");
          i = paramBundle.getInt("uniqueTitleExpire");
          ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).a((String)localObject1, (String)localObject2, (String)localObject3, i);
          paramBundle = localBundle;
          break;
        case 1006: 
          localObject1 = paramBundle.getString("troopUin");
          localObject2 = paramBundle.getString("memUin");
          byte b = paramBundle.getByte("flag");
          localBundle.putBoolean("result", ((IBizTroopMemberInfoService)this.a.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveTroopMemberSpearkFlag((String)localObject1, (String)localObject2, b));
          paramBundle = localBundle;
          break;
        case 1005: 
          localObject1 = paramBundle.getString("troopUin");
          localObject2 = paramBundle.getString("memUin");
          paramBundle = (HWTroopMemberCard)paramBundle.getSerializable("card");
          ((IBizTroopMemberInfoService)this.a.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHWTroopMemberCard((String)localObject1, (String)localObject2, paramBundle);
          paramBundle = localBundle;
          break;
        case 1004: 
          localObject1 = paramBundle.getString("troopUin");
          paramBundle = paramBundle.getString("memUin");
          localBundle.putSerializable("card", ((IBizTroopMemberInfoService)this.a.getRuntimeService(IBizTroopMemberInfoService.class, "")).getHWTroopMemberCard((String)localObject1, paramBundle));
          paramBundle = localBundle;
          break;
        case 1003: 
          paramBundle = paramBundle.getString("troopUin");
          localBundle.putSerializable("troopInfo", ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramBundle));
          paramBundle = localBundle;
          break;
        case 1002: 
          paramBundle = (TroopInfo)paramBundle.getSerializable("troopInfo");
          ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramBundle);
          paramBundle = localBundle;
          break;
        case 1001: 
          paramBundle = a(paramBundle, paramOnInvokeFinishLinstener);
        }
        if (paramOnInvokeFinishLinstener != null) {
          paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
        }
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          paramOnInvokeFinishLinstener = new StringBuilder();
          paramOnInvokeFinishLinstener.append("invoke Exception hanppend! ExceptionClass = + ");
          paramOnInvokeFinishLinstener.append(paramBundle.getClass().getName());
          paramOnInvokeFinishLinstener.append("msg = ");
          paramOnInvokeFinishLinstener.append(paramBundle.getMessage());
          QLog.d("TroopMemCardCmd", 2, paramOnInvokeFinishLinstener.toString());
        }
        ReportController.b(this.a, "P_CliOper", "BizTechReport", "", "troop_member_card_plugin", "plugin_cmd_exp", 0, 0, paramBundle.getClass().getName(), null, null, null);
        return null;
      }
      label1374:
      long l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.troopmemcard.TroopMemCardCmd
 * JD-Core Version:    0.7.0.1
 */