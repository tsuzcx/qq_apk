package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.BorderTextView;
import java.util.List;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements ComponentInheritView
{
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ComponentContentHotQuestion.1(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  BorderTextView jdField_a_of_type_ComTencentWidgetBorderTextView;
  TextView b;
  
  public ComponentContentHotQuestion(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560126, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368531));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131366263));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378784));
    this.b = ((TextView)paramView.findViewById(2131372043));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(HardCodeUtil.a(2131702473));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    b();
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramObject.a();
      NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localAbsBaseArticleInfo.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(localPackArticleInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localPackArticleInfo.jdField_a_of_type_JavaLangString);
      }
      if ((localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo != null) && (!TextUtils.isEmpty(localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.b)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.b);
      }
      if ((localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo != null) && (localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_a_of_type_Int >= 0))
      {
        this.b.setVisibility(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ReadInJoyHelper.b(localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_a_of_type_Int));
        if (TextUtils.isEmpty(localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_a_of_type_JavaLangString)) {
          paramObject = HardCodeUtil.a(2131702488);
        } else {
          paramObject = localPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_a_of_type_JavaLangString;
        }
        localStringBuilder.append(paramObject);
        paramObject = localStringBuilder.toString();
        this.b.setText(paramObject);
      }
      if (!TextUtils.isEmpty(localPackArticleInfo.h))
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(localPackArticleInfo.h);
        return;
      }
      if (localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12)
      {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(HardCodeUtil.a(2131702507));
        return;
      }
      if (localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 13) {
        this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(HardCodeUtil.a(2131702439));
      }
    }
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = AIOUtils.b(150.0F, getResources());
    localLayoutParams.height = AIOUtils.b(150.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */