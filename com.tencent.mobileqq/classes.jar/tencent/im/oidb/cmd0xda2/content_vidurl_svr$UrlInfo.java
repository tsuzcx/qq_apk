package tencent.im.oidb.cmd0xda2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class content_vidurl_svr$UrlInfo
  extends MessageMicro<UrlInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "vid", "status", "url" }, new Object[] { "", Integer.valueOf(0), "" }, UrlInfo.class);
  public final PBInt32Field status = PBField.initInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBStringField vid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xda2.content_vidurl_svr.UrlInfo
 * JD-Core Version:    0.7.0.1
 */