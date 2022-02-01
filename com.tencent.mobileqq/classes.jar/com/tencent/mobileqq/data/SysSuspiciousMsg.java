package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DoubtInfo;

public class SysSuspiciousMsg
  extends Entity
  implements Serializable
{
  public int age;
  public long commFrdNum;
  public String entity_category;
  public String entity_name;
  public String entity_url;
  public long groupCode;
  public String msg;
  public String nameMore;
  public String nick;
  public String reason;
  public byte[] session_key;
  public int sex;
  public String source;
  public int sourceflag;
  public long time;
  @unique
  public long uin;
  
  public static SysSuspiciousMsg covertFrom(oidb_cmd0xd69.DoubtInfo paramDoubtInfo)
  {
    SysSuspiciousMsg localSysSuspiciousMsg = new SysSuspiciousMsg();
    if (paramDoubtInfo != null)
    {
      localSysSuspiciousMsg.uin = paramDoubtInfo.uint64_uin.get();
      boolean bool = paramDoubtInfo.bytes_nick.has();
      Object localObject2 = null;
      if (bool) {
        localObject1 = paramDoubtInfo.bytes_nick.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.nick = ((String)localObject1);
      bool = paramDoubtInfo.uint32_age.has();
      int j = 0;
      if (bool) {
        i = paramDoubtInfo.uint32_age.get();
      } else {
        i = 0;
      }
      localSysSuspiciousMsg.age = i;
      if (paramDoubtInfo.uint32_sex.has()) {
        i = paramDoubtInfo.uint32_sex.get();
      } else {
        i = -1;
      }
      localSysSuspiciousMsg.sex = i;
      if (paramDoubtInfo.bytes_msg.has()) {
        localObject1 = paramDoubtInfo.bytes_msg.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.msg = ((String)localObject1);
      if (paramDoubtInfo.bytes_source.has()) {
        localObject1 = paramDoubtInfo.bytes_source.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.source = ((String)localObject1);
      if (paramDoubtInfo.bytes_reason.has()) {
        localObject1 = paramDoubtInfo.bytes_reason.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.reason = ((String)localObject1);
      localSysSuspiciousMsg.time = paramDoubtInfo.uint32_time.get();
      localSysSuspiciousMsg.groupCode = paramDoubtInfo.uint64_group.get();
      localSysSuspiciousMsg.commFrdNum = paramDoubtInfo.uint32_comm_frd_num.get();
      if (paramDoubtInfo.bytes_name_more.has()) {
        localObject1 = paramDoubtInfo.bytes_name_more.get().toStringUtf8();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.nameMore = ((String)localObject1);
      if (paramDoubtInfo.bytes_session_key.has()) {
        localObject1 = paramDoubtInfo.bytes_session_key.get().toByteArray();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.session_key = ((byte[])localObject1);
      if (paramDoubtInfo.str_entity_category.has()) {
        localObject1 = paramDoubtInfo.str_entity_category.get();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.entity_category = ((String)localObject1);
      if (paramDoubtInfo.str_entity_name.has()) {
        localObject1 = paramDoubtInfo.str_entity_name.get();
      } else {
        localObject1 = null;
      }
      localSysSuspiciousMsg.entity_name = ((String)localObject1);
      Object localObject1 = localObject2;
      if (paramDoubtInfo.str_entity_url.has()) {
        localObject1 = paramDoubtInfo.str_entity_url.get();
      }
      localSysSuspiciousMsg.entity_url = ((String)localObject1);
      int i = j;
      if (paramDoubtInfo.uint32_source_flag.has()) {
        i = paramDoubtInfo.uint32_source_flag.get();
      }
      localSysSuspiciousMsg.sourceflag = i;
    }
    return localSysSuspiciousMsg;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SysSuspiciousMsg{uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", nick='");
    localStringBuilder.append(this.nick);
    localStringBuilder.append(", age='");
    localStringBuilder.append(this.age);
    localStringBuilder.append(", sex='");
    localStringBuilder.append(this.sex);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.msg);
    localStringBuilder.append(", source='");
    localStringBuilder.append(this.source);
    localStringBuilder.append(", reason='");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(", time='");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", groupCode='");
    localStringBuilder.append(this.groupCode);
    localStringBuilder.append(", commFrdNum='");
    localStringBuilder.append(this.commFrdNum);
    localStringBuilder.append(", nameMore='");
    localStringBuilder.append(this.nameMore);
    localStringBuilder.append(", session_key='");
    boolean bool;
    if (this.session_key == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append(", entity_category='");
    localStringBuilder.append(this.entity_category);
    localStringBuilder.append(", entity_name='");
    localStringBuilder.append(this.entity_name);
    localStringBuilder.append(", entity_url='");
    localStringBuilder.append(this.entity_url);
    localStringBuilder.append(", sourceflag='");
    localStringBuilder.append(this.sourceflag);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.SysSuspiciousMsg
 * JD-Core Version:    0.7.0.1
 */