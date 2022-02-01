package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;

class VipFunCallPreviewActivity$4
  extends VipFunCallObserver
{
  VipFunCallPreviewActivity$4(VipFunCallPreviewActivity paramVipFunCallPreviewActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    Collections.sort(this.a.jdField_a_of_type_JavaUtilArrayList);
    this.a.c = this.a.jdField_a_of_type_JavaUtilArrayList.toString();
    this.a.a(false, 0);
    this.a.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      VipFunCallPreviewActivity.a(this.a, (Bundle)paramObject);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */