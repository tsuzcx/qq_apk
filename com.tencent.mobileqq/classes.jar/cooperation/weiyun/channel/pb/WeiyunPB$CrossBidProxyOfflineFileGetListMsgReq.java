package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeiyunPB$CrossBidProxyOfflineFileGetListMsgReq
  extends MessageMicro<CrossBidProxyOfflineFileGetListMsgReq>
{
  public static final int UINT32_FTN_BID_FIELD_NUMBER = 10;
  public static final int UINT32_NUMBER_FIELD_NUMBER = 3;
  public static final int UINT32_OFFLINE_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_OFFSET_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80 }, new String[] { "uint32_offline_type", "uint32_offset", "uint32_number", "uint32_ftn_bid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CrossBidProxyOfflineFileGetListMsgReq.class);
  public final PBUInt32Field uint32_ftn_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_offline_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq
 * JD-Core Version:    0.7.0.1
 */