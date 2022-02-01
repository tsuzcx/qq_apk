package com.tencent.mobileqq.confess.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    if (paramMsgElemInfo_servtype21.group_confess_msg.has())
    {
      paramMsgElemInfo_servtype21 = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessMsg)paramMsgElemInfo_servtype21.group_confess_msg.get();
      boolean bool = paramMsgElemInfo_servtype21.uint64_confess_time.has();
      long l2 = 0L;
      if (bool) {
        l1 = paramMsgElemInfo_servtype21.uint64_confess_time.get();
      } else {
        l1 = 0L;
      }
      this.confessTime = l1;
      long l1 = l2;
      if (paramMsgElemInfo_servtype21.uint64_confessor_uin.has()) {
        l1 = paramMsgElemInfo_servtype21.uint64_confessor_uin.get();
      }
      this.confessorUin = l1;
      bool = paramMsgElemInfo_servtype21.uint32_confessor_sex.has();
      int j = 0;
      if (bool) {
        i = paramMsgElemInfo_servtype21.uint32_confessor_sex.get();
      } else {
        i = 0;
      }
      this.confessorSex = ((byte)i);
      if (paramMsgElemInfo_servtype21.uint32_sysmsg_flag.has()) {
        i = paramMsgElemInfo_servtype21.uint32_sysmsg_flag.get();
      } else {
        i = 0;
      }
      this.sysMsgFlag = ((byte)i);
      int i = j;
      if (paramMsgElemInfo_servtype21.uint32_total_topic_count.has()) {
        i = paramMsgElemInfo_servtype21.uint32_total_topic_count.get();
      }
      this.totalCount = i;
      if ((paramMsgElemInfo_servtype21.confess_items.has()) && (paramMsgElemInfo_servtype21.confess_items.size() > 0))
      {
        paramMsgElemInfo_servtype21 = paramMsgElemInfo_servtype21.confess_items.get().iterator();
        while (paramMsgElemInfo_servtype21.hasNext())
        {
          hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem localGroupConfessItem = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem)paramMsgElemInfo_servtype21.next();
          TroopConfessMsgItem localTroopConfessMsgItem = new TroopConfessMsgItem();
          localTroopConfessMsgItem.convertFrom(localGroupConfessItem);
          this.items.add(localTroopConfessMsgItem);
        }
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
    if (this.items.size() > 0)
    {
      TroopConfessMsgItem localTroopConfessMsgItem = (TroopConfessMsgItem)this.items.get(0);
      if (localTroopConfessMsgItem.nickType == 0)
      {
        localStringBuilder.append(localTroopConfessMsgItem.confessToNick);
      }
      else if (localTroopConfessMsgItem.nickType == 1)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (!Long.toString(localTroopConfessMsgItem.confessToUin).equals(((QQAppInterface)localObject).getCurrentAccountUin()))
        {
          localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).c(Long.toString(localTroopConfessMsgItem.confessToUin));
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
      if (localStringBuilder.length() == 0) {
        localStringBuilder.append(Long.toString(localTroopConfessMsgItem.confessToUin));
      }
    }
    return localStringBuilder.toString();
  }
  
  public long getConfessToUin()
  {
    List localList = this.items;
    if ((localList != null) && (localList.size() > 0)) {
      return ((TroopConfessMsgItem)this.items.get(0)).confessToUin;
    }
    return 0L;
  }
  
  public int getConfessTopicId()
  {
    List localList = this.items;
    int j = 0;
    int i = j;
    if (localList != null)
    {
      i = j;
      if (localList.size() > 0) {
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
      localStringBuilder.append("，");
      localStringBuilder.append(localTroopConfessMsgItem.topic);
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
    localStringBuilder.append("confessorUin");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessorUin);
    localStringBuilder.append(",");
    localStringBuilder.append("confessTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessTime);
    localStringBuilder.append(",");
    localStringBuilder.append("confessorSex");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessorSex);
    localStringBuilder.append(",");
    localStringBuilder.append("sysMsgFlag");
    localStringBuilder.append("=");
    localStringBuilder.append(this.sysMsgFlag);
    localStringBuilder.append(",");
    localStringBuilder.append("totalCount");
    localStringBuilder.append("=");
    localStringBuilder.append(this.totalCount);
    localStringBuilder.append("[");
    Iterator localIterator = this.items.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((TroopConfessMsgItem)localIterator.next()).toString());
      localStringBuilder.append("\n");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.data.TroopConfessMsg
 * JD-Core Version:    0.7.0.1
 */