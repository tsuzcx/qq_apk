package tencent.im.oidb.cmd0xb40;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb40$FavoriteItem
  extends MessageMicro<FavoriteItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xb40.Author msg_author = new oidb_0xb40.Author();
  public oidb_0xb40.FavoriteExtInfo msg_favorite_ext_info = new oidb_0xb40.FavoriteExtInfo();
  public oidb_0xb40.FavoriteSummary msg_favorite_summary = new oidb_0xb40.FavoriteSummary();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_cid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt64Field uint64_favorite_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50 }, new String[] { "bytes_rowkey", "rpt_bytes_cid", "msg_author", "uint64_favorite_time", "msg_favorite_summary", "msg_favorite_ext_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Long.valueOf(0L), null, null }, FavoriteItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb40.oidb_0xb40.FavoriteItem
 * JD-Core Version:    0.7.0.1
 */