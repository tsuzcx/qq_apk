package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class Oidb_0xcd1$GetPackageShopReq
  extends MessageMicro<GetPackageShopReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field client_source = PBField.initInt32(0);
  public final PBInt32Field portal_number = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "portal_number", "client_source" }, new Object[] { localInteger, localInteger }, GetPackageShopReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.GetPackageShopReq
 * JD-Core Version:    0.7.0.1
 */