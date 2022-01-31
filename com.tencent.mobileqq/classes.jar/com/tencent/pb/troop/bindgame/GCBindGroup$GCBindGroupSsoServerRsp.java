package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GCBindGroup$GCBindGroupSsoServerRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "msg", "bind_info", "card_info", "memeber_info" }, new Object[] { Integer.valueOf(0), "", null, null, null }, GCBindGroupSsoServerRsp.class);
  public GCBindGroup.QQBindInfo bind_info = new GCBindGroup.QQBindInfo();
  public GCBindGroup.QQCardDynamicInfo card_info = new GCBindGroup.QQCardDynamicInfo();
  public GCBindGroup.QQCardMemberInfo memeber_info = new GCBindGroup.QQCardMemberInfo();
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp
 * JD-Core Version:    0.7.0.1
 */