package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class servtype$CategoryInfo
  extends MessageMicro<CategoryInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_category_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<servtype.CategoryChannelInfo> rpt_msg_channel_info = PBField.initRepeatMessage(servtype.CategoryChannelInfo.class);
  public final PBUInt32Field uint32_category_index = PBField.initUInt32(0);
  public final PBUInt64Field uint64_category_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_category_index", "rpt_msg_channel_info", "bytes_category_name", "uint64_category_id" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro, Long.valueOf(0L) }, CategoryInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.CategoryInfo
 * JD-Core Version:    0.7.0.1
 */