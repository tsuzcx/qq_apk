package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgReq
  extends MessageMicro<CrossBidProxyCopyFileToOtherBidMsgReq>
{
  public static final int DST_BID_FIELD_NUMBER = 200;
  public static final int DST_UIN_FIELD_NUMBER = 201;
  public static final int EXTENSION_REQ_FIELD_NUMBER = 300;
  public static final int FILE_MD5_FIELD_NUMBER = 101;
  public static final int FILE_NAME_FIELD_NUMBER = 102;
  public static final int FILE_SHA_FIELD_NUMBER = 103;
  public static final int FILE_SIZE_FIELD_NUMBER = 100;
  public static final int GROUP_USER = 1;
  public static final int NORMAL_USER = 0;
  public static final int SRC_BID_FIELD_NUMBER = 20;
  public static final int SRC_FILE_ID_FIELD_NUMBER = 31;
  public static final int SRC_GROUP_FIELD_NUMBER = 22;
  public static final int SRC_PDIR_KEY_FIELD_NUMBER = 30;
  public static final int SRC_UIN_FIELD_NUMBER = 21;
  public static final int USER_TYPE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field dst_bid = PBField.initUInt32(0);
  public final PBUInt64Field dst_uin = PBField.initUInt64(0L);
  public WeiyunPB.ExtensionReq extension_req = new WeiyunPB.ExtensionReq();
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField file_name = PBField.initString("");
  public final PBBytesField file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  public final PBUInt32Field src_bid = PBField.initUInt32(0);
  public final PBStringField src_file_id = PBField.initString("");
  public final PBUInt64Field src_group = PBField.initUInt64(0L);
  public final PBBytesField src_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field src_uin = PBField.initUInt64(0L);
  public final PBEnumField user_type = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160, 168, 176, 242, 250, 800, 810, 818, 826, 1600, 1608, 2402 }, new String[] { "user_type", "src_bid", "src_uin", "src_group", "src_pdir_key", "src_file_id", "file_size", "file_md5", "file_name", "file_sha", "dst_bid", "dst_uin", "extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, "", Long.valueOf(0L), localByteStringMicro2, "", localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), null }, CrossBidProxyCopyFileToOtherBidMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq
 * JD-Core Version:    0.7.0.1
 */