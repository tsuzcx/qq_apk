package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xbe0$StackInfo
  extends MessageMicro<StackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_current_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<cmd0xbe0.StackGallery> rpt_msg_stack_gallery = PBField.initRepeatMessage(cmd0xbe0.StackGallery.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_stack_gallery", "bytes_current_gallery_rowkey" }, new Object[] { null, localByteStringMicro }, StackInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0.StackInfo
 * JD-Core Version:    0.7.0.1
 */