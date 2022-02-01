package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class kua_kua_hb_srv$TopicMatchRequest
  extends MessageMicro<TopicMatchRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "clientAttr", "hbTopic", "userAnswer", "hbListId", "grapUin", "sendUin", "fromType", "groupId" }, new Object[] { null, "", "", "", "", "", Long.valueOf(0L), "" }, TopicMatchRequest.class);
  public kua_kua_hb_srv.ClientAttr clientAttr = new kua_kua_hb_srv.ClientAttr();
  public final PBInt64Field fromType = PBField.initInt64(0L);
  public final PBStringField grapUin = PBField.initString("");
  public final PBStringField groupId = PBField.initString("");
  public final PBStringField hbListId = PBField.initString("");
  public final PBStringField hbTopic = PBField.initString("");
  public final PBStringField sendUin = PBField.initString("");
  public final PBStringField userAnswer = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqwallet.kua_kua_hb_srv.TopicMatchRequest
 * JD-Core Version:    0.7.0.1
 */