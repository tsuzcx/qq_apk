package tencent.im.oidb.cmd0xafc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class cmd0xafc$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_nearby_enter", "msg_nearby_exit", "msg_heart_beat" }, new Object[] { null, null, null }, ReqBody.class);
  public cmd0xafc.HeartBeat msg_heart_beat = new cmd0xafc.HeartBeat();
  public cmd0xafc.NearbyEnter msg_nearby_enter = new cmd0xafc.NearbyEnter();
  public cmd0xafc.NearbyExit msg_nearby_exit = new cmd0xafc.NearbyExit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xafc.cmd0xafc.ReqBody
 * JD-Core Version:    0.7.0.1
 */