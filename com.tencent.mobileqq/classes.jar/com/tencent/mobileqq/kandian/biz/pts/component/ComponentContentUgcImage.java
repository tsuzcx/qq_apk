package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.IconWordingInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, ComponentInheritView
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  private URL jdField_a_of_type_JavaNetURL;
  
  public ComponentContentUgcImage(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentUgcImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return "";
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.d != null) && (paramAbsBaseArticleInfo.d.trim().length() > 0)) {
        return paramAbsBaseArticleInfo.d;
      }
    }
    return "";
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.d() == 80) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.d() == 81);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
    {
      ArrayList localArrayList = new ArrayList();
      String str1 = ((UGCPicInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.get(0)).jdField_b_of_type_JavaLangString;
      Object localObject = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (str1.contains("https")) {
          localObject = str1.replaceFirst("https", "http");
        }
      }
      localArrayList.add(localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      if (RIJFeedsType.t((AbsBaseArticleInfo)localObject))
      {
        str1 = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.f;
        String str2 = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_b_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a() != null)) {
          TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (AbsBaseArticleInfo)localObject, "");
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a() != null))
      {
        TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "info is null");
    }
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null))
    {
      if (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo == null) {
        return;
      }
      localObject = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_c_of_type_JavaLangString;
      if (localObject != null)
      {
        ReadInJoyUtils.a(getContext(), (String)localObject);
        RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpUrl is ");
      localStringBuilder.append((String)localObject);
      QLog.d("ComponentContentUgcImage", 2, localStringBuilder.toString());
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560433, this, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131380116));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131380117));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364408));
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
    if (paramView != null) {
      paramView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
    {
      if (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.size() == 0) {
        return;
      }
      String str = ((UGCPicInfo)paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a.get(0)).jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        paramIReadInJoyModel = new StringBuilder();
        paramIReadInJoyModel.append("thumb url is ");
        paramIReadInJoyModel.append(str);
        QLog.d("ComponentContentUgcImage", 2, paramIReadInJoyModel.toString());
      }
      paramIReadInJoyModel = str;
      if (!TextUtils.isEmpty(str))
      {
        paramIReadInJoyModel = str;
        if (str.contains("https")) {
          paramIReadInJoyModel = str.replaceFirst("https", "http");
        }
      }
      paramIReadInJoyModel = RIJConvertString2URL.a(paramIReadInJoyModel);
      PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramIReadInJoyModel, new ComponentContentUgcImage.1(this, paramIReadInJoyModel));
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      b();
      a(paramObject);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
    {
      Object localObject1 = getResources().getDisplayMetrics();
      int j = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
      int k = AIOUtils.b(12.0F, getResources());
      int i = AIOUtils.b(4.5F, getResources());
      int m = k * 2;
      k = (j - (i * 2 + m)) / 3 * 2 + i;
      m = (j - (m + i)) / 2;
      float f1 = k;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a;
      float f2;
      if (((List)localObject1).size() > 0)
      {
        float f4 = ((UGCPicInfo)((List)localObject1).get(0)).a;
        float f3 = ((UGCPicInfo)((List)localObject1).get(0)).jdField_b_of_type_Int;
        f1 = f4;
        f2 = f3;
        if (((UGCPicInfo)((List)localObject1).get(0)).jdField_c_of_type_Int == 1)
        {
          i = 1;
          f1 = f4;
          f2 = f3;
          break label272;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ComponentContentUgcImage", 2, "ugc pic info is null");
        }
        f2 = f1;
      }
      i = 0;
      label272:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
      f1 /= f2;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView;
      if (localObject2 != null)
      {
        double d = f1;
        if (d < 0.455D)
        {
          ((ViewGroup.LayoutParams)localObject1).width = m;
          ((ViewGroup.LayoutParams)localObject1).height = k;
          ((KanDianRoundCornerTextView)localObject2).setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(getResources().getText(2131718071));
        }
        else if ((0.455D <= d) && (d <= 0.7441D))
        {
          ((ViewGroup.LayoutParams)localObject1).width = m;
          ((ViewGroup.LayoutParams)localObject1).height = k;
          ((KanDianRoundCornerTextView)localObject2).setVisibility(4);
        }
        else if ((0.7441D <= d) && (d <= 1.3439D))
        {
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = k;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(4);
        }
        else if (a())
        {
          ((ViewGroup.LayoutParams)localObject1).width = -1;
          ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.b(190.0F, getResources());
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(4);
        }
        else if ((1.3439D <= d) && (d <= 2.2D))
        {
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = m;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(4);
        }
        else
        {
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = m;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(getResources().getText(2131718071));
        }
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(2131718070);
        }
        if (RIJFeedsType.s(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(HardCodeUtil.a(2131702472));
        }
        else if (a())
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo;
          if (localObject2 != null)
          {
            if ((!TextUtils.isEmpty(((IconWordingInfo)localObject2).d)) && (!TextUtils.isEmpty(((IconWordingInfo)localObject2).jdField_c_of_type_JavaLangString)))
            {
              this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setText(((IconWordingInfo)localObject2).d);
              Drawable localDrawable = DrawableUtil.getDrawable(getContext(), ((IconWordingInfo)localObject2).jdField_c_of_type_JavaLangString, null, null);
              if (localDrawable != null)
              {
                localDrawable.setBounds(0, 0, AIOUtils.b(12.0F, getResources()), AIOUtils.b(12.0F, getResources()));
                this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawables(localDrawable, null, null, null);
              }
            }
            if (((IconWordingInfo)localObject2).jdField_c_of_type_Int == 1)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843373);
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianRoundCornerTextView.setCompoundDrawables(null, null, null, null);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mChannelID == 0L)
      {
        i = ReadInJoyDisplayUtils.a(j, getResources());
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = i;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("main feeds | ivWidth is ");
        ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).width);
        ((StringBuilder)localObject2).append("; ivHeight is ");
        ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).height);
        QLog.d("ComponentContentUgcImage", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("imageParams.width is ");
      ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).width);
      ((StringBuilder)localObject2).append("; imageParams.height is ");
      ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject1).height);
      QLog.d("ComponentContentUgcImage", 2, ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setPadding(0, 0, 0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "info is null");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131380116) {
      return;
    }
    if (a())
    {
      d();
      return;
    }
    RIJFrameworkReportManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
    if (RIJFeedsType.s(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()))
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        RIJJumpUtils.b(getContext(), (String)localObject);
        return;
      }
    }
    c();
    Object localObject = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
  }
  
  public void setPicClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcImage
 * JD-Core Version:    0.7.0.1
 */