package com.tencent.mobileqq.confess.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem;

public class TroopConfessMsgItem
  implements Externalizable
{
  public String confessToNick;
  public long confessToUin;
  public int nickType;
  public String topic;
  public int topicId;
  
  public TroopConfessMsgItem() {}
  
  public TroopConfessMsgItem(TroopConfessMsgItem paramTroopConfessMsgItem)
  {
    this.topicId = paramTroopConfessMsgItem.topicId;
    this.confessToUin = paramTroopConfessMsgItem.confessToUin;
    this.confessToNick = paramTroopConfessMsgItem.confessToNick;
    this.topic = paramTroopConfessMsgItem.topic;
    this.nickType = paramTroopConfessMsgItem.nickType;
  }
  
  public void convertFrom(hummer_commelem.MsgElemInfo_servtype21.GroupConfessItem paramGroupConfessItem)
  {
    int j = 0;
    int i;
    long l;
    if (paramGroupConfessItem.uint32_topic_id.has())
    {
      i = paramGroupConfessItem.uint32_topic_id.get();
      this.topicId = i;
      if (!paramGroupConfessItem.uint64_confess_to_uin.has()) {
        break label137;
      }
      l = paramGroupConfessItem.uint64_confess_to_uin.get();
      label44:
      this.confessToUin = l;
      if (!paramGroupConfessItem.bytes_confess_to_nick.has()) {
        break label143;
      }
      str = paramGroupConfessItem.bytes_confess_to_nick.get().toStringUtf8();
      label72:
      this.confessToNick = str;
      if (!paramGroupConfessItem.bytes_topic.has()) {
        break label150;
      }
    }
    label137:
    label143:
    label150:
    for (String str = paramGroupConfessItem.bytes_topic.get().toStringUtf8();; str = "")
    {
      this.topic = str;
      i = j;
      if (paramGroupConfessItem.uint32_confess_to_nick_type.has()) {
        i = paramGroupConfessItem.uint32_confess_to_nick_type.get();
      }
      this.nickType = i;
      return;
      i = 0;
      break;
      l = 0L;
      break label44;
      str = "";
      break label72;
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
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    if (paramObjectInput.readInt() == 805)
    {
      this.topicId = paramObjectInput.readInt();
      this.confessToUin = paramObjectInput.readLong();
      this.confessToNick = paramObjectInput.readUTF();
      this.topic = paramObjectInput.readUTF();
      this.nickType = paramObjectInput.readInt();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("topicId").append("=").append(this.topicId);
    localStringBuilder.append(",").append("confessToUin").append("=").append(this.confessToUin);
    localStringBuilder.append(",").append("confessToNick").append("=").append(this.confessToNick);
    localStringBuilder.append(",").append("topic").append("=").append(this.topic);
    localStringBuilder.append(",").append("nickType").append("=").append(this.nickType);
    return localStringBuilder.toString();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(805);
    paramObjectOutput.writeInt(this.topicId);
    paramObjectOutput.writeLong(this.confessToUin);
    paramObjectOutput.writeUTF(this.confessToNick);
    paramObjectOutput.writeUTF(this.topic);
    paramObjectOutput.writeInt(this.nickType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.data.TroopConfessMsgItem
 * JD-Core Version:    0.7.0.1
 */