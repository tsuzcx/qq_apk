package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowQQLiveFocusProto$GetAnchorOnline1Req
  extends MessageMicro<GetAnchorOnline1Req>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_uid = PBField.initUInt32(0);
  public final PBUInt32Field need_kroom = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uin", "is_uid", "source", "need_kroom" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, GetAnchorOnline1Req.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.nowqqlivefocus.NowQQLiveFocusProto.GetAnchorOnline1Req
 * JD-Core Version:    0.7.0.1
 */