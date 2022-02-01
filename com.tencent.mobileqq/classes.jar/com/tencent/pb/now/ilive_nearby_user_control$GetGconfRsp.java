package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_nearby_user_control$GetGconfRsp
  extends MessageMicro<GetGconfRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "err_msg", "config_info" }, new Object[] { Integer.valueOf(0), "", "" }, GetGconfRsp.class);
  public final PBStringField config_info = PBField.initString("");
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_nearby_user_control.GetGconfRsp
 * JD-Core Version:    0.7.0.1
 */