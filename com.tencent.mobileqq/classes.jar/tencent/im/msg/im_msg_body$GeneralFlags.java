package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$GeneralFlags
  extends MessageMicro<GeneralFlags>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField babyq_guide_msg_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rp_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rp_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field long_text_flag = PBField.initUInt32(0);
  public final PBBytesField long_text_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uin32_expert_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bubble_diy_text_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bubble_sub_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_glamour_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_olympic_torch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_prp_fold = PBField.initUInt32(0);
  public final PBUInt32Field uint32_to_uin_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_rank_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pendant_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 80, 88, 96, 104, 114, 120, 128, 136, 146, 154 }, new String[] { "uint32_bubble_diy_text_id", "uint32_group_flag_new", "uint64_uin", "bytes_rp_id", "uint32_prp_fold", "long_text_flag", "long_text_resid", "uint32_group_type", "uint32_to_uin_flag", "uint32_glamour_level", "uint32_member_level", "uint64_group_rank_seq", "uint32_olympic_torch", "babyq_guide_msg_cookie", "uin32_expert_flag", "uint32_bubble_sub_id", "uint64_pendant_id", "bytes_rp_index", "bytes_pb_reserve" }, new Object[] { localInteger, localInteger, localLong, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localInteger, localInteger, localInteger, localInteger, localLong, localInteger, localByteStringMicro3, localInteger, localInteger, localLong, localByteStringMicro4, localByteStringMicro5 }, GeneralFlags.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.GeneralFlags
 * JD-Core Version:    0.7.0.1
 */