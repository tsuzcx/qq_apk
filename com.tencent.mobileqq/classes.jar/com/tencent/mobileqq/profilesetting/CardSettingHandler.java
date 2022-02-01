package com.tencent.mobileqq.profilesetting;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/CardSettingHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getCommandList", "", "", "handleGetCardDisplaySetting", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleSetCardDisplaySetting", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "res", "parseUdcUinBaseDataToCard", "udcData", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "card", "Lcom/tencent/mobileqq/data/Card;", "parseUdcUinOtherDataToCard", "reqGetCardDisplaySetting", "fieldIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "reqSetCardDisplaySetting", "items", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "setReqGetDisplaySettingTag", "fieldID", "body", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "setReqSetDisplaySettingTag", "state", "Ltencent/im/oidb/cmd0x587/oidb_0x587$ReqBody;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CardSettingHandler
  extends BusinessHandler
{
  public static final CardSettingHandler.Companion a = new CardSettingHandler.Companion(null);
  private final QQAppInterface b;
  
  public CardSettingHandler(@NotNull QQAppInterface paramQQAppInterface)
  {
    super((AppInterface)paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  private final void a(int paramInt1, int paramInt2, oidb_0x587.ReqBody paramReqBody)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 42505: 
      paramReqBody.uint32_profile_wz_game_card_switch.set(paramInt2);
      return;
    case 42488: 
      paramReqBody.uint32_profile_show_idol_switch.set(paramInt2);
      return;
    case 42425: 
      paramReqBody.uint32_profile_anonymous_answer_switch.set(paramInt2);
      return;
    case 42377: 
      paramReqBody.uint32_flag_profile_weishi_switch.set(paramInt2);
      return;
    case 42367: 
      paramReqBody.uint32_flag_profile_life_achievement_switch.set(paramInt2);
      return;
    case 42361: 
      paramReqBody.uint32_profile_qqcircle_switch.set(paramInt2);
      return;
    case 42356: 
      paramReqBody.uint32_profile_sticky_note_switch.set(paramInt2);
      return;
    case 42340: 
      paramReqBody.uint32_profile_musicbox_switch.set(paramInt2);
      return;
    case 42323: 
      paramReqBody.uint32_profile_miniapp_switch.set(paramInt2);
      return;
    case 42289: 
      paramReqBody.uint32_profile_present_switch.set(paramInt2);
      return;
    case 42172: 
      paramReqBody.uint32_extend_friend_card_shown.set(paramInt2);
      return;
    case 42128: 
      paramReqBody.uint32_profile_personality_label_switch.set(paramInt2);
      return;
    case 42075: 
      paramReqBody.uint32_req_medalwall_flag.set(paramInt2);
      return;
    case 41623: 
      paramReqBody.uint32_profile_personal_note_visible.set(paramInt2);
      return;
    case 41622: 
      paramReqBody.uint32_profile_email_visible.set(paramInt2);
      return;
    case 41619: 
      paramReqBody.uint32_profile_college_visible.set(paramInt2);
      return;
    case 41618: 
      paramReqBody.uint32_profile_profession_visible.set(paramInt2);
      return;
    case 41614: 
      paramReqBody.uint32_profile_location_visible.set(paramInt2);
      return;
    case 41613: 
      paramReqBody.uint32_profile_hometown_visible.set(paramInt2);
      return;
    case 41611: 
      paramReqBody.uint32_profile_sex_visible.set(paramInt2);
      return;
    case 41610: 
      paramReqBody.uint32_profile_age_visible.set(paramInt2);
      return;
    case 41609: 
      paramReqBody.uint32_profile_constellation_visible.set(paramInt2);
      return;
    case 41607: 
      paramReqBody.uint32_profile_birthday_visible.set(paramInt2);
      return;
    case 40314: 
      paramReqBody.uint32_profile_music_switch.set(paramInt2);
      return;
    case 40313: 
      paramReqBody.uint32_profile_interest_switch.set(paramInt2);
      return;
    }
    paramReqBody.uint32_profile_company_visible.set(paramInt2);
  }
  
  private final void a(int paramInt, oidb_0x5eb.ReqBody paramReqBody)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 42505: 
      paramReqBody.uint32_profile_wz_game_card_switch.set(1);
      return;
    case 42488: 
      paramReqBody.uint32_profile_show_idol_switch.set(1);
      return;
    case 42425: 
      paramReqBody.uint32_profile_anonymous_answer_switch.set(1);
      return;
    case 42377: 
      paramReqBody.uint32_flag_profile_weishi_switch.set(1);
      return;
    case 42367: 
      paramReqBody.uint32_flag_profile_life_achievement_switch.set(1);
      return;
    case 42361: 
      paramReqBody.uint32_profile_qqcircle_switch.set(1);
      return;
    case 42356: 
      paramReqBody.uint32_profile_sticky_note_switch.set(1);
      return;
    case 42340: 
      paramReqBody.uint32_profile_musicbox_switch.set(1);
      return;
    case 42323: 
      paramReqBody.uint32_profile_miniapp_switch.set(1);
      return;
    case 42289: 
      paramReqBody.uint32_profile_present_switch.set(1);
      return;
    case 42172: 
      paramReqBody.uint32_extend_friend_card_shown.set(1);
      return;
    case 42128: 
      paramReqBody.uint32_profile_personality_label_switch.set(1);
      return;
    case 42075: 
      paramReqBody.uint32_req_medalwall_flag.set(1);
      return;
    case 41623: 
      paramReqBody.uint32_profile_personal_note_visible.set(1);
      return;
    case 41622: 
      paramReqBody.uint32_profile_email_visible.set(1);
      return;
    case 41619: 
      paramReqBody.uint32_profile_college_visible.set(1);
      return;
    case 41618: 
      paramReqBody.uint32_profile_profession_visible.set(1);
      return;
    case 41614: 
      paramReqBody.uint32_profile_location_visible.set(1);
      return;
    case 41613: 
      paramReqBody.uint32_profile_hometown_visible.set(1);
      return;
    case 41611: 
      paramReqBody.uint32_profile_sex_visible.set(1);
      return;
    case 41610: 
      paramReqBody.uint32_profile_age_visible.set(1);
      return;
    case 41609: 
      paramReqBody.uint32_profile_constellation_visible.set(1);
      return;
    case 41607: 
      paramReqBody.uint32_profile_birthday_visible.set(1);
      return;
    case 40314: 
      paramReqBody.uint32_profile_music_switch.set(1);
      return;
    case 40313: 
      paramReqBody.uint32_profile_interest_switch.set(1);
      return;
    }
    paramReqBody.uint32_profile_company_visible.set(1);
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      Intrinsics.throwNpe();
    }
    if ((Intrinsics.areEqual(paramToServiceMsg.getAttribute("req_get_card_display_setting_tag"), Boolean.valueOf(true)) ^ true)) {
      return;
    }
    if (paramFromServiceMsg == null) {
      Intrinsics.throwNpe();
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg = paramToServiceMsg.getAttribute("uin");
    Object localObject1;
    int k;
    boolean bool3;
    int j;
    boolean bool2;
    int i;
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = (String)paramToServiceMsg;
      localObject1 = (CharSequence)paramToServiceMsg;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!TextUtils.equals((CharSequence)this.b.getCurrentAccountUin(), (CharSequence)localObject1)) {
          return;
        }
        k = paramFromServiceMsg.getResultCode();
        paramFromServiceMsg = this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramFromServiceMsg != null)
        {
          localObject1 = (FriendsManager)paramFromServiceMsg;
          paramFromServiceMsg = ((FriendsManager)localObject1).g(paramToServiceMsg);
          bool3 = bool1;
          j = k;
          if (bool1)
          {
            bool2 = bool1;
            i = k;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new oidb_sso.OIDBSSOPkg();
        if (paramObject != null)
        {
          bool2 = bool1;
          i = k;
          paramObject = ((oidb_sso.OIDBSSOPkg)localObject2).mergeFrom((byte[])paramObject);
          bool2 = bool1;
          i = k;
          Intrinsics.checkExpressionValueIsNotNull(paramObject, "pkg.mergeFrom(data as ByteArray)");
          bool2 = bool1;
          i = k;
          paramObject = (oidb_sso.OIDBSSOPkg)paramObject;
          bool2 = bool1;
          i = k;
          k = paramObject.uint32_result.get();
          bool2 = bool1;
          i = k;
          if (paramObject.uint32_result.get() != 0) {
            break label812;
          }
          bool1 = true;
          bool3 = bool1;
          j = k;
          if (bool1)
          {
            bool2 = bool1;
            i = k;
            bool3 = bool1;
            j = k;
            if (paramObject.bytes_bodybuffer.has())
            {
              bool2 = bool1;
              i = k;
              bool3 = bool1;
              j = k;
              if (paramObject.bytes_bodybuffer.get() != null)
              {
                bool2 = bool1;
                i = k;
                localObject2 = new oidb_0x5eb.RspBody();
                bool2 = bool1;
                i = k;
                ((oidb_0x5eb.RspBody)localObject2).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
                bool2 = bool1;
                i = k;
                bool3 = bool1;
                j = k;
                if (((oidb_0x5eb.RspBody)localObject2).rpt_msg_uin_data.has())
                {
                  bool2 = bool1;
                  i = k;
                  bool3 = bool1;
                  j = k;
                  if (((oidb_0x5eb.RspBody)localObject2).rpt_msg_uin_data.get().size() > 0)
                  {
                    bool2 = bool1;
                    i = k;
                    paramObject = (oidb_0x5eb.UdcUinData)((oidb_0x5eb.RspBody)localObject2).rpt_msg_uin_data.get().get(0);
                    bool2 = bool1;
                    i = k;
                    Intrinsics.checkExpressionValueIsNotNull(paramObject, "udcData");
                    bool2 = bool1;
                    i = k;
                    Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "card");
                    bool2 = bool1;
                    i = k;
                    a(paramObject, paramFromServiceMsg);
                    bool2 = bool1;
                    i = k;
                    b(paramObject, paramFromServiceMsg);
                    bool2 = bool1;
                    i = k;
                    ((FriendsManager)localObject1).a(paramFromServiceMsg);
                    bool2 = bool1;
                    i = k;
                    bool3 = bool1;
                    j = k;
                    if (QLog.isColorLevel())
                    {
                      bool2 = bool1;
                      i = k;
                      paramObject = new StringBuilder();
                      bool2 = bool1;
                      i = k;
                      paramObject.append("handleGetCardDisplaySetting size=");
                      bool2 = bool1;
                      i = k;
                      paramObject.append(paramFromServiceMsg.profileDisplaySettingStates.size());
                      bool2 = bool1;
                      i = k;
                      paramObject.append(" settingStates=");
                      bool2 = bool1;
                      i = k;
                      paramObject.append(paramFromServiceMsg.profileDisplaySettingStates);
                      bool2 = bool1;
                      i = k;
                      QLog.d("CardSettingHandler", 2, paramObject.toString());
                      bool3 = bool1;
                      j = k;
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          bool2 = bool1;
          i = k;
          throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
      }
      catch (Exception paramObject)
      {
        QLog.d("CardSettingHandler", 1, "handleGetCardDisplaySetting ex", (Throwable)paramObject);
        j = i;
        bool3 = bool2;
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetCardDisplaySetting success=");
        paramObject.append(bool3);
        paramObject.append(", uin=");
        paramObject.append(paramToServiceMsg);
        paramObject.append(", resultCode=");
        paramObject.append(j);
        QLog.d("CardSettingHandler", 2, paramObject.toString());
      }
      notifyUI(1, bool3, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
      return;
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      label812:
      bool1 = false;
    }
  }
  
  private final void a(oidb_0x5eb.UdcUinData paramUdcUinData, Card paramCard)
  {
    if (paramUdcUinData.uint32_profile_sex_visible.has()) {
      ProfileSettingUtils.a.a(41611, paramUdcUinData.uint32_profile_sex_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_age_visible.has()) {
      ProfileSettingUtils.a.a(41610, paramUdcUinData.uint32_profile_age_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_birthday_visible.has()) {
      ProfileSettingUtils.a.a(41607, paramUdcUinData.uint32_profile_birthday_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_constellation_visible.has()) {
      ProfileSettingUtils.a.a(41609, paramUdcUinData.uint32_profile_constellation_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_profession_visible.has()) {
      ProfileSettingUtils.a.a(41618, paramUdcUinData.uint32_profile_profession_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_college_visible.has()) {
      ProfileSettingUtils.a.a(41619, paramUdcUinData.uint32_profile_college_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_location_visible.has()) {
      ProfileSettingUtils.a.a(41614, paramUdcUinData.uint32_profile_location_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_hometown_visible.has()) {
      ProfileSettingUtils.a.a(41613, paramUdcUinData.uint32_profile_hometown_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_email_visible.has()) {
      ProfileSettingUtils.a.a(41622, paramUdcUinData.uint32_profile_email_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_personal_note_visible.has()) {
      ProfileSettingUtils.a.a(41623, paramUdcUinData.uint32_profile_personal_note_visible.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_company_visible.has()) {
      ProfileSettingUtils.a.a(40272, paramUdcUinData.uint32_profile_company_visible.get(), paramCard, this.b);
    }
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      Intrinsics.throwNpe();
    }
    if ((Intrinsics.areEqual(paramToServiceMsg.getAttribute("req_set_card_display_setting_tag"), Boolean.valueOf(true)) ^ true)) {
      return;
    }
    if (paramFromServiceMsg == null) {
      Intrinsics.throwNpe();
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject1 = paramToServiceMsg.getAttribute("uin");
    Object localObject2;
    int j;
    boolean bool2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = (String)localObject1;
      localObject2 = (CharSequence)localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!TextUtils.equals((CharSequence)this.b.getCurrentAccountUin(), (CharSequence)localObject2)) {
          return;
        }
        j = paramFromServiceMsg.getResultCode();
        paramFromServiceMsg = this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramFromServiceMsg != null)
        {
          localObject2 = (FriendsManager)paramFromServiceMsg;
          paramFromServiceMsg = ((FriendsManager)localObject2).g((String)localObject1);
          paramToServiceMsg = paramToServiceMsg.getAttribute("req_items");
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = (ArrayList)paramToServiceMsg;
            bool2 = bool1;
            i = j;
            if (bool1)
            {
              bool2 = bool1;
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new oidb_sso.OIDBSSOPkg();
        if (paramObject != null)
        {
          bool2 = bool1;
          i = j;
          paramObject = ((oidb_sso.OIDBSSOPkg)localObject3).mergeFrom((byte[])paramObject);
          bool2 = bool1;
          i = j;
          Intrinsics.checkExpressionValueIsNotNull(paramObject, "pkg.mergeFrom(data as ByteArray)");
          bool2 = bool1;
          i = j;
          paramObject = (oidb_sso.OIDBSSOPkg)paramObject;
          bool2 = bool1;
          i = j;
          j = paramObject.uint32_result.get();
          bool2 = bool1;
          i = j;
          if (paramObject.uint32_result.get() != 0) {
            break label654;
          }
          bool1 = true;
          bool2 = bool1;
          i = j;
          if (bool1)
          {
            bool2 = bool1;
            i = j;
            paramObject = paramToServiceMsg.iterator();
            bool2 = bool1;
            i = j;
            if (paramObject.hasNext())
            {
              bool2 = bool1;
              i = j;
              localObject3 = (ReqSetSettingItem)paramObject.next();
              bool2 = bool1;
              i = j;
              ProfileSettingUtils.Companion localCompanion = ProfileSettingUtils.a;
              bool2 = bool1;
              i = j;
              int k = ((ReqSetSettingItem)localObject3).a();
              bool2 = bool1;
              i = j;
              int m = ((ReqSetSettingItem)localObject3).c();
              bool2 = bool1;
              i = j;
              Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "card");
              bool2 = bool1;
              i = j;
              localCompanion.a(k, m, paramFromServiceMsg, this.b);
              continue;
            }
            bool2 = bool1;
            i = j;
            ((FriendsManager)localObject2).a(paramFromServiceMsg);
            bool2 = bool1;
            i = j;
          }
        }
        else
        {
          bool2 = bool1;
          i = j;
          throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
      }
      catch (Exception paramObject)
      {
        QLog.d("CardSettingHandler", 1, "handleSetCardDisplaySetting ex", (Throwable)paramObject);
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleSetCardDisplaySetting success=");
        paramObject.append(bool2);
        paramObject.append(", uin=");
        paramObject.append((String)localObject1);
        paramObject.append(", resultCode=");
        paramObject.append(i);
        paramObject.append(" reqItems=");
        paramObject.append(paramToServiceMsg);
        paramObject.append(" settingStates=");
        paramObject.append(paramFromServiceMsg.profileDisplaySettingStates);
        QLog.d("CardSettingHandler", 2, paramObject.toString());
      }
      notifyUI(2, bool2, new Object[] { localObject1, paramFromServiceMsg, paramToServiceMsg });
      return;
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mobileqq.profilesetting.ReqSetSettingItem> /* = java.util.ArrayList<com.tencent.mobileqq.profilesetting.ReqSetSettingItem> */");
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
      return;
      paramToServiceMsg = new TypeCastException("null cannot be cast to non-null type kotlin.String");
      for (;;)
      {
        throw paramToServiceMsg;
      }
      label654:
      bool1 = false;
    }
  }
  
  private final void b(oidb_0x5eb.UdcUinData paramUdcUinData, Card paramCard)
  {
    if (paramUdcUinData.uint32_req_medalwall_flag.has()) {
      ProfileSettingUtils.a.a(42075, paramUdcUinData.uint32_req_medalwall_flag.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_personality_label_switch.has()) {
      ProfileSettingUtils.a.a(42128, paramUdcUinData.uint32_profile_personality_label_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_life_achievement_switch.has()) {
      ProfileSettingUtils.a.a(42367, paramUdcUinData.uint32_profile_life_achievement_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_interest_switch.has()) {
      ProfileSettingUtils.a.a(40313, paramUdcUinData.uint32_profile_interest_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_music_switch.has()) {
      ProfileSettingUtils.a.a(40314, paramUdcUinData.uint32_profile_music_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_present_switch.has()) {
      ProfileSettingUtils.a.a(42289, paramUdcUinData.uint32_profile_present_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_miniapp_switch.has()) {
      ProfileSettingUtils.a.a(42323, paramUdcUinData.uint32_profile_miniapp_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_musicbox_switch.has()) {
      ProfileSettingUtils.a.a(42340, paramUdcUinData.uint32_profile_musicbox_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_sticky_note_switch.has()) {
      ProfileSettingUtils.a.a(42356, paramUdcUinData.uint32_profile_sticky_note_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_qqcircle_switch.has()) {
      ProfileSettingUtils.a.a(42361, paramUdcUinData.uint32_profile_qqcircle_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_weishi_switch.has()) {
      ProfileSettingUtils.a.a(42377, paramUdcUinData.uint32_profile_weishi_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_extend_friend_card_shown.has()) {
      ProfileSettingUtils.a.a(42172, paramUdcUinData.uint32_extend_friend_card_shown.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_anonymous_answer_switch.has()) {
      ProfileSettingUtils.a.a(42425, paramUdcUinData.uint32_profile_anonymous_answer_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_wz_game_card_switch.has()) {
      ProfileSettingUtils.a.a(42505, paramUdcUinData.uint32_profile_wz_game_card_switch.get(), paramCard, this.b);
    }
    if (paramUdcUinData.uint32_profile_show_idol_switch.has()) {
      ProfileSettingUtils.a.a(42488, paramUdcUinData.uint32_profile_show_idol_switch.get(), paramCard, this.b);
    }
  }
  
  public final void a(@NotNull ArrayList<Integer> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "fieldIds");
    String str = this.b.getCurrentAccountUin();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqGetCardDisplaySetting uin=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", size=");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append(", fieldIds=");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.i("CardSettingHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(str);
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        Intrinsics.checkExpressionValueIsNotNull(localInteger, "fieldId");
        a(localInteger.intValue(), (oidb_0x5eb.ReqBody)localObject);
      }
      paramArrayList = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      paramArrayList.addAttribute("uin", str);
      paramArrayList.addAttribute("req_get_card_display_setting_tag", Boolean.valueOf(true));
      sendPbReq(paramArrayList);
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("CardSettingHandler", 1, "reqGetCardDisplaySetting error:", (Throwable)paramArrayList);
    }
  }
  
  public final void b(@NotNull ArrayList<ReqSetSettingItem> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "items");
    String str = this.b.getCurrentAccountUin();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqSetCardDisplaySetting uin=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", size=");
      ((StringBuilder)localObject).append(paramArrayList.size());
      ((StringBuilder)localObject).append(", fieldIds=");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.i("CardSettingHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x587.ReqBody();
    try
    {
      long l = Long.parseLong(str);
      ((oidb_0x587.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ReqSetSettingItem localReqSetSettingItem = (ReqSetSettingItem)localIterator.next();
        a(localReqSetSettingItem.a(), localReqSetSettingItem.c(), (oidb_0x587.ReqBody)localObject);
      }
      localObject = makeOIDBPkg("OidbSvc.0x587_74", 1415, 74, ((oidb_0x587.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("uin", str);
      ((ToServiceMsg)localObject).addAttribute("req_set_card_display_setting_tag", Boolean.valueOf(true));
      ((ToServiceMsg)localObject).addAttribute("req_items", paramArrayList);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("CardSettingHandler", 1, "reqSetCardDisplaySetting error:", (Throwable)paramArrayList);
    }
  }
  
  @NotNull
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = ((Set)new HashSet());
      this.allowCmdSet.add("OidbSvc.0x5eb_22");
      this.allowCmdSet.add("OidbSvc.0x587_74");
    }
    Set localSet = this.allowCmdSet;
    Intrinsics.checkExpressionValueIsNotNull(localSet, "allowCmdSet");
    return localSet;
  }
  
  @NotNull
  protected Class<? extends BusinessObserver> observerClass()
  {
    return CardSettingObserver.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (msgCmdFilter(str)) {
      return;
    }
    if (str == null) {
      return;
    }
    int i = str.hashCode();
    if (i != -532178634)
    {
      if (i != -489339333) {
        return;
      }
      if (str.equals("OidbSvc.0x5eb_22")) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else if (str.equals("OidbSvc.0x587_74"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.CardSettingHandler
 * JD-Core Version:    0.7.0.1
 */