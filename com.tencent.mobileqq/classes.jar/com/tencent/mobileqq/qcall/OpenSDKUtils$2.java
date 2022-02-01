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
    if (this.jdField_a_of_type_ArrayOfInt[paramInt] != 1) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append("tel:");
    paramView.append(this.jdField_a_of_type_JavaLangString);
    paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
    if ((!MobileIssueSettings.a) && (KapalaiAdapterUtil.a().a())) {
      KapalaiAdapterUtil.a().a(paramView);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCallFacade();
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_JavaLangString;
    paramView.a(str, 26, -1, l, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.OpenSDKUtils.2
 * JD-Core Version:    0.7.0.1
 */