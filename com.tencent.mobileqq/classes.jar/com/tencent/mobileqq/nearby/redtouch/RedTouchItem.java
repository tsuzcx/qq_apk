package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x6cd.MessageRec;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6cd.RepointExtraInfo;

public class RedTouchItem
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public byte[] bytes;
  public String configVersion;
  public int count;
  public long curSeq;
  public List<RedTouchItemExtMsg> extMsgs = new ArrayList();
  public long fromId;
  public String icon;
  public boolean isClosed = false;
  public int lastRecvTime;
  public int passThroughLevel = 0;
  public long receiveTime = 0L;
  public int redtouchType;
  public int taskId;
  public String tips;
  public boolean unReadFlag = true;
  public int validTimeRemained = 0;
  
  public static RedTouchItem getRedTouchItem(cmd0x6cd.RedpointInfo paramRedpointInfo)
  {
    if ((paramRedpointInfo != null) && (paramRedpointInfo.uint32_taskid.has()))
    {
      if (!paramRedpointInfo.uint64_cur_seq.has()) {
        return null;
      }
      RedTouchItem localRedTouchItem = new RedTouchItem();
      int i;
      if (paramRedpointInfo.uint32_taskid.has()) {
        i = paramRedpointInfo.uint32_taskid.get();
      } else {
        i = 0;
      }
      localRedTouchItem.taskId = i;
      long l;
      if (paramRedpointInfo.uint64_cur_seq.has()) {
        l = paramRedpointInfo.uint64_cur_seq.get();
      } else {
        l = 0L;
      }
      localRedTouchItem.curSeq = l;
      if (paramRedpointInfo.enum_redpoint_type.has()) {
        i = paramRedpointInfo.enum_redpoint_type.get();
      } else {
        i = 0;
      }
      localRedTouchItem.redtouchType = i;
      if (paramRedpointInfo.uint64_from_id.has()) {
        l = paramRedpointInfo.uint64_from_id.get();
      } else {
        l = 0L;
      }
      localRedTouchItem.fromId = l;
      if (paramRedpointInfo.uint32_last_recv_time.has()) {
        i = paramRedpointInfo.uint32_last_recv_time.get();
      } else {
        i = 0;
      }
      localRedTouchItem.lastRecvTime = i;
      if (paramRedpointInfo.int32_remained_time.has()) {
        i = paramRedpointInfo.int32_remained_time.get();
      } else {
        i = 0;
      }
      localRedTouchItem.validTimeRemained = i;
      localRedTouchItem.receiveTime = System.currentTimeMillis();
      localRedTouchItem.configVersion = paramRedpointInfo.str_config_version.get();
      Object localObject1;
      if (paramRedpointInfo.msg_redpoint_extra_info.has()) {
        localObject1 = (cmd0x6cd.RepointExtraInfo)paramRedpointInfo.msg_redpoint_extra_info.get();
      } else {
        localObject1 = null;
      }
      Object localObject2;
      if (localObject1 != null)
      {
        if (((cmd0x6cd.RepointExtraInfo)localObject1).uint32_count.has()) {
          i = ((cmd0x6cd.RepointExtraInfo)localObject1).uint32_count.get();
        } else {
          i = 0;
        }
        localRedTouchItem.count = i;
        boolean bool = ((cmd0x6cd.RepointExtraInfo)localObject1).str_icon_url.has();
        String str = "";
        if (bool) {
          localObject2 = ((cmd0x6cd.RepointExtraInfo)localObject1).str_icon_url.get();
        } else {
          localObject2 = "";
        }
        localRedTouchItem.icon = ((String)localObject2);
        localObject2 = str;
        if (((cmd0x6cd.RepointExtraInfo)localObject1).str_tips.has()) {
          localObject2 = ((cmd0x6cd.RepointExtraInfo)localObject1).str_tips.get();
        }
        localRedTouchItem.tips = ((String)localObject2);
        if (((cmd0x6cd.RepointExtraInfo)localObject1).bytes_data.has()) {
          localObject1 = ((cmd0x6cd.RepointExtraInfo)localObject1).bytes_data.get().toByteArray();
        } else {
          localObject1 = null;
        }
        localRedTouchItem.bytes = ((byte[])localObject1);
      }
      if ((paramRedpointInfo.rpt_msg_unread_msg.has()) && (paramRedpointInfo.rpt_msg_unread_msg.get().size() > 0))
      {
        localObject1 = paramRedpointInfo.rpt_msg_unread_msg.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramRedpointInfo = (cmd0x6cd.MessageRec)((Iterator)localObject1).next();
          localObject2 = new RedTouchItemExtMsg();
          if (paramRedpointInfo.uint64_seq.has()) {
            l = paramRedpointInfo.uint64_seq.get();
          } else {
            l = 0L;
          }
          ((RedTouchItemExtMsg)localObject2).seq = l;
          if (paramRedpointInfo.uint32_time.has()) {
            i = paramRedpointInfo.uint32_time.get();
          } else {
            i = 0;
          }
          ((RedTouchItemExtMsg)localObject2).time = i;
          if (paramRedpointInfo.bytes_content.has()) {
            paramRedpointInfo = paramRedpointInfo.bytes_content.get().toByteArray();
          } else {
            paramRedpointInfo = null;
          }
          ((RedTouchItemExtMsg)localObject2).bytesData = paramRedpointInfo;
          localRedTouchItem.extMsgs.add(localObject2);
        }
      }
      return localRedTouchItem;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RedTouchItem{hash=");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append(", curSeq=");
    localStringBuilder.append(this.curSeq);
    localStringBuilder.append(", redtouchType=");
    localStringBuilder.append(this.redtouchType);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.count);
    localStringBuilder.append(", icon='");
    localStringBuilder.append(this.icon);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tips='");
    localStringBuilder.append(this.tips);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromId=");
    localStringBuilder.append(this.fromId);
    localStringBuilder.append(", lastRecvTime=");
    localStringBuilder.append(this.lastRecvTime);
    localStringBuilder.append(", receiveTime=");
    localStringBuilder.append(this.receiveTime);
    localStringBuilder.append(", validTimeRemained=");
    localStringBuilder.append(this.validTimeRemained);
    localStringBuilder.append(", unReadFlag=");
    localStringBuilder.append(this.unReadFlag);
    localStringBuilder.append(", passThroughLevel=");
    localStringBuilder.append(this.passThroughLevel);
    localStringBuilder.append(", configVersion='");
    localStringBuilder.append(this.configVersion);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedTouchItem
 * JD-Core Version:    0.7.0.1
 */