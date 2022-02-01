package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$ProgressRsp$ProgressInfo
  extends MessageMicro<ProgressInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_filename = PBField.initString("");
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_filesize = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_progress = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "uint64_sessionid", "uint64_progress", "uint32_status", "uint64_filesize", "str_filename", "uint64_time" }, new Object[] { localLong, localLong, Integer.valueOf(0), localLong, "", localLong }, ProgressInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.ProgressRsp.ProgressInfo
 * JD-Core Version:    0.7.0.1
 */