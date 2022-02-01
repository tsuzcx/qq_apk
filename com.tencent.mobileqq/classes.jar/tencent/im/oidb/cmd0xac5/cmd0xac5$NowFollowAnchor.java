package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xac5$NowFollowAnchor
  extends MessageMicro<NowFollowAnchor>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_live_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_live_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_live_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_now_uid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_nowid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 64, 72 }, new String[] { "uint64_uin", "uint64_now_uid", "bytes_nick_name", "bytes_head_url", "uint32_live_status", "bytes_live_url", "bytes_live_cover_url", "uint32_account_type", "uint64_nowid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L) }, NowFollowAnchor.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NowFollowAnchor
 * JD-Core Version:    0.7.0.1
 */