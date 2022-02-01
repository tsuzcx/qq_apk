package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class ComponentAccountSummary
  extends FrameLayout
  implements ComponentView
{
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  
  public ComponentAccountSummary(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    b(paramContext);
  }
  
  private String a(@NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    String str = paramIReadInJoyModel.a().mSummary;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.c()) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.g())) {
      str = paramIReadInJoyModel.a().mTitle;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    if (paramIReadInJoyModel.d() == 33) {
      return HardCodeUtil.a(2131702513);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.b()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.d()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.e()))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.c()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.g()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.h()) {
          return HardCodeUtil.a(2131702504);
        }
        return HardCodeUtil.a(2131702518);
      }
      return HardCodeUtil.a(2131702493);
    }
    return HardCodeUtil.a(2131702516);
  }
  
  private void a(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null))
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Comment String: ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a);
      QLog.d("Q.readinjoy.ui", 2, ((StringBuilder)localObject).toString());
    }
    else if (paramAbsBaseArticleInfo.mTitle != null)
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    }
    Object localObject = HardCodeUtil.a(2131702475);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append((CharSequence)localObject);
    localSpannableStringBuilder.setSpan(new ComponentAccountSummary.ReadArticleSpan(paramAbsBaseArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt), localSpannableStringBuilder.length() - ((String)localObject).length(), localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.append(localSpannableStringBuilder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.jdField_a_of_type_Boolean = true;
  }
  
  private void a(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    if ((paramIReadInJoyModel.d() == 33) && (paramIReadInJoyModel.a().mSocialFeedInfo != null) && (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo != null))
    {
      if (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.b == 0L)
      {
        String str = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a;
        paramIReadInJoyModel = paramString;
        paramString = str;
      }
      else
      {
        paramString = String.valueOf(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.b);
        if (RIJQQAppInterfaceUtil.a()) {
          paramIReadInJoyModel = ContactUtils.a((QQAppInterface)ReadInJoyUtils.a(), paramString, true);
        } else {
          paramIReadInJoyModel = ((ReadInJoyBaseAdapter)paramIReadInJoyModel.a()).a(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.b);
        }
      }
      paramSpannableStringBuilder.append(paramIReadInJoyModel);
      paramSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, paramString, -3355444), 0, paramIReadInJoyModel.length(), 33);
    }
    else if (paramIReadInJoyModel.a().mAccountLess == 0)
    {
      paramIReadInJoyModel = paramIReadInJoyModel.a().mSubscribeID;
      paramSpannableStringBuilder.append(paramString);
      paramSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, paramIReadInJoyModel, -3355444), 0, paramString.length(), 33);
    }
    else
    {
      paramSpannableStringBuilder.append(paramString);
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramString.length(), 33);
    }
    paramSpannableStringBuilder.append(": ");
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null))
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Comment String: ");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
    }
    else if (paramAbsBaseArticleInfo.mTitle != null)
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    }
    paramSpannableStringBuilder.append(localSpannableStringBuilder);
  }
  
  private void b(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((!this.jdField_a_of_type_Boolean) && (!this.b))
    {
      if (this.c)
      {
        b(paramSpannableStringBuilder, paramIReadInJoyModel);
        return;
      }
      paramSpannableStringBuilder.append(paramString);
      return;
    }
    a(paramSpannableStringBuilder, paramIReadInJoyModel);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131560155, this, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365055));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof IReadInJoyModel)) {
      return;
    }
    paramObject = (IReadInJoyModel)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
    if (paramObject.a() == null) {
      return;
    }
    String str1 = paramObject.a().mSubscribeName;
    String str2 = a(paramObject);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(paramObject, localSpannableStringBuilder, str1);
    b(paramObject, localSpannableStringBuilder, str2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702532));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(7);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentAccountSummary.MoreSpan(this, paramObject.a(), -3355444));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(localSpannableStringBuilder);
    b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */