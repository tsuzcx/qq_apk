package com.tencent.mobileqq.data;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.EqqAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EqqDetail
  extends Entity
{
  public byte[] accountData;
  public String address = "";
  @notColumn
  public String certifiedDescription = "腾讯认证公众号";
  public int certifiedGrade;
  public String displayNumber = "";
  public long eqqAccountFlag;
  public int followType;
  public List groupInfoList;
  public boolean isConfirmed;
  public boolean isRecvMsg;
  public String latitude = "";
  public String longitude = "";
  public boolean mIsAgreeSyncLbs;
  public boolean mIsSyncLbs;
  public boolean mIsSyncLbsSelected;
  public int mShowMsgFlag = -1;
  public String name = "公众帐号";
  public String phoneNumber = "";
  public String realSummary = "";
  public int seqno;
  public String summary = "挺好的";
  @unique
  public String uin;
  
  public EqqDetail() {}
  
  public EqqDetail(mobileqq_mp.GetEqqAccountDetailInfoResponse paramGetEqqAccountDetailInfoResponse)
  {
    Object localObject = (mobileqq_mp.EqqAccountInfo)paramGetEqqAccountDetailInfoResponse.accountInfo.get();
    this.uin = ("" + (((mobileqq_mp.EqqAccountInfo)localObject).uin.get() & 0xFFFFFFFF));
    this.seqno = paramGetEqqAccountDetailInfoResponse.seqno.get();
    this.name = ((mobileqq_mp.EqqAccountInfo)localObject).name.get();
    this.summary = ((mobileqq_mp.EqqAccountInfo)localObject).summary.get();
    this.realSummary = paramGetEqqAccountDetailInfoResponse.introduce.get();
    this.isRecvMsg = paramGetEqqAccountDetailInfoResponse.is_recv_msg.get();
    this.groupInfoList = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetEqqAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = ((mobileqq_mp.EqqAccountInfo)localObject).display_number.get();
    this.phoneNumber = paramGetEqqAccountDetailInfoResponse.phone_number.get();
    this.certifiedGrade = ((mobileqq_mp.EqqAccountInfo)localObject).certified_grade.get();
    long l;
    int i;
    int j;
    label349:
    int n;
    int k;
    if (((mobileqq_mp.EqqAccountInfo)localObject).account_flag.has())
    {
      l = ((mobileqq_mp.EqqAccountInfo)localObject).account_flag.get();
      this.eqqAccountFlag = l;
      this.latitude = paramGetEqqAccountDetailInfoResponse.lat.get();
      this.longitude = paramGetEqqAccountDetailInfoResponse.lng.get();
      this.address = paramGetEqqAccountDetailInfoResponse.address.get();
      this.accountData = paramGetEqqAccountDetailInfoResponse.toByteArray();
      this.mShowMsgFlag = -1;
      if ((!paramGetEqqAccountDetailInfoResponse.config_group_info.has()) || (paramGetEqqAccountDetailInfoResponse.config_group_info.isEmpty())) {
        break label749;
      }
      paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
      if ((paramGetEqqAccountDetailInfoResponse == null) || (paramGetEqqAccountDetailInfoResponse.size() <= 0)) {
        break label749;
      }
      paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.iterator();
      i = 0;
      j = 0;
      if (!paramGetEqqAccountDetailInfoResponse.hasNext()) {
        break label746;
      }
      localObject = (mobileqq_mp.ConfigGroupInfo)paramGetEqqAccountDetailInfoResponse.next();
      n = i;
      k = j;
      if (!((mobileqq_mp.ConfigGroupInfo)localObject).config_info.has()) {
        break label737;
      }
      n = i;
      k = j;
      if (((mobileqq_mp.ConfigGroupInfo)localObject).config_info.isEmpty()) {
        break label737;
      }
      localObject = ((mobileqq_mp.ConfigGroupInfo)localObject).config_info.get().iterator();
      int m = j;
      j = i;
      label482:
      label636:
      do
      {
        do
        {
          n = j;
          k = m;
          if (!((Iterator)localObject).hasNext()) {
            break label737;
          }
          mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)((Iterator)localObject).next();
          k = m;
          if (localConfigInfo.state_id.get() == 5)
          {
            if (localConfigInfo.state.get() != 1) {
              break;
            }
            i = 1;
            this.mShowMsgFlag = i;
            k = 1;
          }
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
                  this.mIsSyncLbs = true;
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
            m = k;
          }
        } while (k == 0);
        j = i;
        m = k;
      } while (i == 0);
      j = k;
      label660:
      if ((j == 0) || (i == 0)) {
        break label734;
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.mIsSyncLbs = false;
      }
      return;
      l = 0L;
      break;
      i = 0;
      break label482;
      this.mIsSyncLbsSelected = false;
      this.mIsAgreeSyncLbs = false;
      i = 1;
      break label636;
      this.mIsSyncLbsSelected = true;
      this.mIsAgreeSyncLbs = true;
      i = 1;
      break label636;
      this.mIsSyncLbsSelected = true;
      this.mIsAgreeSyncLbs = false;
      i = 1;
      break label636;
      label734:
      break label349;
      label737:
      i = n;
      j = k;
      break label660;
      label746:
      continue;
      label749:
      i = 0;
    }
  }
  
  public void clone(EqqDetail paramEqqDetail)
  {
    this.uin = paramEqqDetail.uin;
    this.seqno = paramEqqDetail.seqno;
    this.name = paramEqqDetail.name;
    this.summary = paramEqqDetail.summary;
    this.realSummary = paramEqqDetail.realSummary;
    this.isRecvMsg = paramEqqDetail.isRecvMsg;
    this.followType = paramEqqDetail.followType;
    this.latitude = paramEqqDetail.latitude;
    this.longitude = paramEqqDetail.longitude;
    this.accountData = paramEqqDetail.accountData;
    this.groupInfoList = paramEqqDetail.groupInfoList;
    this.displayNumber = paramEqqDetail.displayNumber;
    this.certifiedGrade = paramEqqDetail.certifiedGrade;
    this.address = paramEqqDetail.address;
    this.phoneNumber = paramEqqDetail.phoneNumber;
    this.mShowMsgFlag = paramEqqDetail.mShowMsgFlag;
    this.mIsSyncLbs = paramEqqDetail.mIsSyncLbs;
    this.mIsAgreeSyncLbs = paramEqqDetail.mIsAgreeSyncLbs;
    this.mIsSyncLbsSelected = paramEqqDetail.mIsSyncLbsSelected;
  }
  
  public boolean hasIvrAbility()
  {
    if (!CrmUtils.a) {
      if (QLog.isDevelopLevel()) {
        QLog.d("EqqDetail", 4, "Don't support sharp");
      }
    }
    while ((this.eqqAccountFlag & 0x400000) != 4194304L) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.EqqDetail
 * JD-Core Version:    0.7.0.1
 */