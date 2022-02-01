package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class OpenSDKUtils$2
  implements ActionSheet.OnButtonClickListener
{
  OpenSDKUtils$2(ActionSheet paramActionSheet, int[] paramArrayOfInt, String paramString, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    default: 
      return;
    }
    paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    if ((!MobileIssueSettings.a) && (KapalaiAdapterUtil.a().a())) {
      KapalaiAdapterUtil.a().a(paramView);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCallFacade();
    long l = MessageCache.a();
    paramView.a(this.jdField_a_of_type_JavaLangString, 26, -1, l, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.OpenSDKUtils.2
 * JD-Core Version:    0.7.0.1
 */