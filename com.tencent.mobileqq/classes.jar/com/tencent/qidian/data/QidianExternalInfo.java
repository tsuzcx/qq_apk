package com.tencent.qidian.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qidian.proto.mobileqq_qidian.CompanyShowCaseInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ExternalInfo;
import com.tencent.qidian.proto.mobileqq_qidian.GroupItem;
import com.tencent.qidian.proto.mobileqq_qidian.PubAccItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QidianExternalInfo
  extends Entity
{
  private static final String TAG = "QidianExternalInfo";
  public long city;
  public long country;
  public long district;
  public long externalOidbflag;
  public int gender;
  public String icon = "";
  public byte[] infoByte;
  public int isShowCall;
  public int isShowVideoCall;
  public String job = "";
  private List<CompanyShowCaseInfo> mCompanyShowCaseInfos = null;
  private List<GroupItem> mGroupItems = null;
  private List<GroupItem> mGroupItemsCorp = null;
  private List<PublicAccountItem> mPubAccItems = null;
  private List<PublicAccountItem> mPubAccItemsCorp = null;
  public String mail = "";
  public String masterUin = "";
  public String mobile = "";
  public String nickname = "";
  public long province;
  public String sign = "";
  public String tel = "";
  @unique
  public String uin = "";
  public String verify_url;
  public int verity;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (QidianExternalInfo)paramObject;
    return Arrays.equals(this.infoByte, paramObject.infoByte);
  }
  
  public void from(mobileqq_qidian.ExternalInfo paramExternalInfo)
  {
    this.infoByte = paramExternalInfo.toByteArray();
    if (paramExternalInfo.uint64_uin.has()) {
      this.uin = String.valueOf(paramExternalInfo.uint64_uin.get());
    }
    if (paramExternalInfo.str_external_nick.has()) {
      this.nickname = paramExternalInfo.str_external_nick.get();
    }
    if (paramExternalInfo.str_external_icon.has()) {
      this.icon = paramExternalInfo.str_external_icon.get();
    }
    if (paramExternalInfo.str_external_sign.has()) {
      this.sign = paramExternalInfo.str_external_sign.get();
    }
    if (paramExternalInfo.uint32_external_gender.has()) {
      this.gender = paramExternalInfo.uint32_external_gender.get();
    }
    if (paramExternalInfo.uint64_external_country.has()) {
      this.country = paramExternalInfo.uint64_external_country.get();
    }
    if (paramExternalInfo.uint64_external_province.has()) {
      this.province = paramExternalInfo.uint64_external_province.get();
    }
    if (paramExternalInfo.uint64_external_city.has()) {
      this.city = paramExternalInfo.uint64_external_city.get();
    }
    if (paramExternalInfo.uint64_external_district.has()) {
      this.district = paramExternalInfo.uint64_external_district.get();
    }
    if (paramExternalInfo.str_external_job.has()) {
      this.job = paramExternalInfo.str_external_job.get();
    }
    if (paramExternalInfo.str_external_tel.has()) {
      this.tel = paramExternalInfo.str_external_tel.get();
    }
    if (paramExternalInfo.str_external_mobile.has()) {
      this.mobile = paramExternalInfo.str_external_mobile.get();
    }
    if (paramExternalInfo.uint64_external_oidbflag.has()) {
      this.externalOidbflag = paramExternalInfo.uint64_external_oidbflag.get();
    }
    if (paramExternalInfo.str_external_mail.has()) {
      this.mail = paramExternalInfo.str_external_mail.get();
    }
    if (paramExternalInfo.uint64_master_uin.has()) {
      this.masterUin = String.valueOf(paramExternalInfo.uint64_master_uin.get());
    }
    if (paramExternalInfo.uint32_verity.has()) {
      this.verity = paramExternalInfo.uint32_verity.get();
    }
    if (paramExternalInfo.uint32_entcallshow.has()) {
      this.isShowCall = paramExternalInfo.uint32_entcallshow.get();
    }
    if (paramExternalInfo.uint32_videoshow.has()) {
      this.isShowVideoCall = paramExternalInfo.uint32_videoshow.get();
    }
    if (paramExternalInfo.str_thirdpart_verity_icon.has()) {
      this.verify_url = paramExternalInfo.str_thirdpart_verity_icon.get();
    }
    initList();
    if (QLog.isColorLevel())
    {
      paramExternalInfo = new StringBuilder();
      paramExternalInfo.append("Load from server: ");
      paramExternalInfo.append(toString());
      QLog.d("QidianExternalInfo", 2, paramExternalInfo.toString());
    }
  }
  
  public List<CompanyShowCaseInfo> getCompanyShowCaseInfos()
  {
    return this.mCompanyShowCaseInfos;
  }
  
  public List<GroupItem> getGroupItemsCorp()
  {
    return this.mGroupItemsCorp;
  }
  
  public List<GroupItem> getGroupItemsUser()
  {
    return this.mGroupItems;
  }
  
  public List<PublicAccountItem> getPublicAccountItemsCorp()
  {
    return this.mPubAccItemsCorp;
  }
  
  public List<PublicAccountItem> getPublicAccountItemsUser()
  {
    return this.mPubAccItems;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.infoByte);
  }
  
  public void initList()
  {
    try
    {
      if (this.infoByte != null)
      {
        Object localObject1 = new mobileqq_qidian.ExternalInfo();
        ((mobileqq_qidian.ExternalInfo)localObject1).mergeFrom(this.infoByte);
        Object localObject2;
        Object localObject3;
        if (((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_pubacc_item.has())
        {
          this.mPubAccItems = new ArrayList();
          localObject2 = ((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_pubacc_item.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (mobileqq_qidian.PubAccItem)((Iterator)localObject2).next();
            this.mPubAccItems.add(new PublicAccountItem((mobileqq_qidian.PubAccItem)localObject3));
          }
        }
        if (((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_pubacc_item_corp.has())
        {
          this.mPubAccItemsCorp = new ArrayList();
          localObject2 = ((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_pubacc_item_corp.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (mobileqq_qidian.PubAccItem)((Iterator)localObject2).next();
            this.mPubAccItemsCorp.add(new PublicAccountItem((mobileqq_qidian.PubAccItem)localObject3));
          }
        }
        if (((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_group_item.has())
        {
          this.mGroupItems = new ArrayList();
          localObject2 = ((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_group_item.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (mobileqq_qidian.GroupItem)((Iterator)localObject2).next();
            this.mGroupItems.add(new GroupItem((mobileqq_qidian.GroupItem)localObject3));
          }
        }
        if (((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_group_item_corp.has())
        {
          this.mGroupItemsCorp = new ArrayList();
          localObject2 = ((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_group_item_corp.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (mobileqq_qidian.GroupItem)((Iterator)localObject2).next();
            this.mGroupItemsCorp.add(new GroupItem((mobileqq_qidian.GroupItem)localObject3));
          }
        }
        if (((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_company_show_case_info.has())
        {
          this.mCompanyShowCaseInfos = new ArrayList();
          localObject1 = ((mobileqq_qidian.ExternalInfo)localObject1).rpt_msg_company_show_case_info.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (mobileqq_qidian.CompanyShowCaseInfo)((Iterator)localObject1).next();
            this.mCompanyShowCaseInfos.add(new CompanyShowCaseInfo((mobileqq_qidian.CompanyShowCaseInfo)localObject2));
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean isExternalMobileVerified()
  {
    return (this.externalOidbflag & 0x8) == 8L;
  }
  
  public void setExternalMobileVerified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.externalOidbflag |= 0x8;
      return;
    }
    this.externalOidbflag &= 0xFFFFFFF7;
  }
  
  public mobileqq_qidian.ExternalInfo to()
  {
    mobileqq_qidian.ExternalInfo localExternalInfo = new mobileqq_qidian.ExternalInfo();
    localExternalInfo.uint64_uin.set(Long.parseLong(this.uin));
    localExternalInfo.str_external_nick.set(this.nickname);
    localExternalInfo.str_external_icon.set(this.icon);
    localExternalInfo.str_external_sign.set(this.sign);
    localExternalInfo.uint32_external_gender.set(this.gender);
    localExternalInfo.uint64_external_country.set(this.country);
    localExternalInfo.uint64_external_province.set(this.province);
    localExternalInfo.uint64_external_city.set(this.city);
    localExternalInfo.uint64_external_district.set(this.district);
    localExternalInfo.str_external_job.set(this.job);
    localExternalInfo.str_external_tel.set(this.tel);
    localExternalInfo.str_external_mobile.set(this.mobile);
    localExternalInfo.uint64_external_oidbflag.set(this.externalOidbflag);
    localExternalInfo.str_external_mail.set(this.mail);
    Object localObject1 = this.mPubAccItems;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PublicAccountItem)((Iterator)localObject1).next();
        localExternalInfo.rpt_msg_pubacc_item.add(((PublicAccountItem)localObject2).a());
      }
    }
    localObject1 = this.mPubAccItemsCorp;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PublicAccountItem)((Iterator)localObject1).next();
        if (localObject2 != null) {
          localExternalInfo.rpt_msg_pubacc_item_corp.add(((PublicAccountItem)localObject2).a());
        }
      }
    }
    localObject1 = this.mGroupItems;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupItem)((Iterator)localObject1).next();
        localExternalInfo.rpt_msg_group_item.add(((GroupItem)localObject2).a());
      }
    }
    localObject1 = this.mGroupItemsCorp;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupItem)((Iterator)localObject1).next();
        if (localObject2 != null) {
          localExternalInfo.rpt_msg_group_item_corp.add(((GroupItem)localObject2).a());
        }
      }
    }
    localObject1 = this.mCompanyShowCaseInfos;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CompanyShowCaseInfo)((Iterator)localObject1).next();
        localExternalInfo.rpt_msg_company_show_case_info.add(((CompanyShowCaseInfo)localObject2).a());
      }
    }
    localExternalInfo.uint64_master_uin.set(Long.parseLong(this.masterUin));
    localExternalInfo.uint32_verity.set(this.verity);
    localExternalInfo.uint32_entcallshow.set(this.isShowCall);
    localExternalInfo.uint32_videoshow.set(this.isShowVideoCall);
    return localExternalInfo;
  }
  
  public void update(QidianExternalInfo paramQidianExternalInfo)
  {
    if ((paramQidianExternalInfo != null) && (this.uin.equals(paramQidianExternalInfo.uin)))
    {
      if (!TextUtils.isEmpty(paramQidianExternalInfo.masterUin)) {
        this.masterUin = paramQidianExternalInfo.masterUin;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.nickname)) {
        this.nickname = paramQidianExternalInfo.nickname;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.icon)) {
        this.icon = paramQidianExternalInfo.icon;
      }
      this.sign = paramQidianExternalInfo.sign;
      if (!TextUtils.isEmpty(paramQidianExternalInfo.job)) {
        this.job = paramQidianExternalInfo.job;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.tel)) {
        this.tel = paramQidianExternalInfo.tel;
      }
      if (!TextUtils.isEmpty(paramQidianExternalInfo.mobile)) {
        this.mobile = paramQidianExternalInfo.mobile;
      }
      this.externalOidbflag = paramQidianExternalInfo.externalOidbflag;
      if (!TextUtils.isEmpty(paramQidianExternalInfo.mail)) {
        this.mail = paramQidianExternalInfo.mail;
      }
      long l = paramQidianExternalInfo.country;
      if (l > 0L) {
        this.country = l;
      }
      l = paramQidianExternalInfo.province;
      if (l > 0L) {
        this.province = l;
      }
      l = paramQidianExternalInfo.city;
      if (l > 0L) {
        this.city = l;
      }
      l = paramQidianExternalInfo.district;
      if (l > 0L) {
        this.district = l;
      }
      this.isShowCall = paramQidianExternalInfo.isShowCall;
      this.isShowVideoCall = paramQidianExternalInfo.isShowVideoCall;
      List localList = paramQidianExternalInfo.mPubAccItems;
      if (localList != null) {
        this.mPubAccItems = localList;
      }
      localList = paramQidianExternalInfo.mPubAccItemsCorp;
      if (localList != null) {
        this.mPubAccItemsCorp = localList;
      }
      localList = paramQidianExternalInfo.mGroupItems;
      if (localList != null) {
        this.mGroupItems = localList;
      }
      localList = paramQidianExternalInfo.mGroupItemsCorp;
      if (localList != null) {
        this.mGroupItemsCorp = localList;
      }
      this.mCompanyShowCaseInfos = paramQidianExternalInfo.mCompanyShowCaseInfos;
      this.verity = paramQidianExternalInfo.verity;
      if (!TextUtils.isEmpty(paramQidianExternalInfo.verify_url)) {
        this.verify_url = paramQidianExternalInfo.verify_url;
      }
      this.infoByte = paramQidianExternalInfo.to().toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.data.QidianExternalInfo
 * JD-Core Version:    0.7.0.1
 */