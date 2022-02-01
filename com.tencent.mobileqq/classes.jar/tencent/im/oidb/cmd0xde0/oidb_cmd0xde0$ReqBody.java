package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xde0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "ctx_feature", "usr_gesture_feature", "feeds_exp_feature", "active_zone" }, new Object[] { null, null, null, null }, ReqBody.class);
  public oidb_cmd0xde0.ActiveZoneFeature active_zone = new oidb_cmd0xde0.ActiveZoneFeature();
  public oidb_cmd0xde0.FeedsCtxFeature ctx_feature = new oidb_cmd0xde0.FeedsCtxFeature();
  public oidb_cmd0xde0.FeedsExpFeature feeds_exp_feature = new oidb_cmd0xde0.FeedsExpFeature();
  public oidb_cmd0xde0.GestureFeature usr_gesture_feature = new oidb_cmd0xde0.GestureFeature();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.ReqBody
 * JD-Core Version:    0.7.0.1
 */