package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class STExploreInfo$STMsgInfo
  extends MessageMicro<STMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field action_id = PBField.initInt32(0);
  public final PBInt32Field bubble_id = PBField.initInt32(0);
  public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field is_red = PBField.initInt32(0);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField scheme = PBField.initString("");
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 64 }, new String[] { "seq", "wording", "jump_url", "scheme", "is_red", "icon_url", "action_id", "bubble_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, "", Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, STMsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STExploreInfo.STMsgInfo
 * JD-Core Version:    0.7.0.1
 */