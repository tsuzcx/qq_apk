package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqavopensdkSsoTunnel$STAudioVideoReq
  extends MessageMicro
{
  public static final int GAMEID_FIELD_NUMBER = 2;
  public static final int REQBODY_FIELD_NUMBER = 1;
  public static final int ROOMID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "reqBody", "gameId", "roomId" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, STAudioVideoReq.class);
  public final PBUInt32Field gameId = PBField.initUInt32(0);
  public qqavopensdkSsoTunnel.ReqBody reqBody = new qqavopensdkSsoTunnel.ReqBody();
  public final PBUInt64Field roomId = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoReq
 * JD-Core Version:    0.7.0.1
 */