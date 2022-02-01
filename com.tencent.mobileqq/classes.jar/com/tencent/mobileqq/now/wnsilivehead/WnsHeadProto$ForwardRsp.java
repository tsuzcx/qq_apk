package com.tencent.mobileqq.now.wnsilivehead;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WnsHeadProto$ForwardRsp
  extends MessageMicro<ForwardRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busi_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field busi_error_code = PBField.initUInt32(0);
  public final PBStringField busi_error_msg = PBField.initString("");
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field proxy_code = PBField.initUInt32(0);
  public final PBUInt32Field report = PBField.initUInt32(0);
  public final PBUInt32Field stream_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58 }, new String[] { "proxy_code", "err_msg", "busi_buf", "report", "stream_type", "busi_error_code", "busi_error_msg" }, new Object[] { localInteger, "", localByteStringMicro, localInteger, localInteger, localInteger, "" }, ForwardRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto.ForwardRsp
 * JD-Core Version:    0.7.0.1
 */