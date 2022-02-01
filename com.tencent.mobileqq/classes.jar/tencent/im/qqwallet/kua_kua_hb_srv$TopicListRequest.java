package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class kua_kua_hb_srv$TopicListRequest
  extends MessageMicro<TopicListRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "limit", "offset" }, new Object[] { "", "" }, TopicListRequest.class);
  public final PBStringField limit = PBField.initString("");
  public final PBStringField offset = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qqwallet.kua_kua_hb_srv.TopicListRequest
 * JD-Core Version:    0.7.0.1
 */