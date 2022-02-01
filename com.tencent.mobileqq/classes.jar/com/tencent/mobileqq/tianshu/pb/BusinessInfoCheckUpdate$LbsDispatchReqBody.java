package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$LbsDispatchReqBody
  extends MessageMicro<LbsDispatchReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iProtocolVer = PBField.initInt32(0);
  public BusinessInfoCheckUpdate.LbsInfo lbs = new BusinessInfoCheckUpdate.LbsInfo();
  public final PBUInt32Field sClientIP = PBField.initUInt32(0);
  public final PBStringField sClientVer = PBField.initString("");
  public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
  public final PBUInt64Field uiUin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "sClientIP", "lbs" }, new Object[] { localInteger, localInteger, "", Long.valueOf(0L), localInteger, null }, LbsDispatchReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsDispatchReqBody
 * JD-Core Version:    0.7.0.1
 */