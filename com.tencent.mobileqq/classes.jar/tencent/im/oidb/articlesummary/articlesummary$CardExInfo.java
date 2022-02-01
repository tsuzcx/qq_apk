package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$CardExInfo
  extends MessageMicro<CardExInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_mini_program_movie_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_owner_datacard_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_share_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_owner_datacard_info", "bytes_mini_program_movie_name", "uint32_share_count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, CardExInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.CardExInfo
 * JD-Core Version:    0.7.0.1
 */