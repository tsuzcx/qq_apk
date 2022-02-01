package com.tencent.mobileqq.data;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;
import com.tencent.qphone.base.util.QLog;

class MessageForArkApp$1
  implements ArkViewImplement.LoadCallback
{
  MessageForArkApp$1(MessageForArkApp paramMessageForArkApp, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkAioContainerWrapper paramArkAioContainerWrapper, ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean) {}
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForArkApp", 2, new Object[] { "ArkFold.attachArkView onLoadFinish MessageForArkApp state=", Integer.valueOf(paramInt), ",app=", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName });
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.b.setVisibility(8);
    if (paramInt == 1)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper.getContainerRect();
      float f = ArkAppCenterUtil.a();
      paramInt = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
      int i = (int)(f * (((Rect)localObject).bottom - ((Rect)localObject).top));
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      if (ArkAppCenterUtil.a)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.a.getLayoutParams();
        QLog.d("MessageForArkApp", 2, new Object[] { "ArkFold.attachArkView.onLoadFinish arkContainer rect(", Integer.valueOf(paramInt), ",", Integer.valueOf(i), "), arkView rect(", Integer.valueOf(((ViewGroup.LayoutParams)localObject).width), ",", Integer.valueOf(((ViewGroup.LayoutParams)localObject).height), "),app=", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAioContainerWrapper, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForArkApp.1
 * JD-Core Version:    0.7.0.1
 */