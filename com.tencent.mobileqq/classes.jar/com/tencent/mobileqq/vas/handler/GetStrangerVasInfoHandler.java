package com.tencent.mobileqq.vas.handler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionServlet;
import com.tencent.mobileqq.apollo.api.handler.IVasExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.utils.ExtensionInfoLogUtils;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GetStrangerVasInfoHandler
  implements IVasExtensionHandler
{
  private IApolloExtensionHandler jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = ApolloExtensionHandlerImpl.b;
      localStringBuilder = new StringBuilder().append("handleGetStrangerVasInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label161;
      }
    }
    label160:
    label161:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d(str, 2, i);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            a(paramIntent, paramFromServiceMsg);
            return;
          }
          ((BusinessHandler)this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler).notifyUI(66, false, null);
          return;
        }
        catch (Throwable paramIntent)
        {
          if (!QLog.isColorLevel()) {
            break label160;
          }
        }
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "", paramIntent);
      }
      else
      {
        ((BusinessHandler)this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler).notifyUI(66, false, null);
      }
      return;
    }
  }
  
  private void a(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
    localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    int n = localRspBody.rpt_msg_uin_data.size();
    HashSet localHashSet = new HashSet(n);
    ArrayList localArrayList1 = new ArrayList(n);
    ArrayList localArrayList2 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
    int i = 0;
    int j = 0;
    boolean bool1 = true;
    QLog.i(ApolloExtensionHandlerImpl.b, 1, "response.rpt_msg_uin_data.size():" + n);
    int m = 0;
    oidb_0x5eb.UdcUinData localUdcUinData;
    boolean bool2;
    String str;
    int k;
    if (m < n)
    {
      localUdcUinData = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get(m);
      bool2 = false;
      str = String.valueOf(localUdcUinData.uint64_uin.get());
      ExtensionInfo localExtensionInfo = localFriendsManager.a(str);
      ExtensionInfoLogUtils.a(ApolloExtensionHandlerImpl.b, "GetStrangerVasInfoHandler，before update，friendManager.getExtensionInfo(uin)：", localExtensionInfo);
      paramOIDBSSOPkg = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramOIDBSSOPkg = new ExtensionInfo();
        paramOIDBSSOPkg.uin = str;
        bool2 = true;
      }
      k = i;
      if (!localUdcUinData.uint32_vas_font_id.has()) {
        break label752;
      }
      long l = localUdcUinData.uint32_vas_font_id.get();
      if (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        k = (int)FontManager.a(l);
        VasShieldFont.c = k;
        i = k;
        if (QLog.isColorLevel())
        {
          QLog.d("VasShieldFont", 2, "handleGetStrangerVasInfo: " + VasShieldFont.c);
          i = k;
        }
      }
      if (FontManager.a(l) == paramOIDBSSOPkg.uVipFont)
      {
        k = i;
        if (FontManager.b(l) == paramOIDBSSOPkg.vipFontType) {
          break label752;
        }
      }
      paramOIDBSSOPkg.uVipFont = FontManager.a(l);
      paramOIDBSSOPkg.vipFontType = FontManager.b(l);
      paramOIDBSSOPkg.lastUpdateTime = NetConnInfoCenter.getServerTime();
      bool2 = true;
    }
    for (;;)
    {
      a(localUdcUinData);
      if ((localUdcUinData.uint32_vas_diy_font_timestamp.has()) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        j = localUdcUinData.uint32_vas_diy_font_timestamp.get();
        bool1 = true;
      }
      for (;;)
      {
        bool2 = a(localUdcUinData, b(localUdcUinData, a(localArrayList2, localUdcUinData, bool2, str, paramOIDBSSOPkg), str, paramOIDBSSOPkg), paramOIDBSSOPkg);
        b(localUdcUinData);
        c(localUdcUinData, str);
        b(localUdcUinData, str);
        d(localUdcUinData);
        a(localUdcUinData, str);
        c(localUdcUinData);
        if ((localUdcUinData.uint64_game_appid.has()) && (localUdcUinData.uint64_game_last_login_time.has()) && (localUdcUinData.uint32_plate_of_king_dan.has()) && (localUdcUinData.uint32_plate_of_king_dan_display_switch.has())) {
          a(str, localUdcUinData.uint64_game_appid.get(), localUdcUinData.uint64_game_last_login_time.get(), localUdcUinData.uint32_plate_of_king_dan.get(), localUdcUinData.uint32_plate_of_king_dan_display_switch.get());
        }
        if (paramIntent.getBooleanExtra("req_roam_type", false)) {
          a(str, localUdcUinData);
        }
        if (paramIntent.getBooleanExtra("req_music_type", false)) {
          ((BusinessHandler)this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler).notifyUI(36, true, Integer.valueOf(localUdcUinData.uint32_rsp_listen_together_player_id.get()));
        }
        if (bool2)
        {
          paramOIDBSSOPkg.timestamp = System.currentTimeMillis();
          localHashSet.add(str);
          localArrayList1.add(paramOIDBSSOPkg);
        }
        m += 1;
        break;
        paramIntent = localArrayList1.iterator();
        while (paramIntent.hasNext())
        {
          paramOIDBSSOPkg = (ExtensionInfo)paramIntent.next();
          ExtensionInfoLogUtils.a(ApolloExtensionHandlerImpl.b, "GetStrangerVasInfoHandler，after update and before bulkSaveOrUpdateExtensionInfo", paramOIDBSSOPkg);
        }
        a(localFriendsManager, i, j, bool1);
        localFriendsManager.b(localArrayList1);
        localVasFaceManager.b(localArrayList2);
        localVasFaceManager.a(localArrayList1);
        ((BusinessHandler)this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler).notifyUI(66, true, localHashSet);
        return;
      }
      label752:
      i = k;
    }
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "0x5eb self has diy timestamp fontid = " + paramInt1 + " timestamp = " + paramInt2);
      }
      paramFriendsManager = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      FontManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFriendsManager, paramInt1, paramInt2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    boolean bool3 = false;
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = new oidb_0x5eb.ReqBody();
    Object localObject2 = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!((List)localObject2).contains(str)) {
        ((List)localObject2).add(str);
      }
      i += 1;
    }
    paramArrayOfString = (String[])((List)localObject2).toArray(new String[1]);
    j = paramArrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i < j)
      {
        localObject2 = paramArrayOfString[i];
        try
        {
          long l = Long.parseLong((String)localObject2);
          ((oidb_0x5eb.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    i = 0;
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2 = bool3;
      if (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] == 42255)
        {
          ((oidb_0x5eb.ReqBody)localObject1).roam_flag_qq_7day.set(1);
          ((oidb_0x5eb.ReqBody)localObject1).roam_flag_vip_30day.set(1);
          ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_2year.set(1);
          ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_5year.set(1);
          ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_forever.set(1);
          bool2 = true;
        }
      }
      else
      {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "batchGetStrangerVasInfo, uins: " + Arrays.toString(paramArrayOfString) + " fields: " + Arrays.toString(paramArrayOfInt));
        paramArrayOfInt = new oidb_sso.OIDBSSOPkg();
        paramArrayOfInt.uint32_command.set(1515);
        paramArrayOfInt.uint32_service_type.set(paramInt);
        paramArrayOfInt.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject1).toByteArray()));
        localObject1 = new NewIntent(paramQQAppInterface.getApp(), ((IApolloExtensionServlet)QRoute.api(IApolloExtensionServlet.class)).getImplClass());
        ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x5eb_99");
        ((NewIntent)localObject1).putExtra("data", paramArrayOfInt.toByteArray());
        ((NewIntent)localObject1).putExtra("req_roam_type", bool2);
        ((NewIntent)localObject1).putExtra("req_music_type", bool1);
        ((NewIntent)localObject1).putExtra("uins", paramArrayOfString);
        paramQQAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      a(paramArrayOfInt, (oidb_0x5eb.ReqBody)localObject1, i);
      bool1 = a(paramArrayOfInt, (oidb_0x5eb.ReqBody)localObject1, bool1, i);
      i += 1;
    }
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    try
    {
      if (paramUdcUinData.uint32_bubble_id.has())
      {
        int i = paramUdcUinData.uint32_bubble_id.get();
        ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(i);
      }
      return;
    }
    catch (Exception paramUdcUinData)
    {
      QLog.e(ApolloExtensionHandlerImpl.b, 1, "" + paramUdcUinData.getMessage());
    }
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if (paramUdcUinData.uint32_rsp_qq_level_icon_type.has())
    {
      int i = paramUdcUinData.uint32_rsp_qq_level_icon_type.get();
      paramUdcUinData = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramString = paramUdcUinData.a(paramString + "");
      if ((paramString != null) && (paramString.mQQLevelType != i))
      {
        paramString.mQQLevelType = i;
        paramUdcUinData.a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramString);
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, oidb_0x5eb.ReqBody paramReqBody, int paramInt)
  {
    switch (paramArrayOfInt[paramInt])
    {
    default: 
      return;
    case 27201: 
      paramReqBody.uint32_req_vas_font_id_flag.set(1);
      return;
    case 40530: 
      paramReqBody.uint32_req_vas_magicfont_flag.set(1);
      return;
    case 27025: 
      paramReqBody.uint32_req_face_addon_id.set(1);
      return;
    case 20059: 
      paramReqBody.uint32_req_bubble_id.set(1);
      return;
    case 27041: 
      paramReqBody.uint32_req_vas_colorring_flag.set(1);
      return;
    case 27217: 
      paramReqBody.uint32_req_vas_praise_flag.set(1);
      return;
    case 27225: 
      paramReqBody.uint32_game_appid.set(1);
      return;
    case 27224: 
      paramReqBody.uint32_game_last_login_time.set(1);
      return;
    case 27234: 
      paramReqBody.uint32_req_vas_voicebubble_id.set(1);
      return;
    case 42122: 
      paramReqBody.uint32_plate_of_king_dan.set(1);
      return;
    case 42121: 
      paramReqBody.uint32_plate_of_king_dan_display_switch.set(1);
      return;
    case 27235: 
      paramReqBody.uint32_req_vas_pendant_diy_id.set(1);
      return;
    case 27236: 
      paramReqBody.uint32_req_suspend_effect_id.set(1);
      return;
    case 27238: 
      paramReqBody.uint32_req_vas_face_id.set(1);
      return;
    case 27241: 
      paramReqBody.uint32_req_vas_diy_font_timestamp_flag.set(1);
      return;
    }
    paramReqBody.uint32_req_font_effect_id.set(1);
  }
  
  private boolean a(PBUInt32Field paramPBUInt32Field)
  {
    return (paramPBUInt32Field.has()) && (paramPBUInt32Field.get() == 1);
  }
  
  private boolean a(ArrayList<String> paramArrayList, oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    int i;
    if (paramUdcUinData.uint32_vas_magicfont_flag.has())
    {
      i = paramUdcUinData.uint32_vas_magicfont_flag.get();
      bool = paramBoolean;
      if (i != paramExtensionInfo.magicFont)
      {
        paramExtensionInfo.magicFont = i;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        bool = true;
      }
    }
    paramBoolean = bool;
    if (paramUdcUinData.uint32_vas_colorring_id.has())
    {
      i = paramUdcUinData.uint32_vas_colorring_id.get();
      paramBoolean = bool;
      if (paramExtensionInfo.colorRingId != i)
      {
        paramExtensionInfo.colorRingId = i;
        paramBoolean = true;
      }
    }
    if (paramUdcUinData.uint32_vas_praise_id.has())
    {
      i = paramUdcUinData.uint32_vas_praise_id.get();
      if ((i > 0) && (String.valueOf(paramString).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "handleGetStrangerVasInfo uin= " + paramString + "praise id = " + i);
      }
    }
    if (paramUdcUinData.uint32_vas_voicebubble_id.has())
    {
      i = paramUdcUinData.uint32_vas_voicebubble_id.get();
      if ((i > 0) && (String.valueOf(paramString).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(i);
        if (QLog.isColorLevel()) {
          QLog.d(ApolloExtensionHandlerImpl.b, 2, "handleGetStrangerVasInfo uin= " + paramString + "voice print bubble id = " + i);
        }
      }
    }
    bool = paramBoolean;
    if (paramUdcUinData.uint32_vas_face_id.has())
    {
      i = paramExtensionInfo.faceId;
      int j = paramUdcUinData.uint32_vas_face_id.get();
      if ((paramExtensionInfo.faceIdUpdateTime == 0L) || (i != j))
      {
        paramExtensionInfo.faceId = j;
        paramExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        paramBoolean = true;
      }
      if (i != j) {
        paramArrayList.add(paramString);
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d(ApolloExtensionHandlerImpl.b, 1, "uint32_vas_face_id uin: " + paramString + " oldId: " + i + " newId: " + j);
        bool = paramBoolean;
      }
    }
    return a(paramUdcUinData, bool, paramString, paramExtensionInfo);
  }
  
  private boolean a(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    if (paramUdcUinData.uint64_face_addon_id.has())
    {
      long l = paramUdcUinData.uint64_face_addon_id.get();
      bool = paramBoolean;
      if (paramExtensionInfo.pendantId != l)
      {
        paramExtensionInfo.pendantId = l;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        bool = true;
      }
    }
    return bool;
  }
  
  private boolean a(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    if (paramUdcUinData.uint32_vas_pendant_diy_id.has())
    {
      int i = paramUdcUinData.uint32_vas_pendant_diy_id.get();
      bool = paramBoolean;
      if (paramExtensionInfo.pendantDiyId != i)
      {
        paramExtensionInfo.pendantDiyId = i;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        paramBoolean = true;
        if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(i, false);
        }
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d(ApolloExtensionHandlerImpl.b, 2, "handleGetStrangerVasInfo, uin=" + paramString + ", pendant=" + paramExtensionInfo.pendantId + ",font=" + paramExtensionInfo.uVipFont + ", fontType = " + paramExtensionInfo.vipFontType + ", magicFont = " + paramExtensionInfo.magicFont + ", colorRing = " + paramExtensionInfo.colorRingId + ", pendantDiyId = " + paramExtensionInfo.pendantDiyId);
          bool = paramBoolean;
        }
      }
    }
    return bool;
  }
  
  private static boolean a(int[] paramArrayOfInt, oidb_0x5eb.ReqBody paramReqBody, boolean paramBoolean, int paramInt)
  {
    switch (paramArrayOfInt[paramInt])
    {
    default: 
      return paramBoolean;
    case 42334: 
      paramReqBody.uint32_req_qq_level_icon_type_id.set(1);
      return paramBoolean;
    case 27373: 
      paramReqBody.uint32_req_theme_font_id.set(1);
      return paramBoolean;
    case 45000: 
      paramReqBody.uint32_bubble_unread_switch.set(1);
      return paramBoolean;
    case 27375: 
      paramReqBody.uint32_req_vip_ext_id.set(1);
      return paramBoolean;
    case 45033: 
      paramReqBody.uint32_req_listen_together_player_id.set(1);
      return true;
    case 42417: 
      paramReqBody.uint32_c2c_aio_shortcut_switch.set(1);
      return paramBoolean;
    }
    paramReqBody.uint32_file_assist_top.set(1);
    return paramBoolean;
  }
  
  private void b(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool = true;
    if (paramUdcUinData.uint32_c2c_aio_shortcut_switch.has()) {
      if (paramUdcUinData.uint32_c2c_aio_shortcut_switch.get() != 1) {
        break label32;
      }
    }
    for (;;)
    {
      C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool);
      return;
      label32:
      bool = false;
    }
  }
  
  private void b(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if (paramUdcUinData.uint32_suspend_effect_id.has())
    {
      int i = paramUdcUinData.uint32_suspend_effect_id.get();
      if ((i >= 0) && (String.valueOf(paramString).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "uint32_suspend_effect_id = " + i);
      }
    }
  }
  
  private boolean b(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    if (paramUdcUinData.uint32_req_font_effect_id.has())
    {
      int i = paramUdcUinData.uint32_req_font_effect_id.get();
      if (QLog.isColorLevel()) {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "handleGetStrangerVasInfo uin = " + paramString + " fontEffect = " + i + " extInfo.fontEffect = " + paramExtensionInfo.fontEffect);
      }
      if (i != paramExtensionInfo.fontEffect)
      {
        paramExtensionInfo.fontEffect = i;
        paramExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        paramBoolean = true;
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "handleGetStrangerVasInfo uin = " + paramString + " extInfo.fontEffect = " + paramExtensionInfo.fontEffect + " extInfo.fontEffectLastUpdateTime = " + paramExtensionInfo.fontEffectLastUpdateTime);
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private void c(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_rsp_theme_font_id.has()) {
      ThemeFontAdapter.b(paramUdcUinData.uint32_rsp_theme_font_id.get());
    }
  }
  
  private void c(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    Dialogue localDialogue;
    if (paramUdcUinData.bytes_req_vip_ext_id.has())
    {
      localDialogue = new Dialogue();
      localDialogue.mergeFrom(paramUdcUinData.bytes_req_vip_ext_id.get().toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "vip_card_extension id by refresh=" + localDialogue.short_nameplate_itemid);
      }
      paramUdcUinData = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramString = paramUdcUinData.e(paramString);
      if (paramString != null) {
        if (!localDialogue.short_nameplate_itemid.has()) {
          break label139;
        }
      }
    }
    label139:
    for (int i = localDialogue.short_nameplate_itemid.get();; i = 0)
    {
      paramString.bigClubExtTemplateId = i;
      paramString.diyFontId = localDialogue.diyfontid.get();
      paramUdcUinData.a(paramString);
      return;
    }
  }
  
  private void d(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (paramUdcUinData.uint32_bubble_unread_switch.has())
    {
      i = paramUdcUinData.uint32_bubble_unread_switch.get();
      paramUdcUinData = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      if (paramUdcUinData != null)
      {
        paramUdcUinData = paramUdcUinData.a;
        if (i != 0) {
          break label86;
        }
      }
    }
    label86:
    for (boolean bool = true;; bool = false)
    {
      paramUdcUinData.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d(ApolloExtensionHandlerImpl.b, 1, "uint32_bubble_unread_switch : " + i);
      }
      return;
    }
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIApolloExtensionHandler == null) || (paramIApolloExtensionHandler.a() == null)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler = paramIApolloExtensionHandler;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramIApolloExtensionHandler.a();
      a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    finally
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionHandler = null;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(ApolloExtensionHandlerImpl.b, 2, "handleNamePlateOfKingInfo : uin = " + paramString + ", gameId = " + paramLong1 + ", gameLoginTime = " + paramLong2 + ", dan = " + paramInt1 + ", dansSwitch = " + paramInt2);
    }
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = ((FriendsManager)localObject).a(paramString);
    localObject = ((FriendsManager)localObject).e(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramString)))
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
      String str = "plate_of_king_display_switch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      if (paramInt2 == 1)
      {
        bool1 = true;
        localEditor.putBoolean(str, bool1).apply();
      }
    }
    else if (localCard != null)
    {
      localCard.namePlateOfKingGameId = paramLong1;
      localCard.namePlateOfKingLoginTime = paramLong2;
      localCard.namePlateOfKingDan = paramInt1;
      if (paramInt2 != 1) {
        break label331;
      }
    }
    label331:
    for (boolean bool1 = true;; bool1 = false)
    {
      localCard.namePlateOfKingDanDisplatSwitch = bool1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, localCard);
      if (localObject != null)
      {
        ((Friends)localObject).namePlateOfKingGameId = paramLong1;
        ((Friends)localObject).namePlateOfKingLoginTime = paramLong2;
        ((Friends)localObject).namePlateOfKingDan = paramInt1;
        bool1 = bool2;
        if (paramInt2 == 1) {
          bool1 = true;
        }
        ((Friends)localObject).namePlateOfKingDanDisplatSwitch = bool1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramString);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void a(String paramString, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (a(paramUdcUinData.roam_flag_svip_5year)) {
      i = 5;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ApolloExtensionHandlerImpl.b, 2, "onGetRoamType: " + i);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_flag" + paramString, i).commit();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(114, true, new Object[] { paramString, Integer.valueOf(i) });
      return;
      if ((a(paramUdcUinData.roam_flag_svip_2year)) || (a(paramUdcUinData.roam_flag_svip_forever))) {
        i = 4;
      } else if (a(paramUdcUinData.roam_flag_vip_30day)) {
        i = 3;
      } else if (a(paramUdcUinData.roam_flag_qq_7day)) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.handler.GetStrangerVasInfoHandler
 * JD-Core Version:    0.7.0.1
 */