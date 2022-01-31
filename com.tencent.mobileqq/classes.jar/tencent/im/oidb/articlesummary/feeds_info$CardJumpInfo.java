package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$CardJumpInfo
  extends MessageMicro<CardJumpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_card_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_available = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_available", "bytes_card_jump_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CardJumpInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.CardJumpInfo
 * JD-Core Version:    0.7.0.1
 */