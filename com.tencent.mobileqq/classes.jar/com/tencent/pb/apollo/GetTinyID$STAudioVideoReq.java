package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTinyID$STAudioVideoReq
  extends MessageMicro<STAudioVideoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "reqBody", "gameId", "roomId" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, STAudioVideoReq.class);
  public final PBUInt32Field gameId = PBField.initUInt32(0);
  public GetTinyID.ReqBody reqBody = new GetTinyID.ReqBody();
  public final PBUInt64Field roomId = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.STAudioVideoReq
 * JD-Core Version:    0.7.0.1
 */