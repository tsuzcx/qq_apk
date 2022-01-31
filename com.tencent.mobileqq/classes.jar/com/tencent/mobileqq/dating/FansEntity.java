package com.tencent.mobileqq.dating;

import appoint.define.appoint_define.CommonLabel;
import atmo;
import atoc;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.UdcUinData;

public class FansEntity
  extends atmo
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
  @atoc
  public long uin;
  public int vip;
  
  public void init(cmd0x9e4.UdcUinData paramUdcUinData)
  {
    boolean bool = true;
    int i = 0;
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
    if (paramUdcUinData.uint32_charm_shown.has())
    {
      if (paramUdcUinData.uint32_charm_shown.get() == 1) {
        this.charmIcon = bool;
      }
    }
    else
    {
      if (paramUdcUinData.uint32_charm_level.has()) {
        this.charmLevel = paramUdcUinData.uint32_charm_level.get();
      }
      if (paramUdcUinData.msg_common_label.has())
      {
        localObject = (appoint_define.CommonLabel)paramUdcUinData.msg_common_label.get();
        if (((appoint_define.CommonLabel)localObject).uint32_lable_id.has()) {
          i = ((appoint_define.CommonLabel)localObject).uint32_lable_id.get();
        }
        this.commonId = i;
        if (!((appoint_define.CommonLabel)localObject).bytes_lable_msg_pre.has()) {
          break label335;
        }
        paramUdcUinData = new String(((appoint_define.CommonLabel)localObject).bytes_lable_msg_pre.get().toByteArray());
        label275:
        if (!((appoint_define.CommonLabel)localObject).bytes_lable_msg_pre.has()) {
          break label341;
        }
      }
    }
    label335:
    label341:
    for (Object localObject = new String(((appoint_define.CommonLabel)localObject).bytes_lable_msg_last.get().toByteArray());; localObject = "")
    {
      this.common = (paramUdcUinData + (String)localObject);
      return;
      bool = false;
      break;
      paramUdcUinData = "";
      break label275;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("uin:" + this.uin);
    localStringBuilder.append(",gender:" + this.gender);
    localStringBuilder.append(",age:" + this.age);
    localStringBuilder.append(",single:" + this.single);
    localStringBuilder.append(",career:" + this.career);
    localStringBuilder.append(",constellation:" + this.constellation);
    localStringBuilder.append(",charmIcon:" + this.charmIcon);
    localStringBuilder.append(",vip:" + this.vip);
    localStringBuilder.append(",charmLevel:" + this.charmLevel);
    localStringBuilder.append(",commonId:" + this.commonId);
    localStringBuilder.append(",common:" + this.common);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.FansEntity
 * JD-Core Version:    0.7.0.1
 */