package com.tencent.mobileqq.simpleui;

import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;

final class SimpleUIProtocolUtil$1
  implements BusinessObserver
{
  SimpleUIProtocolUtil$1(String paramString, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      List localList = SimpleUIUtil.a();
      localList.clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        localList.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          SimpleUIUtil.e(paramInt);
        }
        paramInt += 1;
      }
      paramInt = SimpleUIUtil.a(this.jdField_a_of_type_JavaLangString);
      SimpleUIProtocolUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Boolean, 1);
      SimpleUIProtocolUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramInt, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil.1
 * JD-Core Version:    0.7.0.1
 */