package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFontUpdate$TFontMd5CheckReq$TMd5Info
  extends MessageMicro<TMd5Info>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field i32_font_id = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_font_id", "bytes_md5" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, TMd5Info.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq.TMd5Info
 * JD-Core Version:    0.7.0.1
 */