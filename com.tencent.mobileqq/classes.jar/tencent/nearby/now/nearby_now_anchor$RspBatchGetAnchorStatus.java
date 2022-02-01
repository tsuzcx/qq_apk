package tencent.nearby.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_now_anchor$RspBatchGetAnchorStatus
  extends MessageMicro<RspBatchGetAnchorStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "msg_anchor_stats" }, new Object[] { Integer.valueOf(0), null }, RspBatchGetAnchorStatus.class);
  public final PBRepeatMessageField<nearby_now_anchor.AnchorStatus> msg_anchor_stats = PBField.initRepeatMessage(nearby_now_anchor.AnchorStatus.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.nearby.now.nearby_now_anchor.RspBatchGetAnchorStatus
 * JD-Core Version:    0.7.0.1
 */