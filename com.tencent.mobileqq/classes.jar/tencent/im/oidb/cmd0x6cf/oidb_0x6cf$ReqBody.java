package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_article_source = PBField.initEnum(0);
  public oidb_0x6cf.ReqAdvertisePara req_advertise_para = new oidb_0x6cf.ReqAdvertisePara();
  public final PBRepeatField rpt_bytes_redo_inner_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_uint64_redo_article_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_req_dislike_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_topic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vertical_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 64, 74, 80, 112, 120, 128 }, new String[] { "uint64_uin", "uint64_article_id", "bytes_inner_id", "enum_article_source", "uint32_want_count", "uint32_want_type", "req_advertise_para", "rpt_uint64_redo_article_id", "rpt_bytes_redo_inner_id", "uint32_req_source", "uint32_req_dislike_type", "uint32_req_topic_id", "uint32_req_vertical_video" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody
 * JD-Core Version:    0.7.0.1
 */