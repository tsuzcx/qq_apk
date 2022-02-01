package com.tencent.pb.icebreakhotpic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class IcebreakHotPic$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_img_num = PBField.initInt32(0);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatMessageField<IcebreakHotPic.ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(IcebreakHotPic.ImgInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 56 }, new String[] { "int32_result", "bytes_fail_msg", "rpt_msg_img_info", "bytes_rsp_other", "int32_img_num" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.icebreakhotpic.IcebreakHotPic.RspBody
 * JD-Core Version:    0.7.0.1
 */