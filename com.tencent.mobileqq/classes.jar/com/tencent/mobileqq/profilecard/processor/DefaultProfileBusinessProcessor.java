package com.tencent.mobileqq.profilecard.processor;

import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AddFrdSrcInfo;
import SummaryCard.BindPhoneInfo;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import SummaryCard.TCoverInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profilecard.utils.ProfileCodecUtils;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.schoolInfo;
import com.tencent.pb.personal.PersonalInfo.ReqBody;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.Color;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.Label;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.rich_ui;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.ui_info;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class DefaultProfileBusinessProcessor
  extends AbsProfileBusinessProcessor
{
  private static final String TAG = "DefaultProfileBusinessProcessor";
  private DefaultProfileBusinessProcessor.ProfileLocationCodes profileLocationCodes;
  
  public DefaultProfileBusinessProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void handleGetDetailInfoInner1(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, DefaultProfileBusinessProcessor.ProfileLocationCodes paramProfileLocationCodes)
  {
    int i;
    switch (paramShort1)
    {
    default: 
      return;
    case 20002: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strNick = new String(paramLong);
      return;
    case 20009: 
      paramShort1 = paramByteBuffer.get();
      if (paramShort1 == 1)
      {
        paramCard.shGender = 0;
        return;
      }
      if (paramShort1 == 2)
      {
        paramCard.shGender = 1;
        return;
      }
      paramCard.shGender = -1;
      return;
    case 27037: 
      paramCard.iProfession = paramByteBuffer.getInt();
      return;
    case 20031: 
      paramCard.lBirthday = paramByteBuffer.getInt();
      if (paramCard.lBirthday == 0L)
      {
        paramCard.constellation = 0;
        return;
      }
      paramCard.constellation = Utils.a((int)((paramCard.lBirthday & 0xFF00) >> 8), (int)(paramCard.lBirthday & 0xFF));
      return;
    case 24008: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strCompany = new String(paramLong);
      return;
    case 24002: 
      paramShort1 = paramByteBuffer.getInt();
      paramShort2 = paramByteBuffer.getInt();
      i = paramByteBuffer.getInt();
      paramProfileLocationCodes.gotHometown = true;
      paramProfileLocationCodes.homeCountryCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
      paramProfileLocationCodes.homeProvinceCode = ProfileCodecUtils.decodeRemoteCode(paramShort2);
      paramProfileLocationCodes.homeCityCode = ProfileCodecUtils.decodeRemoteCode(i);
      return;
    case 20043: 
      paramShort1 = paramByteBuffer.getInt();
      paramProfileLocationCodes.gotHometown = true;
      paramProfileLocationCodes.homeDistrictCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
      return;
    case 20032: 
      paramShort1 = paramByteBuffer.getInt();
      paramShort2 = paramByteBuffer.getInt();
      i = paramByteBuffer.getInt();
      paramProfileLocationCodes.gotLocation = true;
      paramProfileLocationCodes.locCountryCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
      paramProfileLocationCodes.locProvinceCode = ProfileCodecUtils.decodeRemoteCode(paramShort2);
      paramProfileLocationCodes.locCityCode = ProfileCodecUtils.decodeRemoteCode(i);
      return;
    case 20041: 
      paramShort1 = paramByteBuffer.getInt();
      paramProfileLocationCodes.gotLocation = true;
      paramProfileLocationCodes.locDistrictCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
      return;
    case 20011: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strEmail = new String(paramLong);
      return;
    case 20019: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strPersonalNote = new String(paramLong);
      return;
    case 20021: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strSchool = new String(paramLong);
      return;
    case 20037: 
      paramCard.age = paramByteBuffer.get();
      return;
    }
    paramCard.constellation = paramByteBuffer.get();
  }
  
  private void handleGetDetailInfoInner2(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard)
  {
    switch (paramShort1)
    {
    default: 
      return;
    case -23196: 
      paramCard.switchMusicBox = paramByteBuffer.getShort();
      return;
    case -23364: 
      if (paramByteBuffer.getShort() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramCard.isShowCard = bool;
        return;
      }
    case -23180: 
      paramCard.switchStickyNote = paramByteBuffer.getShort();
      return;
    case -23175: 
      paramCard.switchQQCircle = paramByteBuffer.getShort();
      return;
    case -23169: 
      paramCard.switchLifeAchievement = paramByteBuffer.getShort();
      return;
    }
    paramCard.switchWeiShi = paramByteBuffer.getShort();
  }
  
  private void processProfileCardWithCover(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    if (paramRespSummaryCard.stCoverInfo != null)
    {
      paramCard.updateCoverData(paramRespSummaryCard.stCoverInfo.vTagInfo);
      if (QLog.isColorLevel()) {
        QLog.d("DefaultProfileBusinessProcessor", 2, String.format("processProfileCardWithCover coverInfo.url=", new Object[] { paramCard.getCoverData(0)[0] }));
      }
    }
  }
  
  private void processProfileCardWithDiamonds(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    if (paramRespSummaryCard.stDiamonds != null)
    {
      paramRespSummaryCard = paramRespSummaryCard.stDiamonds.getMOpenInfo();
      if (paramRespSummaryCard != null)
      {
        VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramRespSummaryCard.get(Integer.valueOf(101));
        if (localVipOpenInfo != null)
        {
          if (localVipOpenInfo.bOpen)
          {
            paramCard.isRedDiamond = true;
            if ((localVipOpenInfo.iVipFlag & 0x1) > 0) {
              paramCard.isSuperRedDiamond = true;
            }
          }
          paramCard.redLevel = localVipOpenInfo.iVipLevel;
        }
        localVipOpenInfo = (VipOpenInfo)paramRespSummaryCard.get(Integer.valueOf(102));
        if (localVipOpenInfo != null)
        {
          if (localVipOpenInfo.bOpen)
          {
            paramCard.isYellowDiamond = true;
            if ((localVipOpenInfo.iVipFlag & 0x1) > 0) {
              paramCard.isSuperYellowDiamond = true;
            }
          }
          paramCard.yellowLevel = localVipOpenInfo.iVipLevel;
        }
        paramRespSummaryCard = (VipOpenInfo)paramRespSummaryCard.get(Integer.valueOf(103));
        if (paramRespSummaryCard != null)
        {
          if (paramRespSummaryCard.bOpen)
          {
            paramCard.isGreenDiamond = true;
            if ((paramRespSummaryCard.iVipFlag & 0x1) > 0) {
              paramCard.isSuperGreenDiamond = true;
            }
          }
          paramCard.greenLevel = paramRespSummaryCard.iVipLevel;
        }
      }
    }
  }
  
  private void processProfileCardWithExtendFriend(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    if (paramRespSummaryCard.vExtendCard != null) {}
    for (;;)
    {
      try
      {
        Object localObject = new GetExtendFriendInfo.RspBody();
        ((GetExtendFriendInfo.RspBody)localObject).mergeFrom(paramRespSummaryCard.vExtendCard);
        if (((GetExtendFriendInfo.RspBody)localObject).bytes_declaration.has())
        {
          paramRespSummaryCard = ((GetExtendFriendInfo.RspBody)localObject).bytes_declaration.get().toStringUtf8();
          if (!((GetExtendFriendInfo.RspBody)localObject).bytes_voice_url.has()) {
            break label519;
          }
          str = ((GetExtendFriendInfo.RspBody)localObject).bytes_voice_url.get().toStringUtf8();
          if (!((GetExtendFriendInfo.RspBody)localObject).uint32_popularity.has()) {
            break label525;
          }
          i = ((GetExtendFriendInfo.RspBody)localObject).uint32_popularity.get();
          if (!((GetExtendFriendInfo.RspBody)localObject).uint64_update_time.has()) {
            break label530;
          }
          l = ((GetExtendFriendInfo.RspBody)localObject).uint64_update_time.get();
          if (!((GetExtendFriendInfo.RspBody)localObject).uint32_voice_duration.has()) {
            break label536;
          }
          j = ((GetExtendFriendInfo.RspBody)localObject).uint32_voice_duration.get();
          PersonalInfo.ReqBody localReqBody = new PersonalInfo.ReqBody();
          localReqBody.mergeFrom(((GetExtendFriendInfo.RspBody)localObject).bytes_personalization.get().toByteArray());
          int k = localReqBody.fontid.get();
          int m = localReqBody.fonttype.get();
          int n = localReqBody.itemid.get();
          paramCard.fontId = k;
          paramCard.fontType = m;
          paramCard.clothesId = n;
          paramCard.declaration = paramRespSummaryCard;
          paramCard.popularity = i;
          paramCard.voiceUrl = str;
          paramCard.updateTime = l;
          paramCard.extendFriendVoiceDuration = j;
          if ((((GetExtendFriendInfo.RspBody)localObject).rpt_school_info.has()) && (((GetExtendFriendInfo.schoolInfo)((GetExtendFriendInfo.RspBody)localObject).rpt_school_info.get().get(0)).has()))
          {
            localObject = (GetExtendFriendInfo.schoolInfo)((GetExtendFriendInfo.RspBody)localObject).rpt_school_info.get().get(0);
            paramCard.schoolId = ((GetExtendFriendInfo.schoolInfo)localObject).str_school_id.get();
            paramCard.schoolName = ((GetExtendFriendInfo.schoolInfo)localObject).str_school_name.get();
            paramCard.authState = ((GetExtendFriendInfo.schoolInfo)localObject).uint64_state.get();
            paramCard.idx = ((GetExtendFriendInfo.schoolInfo)localObject).uint32_idx.get();
            paramCard.category = ((GetExtendFriendInfo.schoolInfo)localObject).uint32_category.get();
            if (QLog.isColorLevel())
            {
              QLog.d("DefaultProfileBusinessProcessor", 2, String.format("processProfileCardWithExtendFriend popularity=%s declaration=%s voiceUrl=%s updateTime=%s duration=%s fontId=%s fontType=%s clothesId=%s", new Object[] { Integer.valueOf(i), paramRespSummaryCard, str, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
              QLog.d("DefaultProfileBusinessProcessor", 2, String.format("processProfileCardWithExtendFriend schoolName=%s schoolId=%s authState=%s", new Object[] { paramCard.schoolName, paramCard.schoolId, Long.valueOf(paramCard.authState) }));
            }
          }
          else
          {
            paramCard.schoolId = null;
            paramCard.schoolName = null;
            paramCard.authState = -1L;
            paramCard.idx = -1;
            paramCard.category = -1;
            continue;
          }
          return;
        }
      }
      catch (Exception paramCard)
      {
        QLog.e("DefaultProfileBusinessProcessor", 1, "", paramCard);
      }
      paramRespSummaryCard = null;
      continue;
      label519:
      String str = null;
      continue;
      label525:
      int i = 0;
      continue;
      label530:
      long l = 0L;
      continue;
      label536:
      int j = 0;
    }
  }
  
  private void processProfileCardWithGetControl(Card paramCard, RespSummaryCard paramRespSummaryCard, long paramLong, String paramString)
  {
    if ((1L & paramLong) != 0L)
    {
      paramCard.strShowName = paramRespSummaryCard.strShowName;
      if (TextUtils.isEmpty(paramCard.strShowName)) {
        paramCard.strShowName = paramString;
      }
    }
    if ((0x4 & paramLong) != 0L)
    {
      paramCard.vRichSign = paramRespSummaryCard.vRichSign;
      paramCard.lSignModifyTime = paramRespSummaryCard.uSignModifyTime;
    }
    if ((0x10000 & paramLong) != 0L) {
      paramCard.vLongNickTopicInfo = paramRespSummaryCard.vLongNickTopicInfo;
    }
    if ((0x10 & paramLong) != 0L)
    {
      paramCard.lLoginDays = paramRespSummaryCard.uLoginDays;
      paramCard.strLoginDaysDesc = paramRespSummaryCard.strLoginDesc;
    }
    if ((0x8 & paramLong) != 0L)
    {
      paramCard.lUserFlag = paramRespSummaryCard.lUserFlag;
      if ((paramCard.lUserFlag & 0x8) == 0L) {
        break label180;
      }
      bool = true;
      paramCard.allowClick = bool;
      if (!paramString.equals(this.appRuntime.getAccount())) {
        if ((paramCard.lUserFlag & 0x10) == 0L) {
          break label186;
        }
      }
    }
    label180:
    label186:
    for (boolean bool = true;; bool = false)
    {
      paramCard.allowPeopleSee = bool;
      return;
      bool = false;
      break;
    }
  }
  
  private void processProfileCardWithHobbies(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i;
    Object localObject1;
    int j;
    label60:
    label82:
    int k;
    Object localObject2;
    if ((paramRespSummaryCard.vvRespServicesBigOrder != null) && (paramRespSummaryCard.vvRespServicesBigOrder.size() > 0))
    {
      i = 0;
      if (i < paramRespSummaryCard.vvRespServicesBigOrder.size())
      {
        localObject1 = (byte[])paramRespSummaryCard.vvRespServicesBigOrder.get(i);
        if (localObject1 == null)
        {
          j = 0;
          if (j > 10) {
            break label82;
          }
        }
        do
        {
          i += 1;
          break;
          j = localObject1.length;
          break label60;
          k = (int)PkgTools.getLongData((byte[])localObject1, 1);
          int m = (int)PkgTools.getLongData((byte[])localObject1, 5);
        } while ((k <= 0) || (k + 9 >= j));
        localObject2 = new byte[k];
        PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, 9, k);
        localObject1 = new SummaryCardBusiEntry.comm();
      }
    }
    for (;;)
    {
      ArrayList localArrayList2;
      ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem;
      ArrayList localArrayList3;
      try
      {
        ((SummaryCardBusiEntry.comm)localObject1).mergeFrom((byte[])localObject2);
        j = ((SummaryCardBusiEntry.comm)localObject1).result.get();
        localObject2 = new ProfileSummaryHobbiesEntry();
        if (j != 0) {
          break label744;
        }
        ((ProfileSummaryHobbiesEntry)localObject2).strName = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strName.get();
        ((ProfileSummaryHobbiesEntry)localObject2).strServiceUrl = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strServiceUrl.get();
        ((ProfileSummaryHobbiesEntry)localObject2).serviceType = ((SummaryCardBusiEntry.comm)localObject1).service.get();
        localArrayList2 = new ArrayList();
        j = 0;
        if (j >= ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.size()) {
          break label737;
        }
        SummaryCardBusiEntry.ui_info localui_info = (SummaryCardBusiEntry.ui_info)((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.get(j);
        localProfileSummaryHobbiesItem = new ProfileSummaryHobbiesItem();
        localProfileSummaryHobbiesItem.strTitle = localui_info.strTitle.get();
        localProfileSummaryHobbiesItem.strCoverUrl = localui_info.strCoverUrl.get();
        localProfileSummaryHobbiesItem.strJmpUrl = localui_info.strJmpUrl.get();
        localProfileSummaryHobbiesItem.strSubInfo = localui_info.strSubInfo.get();
        localProfileSummaryHobbiesItem.strDesc = localui_info.strDesc.get();
        localProfileSummaryHobbiesItem.strTitleIconUrl = localui_info.strTitleIconUrl.get();
        localProfileSummaryHobbiesItem.groupCode = localui_info.uint64_group_code.get();
        localProfileSummaryHobbiesItem.serviceType = ((ProfileSummaryHobbiesEntry)localObject2).serviceType;
        if (i == 0)
        {
          if (j == 0) {
            localProfileSummaryHobbiesItem.service = 0;
          }
        }
        else
        {
          if (localui_info.rptGroupTagList.size() <= 0) {
            break label677;
          }
          localArrayList3 = new ArrayList();
          k = 0;
          if (k >= localui_info.rptGroupTagList.size()) {
            break label670;
          }
          SummaryCardBusiEntry.Label localLabel = (SummaryCardBusiEntry.Label)localui_info.rptGroupTagList.get(k);
          ProfileGroupLabel localProfileGroupLabel = new ProfileGroupLabel();
          localProfileGroupLabel.strWording = localLabel.bytes_name.get().toStringUtf8();
          localProfileGroupLabel.type = localLabel.uint32_label_type.get();
          localProfileGroupLabel.attr = localLabel.uint32_label_attr.get();
          ProfileColor localProfileColor = new ProfileColor();
          localProfileColor.red = localLabel.edging_color.uint32_r.get();
          localProfileColor.green = localLabel.edging_color.uint32_g.get();
          localProfileColor.blue = localLabel.edging_color.uint32_b.get();
          localProfileGroupLabel.edgingColor = localProfileColor;
          localProfileColor = new ProfileColor();
          localProfileColor.red = localLabel.text_color.uint32_r.get();
          localProfileColor.green = localLabel.text_color.uint32_g.get();
          localProfileColor.blue = localLabel.text_color.uint32_b.get();
          localProfileGroupLabel.textColor = localProfileColor;
          localArrayList3.add(localProfileGroupLabel);
          k += 1;
          continue;
        }
        localProfileSummaryHobbiesItem.service = 1;
        continue;
      }
      catch (Exception localException)
      {
        QLog.e("DefaultProfileBusinessProcessor", 1, "processProfileCardWithHobbies fail.", localException);
      }
      label670:
      localProfileSummaryHobbiesItem.labels = localArrayList3;
      label677:
      localArrayList2.add(localProfileSummaryHobbiesItem);
      if (QLog.isColorLevel())
      {
        QLog.d("DefaultProfileBusinessProcessor", 2, String.format("HobbiesEntry Item strTitle=%s serviceType=%s strJmpUrl=%s", new Object[] { localProfileSummaryHobbiesItem.strTitle, Integer.valueOf(localProfileSummaryHobbiesItem.serviceType), localProfileSummaryHobbiesItem.strJmpUrl }));
        break label810;
        label737:
        ((ProfileSummaryHobbiesEntry)localObject2).sProfileSummaryHobbiesItem = localArrayList2;
        label744:
        localArrayList1.add(localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("DefaultProfileBusinessProcessor", 2, String.format("HobbiesEntry strName=%s strServiceType=%s strServiceUrl=%s", new Object[] { ((ProfileSummaryHobbiesEntry)localObject2).strName, ((ProfileSummaryHobbiesEntry)localObject2).strServiceType, ((ProfileSummaryHobbiesEntry)localObject2).strServiceUrl }));
        break;
        paramCard.saveBigOrderEntrys(localArrayList1);
        return;
      }
      label810:
      j += 1;
    }
  }
  
  private void processProfileCardWithVisitingCard(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    if (paramRespSummaryCard.stAddFrdSrcInfo != null)
    {
      paramCard.addSrcName = paramRespSummaryCard.stAddFrdSrcInfo.strSrcName;
      paramCard.addSrcId = paramRespSummaryCard.stAddFrdSrcInfo.uSrcId;
      paramCard.addSubSrcId = paramRespSummaryCard.stAddFrdSrcInfo.uSubSrcId;
    }
    if (paramRespSummaryCard.stBindPhoneInfo != null) {
      paramCard.bindPhoneInfo = paramRespSummaryCard.stBindPhoneInfo.strName;
    }
    if (paramRespSummaryCard.vVisitingCardInfo != null) {
      paramCard.bCardInfo = paramRespSummaryCard.vVisitingCardInfo;
    }
  }
  
  public void onGetProfileDetailRequestForLogin(List<Short> paramList)
  {
    paramList.add(Short.valueOf((short)20031));
    paramList.add(Short.valueOf((short)20037));
    paramList.add(Short.valueOf((short)20009));
    paramList.add(Short.valueOf((short)20032));
    paramList.add(Short.valueOf((short)20041));
    paramList.add(Short.valueOf((short)-25217));
    paramList.add(Short.valueOf((short)-23754));
    paramList.add(Short.valueOf((short)-24980));
    paramList.add(Short.valueOf((short)-23723));
    paramList.add(Short.valueOf((short)27055));
    paramList.add(Short.valueOf((short)-23776));
    paramList.add(Short.valueOf((short)-23488));
    paramList.add(Short.valueOf((short)27034));
    paramList.add(Short.valueOf((short)-23753));
    paramList.add(Short.valueOf((short)-25200));
    paramList.add(Short.valueOf((short)-23533));
    paramList.add(Short.valueOf((short)-23537));
    paramList.add(Short.valueOf((short)-22556));
    paramList.add(Short.valueOf((short)27059));
    paramList.add(Short.valueOf((short)-25019));
    paramList.add(Short.valueOf((short)-23306));
    paramList.add(Short.valueOf((short)27206));
    paramList.add(Short.valueOf((short)27210));
    paramList.add(Short.valueOf((short)-23543));
    paramList.add(Short.valueOf((short)-23538));
    paramList.add(Short.valueOf((short)-25042));
    paramList.add(Short.valueOf((short)-25181));
    paramList.add(Short.valueOf((short)-23502));
    paramList.add(Short.valueOf((short)-23461));
    paramList.add(Short.valueOf((short)-25188));
    paramList.add(Short.valueOf((short)-23282));
    paramList.add(Short.valueOf((short)-25155));
    paramList.add(Short.valueOf((short)-23456));
    paramList.add(Short.valueOf((short)-23366));
    paramList.add(Short.valueOf((short)-23364));
    paramList.add(Short.valueOf((short)-23322));
    paramList.add(Short.valueOf((short)-23326));
    paramList.add(Short.valueOf((short)-23325));
    paramList.add(Short.valueOf((short)27245));
    paramList.add(Short.valueOf((short)-23332));
    paramList.add(Short.valueOf((short)-23308));
    paramList.add(Short.valueOf((short)-23309));
    paramList.add(Short.valueOf((short)-23310));
    paramList.add(Short.valueOf((short)-23166));
    paramList.add(Short.valueOf((short)-23312));
    paramList.add(Short.valueOf((short)-23168));
    paramList.add(Short.valueOf((short)-23158));
    paramList.add(Short.valueOf((short)-23161));
    paramList.add(Short.valueOf((short)-23249));
    paramList.add(Short.valueOf((short)-23221));
    paramList.add(Short.valueOf((short)-23172));
    paramList.add(Short.valueOf((short)-23046));
    paramList.add(Short.valueOf((short)-23106));
    paramList.add(Short.valueOf((short)-23108));
    paramList.add(Short.valueOf((short)-23107));
    paramList.add(Short.valueOf((short)-23143));
    paramList.add(Short.valueOf((short)-23103));
    paramList.add(Short.valueOf((short)-23102));
    paramList.add(Short.valueOf((short)27390));
  }
  
  public void onGetProfileDetailResponseBegin(Bundle paramBundle)
  {
    this.profileLocationCodes = null;
  }
  
  public void onGetProfileDetailTLV(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    handleGetDetailInfoInner1(paramByteBuffer, paramShort1, paramShort2, Long.valueOf(paramLong), paramCard, this.profileLocationCodes);
    handleGetDetailInfoInner2(paramByteBuffer, paramShort1, paramShort2, Long.valueOf(paramLong), paramCard);
  }
  
  public void onGetProfileDetailTLVBegin(Bundle paramBundle, long paramLong, Card paramCard)
  {
    this.profileLocationCodes = new DefaultProfileBusinessProcessor.ProfileLocationCodes(null);
  }
  
  public void onGetProfileDetailTLVEnd(Bundle paramBundle, long paramLong, Card paramCard)
  {
    this.profileLocationCodes.getLocationCodes(paramCard);
    if ((this.profileLocationCodes.gotLocation) || (this.profileLocationCodes.gotHometown)) {
      paramBundle.putBoolean("parse_profile_location", true);
    }
  }
  
  public void onProcessProfileCard(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard)
  {
    long l1 = paramBundle.getLong("targetUin");
    int i = paramBundle.getInt("comeFromType");
    long l2 = paramBundle.getLong("getControl");
    paramCard.iQQLevel = paramRespSummaryCard.iLevel;
    paramCard.strNick = paramRespSummaryCard.strNick;
    paramCard.shGender = ((short)paramRespSummaryCard.bSex);
    paramCard.uCurMulType = paramRespSummaryCard.uCurMulType;
    paramCard.age = paramRespSummaryCard.bAge;
    paramCard.lBirthday = paramRespSummaryCard.iBirthday;
    paramCard.strEmail = paramRespSummaryCard.strEmail;
    paramCard.nFaceID = paramRespSummaryCard.iFace;
    paramCard.strSign = paramRespSummaryCard.strSign;
    paramCard.strCity = paramRespSummaryCard.strCity;
    paramCard.strProvince = paramRespSummaryCard.strProvince;
    paramCard.strCountry = paramRespSummaryCard.strCountry;
    paramCard.strReMark = paramRespSummaryCard.strRemark;
    paramCard.strMobile = paramRespSummaryCard.strMobile;
    paramCard.strContactName = paramRespSummaryCard.strContactName;
    paramCard.strStatus = paramRespSummaryCard.strStatus;
    paramCard.strAutoRemark = paramRespSummaryCard.strAutoRemark;
    paramCard.vSeed = paramRespSummaryCard.vSeed;
    paramCard.lVisitCount = paramRespSummaryCard.iVoteCount;
    paramCard.lQQMasterLogindays = paramRespSummaryCard.uQQMasterLoginDays;
    paramCard.favoriteSource = i;
    if (i == 37) {
      paramCard.encId = paramBundle.getString("searchName");
    }
    paramCard.ulShowControl = ((int)paramRespSummaryCard.ulShowControl);
    if ((paramRespSummaryCard.ulShowControl & 1L) != 0L)
    {
      bool = true;
      paramCard.setFeedsShowFlag(bool);
      if ((paramRespSummaryCard.ulShowControl & 0x2) == 0L) {
        break label395;
      }
      bool = true;
      label282:
      paramCard.setPhotoShowFlag(bool);
      if ((paramRespSummaryCard.ulShowControl & 0x10) == 0L) {
        break label401;
      }
      bool = true;
      label305:
      paramCard.setXManFlag(bool);
      if (paramRespSummaryCard.lCacheControl == 0L) {
        break label407;
      }
    }
    label395:
    label401:
    label407:
    for (boolean bool = true;; bool = false)
    {
      paramCard.setPhotoUseCacheFlag(bool);
      paramCard.setVipInfo(paramRespSummaryCard.stVipInfo);
      processProfileCardWithGetControl(paramCard, paramRespSummaryCard, l2, String.valueOf(l1));
      processProfileCardWithCover(paramCard, paramRespSummaryCard);
      processProfileCardWithDiamonds(paramCard, paramRespSummaryCard);
      processProfileCardWithHobbies(paramCard, paramRespSummaryCard);
      processProfileCardWithVisitingCard(paramCard, paramRespSummaryCard);
      processProfileCardWithExtendFriend(paramCard, paramRespSummaryCard);
      return;
      bool = false;
      break;
      bool = false;
      break label282;
      bool = false;
      break label305;
    }
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    paramArrayList.add(new BusinessReqBuffer(2, null));
    paramArrayList.add(new BusinessReqBuffer(4, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.DefaultProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */