package com.tencent.mobileqq.kandian.biz.pts.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentSmall;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentView;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.CellListener;
import com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem;
import com.tencent.mobileqq.kandian.glue.text.UserSpan;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class PgcSmallView
  extends RelativeLayout
  implements ComponentView
{
  int jdField_a_of_type_Int;
  ReadInJoyYAFolderTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
  ComponentContentSmall jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall;
  
  public PgcSmallView(int paramInt, Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(paramContext);
    b(paramContext);
  }
  
  public long a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      long l = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException paramAbsBaseArticleInfo)
    {
      label10:
      break label10;
    }
    return 0L;
  }
  
  public RelativeLayout.LayoutParams a(Context paramContext)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 10)
    {
      if (i != 12) {
        if ((i != 16) && (i != 20) && (i != 83) && (i != 86) && (i != 132))
        {
          if ((i != 74) && (i != 75))
          {
            if (i == 94) {
              break label119;
            }
            if (i != 95)
            {
              localLayoutParams = null;
              break label137;
            }
          }
        }
        else
        {
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(67.0F, paramContext.getResources()));
          break label137;
        }
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(67.0F, paramContext.getResources()));
      break label137;
    }
    label119:
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(67.0F, paramContext.getResources()));
    label137:
    i = AIOUtils.b(12.0F, paramContext.getResources());
    if (localLayoutParams != null) {
      localLayoutParams.setMargins(i, 0, i, 0);
    }
    return localLayoutParams;
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(a(paramContext));
    Object localObject = b(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall = new ComponentContentSmall(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.setId(1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.a().setScaleType(ImageView.ScaleType.FIT_XY);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.a().getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = -1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall);
    localObject = c(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView = new ReadInJoyYAFolderTextView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMaxLines(2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setSpanText("");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      if ((paramIReadInJoyModel.d() != 10) && (paramIReadInJoyModel.d() != 12))
      {
        if ((paramIReadInJoyModel.d() == 94) || (paramIReadInJoyModel.d() == 95))
        {
          paramSpannableStringBuilder.append("@");
          paramSpannableStringBuilder.append(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.d);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
          paramSpannableStringBuilder.append(": ");
        }
      }
      else
      {
        paramSpannableStringBuilder.append("@");
        String str = paramIReadInJoyModel.a().mSubscribeName;
        if (paramIReadInJoyModel.a().mAccountLess == 0)
        {
          long l = a(paramIReadInJoyModel.a());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new UserSpan(l, "2", paramIReadInJoyModel.a()), 0, paramSpannableStringBuilder.length(), 33);
        }
        else
        {
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
        }
        paramSpannableStringBuilder.append(": ");
      }
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)paramObject;
      if ((localIReadInJoyModel.d() != 20) && (localIReadInJoyModel.d() != 12) && (localIReadInJoyModel.d() != 86) && (localIReadInJoyModel.d() != 95))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.a(paramObject);
        int i = this.jdField_a_of_type_Int;
        if ((i != 74) && (i != 75))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.setLayoutParams(b(getContext()));
        }
        else
        {
          paramObject = QuestionCardProteusItem.a(localIReadInJoyModel.a());
          if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
          {
            i = AIOUtils.b(50.0F, getContext().getResources());
            paramObject = new RelativeLayout.LayoutParams(i, i);
            paramObject.setMargins(0, 0, AIOUtils.b(12.0F, getContext().getResources()), 0);
            paramObject.addRule(15);
            i = AIOUtils.b(12.0F, getContext().getResources());
            paramObject.setMargins(i, 0, i, 0);
            paramObject.addRule(11);
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.setLayoutParams(paramObject);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.setLayoutParams(b(getContext()));
          }
        }
      }
      if (localIReadInJoyModel.a() == null) {
        return;
      }
      paramObject = new SpannableStringBuilder();
      a(localIReadInJoyModel, paramObject);
      b(localIReadInJoyModel, paramObject);
    }
  }
  
  public RelativeLayout.LayoutParams b(Context paramContext)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 10) {
      if (i != 12)
      {
        if (i != 16)
        {
          if (i != 20)
          {
            if (i == 83) {
              break label100;
            }
            if (i != 86)
            {
              if (i == 132) {
                break label100;
              }
              if ((i == 74) || (i == 75) || (i == 94)) {
                break label154;
              }
              if (i != 95)
              {
                paramContext = null;
                break label182;
              }
            }
          }
          i = AIOUtils.b(67.0F, paramContext.getResources());
          paramContext = new RelativeLayout.LayoutParams(i, i);
          break label182;
        }
        label100:
        i = AIOUtils.b(67.0F, paramContext.getResources());
        paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(96.0F, paramContext.getResources()), i);
        break label182;
      }
      else
      {
        i = AIOUtils.b(67.0F, paramContext.getResources());
        paramContext = new RelativeLayout.LayoutParams(i, i);
        break label182;
      }
    }
    label154:
    i = AIOUtils.b(67.0F, paramContext.getResources());
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(96.0F, paramContext.getResources()), i);
    label182:
    if (paramContext != null) {
      paramContext.addRule(11);
    }
    return paramContext;
  }
  
  public void b(Context paramContext)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 10)
    {
      if (i != 12)
      {
        if (i != 16)
        {
          if (i != 20)
          {
            if (i == 83) {
              break label96;
            }
            if (i != 86)
            {
              if (i == 132) {
                break label96;
              }
              if ((i == 74) || (i == 75) || (i == 94)) {
                break label126;
              }
              if (i == 95) {
                break label105;
              }
              break label132;
            }
          }
          setBackgroundResource(2130842990);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.a().setImageResource(2130846091);
          break label132;
        }
        label96:
        setBackgroundResource(2130842990);
        break label132;
      }
      label105:
      setBackgroundResource(2130842990);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.a().setImageResource(2130846091);
      break label132;
    }
    label126:
    setBackgroundResource(2130842990);
    label132:
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setTextSize(0, Utils.dp2px(16.0D));
  }
  
  public void b(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      int i = paramSpannableStringBuilder.length() - 2;
      if (i < 0) {
        i = 0;
      }
      Object localObject = paramIReadInJoyModel.a().mTitle;
      if ((paramIReadInJoyModel.d() != 94) && (paramIReadInJoyModel.d() != 95))
      {
        if ((paramIReadInJoyModel.d() == 74) || (paramIReadInJoyModel.d() == 75)) {
          localObject = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.a;
        }
      }
      else {
        localObject = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.b;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSpannableStringBuilder.append((CharSequence)localObject);
      }
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      if (paramIReadInJoyModel.d() != 10) {
        paramIReadInJoyModel = (IReadInJoyModel)localObject;
      } else {
        paramIReadInJoyModel = new ForegroundColorSpan(Color.parseColor("#606060"));
      }
      paramSpannableStringBuilder.setSpan(paramIReadInJoyModel, i, paramSpannableStringBuilder.length(), 34);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setGravity(16);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public RelativeLayout.LayoutParams c(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentSmall.getId());
    int i = this.jdField_a_of_type_Int;
    if ((i != 10) && (i != 12)) {
      if ((i != 16) && (i != 20) && (i != 83) && (i != 86) && (i != 132))
      {
        if ((i != 74) && (i != 75) && (i != 94) && (i != 95)) {
          return localLayoutParams;
        }
      }
      else
      {
        localLayoutParams.setMargins(AIOUtils.b(12.0F, paramContext.getResources()), 0, AIOUtils.b(12.0F, paramContext.getResources()), 0);
        return localLayoutParams;
      }
    }
    localLayoutParams.setMargins(AIOUtils.b(12.0F, paramContext.getResources()), 0, AIOUtils.b(12.0F, paramContext.getResources()), 0);
    return localLayoutParams;
  }
  
  public void setTitleCustomStyle(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setTitleCustomStyle | fontSize : ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("; fontColor : ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("; linkTextColor : ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("; lineSpace : ");
    ((StringBuilder)localObject).append(paramInt4);
    QLog.d("PgcSmallView", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView;
    if (localObject != null)
    {
      if (paramInt1 > 0) {
        ((ReadInJoyYAFolderTextView)localObject).setTextSize(paramInt1);
      }
      if (paramInt2 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setTextColor(paramInt2);
      }
      if (paramInt3 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setLinkedTextColor(paramInt3);
      }
      if (paramInt4 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyYAFolderTextView.setLineSpacing(paramInt4, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */