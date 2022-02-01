package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FavoriteCKVData$FavoriteItem
  extends MessageMicro<FavoriteItem>
{
  public static final int Kandian = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 802 }, new String[] { "uint32_favorite_source", "msg_kandian_favorite_item" }, new Object[] { Integer.valueOf(0), null }, FavoriteItem.class);
  public FavoriteCKVData.KandianFavoriteItem msg_kandian_favorite_item = new FavoriteCKVData.KandianFavoriteItem();
  public final PBUInt32Field uint32_favorite_source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.FavoriteCKVData.FavoriteItem
 * JD-Core Version:    0.7.0.1
 */