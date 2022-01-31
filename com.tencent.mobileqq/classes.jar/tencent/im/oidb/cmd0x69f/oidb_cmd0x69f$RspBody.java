package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x69f$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_refresh_backgroud_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField bytes_search_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField rpt_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f.ChannelInfo.class);
  public final PBRepeatMessageField rpt_recomm_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f.ChannelInfo.class);
  public final PBRepeatField rpt_uint32_my_channel_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_channel_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_channel_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 96, 106, 114, 176, 192, 210 }, new String[] { "uint64_uin", "rpt_channel_list", "rpt_uint32_my_channel_id_list", "rpt_recomm_channel_list", "bytes_search_word", "uint32_req_channel_id", "uint32_channel_seq", "bytes_refresh_backgroud_url" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody
 * JD-Core Version:    0.7.0.1
 */