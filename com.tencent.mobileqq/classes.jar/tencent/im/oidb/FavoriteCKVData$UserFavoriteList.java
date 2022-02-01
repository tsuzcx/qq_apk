package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavoriteCKVData$UserFavoriteList
  extends MessageMicro<UserFavoriteList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<FavoriteCKVData.FavoriteItem> rpt_msg_favorite_items = PBField.initRepeatMessage(FavoriteCKVData.FavoriteItem.class);
  public final PBUInt64Field uint64_modify_ts = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 802 }, new String[] { "uint64_uin", "uint64_modify_ts", "rpt_msg_favorite_items" }, new Object[] { localLong, localLong, null }, UserFavoriteList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData.UserFavoriteList
 * JD-Core Version:    0.7.0.1
 */