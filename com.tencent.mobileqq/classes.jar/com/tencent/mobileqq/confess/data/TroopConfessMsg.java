package com.tencent.mobileqq.confess.data;

import ajxn;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessMsg;

public class TroopConfessMsg
  implements Externalizable
{
  public long confessTime;
  public byte confessorSex;
  public long confessorUin;
  public List<TroopConfessMsgItem> items = new ArrayList();
  public byte sysMsgFlag;
  public int totalCount;
  
  public void convertFrom(hummer_commelem.MsgElemInfo_servtype21 paramMsgElemInfo_servtype21)
  {
    long l2 = 0L;
    int j = 0;
    if (paramMsgElemInfo_servtype21.group_confess_msg.has())
    {
      paramMsgElemInfo_servtype21 = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessMsg)paramMsgElemInfo_servtype21.group_confess_msg.get();
      long l1;
      if (paramMsgElemInfo_servtype21.uint64_confess_time.has())
      {
        l1 = paramMsgElemInfo_servtype21.uint64_confess_time.get();
        this.confessTime = l1;
        l1 = l2;
        if (paramMsgElemInfo_servtype21.uint64_confessor_uin.has()) {
          l1 = paramMsgElemInfo_servtype21.uint64_confessor_uin.get();
        }
        this.confessorUin = l1;
        if (!paramMsgElemInfo_servtype21.uint32_confessor_sex.has()) {
          break label243;
        }
        i = paramMsgElemInfo_servtype21.uint32_confessor_sex.get();
        label98:
        this.confessorSex = ((byte)i);
        if (!paramMsgElemInfo_servtype21.uint32_sysmsg_flag.has()) {
          break label248;
        }
      }
      label243:
      label248:
      for (int i = paramMsgElemInfo_servtype21.uint32_sysmsg_flag.get();; i = 0)
      {
        this.sysMsgFlag = ((byte)i);
        i = j;
        if (paramMsgElemInfo_servtype21.uint32_total_topic_count.has()) {
          i = paramMsgElemInfo_servtype21.uint32_total_topic_count.get();
        }
        this.totalCount = i;
        if ((!paramMsgElemInfo_servtype21.confess_items.has()) || (paramMsgElemInfo_servtype21.confess_items.size() <= 0)) {
          return;
        }
        paramMsgElemInfo_servtype21 = paramMsgElemInfo_servtype21.confess_items.get().iterator();
        while (paramMsgElemInfo_servtype21.hasNext())
        {
          hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem localGroupConfessItem = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem)paramMsgElemInfo_servtype21.next();
          TroopConfessMsgItem localTroopConfessMsgItem = new TroopConfessMsgItem();
          localTroopConfessMsgItem.convertFrom(localGroupConfessItem);
          this.items.add(localTroopConfessMsgItem);
        }
        l1 = 0L;
        break;
        i = 0;
        break label98;
      }
    }
  }
  
  public byte[] getBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopConfess", 2, localIOException.getMessage(), localIOException);
      }
    }
    return null;
  }
  
  public String getConfessToNick()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    TroopConfessMsgItem localTroopConfessMsgItem;
    if (this.items.size() > 0)
    {
      localTroopConfessMsgItem = (TroopConfessMsgItem)this.items.get(0);
      if (localTroopConfessMsgItem.nickType != 0) {
        break label74;
      }
      localStringBuilder.append(localTroopConfessMsgItem.confessToNick);
    }
    for (;;)
    {
      if (localStringBuilder.length() == 0) {
        localStringBuilder.append(Long.toString(localTroopConfessMsgItem.confessToUin));
      }
      return localStringBuilder.toString();
      label74:
      if (localTroopConfessMsgItem.nickType == 1)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (!Long.toString(localTroopConfessMsgItem.confessToUin).equals(((QQAppInterface)localObject).getCurrentAccountUin()))
        {
          localObject = ((ajxn)((QQAppInterface)localObject).getManager(51)).b(Long.toString(localTroopConfessMsgItem.confessToUin));
          if ((localObject != null) && (((Friends)localObject).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localStringBuilder.append(((Friends)localObject).remark);
          } else {
            localStringBuilder.append(localTroopConfessMsgItem.confessToNick);
          }
        }
        else
        {
          localStringBuilder.append(((QQAppInterface)localObject).getCurrentNickname());
        }
      }
    }
  }
  
  public long getConfessToUin()
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.items != null)
    {
      l1 = l2;
      if (this.items.size() > 0) {
        l1 = ((TroopConfessMsgItem)this.items.get(0)).confessToUin;
      }
    }
    return l1;
  }
  
  public int getConfessTopicId()
  {
    int j = 0;
    int i = j;
    if (this.items != null)
    {
      i = j;
      if (this.items.size() > 0) {
        i = ((TroopConfessMsgItem)this.items.get(0)).topicId;
      }
    }
    return i;
  }
  
  public String getSimpleMsg()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.items.size() > 0)
    {
      TroopConfessMsgItem localTroopConfessMsgItem = (TroopConfessMsgItem)this.items.get(0);
      localStringBuilder.append(getConfessToNick());
      localStringBuilder.append("，").append(localTroopConfessMsgItem.topic);
    }
    return localStringBuilder.toString();
  }
  
  public boolean isToSelf()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext()) {
      if (Long.toString(((TroopConfessMsgItem)localIterator.next()).confessToUin).equals(localQQAppInterface.getCurrentAccountUin())) {
        return true;
      }
    }
    return false;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput.readInt() == 805)
    {
      this.confessTime = paramObjectInput.readLong();
      this.confessorUin = paramObjectInput.readLong();
      this.confessorSex = paramObjectInput.readByte();
      this.sysMsgFlag = paramObjectInput.readByte();
      this.totalCount = paramObjectInput.readInt();
      paramObjectInput = (List)paramObjectInput.readObject();
      if ((paramObjectInput != null) && (paramObjectInput.size() > 0)) {
        this.items.addAll(paramObjectInput);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("confessorUin").append("=").append(this.confessorUin);
    localStringBuilder.append(",").append("confessTime").append("=").append(this.confessTime);
    localStringBuilder.append(",").append("confessorSex").append("=").append(this.confessorSex);
    localStringBuilder.append(",").append("sysMsgFlag").append("=").append(this.sysMsgFlag);
    localStringBuilder.append(",").append("totalCount").append("=").append(this.totalCount);
    localStringBuilder.append("[");
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((TroopConfessMsgItem)localIterator.next()).toString()).append("\n");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(805);
    paramObjectOutput.writeLong(this.confessTime);
    paramObjectOutput.writeLong(this.confessorUin);
    paramObjectOutput.writeByte(this.confessorSex);
    paramObjectOutput.writeByte(this.sysMsgFlag);
    paramObjectOutput.writeInt(this.totalCount);
    paramObjectOutput.writeObject(this.items);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.data.TroopConfessMsg
 * JD-Core Version:    0.7.0.1
 */