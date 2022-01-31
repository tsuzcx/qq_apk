package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class C2CType0x211_SubC2CType0x8$NearfieldInfo
  extends MessageMicro
{
  public static final int BYTES_EXTRA_FIELD_NUMBER = 6;
  public static final int MSG_CONN_TYPE_FIELD_NUMBER = 2;
  public static final int MSG_IP_INFO_FIELD_NUMBER = 3;
  public static final int MSG_LBS_INFO_FIELD_NUMBER = 1;
  public static final int MSG_WIFI_ABI_FIELD_NUMBER = 5;
  public static final int MSG_WIFI_DETAIL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_extra = PBField.initBytes(ByteStringMicro.EMPTY);
  public C2CType0x211_SubC2CType0x8.ConnType msg_conn_type = new C2CType0x211_SubC2CType0x8.ConnType();
  public C2CType0x211_SubC2CType0x8.IPAddrInfo msg_ip_info = new C2CType0x211_SubC2CType0x8.IPAddrInfo();
  public C2CType0x211_SubC2CType0x8.LBSInfo msg_lbs_info = new C2CType0x211_SubC2CType0x8.LBSInfo();
  public C2CType0x211_SubC2CType0x8.WifiAbility msg_wifi_abi = new C2CType0x211_SubC2CType0x8.WifiAbility();
  public C2CType0x211_SubC2CType0x8.WifiDetailInfo msg_wifi_detail = new C2CType0x211_SubC2CType0x8.WifiDetailInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "msg_lbs_info", "msg_conn_type", "msg_ip_info", "msg_wifi_detail", "msg_wifi_abi", "bytes_extra" }, new Object[] { null, null, null, null, null, localByteStringMicro }, NearfieldInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.NearfieldInfo
 * JD-Core Version:    0.7.0.1
 */