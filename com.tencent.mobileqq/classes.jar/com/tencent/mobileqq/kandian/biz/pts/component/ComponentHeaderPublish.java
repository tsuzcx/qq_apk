package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;

public class ComponentHeaderPublish
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  RingAvatarView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView;
  public ReadInJoyYAFolderTextView a;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  public boolean a;
  private TextView b;
  public boolean b;
  public boolean c = false;
  
  public ComponentHeaderPublish(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSubscribeID);
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 0L;
  }
  
  private void d()
  {
    long l = a();
    if (l != 0L)
    {
      if (RIJQQAppInterfaceUtil.a()) {
        this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(l), 1));
      } else {
        this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(l));
      }
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setOnClickListener(this);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(RIJStringUtils.a(localAbsBaseArticleInfo.mSubscribeName));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((localAbsBaseArticleInfo.mSocialFeedInfo != null) && (RIJItemViewTypeUtils.a(localAbsBaseArticleInfo)) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a == 1))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      if (ComponentPolymericView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
      }
      else if ((TextUtils.isEmpty(localAbsBaseArticleInfo.mSummary)) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(7);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpanText(HardCodeUtil.a(2131702519));
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMoreSpan(new ComponentHeaderPublish.1(this));
        Object localObject1;
        Object localObject2;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = new SpannableStringBuilder();
          if ((localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null))
          {
            ((SpannableStringBuilder)localObject1).append(localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Comment String: ");
              ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a);
              QLog.d("Q.readinjoy.ui", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else if (localAbsBaseArticleInfo.mTitle != null)
          {
            ((SpannableStringBuilder)localObject1).append(localAbsBaseArticleInfo.mTitle);
          }
          localObject2 = HardCodeUtil.a(2131702503);
          ((SpannableStringBuilder)localObject1).append(" ");
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
          ComponentAccountSummary.ReadArticleSpan localReadArticleSpan = new ComponentAccountSummary.ReadArticleSpan(localAbsBaseArticleInfo, -3355444, getContext(), getResources(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt);
          localReadArticleSpan.a = 17;
          ((SpannableStringBuilder)localObject1).setSpan(localReadArticleSpan, ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
          ((SpannableStringBuilder)localObject1).append(" ");
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
          ((ReadInJoyYAFolderTextView)localObject2).jdField_a_of_type_Boolean = true;
          ((ReadInJoyYAFolderTextView)localObject2).setText((CharSequence)localObject1);
        }
        else if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setHeight(0);
        }
        else if (this.c)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
          if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mTitle)) {
            localObject1 = localAbsBaseArticleInfo.mTitle;
          } else {
            localObject1 = localAbsBaseArticleInfo.mSummary;
          }
          ((ReadInJoyYAFolderTextView)localObject2).setText((CharSequence)localObject1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(localAbsBaseArticleInfo.mSummary);
        }
      }
      if (localAbsBaseArticleInfo.mTime > 0L) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(localAbsBaseArticleInfo.mTime, true));
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131702482));
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setVisibility(8);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(a());
      String str1 = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.k);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(str1.getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject);
      String str2 = RIJTransMergeKanDianReport.a("4", localAbsBaseArticleInfo, a());
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c())) {
        localObject = "0X800935C";
      } else {
        localObject = "0X8007BA3";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      long l1 = localAbsBaseArticleInfo.mFeedId;
      long l2 = localAbsBaseArticleInfo.mArticleID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, (String)localObject, (String)localObject, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str2, false);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560146, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((RIJQQAppInterfaceUtil.a()) && (a() == paramLong)) {
      this.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363135));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371877));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378688));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = ((ReadInJoyYAFolderTextView)findViewById(2131365536));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376025);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView = ((RingAvatarView)findViewById(2131375988));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369505));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    d();
    UtilsForComponent.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRingAvatarView, this.jdField_a_of_type_AndroidWidgetImageView);
    e();
    f();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131363135) && (i != 2131371877) && (i != 2131378688)) {
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPublish
 * JD-Core Version:    0.7.0.1
 */