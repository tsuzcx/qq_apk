package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class CmShowContentUpdate$STDomainInfo
  extends MessageMicro<STDomainInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field domain_id = PBField.initInt32(0);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "domain_id", "url" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, STDomainInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate.STDomainInfo
 * JD-Core Version:    0.7.0.1
 */