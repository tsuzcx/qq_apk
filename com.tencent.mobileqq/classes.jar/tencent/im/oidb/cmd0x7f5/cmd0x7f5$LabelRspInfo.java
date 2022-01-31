package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x7f5$LabelRspInfo
  extends MessageMicro<LabelRspInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<cmd0x7f5.LabelInfo> rpt_label_info = PBField.initRepeatMessage(cmd0x7f5.LabelInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_error", "rpt_label_info" }, new Object[] { localByteStringMicro, null }, LabelRspInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.LabelRspInfo
 * JD-Core Version:    0.7.0.1
 */