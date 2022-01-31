package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$ReqItemInfo
  extends MessageMicro<ReqItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_name", "uint_version" }, new Object[] { "", Integer.valueOf(0) }, ReqItemInfo.class);
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqItemInfo
 * JD-Core Version:    0.7.0.1
 */