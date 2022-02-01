package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$RspItemInfo
  extends MessageMicro<RspItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_extend = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint_update_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "str_name", "uint_version", "uint_update_flag", "str_extend" }, new Object[] { "", localInteger, localInteger, "" }, RspItemInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.RspItemInfo
 * JD-Core Version:    0.7.0.1
 */