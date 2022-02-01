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
  ComponentContentSmall a;
  ReadInJoyYAFolderTextView b;
  int c;
  
  public PgcSmallView(int paramInt, Context paramContext)
  {
    super(paramContext);
    this.c = paramInt;
    a(paramContext);
    e(paramContext);
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
  
  public void a(Context paramContext)
  {
    setLayoutParams(b(paramContext));
    Object localObject = c(paramContext);
    this.a = new ComponentContentSmall(paramContext);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setId(1);
    this.a.getImageView().setScaleType(ImageView.ScaleType.FIT_XY);
    ViewGroup.LayoutParams localLayoutParams = this.a.getImageView().getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-1, -1);
    }
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = -1;
    this.a.getImageView().setLayoutParams((ViewGroup.LayoutParams)localObject);
    addView(this.a);
    localObject = d(paramContext);
    this.b = new ReadInJoyYAFolderTextView(paramContext);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setMaxLines(2);
    this.b.setSpanText("");
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    addView(this.b);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramIReadInJoyModel.k() == null) {
        return;
      }
      if ((paramIReadInJoyModel.o() != 10) && (paramIReadInJoyModel.o() != 12))
      {
        if ((paramIReadInJoyModel.o() == 94) || (paramIReadInJoyModel.o() == 95))
        {
          paramSpannableStringBuilder.append("@");
          paramSpannableStringBuilder.append(paramIReadInJoyModel.k().mSocialFeedInfo.E.d);
          paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramSpannableStringBuilder.length(), 33);
          paramSpannableStringBuilder.append(": ");
        }
      }
      else
      {
        paramSpannableStringBuilder.append("@");
        String str = paramIReadInJoyModel.k().mSubscribeName;
        if (paramIReadInJoyModel.k().mAccountLess == 0)
        {
          long l = a(paramIReadInJoyModel.k());
          paramSpannableStringBuilder.append(str);
          paramSpannableStringBuilder.setSpan(new UserSpan(l, "2", paramIReadInJoyModel.k()), 0, paramSpannableStringBuilder.length(), 33);
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
      if ((localIReadInJoyModel.o() != 20) && (localIReadInJoyModel.o() != 12) && (localIReadInJoyModel.o() != 86) && (localIReadInJoyModel.o() != 95))
      {
        this.a.a(paramObject);
        int i = this.c;
        if ((i != 74) && (i != 75))
        {
          this.a.setLayoutParams(c(getContext()));
        }
        else
        {
          paramObject = QuestionCardProteusItem.a(localIReadInJoyModel.k());
          if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
          {
            i = AIOUtils.b(50.0F, getContext().getResources());
            paramObject = new RelativeLayout.LayoutParams(i, i);
            paramObject.setMargins(0, 0, AIOUtils.b(12.0F, getContext().getResources()), 0);
            paramObject.addRule(15);
            i = AIOUtils.b(12.0F, getContext().getResources());
            paramObject.setMargins(i, 0, i, 0);
            paramObject.addRule(11);
            this.a.setLayoutParams(paramObject);
          }
          else
          {
            this.a.setLayoutParams(c(getContext()));
          }
        }
      }
      if (localIReadInJoyModel.k() == null) {
        return;
      }
      paramObject = new SpannableStringBuilder();
      a(localIReadInJoyModel, paramObject);
      b(localIReadInJoyModel, paramObject);
    }
  }
  
  public RelativeLayout.LayoutParams b(Context paramContext)
  {
    int i = this.c;
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
  
  public void b(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramIReadInJoyModel != null)
    {
      if (paramIReadInJoyModel.k() == null) {
        return;
      }
      int i = paramSpannableStringBuilder.length() - 2;
      if (i < 0) {
        i = 0;
      }
      Object localObject = paramIReadInJoyModel.k().mTitle;
      if ((paramIReadInJoyModel.o() != 94) && (paramIReadInJoyModel.o() != 95))
      {
        if ((paramIReadInJoyModel.o() == 74) || (paramIReadInJoyModel.o() == 75)) {
          localObject = paramIReadInJoyModel.k().mSocialFeedInfo.s.f;
        }
      }
      else {
        localObject = paramIReadInJoyModel.k().mSocialFeedInfo.E.b;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramSpannableStringBuilder.append((CharSequence)localObject);
      }
      localObject = new ForegroundColorSpan(Color.parseColor("#000000"));
      if (paramIReadInJoyModel.o() != 10) {
        paramIReadInJoyModel = (IReadInJoyModel)localObject;
      } else {
        paramIReadInJoyModel = new ForegroundColorSpan(Color.parseColor("#606060"));
      }
      paramSpannableStringBuilder.setSpan(paramIReadInJoyModel, i, paramSpannableStringBuilder.length(), 34);
      this.b.setTextColor(Color.parseColor("#FFCCCCCC"));
      this.b.setText(paramSpannableStringBuilder);
      this.b.setGravity(16);
      this.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public RelativeLayout.LayoutParams c(Context paramContext)
  {
    int i = this.c;
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
                break label155;
              }
              if (i != 95)
              {
                paramContext = null;
                break label184;
              }
            }
          }
          i = AIOUtils.b(67.0F, paramContext.getResources());
          paramContext = new RelativeLayout.LayoutParams(i, i);
          break label184;
        }
        label100:
        i = AIOUtils.b(67.0F, paramContext.getResources());
        paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(96.0F, paramContext.getResources()), i);
        break label184;
      }
      else
      {
        i = AIOUtils.b(67.0F, paramContext.getResources());
        paramContext = new RelativeLayout.LayoutParams(i, i);
        break label184;
      }
    }
    label155:
    i = AIOUtils.b(67.0F, paramContext.getResources());
    paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(96.0F, paramContext.getResources()), i);
    label184:
    if (paramContext != null) {
      paramContext.addRule(11);
    }
    return paramContext;
  }
  
  public RelativeLayout.LayoutParams d(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localLayoutParams.addRule(0, this.a.getId());
    int i = this.c;
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
  
  public void e(Context paramContext)
  {
    int i = this.c;
    if (i != 10)
    {
      if (i != 12)
      {
        if (i != 16)
        {
          if (i != 20)
          {
            if (i == 83) {
              break label98;
            }
            if (i != 86)
            {
              if (i == 132) {
                break label98;
              }
              if ((i == 74) || (i == 75) || (i == 94)) {
                break label131;
              }
              if (i == 95) {
                break label108;
              }
              break label138;
            }
          }
          setBackgroundResource(2130843946);
          this.a.getImageView().setImageResource(2130847561);
          break label138;
        }
        label98:
        setBackgroundResource(2130843946);
        break label138;
      }
      label108:
      setBackgroundResource(2130843946);
      this.a.getImageView().setImageResource(2130847561);
      break label138;
    }
    label131:
    setBackgroundResource(2130843946);
    label138:
    this.b.setTextSize(0, Utils.dp2px(16.0D));
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
    localObject = this.b;
    if (localObject != null)
    {
      if (paramInt1 > 0) {
        ((ReadInJoyYAFolderTextView)localObject).setTextSize(paramInt1);
      }
      if (paramInt2 > 0) {
        this.b.setTextColor(paramInt2);
      }
      if (paramInt3 > 0) {
        this.b.setLinkedTextColor(paramInt3);
      }
      if (paramInt4 > 0) {
        this.b.setLineSpacing(paramInt4, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView
 * JD-Core Version:    0.7.0.1
 */