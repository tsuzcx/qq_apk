package tencent.im.oidb.cmd0xe6b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class beancurdcube_profile_common$ProfileIntro
  extends MessageMicro<ProfileIntro>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_intro = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_intro" }, new Object[] { localByteStringMicro }, ProfileIntro.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe6b.beancurdcube_profile_common.ProfileIntro
 * JD-Core Version:    0.7.0.1
 */