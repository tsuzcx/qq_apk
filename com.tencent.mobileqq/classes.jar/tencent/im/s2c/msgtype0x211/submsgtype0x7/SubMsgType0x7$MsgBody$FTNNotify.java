package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$FTNNotify
  extends MessageMicro<FTNNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_originfile_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0x7.MsgBody.ActionInfo msg_ActionInfo = new SubMsgType0x7.MsgBody.ActionInfo();
  public final PBStringField str_file_index = PBField.initString("");
  public final PBStringField str_file_key = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_batchID = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_curindex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_groupflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_originfiletype = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_len = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 88, 162, 168, 176 }, new String[] { "uint64_sessionid", "str_file_name", "str_file_index", "bytes_file_md5", "str_file_key", "uint64_file_len", "bytes_originfile_md5", "uint32_originfiletype", "uint32_group_id", "uint32_group_size", "uint32_group_curindex", "msg_ActionInfo", "uint32_batchID", "uint32_groupflag" }, new Object[] { Long.valueOf(0L), "", "", localByteStringMicro1, "", Long.valueOf(0L), localByteStringMicro2, localInteger, localInteger, localInteger, localInteger, null, localInteger, localInteger }, FTNNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify
 * JD-Core Version:    0.7.0.1
 */