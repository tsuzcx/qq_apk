package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class synclogic$ChannelMsgRsp
  extends MessageMicro<ChannelMsgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public synclogic.ChannelMsg channel_msg = new synclogic.ChannelMsg();
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field get_msg_time = PBField.initUInt64(0L);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field with_version_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "result", "err_msg", "channel_msg", "with_version_flag", "get_msg_time" }, new Object[] { localInteger, localByteStringMicro, null, localInteger, Long.valueOf(0L) }, ChannelMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp
 * JD-Core Version:    0.7.0.1
 */