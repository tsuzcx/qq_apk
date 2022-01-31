package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CameraEmotionRoaming_sso$UpLoadStateRsp
  extends MessageMicro<UpLoadStateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField server_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<CameraEmotionRoaming_sso.UpLoadStateRet> upload_state_ret = PBField.initRepeatMessage(CameraEmotionRoaming_sso.UpLoadStateRet.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "upload_state_ret", "server_timestamp_version" }, new Object[] { null, localByteStringMicro }, UpLoadStateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRsp
 * JD-Core Version:    0.7.0.1
 */