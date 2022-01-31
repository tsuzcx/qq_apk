package tencent.im.s2c.msgtype0x210.submsgtype0xc5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xc5$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_diandian_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public submsgtype0xc5.NotifyBody msg_notify_infos = new submsgtype0xc5.NotifyBody();
  public final PBEnumField operator_type = PBField.initEnum(1);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 82, 90 }, new String[] { "uint32_bid", "uint32_source", "operator_type", "uint64_article_id", "uint32_push_time", "uint64_seq", "msg_notify_infos", "bytes_diandian_cookie" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody
 * JD-Core Version:    0.7.0.1
 */