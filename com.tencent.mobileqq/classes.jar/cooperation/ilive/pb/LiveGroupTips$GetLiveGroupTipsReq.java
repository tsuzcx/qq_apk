package cooperation.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LiveGroupTips$GetLiveGroupTipsReq
  extends MessageMicro<GetLiveGroupTipsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "anchor_uid", "group_id" }, new Object[] { "", Long.valueOf(0L) }, GetLiveGroupTipsReq.class);
  public final PBStringField anchor_uid = PBField.initString("");
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsReq
 * JD-Core Version:    0.7.0.1
 */