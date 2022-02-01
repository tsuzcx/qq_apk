package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class kua_kua_hb_srv$TopicListReply
  extends MessageMicro<TopicListReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "retCode", "retMsg", "topicList" }, new Object[] { Long.valueOf(0L), "", null }, TopicListReply.class);
  public final PBInt64Field retCode = PBField.initInt64(0L);
  public final PBStringField retMsg = PBField.initString("");
  public final PBRepeatMessageField<kua_kua_hb_srv.TopicAttr> topicList = PBField.initRepeatMessage(kua_kua_hb_srv.TopicAttr.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.kua_kua_hb_srv.TopicListReply
 * JD-Core Version:    0.7.0.1
 */