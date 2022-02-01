package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class ExtendFriendUserCategory$GetUserStatusRsp
  extends MessageMicro<GetUserStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField Category = PBField.initEnum(0);
  public final PBBoolField HasPersonalLabels = PBField.initBool(false);
  public final PBBoolField HasWangzheRecord = PBField.initBool(false);
  public final PBInt64Field LastLoginTime = PBField.initInt64(0L);
  public final PBBoolField UsedNewMatch = PBField.initBool(false);
  public ExtendFriendUserCategory.ForbiddenInfo forbiddenInfo = new ExtendFriendUserCategory.ForbiddenInfo();
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "Category", "UsedNewMatch", "HasPersonalLabels", "forbiddenInfo", "HasWangzheRecord", "LastLoginTime" }, new Object[] { Integer.valueOf(0), localBoolean, localBoolean, null, localBoolean, Long.valueOf(0L) }, GetUserStatusRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp
 * JD-Core Version:    0.7.0.1
 */