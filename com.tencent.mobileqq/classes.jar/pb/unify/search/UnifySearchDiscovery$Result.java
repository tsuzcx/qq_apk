package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UnifySearchDiscovery$Result
  extends MessageMicro<Result>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field has_header = PBField.initUInt32(0);
  public final PBUInt32Field hide_top_divider = PBField.initUInt32(0);
  public UnifySearchDiscovery.GifInfoItem hot_search_gif_item = new UnifySearchDiscovery.GifInfoItem();
  public final PBRepeatMessageField<UnifySearchDiscovery.HotSearchItem> hot_search_items = PBField.initRepeatMessage(UnifySearchDiscovery.HotSearchItem.class);
  public UnifySearchDiscovery.GifInfoItem hot_word_gif_item = new UnifySearchDiscovery.GifInfoItem();
  public final PBUInt32Field hotword_update_ts = PBField.initUInt32(0);
  public final PBRepeatMessageField<UnifySearchDiscovery.OperationItem> operation_items = PBField.initRepeatMessage(UnifySearchDiscovery.OperationItem.class);
  public final PBBytesField result_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public UnifySearchDiscovery.SpecialTopic special_topic_item = new UnifySearchDiscovery.SpecialTopic();
  public final PBRepeatMessageField<UnifySearchDiscovery.SubBusinessItem> sub_business_items = PBField.initRepeatMessage(UnifySearchDiscovery.SubBusinessItem.class);
  public UnifySearchDiscovery.TitleHeaderItem title_header = new UnifySearchDiscovery.TitleHeaderItem();
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 170, 178, 184, 194, 202, 210, 218 }, new String[] { "type", "has_header", "title_header", "hide_top_divider", "sub_business_items", "operation_items", "hot_search_items", "hotword_update_ts", "special_topic_item", "hot_word_gif_item", "hot_search_gif_item", "result_ext" }, new Object[] { localInteger, localInteger, null, localInteger, null, null, null, localInteger, null, null, null, localByteStringMicro }, Result.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     pb.unify.search.UnifySearchDiscovery.Result
 * JD-Core Version:    0.7.0.1
 */