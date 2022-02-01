package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavoriteCKVData$KandianFavoriteItem
  extends MessageMicro<KandianFavoriteItem>
{
  public static final int Link = 2;
  public static final int Valid = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public FavoriteCKVData.Author msg_author = new FavoriteCKVData.Author();
  public FavoriteCKVData.KandianFavoriteBizData msg_favorite_ext_info = new FavoriteCKVData.KandianFavoriteBizData();
  public FavoriteCKVData.FavoriteSummary msg_favorite_summary = new FavoriteCKVData.FavoriteSummary();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_cid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_data_sync_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_favorite_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_modify_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64, 72, 82 }, new String[] { "msg_favorite_ext_info", "rpt_bytes_cid", "uint32_type", "uint32_status", "msg_author", "uint64_create_time", "uint64_favorite_time", "uint64_modify_time", "uint64_data_sync_time", "msg_favorite_summary" }, new Object[] { null, localByteStringMicro, localInteger, localInteger, null, localLong, localLong, localLong, localLong, null }, KandianFavoriteItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData.KandianFavoriteItem
 * JD-Core Version:    0.7.0.1
 */