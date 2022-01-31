package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xd55$CheckAppSignReq
  extends MessageMicro<CheckAppSignReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "client_info" }, new Object[] { null }, CheckAppSignReq.class);
  public qqconnect.ConnectClientInfo client_info = new qqconnect.ConnectClientInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.CheckAppSignReq
 * JD-Core Version:    0.7.0.1
 */