package tencent.im.selfgif;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class CameraEmotionRoaming_sso$UpLoadStateRet
  extends MessageMicro<UpLoadStateRet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_upload_state_ret", "img_info" }, new Object[] { Integer.valueOf(0), null }, UpLoadStateRet.class);
  public CameraEmotionRoaming_sso.ImgInfo img_info = new CameraEmotionRoaming_sso.ImgInfo();
  public final PBInt32Field int32_upload_state_ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRet
 * JD-Core Version:    0.7.0.1
 */