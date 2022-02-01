package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TtsResBody$voice_item
  extends MessageMicro<voice_item>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBBytesField voice = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "voice", "seq" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, voice_item.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.TtsResBody.voice_item
 * JD-Core Version:    0.7.0.1
 */