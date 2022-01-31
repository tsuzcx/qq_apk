package com.tencent.mobileqq.extendfriend.bean;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.GroupInfo;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.Label;

public class GroupInfo
  implements Serializable
{
  public long groupCode;
  public String groupDesc;
  public String groupFace;
  public String groupName;
  public List<GroupInfo.Label> labels = new ArrayList();
  public long lastMsgTime;
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof GroupInfo)) && (((GroupInfo)paramObject).groupCode == this.groupCode);
  }
  
  public void parseFromPb(oidb_0xb4a.GroupInfo paramGroupInfo)
  {
    long l2 = 0L;
    if (paramGroupInfo == null) {
      return;
    }
    long l1;
    if (paramGroupInfo.group_code.has())
    {
      l1 = paramGroupInfo.group_code.get();
      label26:
      this.groupCode = l1;
      if (!paramGroupInfo.group_name.has()) {
        break label247;
      }
      localObject = paramGroupInfo.group_name.get().toString();
      label53:
      this.groupName = ((String)localObject);
      if (!paramGroupInfo.group_face.has()) {
        break label254;
      }
      localObject = paramGroupInfo.group_face.get().toString();
      label81:
      this.groupFace = ((String)localObject);
      if (!paramGroupInfo.group_desc.has()) {
        break label261;
      }
    }
    label261:
    for (Object localObject = paramGroupInfo.group_desc.get().toString();; localObject = "")
    {
      this.groupDesc = ((String)localObject);
      l1 = l2;
      if (paramGroupInfo.last_msg_time.has()) {
        l1 = paramGroupInfo.last_msg_time.get();
      }
      this.lastMsgTime = l1;
      if (this.labels == null) {
        this.labels = new ArrayList(paramGroupInfo.group_label_list.size());
      }
      if (!paramGroupInfo.group_label_list.has()) {
        break;
      }
      paramGroupInfo = paramGroupInfo.group_label_list.get().iterator();
      while (paramGroupInfo.hasNext())
      {
        localObject = (oidb_0xb4a.Label)paramGroupInfo.next();
        GroupInfo.Label localLabel = new GroupInfo.Label(this);
        localLabel.parseFromPb((oidb_0xb4a.Label)localObject);
        this.labels.add(localLabel);
      }
      break;
      l1 = 0L;
      break label26;
      label247:
      localObject = "";
      break label53;
      label254:
      localObject = "";
      break label81;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("groupCode").append("=").append(this.groupCode);
    localStringBuilder.append(" ").append("groupName").append("=").append(this.groupName);
    localStringBuilder.append(" ").append("groupFace").append("=").append(this.groupFace);
    localStringBuilder.append(" ").append("groupDesc").append("=").append(this.groupDesc);
    localStringBuilder.append(" ").append("lastMsgTime").append("=").append(this.lastMsgTime);
    localStringBuilder.append(" ").append("labels").append("=").append("[").append(this.labels.toString()).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.GroupInfo
 * JD-Core Version:    0.7.0.1
 */