package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class kua_kua_hb_srv$TopicMatchReply
  extends MessageMicro<TopicMatchReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField matchToken = PBField.initString("");
  public final PBInt64Field refuseInterval = PBField.initInt64(0L);
  public final PBInt64Field retCode = PBField.initInt64(0L);
  public final PBStringField retMsg = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "retCode", "retMsg", "refuseInterval", "matchToken" }, new Object[] { localLong, "", localLong, "" }, TopicMatchReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchReply
 * JD-Core Version:    0.7.0.1
 */