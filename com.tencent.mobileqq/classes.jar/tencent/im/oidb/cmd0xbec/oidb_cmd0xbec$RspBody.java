package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xbec$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "search_result_rsp", "rpt_hot_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_cmd0xbec.HotWendaRsp rpt_hot_rsp = new oidb_cmd0xbec.HotWendaRsp();
  public oidb_cmd0xbec.SearchResultRsp search_result_rsp = new oidb_cmd0xbec.SearchResultRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec.RspBody
 * JD-Core Version:    0.7.0.1
 */