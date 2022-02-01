package com.tencent.mobileqq.pluspanel.appinfo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.jungle.videohub.proto.GroupRoomManageProto.GetGameStatusByGroupCodeReq;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GroupVideoChatAppInfo
  extends PlusPanelAppInfo
{
  private static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("startGroupVoice, uinType[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], groupUin[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], roomId[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], gameId[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("]");
      QLog.i("GroupVideoChatAppInfo", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("roomid", String.valueOf(paramInt2));
    ((Bundle)localObject).putString("gameId", String.valueOf(paramInt3));
    ((Bundle)localObject).putString("groupUin", String.valueOf(paramLong));
    ((Bundle)localObject).putString("uinType", String.valueOf(paramInt1));
    ((Bundle)localObject).putString("fromid", "10032");
    ((Bundle)localObject).putString("first", "2");
    ((Bundle)localObject).putString("roomtype", "10001");
    ((Bundle)localObject).putString("is_record", "0");
    ((Bundle)localObject).putString("enter_record_if_finish", "0");
    ((Bundle)localObject).putString("first_jump_mode", "plugin");
    ((Bundle)localObject).putString("startsrc", "group");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://now/openroom?");
    Iterator localIterator = ((Bundle)localObject).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append(((Bundle)localObject).getString(str));
      localStringBuilder.append("&");
    }
    ((Bundle)localObject).putString("mqqScheme", localStringBuilder.toString());
    if (QLog.isDevelopLevel()) {
      QLog.i("GroupVideoChatAppInfo", 4, ((Bundle)localObject).toString());
    }
    ((IDynamicNowManager)((QQAppInterface)((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).getQQAppInterface()).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject);
  }
  
  private static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo phone is calling!");
    }
    String str = paramContext.getString(2131893471);
    DialogUtil.a(paramContext, 230, paramContext.getString(2131893450), str, 2131887648, 2131892267, new GroupVideoChatAppInfo.7(), null).show();
    DataReport.a();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = paramContext.getString(2131893654);
    DialogUtil.a(paramContext, 230, paramContext.getString(2131893450), str, 2131887648, 2131893377, new GroupVideoChatAppInfo.6(), null).show();
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map<String, String> paramMap)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("startGroupVideo, uinType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], chatSession[");
      localStringBuilder.append(paramQQAppInterface.getAVNotifyCenter().b(paramString, false));
      localStringBuilder.append("]");
      QLog.i("GroupVideoChatAppInfo", 4, localStringBuilder.toString());
    }
    ((IFactoryApi)QRoute.api(IFactoryApi.class)).monitorReport("3236166");
    enterNewGroupVideo(paramQQAppInterface, paramContext, paramInt, paramString, true, true, paramMap);
    paramContext = (String)paramMap.get("from");
    ((IFactoryApi)QRoute.api(IFactoryApi.class)).getIVPluginReportInterface().opDepartment("group_video").opName("startGroupVideo").opType(paramContext).report();
    try
    {
      long l = Long.valueOf(paramString).longValue();
      paramInt = Integer.valueOf((String)paramMap.get("MultiAVType")).intValue();
      paramString = paramQQAppInterface.getAVNotifyCenter().a(l, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, String.format("startGroupVideo from=%s groupId=%s avType=%s roomInfo=%s", new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(paramInt), paramString }));
      }
      if ((paramString != null) && (paramString.a()))
      {
        if ("tipBar".equals(paramContext))
        {
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800ABD4", "0X800ABD4", 0, 0, "", "", "", "");
          return;
        }
        if ("itemBuilder".equals(paramContext))
        {
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800ABD5", "0X800ABD5", 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("GroupVideoChatAppInfo", 1, "startGroupVideo education report fail.", paramQQAppInterface);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(VideoController.aj);
    ((StringBuilder)localObject1).append(paramQQAppInterface.getCurrentAccountUin());
    if (VideoController.n(((StringBuilder)localObject1).toString()) > 0)
    {
      enterNewGroupVideo(paramQQAppInterface, paramContext, paramInt, paramString, false, paramBoolean, paramMap);
      return;
    }
    boolean bool = NetworkUtil.isMobileNetWork(BaseApplication.getContext());
    localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject1 = paramContext.getString(2131893450);
      localObject2 = paramContext.getString(2131893445);
    }
    else
    {
      localObject2 = null;
    }
    Object localObject3;
    if (NetworkUtil.is3Gor4G(BaseApplication.getContext()))
    {
      localObject2 = paramContext.getString(2131893450);
      if ((paramMap != null) && (TextUtils.equals((CharSequence)paramMap.get("isVideo"), "true"))) {
        localObject1 = paramContext.getString(2131893446);
      } else {
        localObject1 = paramContext.getString(2131893447);
      }
      localObject3 = localObject1;
    }
    else
    {
      localObject3 = localObject2;
      localObject2 = localObject1;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(localObject3)))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramContext, 230, (String)localObject2, localObject3, 2131893167, 2131893180, new GroupVideoChatAppInfo.4(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean, paramMap), new GroupVideoChatAppInfo.5());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("GroupVideoChatAppInfo", 2, "enterNewGroupVideo title or content is empty");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean, Map<String, String> paramMap, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo is multi calling!");
    }
    String str1 = paramContext.getString(2131893276);
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    int i = TroopMemberUtil.a(paramQQAppInterface, str2, localStringBuilder.toString());
    PopupDialog.a(paramContext, 230, null, str1, 2131893167, 2131893180, new GroupVideoChatAppInfo.2(paramQQAppInterface, paramContext, paramInt2, paramInt3, paramInt1, paramString, paramBoolean, paramMap), new GroupVideoChatAppInfo.3(paramQQAppInterface, paramString));
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(paramString);
    paramQQAppInterface.append("");
    paramQQAppInterface = paramQQAppInterface.toString();
    paramContext = new StringBuilder();
    paramContext.append(i);
    paramContext.append("");
    ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramQQAppInterface, paramContext.toString(), "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface.F(String.valueOf(paramString))) {
      paramQQAppInterface.E(String.valueOf(paramString));
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 1) && (paramQQAppInterface.getAVNotifyCenter().r()) && (paramInt1 == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, "check mutex of qq call and group call!");
      }
      long l = paramQQAppInterface.getAVNotifyCenter().g();
      paramInt1 = paramQQAppInterface.getAVNotifyCenter().e(l);
      if ((paramInt1 != paramInt3) && (paramInt1 == 10) && (paramInt3 == 2))
      {
        if (paramQQAppInterface.getAVNotifyCenter().e())
        {
          QQToast.makeText(paramContext, 2131893275, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
          return true;
        }
        QQToast.makeText(paramContext, 2131893277, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean, Map<String, String> paramMap, long paramLong, int paramInt2, int paramInt3)
  {
    int i = paramQQAppInterface.getAVNotifyCenter().j();
    int j = paramQQAppInterface.getAVNotifyCenter().k();
    if (((j != 1) && (j != 2)) || (((i < 1) || (i > 5)) && (paramQQAppInterface.getAVNotifyCenter().t() != 1) && (paramQQAppInterface.getAVNotifyCenter().t() != 2)))
    {
      if (((j != 3) && (j != 4)) || (((i >= 1) && (i <= 5)) || (paramQQAppInterface.getAVNotifyCenter().t() == 3) || (paramQQAppInterface.getAVNotifyCenter().t() == 4)))
      {
        if ((paramQQAppInterface.getAVNotifyCenter().g() == paramLong) && (paramInt2 != 1))
        {
          if (QLog.isColorLevel()) {
            QLog.e("GroupVideoChatAppInfo", 2, "enterNewGroupVideo-->chatUin==discussid???Why");
          }
          return true;
        }
        if (paramQQAppInterface.getAVNotifyCenter().g() > 0L)
        {
          a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean, paramMap, paramInt2, paramInt3);
          return true;
        }
      }
      return false;
    }
    QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
    return true;
  }
  
  public static void enterNewGroupVideo(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterNewGroupVideo uinType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], uin[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.d("GroupVideoChatAppInfo", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo Activity isDestroyed!");
      }
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(paramContext, 2131892074, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
    if ((paramQQAppInterface.getAVNotifyCenter().c()) && (!paramQQAppInterface.isVideoChatting()))
    {
      a(paramContext);
      return;
    }
    if (!VcSystemInfo.isNormalSharp())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo old engine!");
      }
      if (paramInt == 1011)
      {
        a(paramQQAppInterface, paramContext);
        return;
      }
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) && (paramInt == 3000))
    {
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("invalid discussId: ");
        paramQQAppInterface.append(paramString);
        QLog.d("GroupVideoChatAppInfo", 2, paramQQAppInterface.toString());
      }
      return;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramString)) {
      return;
    }
    long l = UinUtils.b(paramString);
    int j = UITools.b(paramInt);
    int i;
    if ((paramMap != null) && (j == 1))
    {
      localObject = (String)paramMap.get("MultiAVType");
      if (localObject != null) {
        i = Integer.valueOf((String)localObject).intValue();
      } else {
        i = 0;
      }
      localObject = (String)paramMap.get("isVideo");
      if ((localObject != null) && (((String)localObject).equals("true"))) {
        paramQQAppInterface.getAVNotifyCenter().a(-1034L, true);
      } else {
        paramQQAppInterface.getAVNotifyCenter().a(-1034L, false);
      }
    }
    else
    {
      i = 0;
    }
    if (j == 2) {
      i = 1;
    }
    if ((paramQQAppInterface.getAVNotifyCenter().a(j, l)) && (a(paramQQAppInterface, paramContext, paramInt, j, i))) {
      return;
    }
    Object localObject = paramMap;
    if (!paramQQAppInterface.getAVNotifyCenter().a(j, l, i))
    {
      if ((paramBoolean1) && (!NetworkUtil.isWifiConnected(BaseApplication.getContext())) && (!NetworkUtil.isBluetoothSharedNetwork(BaseApplication.getContext())))
      {
        a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramMap);
        return;
      }
      if ((paramBoolean2) && (paramQQAppInterface.isVideoChatting()) && (a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramMap, l, j, i))) {
        return;
      }
    }
    if (localObject != null)
    {
      paramMap = (String)((Map)localObject).get("from");
      if (TextUtils.equals(paramMap, "Panel"))
      {
        if (TextUtils.equals((String)((Map)localObject).get("publicClass"), "false")) {
          paramMap = "1";
        } else {
          paramMap = "3690";
        }
        localObject = "openMiddlePage";
        break label697;
      }
      if (TextUtils.equals(paramMap, "tipBar"))
      {
        paramMap = "2";
        localObject = "openRoom";
        break label697;
      }
      if (!paramQQAppInterface.getAVNotifyCenter().c(Long.parseLong(paramString))) {
        paramMap = "openMiddlePage";
      } else {
        paramMap = "openRoom";
      }
    }
    else
    {
      paramMap = null;
    }
    String str = "0";
    localObject = paramMap;
    paramMap = str;
    label697:
    ((IGroupVideoManager)paramQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(paramContext, paramQQAppInterface.getCurrentAccountUin(), paramString, paramMap, (String)localObject);
    paramQQAppInterface.getAVNotifyCenter().c(8, l, i);
  }
  
  public static void startGroupVideoOrVoice(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map<String, String> paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uinType = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" groupUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("GroupVideoChatAppInfo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    if (paramMap != null) {
      ((HashMap)localObject).putAll(paramMap);
    } else {
      ((HashMap)localObject).put("from", "unknow");
    }
    paramMap = new GroupRoomManageProto.GetGameStatusByGroupCodeReq();
    paramMap.group_code.set(Long.valueOf(paramString).longValue());
    ((IODCsChannel)QRoute.api(IODCsChannel.class)).get(paramQQAppInterface, Long.valueOf(paramString).longValue()).sendRequest(93113, paramMap.toByteArray(), false, new GroupVideoChatAppInfo.1(paramQQAppInterface, paramContext, paramInt, paramString, (HashMap)localObject));
  }
  
  public int defaultDrawableID()
  {
    return 2130839270;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 100719166;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131917341);
  }
  
  void handleTroopLiveOrTroopCourseClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo.a == 1)
    {
      QQAppInterface localQQAppInterface = paramBaseChatPie.d;
      try
      {
        l = Long.parseLong(paramSessionInfo.b);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("GroupVideoChatAppInfo", 1, localNumberFormatException, new Object[0]);
        l = 0L;
      }
      int i = UITools.b(paramSessionInfo.a);
      long l = localQQAppInterface.getAVNotifyCenter().c(i, l);
      Object localObject = (TroopGagMgr)localQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      boolean bool1 = ((TroopGagMgr)localObject).a(paramSessionInfo.b, localQQAppInterface.getCurrentAccountUin());
      boolean bool2 = ((TroopGagMgr)localObject).c(paramSessionInfo.b);
      boolean bool3 = ((TroopGagMgr)localObject).d(paramSessionInfo.b);
      localObject = ((TroopGagMgr)localObject).b(paramSessionInfo.b);
      if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((TroopGagInfo)localObject).b > 0L))))
      {
        QQToast.makeText(paramBaseChatPie.e, HardCodeUtil.a(2131906096), 0).show(paramBaseChatPie.e.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      paramPlusPanelViewModel.a("chat_tool_gaudio", localQQAppInterface.getCurrentAccountUin());
      HashMap localHashMap = new HashMap();
      localHashMap.put("MultiAVType", String.valueOf(2));
      localHashMap.put("from", "Panel");
      if (paramBoolean) {
        localObject = "true";
      } else {
        localObject = "false";
      }
      localHashMap.put("publicClass", localObject);
      if (paramBoolean) {
        a(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo.a, paramSessionInfo.b, localHashMap);
      } else {
        startGroupVideoOrVoice(localQQAppInterface, paramBaseChatPie.aX(), paramSessionInfo.a, paramSessionInfo.b, localHashMap);
      }
      paramBaseChatPie.aw();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.aX().setCanLock(false);
      l = Long.parseLong(paramSessionInfo.b);
      if (!localQQAppInterface.getAVNotifyCenter().f(1, l))
      {
        paramPlusPanelViewModel = paramSessionInfo.b;
        paramBaseChatPie = new StringBuilder();
        paramBaseChatPie.append("");
        paramBaseChatPie.append(TroopUtils.a(localQQAppInterface, paramSessionInfo.b));
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramPlusPanelViewModel, paramBaseChatPie.toString(), "1", "");
      }
      AIOPanelUtiles.a(localQQAppInterface, "0X8005CB5", paramSessionInfo.a);
    }
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    try
    {
      handleTroopLiveOrTroopCourseClick(paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo, false);
      return;
    }
    catch (Exception paramPlusPanelViewModel)
    {
      QLog.d("GroupVideoChatAppInfo", 1, "handleTroopLiveOrTroopCourseClick Exception", paramPlusPanelViewModel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo
 * JD-Core Version:    0.7.0.1
 */