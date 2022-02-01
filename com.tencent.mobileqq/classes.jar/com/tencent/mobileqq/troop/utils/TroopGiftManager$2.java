package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.biz.troopgift.TroopGiftAioPanelData.EmptyPackagePage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.EmptyPackagePage;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.GetPackageShopRsp;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.RspBody;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.StockItem;

class TroopGiftManager$2
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$2(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "errorCode=" + paramInt);
    }
    do
    {
      return;
      paramBundle = new Oidb_0xcd1.RspBody();
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. onResult erro data=" + null);
    return;
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.get_pack_rsp.has()) {
          break;
        }
        paramArrayOfByte = new Oidb_0xcd1.GetPackageShopRsp();
        paramArrayOfByte.mergeFrom(((Oidb_0xcd1.GetPackageShopRsp)paramBundle.get_pack_rsp.get()).toByteArray());
        paramBundle = new ArrayList();
        if (paramArrayOfByte.msg_stock.has())
        {
          List localList = paramArrayOfByte.msg_stock.get();
          paramInt = 0;
          if (paramInt < localList.size())
          {
            Oidb_0xcd1.StockItem localStockItem = (Oidb_0xcd1.StockItem)localList.get(paramInt);
            TroopGiftManager.PackGift localPackGift = new TroopGiftManager.PackGift();
            localPackGift.a = localStockItem.int32_productid.get();
            localPackGift.b = localStockItem.int32_amount.get();
            paramBundle.add(localPackGift);
            paramInt += 1;
            continue;
          }
        }
        if (paramArrayOfByte.empty_package_page.has())
        {
          paramArrayOfByte = (Oidb_0xcd1.EmptyPackagePage)paramArrayOfByte.empty_package_page.get();
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = new TroopGiftAioPanelData.EmptyPackagePage(paramArrayOfByte);
            if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramBundle, paramArrayOfByte);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
      paramArrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.2
 * JD-Core Version:    0.7.0.1
 */