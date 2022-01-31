package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class member_lbs$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int BOOL_NEED_NEIGHBOURS_FIELD_NUMBER = 4;
  public static final int MSG_LBSINFO_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "msg_lbsinfo", "uint64_group_code", "uint64_uin", "bool_need_neighbours" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, ReqBody.class);
  public final PBBoolField bool_need_neighbours = PBField.initBool(false);
  public member_lbs.LBSInfo msg_lbsinfo = new member_lbs.LBSInfo();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.ReqBody
 * JD-Core Version:    0.7.0.1
 */