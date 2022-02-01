package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;

public class ComponentContentSmall
  extends RelativeLayout
  implements ComponentInheritView
{
  CmpCtxt a;
  KandianUrlImageView b;
  KanDianRoundCornerTextView c;
  private Drawable d;
  
  public ComponentContentSmall(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.b = ((KandianUrlImageView)paramView.findViewById(2131435435));
    this.c = ((KanDianRoundCornerTextView)paramView.findViewById(2131431431));
    paramView = this.c;
    if (paramView != null) {
      paramView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)paramObject;
      this.a.a(localIReadInJoyModel);
      b();
      AbsBaseArticleInfo localAbsBaseArticleInfo = localIReadInJoyModel.k();
      if (localAbsBaseArticleInfo == null) {
        return;
      }
      URL localURL = localAbsBaseArticleInfo.mSinglePicture;
      if (localIReadInJoyModel.o() == 94)
      {
        paramObject = RIJConvertString2URL.b(localAbsBaseArticleInfo.mSocialFeedInfo.E.c);
      }
      else if (localIReadInJoyModel.o() != 74)
      {
        paramObject = localURL;
        if (localIReadInJoyModel.o() != 75) {}
      }
      else
      {
        Pair localPair = QuestionCardProteusItem.a(localAbsBaseArticleInfo);
        paramObject = localURL;
        if (localPair != null) {
          paramObject = RIJConvertString2URL.b((String)localPair.second);
        }
      }
      ReadInJoyDisplayUtils.a(this.b, paramObject, getContext());
      if (this.c != null) {
        if ((localIReadInJoyModel.o() != 10) && (localIReadInJoyModel.o() != 16) && (localIReadInJoyModel.o() != 83))
        {
          if ((localIReadInJoyModel.o() != 74) && (localIReadInJoyModel.o() != 75))
          {
            if (localIReadInJoyModel.o() == 132)
            {
              if ((localAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t.b != null) && (!localAbsBaseArticleInfo.mSocialFeedInfo.t.b.isEmpty()))
              {
                paramObject = (PGCVideoInfo)localAbsBaseArticleInfo.mSocialFeedInfo.t.b.get(0);
                this.c.setVisibility(0);
                this.c.setText(VideoFeedsHelper.b(paramObject.f * 1000L));
                this.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
              }
              this.c.setVisibility(8);
              return;
            }
            this.c.setVisibility(8);
            return;
          }
          paramObject = QuestionCardProteusItem.a(localIReadInJoyModel.k());
          if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
          {
            this.c.setVisibility(8);
            return;
          }
          if ((paramObject != null) && (!((Boolean)paramObject.first).booleanValue()))
          {
            this.c.setText(HardCodeUtil.a(2131900448));
            this.c.setVisibility(0);
          }
        }
        else
        {
          this.c.setText(2131915224);
          if (this.d == null)
          {
            this.d = getContext().getResources().getDrawable(2130843787);
            paramObject = this.d;
            paramObject.setBounds(new Rect(0, 0, paramObject.getIntrinsicWidth(), this.d.getIntrinsicHeight()));
            this.c.setCompoundDrawables(this.d, null, null, null);
          }
          this.c.setVisibility(0);
        }
      }
    }
  }
  
  public View b(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626179, this, true);
  }
  
  public void b()
  {
    UtilsForComponent.a(getContext(), this.b, false);
  }
  
  public KandianUrlImageView getImageView()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */