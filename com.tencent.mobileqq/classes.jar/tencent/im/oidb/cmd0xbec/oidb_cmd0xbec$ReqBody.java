package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xbec$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "search_req", "get_hot_wenda_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_cmd0xbec.GetHotWendaReq get_hot_wenda_req = new oidb_cmd0xbec.GetHotWendaReq();
  public oidb_cmd0xbec.SearchByKeyWordsReq search_req = new oidb_cmd0xbec.SearchByKeyWordsReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec.ReqBody
 * JD-Core Version:    0.7.0.1
 */