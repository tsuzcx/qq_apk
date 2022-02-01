package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniCardManager$1
  extends ProtoUtils.TroopProtocolObserver
{
  MiniCardManager$1(MiniCardManager paramMiniCardManager, boolean paramBoolean, IGetMiniCardCallback paramIGetMiniCardCallback, List paramList)
  {
    super(paramBoolean);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardIGetMiniCardCallback;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(paramInt, null, "Request error.");
      }
      return;
    }
    paramBundle = new NowSummaryCard.NearbyMiniCardRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle.mini_card.get();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMiniCardList size: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.size());
      ((StringBuilder)localObject).append(", retCode: ");
      ((StringBuilder)localObject).append(paramBundle.ret_code.get());
      QLog.d("MiniCardManager", 1, ((StringBuilder)localObject).toString());
      paramBundle = MiniCardManager.a();
      int i = 0;
      try
      {
        while (i < paramArrayOfByte.size())
        {
          localObject = (NowSummaryCard.MiniCard)paramArrayOfByte.get(i);
          MiniCardManager.a().put(String.valueOf(this.jdField_a_of_type_JavaUtilList.get(i)), localObject);
          i += 1;
        }
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardIGetMiniCardCallback;
        if (paramBundle != null) {
          paramBundle.a(paramInt, paramArrayOfByte, "");
        }
        return;
      }
      finally {}
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardIGetMiniCardCallback;
      if (paramBundle != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        paramBundle.a(1, null, ((StringBuilder)localObject).toString());
      }
      paramBundle = new StringBuilder();
      paramBundle.append("getMiniCardList error: ");
      paramBundle.append(paramArrayOfByte);
      QLog.e("MiniCardManager", 1, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.MiniCardManager.1
 * JD-Core Version:    0.7.0.1
 */