package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class CSDataHighwayHead$NewServiceTicket
  extends MessageMicro<NewServiceTicket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_signature", "bytes_ukey" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, NewServiceTicket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.NewServiceTicket
 * JD-Core Version:    0.7.0.1
 */