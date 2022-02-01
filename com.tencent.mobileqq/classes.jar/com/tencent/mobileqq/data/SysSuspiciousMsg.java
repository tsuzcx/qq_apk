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
    int j = 0;
    Object localObject2 = null;
    SysSuspiciousMsg localSysSuspiciousMsg = new SysSuspiciousMsg();
    int i;
    if (paramDoubtInfo != null)
    {
      localSysSuspiciousMsg.uin = paramDoubtInfo.uint64_uin.get();
      if (!paramDoubtInfo.bytes_nick.has()) {
        break label382;
      }
      localObject1 = paramDoubtInfo.bytes_nick.get().toStringUtf8();
      localSysSuspiciousMsg.nick = ((String)localObject1);
      if (!paramDoubtInfo.uint32_age.has()) {
        break label387;
      }
      i = paramDoubtInfo.uint32_age.get();
      label75:
      localSysSuspiciousMsg.age = i;
      if (!paramDoubtInfo.uint32_sex.has()) {
        break label392;
      }
      i = paramDoubtInfo.uint32_sex.get();
      label99:
      localSysSuspiciousMsg.sex = i;
      if (!paramDoubtInfo.bytes_msg.has()) {
        break label397;
      }
      localObject1 = paramDoubtInfo.bytes_msg.get().toStringUtf8();
      label126:
      localSysSuspiciousMsg.msg = ((String)localObject1);
      if (!paramDoubtInfo.bytes_source.has()) {
        break label402;
      }
      localObject1 = paramDoubtInfo.bytes_source.get().toStringUtf8();
      label153:
      localSysSuspiciousMsg.source = ((String)localObject1);
      if (!paramDoubtInfo.bytes_reason.has()) {
        break label407;
      }
      localObject1 = paramDoubtInfo.bytes_reason.get().toStringUtf8();
      label180:
      localSysSuspiciousMsg.reason = ((String)localObject1);
      localSysSuspiciousMsg.time = paramDoubtInfo.uint32_time.get();
      localSysSuspiciousMsg.groupCode = paramDoubtInfo.uint64_group.get();
      localSysSuspiciousMsg.commFrdNum = paramDoubtInfo.uint32_comm_frd_num.get();
      if (!paramDoubtInfo.bytes_name_more.has()) {
        break label412;
      }
      localObject1 = paramDoubtInfo.bytes_name_more.get().toStringUtf8();
      label245:
      localSysSuspiciousMsg.nameMore = ((String)localObject1);
      if (!paramDoubtInfo.bytes_session_key.has()) {
        break label417;
      }
      localObject1 = paramDoubtInfo.bytes_session_key.get().toByteArray();
      label272:
      localSysSuspiciousMsg.session_key = ((byte[])localObject1);
      if (!paramDoubtInfo.str_entity_category.has()) {
        break label422;
      }
      localObject1 = paramDoubtInfo.str_entity_category.get();
      label296:
      localSysSuspiciousMsg.entity_category = ((String)localObject1);
      if (!paramDoubtInfo.str_entity_name.has()) {
        break label427;
      }
    }
    label387:
    label392:
    label397:
    label402:
    label407:
    label412:
    label417:
    label422:
    label427:
    for (Object localObject1 = paramDoubtInfo.str_entity_name.get();; localObject1 = null)
    {
      localSysSuspiciousMsg.entity_name = ((String)localObject1);
      localObject1 = localObject2;
      if (paramDoubtInfo.str_entity_url.has()) {
        localObject1 = paramDoubtInfo.str_entity_url.get();
      }
      localSysSuspiciousMsg.entity_url = ((String)localObject1);
      i = j;
      if (paramDoubtInfo.uint32_source_flag.has()) {
        i = paramDoubtInfo.uint32_source_flag.get();
      }
      localSysSuspiciousMsg.sourceflag = i;
      return localSysSuspiciousMsg;
      label382:
      localObject1 = null;
      break;
      i = 0;
      break label75;
      i = -1;
      break label99;
      localObject1 = null;
      break label126;
      localObject1 = null;
      break label153;
      localObject1 = null;
      break label180;
      localObject1 = null;
      break label245;
      localObject1 = null;
      break label272;
      localObject1 = null;
      break label296;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SysSuspiciousMsg{uin=").append(this.uin).append(", nick='").append(this.nick).append(", age='").append(this.age).append(", sex='").append(this.sex).append(", msg='").append(this.msg).append(", source='").append(this.source).append(", reason='").append(this.reason).append(", time='").append(this.time).append(", groupCode='").append(this.groupCode).append(", commFrdNum='").append(this.commFrdNum).append(", nameMore='").append(this.nameMore).append(", session_key='");
    if (this.session_key == null) {}
    for (boolean bool = true;; bool = false) {
      return bool + ", entity_category='" + this.entity_category + ", entity_name='" + this.entity_name + ", entity_url='" + this.entity_url + ", sourceflag='" + this.sourceflag + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.SysSuspiciousMsg
 * JD-Core Version:    0.7.0.1
 */