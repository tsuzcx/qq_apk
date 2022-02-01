package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcd5$CheckReplyRsp
  extends MessageMicro<CheckReplyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "auto_reply_flag" }, new Object[] { Integer.valueOf(0) }, CheckReplyRsp.class);
  public final PBUInt32Field auto_reply_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.CheckReplyRsp
 * JD-Core Version:    0.7.0.1
 */