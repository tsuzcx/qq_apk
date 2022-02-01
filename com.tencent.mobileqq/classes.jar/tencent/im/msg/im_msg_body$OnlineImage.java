package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class im_msg_body$OnlineImage
  extends MessageMicro<OnlineImage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField old_ver_send_file = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "guid", "file_path", "old_ver_send_file" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, OnlineImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.OnlineImage
 * JD-Core Version:    0.7.0.1
 */