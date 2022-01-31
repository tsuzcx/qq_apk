package tencent.im.s2c.msgtype0x210.submsgtype0x8d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x8d$ChannelNotify
  extends MessageMicro<ChannelNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_top_article_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_channel_id", "bytes_channel_name", "bytes_wording", "rpt_top_article_id_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, ChannelNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d.ChannelNotify
 * JD-Core Version:    0.7.0.1
 */