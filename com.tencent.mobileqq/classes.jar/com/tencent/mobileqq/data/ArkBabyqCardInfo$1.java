package com.tencent.mobileqq.data;

import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.qphone.base.util.QLog;

class ArkBabyqCardInfo$1
  implements ArkViewImplement.LoadCallback
{
  ArkBabyqCardInfo$1(ArkBabyqCardInfo paramArkBabyqCardInfo, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkAioContainerWrapper paramArkAioContainerWrapper, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attachArkView onLoadFinish ArkBabyqCardInfo state=");
      localStringBuilder.append(paramInt);
      QLog.d("ArkBabyqCardInfo", 2, localStringBuilder.toString());
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder, this.jdField_a_of_type_ComTencentMobileqqDataArkBabyqCardInfo);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkBabyqCardInfo.1
 * JD-Core Version:    0.7.0.1
 */