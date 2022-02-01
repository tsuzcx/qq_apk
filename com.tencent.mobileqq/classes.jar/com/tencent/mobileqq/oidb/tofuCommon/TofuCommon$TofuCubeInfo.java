package com.tencent.mobileqq.oidb.tofuCommon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TofuCommon$TofuCubeInfo
  extends MessageMicro<TofuCubeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public TofuCommon.Content busi_desc = new TofuCommon.Content();
  public final PBRepeatMessageField<TofuCommon.Content> busi_detail = PBField.initRepeatMessage(TofuCommon.Content.class);
  public final PBStringField string_backgroud = PBField.initString("");
  public final PBStringField string_busi_uuid = PBField.initString("");
  public final PBStringField string_resource = PBField.initString("");
  public final PBUInt32Field uint32_style = PBField.initUInt32(0);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBRepeatField<Long> uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66 }, new String[] { "uint64_busi_id", "uint64_uin", "string_busi_uuid", "uint32_style", "busi_desc", "busi_detail", "string_backgroud", "string_resource" }, new Object[] { localLong, localLong, "", Integer.valueOf(0), null, null, "", "" }, TofuCubeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.oidb.tofuCommon.TofuCommon.TofuCubeInfo
 * JD-Core Version:    0.7.0.1
 */