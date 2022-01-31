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
    //   53: ifeq +5821 -> 5874
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
    //   118: ifeq +5751 -> 5869
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
    //   218: ifeq +5617 -> 5835
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
    //   301: ifnonnull +5565 -> 5866
    //   304: aload 25
    //   306: getfield 847	SummaryCard/RespSummaryCard:lUIN	J
    //   309: lconst_0
    //   310: lcmp
    //   311: ifle +5555 -> 5866
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
    //   378: ifle +934 -> 1312
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
    //   406: ifeq +917 -> 1323
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
    //   730: ifnull +614 -> 1344
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
    //   906: ifnull +479 -> 1385
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
    //   942: ifnull +488 -> 1430
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
    //   1016: if_icmpne +405 -> 1421
    //   1019: iconst_0
    //   1020: istore 4
    //   1022: iload 4
    //   1024: aload 26
    //   1026: invokeinterface 153 1 0
    //   1031: if_icmpge +390 -> 1421
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
    //   1187: getfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   1190: putfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   1193: aload_3
    //   1194: aload_1
    //   1195: getfield 1118	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1198: putfield 1118	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1201: aload_3
    //   1202: aload_1
    //   1203: getfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1206: putfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1209: aload_3
    //   1210: aload_1
    //   1211: getfield 1124	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1214: putfield 1124	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1217: aload_3
    //   1218: aload_1
    //   1219: getfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1222: putfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1225: aload_3
    //   1226: aload_1
    //   1227: getfield 1130	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1230: putfield 1130	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1233: aload_3
    //   1234: aload_1
    //   1235: getfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1238: putfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1241: aload_3
    //   1242: aload_1
    //   1243: getfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1246: putfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1249: aload_3
    //   1250: aload_1
    //   1251: getfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1254: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1257: aload_3
    //   1258: aload_1
    //   1259: getfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1262: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1265: aload_3
    //   1266: aload_1
    //   1267: getfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1270: putfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1273: aload_3
    //   1274: aload_1
    //   1275: getfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1278: putfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1281: aload_3
    //   1282: aload_1
    //   1283: getfield 1151	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1286: putfield 1151	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1289: aload_3
    //   1290: aload_1
    //   1291: getfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1294: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1297: aload_3
    //   1298: iload 4
    //   1300: invokevirtual 1154	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1303: aload_3
    //   1304: lload 18
    //   1306: invokevirtual 1157	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1309: goto -953 -> 356
    //   1312: aload_3
    //   1313: aload_1
    //   1314: getfield 1160	SummaryCard/DateCard:lTinyId	J
    //   1317: putfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1320: goto -933 -> 387
    //   1323: aload_3
    //   1324: aload 25
    //   1326: getfield 861	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1329: putfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1332: aload_3
    //   1333: aload 25
    //   1335: getfield 866	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1338: putfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1341: goto -854 -> 487
    //   1344: aload_0
    //   1345: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1348: ldc_w 1002
    //   1351: ldc_w 1004
    //   1354: ldc 216
    //   1356: ldc_w 1006
    //   1359: ldc_w 1162
    //   1362: iconst_0
    //   1363: iconst_0
    //   1364: aload_0
    //   1365: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1368: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1371: aload_3
    //   1372: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1375: ldc 216
    //   1377: ldc 216
    //   1379: invokestatic 1013	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1382: goto -551 -> 831
    //   1385: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1388: ifeq -455 -> 933
    //   1391: ldc_w 786
    //   1394: iconst_2
    //   1395: new 49	java/lang/StringBuilder
    //   1398: dup
    //   1399: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1402: ldc_w 1164
    //   1405: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: aconst_null
    //   1409: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 1167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1418: goto -485 -> 933
    //   1421: aload_3
    //   1422: aload 27
    //   1424: invokevirtual 1168	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1427: putfield 1171	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1430: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1433: ifeq +33 -> 1466
    //   1436: ldc_w 786
    //   1439: iconst_4
    //   1440: new 49	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1447: ldc_w 1173
    //   1450: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: aload_1
    //   1454: getfield 1027	SummaryCard/DateCard:uSchoolId	J
    //   1457: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1460: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1463: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1466: aload_3
    //   1467: aload 25
    //   1469: getfield 1176	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1472: putfield 1177	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1475: aload_3
    //   1476: aload 25
    //   1478: getfield 1181	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1481: putfield 1182	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1484: aload_3
    //   1485: aload 25
    //   1487: getfield 1185	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1490: putfield 1186	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1493: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1496: ifeq +61 -> 1557
    //   1499: ldc 24
    //   1501: iconst_2
    //   1502: new 49	java/lang/StringBuilder
    //   1505: dup
    //   1506: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1509: ldc_w 1188
    //   1512: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: aload 25
    //   1517: getfield 1176	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1520: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: ldc_w 1190
    //   1526: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: aload 25
    //   1531: getfield 1181	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1534: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1537: ldc_w 1192
    //   1540: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload 25
    //   1545: getfield 1185	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1548: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1557: aload 25
    //   1559: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1562: ifnull +54 -> 1616
    //   1565: aload_3
    //   1566: aload 25
    //   1568: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1571: getfield 1201	SummaryCard/PanSocialInfo:uCharm	J
    //   1574: putfield 1204	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1577: aload_3
    //   1578: aload 25
    //   1580: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1583: getfield 1207	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1586: l2i
    //   1587: putfield 1210	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1590: aload_3
    //   1591: aload 25
    //   1593: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1596: getfield 1213	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1599: l2i
    //   1600: putfield 1216	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1603: aload_3
    //   1604: aload 25
    //   1606: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1609: getfield 1219	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1612: l2i
    //   1613: putfield 1222	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1616: iload 8
    //   1618: ifeq +20 -> 1638
    //   1621: aload_3
    //   1622: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1625: aload_0
    //   1626: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1629: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1632: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1635: ifeq +236 -> 1871
    //   1638: iconst_1
    //   1639: istore 21
    //   1641: aload_3
    //   1642: aload_1
    //   1643: getfield 1225	SummaryCard/DateCard:vFaces	[B
    //   1646: aload 25
    //   1648: getfield 1229	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1651: iload 21
    //   1653: invokevirtual 1233	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1656: pop
    //   1657: aload_3
    //   1658: aload 25
    //   1660: getfield 1237	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1663: getfield 1242	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1666: putfield 1243	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1669: aload 25
    //   1671: getfield 1246	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1674: ifne +203 -> 1877
    //   1677: aload_3
    //   1678: iconst_1
    //   1679: putfield 1249	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1682: aload_2
    //   1683: ifnull +11 -> 1694
    //   1686: aload_3
    //   1687: aload_2
    //   1688: getfield 1252	SummaryCard/RespHead:vCookies	[B
    //   1691: putfield 1253	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1694: aload_3
    //   1695: getfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1698: ldc2_w 1254
    //   1701: land
    //   1702: lconst_0
    //   1703: lcmp
    //   1704: ifeq +181 -> 1885
    //   1707: aload_3
    //   1708: iconst_1
    //   1709: putfield 571	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1712: aload_3
    //   1713: getfield 976	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1716: ldc2_w 1256
    //   1719: land
    //   1720: lconst_0
    //   1721: lcmp
    //   1722: ifeq +171 -> 1893
    //   1725: aload_3
    //   1726: iconst_1
    //   1727: putfield 576	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1730: aload_3
    //   1731: invokevirtual 1260	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1734: ifne +223 -> 1957
    //   1737: aload_3
    //   1738: ldc 216
    //   1740: putfield 1263	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1743: aload_3
    //   1744: ldc 216
    //   1746: putfield 1266	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1749: aload_3
    //   1750: ldc 216
    //   1752: putfield 1269	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1755: aload 25
    //   1757: getfield 1273	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1760: astore_1
    //   1761: aload_1
    //   1762: ifnull +195 -> 1957
    //   1765: aload_1
    //   1766: getfield 1278	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1769: ifnull +188 -> 1957
    //   1772: aload_1
    //   1773: getfield 1278	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1776: invokevirtual 1279	java/util/ArrayList:size	()I
    //   1779: ifle +178 -> 1957
    //   1782: iconst_0
    //   1783: istore 4
    //   1785: iload 4
    //   1787: aload_1
    //   1788: getfield 1278	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1791: invokevirtual 1279	java/util/ArrayList:size	()I
    //   1794: if_icmpge +163 -> 1957
    //   1797: iload 4
    //   1799: ifne +102 -> 1901
    //   1802: aload_3
    //   1803: aload_1
    //   1804: getfield 1278	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1807: iload 4
    //   1809: invokevirtual 1280	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1812: checkcast 1282	SummaryCard/PhotoInfo
    //   1815: getfield 1285	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1818: putfield 1263	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1821: iload 4
    //   1823: iconst_1
    //   1824: iadd
    //   1825: istore 4
    //   1827: goto -42 -> 1785
    //   1830: astore 26
    //   1832: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1835: ifeq -405 -> 1430
    //   1838: ldc 24
    //   1840: iconst_2
    //   1841: new 49	java/lang/StringBuilder
    //   1844: dup
    //   1845: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1848: ldc_w 1287
    //   1851: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1854: aload 26
    //   1856: invokevirtual 627	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1859: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokestatic 1289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1868: goto -438 -> 1430
    //   1871: iconst_0
    //   1872: istore 21
    //   1874: goto -233 -> 1641
    //   1877: aload_3
    //   1878: iconst_0
    //   1879: putfield 1249	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1882: goto -200 -> 1682
    //   1885: aload_3
    //   1886: iconst_0
    //   1887: putfield 571	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1890: goto -178 -> 1712
    //   1893: aload_3
    //   1894: iconst_0
    //   1895: putfield 576	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1898: goto -168 -> 1730
    //   1901: iload 4
    //   1903: iconst_1
    //   1904: if_icmpne +25 -> 1929
    //   1907: aload_3
    //   1908: aload_1
    //   1909: getfield 1278	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1912: iload 4
    //   1914: invokevirtual 1280	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1917: checkcast 1282	SummaryCard/PhotoInfo
    //   1920: getfield 1285	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1923: putfield 1266	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1926: goto -105 -> 1821
    //   1929: iload 4
    //   1931: iconst_2
    //   1932: if_icmpne -111 -> 1821
    //   1935: aload_3
    //   1936: aload_1
    //   1937: getfield 1278	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1940: iload 4
    //   1942: invokevirtual 1280	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1945: checkcast 1282	SummaryCard/PhotoInfo
    //   1948: getfield 1285	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1951: putfield 1269	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1954: goto -133 -> 1821
    //   1957: aload 25
    //   1959: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1962: astore_1
    //   1963: aload_1
    //   1964: ifnull +25 -> 1989
    //   1967: aload_1
    //   1968: getfield 1292	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1971: lconst_1
    //   1972: lcmp
    //   1973: ifne +149 -> 2122
    //   1976: aload_3
    //   1977: iconst_1
    //   1978: putfield 435	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1981: aload_3
    //   1982: aload_1
    //   1983: getfield 1295	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1986: putfield 1296	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1989: aload 25
    //   1991: getfield 1299	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1994: ifnull +29 -> 2023
    //   1997: aload_3
    //   1998: aload_0
    //   1999: aload 25
    //   2001: getfield 1299	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   2004: ldc_w 1301
    //   2007: new 1303	GameCenter/RespLastGameInfo
    //   2010: dup
    //   2011: invokespecial 1304	GameCenter/RespLastGameInfo:<init>	()V
    //   2014: invokevirtual 813	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2017: checkcast 1303	GameCenter/RespLastGameInfo
    //   2020: invokevirtual 1308	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   2023: aload 25
    //   2025: getfield 1196	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   2028: astore_1
    //   2029: aload_1
    //   2030: ifnull +12 -> 2042
    //   2033: aload_3
    //   2034: aload_1
    //   2035: getfield 1311	SummaryCard/PanSocialInfo:uChatflag	J
    //   2038: l2i
    //   2039: putfield 1314	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   2042: new 142	java/util/ArrayList
    //   2045: dup
    //   2046: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2049: astore_1
    //   2050: aload 25
    //   2052: getfield 1317	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2055: ifnull +746 -> 2801
    //   2058: aload 25
    //   2060: getfield 1317	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2063: invokevirtual 1279	java/util/ArrayList:size	()I
    //   2066: ifle +735 -> 2801
    //   2069: iconst_0
    //   2070: istore 4
    //   2072: iload 4
    //   2074: aload 25
    //   2076: getfield 1317	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2079: invokevirtual 1279	java/util/ArrayList:size	()I
    //   2082: if_icmpge +719 -> 2801
    //   2085: aload 25
    //   2087: getfield 1317	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2090: iload 4
    //   2092: invokevirtual 1280	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2095: checkcast 645	[B
    //   2098: astore_2
    //   2099: aload_2
    //   2100: ifnonnull +30 -> 2130
    //   2103: iconst_0
    //   2104: istore 5
    //   2106: iload 5
    //   2108: bipush 10
    //   2110: if_icmpgt +27 -> 2137
    //   2113: iload 4
    //   2115: iconst_1
    //   2116: iadd
    //   2117: istore 4
    //   2119: goto -47 -> 2072
    //   2122: aload_3
    //   2123: iconst_0
    //   2124: putfield 435	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   2127: goto -146 -> 1981
    //   2130: aload_2
    //   2131: arraylength
    //   2132: istore 5
    //   2134: goto -28 -> 2106
    //   2137: aload_2
    //   2138: iconst_1
    //   2139: invokestatic 1322	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2142: l2i
    //   2143: istore 6
    //   2145: aload_2
    //   2146: iconst_5
    //   2147: invokestatic 1322	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2150: l2i
    //   2151: istore 9
    //   2153: iload 6
    //   2155: ifle -42 -> 2113
    //   2158: iload 6
    //   2160: bipush 9
    //   2162: iadd
    //   2163: iload 5
    //   2165: if_icmpge -52 -> 2113
    //   2168: iload 6
    //   2170: newarray byte
    //   2172: astore 26
    //   2174: aload 26
    //   2176: iconst_0
    //   2177: aload_2
    //   2178: bipush 9
    //   2180: iload 6
    //   2182: invokestatic 1325	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   2185: new 1327	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2188: dup
    //   2189: invokespecial 1328	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2192: astore_2
    //   2193: aload_2
    //   2194: aload 26
    //   2196: invokevirtual 1329	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2199: pop
    //   2200: aload_2
    //   2201: getfield 1333	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2204: invokevirtual 1336	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2207: istore 9
    //   2209: new 1338	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry
    //   2212: dup
    //   2213: invokespecial 1339	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:<init>	()V
    //   2216: astore 26
    //   2218: iload 9
    //   2220: ifne +485 -> 2705
    //   2223: aload 26
    //   2225: aload_2
    //   2226: getfield 1343	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2229: getfield 1348	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2232: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2235: putfield 1350	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2238: aload 26
    //   2240: aload_2
    //   2241: getfield 1343	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2244: getfield 1353	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2247: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2250: putfield 1355	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2253: aload 26
    //   2255: aload_2
    //   2256: getfield 1358	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2259: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2262: putfield 1360	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_Int	I
    //   2265: new 142	java/util/ArrayList
    //   2268: dup
    //   2269: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2272: astore 27
    //   2274: iconst_0
    //   2275: istore 5
    //   2277: iload 5
    //   2279: aload_2
    //   2280: getfield 1343	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2283: getfield 1363	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2286: invokevirtual 1364	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2289: if_icmpge +409 -> 2698
    //   2292: aload_2
    //   2293: getfield 1343	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2296: getfield 1363	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2299: iload 5
    //   2301: invokevirtual 1367	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2304: checkcast 1369	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2307: astore 28
    //   2309: new 1371	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem
    //   2312: dup
    //   2313: invokespecial 1372	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:<init>	()V
    //   2316: astore 29
    //   2318: aload 29
    //   2320: aload 28
    //   2322: getfield 1375	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2325: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2328: putfield 1376	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2331: aload 29
    //   2333: aload 28
    //   2335: getfield 1379	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2338: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2341: putfield 1380	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2344: aload 29
    //   2346: aload 28
    //   2348: getfield 1383	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2351: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2354: putfield 1386	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:c	Ljava/lang/String;
    //   2357: aload 29
    //   2359: aload 28
    //   2361: getfield 1389	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2364: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2367: putfield 1391	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:d	Ljava/lang/String;
    //   2370: aload 29
    //   2372: aload 28
    //   2374: getfield 1394	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2377: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2380: putfield 1396	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:e	Ljava/lang/String;
    //   2383: aload 29
    //   2385: aload 28
    //   2387: getfield 1399	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2390: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2393: putfield 1401	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:f	Ljava/lang/String;
    //   2396: aload 29
    //   2398: aload 28
    //   2400: getfield 1404	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2403: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2406: putfield 1406	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_Long	J
    //   2409: aload 29
    //   2411: aload 26
    //   2413: getfield 1360	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_Int	I
    //   2416: putfield 1407	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_Int	I
    //   2419: aload 28
    //   2421: getfield 1410	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2424: invokevirtual 1364	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2427: ifle +254 -> 2681
    //   2430: new 142	java/util/ArrayList
    //   2433: dup
    //   2434: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2437: astore 30
    //   2439: iconst_0
    //   2440: istore 6
    //   2442: iload 6
    //   2444: aload 28
    //   2446: getfield 1410	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2449: invokevirtual 1364	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2452: if_icmpge +222 -> 2674
    //   2455: aload 28
    //   2457: getfield 1410	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2460: iload 6
    //   2462: invokevirtual 1367	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2465: checkcast 1412	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2468: astore 31
    //   2470: new 1414	com/tencent/mobileqq/profile/ProfileGroupLabel
    //   2473: dup
    //   2474: invokespecial 1415	com/tencent/mobileqq/profile/ProfileGroupLabel:<init>	()V
    //   2477: astore 32
    //   2479: aload 32
    //   2481: aload 31
    //   2483: getfield 1418	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2486: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2489: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2492: putfield 1419	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2495: aload 32
    //   2497: aload 31
    //   2499: getfield 1422	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2502: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2505: i2l
    //   2506: putfield 1423	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_Long	J
    //   2509: aload 32
    //   2511: aload 31
    //   2513: getfield 1426	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2516: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2519: i2l
    //   2520: putfield 1428	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_b_of_type_Long	J
    //   2523: new 1430	com/tencent/mobileqq/profile/ProfileColor
    //   2526: dup
    //   2527: invokespecial 1431	com/tencent/mobileqq/profile/ProfileColor:<init>	()V
    //   2530: astore 33
    //   2532: aload 33
    //   2534: aload 31
    //   2536: getfield 1435	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2539: getfield 1440	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2542: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2545: i2l
    //   2546: putfield 1441	com/tencent/mobileqq/profile/ProfileColor:jdField_a_of_type_Long	J
    //   2549: aload 33
    //   2551: aload 31
    //   2553: getfield 1435	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2556: getfield 1444	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2559: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2562: i2l
    //   2563: putfield 1445	com/tencent/mobileqq/profile/ProfileColor:jdField_b_of_type_Long	J
    //   2566: aload 33
    //   2568: aload 31
    //   2570: getfield 1435	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2573: getfield 1448	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2576: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2579: i2l
    //   2580: putfield 1450	com/tencent/mobileqq/profile/ProfileColor:c	J
    //   2583: aload 32
    //   2585: aload 33
    //   2587: putfield 1453	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_b_of_type_ComTencentMobileqqProfileProfileColor	Lcom/tencent/mobileqq/profile/ProfileColor;
    //   2590: new 1430	com/tencent/mobileqq/profile/ProfileColor
    //   2593: dup
    //   2594: invokespecial 1431	com/tencent/mobileqq/profile/ProfileColor:<init>	()V
    //   2597: astore 33
    //   2599: aload 33
    //   2601: aload 31
    //   2603: getfield 1456	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2606: getfield 1440	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2609: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2612: i2l
    //   2613: putfield 1441	com/tencent/mobileqq/profile/ProfileColor:jdField_a_of_type_Long	J
    //   2616: aload 33
    //   2618: aload 31
    //   2620: getfield 1456	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2623: getfield 1444	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2626: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2629: i2l
    //   2630: putfield 1445	com/tencent/mobileqq/profile/ProfileColor:jdField_b_of_type_Long	J
    //   2633: aload 33
    //   2635: aload 31
    //   2637: getfield 1456	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2640: getfield 1448	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2643: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2646: i2l
    //   2647: putfield 1450	com/tencent/mobileqq/profile/ProfileColor:c	J
    //   2650: aload 32
    //   2652: aload 33
    //   2654: putfield 1458	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_ComTencentMobileqqProfileProfileColor	Lcom/tencent/mobileqq/profile/ProfileColor;
    //   2657: aload 30
    //   2659: aload 32
    //   2661: invokevirtual 1459	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2664: pop
    //   2665: iload 6
    //   2667: iconst_1
    //   2668: iadd
    //   2669: istore 6
    //   2671: goto -229 -> 2442
    //   2674: aload 29
    //   2676: aload 30
    //   2678: putfield 1461	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2681: aload 27
    //   2683: aload 29
    //   2685: invokevirtual 1459	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2688: pop
    //   2689: iload 5
    //   2691: iconst_1
    //   2692: iadd
    //   2693: istore 5
    //   2695: goto -418 -> 2277
    //   2698: aload 26
    //   2700: aload 27
    //   2702: putfield 1462	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   2705: aload_1
    //   2706: aload 26
    //   2708: invokeinterface 177 2 0
    //   2713: pop
    //   2714: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2717: ifeq -604 -> 2113
    //   2720: ldc_w 786
    //   2723: iconst_2
    //   2724: new 49	java/lang/StringBuilder
    //   2727: dup
    //   2728: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   2731: ldc_w 1464
    //   2734: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: aload_2
    //   2738: getfield 1358	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2741: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2744: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2747: ldc_w 1466
    //   2750: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2753: iload 9
    //   2755: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2758: ldc_w 1468
    //   2761: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2764: aload_2
    //   2765: getfield 1471	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2768: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2771: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2774: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2777: goto -664 -> 2113
    //   2780: astore_2
    //   2781: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2784: ifeq -671 -> 2113
    //   2787: ldc_w 786
    //   2790: iconst_2
    //   2791: aload_2
    //   2792: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   2795: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2798: goto -685 -> 2113
    //   2801: new 142	java/util/ArrayList
    //   2804: dup
    //   2805: invokespecial 143	java/util/ArrayList:<init>	()V
    //   2808: astore_1
    //   2809: aload 25
    //   2811: getfield 1474	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2814: ifnull +379 -> 3193
    //   2817: aload 25
    //   2819: getfield 1474	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2822: invokevirtual 1279	java/util/ArrayList:size	()I
    //   2825: ifle +368 -> 3193
    //   2828: iconst_0
    //   2829: istore 4
    //   2831: iload 4
    //   2833: aload 25
    //   2835: getfield 1474	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2838: invokevirtual 1279	java/util/ArrayList:size	()I
    //   2841: if_icmpge +352 -> 3193
    //   2844: aload 25
    //   2846: getfield 1474	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2849: iload 4
    //   2851: invokevirtual 1280	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2854: checkcast 645	[B
    //   2857: astore 26
    //   2859: aload 26
    //   2861: ifnonnull +22 -> 2883
    //   2864: iconst_0
    //   2865: istore 5
    //   2867: iload 5
    //   2869: bipush 10
    //   2871: if_icmpgt +20 -> 2891
    //   2874: iload 4
    //   2876: iconst_1
    //   2877: iadd
    //   2878: istore 4
    //   2880: goto -49 -> 2831
    //   2883: aload 26
    //   2885: arraylength
    //   2886: istore 5
    //   2888: goto -21 -> 2867
    //   2891: aload 26
    //   2893: iconst_1
    //   2894: invokestatic 1322	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2897: l2i
    //   2898: istore 6
    //   2900: aload 26
    //   2902: iconst_5
    //   2903: invokestatic 1322	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2906: l2i
    //   2907: istore 9
    //   2909: iload 6
    //   2911: ifle -37 -> 2874
    //   2914: iload 6
    //   2916: bipush 9
    //   2918: iadd
    //   2919: iload 5
    //   2921: if_icmpge -47 -> 2874
    //   2924: iload 6
    //   2926: newarray byte
    //   2928: astore_2
    //   2929: aload_2
    //   2930: iconst_0
    //   2931: aload 26
    //   2933: bipush 9
    //   2935: iload 6
    //   2937: invokestatic 1325	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   2940: new 1327	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2943: dup
    //   2944: invokespecial 1328	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2947: astore 26
    //   2949: aload 26
    //   2951: aload_2
    //   2952: invokevirtual 1329	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2955: pop
    //   2956: aload 26
    //   2958: getfield 1333	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2961: invokevirtual 1336	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2964: istore 5
    //   2966: iload 5
    //   2968: ifne +157 -> 3125
    //   2971: new 1476	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   2974: dup
    //   2975: invokespecial 1477	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   2978: astore_2
    //   2979: aload_2
    //   2980: aload 26
    //   2982: getfield 1358	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2985: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2988: putfield 1478	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   2991: aload 26
    //   2993: getfield 1482	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2996: ifnull +102 -> 3098
    //   2999: aload_2
    //   3000: aload 26
    //   3002: getfield 1482	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3005: getfield 1487	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3008: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3011: putfield 1488	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3014: aload_2
    //   3015: aload 26
    //   3017: getfield 1482	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3020: getfield 1491	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3023: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3026: putfield 1492	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3029: aload_2
    //   3030: aload 26
    //   3032: getfield 1482	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3035: getfield 1495	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3038: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3041: putfield 1496	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   3044: aload_2
    //   3045: aload 26
    //   3047: getfield 1482	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3050: getfield 1499	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3053: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3056: putfield 1500	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3059: aload_2
    //   3060: invokevirtual 1502	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   3063: ifne -189 -> 2874
    //   3066: aload_1
    //   3067: aload_2
    //   3068: invokeinterface 177 2 0
    //   3073: pop
    //   3074: goto -200 -> 2874
    //   3077: astore_2
    //   3078: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3081: ifeq -207 -> 2874
    //   3084: ldc_w 786
    //   3087: iconst_2
    //   3088: aload_2
    //   3089: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   3092: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3095: goto -221 -> 2874
    //   3098: aload_2
    //   3099: ldc 216
    //   3101: putfield 1488	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3104: aload_2
    //   3105: ldc 216
    //   3107: putfield 1492	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3110: aload_2
    //   3111: ldc 216
    //   3113: putfield 1496	com/tencent/mobileqq/profile/ProfileBusiEntry:c	Ljava/lang/String;
    //   3116: aload_2
    //   3117: ldc 216
    //   3119: putfield 1500	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3122: goto -63 -> 3059
    //   3125: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3128: ifeq -254 -> 2874
    //   3131: ldc_w 786
    //   3134: iconst_4
    //   3135: new 49	java/lang/StringBuilder
    //   3138: dup
    //   3139: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3142: ldc_w 1504
    //   3145: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3148: aload 26
    //   3150: getfield 1358	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3153: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3156: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3159: ldc_w 1506
    //   3162: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3165: iload 5
    //   3167: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3170: ldc_w 1506
    //   3173: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3176: aload 26
    //   3178: getfield 1471	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3181: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3184: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3187: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3190: goto -316 -> 2874
    //   3193: aload_3
    //   3194: aload_1
    //   3195: invokevirtual 1510	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   3198: aload 25
    //   3200: getfield 1514	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3203: ifnonnull +128 -> 3331
    //   3206: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3209: ifeq +13 -> 3222
    //   3212: ldc_w 786
    //   3215: iconst_2
    //   3216: ldc_w 1516
    //   3219: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3222: aload 25
    //   3224: getfield 1519	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3227: ifnull +1359 -> 4586
    //   3230: new 1521	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   3233: dup
    //   3234: invokespecial 1522	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   3237: astore_1
    //   3238: aload_1
    //   3239: aload 25
    //   3241: getfield 1519	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3244: invokevirtual 1523	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3247: pop
    //   3248: aload_1
    //   3249: ifnull +2612 -> 5861
    //   3252: aload_1
    //   3253: getfield 1526	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3256: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3259: astore_1
    //   3260: new 142	java/util/ArrayList
    //   3263: dup
    //   3264: invokespecial 143	java/util/ArrayList:<init>	()V
    //   3267: astore_2
    //   3268: aload_1
    //   3269: ifnull +157 -> 3426
    //   3272: aload_1
    //   3273: invokeinterface 157 1 0
    //   3278: astore_1
    //   3279: aload_1
    //   3280: invokeinterface 162 1 0
    //   3285: ifeq +141 -> 3426
    //   3288: aload_1
    //   3289: invokeinterface 166 1 0
    //   3294: checkcast 1528	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   3297: astore 26
    //   3299: aload 26
    //   3301: getfield 1531	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3304: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3307: iconst_1
    //   3308: if_icmpne +112 -> 3420
    //   3311: iconst_1
    //   3312: istore 21
    //   3314: aload_2
    //   3315: aload 26
    //   3317: iload 21
    //   3319: invokestatic 1537	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   3322: invokeinterface 177 2 0
    //   3327: pop
    //   3328: goto -49 -> 3279
    //   3331: aload 25
    //   3333: getfield 1514	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3336: getfield 1542	SummaryCard/InterestTagInfo:uFlag	J
    //   3339: lstore 16
    //   3341: new 1544	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   3344: dup
    //   3345: invokespecial 1545	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   3348: astore_1
    //   3349: aload_1
    //   3350: aload 25
    //   3352: getfield 1514	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3355: getfield 1548	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   3358: invokevirtual 1549	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3361: pop
    //   3362: aload_3
    //   3363: lload 16
    //   3365: aload_1
    //   3366: getfield 1552	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3369: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3372: invokevirtual 479	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   3375: goto -153 -> 3222
    //   3378: astore_1
    //   3379: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3382: ifeq -160 -> 3222
    //   3385: ldc_w 1554
    //   3388: iconst_2
    //   3389: aload_1
    //   3390: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   3393: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3396: goto -174 -> 3222
    //   3399: astore_2
    //   3400: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3403: ifeq -155 -> 3248
    //   3406: ldc_w 786
    //   3409: iconst_2
    //   3410: aload_2
    //   3411: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   3414: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3417: goto -169 -> 3248
    //   3420: iconst_0
    //   3421: istore 21
    //   3423: goto -109 -> 3314
    //   3426: aload_2
    //   3427: invokeinterface 153 1 0
    //   3432: ifle +2429 -> 5861
    //   3435: iconst_0
    //   3436: istore 4
    //   3438: iload 4
    //   3440: aload_2
    //   3441: invokeinterface 153 1 0
    //   3446: if_icmpge +2415 -> 5861
    //   3449: aload_2
    //   3450: iload 4
    //   3452: invokeinterface 208 2 0
    //   3457: checkcast 1533	com/tencent/mobileqq/data/HotChatInfo
    //   3460: astore_1
    //   3461: aload_1
    //   3462: ifnull +1115 -> 4577
    //   3465: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3468: ifeq +30 -> 3498
    //   3471: ldc_w 786
    //   3474: iconst_2
    //   3475: new 49	java/lang/StringBuilder
    //   3478: dup
    //   3479: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3482: ldc_w 1556
    //   3485: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3488: aload_1
    //   3489: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3492: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3495: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3498: aload_1
    //   3499: ifnull +8 -> 3507
    //   3502: aload_3
    //   3503: aload_1
    //   3504: invokevirtual 1560	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   3507: aload_3
    //   3508: getfield 1040	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3511: ifnull +484 -> 3995
    //   3514: new 1562	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   3517: dup
    //   3518: invokespecial 1563	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   3521: astore_1
    //   3522: aload_1
    //   3523: aload_3
    //   3524: getfield 1040	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3527: invokevirtual 1564	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3530: pop
    //   3531: iload 8
    //   3533: bipush 51
    //   3535: if_icmpne +1082 -> 4617
    //   3538: aload_1
    //   3539: getfield 1567	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3542: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3545: iconst_1
    //   3546: if_icmpne +1059 -> 4605
    //   3549: iconst_1
    //   3550: istore 21
    //   3552: aload_3
    //   3553: iload 21
    //   3555: putfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   3558: aload_1
    //   3559: getfield 1570	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3562: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3565: iconst_1
    //   3566: if_icmpne +1045 -> 4611
    //   3569: iconst_1
    //   3570: istore 21
    //   3572: aload_3
    //   3573: iload 21
    //   3575: putfield 1109	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   3578: aload_3
    //   3579: aload_1
    //   3580: getfield 1573	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3583: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3586: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3589: putfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   3592: aload_3
    //   3593: aload_1
    //   3594: getfield 1576	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3597: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3600: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3603: putfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   3606: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3609: ifeq +1118 -> 4727
    //   3612: ldc_w 1578
    //   3615: iconst_2
    //   3616: new 49	java/lang/StringBuilder
    //   3619: dup
    //   3620: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3623: ldc_w 1580
    //   3626: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3629: iload 8
    //   3631: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3634: ldc_w 1582
    //   3637: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3640: aload_1
    //   3641: getfield 1567	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3644: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3647: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3650: ldc_w 1584
    //   3653: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3656: aload_1
    //   3657: getfield 1573	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3660: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3663: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3666: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3669: ldc_w 1586
    //   3672: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3675: aload_0
    //   3676: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3679: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3682: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3685: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3688: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3691: aload_3
    //   3692: aload_1
    //   3693: getfield 1589	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3696: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3699: putfield 1118	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   3702: aload_1
    //   3703: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3706: invokevirtual 1596	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   3709: ifeq +1123 -> 4832
    //   3712: aload_3
    //   3713: aload_1
    //   3714: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3717: invokevirtual 1597	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3720: checkcast 1595	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3723: getfield 1600	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3726: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3729: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3732: putfield 1151	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3735: aload_3
    //   3736: aload_1
    //   3737: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3740: invokevirtual 1597	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3743: checkcast 1595	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3746: getfield 1603	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3749: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3752: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3755: putfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3758: aload_3
    //   3759: aload_1
    //   3760: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3763: invokevirtual 1597	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3766: checkcast 1595	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3769: getfield 1606	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3772: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3775: putfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3778: aload_3
    //   3779: aload_1
    //   3780: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3783: invokevirtual 1597	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3786: checkcast 1595	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3789: getfield 1609	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3792: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3795: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3798: putfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3801: aload_3
    //   3802: aload_1
    //   3803: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3806: invokevirtual 1597	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3809: checkcast 1595	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3812: getfield 1612	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3815: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3818: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3821: aload_3
    //   3822: aload_1
    //   3823: getfield 1593	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3826: invokevirtual 1597	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3829: checkcast 1595	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3832: getfield 1615	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3835: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3838: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3841: aload_1
    //   3842: getfield 1618	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3845: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3848: iconst_1
    //   3849: if_icmpne +1019 -> 4868
    //   3852: iconst_1
    //   3853: istore 21
    //   3855: aload_3
    //   3856: iload 21
    //   3858: putfield 1621	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3861: aload_3
    //   3862: aload_1
    //   3863: getfield 1624	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3866: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3869: putfield 1627	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3872: aload_3
    //   3873: aload_1
    //   3874: getfield 1630	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3877: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3880: putfield 1633	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3883: aload_3
    //   3884: aload_1
    //   3885: getfield 1636	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3888: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3891: putfield 1639	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3894: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3897: ifeq +98 -> 3995
    //   3900: ldc_w 1641
    //   3903: iconst_2
    //   3904: new 49	java/lang/StringBuilder
    //   3907: dup
    //   3908: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   3911: ldc_w 1643
    //   3914: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3917: aload_3
    //   3918: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   3921: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3924: ldc_w 1645
    //   3927: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3930: aload_3
    //   3931: getfield 1621	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3934: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3937: ldc_w 1647
    //   3940: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3943: aload_3
    //   3944: invokevirtual 1650	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   3947: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3950: ldc_w 1652
    //   3953: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3956: aload_3
    //   3957: getfield 1627	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3960: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3963: ldc_w 1654
    //   3966: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3969: aload_3
    //   3970: getfield 1639	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3973: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3976: ldc_w 1656
    //   3979: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3982: aload_3
    //   3983: getfield 1633	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3986: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3989: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3992: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3995: aload 25
    //   3997: getfield 1660	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4000: ifnull +27 -> 4027
    //   4003: aload_3
    //   4004: aload 25
    //   4006: getfield 1660	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4009: getfield 1665	SummaryCard/GiftInfo:uOpenFlag	J
    //   4012: putfield 581	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   4015: aload_3
    //   4016: aload 25
    //   4018: getfield 1660	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4021: getfield 1666	SummaryCard/GiftInfo:vGiftInfo	[B
    //   4024: putfield 1667	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   4027: aload 25
    //   4029: getfield 1670	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4032: ifnull +162 -> 4194
    //   4035: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4038: ifeq +12 -> 4050
    //   4041: ldc 24
    //   4043: iconst_2
    //   4044: ldc_w 1672
    //   4047: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4050: new 1674	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   4053: dup
    //   4054: invokespecial 1675	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   4057: astore_1
    //   4058: aload_1
    //   4059: aload 25
    //   4061: getfield 1670	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4064: invokevirtual 1676	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4067: pop
    //   4068: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4071: ifeq +82 -> 4153
    //   4074: ldc 24
    //   4076: iconst_2
    //   4077: new 49	java/lang/StringBuilder
    //   4080: dup
    //   4081: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4084: ldc_w 1678
    //   4087: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4090: aload_1
    //   4091: getfield 1681	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4094: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4097: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4100: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4103: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4106: aload_1
    //   4107: getfield 1684	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4110: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4113: ifeq +40 -> 4153
    //   4116: ldc 24
    //   4118: iconst_2
    //   4119: new 49	java/lang/StringBuilder
    //   4122: dup
    //   4123: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4126: ldc_w 1686
    //   4129: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: aload_1
    //   4133: getfield 1684	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4136: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4139: invokeinterface 153 1 0
    //   4144: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4147: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4150: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4153: aload_1
    //   4154: getfield 1681	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4157: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4160: iconst_1
    //   4161: if_icmpne +713 -> 4874
    //   4164: iconst_1
    //   4165: istore 21
    //   4167: aload_3
    //   4168: iload 21
    //   4170: putfield 1689	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   4173: aload_1
    //   4174: getfield 1684	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4177: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4180: ifeq +14 -> 4194
    //   4183: aload_3
    //   4184: aload_1
    //   4185: getfield 1684	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4188: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4191: invokevirtual 1692	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   4194: aload 25
    //   4196: getfield 1695	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   4199: astore_1
    //   4200: aload_1
    //   4201: ifnull +39 -> 4240
    //   4204: new 1697	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   4207: dup
    //   4208: invokespecial 1698	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   4211: astore_2
    //   4212: aload_2
    //   4213: aload_1
    //   4214: invokevirtual 1699	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4217: pop
    //   4218: aload_3
    //   4219: aload_2
    //   4220: getfield 1702	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4223: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4226: putfield 1705	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   4229: aload_3
    //   4230: aload_2
    //   4231: getfield 1708	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4234: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4237: putfield 1711	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   4240: aload 25
    //   4242: getfield 1714	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4245: astore_1
    //   4246: aload_1
    //   4247: ifnull +684 -> 4931
    //   4250: aload_3
    //   4251: new 142	java/util/ArrayList
    //   4254: dup
    //   4255: invokespecial 143	java/util/ArrayList:<init>	()V
    //   4258: putfield 1717	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4261: new 1719	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   4264: dup
    //   4265: invokespecial 1720	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   4268: astore_2
    //   4269: aload_2
    //   4270: aload_1
    //   4271: invokevirtual 1721	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4274: pop
    //   4275: aload_2
    //   4276: getfield 1724	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4279: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4282: astore_1
    //   4283: aload_1
    //   4284: ifnull +647 -> 4931
    //   4287: new 1095	org/json/JSONArray
    //   4290: dup
    //   4291: invokespecial 1096	org/json/JSONArray:<init>	()V
    //   4294: astore_2
    //   4295: iconst_0
    //   4296: istore 4
    //   4298: iload 4
    //   4300: aload_1
    //   4301: invokeinterface 153 1 0
    //   4306: if_icmpge +613 -> 4919
    //   4309: new 1726	org/json/JSONObject
    //   4312: dup
    //   4313: invokespecial 1727	org/json/JSONObject:<init>	()V
    //   4316: astore 26
    //   4318: new 1729	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   4321: dup
    //   4322: invokespecial 1730	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   4325: astore 27
    //   4327: aload 27
    //   4329: aload_1
    //   4330: iload 4
    //   4332: invokeinterface 208 2 0
    //   4337: checkcast 1732	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4340: getfield 1735	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4343: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4346: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4349: putfield 1737	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4352: aload 27
    //   4354: getfield 1737	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4357: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4360: ifne +17 -> 4377
    //   4363: aload 26
    //   4365: ldc_w 1738
    //   4368: aload 27
    //   4370: getfield 1737	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4373: invokevirtual 1741	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4376: pop
    //   4377: aload 27
    //   4379: aload_1
    //   4380: iload 4
    //   4382: invokeinterface 208 2 0
    //   4387: checkcast 1732	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4390: getfield 1744	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4393: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4396: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4399: putfield 1747	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4402: aload 27
    //   4404: getfield 1747	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4407: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4410: ifne +17 -> 4427
    //   4413: aload 26
    //   4415: ldc_w 1748
    //   4418: aload 27
    //   4420: getfield 1747	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4423: invokevirtual 1741	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4426: pop
    //   4427: aload 27
    //   4429: aload_1
    //   4430: iload 4
    //   4432: invokeinterface 208 2 0
    //   4437: checkcast 1732	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4440: getfield 1751	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4443: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4446: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4449: putfield 1753	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4452: aload 27
    //   4454: getfield 1753	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4457: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4460: ifne +17 -> 4477
    //   4463: aload 26
    //   4465: ldc_w 1754
    //   4468: aload 27
    //   4470: getfield 1753	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4473: invokevirtual 1741	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4476: pop
    //   4477: aload 27
    //   4479: aload_1
    //   4480: iload 4
    //   4482: invokeinterface 208 2 0
    //   4487: checkcast 1732	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4490: getfield 1757	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4493: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4496: putfield 1760	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4499: aload 26
    //   4501: ldc_w 1761
    //   4504: aload 27
    //   4506: getfield 1760	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4509: invokevirtual 1764	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4512: pop
    //   4513: aload 27
    //   4515: aload_1
    //   4516: iload 4
    //   4518: invokeinterface 208 2 0
    //   4523: checkcast 1732	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4526: getfield 1767	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4529: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4532: putfield 1770	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4535: aload 26
    //   4537: ldc_w 1771
    //   4540: aload 27
    //   4542: getfield 1770	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4545: invokevirtual 1764	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4548: pop
    //   4549: aload_3
    //   4550: getfield 1717	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4553: aload 27
    //   4555: invokeinterface 177 2 0
    //   4560: pop
    //   4561: aload_2
    //   4562: aload 26
    //   4564: invokevirtual 1099	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4567: pop
    //   4568: iload 4
    //   4570: iconst_1
    //   4571: iadd
    //   4572: istore 4
    //   4574: goto -276 -> 4298
    //   4577: iload 4
    //   4579: iconst_1
    //   4580: iadd
    //   4581: istore 4
    //   4583: goto -1145 -> 3438
    //   4586: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4589: ifeq -1082 -> 3507
    //   4592: ldc_w 786
    //   4595: iconst_2
    //   4596: ldc_w 1773
    //   4599: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4602: goto -1095 -> 3507
    //   4605: iconst_0
    //   4606: istore 21
    //   4608: goto -1056 -> 3552
    //   4611: iconst_0
    //   4612: istore 21
    //   4614: goto -1042 -> 3572
    //   4617: aload_3
    //   4618: aload_1
    //   4619: getfield 1567	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4622: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4625: putfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4628: aload_3
    //   4629: getfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4632: iconst_1
    //   4633: if_icmpne +82 -> 4715
    //   4636: iconst_1
    //   4637: istore 21
    //   4639: aload_3
    //   4640: iload 21
    //   4642: putfield 1112	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4645: aload_1
    //   4646: getfield 1570	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4649: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4652: iconst_1
    //   4653: if_icmpne +68 -> 4721
    //   4656: iconst_1
    //   4657: istore 21
    //   4659: aload_3
    //   4660: iload 21
    //   4662: putfield 1106	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4665: aload_3
    //   4666: aload_1
    //   4667: getfield 1573	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4670: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4673: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4676: putfield 1130	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4679: aload_3
    //   4680: aload_1
    //   4681: getfield 1576	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4684: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4687: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4690: putfield 1124	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4693: goto -1087 -> 3606
    //   4696: astore_1
    //   4697: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4700: ifeq -705 -> 3995
    //   4703: ldc 24
    //   4705: iconst_2
    //   4706: ldc_w 1775
    //   4709: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4712: goto -717 -> 3995
    //   4715: iconst_0
    //   4716: istore 21
    //   4718: goto -79 -> 4639
    //   4721: iconst_0
    //   4722: istore 21
    //   4724: goto -65 -> 4659
    //   4727: ldc_w 1578
    //   4730: iconst_1
    //   4731: new 49	java/lang/StringBuilder
    //   4734: dup
    //   4735: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4738: ldc_w 1580
    //   4741: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4744: iload 8
    //   4746: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4749: ldc_w 1582
    //   4752: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4755: aload_1
    //   4756: getfield 1567	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4759: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4762: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4765: ldc_w 1584
    //   4768: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4771: aload_1
    //   4772: getfield 1573	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4775: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4778: invokevirtual 211	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4781: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4784: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4787: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4790: goto -1099 -> 3691
    //   4793: astore_2
    //   4794: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4797: ifeq -1106 -> 3691
    //   4800: ldc 24
    //   4802: iconst_2
    //   4803: new 49	java/lang/StringBuilder
    //   4806: dup
    //   4807: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4810: ldc_w 1777
    //   4813: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4816: aload_2
    //   4817: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   4820: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4823: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4826: invokestatic 1289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4829: goto -1138 -> 3691
    //   4832: aload_3
    //   4833: ldc 216
    //   4835: putfield 1151	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4838: aload_3
    //   4839: ldc 216
    //   4841: putfield 1148	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4844: aload_3
    //   4845: iconst_0
    //   4846: putfield 1145	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4849: aload_3
    //   4850: ldc 216
    //   4852: putfield 1136	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4855: aload_3
    //   4856: iconst_0
    //   4857: putfield 1139	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4860: aload_3
    //   4861: iconst_0
    //   4862: putfield 1142	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4865: goto -1024 -> 3841
    //   4868: iconst_0
    //   4869: istore 21
    //   4871: goto -1016 -> 3855
    //   4874: iconst_0
    //   4875: istore 21
    //   4877: goto -710 -> 4167
    //   4880: astore_1
    //   4881: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4884: ifeq -690 -> 4194
    //   4887: ldc 24
    //   4889: iconst_2
    //   4890: new 49	java/lang/StringBuilder
    //   4893: dup
    //   4894: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4897: ldc_w 1779
    //   4900: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4903: aload_1
    //   4904: invokevirtual 1780	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4907: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4910: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4913: invokestatic 1289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4916: goto -722 -> 4194
    //   4919: aload_2
    //   4920: ifnull +11 -> 4931
    //   4923: aload_3
    //   4924: aload_2
    //   4925: invokevirtual 1168	org/json/JSONArray:toString	()Ljava/lang/String;
    //   4928: putfield 1783	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   4931: aload_3
    //   4932: aload 25
    //   4934: getfield 1714	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4937: putfield 1786	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   4940: new 1788	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   4943: dup
    //   4944: invokespecial 1789	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   4947: astore_2
    //   4948: aload_2
    //   4949: aload 25
    //   4951: getfield 1714	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4954: invokevirtual 1790	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4957: pop
    //   4958: aload_2
    //   4959: astore_1
    //   4960: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4963: ifeq +70 -> 5033
    //   4966: ldc_w 1792
    //   4969: iconst_2
    //   4970: new 49	java/lang/StringBuilder
    //   4973: dup
    //   4974: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   4977: ldc_w 1794
    //   4980: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4983: aload_2
    //   4984: getfield 1797	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4987: invokevirtual 439	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4990: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4993: ldc_w 1799
    //   4996: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4999: aload_2
    //   5000: getfield 1802	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5003: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5006: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5009: ldc_w 1804
    //   5012: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5015: aload_2
    //   5016: getfield 1807	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5019: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5022: invokevirtual 656	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5025: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5028: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5031: aload_2
    //   5032: astore_1
    //   5033: aload_3
    //   5034: aload_1
    //   5035: putfield 1811	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   5038: aload_0
    //   5039: bipush 51
    //   5041: iconst_1
    //   5042: aload_3
    //   5043: iload 22
    //   5045: invokevirtual 1814	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;Z)V
    //   5048: aload_0
    //   5049: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5052: bipush 105
    //   5054: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5057: checkcast 511	com/tencent/mobileqq/nearby/NearbyCardManager
    //   5060: astore_1
    //   5061: iload 8
    //   5063: bipush 51
    //   5065: if_icmpne +444 -> 5509
    //   5068: aload_1
    //   5069: aload_3
    //   5070: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5073: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   5076: invokevirtual 1817	com/tencent/mobileqq/nearby/NearbyCardManager:b	(Ljava/lang/String;J)V
    //   5079: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5082: ifeq +45 -> 5127
    //   5085: ldc_w 356
    //   5088: iconst_4
    //   5089: new 49	java/lang/StringBuilder
    //   5092: dup
    //   5093: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5096: ldc_w 1819
    //   5099: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5102: aload_3
    //   5103: getfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5106: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5109: ldc_w 1821
    //   5112: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5115: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   5118: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5121: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5124: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5127: aload_0
    //   5128: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5131: bipush 50
    //   5133: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5136: checkcast 1823	com/tencent/mobileqq/app/FriendsManager
    //   5139: astore_1
    //   5140: invokestatic 1825	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   5143: ifeq +54 -> 5197
    //   5146: ldc 24
    //   5148: iconst_5
    //   5149: anewarray 79	java/lang/Object
    //   5152: dup
    //   5153: iconst_0
    //   5154: ldc_w 1827
    //   5157: aastore
    //   5158: dup
    //   5159: iconst_1
    //   5160: iload 8
    //   5162: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5165: aastore
    //   5166: dup
    //   5167: iconst_2
    //   5168: aload_3
    //   5169: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5172: aastore
    //   5173: dup
    //   5174: iconst_3
    //   5175: aload_0
    //   5176: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5179: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5182: aastore
    //   5183: dup
    //   5184: iconst_4
    //   5185: aload 25
    //   5187: getfield 847	SummaryCard/RespSummaryCard:lUIN	J
    //   5190: invokestatic 1832	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5193: aastore
    //   5194: invokestatic 1835	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   5197: iload 8
    //   5199: ifeq +20 -> 5219
    //   5202: aload_3
    //   5203: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5206: aload_0
    //   5207: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5210: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5213: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5216: ifeq +72 -> 5288
    //   5219: aload_1
    //   5220: aload_3
    //   5221: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5224: invokevirtual 1838	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   5227: astore_2
    //   5228: aload_2
    //   5229: aload_3
    //   5230: getfield 872	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   5233: putfield 1843	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5236: aload_2
    //   5237: aload_3
    //   5238: getfield 869	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   5241: i2l
    //   5242: putfield 1846	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5245: aload_0
    //   5246: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5249: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5252: aload_2
    //   5253: getfield 1846	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5256: aload_2
    //   5257: getfield 1843	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5260: invokestatic 1849	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   5263: pop
    //   5264: aload_1
    //   5265: aload_2
    //   5266: invokevirtual 1852	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5269: pop
    //   5270: aload_0
    //   5271: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5274: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5277: ldc_w 544
    //   5280: aload_3
    //   5281: getfield 542	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   5284: invokestatic 458	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   5287: pop
    //   5288: aload_0
    //   5289: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5292: invokevirtual 293	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5295: aload_3
    //   5296: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5299: invokevirtual 856	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5302: ifeq +29 -> 5331
    //   5305: aload_3
    //   5306: getfield 1210	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5309: ifle +22 -> 5331
    //   5312: aload_0
    //   5313: getfield 241	com/tencent/mobileqq/nearby/business/NearbyCardHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5316: bipush 59
    //   5318: invokevirtual 509	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5321: checkcast 1854	com/tencent/mobileqq/app/HotChatManager
    //   5324: aload_3
    //   5325: getfield 1210	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5328: invokevirtual 1855	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   5331: aload_1
    //   5332: aload_3
    //   5333: invokevirtual 1858	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   5336: aload_3
    //   5337: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5340: sipush 1000
    //   5343: if_icmpne +435 -> 5778
    //   5346: aload 23
    //   5348: iconst_0
    //   5349: ldc_w 413
    //   5352: invokevirtual 273	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5355: aconst_null
    //   5356: aconst_null
    //   5357: aconst_null
    //   5358: aconst_null
    //   5359: aconst_null
    //   5360: aconst_null
    //   5361: aconst_null
    //   5362: invokevirtual 1861	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5365: astore_2
    //   5366: aload_2
    //   5367: ifnull +286 -> 5653
    //   5370: aload_2
    //   5371: astore_1
    //   5372: aload_2
    //   5373: invokeinterface 1866 1 0
    //   5378: istore 4
    //   5380: aload_2
    //   5381: astore_1
    //   5382: aload_2
    //   5383: invokeinterface 1869 1 0
    //   5388: pop
    //   5389: iload 4
    //   5391: sipush 200
    //   5394: if_icmple +259 -> 5653
    //   5397: iload 4
    //   5399: bipush 100
    //   5401: if_icmple +130 -> 5531
    //   5404: aload_2
    //   5405: astore_1
    //   5406: aload_2
    //   5407: invokeinterface 1872 1 0
    //   5412: pop
    //   5413: iload 4
    //   5415: iconst_1
    //   5416: isub
    //   5417: istore 4
    //   5419: goto -22 -> 5397
    //   5422: astore_1
    //   5423: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5426: ifeq -495 -> 4931
    //   5429: ldc 24
    //   5431: iconst_2
    //   5432: new 49	java/lang/StringBuilder
    //   5435: dup
    //   5436: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5439: ldc_w 1874
    //   5442: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5445: aload_1
    //   5446: invokevirtual 627	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5449: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5452: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5455: invokestatic 1289	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5458: goto -527 -> 4931
    //   5461: astore 26
    //   5463: aconst_null
    //   5464: astore_2
    //   5465: aload_2
    //   5466: astore_1
    //   5467: invokestatic 22	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5470: ifeq -437 -> 5033
    //   5473: ldc_w 1792
    //   5476: iconst_2
    //   5477: new 49	java/lang/StringBuilder
    //   5480: dup
    //   5481: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5484: ldc_w 1876
    //   5487: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5490: aload 26
    //   5492: invokevirtual 1100	java/lang/Exception:toString	()Ljava/lang/String;
    //   5495: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5498: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5501: invokestatic 1167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5504: aload_2
    //   5505: astore_1
    //   5506: goto -473 -> 5033
    //   5509: aload_1
    //   5510: aload_3
    //   5511: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5514: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   5517: invokevirtual 1878	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   5520: goto -441 -> 5079
    //   5523: astore_2
    //   5524: aload_2
    //   5525: invokevirtual 1879	java/lang/Exception:printStackTrace	()V
    //   5528: goto -240 -> 5288
    //   5531: aload_2
    //   5532: astore_1
    //   5533: aload_2
    //   5534: aload_2
    //   5535: ldc_w 1881
    //   5538: invokeinterface 1884 2 0
    //   5543: invokeinterface 1887 2 0
    //   5548: istore 4
    //   5550: aload_2
    //   5551: astore_1
    //   5552: new 49	java/lang/StringBuilder
    //   5555: dup
    //   5556: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5559: astore 25
    //   5561: aload_2
    //   5562: astore_1
    //   5563: aload 25
    //   5565: ldc_w 1889
    //   5568: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5571: pop
    //   5572: aload_2
    //   5573: astore_1
    //   5574: aload 25
    //   5576: ldc_w 413
    //   5579: invokevirtual 273	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5582: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5585: pop
    //   5586: aload_2
    //   5587: astore_1
    //   5588: aload 25
    //   5590: ldc_w 1891
    //   5593: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5596: pop
    //   5597: aload_2
    //   5598: astore_1
    //   5599: aload 25
    //   5601: ldc_w 1881
    //   5604: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5607: pop
    //   5608: aload_2
    //   5609: astore_1
    //   5610: aload 25
    //   5612: ldc_w 1893
    //   5615: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5618: pop
    //   5619: aload_2
    //   5620: astore_1
    //   5621: aload 25
    //   5623: iload 4
    //   5625: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5628: pop
    //   5629: aload_2
    //   5630: astore_1
    //   5631: aload 25
    //   5633: ldc_w 279
    //   5636: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5639: pop
    //   5640: aload_2
    //   5641: astore_1
    //   5642: aload 23
    //   5644: aload 25
    //   5646: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5649: invokevirtual 284	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   5652: pop
    //   5653: aload_2
    //   5654: astore_1
    //   5655: aload 23
    //   5657: aload_3
    //   5658: invokevirtual 586	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   5661: aload_2
    //   5662: astore_1
    //   5663: aload 24
    //   5665: invokevirtual 1895	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   5668: aload_2
    //   5669: ifnull +9 -> 5678
    //   5672: aload_2
    //   5673: invokeinterface 1898 1 0
    //   5678: aload 24
    //   5680: invokevirtual 1900	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   5683: aload 23
    //   5685: invokevirtual 354	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   5688: new 588	java/util/HashMap
    //   5691: dup
    //   5692: invokespecial 589	java/util/HashMap:<init>	()V
    //   5695: astore_1
    //   5696: aload_1
    //   5697: ldc_w 591
    //   5700: iload 7
    //   5702: invokestatic 594	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5705: invokevirtual 598	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5708: pop
    //   5709: invokestatic 604	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   5712: invokestatic 609	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   5715: aload_0
    //   5716: getfield 612	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5719: invokevirtual 615	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5722: ldc_w 1902
    //   5725: iload 20
    //   5727: lload 14
    //   5729: lload 12
    //   5731: lsub
    //   5732: lconst_0
    //   5733: aload_1
    //   5734: ldc 216
    //   5736: invokevirtual 620	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   5739: invokestatic 778	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5742: ifeq -5729 -> 13
    //   5745: ldc_w 786
    //   5748: iconst_4
    //   5749: new 49	java/lang/StringBuilder
    //   5752: dup
    //   5753: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   5756: ldc_w 1904
    //   5759: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5762: invokestatic 796	java/lang/System:currentTimeMillis	()J
    //   5765: lload 10
    //   5767: lsub
    //   5768: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5771: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5774: invokestatic 430	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5777: return
    //   5778: aload_3
    //   5779: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5782: sipush 1001
    //   5785: if_icmpeq +13 -> 5798
    //   5788: aload_3
    //   5789: invokevirtual 584	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5792: sipush 1002
    //   5795: if_icmpne +10 -> 5805
    //   5798: aload 23
    //   5800: aload_3
    //   5801: invokevirtual 633	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   5804: pop
    //   5805: aconst_null
    //   5806: astore_2
    //   5807: goto -146 -> 5661
    //   5810: astore_2
    //   5811: aconst_null
    //   5812: astore_1
    //   5813: aload_1
    //   5814: ifnull +9 -> 5823
    //   5817: aload_1
    //   5818: invokeinterface 1898 1 0
    //   5823: aload 24
    //   5825: invokevirtual 1900	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   5828: aload 23
    //   5830: invokevirtual 354	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   5833: aload_2
    //   5834: athrow
    //   5835: aload_0
    //   5836: bipush 51
    //   5838: iconst_0
    //   5839: aconst_null
    //   5840: iload 22
    //   5842: invokevirtual 1814	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(IZLjava/lang/Object;Z)V
    //   5845: goto -157 -> 5688
    //   5848: astore_2
    //   5849: goto -36 -> 5813
    //   5852: astore_1
    //   5853: goto -1613 -> 4240
    //   5856: astore 23
    //   5858: goto -4741 -> 1117
    //   5861: aconst_null
    //   5862: astore_1
    //   5863: goto -2398 -> 3465
    //   5866: goto -5522 -> 344
    //   5869: aconst_null
    //   5870: astore_2
    //   5871: goto -5667 -> 204
    //   5874: lconst_0
    //   5875: lstore 10
    //   5877: goto -5816 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5880	0	this	NearbyCardHandler
    //   0	5880	1	paramToServiceMsg	ToServiceMsg
    //   0	5880	2	paramFromServiceMsg	FromServiceMsg
    //   0	5880	3	paramObject	Object
    //   1020	4604	4	i	int
    //   2104	1062	5	j	int
    //   2143	793	6	k	int
    //   94	5607	7	m	int
    //   214	4984	8	n	int
    //   2151	757	9	i1	int
    //   59	5817	10	l1	long
    //   83	5647	12	l2	long
    //   88	5640	14	l3	long
    //   262	3102	16	l4	long
    //   1151	154	18	l5	long
    //   114	5612	20	bool1	boolean
    //   1639	3237	21	bool2	boolean
    //   71	5770	22	bool3	boolean
    //   97	5732	23	localObject1	Object
    //   5856	1	23	localException1	Exception
    //   176	71	24	localObject2	Object
    //   1108	4716	24	localException2	Exception
    //   225	5420	25	localObject3	Object
    //   938	97	26	localObject4	Object
    //   1830	25	26	localException3	Exception
    //   2172	2391	26	localObject5	Object
    //   5461	30	26	localException4	Exception
    //   963	3591	27	localObject6	Object
    //   991	1465	28	localObject7	Object
    //   2316	368	29	localProfileSummaryHobbiesItem	com.tencent.mobileqq.profile.ProfileSummaryHobbiesItem
    //   2437	240	30	localArrayList	ArrayList
    //   2468	168	31	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2477	183	32	localProfileGroupLabel	com.tencent.mobileqq.profile.ProfileGroupLabel
    //   2530	123	33	localProfileColor	com.tencent.mobileqq.profile.ProfileColor
    // Exception table:
    //   from	to	target	type
    //   121	143	1108	java/lang/Exception
    //   965	1019	1830	java/lang/Exception
    //   1022	1071	1830	java/lang/Exception
    //   1421	1430	1830	java/lang/Exception
    //   2193	2218	2780	java/lang/Exception
    //   2223	2274	2780	java/lang/Exception
    //   2277	2439	2780	java/lang/Exception
    //   2442	2665	2780	java/lang/Exception
    //   2674	2681	2780	java/lang/Exception
    //   2681	2689	2780	java/lang/Exception
    //   2698	2705	2780	java/lang/Exception
    //   2705	2777	2780	java/lang/Exception
    //   2949	2966	3077	java/lang/Exception
    //   2971	3059	3077	java/lang/Exception
    //   3059	3074	3077	java/lang/Exception
    //   3098	3122	3077	java/lang/Exception
    //   3125	3190	3077	java/lang/Exception
    //   3341	3375	3378	java/lang/Exception
    //   3238	3248	3399	java/lang/Exception
    //   3522	3531	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3538	3549	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3552	3569	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3572	3606	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3606	3691	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3691	3841	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3841	3852	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3855	3995	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4617	4636	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4639	4656	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4659	4693	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4727	4790	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4794	4829	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4832	4865	4696	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3606	3691	4793	java/lang/Exception
    //   4727	4790	4793	java/lang/Exception
    //   4035	4050	4880	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4050	4153	4880	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4153	4164	4880	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4167	4194	4880	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4269	4283	5422	java/lang/Exception
    //   4287	4295	5422	java/lang/Exception
    //   4298	4377	5422	java/lang/Exception
    //   4377	4427	5422	java/lang/Exception
    //   4427	4477	5422	java/lang/Exception
    //   4477	4568	5422	java/lang/Exception
    //   4923	4931	5422	java/lang/Exception
    //   4940	4958	5461	java/lang/Exception
    //   4960	5031	5461	java/lang/Exception
    //   5270	5288	5523	java/lang/Exception
    //   5336	5366	5810	finally
    //   5778	5798	5810	finally
    //   5798	5805	5810	finally
    //   5372	5380	5848	finally
    //   5382	5389	5848	finally
    //   5406	5413	5848	finally
    //   5533	5550	5848	finally
    //   5552	5561	5848	finally
    //   5563	5572	5848	finally
    //   5574	5586	5848	finally
    //   5588	5597	5848	finally
    //   5599	5608	5848	finally
    //   5610	5619	5848	finally
    //   5621	5629	5848	finally
    //   5631	5640	5848	finally
    //   5642	5653	5848	finally
    //   5655	5661	5848	finally
    //   5663	5668	5848	finally
    //   4212	4240	5852	java/lang/Exception
    //   147	154	5856	java/lang/Exception
    //   157	178	5856	java/lang/Exception
    //   187	204	5856	java/lang/Exception
    //   1092	1098	5856	java/lang/Exception
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
    //   18: ldc_w 1962
    //   21: iconst_2
    //   22: new 49	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 1964
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
    //   136: ldc_w 1962
    //   139: iconst_2
    //   140: new 49	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1966
    //   150: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 647	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 30	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 1913	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 1914	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 61	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 67	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 73	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 1915	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 1913	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 79	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 1947	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 146	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 1950	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 1953	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 1956	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 1959	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
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
    //   280: ldc_w 1968
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
    //   319: checkcast 1921	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 1970
    //   328: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 1973	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 1975
    //   345: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 1978	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 377	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1980
    //   362: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 1983	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 1985
    //   379: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 1987
    //   396: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 1989
    //   408: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 1991
    //   420: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 1993
    //   432: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 823	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 1962
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
    //   487: ldc_w 1962
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 1923	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
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