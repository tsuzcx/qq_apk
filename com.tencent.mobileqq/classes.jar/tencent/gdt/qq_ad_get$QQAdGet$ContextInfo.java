package tencent.gdt;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$ContextInfo
  extends MessageMicro<ContextInfo>
{
  public static final int CALL_TYPE_EXTERNAL_CALL = 3;
  public static final int CALL_TYPE_ICON = 1;
  public static final int CALL_TYPE_PUSH = 2;
  public static final int CALL_TYPE_UNKNOWN = 0;
  public static final int LOAD_TYPE_DEFAULT = 0;
  public static final int LOAD_TYPE_PRELOAD = 3;
  public static final int LOAD_TYPE_REAR = 4;
  public static final int LOAD_TYPE_TIMEOUT = 2;
  public static final int LOAD_TYPE_TOP = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field article_id = PBField.initUInt64(0L);
  public final PBStringField call_from = PBField.initString("");
  public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBEnumField launch_channel = PBField.initEnum(0);
  public final PBEnumField load_type = PBField.initEnum(0);
  public final PBUInt32Field mini_program_status = PBField.initUInt32(0);
  public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field public_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.QQPublicCategoryInfo> qq_public_category = PBField.initRepeatMessage(qq_ad_get.QQAdGet.QQPublicCategoryInfo.class);
  public final PBUInt32Field source_from = PBField.initUInt32(0);
  public final PBStringField str_source_from = PBField.initString("");
  public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
  public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74, 80, 88, 98, 104 }, new String[] { "public_id", "article_id", "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids", "str_source_from", "qq_public_category", "load_type", "mini_program_status", "call_from", "launch_channel" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), "", null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ContextInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.ContextInfo
 * JD-Core Version:    0.7.0.1
 */