package tencent.im.oidb;

import appoint.define.appoint_define.LBSInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x5fb$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 2;
  public static final int REQ_INFO_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public cmd0x5fb.BusiReqHead msg_head = new cmd0x5fb.BusiReqHead();
  public appoint_define.LBSInfo msg_lbs_info = new appoint_define.LBSInfo();
  public final PBBytesField req_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_head", "msg_lbs_info", "req_info" }, new Object[] { null, null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fb.ReqBody
 * JD-Core Version:    0.7.0.1
 */