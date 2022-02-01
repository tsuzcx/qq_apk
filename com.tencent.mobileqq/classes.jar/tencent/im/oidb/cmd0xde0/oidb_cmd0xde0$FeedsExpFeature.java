package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xde0$FeedsExpFeature
  extends MessageMicro<FeedsExpFeature>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field exp_chnl_duration = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_cmd0xde0.FeedExpInfo> exp_feeds = PBField.initRepeatMessage(oidb_cmd0xde0.FeedExpInfo.class);
  public final PBUInt64Field exp_first_scrn_duration = PBField.initUInt64(0L);
  public final PBUInt64Field exp_last_scrn_duration = PBField.initUInt64(0L);
  public final PBBoolField is_user_active = PBField.initBool(false);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "exp_feeds", "exp_chnl_duration", "is_user_active", "exp_first_scrn_duration", "exp_last_scrn_duration" }, new Object[] { null, localLong, Boolean.valueOf(false), localLong, localLong }, FeedsExpFeature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedsExpFeature
 * JD-Core Version:    0.7.0.1
 */