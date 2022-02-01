package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CmGameMsgTunnel$PushMsgInfo
  extends MessageMicro<PushMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field accept_uid = PBField.initUInt64(0L);
  public final PBStringField ext_info = PBField.initString("");
  public final PBUInt32Field gameid = PBField.initUInt32(0);
  public final PBUInt64Field invite_uid = PBField.initUInt64(0L);
  public final PBUInt32Field ret = PBField.initUInt32(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "gameid", "accept_uid", "invite_uid", "roomid", "ret", "ext_info" }, new Object[] { localInteger, localLong, localLong, localLong, localInteger, "" }, PushMsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.CmGameMsgTunnel.PushMsgInfo
 * JD-Core Version:    0.7.0.1
 */