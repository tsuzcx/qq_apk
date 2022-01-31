package com.tencent.protofile.discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FlyTicket$DiscussGetUrlRequest
  extends MessageMicro
{
  public static final int CONF_UIN_FIELD_NUMBER = 1;
  public static final int IS_NEED_LONG_LINK_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "conf_uin", "is_need_long_link" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, DiscussGetUrlRequest.class);
  public final PBUInt32Field conf_uin = PBField.initUInt32(0);
  public final PBBoolField is_need_long_link = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlRequest
 * JD-Core Version:    0.7.0.1
 */