package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Doutu$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_get_imginfo_req", "msg_get_hotpic_req", "msg_get_shanmeng_req", "msg_report_hotpic_req", "testReq" }, new Object[] { null, null, null, null, null }, ReqBody.class);
  public Doutu.GetHotPicReq msg_get_hotpic_req = new Doutu.GetHotPicReq();
  public Doutu.GetImgInfoReq msg_get_imginfo_req = new Doutu.GetImgInfoReq();
  public Doutu.GetShanMengReq msg_get_shanmeng_req = new Doutu.GetShanMengReq();
  public Doutu.ReportHotPicReq msg_report_hotpic_req = new Doutu.ReportHotPicReq();
  public Doutu.TestReq testReq = new Doutu.TestReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu.ReqBody
 * JD-Core Version:    0.7.0.1
 */