package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import QQService.RespHead;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeResultItem;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LimitInfo;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.RspBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.ReqBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.LoginSig;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.ReqBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteInfo;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteResult;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ExtParam;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.LoginSig;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ReqBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.RspBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.StockRsp;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.UserZanInfo;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ZanLimitInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyCardHandler
  extends BusinessHandler
{
  protected Set a;
  
  public NearbyCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      a(57, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            a(57, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        a(57, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          a(57, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
            i += 1;
          }
          a(57, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          a(57, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, "", Integer.valueOf(-1), Integer.valueOf(-1), "数据错误" });
      return;
    }
    String str;
    label86:
    int i;
    label96:
    int j;
    label106:
    int i2;
    int k;
    label146:
    int m;
    label165:
    label183:
    label201:
    Object localObject;
    if (paramToServiceMsg.extraData == null)
    {
      str = "";
      if (paramToServiceMsg.extraData != null) {
        break label541;
      }
      if (paramToServiceMsg.extraData != null) {
        break label555;
      }
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label570;
      }
      j = -1;
      paramToServiceMsg = new cmd0x9c8.RspBody();
      i2 = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i2 != 0) {
        break label843;
      }
      if (!paramToServiceMsg.uint32_tag_type.has()) {
        break label585;
      }
      k = paramToServiceMsg.uint32_tag_type.get();
      if (!paramToServiceMsg.uint32_next_pos.has()) {
        break label591;
      }
      m = paramToServiceMsg.uint32_next_pos.get();
      if (!paramToServiceMsg.rpt_msg_tag_list.has()) {
        break label597;
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_tag_list.get();
      if (!paramToServiceMsg.rpt_msg_sel_list.has()) {
        break label602;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_sel_list.get();
      localObject = this.b.getEntityManagerFactory(this.b.getAccount()).createEntityManager();
      if ((i != 0) || (!TextUtils.isEmpty(str)) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label607;
      }
    }
    label541:
    label555:
    label570:
    label585:
    label591:
    label597:
    label602:
    label607:
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        paramObject = new StringBuilder();
        paramObject.append("DELETE FROM ");
        paramObject.append(InterestTagInfo.class.getSimpleName());
        paramObject.append(" WHERE ");
        paramObject.append("tagType = ");
        paramObject.append(k);
        paramObject.append(";");
        ((EntityManager)localObject).b(paramObject.toString());
        paramObject = this.b.getApplication().getSharedPreferences("dating_pref" + this.b.getCurrentAccountUin(), 0).edit();
        paramObject.putLong("list_last_update_time_" + k, NetConnInfoCenter.getServerTimeMillis());
        paramObject.putInt("list_fetch_pos_" + k, m);
        paramObject.commit();
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label960;
      }
      paramObject = new ArrayList();
      int i1 = 0;
      while (i1 < paramFromServiceMsg.size())
      {
        InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramFromServiceMsg.get(i1));
        if (localInterestTagInfo != null)
        {
          localInterestTagInfo.tagType = k;
          paramObject.add(localInterestTagInfo);
          if (n != 0) {
            ((EntityManager)localObject).a(localInterestTagInfo);
          }
        }
        i1 += 1;
      }
      str = paramToServiceMsg.extraData.getString("key_word");
      break;
      paramToServiceMsg.extraData.getInt("tag_type");
      break label86;
      i = paramToServiceMsg.extraData.getInt("fetch_start");
      break label96;
      j = paramToServiceMsg.extraData.getInt("person_flag");
      break label106;
      k = -1;
      break label146;
      m = -1;
      break label165;
      paramFromServiceMsg = null;
      break label183;
      paramToServiceMsg = null;
      break label201;
    }
    label960:
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      ((EntityManager)localObject).a();
      localObject = null;
      paramObject = localObject;
      if (paramToServiceMsg != null)
      {
        paramObject = localObject;
        if (!paramToServiceMsg.isEmpty())
        {
          paramObject = new ArrayList();
          n = 0;
          while (n < paramToServiceMsg.size())
          {
            localObject = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramToServiceMsg.get(n));
            if (localObject != null) {
              paramObject.add(localObject);
            }
            n += 1;
          }
        }
      }
      a(1, true, new Object[] { Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j), null });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j) });
      return;
      label843:
      if (paramToServiceMsg.str_error.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error.get();; paramToServiceMsg = "")
      {
        a(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, str, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
        NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(false), paramToServiceMsg });
        return;
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "handleEditProfileCard");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(3, false, null);
      return;
    }
    Object localObject = new cmd0x9c9.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l2 = SystemClock.elapsedRealtime();
    long l3 = paramToServiceMsg.extraData.getLong("startSaveTime");
    boolean bool1;
    EntityManager localEntityManager;
    if (paramToServiceMsg.extraData.containsKey("is_head_changed"))
    {
      bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      if (i != 0) {
        break label1057;
      }
      localEntityManager = this.b.getEntityManagerFactory(this.b.getAccount()).createEntityManager();
      paramFromServiceMsg = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.b.getCurrentAccountUin() });
      if (paramFromServiceMsg != null) {
        break label1095;
      }
      paramFromServiceMsg = new NearbyPeopleCard();
      paramFromServiceMsg.uin = this.b.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "handleEditProfileCard get nearbyCard from db is null.");
      }
    }
    label1027:
    label1057:
    label1095:
    for (;;)
    {
      for (;;)
      {
        if (paramToServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
          paramFromServiceMsg.godFlag = false;
        }
        if (((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.has())
        {
          paramObject = ((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.get().toByteArray();
          label231:
          paramObject = paramFromServiceMsg.updateEditPicInfos(paramObject, (PicInfo)paramToServiceMsg.extraData.getParcelable("avatar_picinfo"));
          if ((paramObject != null) && (!paramObject.isEmpty())) {
            NearbySPUtil.a(this.b.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
          }
          paramObject = paramToServiceMsg.extraData.getByteArray("9c7_body");
          if ((paramObject == null) || (paramObject.length <= 0)) {}
        }
        try
        {
          localObject = new cmd0x9c7.ReqBody();
          ((cmd0x9c7.ReqBody)localObject).mergeFrom(paramObject);
          paramFromServiceMsg.updateInterestTags(paramFromServiceMsg.tagFlag, ((cmd0x9c7.ReqBody)localObject).rpt_msg_tags.get());
          if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
            paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
          }
          if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
            paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
          }
          if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
            paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
          }
          if (paramToServiceMsg.extraData.containsKey("sex"))
          {
            paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
            paramObject = (NearbyCardManager)this.b.getManager(105);
            if (paramObject != null) {
              paramObject.b(paramFromServiceMsg.gender);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("birthday"))
          {
            paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
            paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
            paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
            paramObject = (NearbyCardManager)this.b.getManager(105);
            if (paramObject != null) {
              paramObject.a(paramFromServiceMsg.age);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("profession")) {
            paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
          }
          if (paramToServiceMsg.extraData.containsKey("company")) {
            paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
          }
          if (paramToServiceMsg.extraData.containsKey("college")) {
            paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
          }
        }
        catch (Exception paramObject)
        {
          try
          {
            do
            {
              NearbySPUtil.a(this.b.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
                paramFromServiceMsg.hometownCountry = paramObject[0];
                paramFromServiceMsg.hometownProvice = paramObject[1];
                paramFromServiceMsg.hometownCity = paramObject[2];
                paramFromServiceMsg.hometownDistrict = paramObject[3];
              }
              if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_qzone_switch") != 0) {
                  break label1009;
                }
                bool2 = true;
                paramFromServiceMsg.switchQzone = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                  break label1015;
                }
                bool2 = true;
                paramFromServiceMsg.switchHobby = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") != 0) {
                  break label1021;
                }
                l1 = 0L;
                paramFromServiceMsg.switchGiftVisible = l1;
              }
              if (paramFromServiceMsg.getStatus() != 1000) {
                break label1027;
              }
              localEntityManager.b(paramFromServiceMsg);
              bool2 = true;
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = "";
              a(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), "" });
              paramObject = new HashMap();
              paramObject.put("errorCode", String.valueOf(i));
              StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramObject, "");
              NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg });
              return;
              bool1 = false;
              break;
              paramObject = null;
              break label231;
              paramObject = paramObject;
            } while ((!NearbyCardConstants.a) || (!QLog.isColorLevel()));
            QLog.d("Q.nearby_people_card.", 2, "rsp_9c7" + paramObject.getMessage());
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              paramObject.printStackTrace();
              continue;
              label1009:
              bool2 = false;
              continue;
              label1015:
              bool2 = false;
              continue;
              label1021:
              long l1 = 1L;
              continue;
              if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                localEntityManager.a(paramFromServiceMsg);
              }
            }
          }
        }
      }
      boolean bool2 = false;
      if (((cmd0x9c9.RspBody)localObject).str_errorinfo.has()) {}
      for (paramToServiceMsg = ((cmd0x9c9.RspBody)localObject).str_errorinfo.get();; paramToServiceMsg = "")
      {
        paramObject = null;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
        break;
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.e(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          this.b.a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          a(60, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i == 1)
          {
            localObject1 = localObject3;
            localObject2 = localObject4;
            if (localRspBody.msg_notify_event.has())
            {
              localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
              localObject1 = localObject3;
            }
          }
        }
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          a(61, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyCardHandler", 2, paramToServiceMsg, new Object[0]);
      }
    }
  }
  
  /* Error */
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 39	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 784
    //   7: invokevirtual 411	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +33 -> 50
    //   20: ldc_w 786
    //   23: iconst_2
    //   24: new 49	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 788
    //   34: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_2
    //   38: invokevirtual 791	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   41: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   53: ifeq +5615 -> 5668
    //   56: invokestatic 796	java/lang/System:currentTimeMillis	()J
    //   59: lstore 10
    //   61: aload_1
    //   62: getfield 39	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   65: ldc_w 798
    //   68: invokevirtual 411	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   71: istore 22
    //   73: aload_1
    //   74: getfield 39	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   77: ldc_w 800
    //   80: invokevirtual 403	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   83: lstore 12
    //   85: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   88: lstore 14
    //   90: aload_2
    //   91: invokevirtual 791	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   94: istore 7
    //   96: aconst_null
    //   97: astore 23
    //   99: aload_2
    //   100: invokevirtual 99	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   103: ifeq +977 -> 1080
    //   106: aload_3
    //   107: instanceof 802
    //   110: ifeq +970 -> 1080
    //   113: iconst_1
    //   114: istore 20
    //   116: iload 20
    //   118: ifeq +5545 -> 5663
    //   121: aload_0
    //   122: aload_2
    //   123: invokevirtual 805	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   126: ldc_w 807
    //   129: new 809	SummaryCard/RespHead
    //   132: dup
    //   133: invokespecial 810	SummaryCard/RespHead:<init>	()V
    //   136: invokevirtual 813	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 809	SummaryCard/RespHead
    //   142: astore_2
    //   143: aload_2
    //   144: ifnull +942 -> 1086
    //   147: aload_2
    //   148: getfield 816	SummaryCard/RespHead:iResult	I
    //   151: ifne +935 -> 1086
    //   154: iconst_1
    //   155: istore 20
    //   157: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +44 -> 204
    //   163: new 49	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 818
    //   173: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: astore 24
    //   178: aload_2
    //   179: ifnonnull +913 -> 1092
    //   182: ldc_w 820
    //   185: astore 23
    //   187: ldc_w 786
    //   190: iconst_2
    //   191: aload 24
    //   193: aload 23
    //   195: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_1
    //   205: getfield 39	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   208: ldc_w 825
    //   211: invokevirtual 348	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   214: istore 8
    //   216: iload 20
    //   218: ifeq +5411 -> 5629
    //   221: aload_3
    //   222: checkcast 802	SummaryCard/RespSummaryCard
    //   225: astore 25
    //   227: aload_0
    //   228: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: invokevirtual 828	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   234: invokevirtual 256	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   237: astore 23
    //   239: aload 23
    //   241: invokevirtual 831	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   244: astore 24
    //   246: aload 24
    //   248: invokevirtual 834	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   251: aload_1
    //   252: getfield 39	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   255: ldc_w 836
    //   258: lconst_0
    //   259: invokevirtual 839	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   262: lstore 16
    //   264: aconst_null
    //   265: astore_1
    //   266: lload 16
    //   268: lconst_0
    //   269: lcmp
    //   270: ifle +30 -> 300
    //   273: aload 23
    //   275: ldc_w 413
    //   278: ldc_w 841
    //   281: iconst_1
    //   282: anewarray 417	java/lang/String
    //   285: dup
    //   286: iconst_0
    //   287: lload 16
    //   289: invokestatic 844	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   292: aastore
    //   293: invokevirtual 420	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   296: checkcast 413	com/tencent/mobileqq/data/NearbyPeopleCard
    //   299: astore_1
    //   300: aload_1
    //   301: ifnonnull +5359 -> 5660
    //   304: aload 25
    //   306: getfield 847	SummaryCard/RespSummaryCard:lUIN	J
    //   309: lconst_0
    //   310: lcmp
    //   311: ifle +5349 -> 5660
    //   314: aload 23
    //   316: ldc_w 413
    //   319: ldc_w 415
    //   322: iconst_1
    //   323: anewarray 417	java/lang/String
    //   326: dup
    //   327: iconst_0
    //   328: aload 25
    //   330: getfield 847	SummaryCard/RespSummaryCard:lUIN	J
    //   333: invokestatic 844	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   336: aastore
    //   337: invokevirtual 420	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   340: checkcast 413	com/tencent/mobileqq/data/NearbyPeopleCard
    //   343: astore_1
    //   344: aload_1
    //   345: ifnonnull +796 -> 1141
    //   348: new 413	com/tencent/mobileqq/data/NearbyPeopleCard
    //   351: dup
    //   352: invokespecial 421	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   355: astore_3
    //   356: aload 25
    //   358: getfield 851	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   361: astore_1
    //   362: aload_3
    //   363: aload 25
    //   365: getfield 847	SummaryCard/RespSummaryCard:lUIN	J
    //   368: invokestatic 844	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   371: putfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   374: lload 16
    //   376: lconst_0
    //   377: lcmp
    //   378: ifle +926 -> 1304
    //   381: aload_3
    //   382: lload 16
    //   384: putfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   387: iload 8
    //   389: ifeq +20 -> 409
    //   392: aload_3
    //   393: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   396: aload_0
    //   397: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   400: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   403: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifeq +909 -> 1315
    //   409: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq +48 -> 460
    //   415: ldc_w 786
    //   418: iconst_2
    //   419: new 49	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 858
    //   429: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 25
    //   434: getfield 861	SummaryCard/RespSummaryCard:iVoteCount	I
    //   437: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: ldc_w 863
    //   443: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload 25
    //   448: getfield 866	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   451: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload_3
    //   461: aload 25
    //   463: getfield 861	SummaryCard/RespSummaryCard:iVoteCount	I
    //   466: putfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   469: aload_3
    //   470: aload 25
    //   472: getfield 866	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   475: putfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   478: aload_3
    //   479: aload 25
    //   481: getfield 876	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   484: putfield 880	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   487: aload_3
    //   488: aload 25
    //   490: getfield 883	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   493: putfield 490	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   496: aload_3
    //   497: aload 25
    //   499: getfield 886	SummaryCard/RespSummaryCard:vRichSign	[B
    //   502: putfield 485	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   505: aload_3
    //   506: aload_1
    //   507: getfield 891	SummaryCard/DateCard:bMarriage	B
    //   510: putfield 500	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   513: aload_3
    //   514: aload 25
    //   516: getfield 894	SummaryCard/RespSummaryCard:bSex	B
    //   519: putfield 505	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   522: aload_3
    //   523: aload 25
    //   525: getfield 897	SummaryCard/RespSummaryCard:bAge	B
    //   528: putfield 522	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   531: aload_3
    //   532: aload 25
    //   534: getfield 900	SummaryCard/RespSummaryCard:iBirthday	I
    //   537: putfield 518	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   540: aload_3
    //   541: aload_1
    //   542: getfield 903	SummaryCard/DateCard:uProfession	J
    //   545: l2i
    //   546: putfield 534	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   549: aload_3
    //   550: aload_1
    //   551: getfield 906	SummaryCard/DateCard:bConstellation	B
    //   554: putfield 527	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   557: aload_3
    //   558: aload_1
    //   559: getfield 909	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   562: putfield 912	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   565: aload_3
    //   566: aload_1
    //   567: getfield 915	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   570: putfield 918	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   573: aload_3
    //   574: aload 25
    //   576: getfield 921	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   579: putfield 924	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   582: aload_3
    //   583: aload_1
    //   584: getfield 927	SummaryCard/DateCard:vDateInfo	[B
    //   587: putfield 930	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   590: aload_3
    //   591: aload_1
    //   592: getfield 933	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   595: putfield 538	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   598: aload_3
    //   599: aload_1
    //   600: getfield 936	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   603: putfield 542	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   606: aload_3
    //   607: aload_1
    //   608: getfield 939	SummaryCard/DateCard:uHomeCountry	J
    //   611: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   614: putfield 553	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   617: aload_3
    //   618: aload_1
    //   619: getfield 946	SummaryCard/DateCard:uHomeProvince	J
    //   622: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   625: putfield 556	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   628: aload_3
    //   629: aload_1
    //   630: getfield 949	SummaryCard/DateCard:uHomeCity	J
    //   633: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   636: putfield 559	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   639: aload_3
    //   640: aload_1
    //   641: getfield 952	SummaryCard/DateCard:uHomeZone	J
    //   644: invokestatic 943	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   647: putfield 562	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   650: aload_3
    //   651: aload 25
    //   653: getfield 955	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   656: putfield 958	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   659: aload_3
    //   660: aload 25
    //   662: getfield 961	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   665: putfield 964	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   668: aload_3
    //   669: aload 25
    //   671: getfield 967	SummaryCard/RespSummaryCard:ulShowControl	J
    //   674: putfield 970	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   677: aload_3
    //   678: aload 25
    //   680: getfield 973	SummaryCard/RespSummaryCard:lUserFlag	J
    //   683: putfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   686: aload_3
    //   687: aload 25
    //   689: getfield 979	SummaryCard/RespSummaryCard:vSeed	[B
    //   692: putfield 980	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   695: aload_3
    //   696: aload 25
    //   698: getfield 983	SummaryCard/RespSummaryCard:lCacheControl	J
    //   701: invokevirtual 987	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   704: aload_3
    //   705: invokestatic 796	java/lang/System:currentTimeMillis	()J
    //   708: putfield 990	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   711: aload_3
    //   712: iload 8
    //   714: putfield 993	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   717: aload_3
    //   718: aload 25
    //   720: getfield 996	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   723: putfield 997	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   726: aload_3
    //   727: getfield 997	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   730: ifnull +606 -> 1336
    //   733: aload_3
    //   734: getfield 997	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   737: arraylength
    //   738: ifne +58 -> 796
    //   741: aload_0
    //   742: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   745: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   748: aload_3
    //   749: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   752: invokestatic 1000	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   755: ifne +41 -> 796
    //   758: aload_0
    //   759: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   762: ldc_w 1002
    //   765: ldc_w 1004
    //   768: ldc 216
    //   770: ldc_w 1006
    //   773: ldc_w 1008
    //   776: iconst_0
    //   777: iconst_0
    //   778: aload_0
    //   779: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   782: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   785: aload_3
    //   786: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   789: ldc 216
    //   791: ldc 216
    //   793: invokestatic 1013	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   796: aload_0
    //   797: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   800: invokevirtual 1016	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   803: aload_3
    //   804: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   807: invokevirtual 1021	com/tencent/mobileqq/service/message/MessageCache:m	(Ljava/lang/String;)[B
    //   810: ifnonnull +21 -> 831
    //   813: aload_0
    //   814: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   817: invokevirtual 1016	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   820: aload_3
    //   821: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   824: aload_3
    //   825: getfield 997	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   828: invokevirtual 1024	com/tencent/mobileqq/service/message/MessageCache:h	(Ljava/lang/String;[B)V
    //   831: aload_3
    //   832: aload_1
    //   833: getfield 1027	SummaryCard/DateCard:uSchoolId	J
    //   836: putfield 1030	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   839: aload_3
    //   840: aload_1
    //   841: getfield 1033	SummaryCard/DateCard:vGroupList	[B
    //   844: putfield 1034	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   847: aload_3
    //   848: aload_1
    //   849: getfield 1037	SummaryCard/DateCard:vNearbyInfo	[B
    //   852: putfield 1040	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   855: aload_3
    //   856: aload_1
    //   857: getfield 1043	SummaryCard/DateCard:vActivityList	[B
    //   860: putfield 1044	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   863: aload_3
    //   864: aload 25
    //   866: getfield 973	SummaryCard/RespSummaryCard:lUserFlag	J
    //   869: putfield 1045	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   872: aload_3
    //   873: aload 25
    //   875: getfield 1048	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   878: putfield 1049	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   881: aload 25
    //   883: getfield 1053	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   886: ifnull +15 -> 901
    //   889: aload_3
    //   890: aload 25
    //   892: getfield 1053	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   895: getfield 1058	SummaryCard/HeartInfo:iHeartCount	I
    //   898: putfield 1061	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   901: aload 25
    //   903: getfield 1065	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   906: ifnull +471 -> 1377
    //   909: aload_3
    //   910: aload 25
    //   912: getfield 1065	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   915: getfield 1070	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   918: putfield 1073	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   921: aload_3
    //   922: aload 25
    //   924: getfield 1065	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   927: getfield 1076	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   930: putfield 1077	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   933: aload 25
    //   935: getfield 1080	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   938: astore 26
    //   940: aload 26
    //   942: ifnull +480 -> 1422
    //   945: aload_3
    //   946: new 142	java/util/ArrayList
    //   949: dup
    //   950: invokespecial 143	java/util/ArrayList:<init>	()V
    //   953: putfield 1083	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   956: new 1085	appoint/define/appoint_define$CommonLabel
    //   959: dup
    //   960: invokespecial 1086	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   963: astore 27
    //   965: aload 27
    //   967: aload 26
    //   969: invokevirtual 1087	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   972: pop
    //   973: aload 27
    //   975: getfield 1090	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   978: invokevirtual 205	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   981: astore 26
    //   983: aload 27
    //   985: getfield 1093	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   988: invokevirtual 205	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   991: astore 28
    //   993: new 1095	org/json/JSONArray
    //   996: dup
    //   997: invokespecial 1096	org/json/JSONArray:<init>	()V
    //   1000: astore 27
    //   1002: aload 26
    //   1004: invokeinterface 153 1 0
    //   1009: aload 28
    //   1011: invokeinterface 153 1 0
    //   1016: if_icmpne +397 -> 1413
    //   1019: iconst_0
    //   1020: istore 4
    //   1022: iload 4
    //   1024: aload 26
    //   1026: invokeinterface 153 1 0
    //   1031: if_icmpge +382 -> 1413
    //   1034: aload 26
    //   1036: iload 4
    //   1038: invokeinterface 208 2 0
    //   1043: checkcast 69	com/tencent/mobileqq/pb/ByteStringMicro
    //   1046: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1049: astore 28
    //   1051: aload_3
    //   1052: getfield 1083	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   1055: aload 28
    //   1057: invokeinterface 177 2 0
    //   1062: pop
    //   1063: aload 27
    //   1065: aload 28
    //   1067: invokevirtual 1099	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1070: pop
    //   1071: iload 4
    //   1073: iconst_1
    //   1074: iadd
    //   1075: istore 4
    //   1077: goto -55 -> 1022
    //   1080: iconst_0
    //   1081: istore 20
    //   1083: goto -967 -> 116
    //   1086: iconst_0
    //   1087: istore 20
    //   1089: goto -932 -> 157
    //   1092: aload_2
    //   1093: getfield 816	SummaryCard/RespHead:iResult	I
    //   1096: istore 4
    //   1098: iload 4
    //   1100: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1103: astore 23
    //   1105: goto -918 -> 187
    //   1108: astore 24
    //   1110: aload 23
    //   1112: astore_2
    //   1113: aload 24
    //   1115: astore 23
    //   1117: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1120: ifeq +15 -> 1135
    //   1123: ldc_w 786
    //   1126: iconst_2
    //   1127: aload 23
    //   1129: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   1132: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: iconst_0
    //   1136: istore 20
    //   1138: goto -934 -> 204
    //   1141: aload_1
    //   1142: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1145: istore 4
    //   1147: aload_1
    //   1148: invokevirtual 1103	com/tencent/mobileqq/data/NearbyPeopleCard:getId	()J
    //   1151: lstore 18
    //   1153: new 413	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1156: dup
    //   1157: invokespecial 421	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1160: astore_3
    //   1161: aload_3
    //   1162: aload_1
    //   1163: getfield 1106	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   1166: putfield 1106	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   1169: aload_3
    //   1170: aload_1
    //   1171: getfield 1109	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1174: putfield 1109	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1177: aload_3
    //   1178: aload_1
    //   1179: getfield 1112	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   1182: putfield 1112	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   1185: aload_3
    //   1186: aload_1
    //   1187: getfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1190: putfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1193: aload_3
    //   1194: aload_1
    //   1195: getfield 1118	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1198: putfield 1118	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1201: aload_3
    //   1202: aload_1
    //   1203: getfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1206: putfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1209: aload_3
    //   1210: aload_1
    //   1211: getfield 1124	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1214: putfield 1124	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1217: aload_3
    //   1218: aload_1
    //   1219: getfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1222: putfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1225: aload_3
    //   1226: aload_1
    //   1227: getfield 1130	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1230: putfield 1130	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1233: aload_3
    //   1234: aload_1
    //   1235: getfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1238: putfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1241: aload_3
    //   1242: aload_1
    //   1243: getfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1246: putfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1249: aload_3
    //   1250: aload_1
    //   1251: getfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1254: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1257: aload_3
    //   1258: aload_1
    //   1259: getfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1262: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1265: aload_3
    //   1266: aload_1
    //   1267: getfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1270: putfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1273: aload_3
    //   1274: aload_1
    //   1275: getfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1278: putfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1281: aload_3
    //   1282: aload_1
    //   1283: getfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1286: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1289: aload_3
    //   1290: iload 4
    //   1292: invokevirtual 1151	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1295: aload_3
    //   1296: lload 18
    //   1298: invokevirtual 1154	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1301: goto -945 -> 356
    //   1304: aload_3
    //   1305: aload_1
    //   1306: getfield 1157	SummaryCard/DateCard:lTinyId	J
    //   1309: putfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1312: goto -925 -> 387
    //   1315: aload_3
    //   1316: aload 25
    //   1318: getfield 861	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1321: putfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1324: aload_3
    //   1325: aload 25
    //   1327: getfield 866	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1330: putfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1333: goto -846 -> 487
    //   1336: aload_0
    //   1337: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1340: ldc_w 1002
    //   1343: ldc_w 1004
    //   1346: ldc 216
    //   1348: ldc_w 1006
    //   1351: ldc_w 1159
    //   1354: iconst_0
    //   1355: iconst_0
    //   1356: aload_0
    //   1357: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1360: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1363: aload_3
    //   1364: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1367: ldc 216
    //   1369: ldc 216
    //   1371: invokestatic 1013	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1374: goto -543 -> 831
    //   1377: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1380: ifeq -447 -> 933
    //   1383: ldc_w 786
    //   1386: iconst_2
    //   1387: new 49	java/lang/StringBuilder
    //   1390: dup
    //   1391: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1394: ldc_w 1161
    //   1397: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aconst_null
    //   1401: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1404: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1407: invokestatic 1164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1410: goto -477 -> 933
    //   1413: aload_3
    //   1414: aload 27
    //   1416: invokevirtual 1165	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1419: putfield 1168	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1422: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1425: ifeq +33 -> 1458
    //   1428: ldc_w 786
    //   1431: iconst_4
    //   1432: new 49	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1439: ldc_w 1170
    //   1442: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: aload_1
    //   1446: getfield 1027	SummaryCard/DateCard:uSchoolId	J
    //   1449: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1452: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1455: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1458: aload_3
    //   1459: aload 25
    //   1461: getfield 1173	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1464: putfield 1174	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1467: aload_3
    //   1468: aload 25
    //   1470: getfield 1178	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1473: putfield 1179	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1476: aload_3
    //   1477: aload 25
    //   1479: getfield 1182	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1482: putfield 1183	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1485: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1488: ifeq +61 -> 1549
    //   1491: ldc 24
    //   1493: iconst_2
    //   1494: new 49	java/lang/StringBuilder
    //   1497: dup
    //   1498: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1501: ldc_w 1185
    //   1504: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: aload 25
    //   1509: getfield 1173	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1512: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: ldc_w 1187
    //   1518: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: aload 25
    //   1523: getfield 1178	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1526: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1529: ldc_w 1189
    //   1532: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: aload 25
    //   1537: getfield 1182	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1540: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1543: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1546: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1549: aload 25
    //   1551: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1554: ifnull +54 -> 1608
    //   1557: aload_3
    //   1558: aload 25
    //   1560: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1563: getfield 1198	SummaryCard/PanSocialInfo:uCharm	J
    //   1566: putfield 1201	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1569: aload_3
    //   1570: aload 25
    //   1572: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1575: getfield 1204	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1578: l2i
    //   1579: putfield 1207	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1582: aload_3
    //   1583: aload 25
    //   1585: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1588: getfield 1210	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1591: l2i
    //   1592: putfield 1213	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1595: aload_3
    //   1596: aload 25
    //   1598: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1601: getfield 1216	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1604: l2i
    //   1605: putfield 1219	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1608: iload 8
    //   1610: ifeq +20 -> 1630
    //   1613: aload_3
    //   1614: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1617: aload_0
    //   1618: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1621: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1624: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1627: ifeq +236 -> 1863
    //   1630: iconst_1
    //   1631: istore 21
    //   1633: aload_3
    //   1634: aload_1
    //   1635: getfield 1222	SummaryCard/DateCard:vFaces	[B
    //   1638: aload 25
    //   1640: getfield 1226	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1643: iload 21
    //   1645: invokevirtual 1230	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1648: pop
    //   1649: aload_3
    //   1650: aload 25
    //   1652: getfield 1234	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1655: getfield 1239	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1658: putfield 1240	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1661: aload 25
    //   1663: getfield 1243	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1666: ifne +203 -> 1869
    //   1669: aload_3
    //   1670: iconst_1
    //   1671: putfield 1246	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1674: aload_2
    //   1675: ifnull +11 -> 1686
    //   1678: aload_3
    //   1679: aload_2
    //   1680: getfield 1249	SummaryCard/RespHead:vCookies	[B
    //   1683: putfield 1250	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1686: aload_3
    //   1687: getfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1690: ldc2_w 1251
    //   1693: land
    //   1694: lconst_0
    //   1695: lcmp
    //   1696: ifeq +181 -> 1877
    //   1699: aload_3
    //   1700: iconst_1
    //   1701: putfield 571	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1704: aload_3
    //   1705: getfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1708: ldc2_w 1253
    //   1711: land
    //   1712: lconst_0
    //   1713: lcmp
    //   1714: ifeq +171 -> 1885
    //   1717: aload_3
    //   1718: iconst_1
    //   1719: putfield 576	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1722: aload_3
    //   1723: invokevirtual 1257	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1726: ifne +223 -> 1949
    //   1729: aload_3
    //   1730: ldc 216
    //   1732: putfield 1260	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1735: aload_3
    //   1736: ldc 216
    //   1738: putfield 1263	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1741: aload_3
    //   1742: ldc 216
    //   1744: putfield 1266	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1747: aload 25
    //   1749: getfield 1270	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1752: astore_1
    //   1753: aload_1
    //   1754: ifnull +195 -> 1949
    //   1757: aload_1
    //   1758: getfield 1275	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1761: ifnull +188 -> 1949
    //   1764: aload_1
    //   1765: getfield 1275	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1768: invokevirtual 1276	java/util/ArrayList:size	()I
    //   1771: ifle +178 -> 1949
    //   1774: iconst_0
    //   1775: istore 4
    //   1777: iload 4
    //   1779: aload_1
    //   1780: getfield 1275	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1783: invokevirtual 1276	java/util/ArrayList:size	()I
    //   1786: if_icmpge +163 -> 1949
    //   1789: iload 4
    //   1791: ifne +102 -> 1893
    //   1794: aload_3
    //   1795: aload_1
    //   1796: getfield 1275	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1799: iload 4
    //   1801: invokevirtual 1277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1804: checkcast 1279	SummaryCard/PhotoInfo
    //   1807: getfield 1282	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1810: putfield 1260	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1813: iload 4
    //   1815: iconst_1
    //   1816: iadd
    //   1817: istore 4
    //   1819: goto -42 -> 1777
    //   1822: astore 26
    //   1824: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1827: ifeq -405 -> 1422
    //   1830: ldc 24
    //   1832: iconst_2
    //   1833: new 49	java/lang/StringBuilder
    //   1836: dup
    //   1837: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1840: ldc_w 1284
    //   1843: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1846: aload 26
    //   1848: invokevirtual 627	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1851: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1857: invokestatic 1286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1860: goto -438 -> 1422
    //   1863: iconst_0
    //   1864: istore 21
    //   1866: goto -233 -> 1633
    //   1869: aload_3
    //   1870: iconst_0
    //   1871: putfield 1246	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1874: goto -200 -> 1674
    //   1877: aload_3
    //   1878: iconst_0
    //   1879: putfield 571	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1882: goto -178 -> 1704
    //   1885: aload_3
    //   1886: iconst_0
    //   1887: putfield 576	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1890: goto -168 -> 1722
    //   1893: iload 4
    //   1895: iconst_1
    //   1896: if_icmpne +25 -> 1921
    //   1899: aload_3
    //   1900: aload_1
    //   1901: getfield 1275	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1904: iload 4
    //   1906: invokevirtual 1277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1909: checkcast 1279	SummaryCard/PhotoInfo
    //   1912: getfield 1282	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1915: putfield 1263	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1918: goto -105 -> 1813
    //   1921: iload 4
    //   1923: iconst_2
    //   1924: if_icmpne -111 -> 1813
    //   1927: aload_3
    //   1928: aload_1
    //   1929: getfield 1275	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1932: iload 4
    //   1934: invokevirtual 1277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1937: checkcast 1279	SummaryCard/PhotoInfo
    //   1940: getfield 1282	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1943: putfield 1266	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1946: goto -133 -> 1813
    //   1949: aload 25
    //   1951: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1954: astore_1
    //   1955: aload_1
    //   1956: ifnull +25 -> 1981
    //   1959: aload_1
    //   1960: getfield 1289	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1963: lconst_1
    //   1964: lcmp
    //   1965: ifne +149 -> 2114
    //   1968: aload_3
    //   1969: iconst_1
    //   1970: putfield 435	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1973: aload_3
    //   1974: aload_1
    //   1975: getfield 1292	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1978: putfield 1293	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1981: aload 25
    //   1983: getfield 1296	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1986: ifnull +29 -> 2015
    //   1989: aload_3
    //   1990: aload_0
    //   1991: aload 25
    //   1993: getfield 1296	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1996: ldc_w 1298
    //   1999: new 1300	GameCenter/RespLastGameInfo
    //   2002: dup
    //   2003: invokespecial 1301	GameCenter/RespLastGameInfo:<init>	()V
    //   2006: invokevirtual 813	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2009: checkcast 1300	GameCenter/RespLastGameInfo
    //   2012: invokevirtual 1305	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   2015: aload 25
    //   2017: getfield 1193	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   2020: astore_1
    //   2021: aload_1
    //   2022: ifnull +12 -> 2034
    //   2025: aload_3
    //   2026: aload_1
    //   2027: getfield 1308	SummaryCard/PanSocialInfo:uChatflag	J
    //   2030: l2i
    //   2031: putfield 1311	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   2034: new 142	java/util/ArrayList
    //   2037: dup
    //   2038: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2041: astore_1
    //   2042: aload 25
    //   2044: getfield 1314	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2047: ifnull +746 -> 2793
    //   2050: aload 25
    //   2052: getfield 1314	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2055: invokevirtual 1276	java/util/ArrayList:size	()I
    //   2058: ifle +735 -> 2793
    //   2061: iconst_0
    //   2062: istore 4
    //   2064: iload 4
    //   2066: aload 25
    //   2068: getfield 1314	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2071: invokevirtual 1276	java/util/ArrayList:size	()I
    //   2074: if_icmpge +719 -> 2793
    //   2077: aload 25
    //   2079: getfield 1314	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2082: iload 4
    //   2084: invokevirtual 1277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2087: checkcast 645	[B
    //   2090: astore_2
    //   2091: aload_2
    //   2092: ifnonnull +30 -> 2122
    //   2095: iconst_0
    //   2096: istore 5
    //   2098: iload 5
    //   2100: bipush 10
    //   2102: if_icmpgt +27 -> 2129
    //   2105: iload 4
    //   2107: iconst_1
    //   2108: iadd
    //   2109: istore 4
    //   2111: goto -47 -> 2064
    //   2114: aload_3
    //   2115: iconst_0
    //   2116: putfield 435	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   2119: goto -146 -> 1973
    //   2122: aload_2
    //   2123: arraylength
    //   2124: istore 5
    //   2126: goto -28 -> 2098
    //   2129: aload_2
    //   2130: iconst_1
    //   2131: invokestatic 1319	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2134: l2i
    //   2135: istore 6
    //   2137: aload_2
    //   2138: iconst_5
    //   2139: invokestatic 1319	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2142: l2i
    //   2143: istore 9
    //   2145: iload 6
    //   2147: ifle -42 -> 2105
    //   2150: iload 6
    //   2152: bipush 9
    //   2154: iadd
    //   2155: iload 5
    //   2157: if_icmpge -52 -> 2105
    //   2160: iload 6
    //   2162: newarray byte
    //   2164: astore 26
    //   2166: aload 26
    //   2168: iconst_0
    //   2169: aload_2
    //   2170: bipush 9
    //   2172: iload 6
    //   2174: invokestatic 1322	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   2177: new 1324	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2180: dup
    //   2181: invokespecial 1325	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2184: astore_2
    //   2185: aload_2
    //   2186: aload 26
    //   2188: invokevirtual 1326	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2191: pop
    //   2192: aload_2
    //   2193: getfield 1330	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2196: invokevirtual 1333	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2199: istore 9
    //   2201: new 1335	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry
    //   2204: dup
    //   2205: invokespecial 1336	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:<init>	()V
    //   2208: astore 26
    //   2210: iload 9
    //   2212: ifne +485 -> 2697
    //   2215: aload 26
    //   2217: aload_2
    //   2218: getfield 1340	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2221: getfield 1345	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2224: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2227: putfield 1347	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2230: aload 26
    //   2232: aload_2
    //   2233: getfield 1340	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2236: getfield 1350	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2239: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2242: putfield 1352	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2245: aload 26
    //   2247: aload_2
    //   2248: getfield 1355	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2251: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2254: putfield 1357	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_Int	I
    //   2257: new 142	java/util/ArrayList
    //   2260: dup
    //   2261: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2264: astore 27
    //   2266: iconst_0
    //   2267: istore 5
    //   2269: iload 5
    //   2271: aload_2
    //   2272: getfield 1340	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2275: getfield 1360	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2278: invokevirtual 1361	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2281: if_icmpge +409 -> 2690
    //   2284: aload_2
    //   2285: getfield 1340	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2288: getfield 1360	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2291: iload 5
    //   2293: invokevirtual 1364	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2296: checkcast 1366	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2299: astore 28
    //   2301: new 1368	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem
    //   2304: dup
    //   2305: invokespecial 1369	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:<init>	()V
    //   2308: astore 29
    //   2310: aload 29
    //   2312: aload 28
    //   2314: getfield 1372	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2317: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2320: putfield 1373	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2323: aload 29
    //   2325: aload 28
    //   2327: getfield 1376	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2330: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2333: putfield 1377	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2336: aload 29
    //   2338: aload 28
    //   2340: getfield 1380	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2343: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2346: putfield 1383	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:c	Ljava/lang/String;
    //   2349: aload 29
    //   2351: aload 28
    //   2353: getfield 1386	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2356: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2359: putfield 1388	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:d	Ljava/lang/String;
    //   2362: aload 29
    //   2364: aload 28
    //   2366: getfield 1391	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2369: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2372: putfield 1393	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:e	Ljava/lang/String;
    //   2375: aload 29
    //   2377: aload 28
    //   2379: getfield 1396	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2382: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2385: putfield 1398	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:f	Ljava/lang/String;
    //   2388: aload 29
    //   2390: aload 28
    //   2392: getfield 1401	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2395: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2398: putfield 1403	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_Long	J
    //   2401: aload 29
    //   2403: aload 26
    //   2405: getfield 1357	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_Int	I
    //   2408: putfield 1404	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_Int	I
    //   2411: aload 28
    //   2413: getfield 1407	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2416: invokevirtual 1361	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2419: ifle +254 -> 2673
    //   2422: new 142	java/util/ArrayList
    //   2425: dup
    //   2426: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2429: astore 30
    //   2431: iconst_0
    //   2432: istore 6
    //   2434: iload 6
    //   2436: aload 28
    //   2438: getfield 1407	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2441: invokevirtual 1361	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2444: if_icmpge +222 -> 2666
    //   2447: aload 28
    //   2449: getfield 1407	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2452: iload 6
    //   2454: invokevirtual 1364	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2457: checkcast 1409	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2460: astore 31
    //   2462: new 1411	com/tencent/mobileqq/profile/ProfileGroupLabel
    //   2465: dup
    //   2466: invokespecial 1412	com/tencent/mobileqq/profile/ProfileGroupLabel:<init>	()V
    //   2469: astore 32
    //   2471: aload 32
    //   2473: aload 31
    //   2475: getfield 1415	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2478: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2481: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2484: putfield 1416	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2487: aload 32
    //   2489: aload 31
    //   2491: getfield 1419	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2494: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2497: i2l
    //   2498: putfield 1420	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_Long	J
    //   2501: aload 32
    //   2503: aload 31
    //   2505: getfield 1423	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2508: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2511: i2l
    //   2512: putfield 1425	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_b_of_type_Long	J
    //   2515: new 1427	com/tencent/mobileqq/profile/ProfileColor
    //   2518: dup
    //   2519: invokespecial 1428	com/tencent/mobileqq/profile/ProfileColor:<init>	()V
    //   2522: astore 33
    //   2524: aload 33
    //   2526: aload 31
    //   2528: getfield 1432	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2531: getfield 1437	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2534: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2537: i2l
    //   2538: putfield 1438	com/tencent/mobileqq/profile/ProfileColor:jdField_a_of_type_Long	J
    //   2541: aload 33
    //   2543: aload 31
    //   2545: getfield 1432	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2548: getfield 1441	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2551: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2554: i2l
    //   2555: putfield 1442	com/tencent/mobileqq/profile/ProfileColor:jdField_b_of_type_Long	J
    //   2558: aload 33
    //   2560: aload 31
    //   2562: getfield 1432	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2565: getfield 1445	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2568: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2571: i2l
    //   2572: putfield 1447	com/tencent/mobileqq/profile/ProfileColor:c	J
    //   2575: aload 32
    //   2577: aload 33
    //   2579: putfield 1450	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_b_of_type_ComTencentMobileqqProfileProfileColor	Lcom/tencent/mobileqq/profile/ProfileColor;
    //   2582: new 1427	com/tencent/mobileqq/profile/ProfileColor
    //   2585: dup
    //   2586: invokespecial 1428	com/tencent/mobileqq/profile/ProfileColor:<init>	()V
    //   2589: astore 33
    //   2591: aload 33
    //   2593: aload 31
    //   2595: getfield 1453	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2598: getfield 1437	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2601: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2604: i2l
    //   2605: putfield 1438	com/tencent/mobileqq/profile/ProfileColor:jdField_a_of_type_Long	J
    //   2608: aload 33
    //   2610: aload 31
    //   2612: getfield 1453	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2615: getfield 1441	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2618: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2621: i2l
    //   2622: putfield 1442	com/tencent/mobileqq/profile/ProfileColor:jdField_b_of_type_Long	J
    //   2625: aload 33
    //   2627: aload 31
    //   2629: getfield 1453	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2632: getfield 1445	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2635: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2638: i2l
    //   2639: putfield 1447	com/tencent/mobileqq/profile/ProfileColor:c	J
    //   2642: aload 32
    //   2644: aload 33
    //   2646: putfield 1455	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_ComTencentMobileqqProfileProfileColor	Lcom/tencent/mobileqq/profile/ProfileColor;
    //   2649: aload 30
    //   2651: aload 32
    //   2653: invokevirtual 1456	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2656: pop
    //   2657: iload 6
    //   2659: iconst_1
    //   2660: iadd
    //   2661: istore 6
    //   2663: goto -229 -> 2434
    //   2666: aload 29
    //   2668: aload 30
    //   2670: putfield 1458	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2673: aload 27
    //   2675: aload 29
    //   2677: invokevirtual 1456	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2680: pop
    //   2681: iload 5
    //   2683: iconst_1
    //   2684: iadd
    //   2685: istore 5
    //   2687: goto -418 -> 2269
    //   2690: aload 26
    //   2692: aload 27
    //   2694: putfield 1459	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2697: aload_1
    //   2698: aload 26
    //   2700: invokeinterface 177 2 0
    //   2705: pop
    //   2706: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2709: ifeq -604 -> 2105
    //   2712: ldc_w 786
    //   2715: iconst_2
    //   2716: new 49	java/lang/StringBuilder
    //   2719: dup
    //   2720: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2723: ldc_w 1461
    //   2726: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2729: aload_2
    //   2730: getfield 1355	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2733: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2736: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2739: ldc_w 1463
    //   2742: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2745: iload 9
    //   2747: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2750: ldc_w 1465
    //   2753: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2756: aload_2
    //   2757: getfield 1468	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2760: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2763: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2766: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2769: goto -664 -> 2105
    //   2772: astore_2
    //   2773: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2776: ifeq -671 -> 2105
    //   2779: ldc_w 786
    //   2782: iconst_2
    //   2783: aload_2
    //   2784: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   2787: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2790: goto -685 -> 2105
    //   2793: new 142	java/util/ArrayList
    //   2796: dup
    //   2797: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2800: astore_1
    //   2801: aload 25
    //   2803: getfield 1471	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2806: ifnull +379 -> 3185
    //   2809: aload 25
    //   2811: getfield 1471	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2814: invokevirtual 1276	java/util/ArrayList:size	()I
    //   2817: ifle +368 -> 3185
    //   2820: iconst_0
    //   2821: istore 4
    //   2823: iload 4
    //   2825: aload 25
    //   2827: getfield 1471	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2830: invokevirtual 1276	java/util/ArrayList:size	()I
    //   2833: if_icmpge +352 -> 3185
    //   2836: aload 25
    //   2838: getfield 1471	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2841: iload 4
    //   2843: invokevirtual 1277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2846: checkcast 645	[B
    //   2849: astore 26
    //   2851: aload 26
    //   2853: ifnonnull +22 -> 2875
    //   2856: iconst_0
    //   2857: istore 5
    //   2859: iload 5
    //   2861: bipush 10
    //   2863: if_icmpgt +20 -> 2883
    //   2866: iload 4
    //   2868: iconst_1
    //   2869: iadd
    //   2870: istore 4
    //   2872: goto -49 -> 2823
    //   2875: aload 26
    //   2877: arraylength
    //   2878: istore 5
    //   2880: goto -21 -> 2859
    //   2883: aload 26
    //   2885: iconst_1
    //   2886: invokestatic 1319	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2889: l2i
    //   2890: istore 6
    //   2892: aload 26
    //   2894: iconst_5
    //   2895: invokestatic 1319	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2898: l2i
    //   2899: istore 9
    //   2901: iload 6
    //   2903: ifle -37 -> 2866
    //   2906: iload 6
    //   2908: bipush 9
    //   2910: iadd
    //   2911: iload 5
    //   2913: if_icmpge -47 -> 2866
    //   2916: iload 6
    //   2918: newarray byte
    //   2920: astore_2
    //   2921: aload_2
    //   2922: iconst_0
    //   2923: aload 26
    //   2925: bipush 9
    //   2927: iload 6
    //   2929: invokestatic 1322	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   2932: new 1324	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2935: dup
    //   2936: invokespecial 1325	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2939: astore 26
    //   2941: aload 26
    //   2943: aload_2
    //   2944: invokevirtual 1326	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2947: pop
    //   2948: aload 26
    //   2950: getfield 1330	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2953: invokevirtual 1333	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2956: istore 5
    //   2958: iload 5
    //   2960: ifne +157 -> 3117
    //   2963: new 1473	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   2966: dup
    //   2967: invokespecial 1474	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   2970: astore_2
    //   2971: aload_2
    //   2972: aload 26
    //   2974: getfield 1355	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2977: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2980: putfield 1475	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   2983: aload 26
    //   2985: getfield 1479	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2988: ifnull +102 -> 3090
    //   2991: aload_2
    //   2992: aload 26
    //   2994: getfield 1479	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2997: getfield 1484	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3000: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3003: putfield 1485	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3006: aload_2
    //   3007: aload 26
    //   3009: getfield 1479	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3012: getfield 1488	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3015: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3018: putfield 1489	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3021: aload_2
    //   3022: aload 26
    //   3024: getfield 1479	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3027: getfield 1492	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3030: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3033: putfield 1493	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   3036: aload_2
    //   3037: aload 26
    //   3039: getfield 1479	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3042: getfield 1496	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3045: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3048: putfield 1497	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3051: aload_2
    //   3052: invokevirtual 1499	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   3055: ifne -189 -> 2866
    //   3058: aload_1
    //   3059: aload_2
    //   3060: invokeinterface 177 2 0
    //   3065: pop
    //   3066: goto -200 -> 2866
    //   3069: astore_2
    //   3070: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3073: ifeq -207 -> 2866
    //   3076: ldc_w 786
    //   3079: iconst_2
    //   3080: aload_2
    //   3081: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   3084: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3087: goto -221 -> 2866
    //   3090: aload_2
    //   3091: ldc 216
    //   3093: putfield 1485	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3096: aload_2
    //   3097: ldc 216
    //   3099: putfield 1489	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3102: aload_2
    //   3103: ldc 216
    //   3105: putfield 1493	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   3108: aload_2
    //   3109: ldc 216
    //   3111: putfield 1497	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3114: goto -63 -> 3051
    //   3117: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3120: ifeq -254 -> 2866
    //   3123: ldc_w 786
    //   3126: iconst_4
    //   3127: new 49	java/lang/StringBuilder
    //   3130: dup
    //   3131: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3134: ldc_w 1501
    //   3137: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: aload 26
    //   3142: getfield 1355	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3145: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3148: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3151: ldc_w 1503
    //   3154: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3157: iload 5
    //   3159: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3162: ldc_w 1503
    //   3165: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: aload 26
    //   3170: getfield 1468	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3173: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3176: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3179: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3182: goto -316 -> 2866
    //   3185: aload_3
    //   3186: aload_1
    //   3187: invokevirtual 1507	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   3190: aload 25
    //   3192: getfield 1511	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3195: ifnonnull +128 -> 3323
    //   3198: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3201: ifeq +13 -> 3214
    //   3204: ldc_w 786
    //   3207: iconst_2
    //   3208: ldc_w 1513
    //   3211: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3214: aload 25
    //   3216: getfield 1516	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3219: ifnull +1274 -> 4493
    //   3222: new 1518	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   3225: dup
    //   3226: invokespecial 1519	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   3229: astore_1
    //   3230: aload_1
    //   3231: aload 25
    //   3233: getfield 1516	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3236: invokevirtual 1520	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3239: pop
    //   3240: aload_1
    //   3241: ifnull +2414 -> 5655
    //   3244: aload_1
    //   3245: getfield 1523	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3248: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3251: astore_1
    //   3252: new 142	java/util/ArrayList
    //   3255: dup
    //   3256: invokespecial 143	java/util/ArrayList:<init>	()V
    //   3259: astore_2
    //   3260: aload_1
    //   3261: ifnull +157 -> 3418
    //   3264: aload_1
    //   3265: invokeinterface 157 1 0
    //   3270: astore_1
    //   3271: aload_1
    //   3272: invokeinterface 162 1 0
    //   3277: ifeq +141 -> 3418
    //   3280: aload_1
    //   3281: invokeinterface 166 1 0
    //   3286: checkcast 1525	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   3289: astore 26
    //   3291: aload 26
    //   3293: getfield 1528	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3296: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3299: iconst_1
    //   3300: if_icmpne +112 -> 3412
    //   3303: iconst_1
    //   3304: istore 21
    //   3306: aload_2
    //   3307: aload 26
    //   3309: iload 21
    //   3311: invokestatic 1534	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   3314: invokeinterface 177 2 0
    //   3319: pop
    //   3320: goto -49 -> 3271
    //   3323: aload 25
    //   3325: getfield 1511	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3328: getfield 1539	SummaryCard/InterestTagInfo:uFlag	J
    //   3331: lstore 16
    //   3333: new 1541	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   3336: dup
    //   3337: invokespecial 1542	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   3340: astore_1
    //   3341: aload_1
    //   3342: aload 25
    //   3344: getfield 1511	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3347: getfield 1545	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   3350: invokevirtual 1546	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3353: pop
    //   3354: aload_3
    //   3355: lload 16
    //   3357: aload_1
    //   3358: getfield 1549	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3361: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3364: invokevirtual 479	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   3367: goto -153 -> 3214
    //   3370: astore_1
    //   3371: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3374: ifeq -160 -> 3214
    //   3377: ldc_w 1551
    //   3380: iconst_2
    //   3381: aload_1
    //   3382: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   3385: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3388: goto -174 -> 3214
    //   3391: astore_2
    //   3392: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3395: ifeq -155 -> 3240
    //   3398: ldc_w 786
    //   3401: iconst_2
    //   3402: aload_2
    //   3403: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   3406: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3409: goto -169 -> 3240
    //   3412: iconst_0
    //   3413: istore 21
    //   3415: goto -109 -> 3306
    //   3418: aload_2
    //   3419: invokeinterface 153 1 0
    //   3424: ifle +2231 -> 5655
    //   3427: iconst_0
    //   3428: istore 4
    //   3430: iload 4
    //   3432: aload_2
    //   3433: invokeinterface 153 1 0
    //   3438: if_icmpge +2217 -> 5655
    //   3441: aload_2
    //   3442: iload 4
    //   3444: invokeinterface 208 2 0
    //   3449: checkcast 1530	com/tencent/mobileqq/data/HotChatInfo
    //   3452: astore_1
    //   3453: aload_1
    //   3454: ifnull +1030 -> 4484
    //   3457: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3460: ifeq +30 -> 3490
    //   3463: ldc_w 786
    //   3466: iconst_2
    //   3467: new 49	java/lang/StringBuilder
    //   3470: dup
    //   3471: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3474: ldc_w 1553
    //   3477: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3480: aload_1
    //   3481: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3490: aload_1
    //   3491: ifnull +8 -> 3499
    //   3494: aload_3
    //   3495: aload_1
    //   3496: invokevirtual 1557	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   3499: aload_3
    //   3500: getfield 1040	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3503: ifnull +399 -> 3902
    //   3506: new 1559	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   3509: dup
    //   3510: invokespecial 1560	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   3513: astore_1
    //   3514: aload_1
    //   3515: aload_3
    //   3516: getfield 1040	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3519: invokevirtual 1561	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3522: pop
    //   3523: iload 8
    //   3525: bipush 51
    //   3527: if_icmpne +997 -> 4524
    //   3530: aload_1
    //   3531: getfield 1564	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3534: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3537: iconst_1
    //   3538: if_icmpne +974 -> 4512
    //   3541: iconst_1
    //   3542: istore 21
    //   3544: aload_3
    //   3545: iload 21
    //   3547: putfield 1118	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   3550: aload_1
    //   3551: getfield 1567	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3554: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3557: iconst_1
    //   3558: if_icmpne +960 -> 4518
    //   3561: iconst_1
    //   3562: istore 21
    //   3564: aload_3
    //   3565: iload 21
    //   3567: putfield 1109	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   3570: aload_3
    //   3571: aload_1
    //   3572: getfield 1570	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3575: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3578: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3581: putfield 1130	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   3584: aload_3
    //   3585: aload_1
    //   3586: getfield 1573	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3589: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3592: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3595: putfield 1124	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   3598: aload_3
    //   3599: aload_1
    //   3600: getfield 1576	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3603: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3606: putfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   3609: aload_1
    //   3610: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3613: invokevirtual 1583	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   3616: ifeq +1010 -> 4626
    //   3619: aload_3
    //   3620: aload_1
    //   3621: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3624: invokevirtual 1584	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3627: checkcast 1582	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3630: getfield 1587	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3633: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3636: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3639: putfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3642: aload_3
    //   3643: aload_1
    //   3644: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3647: invokevirtual 1584	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3650: checkcast 1582	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3653: getfield 1590	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3656: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3659: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3662: putfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3665: aload_3
    //   3666: aload_1
    //   3667: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3670: invokevirtual 1584	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3673: checkcast 1582	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3676: getfield 1593	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3679: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3682: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3685: aload_3
    //   3686: aload_1
    //   3687: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3690: invokevirtual 1584	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3693: checkcast 1582	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3696: getfield 1596	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3699: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3702: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3705: putfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3708: aload_3
    //   3709: aload_1
    //   3710: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3713: invokevirtual 1584	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3716: checkcast 1582	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3719: getfield 1599	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3722: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3725: putfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3728: aload_3
    //   3729: aload_1
    //   3730: getfield 1580	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3733: invokevirtual 1584	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3736: checkcast 1582	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3739: getfield 1602	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3742: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3745: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3748: aload_1
    //   3749: getfield 1605	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3752: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3755: iconst_1
    //   3756: if_icmpne +906 -> 4662
    //   3759: iconst_1
    //   3760: istore 21
    //   3762: aload_3
    //   3763: iload 21
    //   3765: putfield 1608	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3768: aload_3
    //   3769: aload_1
    //   3770: getfield 1611	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3773: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3776: putfield 1614	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3779: aload_3
    //   3780: aload_1
    //   3781: getfield 1617	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3784: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3787: putfield 1620	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3790: aload_3
    //   3791: aload_1
    //   3792: getfield 1623	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3795: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3798: putfield 1626	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3801: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3804: ifeq +98 -> 3902
    //   3807: ldc_w 1628
    //   3810: iconst_2
    //   3811: new 49	java/lang/StringBuilder
    //   3814: dup
    //   3815: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3818: ldc_w 1630
    //   3821: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3824: aload_3
    //   3825: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   3828: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3831: ldc_w 1632
    //   3834: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: aload_3
    //   3838: getfield 1608	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3841: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3844: ldc_w 1634
    //   3847: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: aload_3
    //   3851: invokevirtual 1637	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   3854: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3857: ldc_w 1639
    //   3860: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3863: aload_3
    //   3864: getfield 1614	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3867: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3870: ldc_w 1641
    //   3873: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3876: aload_3
    //   3877: getfield 1626	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3880: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3883: ldc_w 1643
    //   3886: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3889: aload_3
    //   3890: getfield 1620	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3893: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3896: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3899: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3902: aload 25
    //   3904: getfield 1647	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3907: ifnull +27 -> 3934
    //   3910: aload_3
    //   3911: aload 25
    //   3913: getfield 1647	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3916: getfield 1652	SummaryCard/GiftInfo:uOpenFlag	J
    //   3919: putfield 581	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   3922: aload_3
    //   3923: aload 25
    //   3925: getfield 1647	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3928: getfield 1653	SummaryCard/GiftInfo:vGiftInfo	[B
    //   3931: putfield 1654	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   3934: aload 25
    //   3936: getfield 1657	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   3939: ifnull +162 -> 4101
    //   3942: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3945: ifeq +12 -> 3957
    //   3948: ldc 24
    //   3950: iconst_2
    //   3951: ldc_w 1659
    //   3954: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3957: new 1661	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   3960: dup
    //   3961: invokespecial 1662	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   3964: astore_1
    //   3965: aload_1
    //   3966: aload 25
    //   3968: getfield 1657	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   3971: invokevirtual 1663	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3974: pop
    //   3975: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3978: ifeq +82 -> 4060
    //   3981: ldc 24
    //   3983: iconst_2
    //   3984: new 49	java/lang/StringBuilder
    //   3987: dup
    //   3988: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3991: ldc_w 1665
    //   3994: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3997: aload_1
    //   3998: getfield 1668	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4001: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4004: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4007: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4010: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4013: aload_1
    //   4014: getfield 1671	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4017: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4020: ifeq +40 -> 4060
    //   4023: ldc 24
    //   4025: iconst_2
    //   4026: new 49	java/lang/StringBuilder
    //   4029: dup
    //   4030: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4033: ldc_w 1673
    //   4036: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4039: aload_1
    //   4040: getfield 1671	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4043: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4046: invokeinterface 153 1 0
    //   4051: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4054: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4057: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4060: aload_1
    //   4061: getfield 1668	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4064: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4067: iconst_1
    //   4068: if_icmpne +600 -> 4668
    //   4071: iconst_1
    //   4072: istore 21
    //   4074: aload_3
    //   4075: iload 21
    //   4077: putfield 1676	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   4080: aload_1
    //   4081: getfield 1671	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4084: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4087: ifeq +14 -> 4101
    //   4090: aload_3
    //   4091: aload_1
    //   4092: getfield 1671	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4095: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4098: invokevirtual 1679	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   4101: aload 25
    //   4103: getfield 1682	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   4106: astore_1
    //   4107: aload_1
    //   4108: ifnull +39 -> 4147
    //   4111: new 1684	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   4114: dup
    //   4115: invokespecial 1685	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   4118: astore_2
    //   4119: aload_2
    //   4120: aload_1
    //   4121: invokevirtual 1686	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4124: pop
    //   4125: aload_3
    //   4126: aload_2
    //   4127: getfield 1689	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4130: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4133: putfield 1692	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   4136: aload_3
    //   4137: aload_2
    //   4138: getfield 1695	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4141: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4144: putfield 1698	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   4147: aload 25
    //   4149: getfield 1701	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4152: astore_1
    //   4153: aload_1
    //   4154: ifnull +571 -> 4725
    //   4157: aload_3
    //   4158: new 142	java/util/ArrayList
    //   4161: dup
    //   4162: invokespecial 143	java/util/ArrayList:<init>	()V
    //   4165: putfield 1704	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4168: new 1706	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   4171: dup
    //   4172: invokespecial 1707	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   4175: astore_2
    //   4176: aload_2
    //   4177: aload_1
    //   4178: invokevirtual 1708	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4181: pop
    //   4182: aload_2
    //   4183: getfield 1711	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4186: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4189: astore_1
    //   4190: aload_1
    //   4191: ifnull +534 -> 4725
    //   4194: new 1095	org/json/JSONArray
    //   4197: dup
    //   4198: invokespecial 1096	org/json/JSONArray:<init>	()V
    //   4201: astore_2
    //   4202: iconst_0
    //   4203: istore 4
    //   4205: iload 4
    //   4207: aload_1
    //   4208: invokeinterface 153 1 0
    //   4213: if_icmpge +500 -> 4713
    //   4216: new 1713	org/json/JSONObject
    //   4219: dup
    //   4220: invokespecial 1714	org/json/JSONObject:<init>	()V
    //   4223: astore 26
    //   4225: new 1716	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   4228: dup
    //   4229: invokespecial 1717	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   4232: astore 27
    //   4234: aload 27
    //   4236: aload_1
    //   4237: iload 4
    //   4239: invokeinterface 208 2 0
    //   4244: checkcast 1719	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4247: getfield 1722	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4250: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4253: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4256: putfield 1724	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4259: aload 27
    //   4261: getfield 1724	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4264: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4267: ifne +17 -> 4284
    //   4270: aload 26
    //   4272: ldc_w 1725
    //   4275: aload 27
    //   4277: getfield 1724	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4280: invokevirtual 1728	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4283: pop
    //   4284: aload 27
    //   4286: aload_1
    //   4287: iload 4
    //   4289: invokeinterface 208 2 0
    //   4294: checkcast 1719	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4297: getfield 1731	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4300: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4303: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4306: putfield 1734	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4309: aload 27
    //   4311: getfield 1734	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4314: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4317: ifne +17 -> 4334
    //   4320: aload 26
    //   4322: ldc_w 1735
    //   4325: aload 27
    //   4327: getfield 1734	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4330: invokevirtual 1728	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4333: pop
    //   4334: aload 27
    //   4336: aload_1
    //   4337: iload 4
    //   4339: invokeinterface 208 2 0
    //   4344: checkcast 1719	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4347: getfield 1738	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4350: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4353: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4356: putfield 1740	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4359: aload 27
    //   4361: getfield 1740	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4364: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4367: ifne +17 -> 4384
    //   4370: aload 26
    //   4372: ldc_w 1741
    //   4375: aload 27
    //   4377: getfield 1740	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4380: invokevirtual 1728	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4383: pop
    //   4384: aload 27
    //   4386: aload_1
    //   4387: iload 4
    //   4389: invokeinterface 208 2 0
    //   4394: checkcast 1719	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4397: getfield 1744	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4400: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4403: putfield 1747	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4406: aload 26
    //   4408: ldc_w 1748
    //   4411: aload 27
    //   4413: getfield 1747	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4416: invokevirtual 1751	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4419: pop
    //   4420: aload 27
    //   4422: aload_1
    //   4423: iload 4
    //   4425: invokeinterface 208 2 0
    //   4430: checkcast 1719	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4433: getfield 1754	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4436: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4439: putfield 1757	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4442: aload 26
    //   4444: ldc_w 1758
    //   4447: aload 27
    //   4449: getfield 1757	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4452: invokevirtual 1751	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4455: pop
    //   4456: aload_3
    //   4457: getfield 1704	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4460: aload 27
    //   4462: invokeinterface 177 2 0
    //   4467: pop
    //   4468: aload_2
    //   4469: aload 26
    //   4471: invokevirtual 1099	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4474: pop
    //   4475: iload 4
    //   4477: iconst_1
    //   4478: iadd
    //   4479: istore 4
    //   4481: goto -276 -> 4205
    //   4484: iload 4
    //   4486: iconst_1
    //   4487: iadd
    //   4488: istore 4
    //   4490: goto -1060 -> 3430
    //   4493: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4496: ifeq -997 -> 3499
    //   4499: ldc_w 786
    //   4502: iconst_2
    //   4503: ldc_w 1760
    //   4506: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4509: goto -1010 -> 3499
    //   4512: iconst_0
    //   4513: istore 21
    //   4515: goto -971 -> 3544
    //   4518: iconst_0
    //   4519: istore 21
    //   4521: goto -957 -> 3564
    //   4524: aload_1
    //   4525: getfield 1564	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4528: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4531: iconst_1
    //   4532: if_icmpne +82 -> 4614
    //   4535: iconst_1
    //   4536: istore 21
    //   4538: aload_3
    //   4539: iload 21
    //   4541: putfield 1112	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4544: aload_1
    //   4545: getfield 1567	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4548: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4551: iconst_1
    //   4552: if_icmpne +68 -> 4620
    //   4555: iconst_1
    //   4556: istore 21
    //   4558: aload_3
    //   4559: iload 21
    //   4561: putfield 1106	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4564: aload_3
    //   4565: aload_1
    //   4566: getfield 1570	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4569: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4572: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4575: putfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4578: aload_3
    //   4579: aload_1
    //   4580: getfield 1573	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4583: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4586: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4589: putfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4592: goto -994 -> 3598
    //   4595: astore_1
    //   4596: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4599: ifeq -697 -> 3902
    //   4602: ldc 24
    //   4604: iconst_2
    //   4605: ldc_w 1762
    //   4608: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4611: goto -709 -> 3902
    //   4614: iconst_0
    //   4615: istore 21
    //   4617: goto -79 -> 4538
    //   4620: iconst_0
    //   4621: istore 21
    //   4623: goto -65 -> 4558
    //   4626: aload_3
    //   4627: ldc 216
    //   4629: putfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4632: aload_3
    //   4633: ldc 216
    //   4635: putfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4638: aload_3
    //   4639: iconst_0
    //   4640: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4643: aload_3
    //   4644: ldc 216
    //   4646: putfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4649: aload_3
    //   4650: iconst_0
    //   4651: putfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4654: aload_3
    //   4655: iconst_0
    //   4656: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4659: goto -911 -> 3748
    //   4662: iconst_0
    //   4663: istore 21
    //   4665: goto -903 -> 3762
    //   4668: iconst_0
    //   4669: istore 21
    //   4671: goto -597 -> 4074
    //   4674: astore_1
    //   4675: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4678: ifeq -577 -> 4101
    //   4681: ldc 24
    //   4683: iconst_2
    //   4684: new 49	java/lang/StringBuilder
    //   4687: dup
    //   4688: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4691: ldc_w 1764
    //   4694: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4697: aload_1
    //   4698: invokevirtual 1765	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4701: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4704: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4707: invokestatic 1286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4710: goto -609 -> 4101
    //   4713: aload_2
    //   4714: ifnull +11 -> 4725
    //   4717: aload_3
    //   4718: aload_2
    //   4719: invokevirtual 1165	org/json/JSONArray:toString	()Ljava/lang/String;
    //   4722: putfield 1768	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   4725: aload_3
    //   4726: aload 25
    //   4728: getfield 1701	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4731: putfield 1771	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   4734: new 1773	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   4737: dup
    //   4738: invokespecial 1774	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   4741: astore_2
    //   4742: aload_2
    //   4743: aload 25
    //   4745: getfield 1701	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4748: invokevirtual 1775	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4751: pop
    //   4752: aload_2
    //   4753: astore_1
    //   4754: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4757: ifeq +70 -> 4827
    //   4760: ldc_w 1777
    //   4763: iconst_2
    //   4764: new 49	java/lang/StringBuilder
    //   4767: dup
    //   4768: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4771: ldc_w 1779
    //   4774: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4777: aload_2
    //   4778: getfield 1782	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4781: invokevirtual 439	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4784: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4787: ldc_w 1784
    //   4790: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4793: aload_2
    //   4794: getfield 1787	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4797: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4800: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4803: ldc_w 1789
    //   4806: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4809: aload_2
    //   4810: getfield 1792	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4813: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4816: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4819: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4822: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4825: aload_2
    //   4826: astore_1
    //   4827: aload_3
    //   4828: aload_1
    //   4829: putfield 1796	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   4832: aload_0
    //   4833: bipush 51
    //   4835: iconst_1
    //   4836: aload_3
    //   4837: iload 22
    //   4839: invokevirtual 1799	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;Z)V
    //   4842: aload_0
    //   4843: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4846: bipush 105
    //   4848: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4851: checkcast 511	com/tencent/mobileqq/nearby/NearbyCardManager
    //   4854: astore_1
    //   4855: iload 8
    //   4857: bipush 51
    //   4859: if_icmpne +444 -> 5303
    //   4862: aload_1
    //   4863: aload_3
    //   4864: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   4867: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   4870: invokevirtual 1802	com/tencent/mobileqq/nearby/NearbyCardManager:b	(Ljava/lang/String;J)V
    //   4873: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   4876: ifeq +45 -> 4921
    //   4879: ldc_w 356
    //   4882: iconst_4
    //   4883: new 49	java/lang/StringBuilder
    //   4886: dup
    //   4887: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4890: ldc_w 1804
    //   4893: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4896: aload_3
    //   4897: getfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   4900: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4903: ldc_w 1806
    //   4906: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4909: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   4912: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4915: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4918: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4921: aload_0
    //   4922: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4925: bipush 50
    //   4927: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4930: checkcast 1808	com/tencent/mobileqq/app/FriendsManager
    //   4933: astore_1
    //   4934: invokestatic 1810	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   4937: ifeq +54 -> 4991
    //   4940: ldc 24
    //   4942: iconst_5
    //   4943: anewarray 79	java/lang/Object
    //   4946: dup
    //   4947: iconst_0
    //   4948: ldc_w 1812
    //   4951: aastore
    //   4952: dup
    //   4953: iconst_1
    //   4954: iload 8
    //   4956: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4959: aastore
    //   4960: dup
    //   4961: iconst_2
    //   4962: aload_3
    //   4963: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   4966: aastore
    //   4967: dup
    //   4968: iconst_3
    //   4969: aload_0
    //   4970: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4973: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4976: aastore
    //   4977: dup
    //   4978: iconst_4
    //   4979: aload 25
    //   4981: getfield 847	SummaryCard/RespSummaryCard:lUIN	J
    //   4984: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4987: aastore
    //   4988: invokestatic 1820	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   4991: iload 8
    //   4993: ifeq +20 -> 5013
    //   4996: aload_3
    //   4997: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5000: aload_0
    //   5001: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5004: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5007: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5010: ifeq +72 -> 5082
    //   5013: aload_1
    //   5014: aload_3
    //   5015: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5018: invokevirtual 1823	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   5021: astore_2
    //   5022: aload_2
    //   5023: aload_3
    //   5024: getfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   5027: putfield 1828	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5030: aload_2
    //   5031: aload_3
    //   5032: getfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   5035: i2l
    //   5036: putfield 1831	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5039: aload_0
    //   5040: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5043: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5046: aload_2
    //   5047: getfield 1831	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5050: aload_2
    //   5051: getfield 1828	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5054: invokestatic 1834	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   5057: pop
    //   5058: aload_1
    //   5059: aload_2
    //   5060: invokevirtual 1837	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5063: pop
    //   5064: aload_0
    //   5065: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5068: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5071: ldc_w 544
    //   5074: aload_3
    //   5075: getfield 542	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   5078: invokestatic 458	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   5081: pop
    //   5082: aload_0
    //   5083: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5086: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5089: aload_3
    //   5090: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5093: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5096: ifeq +29 -> 5125
    //   5099: aload_3
    //   5100: getfield 1207	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5103: ifle +22 -> 5125
    //   5106: aload_0
    //   5107: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5110: bipush 59
    //   5112: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5115: checkcast 1839	com/tencent/mobileqq/app/HotChatManager
    //   5118: aload_3
    //   5119: getfield 1207	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5122: invokevirtual 1840	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   5125: aload_1
    //   5126: aload_3
    //   5127: invokevirtual 1843	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   5130: aload_3
    //   5131: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5134: sipush 1000
    //   5137: if_icmpne +435 -> 5572
    //   5140: aload 23
    //   5142: iconst_0
    //   5143: ldc_w 413
    //   5146: invokevirtual 273	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5149: aconst_null
    //   5150: aconst_null
    //   5151: aconst_null
    //   5152: aconst_null
    //   5153: aconst_null
    //   5154: aconst_null
    //   5155: aconst_null
    //   5156: invokevirtual 1846	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5159: astore_2
    //   5160: aload_2
    //   5161: ifnull +286 -> 5447
    //   5164: aload_2
    //   5165: astore_1
    //   5166: aload_2
    //   5167: invokeinterface 1851 1 0
    //   5172: istore 4
    //   5174: aload_2
    //   5175: astore_1
    //   5176: aload_2
    //   5177: invokeinterface 1854 1 0
    //   5182: pop
    //   5183: iload 4
    //   5185: sipush 200
    //   5188: if_icmple +259 -> 5447
    //   5191: iload 4
    //   5193: bipush 100
    //   5195: if_icmple +130 -> 5325
    //   5198: aload_2
    //   5199: astore_1
    //   5200: aload_2
    //   5201: invokeinterface 1857 1 0
    //   5206: pop
    //   5207: iload 4
    //   5209: iconst_1
    //   5210: isub
    //   5211: istore 4
    //   5213: goto -22 -> 5191
    //   5216: astore_1
    //   5217: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5220: ifeq -495 -> 4725
    //   5223: ldc 24
    //   5225: iconst_2
    //   5226: new 49	java/lang/StringBuilder
    //   5229: dup
    //   5230: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5233: ldc_w 1859
    //   5236: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5239: aload_1
    //   5240: invokevirtual 627	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5243: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5246: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5249: invokestatic 1286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5252: goto -527 -> 4725
    //   5255: astore 26
    //   5257: aconst_null
    //   5258: astore_2
    //   5259: aload_2
    //   5260: astore_1
    //   5261: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5264: ifeq -437 -> 4827
    //   5267: ldc_w 1777
    //   5270: iconst_2
    //   5271: new 49	java/lang/StringBuilder
    //   5274: dup
    //   5275: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5278: ldc_w 1861
    //   5281: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5284: aload 26
    //   5286: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   5289: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5292: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5295: invokestatic 1164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5298: aload_2
    //   5299: astore_1
    //   5300: goto -473 -> 4827
    //   5303: aload_1
    //   5304: aload_3
    //   5305: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5308: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   5311: invokevirtual 1863	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   5314: goto -441 -> 4873
    //   5317: astore_2
    //   5318: aload_2
    //   5319: invokevirtual 1864	java/lang/Exception:printStackTrace	()V
    //   5322: goto -240 -> 5082
    //   5325: aload_2
    //   5326: astore_1
    //   5327: aload_2
    //   5328: aload_2
    //   5329: ldc_w 1866
    //   5332: invokeinterface 1869 2 0
    //   5337: invokeinterface 1872 2 0
    //   5342: istore 4
    //   5344: aload_2
    //   5345: astore_1
    //   5346: new 49	java/lang/StringBuilder
    //   5349: dup
    //   5350: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5353: astore 25
    //   5355: aload_2
    //   5356: astore_1
    //   5357: aload 25
    //   5359: ldc_w 1874
    //   5362: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5365: pop
    //   5366: aload_2
    //   5367: astore_1
    //   5368: aload 25
    //   5370: ldc_w 413
    //   5373: invokevirtual 273	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5376: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5379: pop
    //   5380: aload_2
    //   5381: astore_1
    //   5382: aload 25
    //   5384: ldc_w 1876
    //   5387: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5390: pop
    //   5391: aload_2
    //   5392: astore_1
    //   5393: aload 25
    //   5395: ldc_w 1866
    //   5398: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5401: pop
    //   5402: aload_2
    //   5403: astore_1
    //   5404: aload 25
    //   5406: ldc_w 1878
    //   5409: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5412: pop
    //   5413: aload_2
    //   5414: astore_1
    //   5415: aload 25
    //   5417: iload 4
    //   5419: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5422: pop
    //   5423: aload_2
    //   5424: astore_1
    //   5425: aload 25
    //   5427: ldc_w 279
    //   5430: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5433: pop
    //   5434: aload_2
    //   5435: astore_1
    //   5436: aload 23
    //   5438: aload 25
    //   5440: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5443: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   5446: pop
    //   5447: aload_2
    //   5448: astore_1
    //   5449: aload 23
    //   5451: aload_3
    //   5452: invokevirtual 586	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   5455: aload_2
    //   5456: astore_1
    //   5457: aload 24
    //   5459: invokevirtual 1880	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   5462: aload_2
    //   5463: ifnull +9 -> 5472
    //   5466: aload_2
    //   5467: invokeinterface 1883 1 0
    //   5472: aload 24
    //   5474: invokevirtual 1885	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   5477: aload 23
    //   5479: invokevirtual 354	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   5482: new 588	java/util/HashMap
    //   5485: dup
    //   5486: invokespecial 589	java/util/HashMap:<init>	()V
    //   5489: astore_1
    //   5490: aload_1
    //   5491: ldc_w 591
    //   5494: iload 7
    //   5496: invokestatic 594	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5499: invokevirtual 598	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5502: pop
    //   5503: invokestatic 604	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5506: invokestatic 609	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   5509: aload_0
    //   5510: getfield 612	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5513: invokevirtual 615	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5516: ldc_w 1887
    //   5519: iload 20
    //   5521: lload 14
    //   5523: lload 12
    //   5525: lsub
    //   5526: lconst_0
    //   5527: aload_1
    //   5528: ldc 216
    //   5530: invokevirtual 620	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   5533: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5536: ifeq -5523 -> 13
    //   5539: ldc_w 786
    //   5542: iconst_4
    //   5543: new 49	java/lang/StringBuilder
    //   5546: dup
    //   5547: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5550: ldc_w 1889
    //   5553: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5556: invokestatic 796	java/lang/System:currentTimeMillis	()J
    //   5559: lload 10
    //   5561: lsub
    //   5562: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5565: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5568: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5571: return
    //   5572: aload_3
    //   5573: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5576: sipush 1001
    //   5579: if_icmpeq +13 -> 5592
    //   5582: aload_3
    //   5583: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5586: sipush 1002
    //   5589: if_icmpne +10 -> 5599
    //   5592: aload 23
    //   5594: aload_3
    //   5595: invokevirtual 633	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   5598: pop
    //   5599: aconst_null
    //   5600: astore_2
    //   5601: goto -146 -> 5455
    //   5604: astore_2
    //   5605: aconst_null
    //   5606: astore_1
    //   5607: aload_1
    //   5608: ifnull +9 -> 5617
    //   5611: aload_1
    //   5612: invokeinterface 1883 1 0
    //   5617: aload 24
    //   5619: invokevirtual 1885	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   5622: aload 23
    //   5624: invokevirtual 354	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   5627: aload_2
    //   5628: athrow
    //   5629: aload_0
    //   5630: bipush 51
    //   5632: iconst_0
    //   5633: aconst_null
    //   5634: iload 22
    //   5636: invokevirtual 1799	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;Z)V
    //   5639: goto -157 -> 5482
    //   5642: astore_2
    //   5643: goto -36 -> 5607
    //   5646: astore_1
    //   5647: goto -1500 -> 4147
    //   5650: astore 23
    //   5652: goto -4535 -> 1117
    //   5655: aconst_null
    //   5656: astore_1
    //   5657: goto -2200 -> 3457
    //   5660: goto -5316 -> 344
    //   5663: aconst_null
    //   5664: astore_2
    //   5665: goto -5461 -> 204
    //   5668: lconst_0
    //   5669: lstore 10
    //   5671: goto -5610 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5674	0	this	NearbyCardHandler
    //   0	5674	1	paramToServiceMsg	ToServiceMsg
    //   0	5674	2	paramFromServiceMsg	FromServiceMsg
    //   0	5674	3	paramObject	Object
    //   1020	4398	4	i	int
    //   2096	1062	5	j	int
    //   2135	793	6	k	int
    //   94	5401	7	m	int
    //   214	4778	8	n	int
    //   2143	757	9	i1	int
    //   59	5611	10	l1	long
    //   83	5441	12	l2	long
    //   88	5434	14	l3	long
    //   262	3094	16	l4	long
    //   1151	146	18	l5	long
    //   114	5406	20	bool1	boolean
    //   1631	3039	21	bool2	boolean
    //   71	5564	22	bool3	boolean
    //   97	5526	23	localObject1	Object
    //   5650	1	23	localException1	Exception
    //   176	71	24	localObject2	Object
    //   1108	4510	24	localException2	Exception
    //   225	5214	25	localObject3	Object
    //   938	97	26	localObject4	Object
    //   1822	25	26	localException3	Exception
    //   2164	2306	26	localObject5	Object
    //   5255	30	26	localException4	Exception
    //   963	3498	27	localObject6	Object
    //   991	1457	28	localObject7	Object
    //   2308	368	29	localProfileSummaryHobbiesItem	com.tencent.mobileqq.profile.ProfileSummaryHobbiesItem
    //   2429	240	30	localArrayList	ArrayList
    //   2460	168	31	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2469	183	32	localProfileGroupLabel	com.tencent.mobileqq.profile.ProfileGroupLabel
    //   2522	123	33	localProfileColor	com.tencent.mobileqq.profile.ProfileColor
    // Exception table:
    //   from	to	target	type
    //   121	143	1108	java/lang/Exception
    //   965	1019	1822	java/lang/Exception
    //   1022	1071	1822	java/lang/Exception
    //   1413	1422	1822	java/lang/Exception
    //   2185	2210	2772	java/lang/Exception
    //   2215	2266	2772	java/lang/Exception
    //   2269	2431	2772	java/lang/Exception
    //   2434	2657	2772	java/lang/Exception
    //   2666	2673	2772	java/lang/Exception
    //   2673	2681	2772	java/lang/Exception
    //   2690	2697	2772	java/lang/Exception
    //   2697	2769	2772	java/lang/Exception
    //   2941	2958	3069	java/lang/Exception
    //   2963	3051	3069	java/lang/Exception
    //   3051	3066	3069	java/lang/Exception
    //   3090	3114	3069	java/lang/Exception
    //   3117	3182	3069	java/lang/Exception
    //   3333	3367	3370	java/lang/Exception
    //   3230	3240	3391	java/lang/Exception
    //   3514	3523	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3530	3541	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3544	3561	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3564	3598	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3598	3748	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3748	3759	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3762	3902	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4524	4535	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4538	4555	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4558	4592	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4626	4659	4595	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3942	3957	4674	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3957	4060	4674	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4060	4071	4674	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4074	4101	4674	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4176	4190	5216	java/lang/Exception
    //   4194	4202	5216	java/lang/Exception
    //   4205	4284	5216	java/lang/Exception
    //   4284	4334	5216	java/lang/Exception
    //   4334	4384	5216	java/lang/Exception
    //   4384	4475	5216	java/lang/Exception
    //   4717	4725	5216	java/lang/Exception
    //   4734	4752	5255	java/lang/Exception
    //   4754	4825	5255	java/lang/Exception
    //   5064	5082	5317	java/lang/Exception
    //   5130	5160	5604	finally
    //   5572	5592	5604	finally
    //   5592	5599	5604	finally
    //   5166	5174	5642	finally
    //   5176	5183	5642	finally
    //   5200	5207	5642	finally
    //   5327	5344	5642	finally
    //   5346	5355	5642	finally
    //   5357	5366	5642	finally
    //   5368	5380	5642	finally
    //   5382	5391	5642	finally
    //   5393	5402	5642	finally
    //   5404	5413	5642	finally
    //   5415	5423	5642	finally
    //   5425	5434	5642	finally
    //   5436	5447	5642	finally
    //   5449	5455	5642	finally
    //   5457	5462	5642	finally
    //   4119	4147	5646	java/lang/Exception
    //   147	154	5650	java/lang/Exception
    //   157	178	5650	java/lang/Exception
    //   187	204	5650	java/lang/Exception
    //   1092	1098	5650	java/lang/Exception
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool1 = bool4;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool1 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool3 = true;
          }
          bool2 = bool3;
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            bool1 = bool3;
            QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool2 = bool3;
          }
        }
        if (!bool2) {
          break label254;
        }
        bool1 = bool2;
        paramToServiceMsg = ((UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray())).msg_verify_video_info.get();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          bool2 = bool1;
          bool1 = bool2;
          paramToServiceMsg = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.update_auth_video", 2, paramFromServiceMsg.toString());
            bool1 = bool2;
            paramToServiceMsg = localObject;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      bool1 = bool2;
    }
    for (;;)
    {
      a(47, bool1, paramToServiceMsg);
      return;
      label254:
      bool1 = false;
      paramToServiceMsg = localObject;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleDeleteNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool4;
      }
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        bool1 = bool5;
        bool2 = bool4;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
        bool3 = bool1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          bool3 = bool1;
        }
      }
      bool1 = bool3;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    a(49, bool1, null);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool2 = bool4;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool2 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool1 = true;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool3 = bool1;
          }
        }
        bool1 = bool3;
        if (bool3) {}
        bool1 = bool3;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        try
        {
          NearbyCardManager.a(this.b);
          bool1 = bool3;
          a(46, bool1, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          break label194;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool3 = bool2;
      }
      label194:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
        bool1 = bool3;
        continue;
        bool1 = false;
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    a(48, bool1, localToServiceMsg);
  }
  
  /* Error */
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 4
    //   12: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 1947
    //   21: iconst_2
    //   22: new 49	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 1949
    //   32: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 99	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 99	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 57	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 644	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 645	[B
    //   92: checkcast 645	[B
    //   95: invokevirtual 646	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 57	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 647	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 228	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 647	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 1947
    //   139: iconst_2
    //   140: new 49	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1951
    //   150: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 647	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 1898	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 1899	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 61	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 73	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 1900	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 1898	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 79	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 1932	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 1935	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 1938	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 1941	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 1944	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 49	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 1953
    //   283: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 150	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 153 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 208 2 0
    //   319: checkcast 1906	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 1955
    //   328: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 1958	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 1960
    //   345: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 1963	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1965
    //   362: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 1968	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 1970
    //   379: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 1972
    //   396: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 1974
    //   408: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 1976
    //   420: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 1978
    //   432: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 1947
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 33	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 9
    //   470: istore 6
    //   472: aload 10
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 6
    //   479: istore 7
    //   481: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 1947
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 1908	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 6
    //   502: istore 7
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 10
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 6
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	NearbyCardHandler
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   10	378	4	i	int
    //   123	3	5	j	int
    //   1	534	6	bool1	boolean
    //   59	444	7	bool2	boolean
    //   4	68	8	bool3	boolean
    //   7	462	9	bool4	boolean
    //   49	460	10	localHeadInfo	UpdatePhotoList.HeadInfo
    //   52	17	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp))) {
      paramToServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
    }
    for (boolean bool = true;; bool = false)
    {
      a(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    paramFromServiceMsg = new Bundle();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramFromServiceMsg.putString("targetUin", Long.toString(l1));
    paramFromServiceMsg.putString("selfUin", Long.toString(l2));
    paramFromServiceMsg.putInt("favoriteSource", i);
    paramFromServiceMsg.putInt("iCount", j);
    paramFromServiceMsg.putInt("from", k);
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)localObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramObject.put("param_FailCode", "0");
      }
      for (;;)
      {
        StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = this.b.getEntityManagerFactory().createEntityManager();
          paramObject = (NearbyPeopleCard)paramToServiceMsg.a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            paramObject.likeCount += j;
            paramObject.bVoted = 1;
            paramObject.bAvailVoteCnt = ((short)(paramObject.bAvailVoteCnt - j));
            if (paramObject.bAvailVoteCnt < 0) {
              paramObject.bAvailVoteCnt = 0;
            }
            paramToServiceMsg.a(paramObject);
          }
          VoteUtil.a(this.b, l1, j);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1 + "," + j);
        }
        a(32, bool1, paramFromServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        paramObject.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (localObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label536:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (localObject == null) {
        break label612;
      }
    }
    label612:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramObject.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label536;
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyCardHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      if (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() != 4) {
        break;
      }
      a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  protected Class a()
  {
    return NearbyCardObserver.class;
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new Oidb_0x686.ReqBody();
    Object localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(i);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.c());
    localObject1 = a("OidbSvc.0x686");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "reqCharmEvent() uin=" + ((ToServiceMsg)localObject1).getUin() + ", type=" + paramInt + ", seqNum=" + i);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    NearbyCmdHelper.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, uin=" + paramLong1 + ", tinyId=" + paramLong2 + ", from=" + paramInt);
    }
    Object localObject2 = ((TicketManager)this.b.getManager(2)).getSkey(this.b.getCurrentAccountUin());
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, skey==null, return");
      }
      return;
    }
    Object localObject1 = new oidb_0x8e7.ReqBody();
    ((oidb_0x8e7.ReqBody)localObject1).bool_stock.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_is_first.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_warn.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_update_url.set(true);
    if (paramLong1 > 0L) {
      ((oidb_0x8e7.ReqBody)localObject1).uint64_uin.set(paramLong1);
    }
    for (;;)
    {
      oidb_0x8e7.LoginSig localLoginSig = new oidb_0x8e7.LoginSig();
      localLoginSig.uint32_type.set(1);
      localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      localObject2 = new oidb_0x8e7.ExtParam();
      ((oidb_0x8e7.ExtParam)localObject2).uint32_client.set(1);
      ((oidb_0x8e7.ExtParam)localObject2).uint32_portal.set(paramInt);
      ((oidb_0x8e7.ExtParam)localObject2).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.c().getBytes()));
      ((oidb_0x8e7.ExtParam)localObject2).msg_login_sig.set(localLoginSig);
      ((oidb_0x8e7.ReqBody)localObject1).msg_ext_parm.set((MessageMicro)localObject2);
      localObject1 = a("OidbSvc.0x8e7_1", 2279, 1, ((oidb_0x8e7.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("uin", paramLong1 + "");
      ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
      b((ToServiceMsg)localObject1);
      return;
      if (paramLong2 > 0L) {
        ((oidb_0x8e7.ReqBody)localObject1).uint64_tinyid.set(paramLong2);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2 + ",voteNum|" + paramInt2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    a(localToServiceMsg);
  }
  
  public void a(Bundle paramBundle, ArrayList paramArrayList, InterestTag[] paramArrayOfInterestTag, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "editProfileCard");
    }
    cmd0x9c9.ReqBody localReqBody = new cmd0x9c9.ReqBody();
    Object localObject2;
    Object localObject1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject2 = new UpdatePhotoList.ReqBody();
      Iterator localIterator = paramArrayList.iterator();
      for (paramBoolean3 = false; localIterator.hasNext(); paramBoolean3 = true)
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        if (localPicInfo.jdField_a_of_type_Int < 0) {
          break label2378;
        }
        localObject1 = new UpdatePhotoList.RichHead();
        ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(localPicInfo.f)) {
          ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.f);
        }
        if (localObject1 == null) {
          break label2375;
        }
        ((UpdatePhotoList.ReqBody)localObject2).rpt_msg_rich_headids.add((MessageMicro)localObject1);
      }
      label154:
      if (paramBoolean3)
      {
        localObject1 = LbsUtils.a(getClass().getSimpleName());
        if (localObject1 != null) {
          ((UpdatePhotoList.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
        }
        localReqBody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject2).toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "editProfileCard, photoList = " + paramArrayList + ", isHasNearbyAvatar = " + paramBoolean3);
      }
    }
    for (;;)
    {
      int j;
      int i;
      if ((paramArrayOfInterestTag != null) && (paramArrayOfInterestTag.length > 0))
      {
        localObject1 = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
        j = paramArrayOfInterestTag.length;
        i = 0;
        if (i < j)
        {
          localObject2 = paramArrayOfInterestTag[i];
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add(((InterestTag)localObject2).a());
          }
        }
        localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
        if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          i = 0;
          while (i < paramArrayOfInterestTag.length)
          {
            ((StringBuilder)localObject2).append(paramArrayOfInterestTag[i].toString()).append(",");
            i += 1;
          }
          QLog.d("Q.nearby_people_card.", 2, "editProfileCard, tags = " + ((StringBuilder)localObject2).toString());
        }
      }
      for (paramArrayOfInterestTag = (InterestTag[])localObject1;; paramArrayOfInterestTag = null)
      {
        i = 0;
        j = 0;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("nick"))
          {
            i = 1;
            localObject1 = paramBundle.getString("nick");
            localReqBody.str_nick.set((String)localObject1);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_nick|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("sex"))
          {
            j += 1;
            k = paramBundle.getByte("sex") + 1;
            localReqBody.uint32_gender.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gender|" + k);
                i = j;
              }
            }
          }
          int k = i;
          if (paramBundle.containsKey("college"))
          {
            i += 1;
            localObject1 = paramBundle.getString("college");
            localReqBody.str_college.set((String)localObject1);
            k = i;
            if (NearbyCardConstants.a)
            {
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_college|" + (String)localObject1);
                k = i;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_constellation"))
          {
            i = k + 1;
            k = paramBundle.getInt("key_constellation");
            localReqBody.uint32_constellation.set(k);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_constellation|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("birthday"))
          {
            j += 1;
            k = paramBundle.getInt("birthday");
            localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(PkgTools.a(k)));
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "bytes_birthday|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("hometown"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("hometown");
            j = 0;
            while (j < 3)
            {
              PkgTools.a((byte[])localObject2, j * 4, PkgTools.a(ConditionSearchManager.a(localObject1[j])), 4);
              j += 1;
            }
            localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
            j = ConditionSearchManager.a(localObject1[3]);
            localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(PkgTools.a(j)));
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              j = 0;
              while (j < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[j]).append(", ");
                j += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_city_id|" + ((StringBuilder)localObject2).toString());
            }
            j = i + 2;
          }
          k = j;
          if (paramBundle.containsKey("location"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("location");
            i = 0;
            while (i < 3)
            {
              PkgTools.a((byte[])localObject2, i * 4, PkgTools.a(ConditionSearchManager.a(localObject1[i])), 4);
              i += 1;
            }
            localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
            i = ConditionSearchManager.a(localObject1[3]);
            localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(PkgTools.a(i)));
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[i]).append(", ");
                i += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_location|" + ((StringBuilder)localObject2).toString());
            }
            k = j + 2;
          }
          i = k;
          if (paramBundle.containsKey("age"))
          {
            j = k + 1;
            i = paramBundle.getInt("age");
            localReqBody.uint32_age.set(i);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "set birthday|age = " + paramBundle.getInt("age"));
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("company"))
          {
            i += 1;
            localObject1 = paramBundle.getString("company");
            localReqBody.str_company.set((String)localObject1);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_company|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_new_nickname"))
          {
            j += 1;
            localObject1 = paramBundle.getString("key_new_nickname");
            localReqBody.str_stranger_nick.set((String)localObject1);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_stranger_nick|" + (String)localObject1);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_xuan_yan"))
          {
            localObject1 = paramBundle.getByteArray("key_xuan_yan");
            if (localObject1 != null) {
              localReqBody.bytes_stranger_declare.set(ByteStringMicro.copyFrom((byte[])localObject1));
            }
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder().append("str_stranger_declare|");
              if (localObject1 != null) {
                break label2351;
              }
              localObject1 = "null";
              QLog.d("Q.nearby_people_card.", 2, localObject1);
            }
            j = i + 1;
          }
          i = j;
          if (paramBundle.containsKey("key_marital_status"))
          {
            j += 1;
            k = paramBundle.getByte("key_marital_status");
            localReqBody.uint32_love_status.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_love_status|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("profession"))
          {
            int m = paramBundle.getInt("profession");
            k = i;
            if (NearbyProfileUtil.a(m))
            {
              k = i + 1;
              localReqBody.uint32_profession.set(m);
            }
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_profession|" + m);
                j = k;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_qzone_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_qzone_switch");
            localReqBody.uint32_qzone_visible.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_qzone_visible|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_hobby_switch"))
          {
            i += 1;
            k = paramBundle.getShort("key_hobby_switch");
            localReqBody.uint32_interest_visible.set(k);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_interest_visible|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_flower_visible_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_flower_visible_switch");
            localReqBody.uint32_gift_visible.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gift_visible|" + k);
                i = j;
              }
            }
          }
        }
        localReqBody.uint32_stranger_profile_flag.set(1);
        if (paramBoolean3) {
          localReqBody.uint32_face_flag.set(1);
        }
        localReqBody.uint32_guide_flag.set(0);
        if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
          QLog.d("Q.nearby_people_card.", 2, "fieldCount|" + (i + 1));
        }
        localObject1 = a("OidbSvc.0x9c9_0", 2505, 0, localReqBody.toByteArray());
        if (paramBundle != null) {
          ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
        }
        if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
          ((ToServiceMsg)localObject1).extraData.putParcelable("avatar_picinfo", (Parcelable)paramArrayList.get(0));
        }
        paramArrayList = ((ToServiceMsg)localObject1).extraData;
        if (paramArrayOfInterestTag == null) {}
        for (paramBundle = null;; paramBundle = paramArrayOfInterestTag.toByteArray())
        {
          paramArrayList.putByteArray("9c7_body", paramBundle);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_lost_god_flag", paramBoolean1);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_head_changed", paramBoolean2);
          ((ToServiceMsg)localObject1).extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
          b((ToServiceMsg)localObject1);
          return;
          label2351:
          localObject1 = Integer.valueOf(localObject1.length);
          break;
        }
      }
      label2375:
      break label154;
      label2378:
      localObject1 = null;
      break;
      paramBoolean3 = false;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (a(paramFromServiceMsg.getServiceCmd()));
      String str = paramFromServiceMsg.getServiceCmd();
      if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c8_0".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c5_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c9_0".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c7_0".equals(str))
      {
        NearbyCmdHelper.c(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x682".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e7_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e6_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb5b".equals(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getRandomUserInfo| uin = " + paramString);
    }
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody1 = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody1.rpt_uint64_uins.set(localArrayList);
    localReqBody1.uint32_req_nick.set(1);
    localReqBody1.uint32_req_stranger_nick.set(1);
    localReqBody1.uint32_req_gender.set(1);
    localReqBody1.uint32_req_god_flag.set(1);
    localReqBody1.uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
    paramString = a("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(10, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyCardHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l = Long.parseLong(paramString);
          if (l != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.b.getManager(51);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = a("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            b((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyCardHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new cmd0x9c8.ReqBody();
    ((cmd0x9c8.ReqBody)localObject).str_keyword.set(paramString);
    ((cmd0x9c8.ReqBody)localObject).uint32_tag_type.set(paramInt1);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_start.set(paramInt2);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_count.set(paramInt3);
    ((cmd0x9c8.ReqBody)localObject).uint32_match_op.set(paramInt4);
    ((cmd0x9c8.ReqBody)localObject).uint32_personal_info_flag.set(paramInt5);
    localObject = a("OidbSvc.0x9c8_0", 2504, 0, ((cmd0x9c8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_word", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("tag_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("person_flag", paramInt5);
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.updateNearbyPeopleAuthVideo(), videoId = " + paramString + ",photoId =" + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    if (paramBoolean)
    {
      localOIDBSSOPkg.uint32_service_type.set(6);
      localOIDBSSOPkg.uint32_result.set(0);
      UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
      UpdatePhotoList.RichHead localRichHead = new UpdatePhotoList.RichHead();
      localRichHead.uint32_headid.set(paramInt);
      localRichHead.str_video_id.set(paramString);
      localReqBody.msg_verify_video_info.set(localRichHead);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (paramString = a("OidbSvc.0x5ea_6");; paramString = a("OidbSvc.0x5ea_7"))
    {
      paramString.setTimeout(30000L);
      paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
      b(paramString);
      return;
      localOIDBSSOPkg.uint32_service_type.set(7);
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean1).append(",uLikeSource = ").append(paramLong6);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt1);
      paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      paramString1.extraData.putByte("isFriend", paramByte);
      paramString1.extraData.putLong("troopCode", paramLong2);
      paramString1.extraData.putLong("troopUin", paramLong3);
      paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
      paramString1.extraData.putString("strSearchName", paramString3);
      paramString1.extraData.putLong("lGetControl", paramLong4);
      paramString1.extraData.putInt("bReqCommLabel", 1);
      paramString1.extraData.putInt("EAddFriendSource", paramInt2);
      paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      paramString1.extraData.putLong("tinyId", paramLong5);
      paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean1);
      paramString1.extraData.putBoolean("partlyRefresh", paramBoolean2);
      paramString1.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
      paramString1.extraData.putLong("likeSource", paramLong6);
      a(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSummayCard", paramString1);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = a("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    b(paramArrayList);
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    int j = 0;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("nearbyPeopleLikeNew, reqList.size=");
      if (paramArrayList == null)
      {
        i = 0;
        QLog.d("NearbyLikeLimitManager", 2, i + ", from=" + paramInt);
      }
    }
    else
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList is empty, return");
      }
    }
    label92:
    Object localObject2;
    label142:
    do
    {
      do
      {
        return;
        i = paramArrayList.size();
        break;
        localObject2 = ((TicketManager)this.b.getManager(2)).getSkey(this.b.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label142;
        }
      } while (!QLog.isColorLevel());
      QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, skey is empty, return");
      return;
      localObject1 = new oidb_0x8e6.ReqBody();
      ((oidb_0x8e6.ReqBody)localObject1).uint32_portal.set(paramInt);
      ((oidb_0x8e6.ReqBody)localObject1).uint32_client.set(1);
      ((oidb_0x8e6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.c().getBytes()));
      Object localObject3 = new oidb_0x8e6.LoginSig();
      ((oidb_0x8e6.LoginSig)localObject3).uint32_type.set(1);
      ((oidb_0x8e6.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      ((oidb_0x8e6.ReqBody)localObject1).msg_login_sig.set((MessageMicro)localObject3);
      localObject3 = new ArrayList();
      int k = paramArrayList.size();
      localObject2 = new StringBuilder();
      i = j;
      while (i < k)
      {
        NearbyLikeLimitManager.LikeItem localLikeItem = (NearbyLikeLimitManager.LikeItem)paramArrayList.get(i);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(localLikeItem).append(" | ");
        }
        oidb_0x8e6.VoteInfo localVoteInfo = new oidb_0x8e6.VoteInfo();
        localVoteInfo.uint64_uin.set(localLikeItem.jdField_a_of_type_Long);
        localVoteInfo.uint32_free_vote_count.set(localLikeItem.jdField_a_of_type_Int);
        localVoteInfo.uint32_pay_vote_count.set(localLikeItem.jdField_b_of_type_Int);
        localVoteInfo.uint32_source.set(localLikeItem.d);
        ((ArrayList)localObject3).add(localVoteInfo);
        i += 1;
      }
      ((oidb_0x8e6.ReqBody)localObject1).rpt_vote_info.set((List)localObject3);
      paramArrayList = a("OidbSvc.0x8e6_1", 2278, 1, ((oidb_0x8e6.ReqBody)localObject1).toByteArray());
      paramArrayList.extraData.putInt("from", paramInt);
      b(paramArrayList);
    } while (!QLog.isColorLevel());
    QLog.d("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList=[" + ((StringBuilder)localObject2).toString() + "]");
  }
  
  public void a(List paramList, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    cmd0xb5b.ReqBody localReqBody = new cmd0xb5b.ReqBody();
    PBUInt32Field localPBUInt32Field = localReqBody.is_review;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      b(a("OidbSvc.0xb5b", 2907, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c8_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c5_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c9_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x682");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x686");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
      this.jdField_a_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_6");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_7");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8e6_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8e7_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xb5b");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby.now", 2, "handleNotifyFaceChange req == null || res == null");
      }
      return;
    }
    paramToServiceMsg = new cmd0xb5b.RspBody();
    a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.i("Q.nearby.now", 1, "handleNotifyFaceChange code:" + paramToServiceMsg.result.get() + "   " + paramToServiceMsg.err_msg.get());
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo");
    }
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    oidb_0x5eb.RspBody localRspBody;
    String str;
    int k;
    int m;
    if (a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      localRspBody = new oidb_0x5eb.RspBody();
      paramObject = null;
      str = "";
      k = -1;
      m = 0;
      if (paramToServiceMsg.bytes_rspbody_5eb.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_rspbody_5eb.get().toByteArray();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramToServiceMsg);
      int j = m;
      int i = k;
      paramFromServiceMsg = str;
      paramToServiceMsg = paramObject;
      if (localRspBody.rpt_msg_uin_data.has())
      {
        j = m;
        i = k;
        paramFromServiceMsg = str;
        paramToServiceMsg = paramObject;
        if (localRspBody.rpt_msg_uin_data.size() > 0)
        {
          paramObject = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0);
          paramToServiceMsg = Long.valueOf(paramObject.uint64_uin.get());
          paramFromServiceMsg = paramObject.bytes_stranger_nick.get().toStringUtf8();
          i = paramObject.uint32_gender.get();
          j = paramObject.uint32_age.get();
        }
      }
      a(13, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      if (QLog.isDevelopLevel()) {
        QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo---->uin =" + paramToServiceMsg + "nickName = " + paramFromServiceMsg + " gender = " + i + "age =" + j);
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramToServiceMsg);
        }
      }
    }
    a(13, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(-1), Integer.valueOf(-1) });
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x8e7.RspBody localRspBody = new oidb_0x8e7.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin", "");
    int j = paramToServiceMsg.extraData.getInt("from", 509);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, uin=" + paramFromServiceMsg + ", ret=" + i);
    }
    if (i == 0)
    {
      for (;;)
      {
        oidb_0x8e7.UserZanInfo localUserZanInfo;
        long l;
        try
        {
          paramToServiceMsg = new NearbyLikeLimitManager.LimitInfo();
          paramToServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.bytes_recharge_url.get().toStringUtf8();
          paramToServiceMsg.jdField_b_of_type_JavaLangString = localRspBody.bytes_update_url.get().toStringUtf8();
          if (localRspBody.msg_zan_limit.has())
          {
            Object localObject = (oidb_0x8e7.ZanLimitInfo)localRspBody.msg_zan_limit.get();
            paramToServiceMsg.jdField_a_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_level.get());
            paramToServiceMsg.c = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_can_free_zan_user_limit.get());
            paramToServiceMsg.d = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_total_limit.get());
            paramToServiceMsg.jdField_b_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_price.get());
            paramToServiceMsg.f = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_user.get());
            paramObject = new ArrayList();
            if (!((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.has()) {
              break;
            }
            localObject = ((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.get().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localUserZanInfo = (oidb_0x8e7.UserZanInfo)((Iterator)localObject).next();
            NearbyLikeLimitManager.LikeItem localLikeItem = new NearbyLikeLimitManager.LikeItem();
            l = 0L;
            if (localUserZanInfo.uint64_uin.has())
            {
              l = localUserZanInfo.uint64_uin.get();
              localLikeItem.jdField_a_of_type_Long = l;
              localLikeItem.jdField_a_of_type_Int = ((int)localUserZanInfo.uint64_free_zan.get());
              localLikeItem.jdField_b_of_type_Int = ((int)localUserZanInfo.uint64_pay_zan.get());
              localLikeItem.c = ((int)localUserZanInfo.uint64_pay_stock.get());
              if (l <= 0L) {
                continue;
              }
              paramObject.add(localLikeItem);
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          a(16, false, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, " + paramToServiceMsg.toString());
          }
        }
        if (localUserZanInfo.uint64_tinyid.has()) {
          l = localUserZanInfo.uint64_tinyid.get();
        }
      }
      if (localRspBody.msg_warn.has()) {
        paramToServiceMsg.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg = ((oidb_0x8e7.WarnMsg)localRspBody.msg_warn.get());
      }
      if (localRspBody.msg_stock_rsp.has()) {
        paramToServiceMsg.e = ((oidb_0x8e7.StockRsp)localRspBody.msg_stock_rsp.get()).int32_total.get();
      }
      ((NearbyLikeLimitManager)this.b.getManager(206)).a(paramToServiceMsg, paramObject, j);
      a(16, true, paramFromServiceMsg);
      return;
    }
    a(16, false, paramFromServiceMsg);
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("from", 0);
    Object localObject1 = new oidb_0x8e6.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew, ret=" + i + ", from=" + j);
    }
    paramToServiceMsg = new ArrayList();
    if (i == 0)
    {
      int k = ((oidb_0x8e6.RspBody)localObject1).uint32_level.get();
      int m = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_user_count.get();
      int n = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_count.get();
      ((oidb_0x8e6.RspBody)localObject1).uint32_remain_total.get();
      paramFromServiceMsg = (NearbyLikeLimitManager)this.b.getManager(206);
      paramObject = ((oidb_0x8e6.RspBody)localObject1).rpt_vote_result.get();
      int i1 = paramObject.size();
      i = 0;
      while (i < i1)
      {
        Object localObject2 = (oidb_0x8e6.VoteResult)paramObject.get(i);
        localObject1 = new NearbyLikeLimitManager.LikeResultItem();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_ret.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_JavaLangString = ((oidb_0x8e6.VoteResult)localObject2).bytes_err_msg.get().toStringUtf8();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long = ((oidb_0x8e6.VoteResult)localObject2).uint64_uin.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_b_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_free_vote_count.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).c = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_pay_vote_count.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).d = ((oidb_0x8e6.VoteResult)localObject2).uint32_vote_count.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).e = ((int)((oidb_0x8e6.VoteResult)localObject2).uint64_pay_stock.get());
        paramToServiceMsg.add(localObject1);
        int i2 = ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_b_of_type_Int;
        i2 = ((NearbyLikeLimitManager.LikeResultItem)localObject1).c + i2;
        if ((((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Int == 0) && (((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long > 0L) && (i2 > 0))
        {
          VoteUtil.a(this.b, ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long, i2);
          localObject2 = this.b.getEntityManagerFactory().createEntityManager();
          NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).a(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long) });
          if (localNearbyPeopleCard != null)
          {
            localNearbyPeopleCard.likeCount += i2;
            localNearbyPeopleCard.bVoted = 1;
            localNearbyPeopleCard.bAvailVoteCnt = ((short)(localNearbyPeopleCard.bAvailVoteCnt - i2));
            if (localNearbyPeopleCard.bAvailVoteCnt < 0) {
              localNearbyPeopleCard.bAvailVoteCnt = 0;
            }
            ((EntityManager)localObject2).a(localNearbyPeopleCard);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew: " + localObject1);
        }
        paramFromServiceMsg.a(((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long + "", true);
        i += 1;
      }
      paramFromServiceMsg.a(k, m, n);
      a(17, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
    }
    a(17, false, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler
 * JD-Core Version:    0.7.0.1
 */