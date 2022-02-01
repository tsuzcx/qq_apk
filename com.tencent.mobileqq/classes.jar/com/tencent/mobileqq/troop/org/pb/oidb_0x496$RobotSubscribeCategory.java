package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$RobotSubscribeCategory
  extends MessageMicro<RobotSubscribeCategory>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField next_content = PBField.initString("");
  public final PBStringField next_wording = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "id", "name", "type", "next_wording", "next_content" }, new Object[] { localInteger, "", localInteger, "", "" }, RobotSubscribeCategory.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory
 * JD-Core Version:    0.7.0.1
 */