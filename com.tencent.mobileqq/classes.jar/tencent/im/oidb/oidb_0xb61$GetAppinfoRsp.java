package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb61$GetAppinfoRsp
  extends MessageMicro<GetAppinfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "appinfo" }, new Object[] { null }, GetAppinfoRsp.class);
  public qqconnect.Appinfo appinfo = new qqconnect.Appinfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb61.GetAppinfoRsp
 * JD-Core Version:    0.7.0.1
 */