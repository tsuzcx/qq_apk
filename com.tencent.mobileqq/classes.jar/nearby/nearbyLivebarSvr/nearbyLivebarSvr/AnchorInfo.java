package nearby.nearbyLivebarSvr.nearbyLivebarSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AnchorInfo
  extends MessageMicro<AnchorInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 74 }, new String[] { "nick", "head_url", "desc", "distance", "age", "gender", "sign", "jump_url", "jump_desc" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", "", "", "" }, AnchorInfo.class);
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField distance = PBField.initString("");
  public final PBStringField gender = PBField.initString("");
  public final PBStringField head_url = PBField.initString("");
  public final PBStringField jump_desc = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField sign = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nearby.nearbyLivebarSvr.nearbyLivebarSvr.AnchorInfo
 * JD-Core Version:    0.7.0.1
 */