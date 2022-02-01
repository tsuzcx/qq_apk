package com.tencent.protofile.oidb_0xe9d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xe9d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_default_on = PBField.initBool(false);
  public final PBBoolField bool_special_follow = PBField.initBool(false);
  public final PBStringField string_request_param = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "string_request_param", "bool_special_follow", "bool_default_on" }, new Object[] { "", localBoolean, localBoolean }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe9d.oidb_0xe9d.ReqBody
 * JD-Core Version:    0.7.0.1
 */