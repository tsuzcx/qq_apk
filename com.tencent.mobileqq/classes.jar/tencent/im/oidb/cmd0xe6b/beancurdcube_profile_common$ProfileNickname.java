package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class beancurdcube_profile_common$ProfileNickname
  extends MessageMicro<ProfileNickname>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_nickname" }, new Object[] { localByteStringMicro }, ProfileNickname.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileNickname
 * JD-Core Version:    0.7.0.1
 */