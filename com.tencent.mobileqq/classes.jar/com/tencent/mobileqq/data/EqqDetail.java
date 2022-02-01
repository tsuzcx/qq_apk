package com.tencent.mobileqq.data;

import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
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
  public byte[] accountData = null;
  public String address = "";
  @notColumn
  public String certifiedDescription;
  public int certifiedGrade = 0;
  public String displayNumber = "";
  public long eqqAccountFlag;
  public int followType = 0;
  public List<mobileqq_mp.ConfigGroupInfo> groupInfoList;
  public boolean isConfirmed;
  public boolean isRecvMsg = false;
  public String latitude = "";
  public String longitude = "";
  public boolean mIsAgreeSyncLbs;
  public boolean mIsSyncLbs;
  public boolean mIsSyncLbsSelected;
  public int mShowMsgFlag;
  public String name = HardCodeUtil.a(2131902220);
  public String phoneNumber = "";
  public String realSummary = "";
  public int seqno = 0;
  public String summary = HardCodeUtil.a(2131902218);
  @unique
  public String uin;
  
  public EqqDetail()
  {
    this.eqqAccountFlag = 0L;
    this.isConfirmed = false;
    this.mShowMsgFlag = -1;
    this.mIsSyncLbs = false;
    this.mIsAgreeSyncLbs = false;
    this.mIsSyncLbsSelected = false;
    this.certifiedDescription = HardCodeUtil.a(2131902219);
  }
  
  public EqqDetail(mobileqq_mp.GetEqqAccountDetailInfoResponse paramGetEqqAccountDetailInfoResponse)
  {
    long l = 0L;
    this.eqqAccountFlag = 0L;
    this.isConfirmed = false;
    this.mShowMsgFlag = -1;
    this.mIsSyncLbs = false;
    this.mIsAgreeSyncLbs = false;
    this.mIsSyncLbsSelected = false;
    this.certifiedDescription = HardCodeUtil.a(2131902219);
    Object localObject1 = (mobileqq_mp.EqqAccountInfo)paramGetEqqAccountDetailInfoResponse.accountInfo.get();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(((mobileqq_mp.EqqAccountInfo)localObject1).uin.get() & 0xFFFFFFFF);
    this.uin = ((StringBuilder)localObject2).toString();
    this.seqno = paramGetEqqAccountDetailInfoResponse.seqno.get();
    this.name = ((mobileqq_mp.EqqAccountInfo)localObject1).name.get();
    this.summary = ((mobileqq_mp.EqqAccountInfo)localObject1).summary.get();
    this.realSummary = paramGetEqqAccountDetailInfoResponse.introduce.get();
    this.isRecvMsg = paramGetEqqAccountDetailInfoResponse.is_recv_msg.get();
    this.groupInfoList = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
    this.followType = paramGetEqqAccountDetailInfoResponse.follow_type.get();
    this.displayNumber = ((mobileqq_mp.EqqAccountInfo)localObject1).display_number.get();
    this.phoneNumber = paramGetEqqAccountDetailInfoResponse.phone_number.get();
    this.certifiedGrade = ((mobileqq_mp.EqqAccountInfo)localObject1).certified_grade.get();
    if (((mobileqq_mp.EqqAccountInfo)localObject1).account_flag.has()) {
      l = ((mobileqq_mp.EqqAccountInfo)localObject1).account_flag.get();
    }
    this.eqqAccountFlag = l;
    this.latitude = paramGetEqqAccountDetailInfoResponse.lat.get();
    this.longitude = paramGetEqqAccountDetailInfoResponse.lng.get();
    this.address = paramGetEqqAccountDetailInfoResponse.address.get();
    this.accountData = paramGetEqqAccountDetailInfoResponse.toByteArray();
    this.mShowMsgFlag = -1;
    if ((paramGetEqqAccountDetailInfoResponse.config_group_info.has()) && (!paramGetEqqAccountDetailInfoResponse.config_group_info.isEmpty()))
    {
      paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.config_group_info.get();
      if ((paramGetEqqAccountDetailInfoResponse != null) && (paramGetEqqAccountDetailInfoResponse.size() > 0))
      {
        paramGetEqqAccountDetailInfoResponse = paramGetEqqAccountDetailInfoResponse.iterator();
        int i = 0;
        int k = 0;
        do
        {
          int m;
          do
          {
            j = i;
            if (!paramGetEqqAccountDetailInfoResponse.hasNext()) {
              break;
            }
            localObject1 = (mobileqq_mp.ConfigGroupInfo)paramGetEqqAccountDetailInfoResponse.next();
            j = i;
            m = k;
            if (((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.has())
            {
              j = i;
              m = k;
              if (!((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.isEmpty())
              {
                localObject1 = ((mobileqq_mp.ConfigGroupInfo)localObject1).config_info.get().iterator();
                do
                {
                  do
                  {
                    j = i;
                    m = k;
                    if (!((Iterator)localObject1).hasNext()) {
                      break;
                    }
                    localObject2 = (mobileqq_mp.ConfigInfo)((Iterator)localObject1).next();
                    m = k;
                    if (((mobileqq_mp.ConfigInfo)localObject2).state_id.get() == 5)
                    {
                      if (((mobileqq_mp.ConfigInfo)localObject2).state.get() == 1) {
                        j = 1;
                      } else {
                        j = 0;
                      }
                      this.mShowMsgFlag = j;
                      m = 1;
                    }
                    j = i;
                    if (((mobileqq_mp.ConfigInfo)localObject2).type.has())
                    {
                      j = i;
                      if (((mobileqq_mp.ConfigInfo)localObject2).type.get() == 2)
                      {
                        j = i;
                        if (((mobileqq_mp.ConfigInfo)localObject2).state_id.has())
                        {
                          j = i;
                          if (((mobileqq_mp.ConfigInfo)localObject2).state_id.get() == 3)
                          {
                            this.mIsSyncLbs = true;
                            if (((mobileqq_mp.ConfigInfo)localObject2).state.has())
                            {
                              i = ((mobileqq_mp.ConfigInfo)localObject2).state.get();
                              if (i != 0)
                              {
                                if (i != 1)
                                {
                                  if (i != 2)
                                  {
                                    if (QLog.isColorLevel())
                                    {
                                      StringBuilder localStringBuilder = new StringBuilder();
                                      localStringBuilder.append("Error Eqq lbs state value: ");
                                      localStringBuilder.append(((mobileqq_mp.ConfigInfo)localObject2).state.get());
                                      QLog.e("EqqDetail", 2, localStringBuilder.toString());
                                    }
                                  }
                                  else
                                  {
                                    this.mIsSyncLbsSelected = true;
                                    this.mIsAgreeSyncLbs = false;
                                  }
                                }
                                else
                                {
                                  this.mIsSyncLbsSelected = true;
                                  this.mIsAgreeSyncLbs = true;
                                }
                              }
                              else
                              {
                                this.mIsSyncLbsSelected = false;
                                this.mIsAgreeSyncLbs = false;
                              }
                            }
                            j = 1;
                          }
                        }
                      }
                    }
                    i = j;
                    k = m;
                  } while (m == 0);
                  i = j;
                  k = m;
                } while (j == 0);
              }
            }
            i = j;
            k = m;
          } while (m == 0);
          i = j;
          k = m;
        } while (j == 0);
        break label794;
      }
    }
    int j = 0;
    label794:
    if (j == 0) {
      this.mIsSyncLbs = false;
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
    boolean bool2 = CrmUtils.b;
    boolean bool1 = false;
    if (!bool2)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EqqDetail", 4, "Don't support sharp");
      }
      return false;
    }
    if ((this.eqqAccountFlag & 0x400000) == 4194304L) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.EqqDetail
 * JD-Core Version:    0.7.0.1
 */