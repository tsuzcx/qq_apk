package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea$AddBarrageReqBody
  extends MessageMicro<AddBarrageReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_group_code", "comment", "topic" }, new Object[] { Long.valueOf(0L), null, null }, AddBarrageReqBody.class);
  public oidb_0xdea.Comment comment = new oidb_0xdea.Comment();
  public oidb_0xdea.Topic topic = new oidb_0xdea.Topic();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.oidb.oidb_0xdea.AddBarrageReqBody
 * JD-Core Version:    0.7.0.1
 */