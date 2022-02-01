package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import java.util.ArrayList;

final class ViolaBizUtils$8
  extends ReadInJoyAtlasManager.AtlasCallbackImpl
{
  ViolaBizUtils$8(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      String str = ViolaBizUtils.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFavoriteStatus, isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", rowKey =  ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isFavorite = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", cidList = ");
      localStringBuilder.append(paramArrayList);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean1) {
      ReadInJoyAtlasManager.getInstance().doDeleteFavorite(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.getViolaInstance().getActivity(), this.jdField_a_of_type_JavaLangString, 0, paramString, paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.8
 * JD-Core Version:    0.7.0.1
 */