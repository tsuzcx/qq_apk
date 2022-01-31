package tencent.im.oidb.cmd0x9da;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9da$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int BYTES_COOKIE_FIELD_NUMBER = 3;
  public static final int UINT32_FEED_NUM_FIELD_NUMBER = 2;
  public static final int UINT64_TOPIC_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_feed_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_topic_id", "uint32_feed_num", "bytes_cookie" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9da.cmd0x9da.ReqBody
 * JD-Core Version:    0.7.0.1
 */