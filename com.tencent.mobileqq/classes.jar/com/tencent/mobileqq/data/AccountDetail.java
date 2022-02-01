package com.tencent.mobileqq.data;

import anvx;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.pb.oac.OACProfilePb.BaseData;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import ojh;
import oji;
import org.json.JSONObject;

public class AccountDetail
  extends Entity
{
  @notColumn
  public static final int ANCIENT = 0;
  @notColumn
  public static final int VERSION_839 = 1;
  public byte[] accountData;
  public int accountFlag;
  public long accountFlag2;
  @notColumn
  public int cardStyle = 0;
  public String certifiedDescription = "";
  @notColumn
  public String certifiedEnterprise = "";
  public int certifiedGrade;
  @notColumn
  public String certifiedWeixin = "";
  public String configBackgroundColor = "3d7fe3";
  @notColumn
  public String configBackgroundImg = "";
  @notColumn
  public List<ojh> customConfigAttrs;
  public String displayNumber = "";
  public int followType;
  @notColumn
  public List<ojh> fullscreenConfigAttrs;
  public int groupId;
  public List<mobileqq_mp.ConfigGroupInfo> groupInfoList;
  public boolean isAgreeSyncLbs;
  public boolean isConfirmed;
  public boolean isRecvMsg;
  public boolean isRecvPush;
  public boolean isShowFollowButton;
  public boolean isShowShareButton;
  public boolean isSyncLbs;
  public boolean isSyncLbsSelected;
  public String lastHistoryMsg;
  public int mShowMsgFlag = -1;
  @notColumn
  public mobileqq_mp.GetPublicAccountMenuResponse menuButtonResp;
  public String name = anvx.a(2131699240);
  public List<mobileqq_mp.ConfigGroupInfo> newGroupInfoList;
  @notColumn
  public List<ojh> paConfigAttrs;
  public byte[] protocol839Data;
  public int protocolVersion = 0;
  public int seqno;
  public int sharedFollowerCount;
  public int showFlag;
  public String summary = anvx.a(2131699243);
  @unique
  public String uin;
  @notColumn
  public String unifiedDesrpition;
  
  public AccountDetail() {}
  
  public AccountDetail(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    this.uin = ("" + (paramGetPublicAccountDetailInfoResponse.uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetPublicAccountDetailInfoResponse.seqno.get();
    this.name = paramGetPublicAccountDetailInfoResponse.name.get();
    this.summary = paramGetPublicAccountDetailInfoResponse.summary.get();
    this.isRecvMsg = paramGetPublicAccountDetailInfoResponse.is_recv_msg.get();
    this.isShowFollowButton = paramGetPublicAccountDetailInfoResponse.is_show_follow_button.get();
    this.isShowShareButton = paramGetPublicAccountDetailInfoResponse.is_show_share_button.get();
    this.groupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetPublicAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = paramGetPublicAccountDetailInfoResponse.display_number.get();
    this.groupId = paramGetPublicAccountDetailInfoResponse.group_id.get();
    this.isRecvPush = paramGetPublicAccountDetailInfoResponse.is_recv_push.get();
    this.certifiedGrade = paramGetPublicAccountDetailInfoResponse.certified_grade.get();
    this.showFlag = paramGetPublicAccountDetailInfoResponse.show_flag.get();
    this.accountFlag = paramGetPublicAccountDetailInfoResponse.account_flag.get();
    this.accountFlag2 = paramGetPublicAccountDetailInfoResponse.account_flag2.get();
    this.accountData = paramGetPublicAccountDetailInfoResponse.toByteArray();
    this.configBackgroundColor = paramGetPublicAccountDetailInfoResponse.config_background_color.get();
    this.configBackgroundImg = paramGetPublicAccountDetailInfoResponse.config_background_img.get();
    this.newGroupInfoList = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
    this.certifiedDescription = paramGetPublicAccountDetailInfoResponse.certified_description.get();
    if (paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.has()) {
      this.unifiedDesrpition = paramGetPublicAccountDetailInfoResponse.unified_account_descrpition.get();
    }
    parser();
    this.mShowMsgFlag = -1;
    if (this.unifiedDesrpition != null)
    {
      initShowMsgFlag_v5_9();
      initLbsItem_v5_9();
    }
    for (;;)
    {
      this.protocolVersion = 0;
      return;
      initShowMsgFlag(paramGetPublicAccountDetailInfoResponse);
      initLbsItem(paramGetPublicAccountDetailInfoResponse);
    }
  }
  
  public AccountDetail(OACProfilePb.ProfileDataRsp paramProfileDataRsp)
  {
    this.uin = ("" + paramProfileDataRsp.base_data.puin.get());
    this.name = paramProfileDataRsp.base_data.name.get();
    this.summary = paramProfileDataRsp.base_data.summary.get();
    this.isRecvMsg = paramProfileDataRsp.base_data.is_recv_msg.get();
    this.isShowFollowButton = paramProfileDataRsp.base_data.is_show_follow_button.get();
    this.followType = paramProfileDataRsp.base_data.follow_type.get();
    this.isRecvPush = paramProfileDataRsp.base_data.is_recv_push.get();
    this.accountFlag = paramProfileDataRsp.base_data.account_flag.get();
    this.accountFlag2 = paramProfileDataRsp.base_data.account_flag2.get();
    this.displayNumber = paramProfileDataRsp.base_data.display_number.get();
    if (paramProfileDataRsp.base_data.unified_account_descrpition.has()) {
      this.unifiedDesrpition = paramProfileDataRsp.base_data.unified_account_descrpition.get();
    }
    parser();
    this.mShowMsgFlag = -1;
    this.menuButtonResp = paramProfileDataRsp.menu_rsp;
    this.protocolVersion = 1;
    this.protocol839Data = paramProfileDataRsp.toByteArray();
    this.sharedFollowerCount = paramProfileDataRsp.common_follower_count.get();
    this.showFlag = 1;
  }
  
  public void clone(AccountDetail paramAccountDetail)
  {
    this.uin = paramAccountDetail.uin;
    this.seqno = paramAccountDetail.seqno;
    this.name = paramAccountDetail.name;
    this.summary = paramAccountDetail.summary;
    this.isRecvMsg = paramAccountDetail.isRecvMsg;
    this.followType = paramAccountDetail.followType;
    this.isShowFollowButton = paramAccountDetail.isShowFollowButton;
    this.accountData = paramAccountDetail.accountData;
    this.groupInfoList = paramAccountDetail.groupInfoList;
    this.displayNumber = paramAccountDetail.displayNumber;
    this.groupId = paramAccountDetail.groupId;
    this.isRecvPush = paramAccountDetail.isRecvPush;
    this.isSyncLbs = paramAccountDetail.isSyncLbs;
    this.certifiedGrade = paramAccountDetail.certifiedGrade;
    this.showFlag = paramAccountDetail.showFlag;
    this.accountFlag = paramAccountDetail.accountFlag;
    this.accountFlag2 = paramAccountDetail.accountFlag2;
    this.mShowMsgFlag = paramAccountDetail.mShowMsgFlag;
    this.configBackgroundColor = paramAccountDetail.configBackgroundColor;
    this.configBackgroundImg = paramAccountDetail.configBackgroundImg;
    this.newGroupInfoList = paramAccountDetail.newGroupInfoList;
    this.certifiedDescription = paramAccountDetail.certifiedDescription;
    this.isAgreeSyncLbs = paramAccountDetail.isAgreeSyncLbs;
    this.isSyncLbsSelected = paramAccountDetail.isSyncLbsSelected;
    this.unifiedDesrpition = paramAccountDetail.unifiedDesrpition;
    this.paConfigAttrs = paramAccountDetail.paConfigAttrs;
    this.customConfigAttrs = paramAccountDetail.customConfigAttrs;
    this.fullscreenConfigAttrs = paramAccountDetail.fullscreenConfigAttrs;
    this.cardStyle = paramAccountDetail.cardStyle;
    this.menuButtonResp = paramAccountDetail.menuButtonResp;
    this.protocolVersion = paramAccountDetail.protocolVersion;
    this.protocol839Data = paramAccountDetail.protocol839Data;
    this.sharedFollowerCount = paramAccountDetail.sharedFollowerCount;
  }
  
  public List<mobileqq_mp.ButtonInfo> getButtonInfo()
  {
    Object localObject = null;
    if (this.menuButtonResp != null) {
      localObject = this.menuButtonResp.button_info.get();
    }
    while (this.protocol839Data == null) {
      return localObject;
    }
    localObject = new OACProfilePb.ProfileDataRsp();
    try
    {
      ((OACProfilePb.ProfileDataRsp)localObject).mergeFrom(this.protocol839Data);
      this.menuButtonResp = ((OACProfilePb.ProfileDataRsp)localObject).menu_rsp;
      localObject = this.menuButtonResp.button_info.get();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  void initLbsItem(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    int i;
    int k;
    if ((paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) && (!paramGetPublicAccountDetailInfoResponse.config_group_info_new.isEmpty()))
    {
      paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.config_group_info_new.get();
      if ((paramGetPublicAccountDetailInfoResponse != null) && (paramGetPublicAccountDetailInfoResponse.size() > 0))
      {
        paramGetPublicAccountDetailInfoResponse = paramGetPublicAccountDetailInfoResponse.iterator();
        i = 0;
        if (paramGetPublicAccountDetailInfoResponse.hasNext())
        {
          Object localObject = (mobileqq_mp.ConfigGroupInfo)paramGetPublicAccountDetailInfoResponse.next();
          k = i;
          if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has())
          {
            k = i;
            if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty())
            {
              localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
              int j = i;
              label286:
              do
              {
                k = j;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
                i = j;
                if (localConfigInfo.type.has())
                {
                  i = j;
                  if (localConfigInfo.type.get() == 2)
                  {
                    i = j;
                    if (localConfigInfo.state_id.has())
                    {
                      i = j;
                      if (localConfigInfo.state_id.get() == 3)
                      {
                        this.isSyncLbs = true;
                        if (!localConfigInfo.state.has()) {}
                      }
                    }
                  }
                }
                switch (localConfigInfo.state.get())
                {
                default: 
                  if (QLog.isColorLevel()) {
                    QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localConfigInfo.state.get());
                  }
                  i = 1;
                  j = i;
                }
              } while (i == 0);
              label292:
              if (i == 0) {}
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.isSyncLbs = false;
      }
      return;
      this.isSyncLbsSelected = false;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label286;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = true;
      i = 1;
      break label286;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label286;
      break;
      i = k;
      break label292;
      continue;
      i = 0;
    }
  }
  
  void initLbsItem_v5_9()
  {
    if (this.paConfigAttrs == null) {
      return;
    }
    Iterator localIterator = this.paConfigAttrs.iterator();
    int i = 0;
    label20:
    int j;
    while (localIterator.hasNext())
    {
      Object localObject = (ojh)localIterator.next();
      if ((((ojh)localObject).jdField_a_of_type_Int != 1) && (((ojh)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        localObject = ((ojh)localObject).jdField_a_of_type_JavaUtilList.iterator();
        j = i;
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            oji localoji = (oji)((Iterator)localObject).next();
            i = j;
            if (localoji.jdField_a_of_type_Int == 2)
            {
              i = j;
              if (localoji.e == 3) {
                this.isSyncLbs = true;
              }
            }
            switch (localoji.d)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EqqDetail", 2, "Error Eqq lbs state value: " + localoji.d);
              }
              i = 1;
              label191:
              j = i;
              if (i != 0) {
                label197:
                if (i == 0) {}
              }
              break;
            }
          }
        }
      }
    }
    while (i == 0)
    {
      this.isSyncLbs = false;
      return;
      this.isSyncLbsSelected = false;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label191;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = true;
      i = 1;
      break label191;
      this.isSyncLbsSelected = true;
      this.isAgreeSyncLbs = false;
      i = 1;
      break label191;
      break label20;
      i = j;
      break label197;
    }
  }
  
  void initShowMsgFlag(mobileqq_mp.GetPublicAccountDetailInfoResponse paramGetPublicAccountDetailInfoResponse)
  {
    if (paramGetPublicAccountDetailInfoResponse.config_group_info.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info.get());
    }
    if (paramGetPublicAccountDetailInfoResponse.config_group_info_new.has()) {
      parserMsgFlag(paramGetPublicAccountDetailInfoResponse.config_group_info_new.get());
    }
  }
  
  void initShowMsgFlag_v5_9()
  {
    if (this.paConfigAttrs == null) {}
    label20:
    label104:
    label124:
    for (;;)
    {
      return;
      Iterator localIterator = this.paConfigAttrs.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = (ojh)localIterator.next();
        if ((((ojh)localObject).jdField_a_of_type_Int != 1) && (((ojh)localObject).jdField_a_of_type_JavaUtilList != null))
        {
          localObject = ((ojh)localObject).jdField_a_of_type_JavaUtilList.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              oji localoji = (oji)((Iterator)localObject).next();
              if (localoji.e == 5) {
                if (localoji.d == 1)
                {
                  i = 1;
                  this.mShowMsgFlag = i;
                  i = 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label124;
        }
        break label20;
        break;
        i = 0;
        break label104;
      }
    }
  }
  
  public void parser()
  {
    if (this.unifiedDesrpition == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.unifiedDesrpition);
      this.certifiedDescription = localJSONObject.optString("certified_description");
      this.configBackgroundColor = localJSONObject.optString("background_color");
      this.certifiedEnterprise = localJSONObject.optString("certified_enterprise");
      this.certifiedWeixin = localJSONObject.optString("certified_weixin");
      this.paConfigAttrs = ojh.a(localJSONObject.optJSONArray("config_arr"));
      this.customConfigAttrs = ojh.a(localJSONObject.optJSONArray("custom_arr"));
      this.fullscreenConfigAttrs = ojh.a(localJSONObject.optJSONArray("fullscreen_arr"));
      this.cardStyle = localJSONObject.optInt("card_style");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void parserMsgFlag(List<mobileqq_mp.ConfigGroupInfo> paramList)
  {
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      i = 0;
      if (paramList.hasNext())
      {
        Object localObject = (mobileqq_mp.ConfigGroupInfo)paramList.next();
        if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) {
          break label130;
        }
        localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
            if (localConfigInfo.state_id.get() == 5) {
              if (localConfigInfo.state.get() == 1)
              {
                i = 1;
                label110:
                this.mShowMsgFlag = i;
                i = 1;
              }
            }
          }
        }
      }
    }
    label130:
    for (;;)
    {
      if (i != 0)
      {
        return;
        i = 0;
        break label110;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.AccountDetail
 * JD-Core Version:    0.7.0.1
 */