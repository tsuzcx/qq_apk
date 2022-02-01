package tencent.im.selfgif;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CameraEmotionRoaming_sso$UpLoadStateReq
  extends MessageMicro<UpLoadStateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "upload_state" }, new Object[] { null }, UpLoadStateReq.class);
  public final PBRepeatMessageField<CameraEmotionRoaming_sso.UpLoadState> upload_state = PBField.initRepeatMessage(CameraEmotionRoaming_sso.UpLoadState.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateReq
 * JD-Core Version:    0.7.0.1
 */