package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleUpdatePB$ReqUpdate
  extends MessageMicro<ReqUpdate>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public BubbleUpdatePB.ReqUpdateData msg_req_data = new BubbleUpdatePB.ReqUpdateData();
  public final PBStringField str_version = PBField.initString("");
  public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "int32_cmd", "uint64_uin", "uint32_plat_id", "str_version", "msg_req_data" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, "", null }, ReqUpdate.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.bubbleupdate.BubbleUpdatePB.ReqUpdate
 * JD-Core Version:    0.7.0.1
 */