package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleComment$ReadPhotoItemInfo
  extends MessageMicro<ReadPhotoItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field item_remain_time = PBField.initUInt32(0);
  public final PBUInt32Field item_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "index", "item_remain_time", "item_type" }, new Object[] { localInteger, localInteger, localInteger }, ReadPhotoItemInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.ac.ArticleComment.ReadPhotoItemInfo
 * JD-Core Version:    0.7.0.1
 */