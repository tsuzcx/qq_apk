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
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("send_iodb_oxcd1. onResult error=");
        paramBundle.append(paramInt);
        paramBundle.append(" data=");
        paramBundle.append(paramArrayOfByte);
        paramBundle.append(" callback=");
        paramBundle.append(this.b);
        QLog.i(".troop.send_gift", 2, paramBundle.toString());
      }
      paramArrayOfByte = this.b;
      paramBundle = new StringBuilder();
      paramBundle.append("errorCode=");
      paramBundle.append(paramInt);
      paramArrayOfByte.a(-1, paramBundle.toString());
      return;
    }
    Object localObject1 = new Oidb_0xcd1.RspBody();
    paramBundle = null;
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("send_iodb_oxcd1. onResult erro data=");
        paramArrayOfByte.append(null);
        QLog.i(".troop.send_gift", 2, paramArrayOfByte.toString());
      }
      return;
    }
    try
    {
      ((Oidb_0xcd1.RspBody)localObject1).mergeFrom(paramArrayOfByte);
      if (((Oidb_0xcd1.RspBody)localObject1).get_pack_rsp.has())
      {
        Object localObject2 = new Oidb_0xcd1.GetPackageShopRsp();
        ((Oidb_0xcd1.GetPackageShopRsp)localObject2).mergeFrom(((Oidb_0xcd1.GetPackageShopRsp)((Oidb_0xcd1.RspBody)localObject1).get_pack_rsp.get()).toByteArray());
        localObject1 = new ArrayList();
        if (((Oidb_0xcd1.GetPackageShopRsp)localObject2).msg_stock.has())
        {
          paramArrayOfByte = ((Oidb_0xcd1.GetPackageShopRsp)localObject2).msg_stock.get();
          paramInt = 0;
          while (paramInt < paramArrayOfByte.size())
          {
            Oidb_0xcd1.StockItem localStockItem = (Oidb_0xcd1.StockItem)paramArrayOfByte.get(paramInt);
            TroopGiftManager.PackGift localPackGift = new TroopGiftManager.PackGift();
            localPackGift.a = localStockItem.int32_productid.get();
            localPackGift.b = localStockItem.int32_amount.get();
            ((List)localObject1).add(localPackGift);
            paramInt += 1;
          }
        }
        paramArrayOfByte = paramBundle;
        if (((Oidb_0xcd1.GetPackageShopRsp)localObject2).empty_package_page.has())
        {
          localObject2 = (Oidb_0xcd1.EmptyPackagePage)((Oidb_0xcd1.GetPackageShopRsp)localObject2).empty_package_page.get();
          paramArrayOfByte = paramBundle;
          if (localObject2 != null) {
            paramArrayOfByte = new TroopGiftAioPanelData.EmptyPackagePage((Oidb_0xcd1.EmptyPackagePage)localObject2);
          }
        }
        if (this.b != null)
        {
          this.b.a((List)localObject1, paramArrayOfByte);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("send_iodb_oxcd1. InvalidProtocolBufferMicroException:");
        paramBundle.append(paramArrayOfByte);
        QLog.i(".troop.send_gift", 2, paramBundle.toString());
      }
      this.b.a(-1, "InvalidProtocolBufferMicroException");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.2
 * JD-Core Version:    0.7.0.1
 */