package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FrdSysMsg$FriendSysMsg
  extends MessageMicro<FriendSysMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_paster_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public FrdSysMsg.GroupInfoExt msg_group_ext = new FrdSysMsg.GroupInfoExt();
  public FrdSysMsg.InviteInfo msg_intite_info = new FrdSysMsg.InviteInfo();
  public FrdSysMsg.SchoolInfo msg_school_info = new FrdSysMsg.SchoolInfo();
  public final PBUInt32Field uint32_doubt_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 402, 800 }, new String[] { "msg_group_ext", "msg_intite_info", "msg_school_info", "bytes_paster_info", "uint32_doubt_flag" }, new Object[] { null, null, null, localByteStringMicro, Integer.valueOf(0) }, FriendSysMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg
 * JD-Core Version:    0.7.0.1
 */