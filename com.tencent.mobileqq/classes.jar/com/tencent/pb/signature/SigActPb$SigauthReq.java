package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb$SigauthReq
  extends MessageMicro<SigauthReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field fontid = PBField.initInt32(0);
  public final PBInt32Field itemid = PBField.initInt32(0);
  public final PBInt32Field len = PBField.initInt32(0);
  public final PBUInt64Field uin_disable = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin_disable", "itemid", "len", "data", "fontid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SigauthReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb.SigauthReq
 * JD-Core Version:    0.7.0.1
 */