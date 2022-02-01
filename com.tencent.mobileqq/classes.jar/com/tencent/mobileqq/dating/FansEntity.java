package com.tencent.mobileqq.dating;

import appoint.define.appoint_define.CommonLabel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.UdcUinData;

public class FansEntity
  extends Entity
{
  public int age;
  public int career;
  public boolean charmIcon;
  public int charmLevel;
  public String common;
  public int commonId;
  public int constellation;
  public int gender;
  public int single;
  @unique
  public long uin;
  public int vip;
  
  public void init(cmd0x9e4.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint64_uin.has()) {
      this.uin = paramUdcUinData.uint64_uin.get();
    }
    if (paramUdcUinData.uint32_gender.has()) {
      this.gender = paramUdcUinData.uint32_gender.get();
    }
    if (paramUdcUinData.uint32_age.has()) {
      this.age = paramUdcUinData.uint32_age.get();
    }
    if (paramUdcUinData.uint32_love_status.has()) {
      this.single = paramUdcUinData.uint32_love_status.get();
    }
    if (paramUdcUinData.uint32_profession.has()) {
      this.career = paramUdcUinData.uint32_profession.get();
    }
    if (paramUdcUinData.uint32_constellation.has()) {
      this.constellation = paramUdcUinData.uint32_constellation.get();
    }
    if (paramUdcUinData.uint32_vip_flag.has()) {
      this.vip = paramUdcUinData.uint32_vip_flag.get();
    }
    boolean bool = paramUdcUinData.uint32_charm_shown.has();
    int i = 0;
    if (bool)
    {
      int j = paramUdcUinData.uint32_charm_shown.get();
      bool = true;
      if (j != 1) {
        bool = false;
      }
      this.charmIcon = bool;
    }
    if (paramUdcUinData.uint32_charm_level.has()) {
      this.charmLevel = paramUdcUinData.uint32_charm_level.get();
    }
    if (paramUdcUinData.msg_common_label.has())
    {
      Object localObject = (appoint_define.CommonLabel)paramUdcUinData.msg_common_label.get();
      if (((appoint_define.CommonLabel)localObject).uint32_lable_id.has()) {
        i = ((appoint_define.CommonLabel)localObject).uint32_lable_id.get();
      }
      this.commonId = i;
      bool = ((appoint_define.CommonLabel)localObject).bytes_lable_msg_pre.has();
      String str = "";
      if (bool) {
        paramUdcUinData = new String(((appoint_define.CommonLabel)localObject).bytes_lable_msg_pre.get().toByteArray());
      } else {
        paramUdcUinData = "";
      }
      if (((appoint_define.CommonLabel)localObject).bytes_lable_msg_pre.has()) {
        str = new String(((appoint_define.CommonLabel)localObject).bytes_lable_msg_last.get().toByteArray());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramUdcUinData);
      ((StringBuilder)localObject).append(str);
      this.common = ((StringBuilder)localObject).toString();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("uin:");
    localStringBuilder2.append(this.uin);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",gender:");
    localStringBuilder2.append(this.gender);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",age:");
    localStringBuilder2.append(this.age);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",single:");
    localStringBuilder2.append(this.single);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",career:");
    localStringBuilder2.append(this.career);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",constellation:");
    localStringBuilder2.append(this.constellation);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",charmIcon:");
    localStringBuilder2.append(this.charmIcon);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",vip:");
    localStringBuilder2.append(this.vip);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",charmLevel:");
    localStringBuilder2.append(this.charmLevel);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",commonId:");
    localStringBuilder2.append(this.commonId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",common:");
    localStringBuilder2.append(this.common);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.FansEntity
 * JD-Core Version:    0.7.0.1
 */