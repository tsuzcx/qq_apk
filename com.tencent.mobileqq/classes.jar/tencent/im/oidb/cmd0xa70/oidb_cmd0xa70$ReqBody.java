package tencent.im.oidb.cmd0xa70;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xa70$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "msg_video_req_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public oidb_cmd0xa70.VideoReqInfo msg_video_req_info = new oidb_cmd0xa70.VideoReqInfo();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.ReqBody
 * JD-Core Version:    0.7.0.1
 */