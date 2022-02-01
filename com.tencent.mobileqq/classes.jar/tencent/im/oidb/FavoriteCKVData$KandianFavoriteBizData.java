package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavoriteCKVData$KandianFavoriteBizData
  extends MessageMicro<KandianFavoriteBizData>
{
  public static final int Article = 1;
  public static final int PictureCollection = 3;
  public static final int Video = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_account_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_account_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72 }, new String[] { "bytes_rowkey", "uint32_type", "uint32_video_duration", "uint32_pic_num", "uint64_account_id", "bytes_account_name", "uint32_video_type", "uint64_feeds_id", "uint32_feeds_type" }, new Object[] { localByteStringMicro1, localInteger, localInteger, localInteger, localLong, localByteStringMicro2, localInteger, localLong, localInteger }, KandianFavoriteBizData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData.KandianFavoriteBizData
 * JD-Core Version:    0.7.0.1
 */