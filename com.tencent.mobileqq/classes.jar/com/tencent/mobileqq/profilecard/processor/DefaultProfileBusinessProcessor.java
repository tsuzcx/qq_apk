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
    if (paramShort1 != 20002)
    {
      if (paramShort1 != 20009)
      {
        if (paramShort1 != 20011)
        {
          if (paramShort1 != 20019)
          {
            if (paramShort1 != 20037)
            {
              if (paramShort1 != 20041)
              {
                if (paramShort1 != 20043)
                {
                  if (paramShort1 != 24002)
                  {
                    if (paramShort1 != 24008)
                    {
                      if (paramShort1 != 27037)
                      {
                        if (paramShort1 != 20021)
                        {
                          if (paramShort1 != 20022)
                          {
                            if (paramShort1 != 20031)
                            {
                              if (paramShort1 != 20032) {
                                return;
                              }
                              paramShort1 = paramByteBuffer.getInt();
                              paramShort2 = paramByteBuffer.getInt();
                              i = paramByteBuffer.getInt();
                              paramProfileLocationCodes.gotLocation = true;
                              paramProfileLocationCodes.locCountryCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
                              paramProfileLocationCodes.locProvinceCode = ProfileCodecUtils.decodeRemoteCode(paramShort2);
                              paramProfileLocationCodes.locCityCode = ProfileCodecUtils.decodeRemoteCode(i);
                              return;
                            }
                            paramCard.lBirthday = paramByteBuffer.getInt();
                            if (paramCard.lBirthday == 0L)
                            {
                              paramCard.constellation = 0;
                              return;
                            }
                            paramCard.constellation = Utils.a((int)((paramCard.lBirthday & 0xFF00) >> 8), (int)(paramCard.lBirthday & 0xFF));
                            return;
                          }
                          paramCard.constellation = paramByteBuffer.get();
                          return;
                        }
                        paramLong = new byte[paramShort2];
                        paramByteBuffer.get(paramLong);
                        paramCard.strSchool = new String(paramLong);
                        return;
                      }
                      paramCard.iProfession = paramByteBuffer.getInt();
                      return;
                    }
                    paramLong = new byte[paramShort2];
                    paramByteBuffer.get(paramLong);
                    paramCard.strCompany = new String(paramLong);
                    return;
                  }
                  paramShort1 = paramByteBuffer.getInt();
                  paramShort2 = paramByteBuffer.getInt();
                  int i = paramByteBuffer.getInt();
                  paramProfileLocationCodes.gotHometown = true;
                  paramProfileLocationCodes.homeCountryCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
                  paramProfileLocationCodes.homeProvinceCode = ProfileCodecUtils.decodeRemoteCode(paramShort2);
                  paramProfileLocationCodes.homeCityCode = ProfileCodecUtils.decodeRemoteCode(i);
                  return;
                }
                paramShort1 = paramByteBuffer.getInt();
                paramProfileLocationCodes.gotHometown = true;
                paramProfileLocationCodes.homeDistrictCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
                return;
              }
              paramShort1 = paramByteBuffer.getInt();
              paramProfileLocationCodes.gotLocation = true;
              paramProfileLocationCodes.locDistrictCode = ProfileCodecUtils.decodeRemoteCode(paramShort1);
              return;
            }
            paramCard.age = paramByteBuffer.get();
            return;
          }
          paramLong = new byte[paramShort2];
          paramByteBuffer.get(paramLong);
          paramCard.strPersonalNote = new String(paramLong);
          return;
        }
        paramLong = new byte[paramShort2];
        paramByteBuffer.get(paramLong);
        paramCard.strEmail = new String(paramLong);
        return;
      }
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
    }
    paramLong = new byte[paramShort2];
    paramByteBuffer.get(paramLong);
    paramCard.strNick = new String(paramLong);
  }
  
  private void handleGetDetailInfoInner2(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard)
  {
    if (paramShort1 != -23364)
    {
      if (paramShort1 != -23196)
      {
        if (paramShort1 != -23180)
        {
          if (paramShort1 != -23175)
          {
            if (paramShort1 != -23169)
            {
              if (paramShort1 != -23159) {
                return;
              }
              paramCard.switchWeiShi = paramByteBuffer.getShort();
              return;
            }
            paramCard.switchLifeAchievement = paramByteBuffer.getShort();
            return;
          }
          paramCard.switchQQCircle = paramByteBuffer.getShort();
          return;
        }
        paramCard.switchStickyNote = paramByteBuffer.getShort();
        return;
      }
      paramCard.switchMusicBox = paramByteBuffer.getShort();
      return;
    }
    boolean bool;
    if (paramByteBuffer.getShort() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramCard.isShowCard = bool;
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
        if (!((GetExtendFriendInfo.RspBody)localObject).bytes_declaration.has()) {
          break label529;
        }
        paramRespSummaryCard = ((GetExtendFriendInfo.RspBody)localObject).bytes_declaration.get().toStringUtf8();
        if (!((GetExtendFriendInfo.RspBody)localObject).bytes_voice_url.has()) {
          break label534;
        }
        str = ((GetExtendFriendInfo.RspBody)localObject).bytes_voice_url.get().toStringUtf8();
        if (!((GetExtendFriendInfo.RspBody)localObject).uint32_popularity.has()) {
          break label540;
        }
        i = ((GetExtendFriendInfo.RspBody)localObject).uint32_popularity.get();
        if (!((GetExtendFriendInfo.RspBody)localObject).uint64_update_time.has()) {
          break label545;
        }
        l = ((GetExtendFriendInfo.RspBody)localObject).uint64_update_time.get();
        if (!((GetExtendFriendInfo.RspBody)localObject).uint32_voice_duration.has()) {
          break label551;
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
        }
        else
        {
          paramCard.schoolId = null;
          paramCard.schoolName = null;
          paramCard.authState = -1L;
          paramCard.idx = -1;
          paramCard.category = -1;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("DefaultProfileBusinessProcessor", 2, String.format("processProfileCardWithExtendFriend popularity=%s declaration=%s voiceUrl=%s updateTime=%s duration=%s fontId=%s fontType=%s clothesId=%s", new Object[] { Integer.valueOf(i), paramRespSummaryCard, str, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
          QLog.d("DefaultProfileBusinessProcessor", 2, String.format("processProfileCardWithExtendFriend schoolName=%s schoolId=%s authState=%s", new Object[] { paramCard.schoolName, paramCard.schoolId, Long.valueOf(paramCard.authState) }));
          return;
        }
      }
      catch (Exception paramCard)
      {
        QLog.e("DefaultProfileBusinessProcessor", 1, "", paramCard);
      }
      return;
      label529:
      paramRespSummaryCard = null;
      continue;
      label534:
      String str = null;
      continue;
      label540:
      int i = 0;
      continue;
      label545:
      long l = 0L;
      continue;
      label551:
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
    if ((paramLong & 0x10) != 0L)
    {
      paramCard.lLoginDays = paramRespSummaryCard.uLoginDays;
      paramCard.strLoginDaysDesc = paramRespSummaryCard.strLoginDesc;
    }
    if ((paramLong & 0x8) != 0L)
    {
      paramCard.lUserFlag = paramRespSummaryCard.lUserFlag;
      paramLong = paramCard.lUserFlag;
      boolean bool2 = true;
      boolean bool1;
      if ((paramLong & 0x8) != 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramCard.allowClick = bool1;
      if (!paramString.equals(this.appRuntime.getAccount()))
      {
        if ((paramCard.lUserFlag & 0x10) != 0L) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        paramCard.allowPeopleSee = bool1;
      }
    }
  }
  
  private void processProfileCardWithHobbies(Card paramCard, RespSummaryCard paramRespSummaryCard)
  {
    Object localObject1 = paramRespSummaryCard;
    ArrayList localArrayList1 = new ArrayList();
    int i;
    int j;
    int k;
    Object localObject2;
    if ((((RespSummaryCard)localObject1).vvRespServicesBigOrder != null) && (((RespSummaryCard)localObject1).vvRespServicesBigOrder.size() > 0))
    {
      i = 0;
      localObject1 = paramRespSummaryCard;
      if (i < ((RespSummaryCard)localObject1).vvRespServicesBigOrder.size())
      {
        localObject1 = (byte[])((RespSummaryCard)localObject1).vvRespServicesBigOrder.get(i);
        if (localObject1 == null) {
          j = 0;
        } else {
          j = localObject1.length;
        }
        if (j > 10)
        {
          k = (int)PkgTools.getLongData((byte[])localObject1, 1);
          PkgTools.getLongData((byte[])localObject1, 5);
          if ((k > 0) && (9 + k < j))
          {
            localObject2 = new byte[k];
            PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, 9, k);
            localObject1 = new SummaryCardBusiEntry.comm();
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        ((SummaryCardBusiEntry.comm)localObject1).mergeFrom((byte[])localObject2);
        j = i;
        k = ((SummaryCardBusiEntry.comm)localObject1).result.get();
        j = i;
        localObject2 = new ProfileSummaryHobbiesEntry();
        if (k != 0) {
          break label1052;
        }
        j = i;
        ((ProfileSummaryHobbiesEntry)localObject2).strName = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strName.get();
        j = i;
        ((ProfileSummaryHobbiesEntry)localObject2).strServiceUrl = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strServiceUrl.get();
        j = i;
        ((ProfileSummaryHobbiesEntry)localObject2).serviceType = ((SummaryCardBusiEntry.comm)localObject1).service.get();
        j = i;
        ArrayList localArrayList2 = new ArrayList();
        k = 0;
        j = i;
        ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem;
        int m;
        SummaryCardBusiEntry.Label localLabel;
        ProfileGroupLabel localProfileGroupLabel;
        ProfileColor localProfileColor;
        long l;
        if (k < ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.size())
        {
          j = i;
          SummaryCardBusiEntry.ui_info localui_info = (SummaryCardBusiEntry.ui_info)((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.get(k);
          j = i;
          localProfileSummaryHobbiesItem = new ProfileSummaryHobbiesItem();
          j = i;
          localProfileSummaryHobbiesItem.strTitle = localui_info.strTitle.get();
          j = i;
          localProfileSummaryHobbiesItem.strCoverUrl = localui_info.strCoverUrl.get();
          j = i;
          localProfileSummaryHobbiesItem.strJmpUrl = localui_info.strJmpUrl.get();
          j = i;
          localProfileSummaryHobbiesItem.strSubInfo = localui_info.strSubInfo.get();
          j = i;
          localProfileSummaryHobbiesItem.strDesc = localui_info.strDesc.get();
          j = i;
          localProfileSummaryHobbiesItem.strTitleIconUrl = localui_info.strTitleIconUrl.get();
          j = i;
          localProfileSummaryHobbiesItem.groupCode = localui_info.uint64_group_code.get();
          j = i;
          localProfileSummaryHobbiesItem.serviceType = ((ProfileSummaryHobbiesEntry)localObject2).serviceType;
          if (i == 0) {
            if (k == 0)
            {
              j = i;
              localProfileSummaryHobbiesItem.service = 0;
            }
            else
            {
              j = i;
              localProfileSummaryHobbiesItem.service = 1;
            }
          }
          j = i;
          if (localui_info.rptGroupTagList.size() <= 0) {
            break label1034;
          }
          j = i;
          localObject3 = new ArrayList();
          m = 0;
          j = i;
          if (m < localui_info.rptGroupTagList.size())
          {
            j = i;
            localLabel = (SummaryCardBusiEntry.Label)localui_info.rptGroupTagList.get(m);
            j = i;
            localProfileGroupLabel = new ProfileGroupLabel();
            j = i;
            localProfileGroupLabel.strWording = localLabel.bytes_name.get().toStringUtf8();
            j = i;
            localProfileGroupLabel.type = localLabel.uint32_label_type.get();
            j = i;
            localProfileGroupLabel.attr = localLabel.uint32_label_attr.get();
            j = i;
            localProfileColor = new ProfileColor();
            j = i;
            int n = localLabel.edging_color.uint32_r.get();
            j = i;
            l = n;
            i = j;
          }
        }
        try
        {
          localProfileColor.red = l;
          i = j;
          localProfileColor.green = localLabel.edging_color.uint32_g.get();
          i = j;
          localProfileColor.blue = localLabel.edging_color.uint32_b.get();
          i = j;
          localProfileGroupLabel.edgingColor = localProfileColor;
          i = j;
          localProfileColor = new ProfileColor();
          i = j;
          localProfileColor.red = localLabel.text_color.uint32_r.get();
          i = j;
          localProfileColor.green = localLabel.text_color.uint32_g.get();
          i = j;
          localProfileColor.blue = localLabel.text_color.uint32_b.get();
          i = j;
          localProfileGroupLabel.textColor = localProfileColor;
          i = j;
          ((ArrayList)localObject3).add(localProfileGroupLabel);
          m += 1;
          i = j;
        }
        catch (Exception localException2)
        {
          break label1000;
        }
        j = i;
        i = j;
        localProfileSummaryHobbiesItem.labels = ((ArrayList)localObject3);
        i = j;
        localArrayList2.add(localProfileSummaryHobbiesItem);
        i = j;
        if (!QLog.isColorLevel()) {
          break label1040;
        }
        i = j;
        Object localObject3 = localProfileSummaryHobbiesItem.strTitle;
        i = j;
        QLog.d("DefaultProfileBusinessProcessor", 2, String.format("HobbiesEntry Item strTitle=%s serviceType=%s strJmpUrl=%s", new Object[] { localObject3, Integer.valueOf(localProfileSummaryHobbiesItem.serviceType), localProfileSummaryHobbiesItem.strJmpUrl }));
        break label1040;
        j = i;
        i = j;
        ((ProfileSummaryHobbiesEntry)localObject2).sProfileSummaryHobbiesItem = localArrayList2;
        i = j;
        localArrayList1.add(localObject2);
        i = j;
        k = j;
        if (!QLog.isColorLevel()) {
          break label1017;
        }
        i = j;
        localObject1 = ((ProfileSummaryHobbiesEntry)localObject2).strName;
        try
        {
          QLog.d("DefaultProfileBusinessProcessor", 2, String.format("HobbiesEntry strName=%s strServiceType=%s strServiceUrl=%s", new Object[] { localObject1, ((ProfileSummaryHobbiesEntry)localObject2).strServiceType, ((ProfileSummaryHobbiesEntry)localObject2).strServiceUrl }));
          i = j;
        }
        catch (Exception localException1)
        {
          i = j;
        }
        QLog.e("DefaultProfileBusinessProcessor", 1, "processProfileCardWithHobbies fail.", localException3);
      }
      catch (Exception localException3)
      {
        i = j;
      }
      label1000:
      break label1020;
      k = i;
      label1017:
      i = k;
      label1020:
      i += 1;
      break;
      paramCard.saveBigOrderEntrys(localArrayList1);
      return;
      label1034:
      j = i;
      continue;
      label1040:
      k += 1;
      i = j;
      continue;
      label1052:
      j = i;
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
    long l3 = paramRespSummaryCard.ulShowControl;
    boolean bool2 = true;
    boolean bool1;
    if ((l3 & 1L) != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramCard.setFeedsShowFlag(bool1);
    if ((paramRespSummaryCard.ulShowControl & 0x2) != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramCard.setPhotoShowFlag(bool1);
    if ((paramRespSummaryCard.ulShowControl & 0x10) != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramCard.setXManFlag(bool1);
    if (paramRespSummaryCard.lCacheControl != 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramCard.setPhotoUseCacheFlag(bool1);
    paramCard.setVipInfo(paramRespSummaryCard.stVipInfo);
    processProfileCardWithGetControl(paramCard, paramRespSummaryCard, l2, String.valueOf(l1));
    processProfileCardWithCover(paramCard, paramRespSummaryCard);
    processProfileCardWithDiamonds(paramCard, paramRespSummaryCard);
    processProfileCardWithHobbies(paramCard, paramRespSummaryCard);
    processProfileCardWithVisitingCard(paramCard, paramRespSummaryCard);
    processProfileCardWithExtendFriend(paramCard, paramRespSummaryCard);
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    paramArrayList.add(new BusinessReqBuffer(2, null));
    paramArrayList.add(new BusinessReqBuffer(4, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.DefaultProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */