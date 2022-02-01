package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VaProfileGate$CommTaskInfo
  extends MessageMicro<CommTaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_task_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appid", "bytes_task_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CommTaskInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo
 * JD-Core Version:    0.7.0.1
 */