package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AccountSearchPb$ResultItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField feed_type = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ftime = PBField.initUInt32(0);
  public final PBBytesField has_video = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField phtot_update = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField pic_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField result_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field total_pic_num = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98, 106, 112 }, new String[] { "feed_id", "name", "pic_url", "jmp_url", "feed_type", "summary", "has_video", "phtot_update", "uin", "result_id", "ftime", "nick_name", "pic_url_list", "total_pic_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Long.valueOf(0L), localByteStringMicro9, Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0) }, ResultItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb.ResultItem
 * JD-Core Version:    0.7.0.1
 */