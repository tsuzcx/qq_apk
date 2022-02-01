package tencent.im.oidb.cmd0xe7e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xe7e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_qq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xe7e.ParagraphInfo> rpt_paragraph_info = PBField.initRepeatMessage(oidb_cmd0xe7e.ParagraphInfo.class);
  public oidb_cmd0xe7e.WebInfo rpt_web_info = new oidb_cmd0xe7e.WebInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_qq", "rpt_web_info", "rpt_paragraph_info", "bytes_rowkey" }, new Object[] { localByteStringMicro1, null, null, localByteStringMicro2 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ReqBody
 * JD-Core Version:    0.7.0.1
 */