package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentHeaderNewSocial$MoreSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  private int jdField_a_of_type_Int = -1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  boolean jdField_a_of_type_Boolean;
  
  public ComponentHeaderNewSocial$MoreSpan(ComponentHeaderNewSocial paramComponentHeaderNewSocial, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (RIJItemViewTypeUtils.l(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0, false, 5, false);
      RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.a.a.c());
      return;
    }
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_a_of_type_Int;
    } else {
      i = -1;
    }
    paramTextPaint.bgColor = i;
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(2, 14, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial.MoreSpan
 * JD-Core Version:    0.7.0.1
 */