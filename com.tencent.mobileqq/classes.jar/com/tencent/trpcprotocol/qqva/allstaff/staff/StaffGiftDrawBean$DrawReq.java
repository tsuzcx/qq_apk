package com.tencent.trpcprotocol.qqva.allstaff.staff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class StaffGiftDrawBean$DrawReq
  extends MessageMicro<DrawReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "orderNum" }, new Object[] { "" }, DrawReq.class);
  public final PBStringField orderNum = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqva.allstaff.staff.StaffGiftDrawBean.DrawReq
 * JD-Core Version:    0.7.0.1
 */