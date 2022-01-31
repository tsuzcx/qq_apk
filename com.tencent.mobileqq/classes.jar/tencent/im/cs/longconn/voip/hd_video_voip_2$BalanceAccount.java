package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_voip_2$BalanceAccount
  extends MessageMicro<BalanceAccount>
{
  public static final int AT_MULTI = 2;
  public static final int AT_PAIR = 1;
  public static final int AT_TEAM = 3;
  public static final int AT_UNKNOW = 0;
  public static final int FROM_TYPE_LT = 1;
  public static final int FROM_TYPE_QQ = 2;
  public static final int FROM_TYPE_UNKNOW = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_balance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_from_app = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_from_app", "uint64_id", "uint32_account_type", "bytes_balance_cookie" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, BalanceAccount.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.BalanceAccount
 * JD-Core Version:    0.7.0.1
 */