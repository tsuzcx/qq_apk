package tencent.hiboom.hiboomauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.im.msg.im_imagent.ImAgentHead;

public final class hiboom_auth$ImAgentSendNextPack
  extends MessageMicro<ImAgentSendNextPack>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 106, 114 }, new String[] { "head", "reqBody", "rspBody" }, new Object[] { null, null, null }, ImAgentSendNextPack.class);
  public im_imagent.ImAgentHead head = new im_imagent.ImAgentHead();
  public hiboom_auth.AuthReqBody reqBody = new hiboom_auth.AuthReqBody();
  public hiboom_auth.AuthRspBody rspBody = new hiboom_auth.AuthRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.hiboom.hiboomauth.hiboom_auth.ImAgentSendNextPack
 * JD-Core Version:    0.7.0.1
 */