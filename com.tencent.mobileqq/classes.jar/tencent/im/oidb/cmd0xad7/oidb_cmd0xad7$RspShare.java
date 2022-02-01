package tencent.im.oidb.cmd0xad7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xad7$RspShare
  extends MessageMicro<RspShare>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_biu = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_friend = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qzhone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wechat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wechat_dpyq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wechat_pyq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_weibo = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 34, 42, 50, 58, 66, 74 }, new String[] { "bytes_friend", "bytes_qzhone", "bytes_wechat", "bytes_wechat_pyq", "bytes_wechat_dpyq", "bytes_weibo", "bytes_biu" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, RspShare.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspShare
 * JD-Core Version:    0.7.0.1
 */