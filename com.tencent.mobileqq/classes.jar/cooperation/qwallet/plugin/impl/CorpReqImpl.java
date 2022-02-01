package cooperation.qwallet.plugin.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IFriendsManager;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IQwTemp;
import com.qwallet.temp.ITenpayFriendListObserver;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.ICorpReq;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpReq.ICallBack;
import cooperation.qwallet.plugin.ipc.CorpResp;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class CorpReqImpl
  implements ICorpReq
{
  private static final String TAG = "CorpReqImpl";
  
  private String getCustomFaceFilePath(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2)
  {
    return ((IQQAvatarDataService)paramAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, 0);
  }
  
  public static boolean isValideName(String paramString1, String paramString2)
  {
    return (TextUtils.isEmpty(paramString1)) && (!paramString1.equals(paramString2)) && (paramString2 != null);
  }
  
  public Bundle callForwardPage(Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramBundle == null) {
      return null;
    }
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    localCorpResp.encryptionData = CorpReq.encryptionData;
    if (paramResultReceiver == null)
    {
      localCorpResp.callForwardRet = -1;
    }
    else
    {
      int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("forward_type", 0);
        paramBundle = paramBundle.getString("forward_title");
      }
      else
      {
        paramBundle = "";
        i = 0;
      }
      Object localObject2 = QBaseActivity.sTopActivity;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = MobileQQ.sMobileQQ;
      }
      if (localObject1 != null) {
        try
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("forward_text", paramBundle);
          ((Intent)localObject2).putExtra("forward_type", i);
          ((Intent)localObject2).putExtra("choose_friend_callback", paramResultReceiver);
          ((Intent)localObject2).addFlags(268435456);
          RouteUtils.a((Context)localObject1, (Intent)localObject2, "/base/forwardRecent");
          localCorpResp.callForwardRet = 0;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
    }
    paramBundle = new Bundle();
    localCorpResp.toBundle(paramBundle);
    return paramBundle;
  }
  
  public Bundle callSendHbPage(Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (paramBundle == null) {
      return null;
    }
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    localCorpResp.encryptionData = CorpReq.encryptionData;
    Object localObject1;
    if (paramResultReceiver == null)
    {
      localCorpResp.callForwardRet = -1;
    }
    else
    {
      localObject1 = QBaseActivity.sTopActivity;
      paramResultReceiver = (ResultReceiver)localObject1;
      if (localObject1 == null) {
        paramResultReceiver = MobileQQ.sMobileQQ;
      }
      if (paramResultReceiver != null)
      {
        localObject1 = "";
        if (paramBundle == null) {
          break label214;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramBundle.getString("channel");
        localObject2 = paramBundle.getString("recv_uin");
        paramBundle = (Bundle)localObject1;
        localObject1 = localObject2;
        localObject2 = new Intent();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("channel", paramBundle);
          localJSONObject.put("recv_uin", localObject1);
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        ((Intent)localObject2).putExtra("extra_data", localJSONObject.toString());
        ((Intent)localObject2).putExtra("come_from", 2);
        ((Intent)localObject2).putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#multi");
        ((Intent)localObject2).addFlags(536870912);
        RouteUtils.a(paramResultReceiver, (Intent)localObject2, "/qwallet/redpacket/sendhb");
        localCorpResp.callForwardRet = 0;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      paramBundle = new Bundle();
      localCorpResp.toBundle(paramBundle);
      return paramBundle;
      label214:
      Object localObject2 = "";
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void deleteUserNickOB()
  {
    BaseQQAppInterface localBaseQQAppInterface = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
    ITenpayFriendListObserver localITenpayFriendListObserver = (ITenpayFriendListObserver)QRoute.api(ITenpayFriendListObserver.class);
    if (localBaseQQAppInterface != null)
    {
      localBaseQQAppInterface.removeObserver((BusinessObserver)localITenpayFriendListObserver);
      localITenpayFriendListObserver.destroy();
    }
  }
  
  public Bundle getAvatar(Bundle paramBundle, CorpReq.ICallBack paramICallBack)
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    if (paramBundle != null)
    {
      BaseQQAppInterface localBaseQQAppInterface = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
      String str = paramBundle.getString("req_uin");
      int i = paramBundle.getInt("req_type", 1);
      if (!TextUtils.isEmpty(str))
      {
        QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
        paramBundle = localQBaseActivity;
        if (localQBaseActivity == null) {
          paramBundle = MobileQQ.sMobileQQ;
        }
        if ((paramBundle != null) && (!TextUtils.isEmpty(str)) && (localBaseQQAppInterface != null))
        {
          paramBundle = ((IQQAvatarService)localBaseQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(localBaseQQAppInterface);
          paramBundle.setDecodeTaskCompletionListener(new CorpReqImpl.2(this, localBaseQQAppInterface, str, localCorpResp, paramICallBack));
          if (paramBundle.getBitmapFromCache(i, str) != null)
          {
            paramBundle = getCustomFaceFilePath(localBaseQQAppInterface, i, str, 0);
            paramICallBack = new Bundle();
            paramICallBack.putString("avatar_path", paramBundle);
            localCorpResp.toBundle(paramICallBack);
            return paramICallBack;
          }
          paramBundle.requestDecodeFace(str, i, false);
        }
      }
    }
    return null;
  }
  
  public Bundle getGroupNickname(Bundle paramBundle)
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      String str = paramBundle.getString("req_uin");
      int i = paramBundle.getInt("req_type", 1);
      if (TextUtils.isEmpty(str))
      {
        localCorpResp.userNick = "";
        localCorpResp.toBundle(localBundle);
        return localBundle;
      }
      paramBundle = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
      localCorpResp.memNick = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getGroupNicknameByType(paramBundle, i, str);
    }
    localCorpResp.toBundle(localBundle);
    return localBundle;
  }
  
  public Bundle onGetEncryption()
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    localCorpResp.encryptionData = CorpReq.encryptionData;
    Bundle localBundle = new Bundle();
    localCorpResp.toBundle(localBundle);
    return localBundle;
  }
  
  public Bundle onGetFaceFilePath(int paramInt1, String paramString, int paramInt2)
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    AppRuntime localAppRuntime = QWalletHelperImpl.getAppRuntime();
    if (localAppRuntime != null)
    {
      localCorpResp.faceFilePath = ((IQQAvatarDataService)localAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, paramInt1, paramString, paramInt2, 0);
      localCorpResp.memUin = paramString;
    }
    paramString = new Bundle();
    localCorpResp.toBundle(paramString);
    return paramString;
  }
  
  public Bundle onIsFriend(String paramString)
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    AppRuntime localAppRuntime = QWalletHelperImpl.getAppRuntime();
    if (localAppRuntime != null) {
      if (localAppRuntime.getCurrentAccountUin().equals(paramString)) {
        localCorpResp.isFriend = false;
      } else {
        localCorpResp.isFriend = ((IFriendsManager)localAppRuntime.getRuntimeService(IFriendsManager.class, "")).isFriend(paramString);
      }
    }
    paramString = new Bundle();
    localCorpResp.toBundle(paramString);
    return paramString;
  }
  
  @Deprecated
  public void onTenWatch(Bundle paramBundle) {}
  
  public Bundle onTroopMemNick(String paramString1, String paramString2, ArrayList<String> paramArrayList, CorpReq.ICallBack paramICallBack)
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    localCorpResp.troopUin = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append("onTroopMemNick:TextUtils.isEmpty(troopUin), troopUin");
      paramString2.append(paramString1);
      QLog.d("CorpReqImpl.troop.get_troop_mem_card_4_tentpay", 2, paramString2.toString());
      return null;
    }
    AppRuntime localAppRuntime = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
    ITroopMemberNameService localITroopMemberNameService = (ITroopMemberNameService)localAppRuntime.getRuntimeService(ITroopMemberNameService.class, "all");
    ArrayList localArrayList = new ArrayList();
    boolean bool = TextUtils.isEmpty(paramString2);
    int i = 0;
    int j = 0;
    Object localObject1;
    String str;
    Object localObject3;
    if (!bool)
    {
      paramArrayList = localITroopMemberNameService.getTroopMemberNick(paramString1, paramString2);
      if (isValideName(paramArrayList, paramString2))
      {
        localCorpResp.memUin = paramString2;
        localCorpResp.memNick = paramArrayList;
      }
      else
      {
        localArrayList.add(paramString2);
        i = 1;
      }
    }
    else
    {
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break label721;
      }
      int m = paramArrayList.size();
      localObject1 = new JSONArray();
      for (i = 0; j < m; i = k)
      {
        str = (String)paramArrayList.get(j);
        Object localObject2 = localITroopMemberNameService.getTroopMemberNick(paramString1, paramString2);
        if (isValideName((String)localObject2, str)) {
          localObject3 = new JSONObject();
        }
        try
        {
          ((JSONObject)localObject3).put("memUin", str);
          ((JSONObject)localObject3).put("memNick", localObject2);
          ((JSONArray)localObject1).put(localObject3);
          k = i;
        }
        catch (JSONException localJSONException)
        {
          int k;
          label285:
          label351:
          long l;
          break label285;
        }
        k = i;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onTroopMemNick:JSONException， memUinTemp：");
          ((StringBuilder)localObject2).append(str);
          QLog.e("CorpReqImpl.troop.get_troop_mem_card_4_tentpay", 2, ((StringBuilder)localObject2).toString());
          k = i;
          break label351;
          localArrayList.add(str);
          k = 1;
        }
        j += 1;
      }
      localCorpResp.troopMemNickJson = ((JSONArray)localObject1).toString();
    }
    if (i != 0) {
      if ((short)localArrayList.size() > 500) {
        return null;
      }
    }
    try
    {
      l = Long.parseLong(paramString1);
      paramArrayList = new oidb_0x787.ReqBody();
      paramArrayList.uint64_group_code.set(l);
      paramArrayList.uint64_begin_uin.set(0L);
      paramArrayList.uint64_data_time.set(0L);
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        try
        {
          l = Long.parseLong(str);
          paramArrayList.rpt_uin_list.add(Long.valueOf(l));
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getTroopCardDefaultNickBatch parseLong err uin=");
          ((StringBuilder)localObject3).append(str);
          QLog.d("CorpReqImpl.troop.get_troop_mem_card_4_tentpay", 2, ((StringBuilder)localObject3).toString(), localException);
        }
      }
      localObject1 = new oidb_0x787.Filter();
      ((oidb_0x787.Filter)localObject1).uint32_member_level_info_uin.set(1);
      ((oidb_0x787.Filter)localObject1).uint32_member_level_info_name.set(1);
      ((oidb_0x787.Filter)localObject1).uint32_nick_name.set(1);
      paramArrayList.opt_filter.set((MessageMicro)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1927);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
      if (localAppRuntime.getApp() == null) {
        return null;
      }
      paramArrayList = new NewIntent(localAppRuntime.getApp(), ProtoServlet.class);
      paramArrayList.putExtra("cmd", "OidbSvc.0x787_1");
      paramArrayList.putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      paramArrayList.setObserver(new CorpReqImpl.1(this, localCorpResp, paramString2, localITroopMemberNameService, paramString1, paramICallBack, localArrayList));
      localAppRuntime.startServlet(paramArrayList);
      return null;
    }
    catch (Exception paramString1)
    {
      label703:
      break label703;
    }
    return null;
    paramString1 = new Bundle();
    localCorpResp.toBundle(paramString1);
    return paramString1;
    label721:
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onTroopMemNick:TextUtils.isEmpty(troopUin) || memUinArrayList == null || memUinArrayList.isEmpty(), troopUin");
      paramString2.append(paramString1);
      QLog.d("CorpReqImpl.troop.get_troop_mem_card_4_tentpay", 2, paramString2.toString());
    }
    return null;
  }
  
  public Bundle onUserNcik(String paramString1, int paramInt, String paramString2, ResultReceiver paramResultReceiver)
  {
    CorpResp localCorpResp = new CorpResp();
    localCorpResp.corpReqType = CorpReq.corpReqType;
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject1 = null;
    if (bool)
    {
      localCorpResp.userNick = paramString1;
      return null;
    }
    BaseQQAppInterface localBaseQQAppInterface = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface();
    if (localBaseQQAppInterface != null)
    {
      Object localObject2 = (IFriendsManager)localBaseQQAppInterface.getRuntimeService(IFriendsManager.class, "");
      if (((paramInt != 5) && ((paramInt & 0x10) == 0)) || ((((IFriendsManager)localObject2).isFriend(paramString1)) && (!localBaseQQAppInterface.getCurrentAccountUin().equals(paramString1))))
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject2 = ((IFriendsManager)localObject2).findFriendEntityByUin(paramString1);
          TroopMemberInfo localTroopMemberInfo = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).TroopManager$getTroopMember(localBaseQQAppInterface, paramString2, paramString1);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((Friends)localObject2).remark)))
          {
            paramString2 = ((Friends)localObject2).remark;
          }
          else if ((localTroopMemberInfo != null) && (!TextUtils.isEmpty(localTroopMemberInfo.troopnick)))
          {
            paramString2 = localTroopMemberInfo.troopnick;
          }
          else if (localObject2 != null)
          {
            paramString2 = ((Friends)localObject2).name;
          }
          else
          {
            paramString2 = localObject1;
            if (localTroopMemberInfo != null) {
              if (paramString1.equals(localBaseQQAppInterface.getCurrentAccountUin())) {
                paramString2 = localTroopMemberInfo.friendnick;
              } else if (!TextUtils.isEmpty(localTroopMemberInfo.autoremark)) {
                paramString2 = localTroopMemberInfo.autoremark;
              } else {
                paramString2 = localTroopMemberInfo.friendnick;
              }
            }
          }
          if (TextUtils.isEmpty(paramString2))
          {
            paramString2 = (ITenpayFriendListObserver)QRoute.api(ITenpayFriendListObserver.class);
            paramString2.add(paramString1, paramResultReceiver);
            localBaseQQAppInterface.addObserver((BusinessObserver)paramString2);
            localCorpResp.userNick = ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(localBaseQQAppInterface, paramString1, true);
          }
          else
          {
            localCorpResp.userNick = paramString2;
          }
        }
        else
        {
          paramString2 = (ITenpayFriendListObserver)QRoute.api(ITenpayFriendListObserver.class);
          paramString2.add(paramString1, paramResultReceiver);
          localBaseQQAppInterface.addObserver((BusinessObserver)paramString2);
          localCorpResp.userNick = ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(localBaseQQAppInterface, paramString1, true);
        }
      }
      else
      {
        paramString2 = ((IQwTemp)QRoute.api(IQwTemp.class)).ContactUtils$getDateNickName(localBaseQQAppInterface, paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          paramString1 = paramString2;
        }
        localCorpResp.userNick = paramString1;
      }
    }
    paramString1 = new Bundle();
    localCorpResp.toBundle(paramString1);
    return paramString1;
  }
  
  public void openAio(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("send_uin");
    int i = paramBundle.getInt("send_type", 0);
    if (i == 1) {
      paramBundle = "discuss";
    } else if (i == 2) {
      paramBundle = "group";
    } else {
      paramBundle = "c2c";
    }
    Object localObject2 = QBaseActivity.sTopActivity;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MobileQQ.sMobileQQ;
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(str))) {
      try
      {
        localObject2 = new Intent((Context)localObject1, JumpActivity.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mqqapi://im/chat?src_type=web&uin=");
        localStringBuilder.append(str);
        localStringBuilder.append("&attach_content=&version=1&chat_type=");
        localStringBuilder.append(paramBundle);
        ((Intent)localObject2).setData(Uri.parse(localStringBuilder.toString()));
        ((Intent)localObject2).addFlags(268435456);
        ((Context)localObject1).startActivity((Intent)localObject2);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.CorpReqImpl
 * JD-Core Version:    0.7.0.1
 */