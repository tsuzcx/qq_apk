package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$RspBody$SubCmd0x4RspBody
  extends MessageMicro<SubCmd0x4RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_max_download_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_transfer_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_transfer_file_queue_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_max_transfer_single_file_size = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_max_transfer_file_count", "uint64_max_transfer_single_file_size", "uint32_max_transfer_file_queue_num", "uint32_max_download_file_num" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger }, SubCmd0x4RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x4RspBody
 * JD-Core Version:    0.7.0.1
 */