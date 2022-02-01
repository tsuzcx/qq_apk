package nearby.nearbyLivebarSvr.nearbyLivebarSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetLiveBarStatusRequest
  extends MessageMicro<GetLiveBarStatusRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "anchor_id", "longitude", "latitude", "need_anchorInfo" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, GetLiveBarStatusRequest.class);
  public final PBUInt64Field anchor_id = PBField.initUInt64(0L);
  public final PBStringField latitude = PBField.initString("");
  public final PBStringField longitude = PBField.initString("");
  public final PBUInt32Field need_anchorInfo = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nearby.nearbyLivebarSvr.nearbyLivebarSvr.GetLiveBarStatusRequest
 * JD-Core Version:    0.7.0.1
 */