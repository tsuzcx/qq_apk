package com.tencent.mobileqq.text.style;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class LinkSpan$1
  implements ActionSheet.OnButtonClickListener
{
  LinkSpan$1(LinkSpan paramLinkSpan, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, int paramInt2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A926", "0X800A926", this.jdField_a_of_type_Int, 0, "", "", "", "");
      LinkSpan.a("2", "1");
      continue;
      TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A927", "0X800A927", this.jdField_a_of_type_Int, 0, "", "", "", "");
      continue;
      if (this.b == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.jdField_a_of_type_JavaLangString)), this.jdField_a_of_type_AndroidContentContext.getString(2131693916));
        paramView.putExtra("big_brother_source_key", LinkSpan.a(this.jdField_a_of_type_ComTencentMobileqqTextStyleLinkSpan));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92D", "0X800A92D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
        paramView.putExtra("big_brother_source_key", LinkSpan.a(this.jdField_a_of_type_ComTencentMobileqqTextStyleLinkSpan));
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92A", "0X800A92A", this.jdField_a_of_type_Int, 0, "", "", "", "");
        LinkSpan.a("1", "2");
        continue;
        LinkSpan.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92B", "0X800A92B", this.jdField_a_of_type_Int, 0, "", "", "", "");
        LinkSpan.b("0X800A00A", "0X800A00A");
        continue;
        ProfileCardUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_JavaLangString);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A92C", "0X800A92C", this.jdField_a_of_type_Int, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan.1
 * JD-Core Version:    0.7.0.1
 */