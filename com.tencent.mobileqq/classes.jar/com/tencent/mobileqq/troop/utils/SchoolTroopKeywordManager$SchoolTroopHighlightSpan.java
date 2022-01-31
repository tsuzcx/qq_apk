package com.tencent.mobileqq.troop.utils;

import ajvi;
import ajvj;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final SchoolTroopKeywordManager.KeywordResult jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  
  public SchoolTroopKeywordManager$SchoolTroopHighlightSpan(QQAppInterface paramQQAppInterface, Context paramContext, SchoolTroopKeywordManager.KeywordResult paramKeywordResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult = paramKeywordResult;
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Show", 0, 0);
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
    ((View)localObject2).setOnClickListener(new ajvj(this));
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131362820);
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
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    ThreadManager.excute(new ajvi(this, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2), 32, null, true);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    TroopLinkManager localTroopLinkManager;
    if (paramInt == 0)
    {
      localObject = null;
      localTroopLinkManager = TroopLinkManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int != 1) {
        break label201;
      }
      paramView = localTroopLinkManager.a("troop_homework_create_notice");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        localObject = new TroopLinkManager.LinkParams();
        ((TroopLinkManager.LinkParams)localObject).a = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a;
        ((TroopLinkManager.LinkParams)localObject).c = "aio_keyword";
        ((TroopLinkManager.LinkParams)localObject).h = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_JavaLangString;
        ((TroopLinkManager.LinkParams)localObject).i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.b();
        paramView = localTroopLinkManager.a(paramView, (TroopLinkManager.LinkParams)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i(SchoolTroopKeywordManager.a, 2, "do action '" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "', open url: " + paramView);
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      a("Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0);
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      label201:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int == 2)
      {
        paramView = localTroopLinkManager.a("troop_create_homework");
      }
      else
      {
        paramView = (View)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e(SchoolTroopKeywordManager.a, 2, "I don't know this action '" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int + "'");
          paramView = (View)localObject;
        }
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
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Clk", 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan
 * JD-Core Version:    0.7.0.1
 */