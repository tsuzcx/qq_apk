package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendUserCategory$ForbiddenInfo
  extends MessageMicro<ForbiddenInfo>
{
  public static final int BEATREASON_JUBAO = 1;
  public static final int BEATREASON_LENGGONG = 2;
  public static final int BEATREASON_LIAOTIANWEIGUI_QITA = 6;
  public static final int BEATREASON_LIAOTIANWEIGUI_SEQING = 3;
  public static final int BEATREASON_LIAOTIANWEIGUI_YINLIU = 5;
  public static final int BEATREASON_LIAOTIANWEIGUI_ZHAPIAN = 4;
  public static final int BEATREASON_UNKNOWN = 0;
  public static final int Jubao = 1;
  public static final int Lenggong = 2;
  public static final int NotSet = 0;
  public static final int SemanticBeat = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField beat_reason = PBField.initEnum(0);
  public final PBStringField fobiddenTips = PBField.initString("");
  public final PBEnumField fobiddenType = PBField.initEnum(0);
  public final PBUInt32Field forbiddenDuration = PBField.initUInt32(0);
  public final PBUInt64Field forbiddenEndTime = PBField.initUInt64(0L);
  public final PBBoolField isForbidden = PBField.initBool(false);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "isForbidden", "forbiddenEndTime", "forbiddenDuration", "fobiddenType", "fobiddenTips", "beat_reason" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), localInteger, localInteger, "", localInteger }, ForbiddenInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.ForbiddenInfo
 * JD-Core Version:    0.7.0.1
 */