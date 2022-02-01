package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GroupAppPb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public GroupAppPb.ClientInfo client = new GroupAppPb.ClientInfo();
  public final PBStringField full_list_hash = PBField.initString("");
  public final PBStringField group_gray_list_hash = PBField.initString("");
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBUInt32Field mini_app_disable = PBField.initUInt32(0);
  public final PBUInt32Field mode = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56 }, new String[] { "client", "group_id", "group_type", "full_list_hash", "group_gray_list_hash", "mini_app_disable", "mode" }, new Object[] { null, Long.valueOf(0L), localInteger, "", "", localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.GroupAppPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */