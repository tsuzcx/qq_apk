package com.tencent.mobileqq.troop.utils;

import aizs;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.text.MessageFormat;

public class SchoolTroopKeywordManager$SchoolTroopHighlightSpan
  extends ClickableSpan
  implements ActionSheet.OnButtonClickListener
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SchoolTroopKeywordManager.KeywordResult jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public SchoolTroopKeywordManager$SchoolTroopHighlightSpan(Context paramContext, SchoolTroopKeywordManager.KeywordResult paramKeywordResult)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult = paramKeywordResult;
    ReportController.b(null, "dc00899", "Grp_edu", "", "Grp_AIO", "GuideWords_Show", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_JavaLangString);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.b();
    Object localObject1 = localObject2;
    if (((String)localObject2).length() > 10) {
      localObject1 = ((String)localObject2).substring(0, 5) + "…" + ((String)localObject2).substring(((String)localObject2).length() - 5, ((String)localObject2).length());
    }
    localObject1 = MessageFormat.format(SchoolTroopKeywordManager.a()[this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int], new Object[] { localObject1 });
    localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968601, null);
    ((View)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837532));
    ((View)localObject2).setOnClickListener(new aizs(this));
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131362797);
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localObject1);
    localTextView.setContentDescription((CharSequence)localObject1);
    localTextView.setGravity(17);
    localTextView.setPadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b((View)localObject2);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(SchoolTroopKeywordManager.b()[this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int]);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = TroopLinkManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int != 1) {
        break label248;
      }
      paramView = ((TroopLinkManager)localObject).a("troop_homework_create_notice");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        TroopLinkManager.LinkParams localLinkParams = new TroopLinkManager.LinkParams();
        localLinkParams.a = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a;
        localLinkParams.c = "aio_keyword";
        localLinkParams.h = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_JavaLangString;
        localLinkParams.i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.b();
        paramView = ((TroopLinkManager)localObject).a(paramView, localLinkParams);
        if (QLog.isDevelopLevel()) {
          QLog.i(SchoolTroopKeywordManager.a, 2, "do action '" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "', open url: " + paramView);
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      ReportController.b(null, "dc00899", "Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      label248:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int == 2)
      {
        paramView = ((TroopLinkManager)localObject).a("troop_create_homework");
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e(SchoolTroopKeywordManager.a, 2, "I don't know this action '" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "'");
        }
        paramView = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (BubbleContextMenu.a)
    {
      if (QLog.isColorLevel()) {
        QLog.e(SchoolTroopKeywordManager.a, 2, "SchoolTroopHighlightSpan onCLick is invoked by LongClick misstake");
      }
      return;
    }
    if ((paramView instanceof ETTextView)) {
      ((ETTextView)paramView).c = true;
    }
    a();
    ReportController.b(null, "dc00899", "Grp_edu", "", "Grp_AIO", "GuideWords_Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan
 * JD-Core Version:    0.7.0.1
 */