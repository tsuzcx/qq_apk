package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class kua_kua_hb_srv$TopicMatchReply
  extends MessageMicro<TopicMatchReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "retCode", "retMsg", "refuseInterval", "matchToken" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), "" }, TopicMatchReply.class);
  public final PBStringField matchToken = PBField.initString("");
  public final PBInt64Field refuseInterval = PBField.initInt64(0L);
  public final PBInt64Field retCode = PBField.initInt64(0L);
  public final PBStringField retMsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchReply
 * JD-Core Version:    0.7.0.1
 */