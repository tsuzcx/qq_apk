package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class STGameResUpdate$STSvrCVerInfo
  extends MessageMicro<STSvrCVerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field busId = PBField.initUInt32(0);
  public final PBUInt32Field isPatch = PBField.initUInt32(0);
  public final PBStringField itemId = PBField.initString("");
  public final PBStringField md5 = PBField.initString("");
  public final PBUInt64Field packageSize = PBField.initUInt64(0L);
  public final PBBytesField patchContent = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField patchUrl = PBField.initString("");
  public final PBInt32Field subCode = PBField.initInt32(0);
  public final PBUInt32Field svrVer = PBField.initUInt32(0);
  public final PBUInt64Field tipsSize = PBField.initUInt64(0L);
  public final PBUInt32Field updateFlag = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 72, 80, 88, 96 }, new String[] { "busId", "itemId", "updateFlag", "isPatch", "patchContent", "patchUrl", "url", "md5", "svrVer", "packageSize", "tipsSize", "subCode" }, new Object[] { localInteger, "", localInteger, localInteger, localByteStringMicro, "", "", "", localInteger, localLong, localLong, localInteger }, STSvrCVerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameResUpdate.STSvrCVerInfo
 * JD-Core Version:    0.7.0.1
 */