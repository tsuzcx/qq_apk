package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_comm$AddrInfo
  extends MessageMicro<AddrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_isp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_prov = PBField.initUInt32(0);
  public final PBUInt64Field uint64_account = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_account", "uint32_isp", "uint32_country", "uint32_prov", "uint32_city" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, AddrInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.AddrInfo
 * JD-Core Version:    0.7.0.1
 */