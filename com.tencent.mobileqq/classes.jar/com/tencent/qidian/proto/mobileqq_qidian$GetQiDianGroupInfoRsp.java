package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class mobileqq_qidian$GetQiDianGroupInfoRsp
  extends MessageMicro<GetQiDianGroupInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_grouplink = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qrcodelink = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wpalink = PBField.initBytes(ByteStringMicro.EMPTY);
  public mobileqq_qidian.RetInfo msg_ret = new mobileqq_qidian.RetInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_ret", "bytes_grouplink", "bytes_wpalink", "bytes_qrcodelink" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, GetQiDianGroupInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetQiDianGroupInfoRsp
 * JD-Core Version:    0.7.0.1
 */