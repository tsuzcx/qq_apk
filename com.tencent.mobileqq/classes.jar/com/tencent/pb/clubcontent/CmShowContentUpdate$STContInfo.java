package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class CmShowContentUpdate$STContInfo
  extends MessageMicro<STContInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field biz_id = PBField.initInt32(0);
  public final PBInt64Field item_id = PBField.initInt64(0L);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field ver = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "biz_id", "item_id", "name", "ver" }, new Object[] { localInteger, Long.valueOf(0L), localByteStringMicro, localInteger }, STContInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.clubcontent.CmShowContentUpdate.STContInfo
 * JD-Core Version:    0.7.0.1
 */