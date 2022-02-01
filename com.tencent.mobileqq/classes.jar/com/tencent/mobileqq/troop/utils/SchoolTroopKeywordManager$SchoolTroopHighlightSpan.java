package com.tencent.mobileqq.troop.utils;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null));
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.b();
    localObject1 = localObject2;
    if (((String)localObject2).length() > 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 5));
      ((StringBuilder)localObject1).append("…");
      ((StringBuilder)localObject1).append(((String)localObject2).substring(((String)localObject2).length() - 5, ((String)localObject2).length()));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject1 = MessageFormat.format(SchoolTroopKeywordManager.a()[this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int], new Object[] { localObject1 });
    localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558469, null);
    ((View)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837659));
    ((View)localObject2).setOnClickListener(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.2(this));
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131362003);
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localObject1);
    localTextView.setContentDescription((CharSequence)localObject1);
    localTextView.setGravity(17);
    localTextView.setPadding(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addViewCustomeTitle((View)localObject2);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(SchoolTroopKeywordManager.b()[this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int]);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(HardCodeUtil.a(2131713490));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    ThreadManager.excute(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1(this, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2), 32, null, true);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject1 = null;
      Object localObject2 = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int == 1)
      {
        paramView = ((ITroopLinkApi)localObject2).getUrl("troop_homework_create_notice");
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int == 2)
      {
        paramView = ((ITroopLinkApi)localObject2).getUrl("troop_create_homework");
      }
      else
      {
        paramView = (View)localObject1;
        if (QLog.isColorLevel())
        {
          paramView = SchoolTroopKeywordManager.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("I don't know this action '");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int);
          localStringBuilder.append("'");
          QLog.e(paramView, 2, localStringBuilder.toString());
          paramView = (View)localObject1;
        }
      }
      if (!TextUtils.isEmpty(paramView))
      {
        localObject1 = new ITroopLinkApi.LinkParams();
        ((ITroopLinkApi.LinkParams)localObject1).a = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.a;
        ((ITroopLinkApi.LinkParams)localObject1).c = "aio_keyword";
        ((ITroopLinkApi.LinkParams)localObject1).h = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_JavaLangString;
        ((ITroopLinkApi.LinkParams)localObject1).i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.b();
        paramView = ((ITroopLinkApi)localObject2).replaceParams(paramView, (ITroopLinkApi.LinkParams)localObject1);
        if (QLog.isDevelopLevel())
        {
          localObject1 = SchoolTroopKeywordManager.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("do action '");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$KeywordResult.jdField_b_of_type_Int);
          ((StringBuilder)localObject2).append("', open url: ");
          ((StringBuilder)localObject2).append(paramView);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      }
      a("Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0);
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramView != null) {
      paramView.dismiss();
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
      ((ETTextView)paramView).mHasClickedArkSpan = true;
    }
    a();
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Clk", 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan
 * JD-Core Version:    0.7.0.1
 */