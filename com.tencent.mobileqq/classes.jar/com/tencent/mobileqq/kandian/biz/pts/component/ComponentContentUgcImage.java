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
  CmpCtxt a;
  KandianUrlImageView b;
  KanDianRoundCornerTextView c;
  ImageView d;
  private View.OnClickListener e;
  private URL f;
  
  public ComponentContentUgcImage(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentUgcImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return "";
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.x;
      if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.e != null) && (paramAbsBaseArticleInfo.e.trim().length() > 0)) {
        return paramAbsBaseArticleInfo.e;
      }
    }
    return "";
  }
  
  private void c()
  {
    if ((this.a.a.k() != null) && (this.a.a.k().mSocialFeedInfo != null) && (this.a.a.k().mSocialFeedInfo.s != null))
    {
      ArrayList localArrayList = new ArrayList();
      String str1 = ((UGCPicInfo)this.a.a.k().mSocialFeedInfo.s.b.get(0)).d;
      Object localObject = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = str1;
        if (str1.contains("https")) {
          localObject = str1.replaceFirst("https", "http");
        }
      }
      localArrayList.add(localObject);
      localObject = this.a.a.k();
      if (RIJFeedsType.z((AbsBaseArticleInfo)localObject))
      {
        str1 = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.x.i;
        String str2 = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.x.c;
        if ((this.a.a.u() != null) && (this.a.a.u().a() != null)) {
          TroopNoticeJsHandler.a(this.a.a.u().a(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (AbsBaseArticleInfo)localObject, "");
        }
      }
      else if ((this.a.a.u() != null) && (this.a.a.u().a() != null))
      {
        TroopNoticeJsHandler.a(this.a.a.u().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "info is null");
    }
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private boolean d()
  {
    return (this.a.a.o() == 80) || (this.a.a.o() == 81);
  }
  
  private void e()
  {
    Object localObject = this.a.a.k();
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null))
    {
      if (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.s == null) {
        return;
      }
      localObject = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.s.j;
      if (localObject != null)
      {
        ReadInJoyUtils.a(getContext(), (String)localObject);
        RIJFrameworkReportManager.b(this.a.a.k(), this.a.a.m());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpUrl is ");
      localStringBuilder.append((String)localObject);
      QLog.d("ComponentContentUgcImage", 2, localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    this.b.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.b = ((KandianUrlImageView)paramView.findViewById(2131449030));
    this.c = ((KanDianRoundCornerTextView)paramView.findViewById(2131449031));
    this.d = ((ImageView)paramView.findViewById(2131430438));
    paramView = this.c;
    if (paramView != null) {
      paramView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.s != null))
    {
      if (paramIReadInJoyModel.mSocialFeedInfo.s.b.size() == 0) {
        return;
      }
      String str = ((UGCPicInfo)paramIReadInJoyModel.mSocialFeedInfo.s.b.get(0)).e;
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
      paramIReadInJoyModel = RIJConvertString2URL.b(paramIReadInJoyModel);
      PGCShortContentUtils.a(this.b, getContext(), this.f, paramIReadInJoyModel, new ComponentContentUgcImage.1(this, paramIReadInJoyModel));
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      b();
      a(paramObject);
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626478, this, true);
  }
  
  public void b()
  {
    if ((this.a.a.k() != null) && (this.a.a.k().mSocialFeedInfo != null) && (this.a.a.k().mSocialFeedInfo.s != null))
    {
      Object localObject1 = getResources().getDisplayMetrics();
      int j = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
      int k = AIOUtils.b(12.0F, getResources());
      int i = AIOUtils.b(4.5F, getResources());
      int m = k * 2;
      k = (j - (i * 2 + m)) / 3 * 2 + i;
      m = (j - (m + i)) / 2;
      float f1 = k;
      localObject1 = this.a.a.k().mSocialFeedInfo.s.b;
      float f2;
      if (((List)localObject1).size() > 0)
      {
        float f4 = ((UGCPicInfo)((List)localObject1).get(0)).a;
        float f3 = ((UGCPicInfo)((List)localObject1).get(0)).b;
        f1 = f4;
        f2 = f3;
        if (((UGCPicInfo)((List)localObject1).get(0)).f == 1)
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
      localObject1 = this.b.getLayoutParams();
      f1 /= f2;
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        double d1 = f1;
        if (d1 < 0.455D)
        {
          ((ViewGroup.LayoutParams)localObject1).width = m;
          ((ViewGroup.LayoutParams)localObject1).height = k;
          ((KanDianRoundCornerTextView)localObject2).setVisibility(0);
          this.c.setText(getResources().getText(2131915548));
        }
        else if ((0.455D <= d1) && (d1 <= 0.7441D))
        {
          ((ViewGroup.LayoutParams)localObject1).width = m;
          ((ViewGroup.LayoutParams)localObject1).height = k;
          ((KanDianRoundCornerTextView)localObject2).setVisibility(4);
        }
        else if ((0.7441D <= d1) && (d1 <= 1.3439D))
        {
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = k;
          this.c.setVisibility(4);
        }
        else if (d())
        {
          ((ViewGroup.LayoutParams)localObject1).width = -1;
          ((ViewGroup.LayoutParams)localObject1).height = AIOUtils.b(190.0F, getResources());
          this.c.setVisibility(4);
        }
        else if ((1.3439D <= d1) && (d1 <= 2.2D))
        {
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = m;
          this.c.setVisibility(4);
        }
        else
        {
          ((ViewGroup.LayoutParams)localObject1).width = k;
          ((ViewGroup.LayoutParams)localObject1).height = m;
          this.c.setVisibility(0);
          this.c.setText(getResources().getText(2131915548));
        }
        if (i != 0)
        {
          this.c.setVisibility(0);
          this.c.setText(2131915547);
        }
        if (RIJFeedsType.y(this.a.a.k()))
        {
          this.c.setVisibility(0);
          this.c.setText(HardCodeUtil.a(2131900474));
        }
        else if (d())
        {
          localObject2 = this.a.a.k().mSocialFeedInfo.z;
          if (localObject2 != null)
          {
            if ((!TextUtils.isEmpty(((IconWordingInfo)localObject2).f)) && (!TextUtils.isEmpty(((IconWordingInfo)localObject2).d)))
            {
              this.c.setVisibility(0);
              this.c.setText(((IconWordingInfo)localObject2).f);
              Drawable localDrawable = DrawableUtil.getDrawable(getContext(), ((IconWordingInfo)localObject2).d, null, null);
              if (localDrawable != null)
              {
                localDrawable.setBounds(0, 0, AIOUtils.b(12.0F, getResources()), AIOUtils.b(12.0F, getResources()));
                this.c.setCompoundDrawables(localDrawable, null, null, null);
              }
            }
            if (((IconWordingInfo)localObject2).g == 1)
            {
              this.d.setImageResource(2130844327);
              this.d.setVisibility(0);
            }
            else
            {
              this.d.setVisibility(8);
            }
          }
        }
        else
        {
          this.c.setCompoundDrawables(null, null, null, null);
        }
      }
      if (this.a.a.k().mChannelID == 0L)
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
      this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.b.setPadding(0, 0, 0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "info is null");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131449030) {
      return;
    }
    if (d())
    {
      e();
      return;
    }
    RIJFrameworkReportManager.b(this.a.a.k(), this.a.a.m());
    if (RIJFeedsType.y(this.a.a.k()))
    {
      localObject = a(this.a.a.k());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        RIJJumpUtils.b(getContext(), (String)localObject);
        return;
      }
    }
    c();
    Object localObject = this.e;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
  }
  
  public void setPicClickListener(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcImage
 * JD-Core Version:    0.7.0.1
 */