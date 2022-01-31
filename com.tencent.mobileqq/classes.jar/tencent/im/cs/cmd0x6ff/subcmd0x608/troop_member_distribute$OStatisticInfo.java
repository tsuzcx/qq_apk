package tencent.im.cs.cmd0x6ff.subcmd0x608;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class troop_member_distribute$OStatisticInfo
  extends MessageMicro
{
  public static final int STATISTIC_TYPE_CITY = 4;
  public static final int STATISTIC_TYPE_GENDER = 1;
  public static final int STATISTIC_TYPE_MARITAL = 3;
  public static final int STATISTIC_TYPE_YEAR = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_statistic_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_desc", "uint32_count", "uint32_statistic_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, OStatisticInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo
 * JD-Core Version:    0.7.0.1
 */