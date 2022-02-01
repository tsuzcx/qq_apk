package tencent.im.andromeda;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class andromeda$NetInfo
  extends MessageMicro<NetInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bussinessid = PBField.initUInt32(0);
  public final PBUInt32Field clientversion = PBField.initUInt32(0);
  public final PBUInt32Field ispcode = PBField.initUInt32(0);
  public final PBBytesField last_srvmessage = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field lastbyte_recv = PBField.initUInt32(0);
  public final PBUInt32Field lastlost_rate = PBField.initUInt32(0);
  public final PBUInt32Field lastrtt = PBField.initUInt32(0);
  public final PBUInt32Field lastrtt_mean = PBField.initUInt32(0);
  public final PBUInt32Field lastspeed = PBField.initUInt32(0);
  public final PBUInt32Field mcc = PBField.initUInt32(0);
  public final PBUInt32Field mnc = PBField.initUInt32(0);
  public final PBUInt32Field nettype = PBField.initUInt32(0);
  public final PBUInt32Field optype = PBField.initUInt32(0);
  public final PBBytesField ssid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 106, 112 }, new String[] { "nettype", "ssid", "mcc", "mnc", "ispcode", "lastrtt", "lastspeed", "lastrtt_mean", "lastlost_rate", "lastbyte_recv", "bussinessid", "clientversion", "last_srvmessage", "optype" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro2, localInteger }, NetInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.andromeda.andromeda.NetInfo
 * JD-Core Version:    0.7.0.1
 */