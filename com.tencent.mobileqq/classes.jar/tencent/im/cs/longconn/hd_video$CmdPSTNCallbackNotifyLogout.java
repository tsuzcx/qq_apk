package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video$CmdPSTNCallbackNotifyLogout
  extends MessageMicro<CmdPSTNCallbackNotifyLogout>
{
  public static final int STATUS_DST_NO_ANSWER = 3;
  public static final int STATUS_DST_NO_CONNECT = 5;
  public static final int STATUS_NORMAL = 1;
  public static final int STATUS_SRC_NO_ANSWER = 2;
  public static final int STATUS_SRC_NO_CONNECT = 4;
  public static final int STATUS_UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_call_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_call_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_call_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_call_id", "uint32_call_time", "uint32_call_status" }, new Object[] { localByteStringMicro, localInteger, localInteger }, CmdPSTNCallbackNotifyLogout.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video.CmdPSTNCallbackNotifyLogout
 * JD-Core Version:    0.7.0.1
 */