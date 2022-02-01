package tencent.media_relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class media_relation$MediaRelationInfo
  extends MessageMicro<MediaRelationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "frd_uin", "create_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, MediaRelationInfo.class);
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBUInt64Field frd_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.media_relation.media_relation.MediaRelationInfo
 * JD-Core Version:    0.7.0.1
 */