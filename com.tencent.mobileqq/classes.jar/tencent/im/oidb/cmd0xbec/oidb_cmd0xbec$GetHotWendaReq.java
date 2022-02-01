package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbec$GetHotWendaReq
  extends MessageMicro<GetHotWendaReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_cookies", "uint32_page_size" }, new Object[] { null, Integer.valueOf(0) }, GetHotWendaReq.class);
  public oidb_cmd0xbec.Cookies msg_cookies = new oidb_cmd0xbec.Cookies();
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec.GetHotWendaReq
 * JD-Core Version:    0.7.0.1
 */