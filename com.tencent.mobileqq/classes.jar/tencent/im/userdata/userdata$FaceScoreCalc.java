package tencent.im.userdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class userdata$FaceScoreCalc
  extends MessageMicro<FaceScoreCalc>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_datenum", "uint32_numerator", "uint32_denominator" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceScoreCalc.class);
  public final PBUInt32Field uint32_datenum = PBField.initUInt32(0);
  public final PBUInt32Field uint32_denominator = PBField.initUInt32(0);
  public final PBUInt32Field uint32_numerator = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.userdata.userdata.FaceScoreCalc
 * JD-Core Version:    0.7.0.1
 */