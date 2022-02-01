package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class WeiyunPB$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int REQMSG_BODY_FIELD_NUMBER = 1;
  public static final int RSPMSG_BODY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ReqMsg_body", "RspMsg_body" }, new Object[] { null, null }, MsgBody.class);
  public WeiyunPB.ReqMsgBody ReqMsg_body = new WeiyunPB.ReqMsgBody();
  public WeiyunPB.RspMsgBody RspMsg_body = new WeiyunPB.RspMsgBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.MsgBody
 * JD-Core Version:    0.7.0.1
 */