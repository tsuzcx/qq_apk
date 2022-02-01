package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ExtendFriendUserCategory$GetUserStatusRsp
  extends MessageMicro<GetUserStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField Category = PBField.initEnum(0);
  public final PBBoolField HasPersonalLabels = PBField.initBool(false);
  public final PBBoolField HasWangzheRecord = PBField.initBool(false);
  public final PBInt64Field LastLoginTime = PBField.initInt64(0L);
  public final PBBoolField UsedNewMatch = PBField.initBool(false);
  public final PBUInt32Field check_interval_ms = PBField.initUInt32(0);
  public ExtendFriendUserCategory.ForbiddenInfo forbiddenInfo = new ExtendFriendUserCategory.ForbiddenInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56 }, new String[] { "Category", "UsedNewMatch", "HasPersonalLabels", "forbiddenInfo", "HasWangzheRecord", "LastLoginTime", "check_interval_ms" }, new Object[] { localInteger, localBoolean, localBoolean, null, localBoolean, Long.valueOf(0L), localInteger }, GetUserStatusRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp
 * JD-Core Version:    0.7.0.1
 */