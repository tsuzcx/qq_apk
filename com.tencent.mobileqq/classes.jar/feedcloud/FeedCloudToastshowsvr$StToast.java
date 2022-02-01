package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudToastshowsvr$StToast
  extends MessageMicro<StToast>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field pushTime = PBField.initInt64(0L);
  public FeedCloudToastshowsvr.StShowControl showControl = new FeedCloudToastshowsvr.StShowControl();
  public FeedCloudToastshowsvr.StToastContent toastContent = new FeedCloudToastshowsvr.StToastContent();
  public final PBStringField toastId = PBField.initString("");
  public final PBUInt32Field toastType = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56 }, new String[] { "toastId", "toastType", "toastContent", "showControl", "busiReport", "busiData", "pushTime" }, new Object[] { "", Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, StToast.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StToast
 * JD-Core Version:    0.7.0.1
 */