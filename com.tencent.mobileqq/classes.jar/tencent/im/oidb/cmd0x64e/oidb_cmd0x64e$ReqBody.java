package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x64e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pre_load_req_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0x64e.ReportInfo> rpt_report_info = PBField.initRepeatMessage(oidb_cmd0x64e.ReportInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_report_info", "bytes_pre_load_req_info" }, new Object[] { null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReqBody
 * JD-Core Version:    0.7.0.1
 */