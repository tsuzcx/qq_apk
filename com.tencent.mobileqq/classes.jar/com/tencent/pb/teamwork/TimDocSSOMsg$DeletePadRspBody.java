package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$DeletePadRspBody
  extends MessageMicro<DeletePadRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<TimDocSSOMsg.PadId> rpt_msg_padid_list = PBField.initRepeatMessage(TimDocSSOMsg.PadId.class);
  public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "uint32_retcode", "bytes_pad_url", "uint32_list_type", "uint32_domainid", "bytes_localpadid", "rpt_msg_padid_list" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, null }, DeletePadRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.DeletePadRspBody
 * JD-Core Version:    0.7.0.1
 */