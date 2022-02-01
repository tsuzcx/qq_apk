package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x69f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_important = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_all_channel_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_bigpic_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_cover = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_jump_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gif_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_local_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_my_channel_id_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recomm_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_search_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_search_word = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_video_channel = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_ctrl_bits = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208 }, new String[] { "uint64_uin", "uint32_req_all_channel_list", "uint32_req_my_channel_id_list", "uint32_req_local_channel_id", "uint32_req_bigpic_channel", "uint32_req_video_channel", "uint32_req_gif_channel", "uint32_req_search_channel", "uint32_req_recomm_channel", "uint32_important", "uint32_req_search_word", "uint32_req_channel_jump_url", "uint32_req_channel_id", "uint32_req_channel_cover", "uint32_req_channel_seq", "uint64_req_ctrl_bits", "uint32_req_type" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody
 * JD-Core Version:    0.7.0.1
 */