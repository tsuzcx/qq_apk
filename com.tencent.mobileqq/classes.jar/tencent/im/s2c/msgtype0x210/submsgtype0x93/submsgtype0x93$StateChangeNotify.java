package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x93$StateChangeNotify
  extends MessageMicro<StateChangeNotify>
{
  public static final int MSG_TYPE_ADD_COMMENT = 2;
  public static final int MSG_TYPE_CANCEL_INGORE = 5;
  public static final int MSG_TYPE_CREATE = 1;
  public static final int MSG_TYPE_DEL = 6;
  public static final int MSG_TYPE_DEL_INDEX = 7;
  public static final int MSG_TYPE_INGORED = 4;
  public static final int MSG_TYPE_READED = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_msg_type = PBField.initEnum(1);
  public submsgtype0x93.SourceID msg_source_id = new submsgtype0x93.SourceID();
  public final PBRepeatMessageField<submsgtype0x93.LiteMailIndexInfo> rpt_msg_lite_mail_index = PBField.initRepeatMessage(submsgtype0x93.LiteMailIndexInfo.class);
  public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50 }, new String[] { "msg_source_id", "bytes_feeds_id", "enum_msg_type", "bytes_ext_msg", "uint64_req_uin", "rpt_msg_lite_mail_index" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(1), localByteStringMicro2, Long.valueOf(0L), null }, StateChangeNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.StateChangeNotify
 * JD-Core Version:    0.7.0.1
 */