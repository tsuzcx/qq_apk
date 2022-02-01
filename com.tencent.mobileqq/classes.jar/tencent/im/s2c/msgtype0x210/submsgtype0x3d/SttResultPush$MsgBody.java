package tencent.im.s2c.msgtype0x210.submsgtype0x3d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SttResultPush$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_ptt_resp", "msg_ptt_shard_resp" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
  public SttResultPush.TransPttResp msg_ptt_resp = new SttResultPush.TransPttResp();
  public SttResultPush.TransPttShardRsp msg_ptt_shard_resp = new SttResultPush.TransPttShardRsp();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody
 * JD-Core Version:    0.7.0.1
 */