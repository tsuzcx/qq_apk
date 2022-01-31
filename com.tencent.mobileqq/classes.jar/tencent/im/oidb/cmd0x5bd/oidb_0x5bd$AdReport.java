package tencent.im.oidb.cmd0x5bd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x5bd$AdReport
  extends MessageMicro<AdReport>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_report_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_report_url" }, new Object[] { localByteStringMicro }, AdReport.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5bd.oidb_0x5bd.AdReport
 * JD-Core Version:    0.7.0.1
 */