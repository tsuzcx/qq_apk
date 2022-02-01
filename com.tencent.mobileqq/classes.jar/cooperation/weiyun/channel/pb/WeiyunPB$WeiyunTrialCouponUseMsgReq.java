package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$WeiyunTrialCouponUseMsgReq
  extends MessageMicro<WeiyunTrialCouponUseMsgReq>
{
  public static final int BUSINESS_ID_FIELD_NUMBER = 10;
  public static final int FILE_ITEM_FIELD_NUMBER = 50;
  public static final int USE_NUM_FIELD_NUMBER = 20;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 160, 402 }, new String[] { "business_id", "use_num", "file_item" }, new Object[] { "", Integer.valueOf(1), null }, WeiyunTrialCouponUseMsgReq.class);
  public final PBStringField business_id = PBField.initString("");
  public WeiyunPB.FileItem file_item = new WeiyunPB.FileItem();
  public final PBInt32Field use_num = PBField.initInt32(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq
 * JD-Core Version:    0.7.0.1
 */