package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan.Standard;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class CommentLinkItemView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseCommentData.CommentLinkData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData;
  private BaseCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public CommentLinkItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public CommentLinkItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public CommentLinkItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.jdField_a_of_type_AndroidContentContext, 2131562700, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)findViewById(2131369410));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379758));
  }
  
  private void a(int paramInt)
  {
    NativeReadInjoyImageView localNativeReadInjoyImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
    if (localNativeReadInjoyImageView != null)
    {
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      if (localContext == null) {
        return;
      }
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130842913));
              return;
            }
            localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2097479708));
            return;
          }
          localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130842917));
          return;
        }
        localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130842914));
        return;
      }
      localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130842916));
    }
  }
  
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (TextUtils.isEmpty(paramCommentLinkData.iconUrl))
    {
      QLog.d("CommentLinkItemView", 2, "createLinkItemView | mLinkData setDefaultIcon");
      a(paramCommentLinkData.type);
      return;
    }
    NativeReadInjoyImageView localNativeReadInjoyImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
    if (localNativeReadInjoyImageView != null) {
      localNativeReadInjoyImageView.setImageSrc(paramCommentLinkData.iconUrl);
    }
  }
  
  private void b(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramCommentLinkData != null))
    {
      paramCommentLinkData = new SpannableString(paramCommentLinkData.wording);
      paramCommentLinkData.setSpan(new LeadingMarginSpan.Standard(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), 0), 0, paramCommentLinkData.length(), 18);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCommentLinkData);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData, BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if ((paramCommentLinkData != null) && (paramBaseCommentData != null))
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData = paramBaseCommentData;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData = paramCommentLinkData;
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("createLinkItemView | mLinkData ");
      paramAbsBaseArticleInfo.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData);
      QLog.d("CommentLinkItemView", 2, paramAbsBaseArticleInfo.toString());
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData);
      b(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData);
      setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData;
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.linkUrl)))
    {
      paramView = new StringBuilder();
      paramView.append("linkItemView click url ");
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.linkUrl);
      QLog.d("CommentLinkItemView", 2, paramView.toString());
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.type == 4) {
        RIJJumpUtils.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.linkUrl, 2104, new CommentLinkItemView.1(this));
      } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.type == 5) {
        ReadInJoyCommentUtils.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.linkUrl, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType));
      } else {
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.linkUrl);
      }
      ReadInJoyCommentReportManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData$CommentLinkData.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkItemView
 * JD-Core Version:    0.7.0.1
 */