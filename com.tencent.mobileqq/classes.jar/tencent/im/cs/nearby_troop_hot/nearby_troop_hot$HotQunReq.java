package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_hot$HotQunReq
  extends MessageMicro<HotQunReq>
{
  public static final int GPS_FIELD_NUMBER = 4;
  public static final int PAGE_NUM_FIELD_NUMBER = 1;
  public static final int PAGE_SIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public nearby_troop_hot.GPS gps = new nearby_troop_hot.GPS();
  public final PBUInt32Field page_num = PBField.initUInt32(0);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34 }, new String[] { "page_num", "page_size", "gps" }, new Object[] { localInteger, localInteger, null }, HotQunReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunReq
 * JD-Core Version:    0.7.0.1
 */