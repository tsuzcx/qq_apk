package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class NowQQLiveFocusProto$GetAnchorOnline1Rsp
  extends MessageMicro<GetAnchorOnline1Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "anchor_info", "ret_info" }, new Object[] { null, null }, GetAnchorOnline1Rsp.class);
  public final PBRepeatMessageField<NowQQLiveFocusProto.AnchorInfo> anchor_info = PBField.initRepeatMessage(NowQQLiveFocusProto.AnchorInfo.class);
  public NowQQLiveFocusProto.RetInfo ret_info = new NowQQLiveFocusProto.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetAnchorOnline1Rsp
 * JD-Core Version:    0.7.0.1
 */