package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_feeds$GroupFeedsMessage$MemoCtrlInfo
  extends MessageMicro<MemoCtrlInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_need_confirmation" }, new Object[] { Integer.valueOf(0) }, MemoCtrlInfo.class);
  public final PBUInt32Field uint32_need_confirmation = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.MemoCtrlInfo
 * JD-Core Version:    0.7.0.1
 */