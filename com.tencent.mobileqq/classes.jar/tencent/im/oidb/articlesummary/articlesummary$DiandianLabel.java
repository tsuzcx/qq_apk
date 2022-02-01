package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class articlesummary$DiandianLabel
  extends MessageMicro<DiandianLabel>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 42 }, new String[] { "bytes_icon_url", "bytes_icon_wording" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, DiandianLabel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.DiandianLabel
 * JD-Core Version:    0.7.0.1
 */