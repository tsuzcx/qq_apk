package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_hot$HotQunMsg
  extends MessageMicro<HotQunMsg>
{
  public static final int CMD_FIELD_NUMBER = 3;
  public static final int EXT_FIELD_NUMBER = 5;
  public static final int MAGIC_FIELD_NUMBER = 1;
  public static final int MSG_REQ_BODY_FIELD_NUMBER = 10;
  public static final int MSG_RSP_BODY_FIELD_NUMBER = 11;
  public static final int SEQ_FIELD_NUMBER = 4;
  public static final int UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 82, 90 }, new String[] { "magic", "uin", "cmd", "seq", "ext", "msg_req_body", "msg_rsp_body" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, HotQunMsg.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public nearby_troop_hot.ExtInfo ext = new nearby_troop_hot.ExtInfo();
  public final PBUInt32Field magic = PBField.initUInt32(0);
  public nearby_troop_hot.HotQunReq msg_req_body = new nearby_troop_hot.HotQunReq();
  public nearby_troop_hot.HotQunRsp msg_rsp_body = new nearby_troop_hot.HotQunRsp();
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunMsg
 * JD-Core Version:    0.7.0.1
 */