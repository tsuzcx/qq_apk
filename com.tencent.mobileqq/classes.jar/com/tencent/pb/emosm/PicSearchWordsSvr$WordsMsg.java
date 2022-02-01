package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PicSearchWordsSvr$WordsMsg
  extends MessageMicro<WordsMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_words_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_words_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_words_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_words_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_words_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "bytes_words_version", "bytes_words_url", "bytes_words_md5", "uint32_words_type", "bytes_words_other" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, WordsMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.emosm.PicSearchWordsSvr.WordsMsg
 * JD-Core Version:    0.7.0.1
 */