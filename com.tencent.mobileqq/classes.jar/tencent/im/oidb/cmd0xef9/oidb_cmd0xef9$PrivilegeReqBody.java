package tencent.im.oidb.cmd0xef9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xef9$PrivilegeReqBody
  extends MessageMicro<PrivilegeReqBody>
{
  public static final int BIU = 2;
  public static final int COIN = 5;
  public static final int COMMENT = 1;
  public static final int COMMENTTOPIC = 11;
  public static final int FAMILY = 9;
  public static final int LIKE = 3;
  public static final int LONGCOMMENT = 4;
  public static final int PATROL = 8;
  public static final int TOPIC = 10;
  public static final int UGCPIC = 7;
  public static final int UGCVIDEO = 6;
  public static final int UNIVERSAL = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "oper_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, PrivilegeReqBody.class);
  public final PBUInt32Field oper_type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeReqBody
 * JD-Core Version:    0.7.0.1
 */