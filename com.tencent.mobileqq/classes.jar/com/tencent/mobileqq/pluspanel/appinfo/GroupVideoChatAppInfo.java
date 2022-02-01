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
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.ODCsChannel;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
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
      ((StringBuilder)localObject).append("startGroupVoice, uinType[").append(paramInt1).append("], groupUin[").append(paramLong).append("], roomId[").append(paramInt2).append("], gameId[").append(paramInt3).append("]");
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
      localStringBuilder.append(str).append("=").append(((Bundle)localObject).getString(str)).append("&");
    }
    ((Bundle)localObject).putString("mqqScheme", localStringBuilder.toString());
    if (QLog.isDevelopLevel()) {
      QLog.i("GroupVideoChatAppInfo", 4, ((Bundle)localObject).toString());
    }
    ((DynamicNowManager)DynamicNowManager.a().getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject);
  }
  
  private static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo phone is calling!");
    }
    String str = paramContext.getString(2131695698);
    DialogUtil.a(paramContext, 230, paramContext.getString(2131695677), str, 2131690800, 2131694615, new GroupVideoChatAppInfo.7(), null).show();
    DataReport.a();
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = paramContext.getString(2131695881);
    DialogUtil.a(paramContext, 230, paramContext.getString(2131695677), str, 2131690800, 2131695607, new GroupVideoChatAppInfo.6(), null).show();
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map<String, String> paramMap)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("startGroupVideo, uinType[").append(paramInt).append("], uin[").append(paramString).append("], chatSession[").append(paramQQAppInterface.getAVNotifyCenter().a(paramString, false)).append("]");
      QLog.i("GroupVideoChatAppInfo", 4, localStringBuilder.toString());
    }
    Monitor.b("3236166");
    enterNewGroupVideo(paramQQAppInterface, paramContext, paramInt, paramString, true, true, paramMap);
    paramContext = (String)paramMap.get("from");
    new IVPluginDataReporter().opDepartment("group_video").opName("startGroupVideo").opType(paramContext).report();
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
    if (VideoController.d(VideoController.b + paramQQAppInterface.getCurrentAccountUin()) > 0)
    {
      enterNewGroupVideo(paramQQAppInterface, paramContext, paramInt, paramString, false, paramBoolean, paramMap);
      return;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (NetworkUtil.b(BaseApplication.getContext()))
    {
      localObject1 = paramContext.getString(2131695677);
      localObject2 = paramContext.getString(2131695672);
    }
    Object localObject3;
    if (NetworkUtil.c(BaseApplication.getContext()))
    {
      localObject1 = paramContext.getString(2131695677);
      if ((paramMap != null) && (TextUtils.equals((CharSequence)paramMap.get("isVideo"), "true")))
      {
        localObject3 = paramContext.getString(2131695673);
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("GroupVideoChatAppInfo", 2, "enterNewGroupVideo title or content is empty");
        return;
        localObject3 = paramContext.getString(2131695674);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
      }
      ChatActivityUtils.a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131695411, 2131695423, new GroupVideoChatAppInfo.4(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean, paramMap), new GroupVideoChatAppInfo.5());
      return;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean, Map<String, String> paramMap, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo is multi calling!");
    }
    String str = paramContext.getString(2131695506);
    int i = TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString + "");
    PopupDialog.a(paramContext, 230, null, str, 2131695411, 2131695423, new GroupVideoChatAppInfo.2(paramQQAppInterface, paramContext, paramInt2, paramInt3, paramInt1, paramString, paramBoolean, paramMap), new GroupVideoChatAppInfo.3(paramQQAppInterface, paramString));
    ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", i + "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface.h(String.valueOf(paramString))) {
      paramQQAppInterface.h(String.valueOf(paramString));
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 1) && (paramQQAppInterface.getAVNotifyCenter().h()) && (paramInt1 == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, "check mutex of qq call and group call!");
      }
      long l = paramQQAppInterface.getAVNotifyCenter().b();
      paramInt1 = paramQQAppInterface.getAVNotifyCenter().b(l);
      if ((paramInt1 != paramInt3) && (paramInt1 == 10) && (paramInt3 == 2))
      {
        if (paramQQAppInterface.getAVNotifyCenter().c())
        {
          QQToast.a(paramContext, 2131695505, 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
          return true;
        }
        QQToast.a(paramContext, 2131695507, 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean, Map<String, String> paramMap, long paramLong, int paramInt2, int paramInt3)
  {
    int i = paramQQAppInterface.getAVNotifyCenter().b();
    int j = paramQQAppInterface.getAVNotifyCenter().c();
    if (((j != 1) && (j != 2)) || (((i >= 1) && (i <= 5)) || (paramQQAppInterface.getAVNotifyCenter().e() == 1) || (paramQQAppInterface.getAVNotifyCenter().e() == 2)))
    {
      QQToast.a(paramContext, 2131695877, 1).b(paramContext.getResources().getDimensionPixelSize(2131299166));
      QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
      return true;
    }
    if (((j != 3) && (j != 4)) || (((i >= 1) && (i <= 5)) || (paramQQAppInterface.getAVNotifyCenter().e() == 3) || (paramQQAppInterface.getAVNotifyCenter().e() == 4)))
    {
      if ((paramQQAppInterface.getAVNotifyCenter().b() == paramLong) && (paramInt2 != 1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoChatAppInfo", 2, "enterNewGroupVideo-->chatUin==discussid???Why");
        }
        return true;
      }
      if (paramQQAppInterface.getAVNotifyCenter().b() > 0L)
      {
        a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean, paramMap, paramInt2, paramInt3);
        return true;
      }
    }
    return false;
  }
  
  public static void enterNewGroupVideo(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo uinType[" + paramInt + "], uin[" + paramString + "]");
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoChatAppInfo", 2, "enterNewGroupVideo Activity isDestroyed!");
      }
    }
    long l;
    int m;
    int i;
    label492:
    do
    {
      do
      {
        do
        {
          return;
          if (!NetworkUtil.d(BaseApplication.getContext()))
          {
            QQToast.a(paramContext, 2131694430, 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
          if ((paramQQAppInterface.getAVNotifyCenter().a()) && (!paramQQAppInterface.isVideoChatting()))
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
          if ((DiscussionInfo.isValidDisUin(paramString)) || (paramInt != 3000)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("GroupVideoChatAppInfo", 2, "invalid discussId: " + paramString);
        return;
      } while (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramString));
      l = UinUtils.b(paramString);
      m = UITools.b(paramInt);
      int k = 0;
      int j = 0;
      i = k;
      if (paramMap != null)
      {
        i = k;
        if (m == 1)
        {
          str1 = (String)paramMap.get("MultiAVType");
          i = j;
          if (str1 != null) {
            i = Integer.valueOf(str1).intValue();
          }
          str1 = (String)paramMap.get("isVideo");
          if ((str1 != null) && (str1.equals("true"))) {
            paramQQAppInterface.getAVNotifyCenter().a(-1034L, true);
          }
        }
      }
      for (;;)
      {
        if (m == 2) {
          i = 1;
        }
        if ((paramQQAppInterface.getAVNotifyCenter().a(m, l)) && (a(paramQQAppInterface, paramContext, paramInt, m, i))) {
          break;
        }
        if (paramQQAppInterface.getAVNotifyCenter().a(m, l, i)) {
          break label524;
        }
        if ((!paramBoolean1) || (NetworkUtil.h(BaseApplication.getContext())) || (NetworkUtil.f(BaseApplication.getContext()))) {
          break label492;
        }
        a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramMap);
        return;
        paramQQAppInterface.getAVNotifyCenter().a(-1034L, false);
      }
    } while ((paramBoolean2) && (paramQQAppInterface.isVideoChatting()) && (a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramMap, l, m, i)));
    label524:
    String str1 = null;
    String str2 = "0";
    Object localObject = str2;
    if (paramMap != null)
    {
      str1 = (String)paramMap.get("from");
      if (!TextUtils.equals(str1, "Panel")) {
        break label646;
      }
      if (!TextUtils.equals((String)paramMap.get("publicClass"), "false")) {
        break label638;
      }
      paramMap = "1";
      str1 = "openMiddlePage";
      localObject = paramMap;
    }
    for (;;)
    {
      ((GroupVideoManager)paramQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(paramContext, paramQQAppInterface.getCurrentAccountUin(), paramString, (String)localObject, str1);
      paramQQAppInterface.getAVNotifyCenter().b(8, l, i);
      return;
      label638:
      paramMap = "3690";
      break;
      label646:
      if (TextUtils.equals(str1, "tipBar"))
      {
        str1 = "openRoom";
        localObject = "2";
      }
      else if (!paramQQAppInterface.getAVNotifyCenter().b(Long.parseLong(paramString)))
      {
        str1 = "openMiddlePage";
        localObject = str2;
      }
      else
      {
        str1 = "openRoom";
        localObject = str2;
      }
    }
  }
  
  public static void startGroupVideoOrVoice(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupVideoChatAppInfo", 2, "uinType = " + paramInt + " groupUin = " + paramString);
    }
    HashMap localHashMap = new HashMap();
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    for (;;)
    {
      paramMap = new GroupRoomManageProto.GetGameStatusByGroupCodeReq();
      paramMap.group_code.set(Long.valueOf(paramString).longValue());
      new ODCsChannel(paramQQAppInterface, Long.valueOf(paramString).longValue()).a(93113, paramMap.toByteArray(), false, new GroupVideoChatAppInfo.1(paramQQAppInterface, paramContext, paramInt, paramString, localHashMap));
      return;
      localHashMap.put("from", "unknow");
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839260;
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
    return BaseApplicationImpl.getContext().getString(2131720006);
  }
  
  void handleTroopLiveOrTroopCourseClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i;
        Object localObject;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        QLog.d("GroupVideoChatAppInfo", 1, localNumberFormatException, new Object[0]);
      }
      paramPlusPanelViewModel.a("chat_tool_gaudio", localQQAppInterface.getCurrentAccountUin());
      localHashMap = new HashMap();
      localHashMap.put("MultiAVType", String.valueOf(2));
      localHashMap.put("from", "Panel");
      if (!paramBoolean) {
        break label401;
      }
    }
    i = UITools.b(paramSessionInfo.jdField_a_of_type_Int);
    long l1 = localQQAppInterface.getAVNotifyCenter().a(i, l1);
    localObject = (TroopGagMgr)localQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    bool1 = ((TroopGagMgr)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString, localQQAppInterface.getCurrentAccountUin());
    bool2 = ((TroopGagMgr)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    bool3 = ((TroopGagMgr)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
    localObject = ((TroopGagMgr)localObject).a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    if ((l1 == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((TroopGagMgr.TroopGagInfo)localObject).a > 0L))))
    {
      QQToast.a(paramBaseChatPie.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131708297), 0).b(paramBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    HashMap localHashMap;
    label401:
    for (String str = "true";; str = "false")
    {
      localHashMap.put("publicClass", str);
      startGroupVideoOrVoice(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, localHashMap);
      paramBaseChatPie.an();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.a().setCanLock(false);
      l1 = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (!localQQAppInterface.getAVNotifyCenter().b(1, l1)) {
        ReportController.b(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramSessionInfo.jdField_a_of_type_JavaLangString, "" + TroopUtils.a(localQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString), "1", "");
      }
      AIOPanelUtiles.a(localQQAppInterface, "0X8005CB5", paramSessionInfo.jdField_a_of_type_Int);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupVideoChatAppInfo
 * JD-Core Version:    0.7.0.1
 */