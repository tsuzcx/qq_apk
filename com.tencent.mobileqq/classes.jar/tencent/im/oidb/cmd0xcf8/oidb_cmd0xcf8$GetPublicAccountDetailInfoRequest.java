package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xcf8$GetPublicAccountDetailInfoRequest
  extends MessageMicro<GetPublicAccountDetailInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 32, 42 }, new String[] { "seqno", "luin", "version", "versionInfo" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, "" }, GetPublicAccountDetailInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoRequest
 * JD-Core Version:    0.7.0.1
 */