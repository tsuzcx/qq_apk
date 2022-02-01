package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class adv_report$MobileAdvReportRsp
  extends MessageMicro<MobileAdvReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busi_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField error_msg = PBField.initString("");
  public final PBInt32Field ret_code = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "error_msg", "busi_buffer" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, MobileAdvReportRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportRsp
 * JD-Core Version:    0.7.0.1
 */