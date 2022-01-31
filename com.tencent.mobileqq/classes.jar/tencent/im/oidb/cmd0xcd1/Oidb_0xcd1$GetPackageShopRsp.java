package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0xcd1$GetPackageShopRsp
  extends MessageMicro<GetPackageShopRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_stock", "empty_package_page" }, new Object[] { null, null }, GetPackageShopRsp.class);
  public Oidb_0xcd1.EmptyPackagePage empty_package_page = new Oidb_0xcd1.EmptyPackagePage();
  public final PBRepeatMessageField<Oidb_0xcd1.StockItem> msg_stock = PBField.initRepeatMessage(Oidb_0xcd1.StockItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.GetPackageShopRsp
 * JD-Core Version:    0.7.0.1
 */