package pb.unite.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicDiscovery$Result
  extends MessageMicro<Result>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 170, 178, 184, 194, 202, 210 }, new String[] { "type", "has_header", "title_header", "hide_top_divider", "sub_business_items", "operation_items", "hot_search_items", "hotword_update_ts", "special_topic_item", "hot_wrod_gif_item", "hot_search_gif_item" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, null, null, Integer.valueOf(0), null, null, null }, Result.class);
  public final PBUInt32Field has_header = PBField.initUInt32(0);
  public final PBUInt32Field hide_top_divider = PBField.initUInt32(0);
  public DynamicDiscovery.GifInfoItem hot_search_gif_item = new DynamicDiscovery.GifInfoItem();
  public final PBRepeatMessageField<DynamicDiscovery.HotSearchItem> hot_search_items = PBField.initRepeatMessage(DynamicDiscovery.HotSearchItem.class);
  public DynamicDiscovery.GifInfoItem hot_wrod_gif_item = new DynamicDiscovery.GifInfoItem();
  public final PBUInt32Field hotword_update_ts = PBField.initUInt32(0);
  public final PBRepeatMessageField<DynamicDiscovery.OperationItem> operation_items = PBField.initRepeatMessage(DynamicDiscovery.OperationItem.class);
  public DynamicDiscovery.SpecialTopic special_topic_item = new DynamicDiscovery.SpecialTopic();
  public final PBRepeatMessageField<DynamicDiscovery.SubBusinessItem> sub_business_items = PBField.initRepeatMessage(DynamicDiscovery.SubBusinessItem.class);
  public DynamicDiscovery.TitleHeaderItem title_header = new DynamicDiscovery.TitleHeaderItem();
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     pb.unite.search.DynamicDiscovery.Result
 * JD-Core Version:    0.7.0.1
 */