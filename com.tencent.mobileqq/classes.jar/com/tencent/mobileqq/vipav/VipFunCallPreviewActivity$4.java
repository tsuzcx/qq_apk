package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import java.util.ArrayList;
import java.util.Collections;

class VipFunCallPreviewActivity$4
  extends VipFunCallObserver
{
  VipFunCallPreviewActivity$4(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        return;
      }
      Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList);
      VipFunCallPreviewActivity localVipFunCallPreviewActivity = this.a;
      localVipFunCallPreviewActivity.c = localVipFunCallPreviewActivity.jdField_a_of_type_JavaUtilArrayList.toString();
      this.a.a(false, 0);
      localVipFunCallPreviewActivity = this.a;
      localVipFunCallPreviewActivity.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        VipFunCallPreviewActivity.a(localVipFunCallPreviewActivity, (Bundle)paramObject);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */