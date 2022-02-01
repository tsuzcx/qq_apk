package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$LiveStatus
  extends MessageMicro<LiveStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xb81.NowLiveInfo now_live_info = new oidb_cmd0xb81.NowLiveInfo();
  public final PBStringField pic_url = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField str_account = PBField.initString("");
  public final PBStringField str_roomid = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_liveing = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_live_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 82, 122 }, new String[] { "uint32_liveing", "uint64_live_time", "uint32_source", "str_account", "str_roomid", "rowkey", "pic_url", "now_live_info", "str_url" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, "", "", "", "", null, "" }, LiveStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.LiveStatus
 * JD-Core Version:    0.7.0.1
 */