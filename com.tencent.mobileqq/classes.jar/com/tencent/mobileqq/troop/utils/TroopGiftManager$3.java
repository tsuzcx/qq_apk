package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockRsp;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ImgShowConfig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ImgShowItem;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.RspBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.StockInfo;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.StockItem;

class TroopGiftManager$3
  extends ProtoUtils.TroopGiftProtocolObserver
{
  TroopGiftManager$3(TroopGiftManager paramTroopGiftManager, TroopGiftCallback paramTroopGiftCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback != null)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new oidb_0x6c3.RspBody();
        ((oidb_0x6c3.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        paramInt = ((oidb_0x6c3.RspBody)localObject1).int32_ret.get();
        if ((paramInt == 0) && (paramBundle != null))
        {
          paramInt = paramBundle.getInt("subCmd");
          if (((paramInt != 0) && (paramInt != 2) && (paramInt != 7)) || (!((oidb_0x6c3.RspBody)localObject1).msg_get_stock.has())) {
            break label697;
          }
          paramArrayOfByte = (oidb_0x6c3.GetStockRsp)((oidb_0x6c3.RspBody)localObject1).msg_get_stock.get();
          paramBundle = new ArrayList(10);
          boolean bool = paramArrayOfByte.msg_stock.has();
          int i = 0;
          Object localObject2;
          if (bool)
          {
            localObject1 = (oidb_0x6c3.StockInfo)paramArrayOfByte.msg_stock.get();
            if (((oidb_0x6c3.StockInfo)localObject1).msg_stock.has())
            {
              localObject1 = ((oidb_0x6c3.StockInfo)localObject1).msg_stock.get();
              paramInt = 0;
              if (paramInt < ((List)localObject1).size())
              {
                localObject2 = (oidb_0x6c3.StockItem)((List)localObject1).get(paramInt);
                TroopGiftManager.GiveGift localGiveGift = new TroopGiftManager.GiveGift();
                localGiveGift.jdField_a_of_type_Int = ((oidb_0x6c3.StockItem)localObject2).int32_productid.get();
                localGiveGift.b = ((oidb_0x6c3.StockItem)localObject2).int32_amount.get();
                localGiveGift.c = ((oidb_0x6c3.StockItem)localObject2).int32_free_limit_chance.get();
                paramBundle.add(localGiveGift);
                paramInt += 1;
                continue;
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.int32_count.get(), paramArrayOfByte.int32_give_count.get(), paramArrayOfByte.bytes_give_info.get().toStringUtf8(), paramBundle);
          paramBundle = new SparseArray();
          if (paramArrayOfByte.msg_imgshow_config.has())
          {
            int j = paramArrayOfByte.msg_imgshow_config.msg_imgshow_item.size();
            paramInt = i;
            if (paramInt < j)
            {
              localObject1 = (oidb_0x6c3.ImgShowItem)paramArrayOfByte.msg_imgshow_config.msg_imgshow_item.get(paramInt);
              localObject2 = new TroopGiftManager.ShowPicPrice();
              ((TroopGiftManager.ShowPicPrice)localObject2).jdField_a_of_type_Int = ((oidb_0x6c3.ImgShowItem)localObject1).uint32_price.get();
              ((TroopGiftManager.ShowPicPrice)localObject2).jdField_a_of_type_JavaLangString = ((oidb_0x6c3.ImgShowItem)localObject1).bytes_wording.get().toStringUtf8();
              ((TroopGiftManager.ShowPicPrice)localObject2).b = ((oidb_0x6c3.ImgShowItem)localObject1).bytes_cut_wording.get().toStringUtf8();
              paramBundle.put(((oidb_0x6c3.ImgShowItem)localObject1).uint32_productid.get(), localObject2);
              paramInt += 1;
              continue;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramBundle);
          return;
          if (((oidb_0x6c3.RspBody)localObject1).msg_extra_data.has())
          {
            paramArrayOfByte = (oidb_0x6c3.GetExtraDataRsp)((oidb_0x6c3.RspBody)localObject1).msg_extra_data.get();
            paramBundle = TroopGiftAioPanelData.a(((oidb_0x6c3.RspBody)localObject1).exclusive_gift_list.get());
            paramInt = ((oidb_0x6c3.RspBody)localObject1).msg_extra_data.int32_version_seq.get();
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.bytes_shop_config.get().toStringUtf8(), paramInt);
            this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramArrayOfByte.bytes_shop_config.get().toStringUtf8(), paramInt, paramBundle);
            return;
          }
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback;
          paramBundle = new StringBuilder();
          paramBundle.append("Invalid RspData. subCmd:");
          paramBundle.append(paramInt);
          paramArrayOfByte.a(-1, paramBundle.toString());
          return;
        }
        paramArrayOfByte = ((oidb_0x6c3.RspBody)localObject1).bytes_msg.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(paramInt, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("send_oidb_0x6c3. InvalidProtocolBufferMicroException:");
          paramBundle.append(paramArrayOfByte);
          QLog.i(".troop.send_gift", 2, paramBundle.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("send_oidb_0x6c3. onResult error=");
        paramBundle.append(paramInt);
        paramBundle.append(" data=");
        paramBundle.append(paramArrayOfByte);
        paramBundle.append(" callback=");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback);
        QLog.i(".troop.send_gift", 2, paramBundle.toString());
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGiftCallback;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(paramInt, "sso request error or callback is null.");
      }
      return;
      label697:
      if ((paramInt != 1) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 8) && (paramInt != 9)) {
        if (paramInt != 10) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftManager.3
 * JD-Core Version:    0.7.0.1
 */