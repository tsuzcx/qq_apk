package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x64e$PGCFeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_pgc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.PGCPicInfo.class);
  public final PBRepeatMessageField msg_pgc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.PGCVideoInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106 }, new String[] { "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments" }, new Object[] { null, null, localByteStringMicro }, PGCFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.PGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */