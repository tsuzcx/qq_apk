package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x5fb$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_HEAD_FIELD_NUMBER = 1;
  public static final int MSG_USER_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public cmd0x5fb.BusiRespHead msg_head = new cmd0x5fb.BusiRespHead();
  public final PBBytesField msg_user_list = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_user_list" }, new Object[] { null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fb.RspBody
 * JD-Core Version:    0.7.0.1
 */