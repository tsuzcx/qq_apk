package tencent.im.oidb.cmd0xeb5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeb5$App
  extends MessageMicro<App>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appid = PBField.initString("");
  public final PBBoolField ark = PBField.initBool(false);
  public final PBStringField ark_label = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBUInt32Field jump_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xeb5.Label> labels = PBField.initRepeatMessage(oidb_0xeb5.Label.class);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field playing_num = PBField.initUInt32(0);
  public final PBInt32Field redpoint = PBField.initInt32(0);
  public final PBUInt64Field type = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 64, 74, 80, 90, 96 }, new String[] { "appid", "type", "name", "icon", "url", "desc", "redpoint", "playing_num", "labels", "ark", "ark_label", "jump_type" }, new Object[] { "", Long.valueOf(0L), "", "", "", "", localInteger, localInteger, null, Boolean.valueOf(false), "", localInteger }, App.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb5.oidb_0xeb5.App
 * JD-Core Version:    0.7.0.1
 */