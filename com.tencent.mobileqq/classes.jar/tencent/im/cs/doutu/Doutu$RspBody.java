package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Doutu$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_imginfo_rsp" }, new Object[] { null }, RspBody.class);
  public Doutu.GetImgInfoRsp msg_get_imginfo_rsp = new Doutu.GetImgInfoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu.RspBody
 * JD-Core Version:    0.7.0.1
 */