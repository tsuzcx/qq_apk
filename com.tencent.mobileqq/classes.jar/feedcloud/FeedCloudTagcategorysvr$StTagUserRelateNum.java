package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudTagcategorysvr$StTagUserRelateNum
  extends MessageMicro<StTagUserRelateNum>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "num" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, StTagUserRelateNum.class);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagUserRelateNum
 * JD-Core Version:    0.7.0.1
 */