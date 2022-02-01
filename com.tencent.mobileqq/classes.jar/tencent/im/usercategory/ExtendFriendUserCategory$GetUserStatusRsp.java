package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class ExtendFriendUserCategory$GetUserStatusRsp
  extends MessageMicro<GetUserStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "Category", "UsedNewMatch", "HasPersonalLabels", "forbiddenInfo" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), null }, GetUserStatusRsp.class);
  public final PBEnumField Category = PBField.initEnum(0);
  public final PBBoolField HasPersonalLabels = PBField.initBool(false);
  public final PBBoolField UsedNewMatch = PBField.initBool(false);
  public ExtendFriendUserCategory.ForbiddenInfo forbiddenInfo = new ExtendFriendUserCategory.ForbiddenInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp
 * JD-Core Version:    0.7.0.1
 */