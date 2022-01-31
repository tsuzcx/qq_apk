package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x938$ScoreListConfig
  extends MessageMicro<ScoreListConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_multi_mode" }, new Object[] { Integer.valueOf(0) }, ScoreListConfig.class);
  public final PBUInt32Field uint32_multi_mode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938.ScoreListConfig
 * JD-Core Version:    0.7.0.1
 */