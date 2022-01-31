package com.tencent.mobileqq.data;

import auko;
import aumc;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DoubtInfo;

public class SysSuspiciousMsg
  extends auko
  implements Serializable
{
  public int age;
  public long commFrdNum;
  public long groupCode;
  public String msg;
  public String nameMore;
  public String nick;
  public String reason;
  public byte[] session_key;
  public int sex;
  public String source;
  public long time;
  @aumc
  public long uin;
  
  public static SysSuspiciousMsg covertFrom(oidb_cmd0xd69.DoubtInfo paramDoubtInfo)
  {
    Object localObject2 = null;
    SysSuspiciousMsg localSysSuspiciousMsg = new SysSuspiciousMsg();
    int i;
    if (paramDoubtInfo != null)
    {
      localSysSuspiciousMsg.uin = paramDoubtInfo.uint64_uin.get();
      if (!paramDoubtInfo.bytes_nick.has()) {
        break label280;
      }
      localObject1 = paramDoubtInfo.bytes_nick.get().toStringUtf8();
      localSysSuspiciousMsg.nick = ((String)localObject1);
      if (!paramDoubtInfo.uint32_age.has()) {
        break label285;
      }
      i = paramDoubtInfo.uint32_age.get();
      label72:
      localSysSuspiciousMsg.age = i;
      if (!paramDoubtInfo.uint32_sex.has()) {
        break label290;
      }
      i = paramDoubtInfo.uint32_sex.get();
      label96:
      localSysSuspiciousMsg.sex = i;
      if (!paramDoubtInfo.bytes_msg.has()) {
        break label295;
      }
      localObject1 = paramDoubtInfo.bytes_msg.get().toStringUtf8();
      label123:
      localSysSuspiciousMsg.msg = ((String)localObject1);
      if (!paramDoubtInfo.bytes_source.has()) {
        break label300;
      }
      localObject1 = paramDoubtInfo.bytes_source.get().toStringUtf8();
      label150:
      localSysSuspiciousMsg.source = ((String)localObject1);
      if (!paramDoubtInfo.bytes_reason.has()) {
        break label305;
      }
      localObject1 = paramDoubtInfo.bytes_reason.get().toStringUtf8();
      label177:
      localSysSuspiciousMsg.reason = ((String)localObject1);
      localSysSuspiciousMsg.time = paramDoubtInfo.uint32_time.get();
      localSysSuspiciousMsg.groupCode = paramDoubtInfo.uint64_group.get();
      localSysSuspiciousMsg.commFrdNum = paramDoubtInfo.uint32_comm_frd_num.get();
      if (!paramDoubtInfo.bytes_name_more.has()) {
        break label310;
      }
    }
    label280:
    label285:
    label290:
    label295:
    label300:
    label305:
    label310:
    for (Object localObject1 = paramDoubtInfo.bytes_name_more.get().toStringUtf8();; localObject1 = null)
    {
      localSysSuspiciousMsg.nameMore = ((String)localObject1);
      localObject1 = localObject2;
      if (paramDoubtInfo.bytes_session_key.has()) {
        localObject1 = paramDoubtInfo.bytes_session_key.get().toByteArray();
      }
      localSysSuspiciousMsg.session_key = ((byte[])localObject1);
      return localSysSuspiciousMsg;
      localObject1 = null;
      break;
      i = 0;
      break label72;
      i = -1;
      break label96;
      localObject1 = null;
      break label123;
      localObject1 = null;
      break label150;
      localObject1 = null;
      break label177;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SysSuspiciousMsg{uin=").append(this.uin).append(", nick='").append(this.nick).append(", age='").append(this.age).append(", sex='").append(this.sex).append(", msg='").append(this.msg).append(", source='").append(this.source).append(", reason='").append(this.reason).append(", time='").append(this.time).append(", groupCode='").append(this.groupCode).append(", commFrdNum='").append(this.commFrdNum).append(", nameMore='").append(this.nameMore).append(", session_key='");
    if (this.session_key == null) {}
    for (boolean bool = true;; bool = false) {
      return bool + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.SysSuspiciousMsg
 * JD-Core Version:    0.7.0.1
 */