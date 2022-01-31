package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class nearby_troop_hot$HotQunRsp
  extends MessageMicro
{
  public static final int QUN_INFO_FIELD_NUMBER = 2;
  public static final int QUN_ITEM_FIELD_NUMBER = 10;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82 }, new String[] { "ret_info", "qun_info", "qun_item" }, new Object[] { null, null, null }, HotQunRsp.class);
  public nearby_troop_hot.QunInfo qun_info = new nearby_troop_hot.QunInfo();
  public final PBRepeatMessageField qun_item = PBField.initRepeatMessage(nearby_troop_hot.QunItem.class);
  public nearby_troop_hot.RetInfo ret_info = new nearby_troop_hot.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot.HotQunRsp
 * JD-Core Version:    0.7.0.1
 */