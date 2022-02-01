package tencent.im.oidb.oidb_0xfa3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_comment.oidb_comment.RptData;
import tencent.im.oidb.oidb_msgboard.oidb_msgboard.SourceInfo;

public final class oidb_0xfa3$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSGTYPE_POST = 1;
  public static final int MSGTYPE_REPLY = 2;
  public static final int MSGTYPE_UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField business_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field message_type = PBField.initUInt32(0);
  public final PBStringField replied_message_id = PBField.initString("");
  public final PBUInt64Field replied_puin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_comment.RptData> rpt_data = PBField.initRepeatMessage(oidb_comment.RptData.class);
  public oidb_msgboard.SourceInfo source = new oidb_msgboard.SourceInfo();
  public final PBStringField source_message_id = PBField.initString("");
  public oidb_0xfa3.TerminalInfo terminal = new oidb_0xfa3.TerminalInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 90, 96, 106, 162 }, new String[] { "source", "rpt_data", "business_info", "message_type", "source_message_id", "replied_puin", "replied_message_id", "terminal" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0), "", Long.valueOf(0L), "", null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.ReqBody
 * JD-Core Version:    0.7.0.1
 */