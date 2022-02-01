package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CameraEmotionRoaming_sso$DelRsp
  extends MessageMicro<DelRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField client_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<CameraEmotionRoaming_sso.DelRet> del_ret = PBField.initRepeatMessage(CameraEmotionRoaming_sso.DelRet.class);
  public final PBRepeatMessageField<CameraEmotionRoaming_sso.ImgInfo> rpt_img_info = PBField.initRepeatMessage(CameraEmotionRoaming_sso.ImgInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "client_timestamp_version", "del_ret", "rpt_img_info" }, new Object[] { localByteStringMicro, null, null }, DelRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.DelRsp
 * JD-Core Version:    0.7.0.1
 */