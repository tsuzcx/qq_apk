package tencent.im.oidb.cmd0x935;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x935$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cur_pos = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0x935.RecommendInfo> recommend_info = PBField.initRepeatMessage(oidb_0x935.RecommendInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "recommend_info", "is_end", "cur_pos" }, new Object[] { null, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x935.oidb_0x935.RspBody
 * JD-Core Version:    0.7.0.1
 */