package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$QidianWpaAddFriendReqBody
  extends MessageMicro<QidianWpaAddFriendReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_visitID", "uint64_customer_uin" }, new Object[] { "", Long.valueOf(0L) }, QidianWpaAddFriendReqBody.class);
  public final PBStringField str_visitID = PBField.initString("");
  public final PBUInt64Field uint64_customer_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.QidianWpaAddFriendReqBody
 * JD-Core Version:    0.7.0.1
 */