package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_post$RspBody
  extends MessageMicro<RspBody>
{
  public static final int INT32_RESULT_FIELD_NUMBER = 2;
  public static final int MSG_SUBCMD0X1_RSP_NEARBYPOSTINFO_FIELD_NUMBER = 4;
  public static final int STR_ERRO_FIELD_NUMBER = 3;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_sub_cmd", "int32_result", "str_erro", "msg_subcmd0x1_rsp_nearbypostinfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, RspBody.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public nearby_troop_post.RspNearbyPostInfo msg_subcmd0x1_rsp_nearbypostinfo = new nearby_troop_post.RspNearbyPostInfo();
  public final PBStringField str_erro = PBField.initString("");
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_post.nearby_troop_post.RspBody
 * JD-Core Version:    0.7.0.1
 */