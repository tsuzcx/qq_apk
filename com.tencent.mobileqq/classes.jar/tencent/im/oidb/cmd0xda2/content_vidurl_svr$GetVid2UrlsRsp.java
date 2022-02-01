package tencent.im.oidb.cmd0xda2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class content_vidurl_svr$GetVid2UrlsRsp
  extends MessageMicro<GetVid2UrlsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "ret_msg", "urls" }, new Object[] { Integer.valueOf(0), "", null }, GetVid2UrlsRsp.class);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
  public final PBRepeatMessageField<content_vidurl_svr.UrlInfo> urls = PBField.initRepeatMessage(content_vidurl_svr.UrlInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xda2.content_vidurl_svr.GetVid2UrlsRsp
 * JD-Core Version:    0.7.0.1
 */