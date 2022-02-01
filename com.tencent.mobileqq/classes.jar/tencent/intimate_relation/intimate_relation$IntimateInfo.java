package tencent.intimate_relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class intimate_relation$IntimateInfo
  extends MessageMicro<IntimateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 74 }, new String[] { "lover", "ladybro", "buddy", "nick_name", "face_url", "is_del", "frd_uin", "modify_time", "bestfriend" }, new Object[] { null, null, null, "", "", Boolean.valueOf(false), Long.valueOf(0L), Integer.valueOf(0), null }, IntimateInfo.class);
  public intimate_relation.IntimateBestFriend bestfriend = new intimate_relation.IntimateBestFriend();
  public intimate_relation.IntimateBuddy buddy = new intimate_relation.IntimateBuddy();
  public final PBStringField face_url = PBField.initString("");
  public final PBUInt64Field frd_uin = PBField.initUInt64(0L);
  public final PBBoolField is_del = PBField.initBool(false);
  public intimate_relation.IntimateLadybro ladybro = new intimate_relation.IntimateLadybro();
  public intimate_relation.IntimateLover lover = new intimate_relation.IntimateLover();
  public final PBUInt32Field modify_time = PBField.initUInt32(0);
  public final PBStringField nick_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.intimate_relation.intimate_relation.IntimateInfo
 * JD-Core Version:    0.7.0.1
 */