package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class StaffGiftDrawBean$DeliverRsp
  extends MessageMicro<DeliverRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "msg" }, new Object[] { Integer.valueOf(0), "" }, DeliverRsp.class);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DeliverRsp
 * JD-Core Version:    0.7.0.1
 */