package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x9ReqBody
  extends MessageMicro<SubCmd0x9ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_begin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_disscus_uin", "uint32_begin", "uint32_file_num" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, SubCmd0x9ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x9ReqBody
 * JD-Core Version:    0.7.0.1
 */