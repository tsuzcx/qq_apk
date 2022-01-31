package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CameraEmotionRoaming_sso$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
  public CameraEmotionRoaming_sso.DelRsp del_rsp = new CameraEmotionRoaming_sso.DelRsp();
  public CameraEmotionRoaming_sso.GetListRsp get_list_rsp = new CameraEmotionRoaming_sso.GetListRsp();
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
  public CameraEmotionRoaming_sso.UpLoadRsp upLoad_rsp = new CameraEmotionRoaming_sso.UpLoadRsp();
  public CameraEmotionRoaming_sso.UpLoadStateRsp upLoad_state_rsp = new CameraEmotionRoaming_sso.UpLoadStateRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66 }, new String[] { "int32_result", "bytes_fail_msg", "uint32_cmd_type", "upLoad_rsp", "upLoad_state_rsp", "get_list_rsp", "del_rsp", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, null, null, null, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.RspBody
 * JD-Core Version:    0.7.0.1
 */