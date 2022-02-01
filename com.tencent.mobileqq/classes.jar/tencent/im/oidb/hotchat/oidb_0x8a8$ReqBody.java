package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8a8$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int JOINED_WIFI_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "joined_wifi" }, new Object[] { null }, ReqBody.class);
  public LBS.Wifi joined_wifi = new LBS.Wifi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x8a8.ReqBody
 * JD-Core Version:    0.7.0.1
 */