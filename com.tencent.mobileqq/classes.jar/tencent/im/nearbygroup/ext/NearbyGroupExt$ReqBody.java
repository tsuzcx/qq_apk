package tencent.im.nearbygroup.ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public final class NearbyGroupExt$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int UINT32_TYPE_FIELD_NUMBER = 3;
  public static final int USER_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 24 }, new String[] { "user_info", "uint32_type" }, new Object[] { null, Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public userinfo.UserInfo user_info = new userinfo.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.nearbygroup.ext.NearbyGroupExt.ReqBody
 * JD-Core Version:    0.7.0.1
 */