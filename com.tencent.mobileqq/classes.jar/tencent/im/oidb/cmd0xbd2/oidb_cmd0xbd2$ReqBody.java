package tencent.im.oidb.cmd0xbd2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbd2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rpt_bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_uint64_entrance_topic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_entrance_red_req = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_banner = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_count_in_page = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_count_in_topic = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "rpt_bytes_cookie", "uint32_req_source", "uint32_req_banner", "uint32_topic_count_in_page", "uint32_video_count_in_topic", "rpt_uint64_entrance_topic_id_list", "bytes_push_context", "uint32_entrance_red_req" }, new Object[] { localByteStringMicro1, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro2, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd2.oidb_cmd0xbd2.ReqBody
 * JD-Core Version:    0.7.0.1
 */