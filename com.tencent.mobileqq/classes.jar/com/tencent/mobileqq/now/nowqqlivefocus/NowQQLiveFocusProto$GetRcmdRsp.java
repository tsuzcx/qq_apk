package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveFocusProto$GetRcmdRsp
  extends MessageMicro<GetRcmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "total_num", "info" }, new Object[] { Integer.valueOf(0), null }, GetRcmdRsp.class);
  public final PBRepeatMessageField<NowQQLiveFocusProto.RcmdAnchorInfo> info = PBField.initRepeatMessage(NowQQLiveFocusProto.RcmdAnchorInfo.class);
  public final PBUInt32Field total_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetRcmdRsp
 * JD-Core Version:    0.7.0.1
 */