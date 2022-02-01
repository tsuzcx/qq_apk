package com.tencent.mobileqq.vas.handler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.IVasExtensionHandler;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
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
  private QQAppInterface a;
  private IApolloExtensionHandler b;
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetStrangerVasInfo ");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      localStringBuilder.append(", ");
      int i;
      if (paramArrayOfByte != null) {
        i = paramArrayOfByte.length;
      } else {
        i = -1;
      }
      localStringBuilder.append(i);
      QLog.d("GetStrangerVasInfoHandler", 2, localStringBuilder.toString());
    }
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
        ((BusinessHandler)this.b).notifyUI(65, false, null);
        return;
      }
      catch (Throwable paramIntent)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("GetStrangerVasInfoHandler", 2, "", paramIntent);
    }
    else
    {
      ((BusinessHandler)this.b).notifyUI(65, false, null);
    }
  }
  
  private void a(Intent paramIntent, oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if ((paramUdcUinData.uint64_game_appid.has()) && (paramUdcUinData.uint64_game_last_login_time.has()) && (paramUdcUinData.uint32_plate_of_king_dan.has()) && (paramUdcUinData.uint32_plate_of_king_dan_display_switch.has())) {
      a(paramString, paramUdcUinData.uint64_game_appid.get(), paramUdcUinData.uint64_game_last_login_time.get(), paramUdcUinData.uint32_plate_of_king_dan.get(), paramUdcUinData.uint32_plate_of_king_dan_display_switch.get());
    }
    if (paramIntent.getBooleanExtra("req_roam_type", false)) {
      a(paramString, paramUdcUinData);
    }
    if (paramIntent.getBooleanExtra("req_music_type", false)) {
      ((BusinessHandler)this.b).notifyUI(36, true, Integer.valueOf(paramUdcUinData.uint32_rsp_listen_together_player_id.get()));
    }
  }
  
  private void a(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
    localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    int k = localRspBody.rpt_msg_uin_data.size();
    HashSet localHashSet = new HashSet(k);
    ArrayList localArrayList1 = new ArrayList(k);
    ArrayList localArrayList2 = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramOIDBSSOPkg = ((VasExtensionManager)this.a.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).c;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("response.rpt_msg_uin_data.size():");
    ((StringBuilder)localObject).append(k);
    QLog.i("GetStrangerVasInfoHandler", 1, ((StringBuilder)localObject).toString());
    int i = 0;
    int j = 0;
    int m = 0;
    while (m < k)
    {
      oidb_0x5eb.UdcUinData localUdcUinData = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get(m);
      String str = String.valueOf(localUdcUinData.uint64_uin.get());
      localObject = localFriendsManager.x(str);
      ExtensionInfoLogUtils.a("GetStrangerVasInfoHandler", "GetStrangerVasInfoHandler，before update，friendManager.getExtensionInfo(uin)：", (ExtensionInfo)localObject);
      if (localObject == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = str;
        bool = true;
      }
      else
      {
        bool = false;
      }
      if (localUdcUinData.uint32_vas_font_id.has())
      {
        long l = localUdcUinData.uint32_vas_font_id.get();
        if (str.equals(this.a.getCurrentAccountUin()))
        {
          i = (int)FontManagerConstants.parseFontId(l);
          VasShieldFont.e = i;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleGetStrangerVasInfo: ");
            localStringBuilder.append(VasShieldFont.e);
            QLog.d("VasShieldFont", 2, localStringBuilder.toString());
          }
        }
        bool = a(bool, (ExtensionInfo)localObject, l);
      }
      a(localUdcUinData);
      if ((localUdcUinData.uint32_vas_diy_font_timestamp.has()) && (str.equals(this.a.getCurrentAccountUin()))) {
        j = localUdcUinData.uint32_vas_diy_font_timestamp.get();
      }
      boolean bool = a(localUdcUinData, c(localUdcUinData, a(localArrayList2, localUdcUinData, bool, str, (ExtensionInfo)localObject), str, (ExtensionInfo)localObject), (ExtensionInfo)localObject);
      b(localUdcUinData);
      c(localUdcUinData, str);
      b(localUdcUinData, str);
      d(localUdcUinData);
      a(localUdcUinData, str);
      c(localUdcUinData);
      a(paramIntent, localUdcUinData, str);
      if (bool)
      {
        ((ExtensionInfo)localObject).timestamp = System.currentTimeMillis();
        localHashSet.add(str);
        localArrayList1.add(localObject);
      }
      m += 1;
    }
    paramIntent = localArrayList1.iterator();
    while (paramIntent.hasNext()) {
      ExtensionInfoLogUtils.a("GetStrangerVasInfoHandler", "GetStrangerVasInfoHandler，after update and before bulkSaveOrUpdateExtensionInfo", (ExtensionInfo)paramIntent.next());
    }
    a(localFriendsManager, i, j, true);
    localFriendsManager.b(localArrayList1);
    paramOIDBSSOPkg.b(localArrayList2);
    paramOIDBSSOPkg.a(localArrayList1);
    ((BusinessHandler)this.b).notifyUI(65, true, localHashSet);
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0x5eb self has diy timestamp fontid = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" timestamp = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("FontManagerConstants", 2, ((StringBuilder)localObject).toString());
      }
      paramFriendsManager = paramFriendsManager.x(this.a.getCurrentAccountUin());
      Object localObject = (IFontManagerService)this.a.getRuntimeService(IFontManagerService.class, "");
      QQAppInterface localQQAppInterface = this.a;
      ((IFontManagerService)localObject).checkUpdateDIYConfig(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), paramFriendsManager, paramInt1, paramInt2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
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
    boolean bool2 = true;
    paramArrayOfString = (String[])((List)localObject2).toArray(new String[1]);
    j = paramArrayOfString.length;
    i = 0;
    while (i < j)
    {
      localObject2 = paramArrayOfString[i];
      try
      {
        long l = Long.parseLong((String)localObject2);
        ((oidb_0x5eb.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    i = 0;
    boolean bool1 = false;
    while (i < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[i] == 42255)
      {
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_qq_7day.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_vip_30day.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_2year.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_5year.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_forever.set(1);
        break label254;
      }
      a(paramArrayOfInt, (oidb_0x5eb.ReqBody)localObject1, i);
      bool1 = a(paramArrayOfInt, (oidb_0x5eb.ReqBody)localObject1, bool1, i);
      i += 1;
    }
    bool2 = false;
    label254:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchGetStrangerVasInfo, uins: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfString));
    localStringBuilder.append(" fields: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfInt));
    QLog.d("GetStrangerVasInfoHandler", 2, localStringBuilder.toString());
    paramArrayOfInt = new oidb_sso.OIDBSSOPkg();
    paramArrayOfInt.uint32_command.set(1515);
    paramArrayOfInt.uint32_service_type.set(paramInt);
    paramArrayOfInt.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(paramQQAppInterface.getApp(), ApolloClassFactoryApi.b());
    ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x5eb_99");
    ((NewIntent)localObject1).putExtra("data", paramArrayOfInt.toByteArray());
    ((NewIntent)localObject1).putExtra("req_roam_type", bool2);
    ((NewIntent)localObject1).putExtra("req_music_type", bool1);
    ((NewIntent)localObject1).putExtra("uins", paramArrayOfString);
    paramQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    try
    {
      if (paramUdcUinData.uint32_bubble_id.has())
      {
        int i = paramUdcUinData.uint32_bubble_id.get();
        ((ISVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(i);
        return;
      }
    }
    catch (Exception paramUdcUinData)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramUdcUinData.getMessage());
      QLog.e("GetStrangerVasInfoHandler", 1, localStringBuilder.toString());
    }
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if (paramUdcUinData.uint32_rsp_qq_level_icon_type.has())
    {
      int i = paramUdcUinData.uint32_rsp_qq_level_icon_type.get();
      paramUdcUinData = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("");
      paramString = paramUdcUinData.f(localStringBuilder.toString());
      if ((paramString != null) && (paramString.mQQLevelType != i))
      {
        paramString.mQQLevelType = i;
        paramUdcUinData.a(paramString);
        this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramString);
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, oidb_0x5eb.ReqBody paramReqBody, int paramInt)
  {
    int i = paramArrayOfInt[paramInt];
    if (i != 20059)
    {
      if (i != 27025)
      {
        if (i != 27041)
        {
          if (i != 27201)
          {
            if (i != 27217)
            {
              if (i != 27234)
              {
                if (i != 40530)
                {
                  if (i != 27224)
                  {
                    if (i == 27225) {
                      paramReqBody.uint32_game_appid.set(1);
                    }
                  }
                  else {
                    paramReqBody.uint32_game_last_login_time.set(1);
                  }
                }
                else {
                  paramReqBody.uint32_req_vas_magicfont_flag.set(1);
                }
              }
              else {
                paramReqBody.uint32_req_vas_voicebubble_id.set(1);
              }
            }
            else {
              paramReqBody.uint32_req_vas_praise_flag.set(1);
            }
          }
          else {
            paramReqBody.uint32_req_vas_font_id_flag.set(1);
          }
        }
        else {
          paramReqBody.uint32_req_vas_colorring_flag.set(1);
        }
      }
      else {
        paramReqBody.uint32_req_face_addon_id.set(1);
      }
    }
    else {
      paramReqBody.uint32_req_bubble_id.set(1);
    }
    b(paramArrayOfInt, paramReqBody, paramInt);
  }
  
  private boolean a(PBUInt32Field paramPBUInt32Field)
  {
    return (paramPBUInt32Field.has()) && (paramPBUInt32Field.get() == 1);
  }
  
  private boolean a(ArrayList<String> paramArrayList, oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    paramBoolean = a(paramUdcUinData, paramBoolean, paramString, paramExtensionInfo);
    int i;
    if (paramUdcUinData.uint32_vas_voicebubble_id.has())
    {
      i = paramUdcUinData.uint32_vas_voicebubble_id.get();
      if ((i > 0) && (String.valueOf(paramString).equals(this.a.getCurrentAccountUin())))
      {
        ((ISVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(i);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGetStrangerVasInfo uin= ");
          localStringBuilder.append(paramString);
          localStringBuilder.append("voice print bubble id = ");
          localStringBuilder.append(i);
          QLog.d("GetStrangerVasInfoHandler", 2, localStringBuilder.toString());
        }
      }
    }
    boolean bool = paramBoolean;
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
        paramArrayList = new StringBuilder();
        paramArrayList.append("uint32_vas_face_id uin: ");
        paramArrayList.append(paramString);
        paramArrayList.append(" oldId: ");
        paramArrayList.append(i);
        paramArrayList.append(" newId: ");
        paramArrayList.append(j);
        QLog.d("GetStrangerVasInfoHandler", 1, paramArrayList.toString());
        bool = paramBoolean;
      }
    }
    return b(paramUdcUinData, bool, paramString, paramExtensionInfo);
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
      long l1 = paramExtensionInfo.colorRingId;
      long l2 = i;
      paramBoolean = bool;
      if (l1 != l2)
      {
        paramExtensionInfo.colorRingId = l2;
        paramBoolean = true;
      }
    }
    if (paramUdcUinData.uint32_vas_praise_id.has())
    {
      i = paramUdcUinData.uint32_vas_praise_id.get();
      if ((i > 0) && (String.valueOf(paramString).equals(this.a.getCurrentAccountUin()))) {
        PraiseManager.a(this.a, i);
      }
      if (QLog.isColorLevel())
      {
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("handleGetStrangerVasInfo uin= ");
        paramUdcUinData.append(paramString);
        paramUdcUinData.append("praise id = ");
        paramUdcUinData.append(i);
        QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
      }
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean, ExtensionInfo paramExtensionInfo, long paramLong)
  {
    if ((FontManagerConstants.parseFontId(paramLong) != paramExtensionInfo.uVipFont) || (FontManagerConstants.parseFontType(paramLong) != paramExtensionInfo.vipFontType))
    {
      paramExtensionInfo.uVipFont = FontManagerConstants.parseFontId(paramLong);
      paramExtensionInfo.vipFontType = FontManagerConstants.parseFontType(paramLong);
      paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean a(int[] paramArrayOfInt, oidb_0x5eb.ReqBody paramReqBody, boolean paramBoolean, int paramInt)
  {
    switch (paramArrayOfInt[paramInt])
    {
    default: 
      return paramBoolean;
    case 45033: 
      paramReqBody.uint32_req_listen_together_player_id.set(1);
      return true;
    case 45000: 
      paramReqBody.uint32_bubble_unread_switch.set(1);
      return paramBoolean;
    case 42489: 
      paramReqBody.uint32_file_assist_top.set(1);
      return paramBoolean;
    case 42417: 
      paramReqBody.uint32_c2c_aio_shortcut_switch.set(1);
      return paramBoolean;
    case 42334: 
      paramReqBody.uint32_req_qq_level_icon_type_id.set(1);
      return paramBoolean;
    case 27375: 
      paramReqBody.uint32_req_vip_ext_id.set(1);
      return paramBoolean;
    }
    paramReqBody.uint32_req_theme_font_id.set(1);
    return paramBoolean;
  }
  
  private void b(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_c2c_aio_shortcut_switch.has())
    {
      int i = paramUdcUinData.uint32_c2c_aio_shortcut_switch.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      C2CShortcutBarSwitcher.a(this.a, bool);
    }
  }
  
  private void b(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if (paramUdcUinData.uint32_suspend_effect_id.has())
    {
      int i = paramUdcUinData.uint32_suspend_effect_id.get();
      if ((i >= 0) && (String.valueOf(paramString).equals(this.a.getCurrentAccountUin()))) {
        ((ISVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString, i);
      }
      if (QLog.isColorLevel())
      {
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("uint32_suspend_effect_id = ");
        paramUdcUinData.append(i);
        QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
      }
    }
  }
  
  private static void b(int[] paramArrayOfInt, oidb_0x5eb.ReqBody paramReqBody, int paramInt)
  {
    paramInt = paramArrayOfInt[paramInt];
    if (paramInt != 27235)
    {
      if (paramInt != 27236)
      {
        if (paramInt != 27238)
        {
          if (paramInt != 27241)
          {
            if (paramInt != 27254)
            {
              switch (paramInt)
              {
              default: 
                return;
              case 42122: 
                paramReqBody.uint32_plate_of_king_dan.set(1);
                return;
              }
              paramReqBody.uint32_plate_of_king_dan_display_switch.set(1);
              return;
            }
            paramReqBody.uint32_req_font_effect_id.set(1);
            return;
          }
          paramReqBody.uint32_req_vas_diy_font_timestamp_flag.set(1);
          return;
        }
        paramReqBody.uint32_req_vas_face_id.set(1);
        return;
      }
      paramReqBody.uint32_req_suspend_effect_id.set(1);
      return;
    }
    paramReqBody.uint32_req_vas_pendant_diy_id.set(1);
  }
  
  private boolean b(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
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
        if (paramString.equals(this.a.getCurrentAccountUin())) {
          ((ISVIPHandler)this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(i, false);
        }
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          paramUdcUinData = new StringBuilder();
          paramUdcUinData.append("handleGetStrangerVasInfo, uin=");
          paramUdcUinData.append(paramString);
          paramUdcUinData.append(", pendant=");
          paramUdcUinData.append(paramExtensionInfo.pendantId);
          paramUdcUinData.append(",font=");
          paramUdcUinData.append(paramExtensionInfo.uVipFont);
          paramUdcUinData.append(", fontType = ");
          paramUdcUinData.append(paramExtensionInfo.vipFontType);
          paramUdcUinData.append(", magicFont = ");
          paramUdcUinData.append(paramExtensionInfo.magicFont);
          paramUdcUinData.append(", colorRing = ");
          paramUdcUinData.append(paramExtensionInfo.colorRingId);
          paramUdcUinData.append(", pendantDiyId = ");
          paramUdcUinData.append(paramExtensionInfo.pendantDiyId);
          QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
          bool = paramBoolean;
        }
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
    if (paramUdcUinData.bytes_req_vip_ext_id.has())
    {
      Dialogue localDialogue = new Dialogue();
      localDialogue.mergeFrom(paramUdcUinData.bytes_req_vip_ext_id.get().toByteArray());
      if (QLog.isColorLevel())
      {
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("vip_card_extension id by refresh=");
        paramUdcUinData.append(localDialogue.nameplate_pendant_itemid);
        QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
      }
      paramUdcUinData = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramString = paramUdcUinData.m(paramString);
      if (paramString != null)
      {
        int i;
        if (localDialogue.nameplate_pendant_itemid.has()) {
          i = localDialogue.nameplate_pendant_itemid.get();
        } else {
          i = 0;
        }
        paramString.bigClubExtTemplateId = i;
        paramString.diyFontId = localDialogue.diyfontid.get();
        paramString.gameCardId = localDialogue.game_nameplate.get();
        paramUdcUinData.b(paramString);
      }
    }
  }
  
  private boolean c(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    if (paramUdcUinData.uint32_req_font_effect_id.has())
    {
      int i = paramUdcUinData.uint32_req_font_effect_id.get();
      if (QLog.isColorLevel())
      {
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("handleGetStrangerVasInfo uin = ");
        paramUdcUinData.append(paramString);
        paramUdcUinData.append(" fontEffect = ");
        paramUdcUinData.append(i);
        paramUdcUinData.append(" extInfo.fontEffect = ");
        paramUdcUinData.append(paramExtensionInfo.fontEffect);
        QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
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
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("handleGetStrangerVasInfo uin = ");
        paramUdcUinData.append(paramString);
        paramUdcUinData.append(" extInfo.fontEffect = ");
        paramUdcUinData.append(paramExtensionInfo.fontEffect);
        paramUdcUinData.append(" extInfo.fontEffectLastUpdateTime = ");
        paramUdcUinData.append(paramExtensionInfo.fontEffectLastUpdateTime);
        QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private void d(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_bubble_unread_switch.has())
    {
      int i = paramUdcUinData.uint32_bubble_unread_switch.get();
      paramUdcUinData = (BubbleManager)this.a.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      if (paramUdcUinData != null)
      {
        paramUdcUinData = paramUdcUinData.m;
        boolean bool;
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramUdcUinData.a(bool);
      }
      if (QLog.isColorLevel())
      {
        paramUdcUinData = new StringBuilder();
        paramUdcUinData.append("uint32_bubble_unread_switch : ");
        paramUdcUinData.append(i);
        QLog.d("GetStrangerVasInfoHandler", 1, paramUdcUinData.toString());
      }
    }
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramIApolloExtensionHandler != null)
    {
      if (paramIApolloExtensionHandler.e() == null) {
        return;
      }
      try
      {
        this.b = paramIApolloExtensionHandler;
        paramIApolloExtensionHandler = paramIApolloExtensionHandler.e();
        if ((paramIApolloExtensionHandler instanceof QQAppInterface)) {
          this.a = ((QQAppInterface)paramIApolloExtensionHandler);
        } else {
          QLog.e("GetStrangerVasInfoHandler", 1, "[handler] app interface is not instance of QQAppInterface!");
        }
        a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      finally
      {
        this.a = null;
        this.b = null;
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNamePlateOfKingInfo : uin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", gameId = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", gameLoginTime = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", dan = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", dansSwitch = ");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("GetStrangerVasInfoHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = ((FriendsManager)localObject2).f(paramString);
    localObject2 = ((FriendsManager)localObject2).m(paramString);
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if ((!bool1) && (this.a.getCurrentUin().equals(paramString)))
    {
      SharedPreferences.Editor localEditor = this.a.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("plate_of_king_display_switch_");
      ((StringBuilder)localObject3).append(this.a.getCurrentUin());
      localObject3 = ((StringBuilder)localObject3).toString();
      if (paramInt2 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localEditor.putBoolean((String)localObject3, bool1).apply();
    }
    if (localObject1 != null)
    {
      ((Card)localObject1).namePlateOfKingGameId = paramLong1;
      ((Card)localObject1).namePlateOfKingLoginTime = paramLong2;
      ((Card)localObject1).namePlateOfKingDan = paramInt1;
      if (paramInt2 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((Card)localObject1).namePlateOfKingDanDisplatSwitch = bool1;
      this.a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, localObject1);
    }
    if (localObject2 != null)
    {
      ((Friends)localObject2).namePlateOfKingGameId = paramLong1;
      ((Friends)localObject2).namePlateOfKingLoginTime = paramLong2;
      ((Friends)localObject2).namePlateOfKingDan = paramInt1;
      bool1 = bool2;
      if (paramInt2 == 1) {
        bool1 = true;
      }
      ((Friends)localObject2).namePlateOfKingDanDisplatSwitch = bool1;
      this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramString);
    }
  }
  
  protected void a(String paramString, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (a(paramUdcUinData.roam_flag_svip_5year)) {
      i = 5;
    } else if ((!a(paramUdcUinData.roam_flag_svip_2year)) && (!a(paramUdcUinData.roam_flag_svip_forever)))
    {
      if (a(paramUdcUinData.roam_flag_vip_30day)) {
        i = 3;
      } else if (a(paramUdcUinData.roam_flag_qq_7day)) {
        i = 2;
      } else {
        i = 1;
      }
    }
    else {
      i = 4;
    }
    if (QLog.isColorLevel())
    {
      paramUdcUinData = new StringBuilder();
      paramUdcUinData.append("onGetRoamType: ");
      paramUdcUinData.append(i);
      QLog.d("GetStrangerVasInfoHandler", 2, paramUdcUinData.toString());
    }
    paramUdcUinData = this.a.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(paramString);
    paramUdcUinData.putInt(localStringBuilder.toString(), i).commit();
    this.a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(114, true, new Object[] { paramString, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.handler.GetStrangerVasInfoHandler
 * JD-Core Version:    0.7.0.1
 */