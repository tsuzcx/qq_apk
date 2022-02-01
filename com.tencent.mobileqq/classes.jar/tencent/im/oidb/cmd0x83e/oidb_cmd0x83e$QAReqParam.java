package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x83e$QAReqParam
  extends MessageMicro<QAReqParam>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_refer = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_refer", "bytes_question_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, QAReqParam.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.QAReqParam
 * JD-Core Version:    0.7.0.1
 */