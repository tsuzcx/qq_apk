package tencent.im.oidb.cmd0xb83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb83$ReqRecommendTagInfo
  extends MessageMicro<ReqRecommendTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_recommend_info", "uint64_topic_id" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, ReqRecommendTagInfo.class);
  public final PBUInt32Field uint32_recommend_info = PBField.initUInt32(1);
  public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqRecommendTagInfo
 * JD-Core Version:    0.7.0.1
 */