package com.tencent.pb.apollousertrace;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloUserTrace$STUserTrackReq
  extends MessageMicro<STUserTrackReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "strFrom", "gameId", "roomId", "playts", "userClick" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null }, STUserTrackReq.class);
  public final PBInt32Field gameId = PBField.initInt32(0);
  public final PBInt32Field playts = PBField.initInt32(0);
  public final PBUInt64Field roomId = PBField.initUInt64(0L);
  public final PBStringField strFrom = PBField.initString("");
  public ApolloUserTrace.STUserClickTrack userClick = new ApolloUserTrace.STUserClickTrack();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq
 * JD-Core Version:    0.7.0.1
 */