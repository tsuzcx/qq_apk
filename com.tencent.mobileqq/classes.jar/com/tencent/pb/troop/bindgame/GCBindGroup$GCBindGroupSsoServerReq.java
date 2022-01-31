package com.tencent.pb.troop.bindgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GCBindGroup$GCBindGroupSsoServerReq
  extends MessageMicro<GCBindGroupSsoServerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "cmd", "bind_req", "dynamic_req", "member_req" }, new Object[] { "", null, null, null }, GCBindGroupSsoServerReq.class);
  public GCBindGroup.QQGroupBind bind_req = new GCBindGroup.QQGroupBind();
  public final PBStringField cmd = PBField.initString("");
  public GCBindGroup.QQGroupCardDynamic dynamic_req = new GCBindGroup.QQGroupCardDynamic();
  public GCBindGroup.QQGroupCardMember member_req = new GCBindGroup.QQGroupCardMember();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerReq
 * JD-Core Version:    0.7.0.1
 */